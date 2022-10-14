public class Student extends Person {

    private double totalPoints;
    private int classesNumber;

    public Student(String name, Date birthDay, int dni) {
        super(name, birthDay, dni);
        this.totalPoints = 0;
        this.classesNumber = 0;
    }

    public Student(String name, Date birthDay, int dni, double totalPoints, int classesNumber) {
        super(name, birthDay, dni);
        this.totalPoints = totalPoints;
        this.classesNumber = classesNumber;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setClassesNumber(int classesNumber) {
        this.classesNumber = classesNumber;
    }

    public void addNote(double points){
        this.totalPoints += points;
        this.classesNumber++;
    }

    private Double getAverage() {
        return totalPoints / classesNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " Student{" +
                "note=" + totalPoints +
                ", classesNumber=" + classesNumber +
                ", average=" + this.getAverage() +
                '}';
    }


}
