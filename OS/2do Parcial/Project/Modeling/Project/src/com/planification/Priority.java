package com.planification;

import java.util.List;

public final class Priority implements IPlanification{
    private static int quantum;

    @Override
    public void print(List<Process> processes) {
        quantum = 21;
    }

    public static int getQuantum() {
        return quantum;
    }
}
