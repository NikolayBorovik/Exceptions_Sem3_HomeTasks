package Exceptions_Sem3_HomeTasks;

import Exceptions_Sem3_HomeTasks.Exceptions.IllegalUserDetailFormatException;

import java.io.IOException;

public class Controller {
    Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void validateEnteredUserDetails(String[] responseArray) {
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
        if (!responseArray[userParameterIndex].equals("m") && !responseArray[userParameterIndex].equals("f")) {
            message = "Sex parameter is not a required character. ";
            throw new IllegalUserDetailFormatException(message);
        }
    }

    public void saveToFile(String[] userDetails) throws IOException {
        model.saveToFile(userDetails);
    }
}
