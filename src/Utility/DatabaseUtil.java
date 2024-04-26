package Utility;
import java.sql.*;





public final class DatabaseUtil {

    private DatabaseUtil() {
        // Private constructor để ngăn chặn việc khởi tạo đối tượng của lớp
    }

    public static Connection openConnection() {
        Connection connection = null;
        try {
            // Thiết lập thông tin kết nối
            String url = "jdbc:postgresql://localhost:5432/Bill_coffe_machine";
            String username = "sa";
            String password = "1234";

            // Thiết lập kết nối
            connection = DriverManager.getConnection(url, username, password);

            // Kiểm tra kết nối đã thành công chưa
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to connect to the PostgreSQL server.");
            }
        } catch (SQLException e) {
            // Xử lý lỗi kết nối
            e.printStackTrace();
        }
        return connection;
    }

    public static void executeQuery(Connection connection, String query) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);

            // Thực thi truy vấn và lấy kết quả
            resultSet = preparedStatement.executeQuery();

            // Thực hiện các thao tác với cơ sở dữ liệu ở đây
            while (resultSet.next()) {
                int column1Value = resultSet.getInt("id");
                String column2Value = resultSet.getString("name");
                int column3Value = resultSet.getInt("age");
                // Xử lý dữ liệu ở đây
                // Ví dụ: In giá trị của column1 và column2
                System.out.println("Column1: " + column1Value + ", Column2: " + column2Value + ",Column3: " + column3Value );
            }
        } catch (SQLException e) {
            // Xử lý lỗi kết nối
            e.printStackTrace();
        } finally {
            // Đóng PreparedStatement và ResultSet
            closeStatementAndResultSet(preparedStatement, resultSet);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatementAndResultSet(PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Mở kết nối đến cơ sở dữ liệu
        Connection connection = DatabaseUtil.openConnection();

        // Kiểm tra nếu kết nối thành công thì thực hiện truy vấn
        if (connection != null) {
            // Ví dụ về việc thực thi truy vấn
            String query = "SELECT * FROM test_table";
            DatabaseUtil.executeQuery(connection, query);

            // Sau khi hoàn thành công việc với cơ sở dữ liệu, đóng kết nối
            DatabaseUtil.closeConnection(connection);
        } else {
            System.out.println("Failed to open connection. Exiting...");
        }
    }
}