public abstract class person {
    String username;
    String password;
    String Type;
    int id;
    

    person(String username, String password,String Type, int id) {
        this.username = username;
        this.password = password;
        this.Type=Type;
        this.id = id;
    }

    public abstract void setusername(String username);
    public abstract String getusername();

    public abstract void setId(String  id);
    public abstract String  getId();
    
     public abstract void setType(String type);
     public abstract  String getType();

    public abstract void setPassword(String password);
    public abstract String getPassword();
}
