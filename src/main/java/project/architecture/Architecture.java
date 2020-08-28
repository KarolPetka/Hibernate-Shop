package project.architecture;

import java.util.Scanner;

public class Architecture {

    Scanner scanner = new Scanner(System.in);
    static String choice;
    static boolean isTrue = true;

    public void MainMenu() {
        System.out.println("+=========================+\n"
                + "|*************************|\n"
                + "|* Welcome to \"The Shop\" *|\n"
                + "|*************************|\n"
                + "+=========================+\n\n"
                + "Select by choosing number\n");

        while (isTrue) {
            System.out.println("1 - Client Menu\n"
                    + "2 - Manager Menu");

            choice = scanner.nextLine();
            if (choice.equals("1")) {
                ClientMenu();
                isTrue = false;
            } else if (choice.equals("2")) {
                ManagerMenu();
                isTrue = false;
            } else System.out.println("Incorrect choice, try again");
        }
    }

    void ClientMenu(){
        System.out.println("1 - Shopping\n" +
                "2 - Basket\n" +
                "3 - Go Back");

    }

    void ManagerMenu(){
        System.out.println("1 - Show employee list\n" +
                "2 - Search for employee by ID\n" +
                "3 - Add employee/update employee\n" +
                "4 - Delete employee\n" +
                "5 - Show location list\n" +
                "6 - Search for location by ID\n" +
                "7 - Add location/update location\n" +
                "8 - Delete location\n" +
                "9 - Show lookbook list\n" +
                "10 - Search for products by ID\n" +
                "11 - Add product/update product\n" +
                "12 - Delete product\n" +
                "13 - Go Back");

    }

}