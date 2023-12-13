import java.util.*;
public class Menu {

    public static void user_interface()
    {

    }

    public static void  Admin_interface( int id ,String username,String password ,String type) {
        Scanner scanner;
        scanner = new Scanner(System.in);

        Admin admin = new Admin(id,username,password,type);
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
