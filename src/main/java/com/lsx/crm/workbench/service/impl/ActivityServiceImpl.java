package com.lsx.crm.workbench.service.impl;

import com.lsx.crm.settings.dao.UserDao;
import com.lsx.crm.settings.domain.User;
import com.lsx.crm.utils.SqlSessionUtil;
import com.lsx.crm.vo.paginationVO;
import com.lsx.crm.workbench.dao.ActivityDao;
import com.lsx.crm.workbench.dao.ActivityRemarkDao;
import com.lsx.crm.workbench.domain.Activity;
import com.lsx.crm.workbench.domain.ActivityRemark;
import com.lsx.crm.workbench.service.ActivityService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
    private ActivityRemarkDao activityRemarkDao = SqlSessionUtil.getSqlSession().getMapper(ActivityRemarkDao.class);
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    public boolean save(Activity a) {

        boolean flag =true;

        int count =activityDao.save(a);
        if(count!=1){
            flag=false;
        }

        return flag;
    }

    public paginationVO<Activity> pageList(Map<String, Object> map) {
        //取得total
        int total = activityDao.getTotalByCondition(map);
        //取得datalist
        List<Activity> dataList = activityDao.getActivityListByCondition(map);
        //将total和dataList封装到vo
        paginationVO<Activity> vo = new paginationVO<Activity>();
        vo.setTotal(total);
        vo.setDataList(dataList);

        //将vo返回
        return vo;
    }

    public boolean delete(String[] ids) {

        boolean flag  = true;

        //查询出需要删除的备注数量
        int count1 = activityRemarkDao.getCountByAids(ids);

        //删除备注，返回受到影响的条数（实际删除的数量）
        int count2 = activityRemarkDao.deleteByAids(ids);
        if (count1!=count2){
            flag=false;
        }

        //删除市场活动
        int count3=activityDao.delete(ids);
        if (count3!=ids.length){
            flag=false;
        }

        return flag;
    }

    public Map<String, Object> getUserListAndActivity(String id) {
        //取uList
        List<User> uList = userDao.getUserList();
        //取a
        Activity a  = activityDao.getById(id);
        //将uList和a打包到map中
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("uList",uList);
        map.put("a",a);
        //返回map就可以了

        return map;
    }

    public boolean update(Activity a) {
        boolean flag =true;

        int count =activityDao.update(a);
        if(count!=1){
            flag=false;
        }

        return flag;
    }

    public Activity detail(String id) {
        Activity a=activityDao.detail(id);
        return a;
    }

    public List<ActivityRemark> getRemarkListByAid(String activityId) {
        List<ActivityRemark> arList=activityRemarkDao.getRemarkListByAid(activityId);
        return arList;
    }

    public boolean deleteRemark(String id) {
        boolean flag =true;

        int count = activityRemarkDao.deleteById(id);

        if(count!=1){
            flag = false;
        }

        return flag;
    }

    public boolean saveRemark(ActivityRemark ar) {
        boolean flag = true;

        int count=activityRemarkDao.saveRemark(ar);

        if (count != 1) {
            flag = false;
        }

        return flag;
    }

    public boolean updateRemark(ActivityRemark ar) {


        boolean flag = true;

        int count=activityRemarkDao.updateRemark(ar);

        if (count != 1) {
            flag = false;
        }

        return flag;
    }
}


















