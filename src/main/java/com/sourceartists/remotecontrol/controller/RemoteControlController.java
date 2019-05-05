package com.sourceartists.remotecontrol.controller;

import com.sourceartists.remotecontrol.driver.*;
import com.sourceartists.remotecontrol.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteControlController {

    @Autowired
    private RobotCleanerDriver robotCleanerDriver;
    @Autowired
    private HeatingDriver heatingDriver;
    @Autowired
    private LightningDriver lightningDriver;
    @Autowired
    private MovementDriver movementDriver;
    @Autowired
    private SecurityDriver securityDriver;
    @Autowired
    private AuditService auditService;

    public void triggerGeneralCleaning(){
        robotCleanerDriver.loadGeneralProgram();
        robotCleanerDriver.startCleaning();

        if(robotCleanerDriver.isFull()){
            robotCleanerDriver.emptyBin();
        }
        if(!robotCleanerDriver.allRoomsAccessed()){
            auditService.reportNoAllRoomsCleaned(
                    robotCleanerDriver.getLastCleanStatistics());
        }

        robotCleanerDriver.returnToDockingStation();
    }
}
