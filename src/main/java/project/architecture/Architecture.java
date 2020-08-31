package project.architecture;

import project.database.dao.EmployeeDao;
import project.database.dao.LocationDao;
import project.database.dao.LookbookDao;
import project.database.daoImpl.EmployeeDaoImpl;
import project.database.daoImpl.LocationDaoImpl;
import project.database.daoImpl.LookbookDaoImpl;
import project.database.entity.Employee;
import project.database.entity.Location;
import project.database.entity.Lookbook;

import java.util.Scanner;

public class Architecture {

    EmployeeDao employeeDao = new EmployeeDaoImpl();
    LocationDao locationDao = new LocationDaoImpl();
    LookbookDao lookbookDao = new LookbookDaoImpl();

    Basket basket = new Basket();

    Scanner scanner = new Scanner(System.in);
    static String choice;
    static boolean isTrue = true;

    public void mainMenu() {
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
                clientMenu();
                isTrue = false;
            } else if (choice.equals("2")) {
                managerMenu();
                isTrue = false;
            } else System.out.println("Incorrect choice, try again");
        }
    }

    void clientMenu() {
        while (isTrue) {
            System.out.println("1 - Shopping\n" +
                    "2 - Basket\n" +
                    "0 - Go Back");

            choice = scanner.nextLine();

            if (choice.equals("1")) {
                for (Lookbook lookbook : lookbookDao.findAll()) {
                    System.out.println(lookbook.toString());
                }
                    while (isTrue) {
                        System.out.print("\nSelect ID to add to BASKET (0 to quit)\n" +
                                "ID= ");
                        choice = scanner.nextLine();

                        if (choice.equals("0")) {
                            clientMenu();
                        } else basket.addToBasket(choice);
                    }

            } else if (choice.equals("2")) {
                basket.showBasket();

                while (isTrue) {
                    System.out.println("\n0 - Go Back");
                    choice = scanner.nextLine();

                    if (choice.equals("0")) {
                        clientMenu();
                    } else System.out.println("Incorrect choice, try again");
                }
            } else if (choice.equals("0")) {
                mainMenu();
            } else System.out.println("Incorrect choice, try again");
        }
    }

    void managerMenu() {
        System.out.println("1 - Show employee list\n" +
                "2 - Search for employee by ID\n" +
                "3 - Add employee\n" +
                "4 - Delete employee\n" +
                "5 - Show location list\n" +
                "6 - Search for location by ID\n" +
                "7 - Add location\n" +
                "8 - Delete location\n" +
                "9 - Show lookbook list\n" +
                "10 - Search for products by ID\n" +
                "11 - Add product\n" +
                "12 - Delete product\n" +
                "0 - Go Back");

        while (true) {
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                for (Employee employee : employeeDao.findAll()) {
                    System.out.println(employee.toString());
                }
                    while (isTrue) {
                        System.out.println("\n0 - Go Back");
                        choice = scanner.nextLine();

                        if (choice.equals("0")) {
                            managerMenu();
                        } else System.out.println("Incorrect choice, try again");
                    }

            } else if (choice.equals("2")) {
                System.out.print("Provide employee ID to search\n" +
                        "ID= ");

                choice = scanner.nextLine();

                System.out.println(employeeDao.findById(Long.parseLong(choice)));

                while (isTrue) {
                    System.out.println("\n0 - Go Back");
                    choice = scanner.nextLine();

                    if (choice.equals("0")) {
                        managerMenu();
                    } else System.out.println("Incorrect choice, try again");
                }

            } else if (choice.equals("3")) {
                System.out.print("Provide Employee Name= ");
                choice = scanner.nextLine();
                Employee employee = new Employee();
                employee.setName(choice);

                employeeDao.save(employee);

                System.out.println("\nEmployee added!\n");
                managerMenu();

            } else if (choice.equals("4")) {
                System.out.print("Provide ID to terminate= ");
                choice = scanner.nextLine();

                employeeDao.delete(Long.parseLong(choice));

                System.out.println("\nEmployee terminated!\n");
                managerMenu();

            } else if (choice.equals("5")) {
                for (Location location : locationDao.findAll()) {
                    System.out.println(location.toString());
                }
                while (isTrue) {
                    System.out.println("\n0 - Go Back");
                    choice = scanner.nextLine();

                    if (choice.equals("0")) {
                        managerMenu();
                    } else System.out.println("Incorrect choice, try again");
                }

            } else if (choice.equals("6")) {
                System.out.print("Provide location ID to search\n" +
                        "ID= ");

                choice = scanner.nextLine();

                System.out.println(locationDao.findById(Long.parseLong(choice)));

                while (isTrue) {
                    System.out.println("\n0 - Go Back");
                    choice = scanner.nextLine();

                    if (choice.equals("0")) {
                        managerMenu();
                    } else System.out.println("Incorrect choice, try again");
                }

            } else if (choice.equals("7")) {
                System.out.print("Provide Location City= ");
                choice = scanner.nextLine();
                Location location = new Location();
                location.setCity(choice);

                System.out.print("Provide Location Country= ");
                choice = scanner.nextLine();
                location.setCountry(choice);

                locationDao.save(location);

                System.out.println("\nLocation added!\n");
                managerMenu();

            } else if (choice.equals("8")) {
                System.out.print("Provide ID to remove= ");
                choice = scanner.nextLine();

                locationDao.delete(Long.parseLong(choice));

                System.out.println("\nLocation removed!\n");
                managerMenu();

            } else if (choice.equals("9")) {
                for (Lookbook lookbook : lookbookDao.findAll()) {
                    System.out.println(lookbook.toString());
                }

                while (isTrue) {
                    System.out.println("\n0 - Go Back");
                    choice = scanner.nextLine();

                    if (choice.equals("0")) {
                        managerMenu();
                    } else System.out.println("Incorrect choice, try again");
                }

            } else if (choice.equals("10")) {
                System.out.print("Provide product ID to search\n" +
                        "ID= ");

                choice = scanner.nextLine();

                System.out.println(lookbookDao.findById(Long.parseLong(choice)));

                while (isTrue) {
                    System.out.println("\n0 - Go Back");
                    choice = scanner.nextLine();

                    if (choice.equals("0")) {
                        managerMenu();
                    } else System.out.println("Incorrect choice, try again");
                }

            } else if (choice.equals("11")) {
                Lookbook lookbook = new Lookbook();
                System.out.print("Provide Product Name= ");
                choice = scanner.nextLine();
                lookbook.setName(choice);

                System.out.print("Provide Product Price= ");
                choice = scanner.nextLine();
                lookbook.setPriceInUSD(Integer.parseInt(choice));

                System.out.print("Provide Product Season= ");
                choice = scanner.nextLine();
                lookbook.setSeason(choice);

                lookbookDao.save(lookbook);

                System.out.println("\nProduct added!\n");
                managerMenu();

            } else if (choice.equals("12")) {
                System.out.print("Provide ID to remove= ");
                choice = scanner.nextLine();

                lookbookDao.delete(Long.parseLong(choice));

                System.out.println("\nProduct removed!\n");
                managerMenu();

            } else if (choice.equals("0")){
                mainMenu();

            } else System.out.println("Incorrect choice, try again");
        }
    }
}