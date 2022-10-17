package com.soccer;

public class Masseuse extends TeamMate {

    private String titulation;
    private int experienceYears;
    private boolean isGivingMassage;

    public Masseuse(String name, String lastName, int age, String titulation, int experienceYears) {
        super(name, lastName, age);
        this.titulation = titulation;
        this.experienceYears = experienceYears;
        this.isGivingMassage = false;
    }

    public boolean isGivingMassage() {
        return isGivingMassage;
    }

    //A team mate can't be doing both things as the same time
    public void setGivingMassage(boolean givingMassage) {
        if(givingMassage){
            System.out.println(this.name + " " + this.lastName + " is giving a massage");
            this.isGivingMassage = true;
        }else{
            System.out.println(this.name + " " + this.lastName + " isn't giving a massage");
        }
        this.isGivingMassage = givingMassage;
    }

    @Override
    public String toString() {
        return "Masseuse{" +
                "titulation='" + titulation + '\'' +
                ", experienceYears=" + experienceYears +
                ", isGivingMassage=" + isGivingMassage +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
