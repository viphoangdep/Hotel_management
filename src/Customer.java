import Utility.*;
import Room_management.*;
import Service.*;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Customer extends Person{
    private List<Room> bookedRooms  ;
    private List<Service> bookedService;
    private int rate;
    //Constructor
    
    
    public Customer(List<Room> bookedRooms, List<Service> bookedService) {
        this.bookedRooms = bookedRooms;
        this.bookedService = bookedService;
    }
    public Customer(int iD, String name, Boolean gender, String phone, List<Room> bookedRooms,
            List<Service> bookedService) {
        super(iD, name, gender, phone);
        this.bookedRooms = bookedRooms;
        this.bookedService = bookedService;
    }
    //Geter and Setter method
    public List<Room> getBookedRooms() {
        return bookedRooms;
    }
    
    public void setBookedRooms(List<Room> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }
    public List<Service> getBookedService() {
        return bookedService;
    }
    public void setBookedService(List<Service> bookedService) {
        this.bookedService = bookedService;
    }
    public int getRate() {
        return rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }
    // Method
    public void bookRoom(Room room){
        if (!room.isAvailable()){
            System.out.println("Room is not available");
            return;
        }
        else{
            this.bookedRooms.add(room);
        Connection connection = null;
        
        try {
            connection = DatabaseUtil.openConnection();
            String query = "INSERT INTO booking_rooms (room_id, customer_id, num_of_days,check_in_date)"+
                            "VALUES(?, ?, ?, ?);";          
    
            try (PreparedStatement preparedStatementCustomer = connection.prepareStatement(query)) {
                preparedStatementCustomer.setInt(1, room.getRoom_id());
                preparedStatementCustomer.setInt(2, this.getID());
                preparedStatementCustomer.setInt(3, room.getNumOfDay());
                
                preparedStatementCustomer.setDate(4, Date.valueOf(room.getCheck_in_date()));
                preparedStatementCustomer.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace(); // Xử lý ngoại lệ nếu có
            }
            
            // Kiểm tra loại phòng và cập nhật thông tin trong bảng tương ứng
        
                String querySuiteRoom = "UPDATE rooms " +
                                        "SET is_available = false "+
                                        "WHERE id = ?;";
                try (PreparedStatement preparedStatementSuiteRoom = connection.prepareStatement(querySuiteRoom)) {
                    preparedStatementSuiteRoom.setInt(1,room.getRoom_id() );
                    preparedStatementSuiteRoom.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace(); // Xử lý ngoại lệ nếu có
                }
            
            
                
                
            
    
            System.out.println("Add room successfully");
        } finally {
            DatabaseUtil.closeConnection(connection);
        }
        }
        
    }
    

    public void bookService(Service service){
        this.bookedService.add(service);
        
        Connection connection = null;

        try {
            connection = DatabaseUtil.openConnection();
            String queryService =  "INSERT INTO booking_services (service_id, customer_id)"+
                                    "VALUES(?, ?);";
            try (PreparedStatement preparedStatementCustomer = connection.prepareStatement(queryService)) {
                preparedStatementCustomer.setInt(1, service.getId());
                preparedStatementCustomer.setInt(2, this.getID());
                preparedStatementCustomer.executeUpdate();
                System.out.println("Add service successfully");
            } catch (SQLException e) {
                e.printStackTrace(); // Xử lý ngoại lệ nếu có
            }     
        } finally {
            
            DatabaseUtil.closeConnection(connection);
        }
    }
    public static void main(String[] args) {
        // Tạo một đối tượng Customer
        Customer customer = new Customer(1, "Nguyen Van A", true, "0123456789", new ArrayList<Room>(), new ArrayList<Service>());
        // Tạo một đối tượng Room
        Room room = new SuiteRoom(1, 100, "2021-01-30", 3, 2, true, "TV, Air conditioner", 2);
        // Tạo một đối tượng Service, Lấy dữ liệu từ database Service
        
        
        Service service = new Service(1, "Service 1");
        
        // Gọi phương thức bookRoom
        customer.bookRoom(room);
        // Gọi phương thức bookService
        customer.bookService(service);
    }

}
