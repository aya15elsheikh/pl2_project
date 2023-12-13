class Employee extends person {
    private String type;

    public Employee(String id, String Username, String password, String type) {
        super(Username,  password,  Integer.parseInt(id));
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}

