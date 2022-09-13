import java.util.Scanner;

public class TestArreglos {
    /**
     * Runs main program
     * @param args
     */
    public static void main(String[] args) {
        do {
            menu(); //Print menu
        }while (operations((int) getNumber("option"))); //If option isn't exit*/
    }

    /**
     * Prints all kind of options
     */
    private static void menu(){
        System.out.println("\nWelcome to Array program! \n" +
                "1) Sum vector\n" +
                "2) Sum matrix\n" +
                "3) Sum arrays\n" +
                "4) Subtract arrays\n" +
                "5) Sum column\n" +
                "6) Sum row\n" +
                "0) Exit\n");
    }

    /**
     * Asks and prints for the requested function
     * @param option function that the user want to use
     * @return if the menu will be printed again
     */
    private static boolean operations(int option){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again
        Arreglos array, array2;
        int rows, columns;

        switch (option){
            case 1: //
                //ask and print the requested function
                array = new Arreglos(getNumber("size"));
                fillArray(array);
                System.out.println("Sum of " + array.print() +  " = " + array.sum() );
                return repeat;
            case 2: //
                array = new Arreglos(getNumber("rows"), getNumber("columns"));
                fillArray(array);
                System.out.println("Sum of: \n" + array.print() +  " = " + array.sum() );
                return repeat;
            case 3: //
                rows = getNumber("rows");
                columns = getNumber("columns");
                array = new Arreglos(rows,columns);
                array2 = new Arreglos(rows,columns);
                fillArray(array);
                fillArray(array2);
                System.out.println("Sum of: \n" + array.print() + "\n + \n" +  array2.print() + "\n = \n" + Arreglos.sum(array, array2).print());
                return repeat;
            case 4: //
                rows = getNumber("rows");
                columns = getNumber("columns");
                array = new Arreglos(rows,columns);
                array2 = new Arreglos(rows,columns);
                fillArray(array);
                fillArray(array2);
                System.out.println("Sub of: \n" + array.print() + "\n - \n" +  array2.print() + "\n =  \n" + Arreglos.sub(array, array2).print());
                return repeat;
            case 5:
                array = new Arreglos(getNumber("rows"), getNumber("columns"));
                fillArray(array);
                int column = getNumber("column");
                while ((column > array.columns || column < 0)) {
                    System.out.println("Incorrect column");
                    column = getNumber("column");
                }
                System.out.println("Column sum of: \n" + array.print() + " = " + array.sumY(column));
                return repeat;
            case 6:
                array = new Arreglos(getNumber("rows"), getNumber("columns"));
                fillArray(array);
                int row = getNumber("row");
                while ((row > array.rows || row < 0)) {
                    System.out.println("Incorrect row");
                    row = getNumber("row");
                }
                System.out.println("Column row of: \n" + array.print() + " = " + array.sumX(row));
                return repeat;
            case 0: //Exit
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations((int) getNumber("option")); //requests a correct option again
                return repeat;
        }
    }

    /**
     * Asks for the inputs and analyzes if is a correct input
     * @param message Kind of input, for example: number 1, number 2, option
     * @return recorded entry
     */
    public static int getNumber(String message){
        Scanner scanner = new Scanner(System.in);
        String input;
        int number = 0;
        boolean incorrectInput;

        do {
            incorrectInput = false;
            System.out.printf("Type a correct " + message + ": ");
            input = scanner.nextLine();
            try { //If the input recorded isn't a int
                number = Integer.parseInt(input);
            } catch (Exception ex) { //Warn the user that it input isn't correct input
                System.out.println("Incorrect input, please try again. ");
                incorrectInput = true;
            }
        }while (incorrectInput); //If the input isn't correct, input again

        return number;
    }

    public static void fillArray(Arreglos array){
        if(array.rows > 1){
            for (int y = 0; y < array.columns; y++){
                for (int x = 0;  x < array.rows; x++) {
                    array.insert(x, y, getNumber("Position [" + x + "][" + y + "] "));
                }
            }
            System.out.println("----------------------------");
            return;
        }
        for (int i = 0; i < array.columns; i++){
            array.insert(i, getNumber("Position [" + i + "]"));
        }
        System.out.println("--------------------------");
    }
}
