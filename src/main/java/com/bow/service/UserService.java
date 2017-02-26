package com.bow.service;

import com.bow.entity.User;

import java.util.List;
import java.util.Set;

/**
 * UserService
 * 
 * @author ViVi
 * @date 2015年7月2日 下午8:52:33
 */

public interface UserService {

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    void changePassword(Long userId, String newPassword);

    User findOne(Long userId);

    List<User> findAll();

    User findByUsername(String username);

//    User findByUserId(Long userId);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
