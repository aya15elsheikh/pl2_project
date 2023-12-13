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
  Marketing_Employee Marketing = new Marketing_Employee(24,"bassmala","bbba","marketing_Employee");
  Marketing.setusername("bassmala");
  Marketing.setPassword("bass246");
  Scanner input = new Scanner(System.in);
  System.out.println("press 1 to add special offers , press 2 to make new roports about produt");
  int choice = input.nextInt();
  switch (choice){
      case 1:
          System.out.println("Enter offer type: ");
          String type = input.nextLine();
          System.out.println("Enter offer time per days");
          double timePerdays = input.nextDouble();
          System.out.println("Enter offer percentage ");
          double percentage = input.nextDouble();
          Marketing.add_offer(type,timePerdays,percentage);
          System.out.println("offer added Successfully");
      case 2:
          System.out.println("Enter your Report details");
          System.out.println("Enter report number ");
          int number = input.nextInt();
          System.out.println("Enter report description ");
          String description  = input.nextLine();
          Products product_info = new Products();
          System.out.println("Enter product details");
          System.out.println("name : ");
          String name  = input.nextLine();
          product_info.setName(name);
          System.out.println("price: ");
          int price = input.nextInt();
          product_info.setPrice(price);
          System.out.println("Quantity: ");
          int quantity = input.nextInt();
          product_info.setQuantity(quantity);
          System.out.println("Expirey date: ");
          String date = input.nextLine();
          product_info.setExpiry_Date(date);
          System.out.println("its special range ");
          int range = input.nextInt();
          product_info.setSpecial_Range(range);
          Marketing.add_report(number,description,product_info);
          System.out.println("report added Successfully");
      default:
          System.out.println("invalid choice :(");
  }


    }

    public static void sales_interface()
    {

    }

}
