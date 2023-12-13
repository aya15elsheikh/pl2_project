import java.io.*;

import java.util.*;

class User {
    private String username;
    private String password;
    private String email;
    private int phoneNumber;
    private static int id = 0;
    static List<User> users = new ArrayList<>();

    static User currentUser = null;

    public User(String username, String password, String email, int phoneNumber, int id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        id++;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static int getId() {
        return id;
    }



    Scanner scanner = new Scanner(System.in);

    public void AddUser() throws IOException {




        while (true) {
            if (currentUser == null) {
                System.out.println("1. Login\n2. Sign Up");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    if (login(username, password)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password!");
                    }
                } else if (choice == 2) {
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    if (usernameExists(username)) {
                        System.out.println("Username already exists!");
                        continue;
                    }
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    if (!email.contains("@")) {
                        System.out.println("That's an invalid email");
                        continue;
                    }
                    int phoneNumber = 0;
                    while (true) {
                        System.out.println("Enter phone number:");
                        try {
                            phoneNumber = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid phone number");
                        }
                    }

                    users.add(new User(username, password, email, phoneNumber, id));
                    saveUsers();
                    System.out.println("Sign up successful! Your ID is: " + id);
                }
            } else {
                System.out.println("1. Update\n2. Logout");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    while (true) {
                        System.out.println("What do you want to update?\n1. Username\n2. Password\n3. Email\n4. Phone number\n5. Go back");
                        int updateChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (updateChoice == 1) {
                            System.out.println("Enter new username:");
                            String newUsername = scanner.nextLine();
                            if (usernameExists(newUsername)) {
                                System.out.println("Username already exists!");
                                continue;
                            }
                            currentUser.username = newUsername;
                        } else if (updateChoice == 2) {
                            System.out.println("Enter new password:");
                            currentUser.password = scanner.nextLine();
                        } else if (updateChoice == 3) {
                            while (true) {
                                System.out.println("Enter new email:");
                                String newEmail = scanner.nextLine();
                                if (!newEmail.contains("@")) {
                                    System.out.println("That's an invalid email");
                                } else {
                                    currentUser.email = newEmail;
                                    break;
                                }
                            }
                        } else if (updateChoice == 4) {
                            while (true) {
                                System.out.println("Enter new phone number:");
                                try {
                                    currentUser.phoneNumber = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid phone number");
                                }
                            }
                        } else {
                            break;
                        }
                        saveUsers();
                        System.out.println("Update successful!");
                    }
                } else if (choice == 2) {
                    currentUser = null;
                    System.out.println("Logged out successfully!");
                }
            }
        }

    }

    static boolean login(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    static boolean usernameExists(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    static void loadUsers() throws IOException {
        File file = new File("users.txt");
        if (!file.exists()) {
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            users.add(new User(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
        }
        reader.close();
    }

    static void saveUsers() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"));
        for (User user : users) {
            writer.write(user.username + "," + user.password + "," + user.email + "," + user.phoneNumber + "," + user.id);
            writer.newLine();
        }
        writer.close();
    }
}
