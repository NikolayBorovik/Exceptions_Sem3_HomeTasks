package Exceptions_Sem3_HomeTasks;

import Exceptions_Sem3_HomeTasks.Exceptions.IllegalUserDetailFormatException;
import Exceptions_Sem3_HomeTasks.Exceptions.WrongNumberOfUserDetailsException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                String[] userDetails = getUserDetails(prompt1);
                validateEnteredUserDetails(userDetails);
                saveToFile(userDetails);
                break;
            } catch (WrongNumberOfUserDetailsException | IllegalUserDetailFormatException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static String prompt1 = "Please, enter your user details (6 parameters) divided by space sign (no other signs allowed) in the " +
            "following order and format:\nFirstname Lastname Patronimic birthdate(dd.mm.yyyy) phonenumber(digits only) sex(f or m): ";

    private static String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String response = scanner.nextLine();
        return response;
    }

    public static String[] getUserDetails(String prompt) {
        String response = getString(prompt);
        int requiredLength = 6;
        String[] responseArray = response.split(" ");
        if (responseArray.length != requiredLength) {
            throw new WrongNumberOfUserDetailsException(responseArray.length, requiredLength);
        }
        return responseArray;
    }

    public static void validateEnteredUserDetails(String[] responseArray) {
        String message;
        int userParameterIndex = 3;
        int maxElInBirthdate = 3;
        String[] stringBirthdate = responseArray[userParameterIndex].split("\\.");
        if (stringBirthdate.length != maxElInBirthdate) {
            message = "Wrong number of birthdate elements. ";
            throw new IllegalUserDetailFormatException(message);
        }
        int[] birthDate = new int[stringBirthdate.length];
        for (int i = 0; i < birthDate.length; i++) {
            try {
                birthDate[i] = Integer.parseInt(stringBirthdate[i]);
            } catch (NumberFormatException e) {
                message = "Some of the birthdate elements are not numbers. ";
                throw new IllegalUserDetailFormatException(message);
            }
        }
        userParameterIndex++;

        try {
            int phoneNumber = Integer.parseInt(responseArray[userParameterIndex]);
        } catch (NumberFormatException e) {
            message = "Some of the phone number elements are not numbers. ";
            throw new IllegalUserDetailFormatException(message);
        }
        userParameterIndex++;
        int maxElInSex = 1;
        if (responseArray[userParameterIndex].length() != maxElInSex) {
            message = "Sex parameter is not one character. ";
            throw new IllegalUserDetailFormatException(message);
        }
//        System.out.println(userParameterIndex);
        if (!responseArray[userParameterIndex].equals("m") ) {
            message = "Sex parameter is not a required character. ";
            throw new IllegalUserDetailFormatException(message);
        }
    }

    private static void saveToFile(String[] userDetails) throws IOException {
//        File file = new File(userDetails[1] + ".txt");
//        if(file.exists() && !file.isDirectory()) {
//            try (FileWriter fileWriter = new FileWriter(userDetails[1] + ".txt", true)) {
//                fileWriter.write(userDetails[0]);
//                for (int i = 1; i < userDetails.length; i++) {
//                    fileWriter.write(", ");
//                    fileWriter.write(userDetails[i]);
//                    fileWriter.flush();
//                }
//            }
//        }
        try (FileWriter fileWriter = new FileWriter(userDetails[1] + ".txt", true)) {
            fileWriter.write(userDetails[0]);
            for (int i = 1; i < userDetails.length; i++) {
                fileWriter.write(", ");
                fileWriter.write(userDetails[i]);
            }
            fileWriter.write("\n");
            fileWriter.flush();
        }
    }

}
