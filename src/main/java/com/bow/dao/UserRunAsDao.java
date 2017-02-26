package com.bow.dao;

import java.util.List;

public interface UserRunAsDao {

    void grantRunAs(Long fromUserId, Long toUserId);

    void revokeRunAs(Long fromUserId, Long toUserId);

    boolean exists(Long fromUserId, Long toUserId);

    List<Long> findFromUserIds(Long toUserId);

    List<Long> findToUserIds(Long fromUserId);

}
