import java.util.*;

public class Admin extends person {
    private List <Employee> employees;
    private Scanner scanner;

    public Admin(String id, String Username, String password) {
        super( Username , password , Integer.parseInt(id));
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addEmployee() {
        System.out.print("Enter employee ID: ");
        String  id = scanner.nextLine();
        System.out.print("Enter employee username: ");
        String username = scanner.nextLine();
        System.out.print("Enter employee password: ");
        String password = scanner.nextLine();
        System.out.print("Enter employee type: ");
        String type = scanner.nextLine();
        System.out.print("Enter employee email: ");
        String email = scanner.nextLine();
        System.out.print("Enter employee phone number : ");
        int p_num = scanner.nextInt();
        Employee employee = new Employee(id,username , password, type);
        employees.add(employee);

        System.out.println("Employee added successfully.");
    }

    public void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        String id = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employees.remove(employee);
                System.out.println("Employee deleted successfully.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    public void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        String id = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                employee.setPassword(newPassword);
                System.out.println("Employee updated successfully.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    public void listEmployees() {
        System.out.println("List of employees:");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Type: " + employee.getType());
        }
    }

    public void searchEmployee() {
        System.out.print("Enter employee ID to search: ");
        String id = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                System.out.println("Employee found:");
                System.out.println("ID: " + employee.getId() + ", Type: " + employee.getType());
                return;
            }
        }

        System.out.println("Employee not found.");
    }
}
