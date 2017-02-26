package com.bow.service.impl;

import java.util.List;

import com.bow.dao.UserRunAsDao;
import com.bow.service.UserRunAsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRunAsServiceImpl implements UserRunAsService {
    @Autowired
    private UserRunAsDao userRunAsDao;

    @Override
    public void grantRunAs(Long fromUserId, Long toUserId) {
        userRunAsDao.grantRunAs(fromUserId, toUserId);
    }

    @Override
    public void revokeRunAs(Long fromUserId, Long toUserId) {
        userRunAsDao.revokeRunAs(fromUserId, toUserId);
    }

    @Override
    public boolean exists(Long fromUserId, Long toUserId) {
        return userRunAsDao.exists(fromUserId, toUserId);
    }

    @Override
    public List<Long> findFromUserIds(Long toUserId) {
        return userRunAsDao.findFromUserIds(toUserId);
    }

    @Override
    public List<Long> findToUserIds(Long fromUserId) {
        return userRunAsDao.findToUserIds(fromUserId);
    }
}
