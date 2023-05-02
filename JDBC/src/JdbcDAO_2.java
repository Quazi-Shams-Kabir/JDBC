import java.sql.*;

public class demo {
    public static void main(String[] args) throws Exception {
        StudentDao1 dao1 = new StudentDao1();
        Student1 s2 = new Student1();
        s2.rollno = 8;
        s2.sname = "Demo";
        dao1.connect();
        dao1.addStudent(s2);
//        dao1.getStudent(8);
//        System.out.println(s2.sname);
    }
}

class StudentDao1 {
    Connection con = null;

    public void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shams", "root", "sqlsqlDemo@1");
    }

    public Student getStudent(int rollno) { // return Student type
        Student s = new Student();
        s.rollno = rollno;
        try {
            String query = "select sname from student where rollno=" + rollno;
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

    public void addStudent(Student1 s) throws Exception {
        String query = "insert into student values (?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, s.rollno);
        preparedStatement.setString(2, s.sname);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        con.close();
    }
}

class Student1 {
    int rollno;
    String sname;
}
