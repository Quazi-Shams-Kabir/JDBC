import java.sql.*; // java.sql package contains all the classes and interfaces required for jdbc

/*
 * 1. Import the package - java.sql
 * 2. Load and Register the Driver - com.mysql.jdbc.Driver (Type 4 Driver) (for mysql)
 * 3. Establish the connection - Connection (Interface)
 * 4. Create the statement - Statement (Interface)
 * 5. Execute the query - ResultSet (Interface)
 * 6. Process the results
 * 7. Close
 */

/*
 DAO: Data Access Objcet
 basically a interface that provides access to an underlying database 
 we need that for desiging advance softwares, so that if any problem occur we can edit 
 the DAO not full code  
 */

public class JdbcFetchDemo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/shams";
        String username = "root";
        String password = "sqlsqlDemo@1";
        // String query = "select sname from student where rollno =2"; // for particular
        // column
        String query = "select * from student";

        Class.forName("com.mysql.cj.jdbc.Driver"); // load and register the driver
        Connection con = DriverManager.getConnection(url, username, password); // establish the connection
        Statement st = con.createStatement(); // create the statement
        ResultSet rs = st.executeQuery(query); // execute the query , ResultSet is an interface to store data in tabular
                                               // form

        // rs.next(); // moves the cursor to the next row
        // String name = rs.getString("sname"); // get the value of the column
        // System.out.println(name);
        // String userData = rs.getInt(1) + " | " + rs.getString(2);
        // System.out.println(userData); // for a single line
        // For the whole table we will use while loop
        // rs.next() will move the pointer to next column if there is else false

        while (rs.next()) {
            String userData = rs.getInt(1) + " | " + rs.getString(2);
            System.out.println(userData);
        }

        st.close();
        con.close();
    }
}
