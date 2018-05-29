package com.mr.service;

import com.mr.model.User;

import java.util.List;

/**
 * Created by Administrator on 2018/5/25.
 */
public interface UserService {
    User getUserByUserName(String username);

    // 通过用户id查询角色
    List<String> selectRolesByUserId(Integer id);


    List<String> selectPermissionIdByUserId(Integer id);
}
