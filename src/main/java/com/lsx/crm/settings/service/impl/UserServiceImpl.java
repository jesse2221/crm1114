package com.lsx.crm.settings.service.impl;

import com.lsx.crm.settings.dao.UserDao;
import com.lsx.crm.settings.service.UserService;
import com.lsx.crm.utils.SqlSessionUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
}
