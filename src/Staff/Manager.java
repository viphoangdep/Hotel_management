package Staff;
import Service.Service;
import Utility.*;
import main.Hotel;
import java.sql.*;

public class Manager extends Employee {
    

    public Manager(int iD, String name, Boolean gender, String phone, String job, int unitTasks, double salary,
            Boolean status, Service task) {
        super(iD, name, gender, phone, job, unitTasks, salary, status, task);
    }

    public Manager() {
        super();
    }
    public void addEmployee(Employee employee){
        Hotel.getEmployees().add(employee);
        // Add employee to database
        Connection connection = null;
        try {
            connection = DatabaseUtil.openConnection();
            String query = "INSERT INTO employees ( name, phone, gender, job) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPhone());
            preparedStatement.setBoolean(3, employee.getGender());
            preparedStatement.setString(4, employee.getJob());
            preparedStatement.executeUpdate();
            System.out.println("Employee added successfully");
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
}
    
}

}
public void addService(Service service){
    // Add service to database
    Connection connection = null;
    try {
        connection = DatabaseUtil.openConnection();
        String query = "INSERT INTO services ( name, price) VALUES (?, ?);";
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, service.getName());
        preparedStatement.setDouble(2, service.getPrice());
        preparedStatement.executeUpdate();
        System.out.println("Service added successfully");
        Hotel.getServices().add(service);
} catch (java.sql.SQLException e) {
    e.printStackTrace();
} finally {
    try {
        connection.close();
    } catch (java.sql.SQLException e) {
        e.printStackTrace();

}  
}
}
    public static void main (String[] args){
        Manager manager = new Manager();
        Employee employee = new Employee(1, "Lee", true, "1234526789", "Receptionist", 1, 1000, true, null);
        manager.addEmployee(employee);
    }
}
