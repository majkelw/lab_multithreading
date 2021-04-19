package edu.iis.mto.multithread;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.Executor;


@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(30)
    void launchPatriotOnceWhenNoticesAScudMissile() {
        Executor executor = Runnable::run;
        final int rocketCount = 1;
        BetterRadar radar = new BetterRadar(batteryMock, rocketCount, executor);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissile);
    }

    @RepeatedTest(30)
    void launchPatriotTenTimesWhenNoticesAScudMissile() {
        Executor executor = Runnable::run;
        final int rocketCount = 10;
        BetterRadar radar = new BetterRadar(batteryMock, rocketCount, executor);
        Scud enemyMissile = new Scud();
        radar.notice(enemyMissile);
        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissile);
    }

}
