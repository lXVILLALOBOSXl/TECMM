//Luis Adrian Villalobos Rivera 220120379 2ISC

/**
 *
 */
public class Condicionales {

    public static boolean isAdult(int age){
        return age > 17;
    }

    public static String lifeStage(int age){
        if(age < 3){
            return "Infancy";
        }else if(age < 4){
            return "Toddlerhood";
        }else if(age < 6){
            return "Preschool years";
        }else if(age < 13){
            return "Early school years";
        }else if(age < 19){
            return "Adolescence";
        }else if(age < 41){
            return "Young adulthood";
        }else if(age < 66){
            return "Middle adulthood";
        }else{
            return "Late adulthood";
        }
    }

    public static double whoIsHighest(double number1, double number2, double number3){
        double mayor;

        if(number1 > number2){
            mayor = number1;
        }else{
            mayor = number2;
        }

        if(mayor > number3){
            return mayor;
        }else{
            return number3;
        }
    }

    public static String kindOfNumber(double number){
        if(number > 0){
            return "positive";
        }else if(number < 0){
            return "negative";
        }else{
            return "zero";
        }
    }

    public static boolean isPair(double number){
        if(number % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    public static double getSalaryIncrease(int categorie){
        switch (categorie){
            case 1:
                return 0.15;
            case 2:
                return 0.10;
            case 3:
                return 0.08;
            case 4:
                return 0.01;
            default:
                return 0;
        }
    }

    public static boolean canDoMilitaryService(int age, String nacionality, String genre){
        nacionality.toLowerCase();
        genre.toLowerCase();
        return (age > 17 && age < 25) && (nacionality.equals("mexicana")) && (genre.equals("m"));
    }

    public static double getCommision(double saleAmount){

        if(saleAmount < 1000){
            return saleAmount * 0.03;
        }else{
            return saleAmount * 0.05;
        }
    }

    public static double salaryIncrease(String categorie, double salary){
        categorie = categorie.toLowerCase();
        categorie = categorie.replaceAll(" ","");
        switch (categorie){
            case "sindicalizado":
                return salary * 1.20;
            case "deconfianza":
                return salary * 1.10;
            case "altodirectivo":
                return salary * 1.05;
            case "ejecutivo":
                return salary * 1.02;
            default:
                return salary;
        }
    }

    public static double mathFunctions(double x){
        if(x < 12){
            return (3 * x) + 36;
        }else if(x < 34){
            return Math.pow(x,2) - 10;
        }else if(x < 65){
            return x + 6;
        }else{
            return 0;
        }
    }
}
