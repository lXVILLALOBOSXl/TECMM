public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(Date date){
        if(date.month > 12 || date.month < 1 || date.day < 1 || date.day > 31 || date.year < 1900 || date.year > 2022){
            System.out.println("Invalid date, try again");
            return false;
        }else if(date.month == 2 && date.day > 29){
            System.out.println("Invalid date, try again");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
