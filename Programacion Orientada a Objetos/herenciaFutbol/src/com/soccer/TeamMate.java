package com.soccer;

public class TeamMate {
    private static int teamMatenumbers = 0;
    protected int id;
    protected String name;
    protected String lastName;
    protected int age;

    public TeamMate(String name, String lastName, int age) {
        TeamMate.teamMatenumbers++;
        this.id = teamMatenumbers;
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
