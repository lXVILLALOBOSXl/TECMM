package com.soccer;

public class Player extends TeamMate {

    private int dorsal;
    private String demarcation;
    private boolean isPlaying;
    private boolean isTraining;

    public Player(String name, String lastName, int age, int dorsal, String demarcation) {
        super(name, lastName, age);
        this.dorsal = dorsal;
        this.demarcation = demarcation;
        this.isPlaying = false;
        this.isTraining = false;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        if(playing){
            System.out.println(this.name + " " + this.lastName + " is playing");
            this.setTraining(false);
        }
        this.isPlaying = playing;
    }

    public boolean isTraining() {
        return isTraining;
    }

    public void setTraining(boolean training) {
        if(training){
            System.out.println(this.name + " " + this.lastName + " is training");
            this.setPlaying(false);
        }
        this.isTraining = training;
    }

    @Override
    public String toString() {
        return "Player{" +
                "dorsal=" + dorsal +
                ", demarcation='" + demarcation + '\'' +
                ", isPlaying=" + isPlaying +
                ", isTraining=" + isTraining +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
