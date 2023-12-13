public abstract class person {
    String username;
    String password;
    String Type;
    

    person(String username, String password,String Type) {
        this.username = username;
        this.password = password;
        this.Type=Type;
        
    }

    public abstract void setusername(String username);
    public abstract String getusername();
    
     public abstract void setType(String type);
     public abstract  String getType();

    public abstract void setPassword(String password);
    public abstract String getPassword();
}
