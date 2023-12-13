public abstract class person {
   String username;
    String password;
    int id;
    

    person(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public abstract void setusername(String username);
    public abstract String getusername();

    public abstract void setId(String  id);
    public abstract String  getId();
    
  
    public abstract void setPassword(String password);
    public abstract String getPassword();
}
