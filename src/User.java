Shahd Emam, [12/13/2023 10:05 PM]
import java.io.*;

import java.util.*;
public  class User extends person {

    private String email;
    private int phoneNumber;
    static private int id_us = 0;
    private int id;



    static List<User> users = new ArrayList<>();

    public User( String username,String Type, String password, String email, int phoneNumber) {
        super(username, password,"User");
        this.id_us++;
        this.id=id;
        this.email = email;
        this.phoneNumber = phoneNumber;


    }

    static User currentUser = null;


    @Override
    public void setusername(String username) {
        this.username = username;
    }

    @Override
    public String getusername() {
        return this.username;
    }


    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getType()
    {
        return this.Type;
    }
    @Override
    public void setType(String Type) {
        this.Type=Type;
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

    public int getid() {
        return id;
    }


    public void AddUser() throws IOException {
        Scanner scanner = new Scanner(System.in);

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
                    System.out.println("Enter type:");
                    String type = scanner.nextLine();
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    System.out.println("Enter email:");
                    email = scanner.nextLine();
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


                    users.add(new User(username, Type, password, email, phoneNumber));
                    saveUsers(type);

                    System.out.println("Sign up successful! Your ID is: " + id_us);
                }
            } else {

Shahd Emam, [12/13/2023 10:05 PM]
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
                            create_files file = new create_files();
                            file.update_file("C:\\Users\\janaw\\Downloads\\CLONE\\pl2_project\\pl2_project\\" + Type + ".txt", currentUser.username, newUsername);
                            currentUser.username = newUsername;
                        } else if (updateChoice == 2) {
                            System.out.println("Enter new password:");
                            String newPassword = scanner.nextLine();
                            create_files file = new create_files();
                            file.update_file("C:\\Users\\janaw\\Downloads\\CLONE\\pl2_project\\pl2_project\\" + Type + ".txt", currentUser.password, newPassword);
                            currentUser.password = newPassword;
                        } else if (updateChoice == 3) {
                            while (true) {
                                System.out.println("Enter new email:");
                                String newEmail = scanner.nextLine();
                                if (!newEmail.contains("@")) {
                                    System.out.println("That's an invalid email");
                                } else {
                                    create_files file = new create_files();
                                    file.update_file("C:\\Users\\janaw\\Downloads\\CLONE\\pl2_project\\pl2_project\\" + Type + ".txt", currentUser.email, newEmail);
                                    currentUser.email = newEmail;
                                    break;
                                }
                            }
                        } else if (updateChoice == 4) {
                            while (true) {
                                System.out.println("Enter new phone number:");
                                int newPhoneNumber = Integer.parseInt(scanner.nextLine());
                                try {
                                    create_files file = new create_files();
                                    file.update_file("C:\\Users\\janaw\\Downloads\\CLONE\\pl2_project\\pl2_project\\" + Type + ".txt", String.valueOf(currentUser.phoneNumber), String.valueOf(newPhoneNumber));
                                    currentUser.phoneNumber = newPhoneNumber;
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid phone number");
                                }
                            }
                        } else {
                            break;
                        }

                        saveUsers(Type);
                        System.out.println("Update successful!");
                    }
                } else if (choice == 2) {
                    currentUser = null;
                    System.out.println("Logged out successfully!");
                }
            }
        }

    }

Shahd Emam, [12/13/2023 10:05 PM]
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


    static void saveUsers(String Type) throws IOException {
        String path ="C:\\Users\\janaw\\Downloads\\CLONE\\pl2_project\\pl2_project\\";
        create_files file = new create_files();
        file.Create(path,Type);
        for (User user : users) {
            file.Append(path+Type+".txt",user.username + "," + user.password + "," + user.email + "," + user.phoneNumber + "," + user.id+"\n");
        }}


}
