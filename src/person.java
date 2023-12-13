abstract class person {
    String username;
    String password;
    int id;

    person(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
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

}
