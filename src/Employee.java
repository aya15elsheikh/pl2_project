public class Employee extends person {
    
    private String Type;

    public Employee(String Type, String username, String password, int id) {
        super(username, password, id);
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
   public void setId(String  id) {
        this.id =  Integer.parseInt(id);
    }

   @Override
    public String  getId() {
        return String.valueOf(id);
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
        return Type;
    }

     

}

