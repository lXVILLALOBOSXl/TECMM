public class Person {

    private String name;
    private Date birthDay;
    private int dni;

    public Person(String  name, Date birthDay, int dni) {
        this.name =  name;
        this.birthDay = birthDay;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", dni=" + dni +
                '}';
    }

    public String getName() {
        return name;
    }
}
