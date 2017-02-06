package com.bow.service;

import com.bow.entity.Resource;

import java.util.List;
import java.util.Set;

public interface ResourceService {

    Resource createResource(Resource resource);

    Resource updateResource(Resource resource);

    void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);

    List<Resource> findAll();

    Set<String> findPermissions(Set<Long> resourceIds);

    List<Resource> findMenus(Set<String> permissions);
}
