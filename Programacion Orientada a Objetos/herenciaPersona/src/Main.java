import java.util.ArrayList;

public class Main {

    private static ArrayList<Person> people = new ArrayList<>();

    /**
     * Runs main program
     * @param args
     */
    public static void main(String[] args) {
        do {
            menu(); //Print menu
        }while (operations(Util.getInt("option"))); //If option isn't exist*/
    }

    /**
     * Prints all kind of main menu options
     */
    private static void menu(){
        System.out.println("\nWelcome to Heritage program! \n" +
                "1) Add employee by comission\n" +
                "2) Add employee\n" +
                "3) Add student\n" +
                "4) Find\n" +
                "0) Exit\n");
    }

    /**
     * Asks and prints for the requested function
     * @param option function that the user want to use
     * @return if the menu will be printed again
     */
    private static boolean operations(int option){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1: //add comission employee
                //ask and print the requested function
                people.add(setEmployeeByComission());
                return repeat;
            case 2: //add employee
                people.add(setEmployee());
                return repeat;
            case 3: //add student
                people.add(setStudent());
                return repeat;
            case 4: //find
                find(Util.getString("name"));
                return repeat;
            case 0: //Exit
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getInt("option")); //requests a correct option again
                return repeat;
        }
    }

    /**
     * create an Employee Comission Instance and request
     * its respect info
     * @return new Employee Comission
     */
    private static Person setEmployeeByComission(){
        return new EmployeeComission(Util.getString("Name"),setBirthDay(),Util.getInt("dni"),Util.getDouble("payment"),Util.getDouble("comission percentaje"),Util.getDouble("money sales"));
    }

    /**
     * create an Employee Instance and request
     * its respect info
     * @return new Employee
     */
    private static Person setEmployee(){
        return new Employee(Util.getString("Name"),setBirthDay(),Util.getInt("dni"),Util.getDouble("payment"));
    }

    /**
     * create an Student Instance and request
     * its respect info
     * @return new Student
     */
    private static Person setStudent(){
        return new Student(Util.getString("Name"),setBirthDay(),Util.getInt("dni"),Util.getDouble("points"),Util.getInt("classes number"));
    }

    private static void find(String nameToFind){
        //Save name person is finding
        String name;
        //Modify String to avoid mistakes like Mayus, Minus or Spaces
        nameToFind = nameToFind.replace(" ","");
        nameToFind = nameToFind.toLowerCase();
        for (Person person : people) {
            name = person.getName();
            //Modify String to avoid mistakes like Mayus, Minus or Spaces
            name = name.replace(" ","");
            name = name.toLowerCase();
            //If finds a match
            if(nameToFind.equals(name)){
                //Guess kind of Person
                if(person instanceof EmployeeComission){
                    do {
                        employeeComissionMenu();  //Print employee menu
                    }while (employeeComissionOperations(Util.getInt("option"),(EmployeeComission) person)); //If option isn't exist*/
                    return;
                }else if(person instanceof Employee){
                    //Print employee info
                    System.out.println(person);
                    return;
                }else{
                    do {
                        studentMenu(); //Print student menu
                    }while (studentOperations(Util.getInt("option"),(Student) person)); //If option isn't exist*/
                    return;
                }
            }
        }
        //If not find a match
        System.out.println("Doesn't exist");
    }



    private static void employeeComissionMenu(){
        System.out.println("\nSub menu\n" +
                "1) Add sale\n" +
                "2) Print data\n" +
                "0) Exit\n");
    }

    private static boolean employeeComissionOperations(int option, EmployeeComission employee){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1:
                //add sale
                employee.addSale(Util.getDouble("amount"));
                return repeat;
            case 2: //print info
                System.out.println(employee);
                return repeat;
            case 0: //Exit
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getInt("option")); //requests a correct option again
                return repeat;
        }
    }


    private static void studentMenu(){
        System.out.println("\nSub menu\n" +
                "1) Add note\n" +
                "2) Print data\n" +
                "0) Exit\n");
    }

    private static boolean studentOperations(int option, Student student){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1:
                //add note
                student.addNote(Util.getDouble("points"));
                return repeat;
            case 2: //print info
                System.out.println(student);
                return repeat;
            case 0: //Exit
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getInt("option")); //requests a correct option again
                return repeat;
        }
    }

    /**
     *create an Date Instance and request
     *its respect info verifying if it's a valid date
     * @return new Date
     */
    private static Date setBirthDay(){
        Date date;
        do{
            date = new Date(Util.getInt("day"),Util.getInt("month"),Util.getInt("year"));
        }while (!Date.isValidDate(date));
        return date;
    }



}
