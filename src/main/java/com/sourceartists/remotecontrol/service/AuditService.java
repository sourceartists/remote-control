package com.sourceartists.remotecontrol.service;

import com.sourceartists.remotecontrol.model.RobotCleanerStatistics;

public interface AuditService {
    void reportNoAllRoomsCleaned(RobotCleanerStatistics lastCleanStatistics);
}
