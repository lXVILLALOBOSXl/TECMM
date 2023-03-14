package com.planification;

public class Process {
    private int id;
    private int time;
    private int priority;

    public Process(int id, int time, int priority) {
        this.id = id;
        this.time = time;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", time=" + time +
                ", priority=" + priority +
                '}';
    }
}
