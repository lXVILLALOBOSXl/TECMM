// Luis Adrian Villalobos Rivera 220120379 2ISC

/**
 *
 */
public class Algoritmos {

    public static double triangleArea(double base, double height){
        return  ( base * height ) / 2  ;
    }

    public static double circleArea(double radio){
        return   Math.PI * Math.pow(radio, 2);
    }

    public static double gradeAverage(int grades){
        int sum = 0;
        for (int i = 1; i < (grades+1); i++){
            sum += TestAlgoritmos.getNonNegativeNumber("Grade " + i);
        }
        return sum / grades;
    }

    public static double celsiusToFarenheit(double celsius){
        return (celsius * 1.8) + 32;
    }

    public static double calculateInterest(double amount){
        return (amount * 0.018) * 12;
    }

    public static double jobPayment(double workHours, double salary, double taxes){
        return (workHours * salary) - ((workHours * salary) * (taxes* 0.01));
    }

    public static double extraHoursPayment(double workHours, double salary){
        if(workHours > 40){
            double extraHours =  (workHours - 40);
            double extraSalary = extraHours * (salary * 1.50);
            return ((workHours - extraHours) * salary) + extraSalary;
        }
        return (workHours * salary);
    }

    public static String getTime(double minutes){
        return (int)minutesToDays(minutes) + " days " + (int)minutesToHours(minutes%=1440) + " hours " + (int)(minutes%=60) + " minutes ";
    }

    private static double minutesToDays(double minutes){
        return minutes / 1440;
    }

    private static double minutesToHours(double minutes){
        return minutes / 60;
    }

    public static double metersToCm(double meters){
        return meters * 100;
    }

    public static double metersToKm(double meters){
        return meters * 0.001;
    }

    public static double metersToFt(double meters){
        return meters * 3.28084;
    }

    public static double metersToIn(double meters){
        return meters * 39.3701;
    }


    public static double ltPer100Km(double litersPurchased){
        return (litersPurchased / 100) * 100;
    }

    public static double euroPer100Km(double oilExpense){
        return (oilExpense / 100);
    }

    public static double ltPerKm(double drivenKm, double litersPurchased){
        return (litersPurchased / drivenKm) * 100;
    }

    public static double euroPerKm(double drivenKm, double oilExpense){
        return (oilExpense / drivenKm);
    }

    public static double speedCalculatorMS(double hours, double minutes, double drivenKm){
        double totalSeconds = hoursToSeconds(hours) + minutesToSeconds(minutes);
        return kmToMeters(drivenKm) / totalSeconds;
    }

    public static double speedCalculatorKH(double hours, double minutes, double drivenKm){
        double totalHours = hours + minutesToHours(minutes);
        return drivenKm / totalHours;
    }

    private static double minutesToSeconds(double minutes){
        return  minutes * 60;
    }

    private static double hoursToSeconds(double hours){
        return  hours * 3600;
    }

    private static double kmToMeters(double km){
        return  km * 1000;
    }
}
