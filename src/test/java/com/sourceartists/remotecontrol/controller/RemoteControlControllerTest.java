package com.sourceartists.remotecontrol.controller;

import static org.mockito.Mockito.*;

import com.sourceartists.remotecontrol.driver.RobotCleanerDriver;
import com.sourceartists.remotecontrol.service.AuditService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RemoteControlControllerTest {

    @Mock
    private RobotCleanerDriver robotCleanerDriverMock;

    @Mock
    private AuditService auditServiceMock;

    @InjectMocks
    private RemoteControlController remoteControlControllerSUT;

    @BeforeEach
    private void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldPerformCleaningWithoutInterruptions() throws Exception{
        // Arrange
        when(robotCleanerDriverMock.allRoomsAccessed()).thenReturn(true);
        when(robotCleanerDriverMock.isFull()).thenReturn(false);

        // Act
        remoteControlControllerSUT.triggerGeneralCleaning();

        // Assert
        verify(robotCleanerDriverMock).loadGeneralProgram();
        verify(robotCleanerDriverMock).startCleaning();
        verify(robotCleanerDriverMock).returnToDockingStation();
        verify(robotCleanerDriverMock).allRoomsAccessed();
        verify(robotCleanerDriverMock).isFull();

        verifyNoMoreInteractions(robotCleanerDriverMock, auditServiceMock);

    }
}