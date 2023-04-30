import java.sql.*;

public class JdbcDAO_1 {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Student s1 = dao.getStudent(2); // getting Student type from getStudent of dao
        System.out.println(s1.sname);
    }
}

//creating DAO for fetching details
class StudentDAO {
    public Student getStudent(int rollno) { // return Student type
        Student s = new Student();
        s.rollno = rollno;
        try {
            String query = "select sname from student where rollno=" + rollno;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shams", "root", "sqlsqlDemo@1");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next(); // coz the pointer by default will point to topmost column
            String name = rs.getString(1);
            s.sname = name;
            return s;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}

//creating Student class
class Student {

    int rollno;
    String sname;
}
