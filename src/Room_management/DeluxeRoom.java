package Room_management;
import java.sql.*;

import Utility.DatabaseUtil;
public class DeluxeRoom extends Room{
    private String furniture ;
    private int numOfUnit;
    
    public DeluxeRoom() {
        super();
        this.furniture = "";
        this.numOfUnit = 0;
    }
    public DeluxeRoom(int room_id, double price,String check_in_date, int numOfDay, int numOfBed, boolean isAvailable, String furniture,
            int numOfUnit) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable);
        this.furniture = furniture;
        this.numOfUnit = numOfUnit;
    }
    public String getFurniture() {
        return furniture;
    }
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }
    public int getNumOfUnit() {
        return numOfUnit;
    }
    public void setNumOfUnit(int numOfUnit) {
        this.numOfUnit = numOfUnit;
    }
    public double calculatePrice(){
        return this.getNumOfDay()*this.getPrice();
    };
    // Import data into Database
    public void importToDatabase() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseUtil.openConnection();
            String query = "INSERT INTO Deluxe_room (room_id, price, numOfDay, numOfBed, isAvailable, furniture, numOfUnit) VALUES(?, ?, ?, ?, ?, ?, ?)";
            
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, this.getRoom_id());
            preparedStatement.setDouble(2, this.getPrice());
            preparedStatement.setInt(3, this.getNumOfDay());
            preparedStatement.setInt(4, this.getNumOfBed());
            preparedStatement.setBoolean(5, this.isAvailable());
            preparedStatement.setString(6, this.getFurniture());
            preparedStatement.setInt(7, this.getNumOfUnit());
    
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Add successfully");
            } else {
                System.out.println("Failed to add data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng PreparedStatement và Connection
            DatabaseUtil.closeConnection(connection);
        }
    }
    public static void main(String[] args) {
        // Tạo một đối tượng DeluxeRoom
        DeluxeRoom room = new DeluxeRoom(101, 100.0,"27/04/2024", 3, 2, true, "Bed, Sofa, Table", 2);
        
        // Gọi phương thức importToDatabase để thêm dữ liệu vào cơ sở dữ liệu
        room.importToDatabase();
    }
}
