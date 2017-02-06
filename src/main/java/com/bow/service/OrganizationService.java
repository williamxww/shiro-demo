package com.bow.service;

import com.bow.entity.Organization;

import java.util.List;

public interface OrganizationService {

    Organization createOrganization(Organization organization);

    Organization updateOrganization(Organization organization);

    void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);

    List<Organization> findAll();

    Object findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
