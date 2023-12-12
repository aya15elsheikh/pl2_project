import java.util.*;
public class Reports {
    private int repo_num;
    private String description;

    public Reports (int repo_num , String description){
        this.repo_num = repo_num;
        this.description=description;
    }
    public int get_repoNum(){
        return repo_num;
    }
    public String description(){
        return description;
    }
    public void add_repo(int productId){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Report Number : ");
        repo_num = input.nextInt();
        System.out.println("Enter Report description ");
        description = input.nextLine();
        System.out.println("Report added Successfully !");

    }
    public void delete_repo(){
      repo_num = 0;
      description = null;
    }
    public void edit_repo(){
        Scanner input = new Scanner(System.in);
        System.out.println("press 1: for edit report number , press 2: for edit report description ");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter new report number :  ");
                repo_num = input.nextInt();
                break;
            case 2:
                System.out.println("Enter new report description :  ");
                description = input.nextLine();
                break;
            default:
                System.out.println("Invalid choice :(  ");


        }
        System.out.println("Report Edited Successfully :) ");


    }










}
