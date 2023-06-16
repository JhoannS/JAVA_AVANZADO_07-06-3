package co.edu.sena.project.model;
public class User {
        private Integer user_id;
        private String user_firstname;
        private String user_lastmane;
        private String user_email;
        private String user_pasword;

    public User() {
    }

    public User(Integer user_id, String user_firstname, String user_lastmane, String user_email, String user_pasword) {
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastmane = user_lastmane;
        this.user_email = user_email;
        this.user_pasword = user_pasword;
    }

    public User(String user_firstname, String user_lastmane, String user_email, String user_pasword) {
        this.user_firstname = user_firstname;
        this.user_lastmane = user_lastmane;
        this.user_email = user_email;
        this.user_pasword = user_pasword;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastmane() {
        return user_lastmane;
    }

    public void setUser_lastmane(String user_lastmane) {
        this.user_lastmane = user_lastmane;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pasword() {
        return user_pasword;
    }

    public void setUser_pasword(String user_pasword) {
        this.user_pasword = user_pasword;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_firstname='" + user_firstname + '\'' +
                ", user_lastmane='" + user_lastmane + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_pasword='" + user_pasword + '\'' +
                '}';
    }
}

