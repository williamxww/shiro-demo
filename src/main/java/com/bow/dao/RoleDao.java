package com.bow.dao;

import com.bow.entity.Role;

import java.util.List;

public interface RoleDao {

    Role createRole(Role role);

    Role updateRole(Role role);

    void deleteRole(Long roleId);

    Role findOne(Long roleId);

    List<Role> findAll();
}
