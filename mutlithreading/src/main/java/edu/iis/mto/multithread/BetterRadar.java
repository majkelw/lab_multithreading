package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar {

    private final ExecutorService executor;
    private final int rocketsCount;
    private final PatriotBattery battery;

    public BetterRadar(PatriotBattery battery, int rocketsCount, ExecutorService executor) {
        this.executor = executor;
        this.rocketsCount = rocketsCount;
        this.battery = battery;
    }

    public void notice(Scud enemyMissile) {
        executor.execute(() -> {
            for (int i = 0; i < rocketsCount; ++i)
                this.battery.launchPatriot(enemyMissile);
        });
    }
}