public abstract class person {
   String username;
    String password;
   
    

    person(String username, String password) {
        this.username = username;
        this.password = password;
        
    }

    public abstract void setusername(String username);
    public abstract String getusername();

    public abstract void setPassword(String password);
    public abstract String getPassword();
}
