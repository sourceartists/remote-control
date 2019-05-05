package com.sourceartists.remotecontrol.service.impl;

import com.sourceartists.remotecontrol.model.RobotCleanerStatistics;
import com.sourceartists.remotecontrol.service.AuditService;
import org.springframework.stereotype.Service;

@Service
public class BasicAuditService implements AuditService {
    @Override
    public void reportNoAllRoomsCleaned(RobotCleanerStatistics lastCleanStatistics) {

    }
}
