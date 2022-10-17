package com.soccer;

public class TeamMate {
    private static int teamMateNumbers = 0; //Provides ID into the team
    protected int id;
    protected String name;
    protected String lastName;
    protected int age;

    public TeamMate(String name, String lastName, int age) {
        //When a new instance is created we have to change the id, because you can´´ have 2 similar ids
        TeamMate.teamMateNumbers++;
        this.id = teamMateNumbers;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "TeamMate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
