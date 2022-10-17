package com.soccer;

public class Coach extends TeamMate {

    private String idFederacion;
    private boolean isLeaderingMatch;
    private boolean isLeaderingTraining;

    public Coach(String name, String lastName, int age, String idFederacion) {
        super(name, lastName, age);
        this.idFederacion = idFederacion;
        this.isLeaderingMatch = false;
        this.isLeaderingTraining = false;
    }

    public boolean isLeaderingMatch() {
        return isLeaderingMatch;
    }

    //A team mate can't be doing both things as the same time
    public void setLeaderingMatch(boolean leaderingMatch) {
        if(leaderingMatch){
            System.out.println(this.name + " " + this.lastName + " is leadering a match");
            setLeaderingTraining(false);
        }
        this.isLeaderingMatch = leaderingMatch;
    }

    public boolean isLeaderingTraining() {
        return isLeaderingTraining;
    }

    //A team mate can't be doing both things as the same time
    public void setLeaderingTraining(boolean leaderingTraining) {
        if(leaderingTraining){
            System.out.println(this.name + " " + this.lastName + " is leadering a training");
            setLeaderingMatch(false);
        }
        this.isLeaderingTraining = leaderingTraining;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "idFederacion='" + idFederacion + '\'' +
                ", isLeaderingMatch=" + isLeaderingMatch +
                ", isLeaderingTraining=" + isLeaderingTraining +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
