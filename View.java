package Exceptions_Sem3_HomeTasks;

import Exceptions_Sem3_HomeTasks.Exceptions.IllegalUserDetailFormatException;
import Exceptions_Sem3_HomeTasks.Exceptions.WrongNumberOfUserDetailsException;

import java.io.IOException;
import java.util.Scanner;

public class View {
    Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void run(){
        while (true) {
            try {
                String[] userDetails = getUserDetails(prompt1);
                controller.validateEnteredUserDetails(userDetails);
                controller.saveToFile(userDetails);
                break;
            } catch (WrongNumberOfUserDetailsException | IllegalUserDetailFormatException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    static String prompt1 = "Please, enter your user details (6 parameters) divided by space sign (no other signs allowed) in the " +
            "following order and format:\nFirstname Lastname Patronimic birthdate(dd.mm.yyyy) phonenumber(digits only) sex(f or m): ";

    private String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String response = scanner.nextLine();
        return response;
    }

    public String[] getUserDetails(String prompt) {
        String response = getString(prompt);
        int requiredLength = 6;
        String[] responseArray = response.split(" ");
        if (responseArray.length != requiredLength) {
            throw new WrongNumberOfUserDetailsException(responseArray.length, requiredLength);
        }
        return responseArray;
    }
}
