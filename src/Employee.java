class Employee {
    private String id;
    private String password;
    private String type;
    private String Username;

    public Employee(String id, String Username, String password, String type) {
        this.id = id;
        this.password = password;
        this.type = type;
        this.Username = Username;
    }

    public String  getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }
}

