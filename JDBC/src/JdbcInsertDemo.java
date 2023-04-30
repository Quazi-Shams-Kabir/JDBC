import java.sql.*;

/*
 * when we use DDL of slq that is Data Definition Language we use executeQuery coz it returns resultSet
 * but when we use DML i.e. Data Manipulation Language we use executeUpdate coz it returns int (for how many row/s get affected)
 */
public class JdbcInsertDemo {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost:3306/shams";
        String userName = "root";
        String pass = "sqlsqlDemo@1";
        // String query = "insert into student values(4,'quazi')";  // For direct query
        // To fetch data from userid and username params
        int userId = 5;
        String uname = "abcd";
        String query = "insert into student values (" + userId + ",'" + uname + "')";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, pass);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query);

        System.out.println(count + " row/s affected");


    }
}
