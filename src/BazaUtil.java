import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BazaUtil {
    static Connection con;
    public static void getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is ok");
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "12345678";

        try {
            con = DriverManager.getConnection(url, user, password);
            if (con != null)
                System.out.println("Connection sucess");
            else
                System.out.println("No connection");
        } catch (SQLException throwables) {
            System.out.println("Mistake !");
        }
    }


    public static void insertEmployee (Employees employees) throws SQLException {
        String query = "insert into employees" + "(id, name, age, address, income)" + "values (?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, employees.getId());
        st.setString(2, employees.getName());
        st.setInt(3, employees.getAge());
        st.setString(4, employees.getAddress());
        st.setDouble(5, employees.getIncome());
        st.execute();
    }

    public static List<Employees> readEmployees () throws SQLException {
        List list = new ArrayList();
        Statement st = con.createStatement();
        String query = "select * from employees";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String adress = rs.getString("address");
            double income = rs.getDouble("income");
            Employees employees = new Employees(id,name,age,adress,income);
            list.add(employees);
        }
        st.close();

        return list;
    }


    public static void updateEmployees (Employees employees) throws SQLException {
        String query = "update employees set age=?, address=?, income=? where id = ?";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, employees.getAge());
            st.setString(2, employees.getAddress());
            st.setDouble(3, employees.getIncome());
            st.setInt(4, employees.getId());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployees (Employees employees) throws SQLException {
        String query = "delete from employees where id = ?";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, employees.getId());
            st.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


