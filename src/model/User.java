package model;

public class User
{
    private String user_name;
    private String pwd;
    private int age;
    private String e_mail;
    private int id;
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPwd() {
        return pwd;
    }

    public int getAge() {
        return age;
    }

    public String getE_mail() {
        return e_mail;
    }

}
