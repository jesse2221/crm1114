package com.lsx.workbench.test;

import com.lsx.crm.utils.ServiceFactory;
import com.lsx.crm.utils.UUIDUtil;
import com.lsx.crm.workbench.domain.Activity;
import com.lsx.crm.workbench.service.ActivityService;
import com.lsx.crm.workbench.service.impl.ActivityServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class ActivityTest {
    @Test
    public void testInsert(){
        Activity a = new Activity();
        a.setId(UUIDUtil.getUUID());
        a.setName("宣传会");
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        boolean flag = as.save(a);
        Assert.assertEquals(flag,true);

    }
}
