package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner input = new Scanner(System.in);

    public static int getIntInput() {
        int testValue = -1;
        boolean noError = false;
        while (!noError) {
            try {
                testValue = input.nextInt();
                noError = true;
            } catch (InputMismatchException ie) {
                System.out.println("Please enter a valid value!");
            }
            input.nextLine();
        }
        return testValue;
    }

    public static int getMenuChoiceInput(int choiceLimit){
        int chosenMenuOption;
        boolean conditionNotSatisfied;
        do {
            chosenMenuOption = getIntInput();
            conditionNotSatisfied = (chosenMenuOption < 0 || chosenMenuOption > choiceLimit);
            if (conditionNotSatisfied) {
                System.out.println("Please enter the right option");
            }
        }
        while(conditionNotSatisfied);

        return chosenMenuOption;
    }

    public static String getStringInput(){
        return input.nextLine();
    }


    public static int getInputFromRange(int lowerLimit, int upperLimit){
        int value =-1;
        boolean isWithinRange;
        do{
            value = getIntInput();
            isWithinRange = (value>=lowerLimit && value<=upperLimit);
            if(!isWithinRange){
                System.out.println("Please enter a value within the range ("+lowerLimit+" - "+upperLimit+")");
            }
        }
        while (!isWithinRange);
        return value;
    }

}
