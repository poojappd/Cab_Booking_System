package App;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputGetter {
    private static Scanner input = new Scanner(System.in);

    private static int handleIntInputException() {
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
            chosenMenuOption = handleIntInputException();
            conditionNotSatisfied = (chosenMenuOption < 0 || chosenMenuOption > choiceLimit);
            if (conditionNotSatisfied) {
                System.out.println("Please enter a valid value");
            }
        }
        while(conditionNotSatisfied);

        return chosenMenuOption;
    }

    public static String getStringInput(){
        return input.nextLine();
    }

    public static int getIntInput(){
        return handleIntInputException();
    }
    public static int getInputFromRange(int lowerLimit, int upperLimit){
        int value =-1;
        boolean conditionNotSatisfied;
        do{
            value = handleIntInputException();
            conditionNotSatisfied = (value<lowerLimit || value>upperLimit);
            if(conditionNotSatisfied){
                System.out.println("Please enter a value within the range!");
            }
        }
        while (conditionNotSatisfied);
        return value;
    }

}
