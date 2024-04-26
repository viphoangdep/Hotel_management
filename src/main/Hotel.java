package main;
import java.util.*;
import Staff.*;
public final class Hotel {
    private String name;
    private String address;
    private String phone;

    private static ArrayList<Employee> employees = new ArrayList<Employee>();
    
    public Hotel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> new_employees) {
        employees = new_employees;
    }
    
    
}
