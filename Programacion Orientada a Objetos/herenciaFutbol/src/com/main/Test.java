package com.main;

import com.soccer.Coach;
import com.soccer.Masseuse;
import com.soccer.Player;
import com.soccer.TeamMate;
import com.util.Util;

import java.util.ArrayList;

public class Test {
    private static ArrayList<TeamMate> team = new ArrayList<>();
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
        System.out.println("\nWelcome to Soccer program! \n" +
                "1) Add player\n" +
                "2) Add trainer\n" +
                "3) Add Masseuse\n" +
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
            case 1: //add player
                //ask and print the requested function
                team.add(setPlayer());
                return repeat;
            case 2: //add trainer
                team.add(setTrainer());
                return repeat;
            case 3: //add masseuse
                team.add(setMasseuse());
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
     * create a Player Instance and request
     * its respect info
     * @return new Employee Comission
     */
    private static TeamMate setPlayer(){
        return new Player(Util.getString("name"),Util.getString("last name"),Util.getInt("age"),Util.getInt("dorsal"),Util.getString("demarcation"));
    }

    /**
     * create a Trainer Instance and request
     * its respect info
     * @return new Employee
     */
    private static TeamMate setTrainer(){
        return new Coach(Util.getString("name"),Util.getString("last name"),Util.getInt("age"),Util.getString("federation"));
    }

    /**
     * create a Masseuse Instance and request
     * its respect info
     * @return new Student
     */
    private static TeamMate setMasseuse(){
        return new Masseuse(Util.getString("name"),Util.getString("last name"),Util.getInt("age"),Util.getString("titulation"),Util.getInt("experience years"));
    }

    private static void find(String nameToFind){
        //Save name person is finding
        String name;
        //Modify String to avoid mistakes like Mayus, Minus or Spaces
        nameToFind = nameToFind.replace(" ","");
        nameToFind = nameToFind.toLowerCase();
        for (TeamMate teamMate : team) {
            name = teamMate.getName();
            name += teamMate.getLastName();
            //Modify String to avoid mistakes like Mayus, Minus or Spaces
            name = name.replace(" ","");
            name = name.toLowerCase();
            //If finds a match
            if(nameToFind.equals(name)){
                //Guess kind of Team mate
                if(teamMate instanceof Player){
                    do {
                        playerMenu();  //Print player menu
                    }while (playerOperations(Util.getInt("option"),(Player) teamMate)); //If option isn't exist*/
                    return;
                }else if(teamMate instanceof Coach){
                    //Print employee info
                    do {
                        coachMenu();  //Print coach menu
                    }while (coachOperations(Util.getInt("option"),(Coach) teamMate)); //If option isn't exist*/
                    return;
                }else{
                    do {
                        masseuseMenu();  //Print masseuse menu
                    }while (masseuseOperations(Util.getInt("option"),(Masseuse) teamMate)); //If option isn't exist*/
                    return;
                }
            }
        }
        //If not find a match
        System.out.println("Doesn't exist");
    }



    private static void playerMenu(){
        System.out.println("\nSub menu\n" +
                "1) play match\n" +
                "2) training\n" +
                "3) info\n" +
                "0) Exit\n");
    }

    private static boolean playerOperations(int option, Player player){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1:
                //set if it's playing a match
                player.setPlaying(true);
                return repeat;
            case 2: //set if it's training
                player.setTraining(true);
                return repeat;
            case 3: //print info
                System.out.println(player);
                return repeat;
            case 0: //Exit
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getInt("option")); //requests a correct option again
                return repeat;
        }
    }


    private static void coachMenu(){
        System.out.println("\nSub menu\n" +
                "1) leadering match\n" +
                "2) leadering train\n" +
                "3) info\n" +
                "4) travel\n" +
                "5) concentration\n" +
                "0) Exit\n");
    }

    private static boolean coachOperations(int option, Coach coach){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1:
                //set if it's leadering a match
                coach.setLeaderingMatch(true);
                return repeat;
            case 2: //set if it's leadering a training
                coach.setLeaderingTraining(true);
                return repeat;
            case 3: //print info
                System.out.println(coach);
                return repeat;
            case 4: //set if the team is traveling
                travel();
                return repeat;
            case 5: //set if the team is in concentration
                concentration();
                return repeat;
            case 0: //Exit
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getInt("option")); //requests a correct option again
                return repeat;
        }
    }

    private static void masseuseMenu(){
        System.out.println("\nSub menu\n" +
                "1) givin massage\n" +
                "2) info\n" +
                "0) Exit\n");
    }

    private static boolean masseuseOperations(int option, Masseuse masseuse){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1:
                //set if is givina massage
                masseuse.setGivingMassage(true);
                return repeat;
            case 2: //print info
                System.out.println(masseuse);
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
     * Set theirs respect status according with the travel
     * All the players are playing
     * The coach is leadering match
     * The massause can't be giving massage
     */
    private static void travel(){
        for (TeamMate teamMate : team) {
            if(teamMate instanceof Player){
                ((Player) teamMate).setPlaying(true);
            }else if(teamMate instanceof Coach){
                ((Coach) teamMate).setLeaderingMatch(true);
            }else{
                ((Masseuse) teamMate).setGivingMassage(false);
            }
        }
    }

    /**
     * Set theirs respect status according with the concentration
     * All the players are training
     * The coach is leadering training
     * The massause could being give massage
     */
    private static void concentration(){
        for (TeamMate teamMate : team) {
            if(teamMate instanceof Player){
                ((Player) teamMate).setTraining(true);
            }else if(teamMate instanceof Coach){
                ((Coach) teamMate).setLeaderingTraining(true);
            }else{
                ((Masseuse) teamMate).setGivingMassage(true);
            }
        }

    }

}
