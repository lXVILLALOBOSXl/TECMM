package com.planification;

import java.util.List;

public final class RoundRobin implements IPlanification{
    private static int quantum;

    @Override
    public void print(List<Process> processes) {

    }

    public static int getQuantum() {
        return quantum;
    }
}
