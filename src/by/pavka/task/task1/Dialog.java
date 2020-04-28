package by.pavka.task.task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Dialog {

    private Properties properties;
    private FileWriter fileWriter;
    private static Scanner scanner = new Scanner(System.in);
    private String address;
    private boolean isOver;

    public Dialog(Properties properties, FileWriter fileWriter) {
        this.properties = properties;
        this.fileWriter = fileWriter;
    }

    public void session(String end) {
        int choice = enter();
        address = null;
        switch(choice) {
            case 1:
                address = signUp(end);
                if(address.equals(end)) {
                    return;
                }
                try {
                    properties.store(fileWriter, address);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                address = signIn(end);
                if(address.equals(end)) {
                    return;
                }
                break;
        }
        User user = address.equals(Admin.ADMIN_EMAIL)? new Admin(): new User(address);
        String result = null;
        do {
            result = process(user, end);
        }
        while(!result.equals(end));


    }

    private String process(User user, String end) {
        user.startView();
        String command = null;
        String error = "";

        do {
            System.out.println(error);
            System.out.println("To check the next page print \"NEXT\"");
            System.out.println("To check the previous page print \"PREV\"");
            System.out.println("To check the first page print \"START\"");
            System.out.println("Or type " + "\"" + end + "\"" + " if you want to end your session");
            error = "Wrong input";
            command = scanner.nextLine();
            if(command.equals(end)) return end;
        }
        while(!command.equals("NEXT") && !command.equals("PREV") && !command.equals("START"));
        switch(command) {
            case "NEXT":
                user.next();
                System.out.println(command);
                return command;
            case "PREV":
                user.prev();
                System.out.println(command);
                return command;
            default:
                user.startView();
                System.out.println(command);
                return command;
        }

    }

    private String signIn(String end) {
        address = null;
        String error = "";
        Set<String> emails = properties.stringPropertyNames();
        do {
            System.out.println(error);
            System.out.println("Enter your email address");
            System.out.println("Or type " + "\"" + end + "\"" + " if you want to end your session");
            address = scanner.nextLine();
            error = "This email address is not registered";

            if(address.equals(end)) return end;
        }
        while(!emails.contains(address));
        System.out.println("Enter your password");
        int passHashInt = Objects.hash(address, scanner.nextLine());
        if(String.valueOf(passHashInt).equals(properties.getProperty(address))) {
            System.out.println("The Password is correct");
        }
        else {
            System.out.println("The Password is wrong");
            return end;
        }

        return address;
    }

    private String signUp(String end) {
        String address = verifyNewEmail(end);
        if(address.equals(end)) return address;
        String result = addPassword(end);
        if(result.equals(end)) return result;
        properties.setProperty(address, result);
        return address;
    }

    private String verifyNewEmail(String end) {
        address = null;
        String error = "";
        boolean ok = false;
        do {
            System.out.println(error);
            System.out.println("Enter your email address");
            System.out.println("Or type " + "\"" + end + "\"" + " if you want to end your session");
            if(scanner.hasNextLine()) {
                address = scanner.nextLine();
            }
            if(address.equals(end)) return end;

            if(!address.matches(".+@.+\\..+")) {

                error = "Wrong email address format";
            }
            else {
                Set<String> addresses = properties.stringPropertyNames();

                if(addresses.contains(address)) {
                    error = "This email address is already registered in the system";
                }
                else ok = true;
            }

        }
        while(!ok);
        return address;
    }

    private String addPassword(String end) {
        System.out.println("Enter your password");
        System.out.println("Or type " + "\"" + end + "\"" + " if you want to end your session");
        String pass = null;
        String error = "";
        do {
            System.out.println(error);
            pass = scanner.nextLine();

            if(pass.equals(end)) return end;

            error = "Password must have at least 5 characters";
        }
        while(pass.length() < 5);
        return String.valueOf(Objects.hash(address, pass));
    }

    private int enter() {

        int choice = 0;
        String error = "";
        do {
            System.out.println(error);
            System.out.println("Enter the System");
            System.out.println("Press 1 if you are a new user and want to Sign Up");
            System.out.println("Press 2 if you already have an account and want to Sign In");
            if(scanner.hasNext()) {
                if(scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                }
                else {
                    scanner.next();
                }
            }
            error = "Incorrect input";
        }
        while (choice != 1 && choice != 2);
        scanner.nextLine();
        return choice;
    }

}
