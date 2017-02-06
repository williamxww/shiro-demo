/**  
 * @FileName: PermissionService.java 
 * @Package com.bow.service.permission 
 * all rights reserved by Hill team
 * @version v1.3  
 */
package com.bow.service;

import com.bow.entity.Permission;
import com.bow.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @author ViVi
 * @date 2015年7月2日 下午8:51:24
 */

public interface PermissionService {

    List<Permission> getPermissions(User user);

    int deletePermission(Permission permission);

    Permission savePermission(Permission permission);

}
