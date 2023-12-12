import java.util.*;

public class Offers {
    private String type;
    private double  time;
    private double percentage;


    public Offers (String type ,double time , double percentage ){
        this.type = type;
        this.time=time;
        this.percentage=percentage;

    }
    public String get_type(){
        return type;
    }
    public double get_time(){
        return time;
    }
    public double get_percentage(){
        return percentage;
    }

    public void addOffer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Offer type: ");
        type = input.nextLine();
        System.out.println("Enter Offer time ");
        time = input.nextDouble();
        System.out.println("Enter Offer percentage ");
        percentage = input.nextDouble();
        System.out.println("offer has been added Successfully !");
    }
    public void deleteOffer(){
        type = null;
        time = 0.0;
        percentage =0.0;
        System.out.println("offer has been deleted Successfully ");
    }
    public void editOffer(){
        Scanner input = new Scanner(System.in);
        System.out.println("press 1 for edit type");
        System.out.println("press 2 for edit time");
        System.out.println("press 3 for edit percentage");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter new offer type ");
                type = input.nextLine();
                break;
            case 2:
                System.out.println("Enter new offer time ");
                time = input.nextDouble();
                break;
            case 3:
                System.out.println("Enter new offer percentage ");
                percentage = input.nextDouble();
                break;
            default:
                System.out.println("Invalid choice");}
        System.out.println("offer has been edited Successfully !");

        }



    }



