package com.lsx.settings.test;

import com.lsx.crm.utils.DateTimeUtil;
import com.lsx.crm.utils.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        //验证失效时间
        //失效时间
        // String expireTime ="2022-10-10 10:10:10";
         //当前系统时间
        // String currenTime = DateTimeUtil.getSysTime();
        // int count = expireTime.compareTo(currenTime);
        // System.out.println(count);

        //
        // String lockState="0";
        // if("0".equals(lockState)){
        //     System.out.println("帐号已锁定");
        // }

        //验证ip
        // String ip="192.168.1.3";
        // String alloIps="192.168.1.1,192.168.1.2";
        // if(alloIps.contains(ip)){
        //     System.out.println("有效的ip地址，允许访问系统");
        // }else {
        //     System.out.println("ip地址受限，请联系管理员");
        // }

        String pwd ="123";
        pwd= MD5Util.getMD5(pwd);
        System.out.println(pwd);
    }
}
