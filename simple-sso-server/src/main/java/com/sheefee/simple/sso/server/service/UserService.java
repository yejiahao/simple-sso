package com.sheefee.simple.sso.server.service;

import com.sheefee.simple.sso.client.domain.User;

public interface UserService {
    /**
     * 根据username和password查找数据库中的用户并返回
     *
     * @param user
     * @return User
     * @author sheefee
     * @date 2017年9月12日 下午2:24:42
     */
    User find(User user);
}