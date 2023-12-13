public class Employee extends person {
    private String type;

    public Employee(String id, String Username, String password, String type) {
        super(Username,  password, id);
        this.type = type;
    }
    
     public void setId(String  id) {
        this.id =  Integer.parseInt(id);
    }

    public String  getId() {
        return String.valueOf(id);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}

