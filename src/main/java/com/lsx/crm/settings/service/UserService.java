package com.lsx.crm.settings.service;

import com.lsx.crm.exception.LoginException;
import com.lsx.crm.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
