import java.util.*;

public class Menu {
    public static void user_interface()
    {

    }

    public static void  Admin_interface() {
        Scanner scanner;
        Admin admin = new Admin(11,"ww","qq" ,"Admin");
        admin.setUsername("admin");
        admin.setPassword("password");

        scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(admin.username) && password.equals(admin.password)) {
            System.out.println("Login successful.\n");
            boolean exit = false;
            while (!exit) {
                System.out.println("1. Add employee");
                System.out.println("2. Delete employee");
                System.out.println("3. Update employee");
                System.out.println("4. List all employees");
                System.out.println("5. Search employee");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        admin.addEmployee();
                        break;
                    case 2:
                        admin.deleteEmployee();
                        break;
                    case 3:
                        admin.updateEmployee();
                        break;
                    case 4:
                        admin.listEmployees();
                        break;
                    case 5:
                        admin.searchEmployee();
                        break;
                    case 6:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

                System.out.println();
            }
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }

        scanner.close();
    }

    public static void Inventory_interface()
    {

    }
    public static void marketing_interface()
    {

    }

    public static void sales_interface()
    {

    }

}
