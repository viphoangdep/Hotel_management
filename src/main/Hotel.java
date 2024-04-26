package main;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Staff.*;
import Utility.DatabaseUtil;
import Service.Service;
public final class Hotel {
    private String name = "Hoang Long Hotel";
    private String address = "123 Nguyen Van Linh, Da Nang";
    private String phone = "0123456789";

    private static ArrayList<Employee> employees ;
    private static ArrayList<Service> services ;
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
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            // 1. Get a connection to the database
            Connection connection = DatabaseUtil.openConnection();

            // 2. Create a statement
            Statement myStmt = connection.createStatement();

            // 3. Execute SQL query
            ResultSet myRs = myStmt.executeQuery("select * from employees");

            // 4. Process the result set
            while (myRs.next()) {
                Employee employee = new Employee();
                // Assuming Employee has id, name, and phone properties
                employee.setID(myRs.getInt("id"));
                employee.setName(myRs.getString("name"));
                employee.setPhone(myRs.getString("phone"));
                employee.setGender(myRs.getBoolean("gender"));
                employee.setJob(myRs.getString("job"));
                employee.toString();
                employees.add(employee);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return employees;
    }

    public void setEmployees(ArrayList<Employee> new_employees) {
        employees = new_employees;
    }
    public static ArrayList<Service> getServices() {
        ArrayList<Service> services = new ArrayList<>();
        try {
            // 1. Get a connection to the database
            Connection connection = DatabaseUtil.openConnection();

            // 2. Create a statement
            Statement myStmt = connection.createStatement();

            // 3. Execute SQL query
            ResultSet myRs = myStmt.executeQuery("select * from services");

            // 4. Process the result set
            while (myRs.next()) {
                Service service = new Service();
                // Assuming Service has id, name, and price properties
                service.setId(myRs.getInt("id"));
                service.setName(myRs.getString("name"));
                service.setPrice(myRs.getDouble("price"));
                services.add(service);
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return services;
    }      
    
}
