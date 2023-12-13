public class Employee extends person {
     
     private String Type;
    public Employee( String username, String password,String Type) {
        super(username, password);
        this.Type=Type;
       
    }
   @Override
      public  void setusername(String username){
          this.username=username;
      }
       @Override
       public String getusername()
       {
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
  
     public void setType(String type) {
        this.Type = type;
     }
    public String getType() {
        return this.Type;
    }
}

