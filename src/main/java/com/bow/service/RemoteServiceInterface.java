package com.bow.service;

import java.io.Serializable;

import com.bow.entity.PermissionContext;
import org.apache.shiro.session.Session;

public interface RemoteServiceInterface {

    Session getSession(String appKey, Serializable sessionId);

    Serializable createSession(Session session);

    void updateSession(String appKey, Session session);

    void deleteSession(String appKey, Session session);

    PermissionContext getPermissions(String appKey, String username);
}
