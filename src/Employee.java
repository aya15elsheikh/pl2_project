public class Employee extends person {
    private String type;

    public Employee(int id, String Username, String password, String type) {
        super(Username,  password,type, id);
        this.type = type;
    }

    @Override
    public void setusername(String username) {
    }

    @Override
    public String getusername() {
        return null;
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

