// for no. of values we dont know, we use prepared statement

import java.sql.*;

public class JdbcPreparedSt {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/shams";
        String username = "root";
        String pass = "sqlsqlDemo@1";
        int userId = 6;
        String uname = "QSK";
        // for values setting dynamically we will use Prepared Statment, here is the
        // syntax along with query
        String query = "insert into student values (?,?)"; // no. of ? = no. of args

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, pass);
        PreparedStatement pStatement = con.prepareStatement(query); // pass the query only here
        pStatement.setInt(1, userId);
        pStatement.setString(2, uname);
        int count = pStatement.executeUpdate();
        System.out.println(count + " row/s affected");

        pStatement.close();
        con.close();
    }
}
