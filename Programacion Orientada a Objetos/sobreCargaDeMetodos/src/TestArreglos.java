public class TestArreglos {
    /**
     * Runs main program
     * @param args
     */
    public static void main(String[] args) {
        do {
            menu(); //Print menu
        }while (operations(Util.getNumber("option"))); //If option isn't exit*/
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
            case 1: //sums vector contents
                //ask and print the requested function
                array = new Arreglos(Util.getNumber("size"));
                System.out.println("Sum of " + array +  " = " + Arreglos.sum(array.getArray()));
                return repeat;
            case 2: //sum matrix contents
                array = new Arreglos(Util.getNumber("rows"),Util.getNumber("columns"));
                System.out.println("Sum of: \n" + array +  " = " + Arreglos.sum(array.getArray()) );
                return repeat;
            case 3: //sums arrays
                rows = Util.getNumber("rows");
                columns = Util.getNumber("columns");
                array = new Arreglos(rows,columns);
                array2 = new Arreglos(rows,columns);
                System.out.println("Sum of: \n" + array + "\n + \n" +  array2 + "\n =");
                Arreglos.print(Arreglos.sum(array.getArray(),array2.getArray()));
                return repeat;
            case 4: //subs arrays
                rows = Util.getNumber("rows");
                columns = Util.getNumber("columns");
                array = new Arreglos(rows,columns);
                array2 = new Arreglos(rows,columns);
                System.out.println("Sum of: \n" + array + "\n - \n" +  array2 + "\n =");
                Arreglos.print(Arreglos.sub(array.getArray(),array2.getArray()));
                return repeat;
            case 5: //sums a specific matrix column
                array = new Arreglos(Util.getNumber("rows"),Util.getNumber("columns"));
                int column = Util.getNumber("column");
                //The specific column has to exist
                while (column < 0 || column > (array.getArray()[0].length-1)){
                    System.out.println("Error, column doesn't exist");
                    column = Util.getNumber("column");
                }
                System.out.println("Column sum of: \n" + array + " = " + Arreglos.sum(column,array.getArray()));
                return repeat;
            case 6:
                //sums a specific matrix row
                array = new Arreglos(Util.getNumber("rows"),Util.getNumber("columns"));
                int row = Util.getNumber("row");
                //The specific row has to exist
                while (row < 0 || row > (array.getArray().length-1)){
                    System.out.println("Error, row doesn't exist");
                    row = Util.getNumber("row");
                }
                System.out.println("Row sum of: \n" + array + " = " + Arreglos.sum(array.getArray(),row));
                return repeat;
            case 0: //Exit
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getNumber("option")); //requests a correct option again
                return repeat;
        }
    }

}
