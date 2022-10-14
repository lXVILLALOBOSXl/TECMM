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
        }while (operations(Util.getInt("option"))); //If option isn't exit*/
    }

    /**
     * Prints all kind of options
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
            case 1: //sums vector contents
                //ask and print the requested function
                people.add(setEmployeeByComission());
                return repeat;
            case 2: //sum matrix contents
                people.add(setEmployee());
                return repeat;
            case 3: //sums arrays
                people.add(setStudent());
                return repeat;
            case 4: //subs arrays
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

    private static Person setEmployeeByComission(){
        return new EmployeeComission(Util.getString("Name"),setBirthDay(),Util.getInt("dni"),Util.getDouble("payment"),Util.getDouble("comission percentaje"),Util.getDouble("money sales"));
    }

    private static Person setEmployee(){
        return new Employee(Util.getString("Name"),setBirthDay(),Util.getInt("dni"),Util.getDouble("payment"));
    }

    private static Person setStudent(){
        return new Student(Util.getString("Name"),setBirthDay(),Util.getInt("dni"),Util.getDouble("points"),Util.getInt("classes number"));
    }

    private static void find(String nameToFind){
        String name;
        nameToFind = nameToFind.replace(" ","");
        nameToFind = nameToFind.toLowerCase();
        for (Person person : people) {
            name = person.getName();
            name = name.replace(" ","");
            name = name.toLowerCase();
            if(nameToFind.equals(name)){
                if(person instanceof EmployeeComission){
                    do {
                        employeeComissionMenu();
                    }while (employeeComissionOperations(Util.getInt("option"),(EmployeeComission) person));
                    return;
                }else if(person instanceof Employee){
                    System.out.println(person);
                    return;
                }else{
                    do {
                        studentMenu(); //Print menu
                    }while (studentOperations(Util.getInt("option"),(Student) person));
                    return;
                }
            }
        }
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
            case 1: //sums vector contents
                //ask and print the requested function
                employee.addSale(Util.getDouble("amount"));
                return repeat;
            case 2: //sum matrix contents
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
            case 1: //sums vector contents
                //ask and print the requested function
                student.addNote(Util.getDouble("points"));
                return repeat;
            case 2: //sum matrix contents
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


    private static Date setBirthDay(){
        Date date;
        do{
            date = new Date(Util.getInt("day"),Util.getInt("month"),Util.getInt("year"));
        }while (!Date.validDate(date));
        return date;
    }



}
