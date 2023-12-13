public class Employee extends person {
   public Employee( String username, String password,String Type) {
        super(username, password,Type);
        this.Type = Type;
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
   @Override
     public void setType(String type) {
        this.Type = type;
     }
      @Override
    public String getType() {
        return this.Type;
    }
}

