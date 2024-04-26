package Utility;
 ;
public class Person {
    private int ID;
    private String name;
    private Boolean gender;
    private String phone;
    public Person() {
        this.ID = 0;
        this.name = "";
        this.gender = true;
        this.phone = "";
    }
    public Person(int iD, String name, Boolean gender, String phone) {
        ID = iD;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }
    
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getGender() {
        return gender;
    }
    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Person [ID=" + ID + ", name=" + name + ", gender=" + gender + ", phone=" + phone + "]";
    }
    
}
