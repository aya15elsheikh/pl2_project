public class Employee {
   private int ID;
   private String password;
   private String Username;
   private String Type;
   
   public Employee()
   {

   }
   public Employee (int ID ,String Username, String password , String Type)
   {
       this.ID = ID;
       this.password = password;
       this.Username = Username;
       this.Type = Type;
   }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getUsername() {
        return Username;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getType() {
        return Type;
    }
}
