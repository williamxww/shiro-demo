package com.bow.service;

import com.bow.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    Role createRole(Role role);

    Role updateRole(Role role);

    void deleteRole(Long roleId);

    Role findOne(Long roleId);

    List<Role> findAll();

    Set<String> findRoles(Long... roleIds);

    Set<String> findPermissions(Long[] roleIds);
}
