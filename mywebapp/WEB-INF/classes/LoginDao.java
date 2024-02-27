import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class LoginDao { // Renamed to match the usage in JSP
    public boolean validate(String username, String date) {
        boolean status = false;
        try {
            // Ensure you have the MySQL JDBC driver in your classpath
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://abcd2.czo24aow0bnr.eu-north-1.rds.amazonaws.com:3306/wt", "abcd2", "adityacc");
                 PreparedStatement ps = con.prepareStatement(
                         "select * from users where username=? and date=?")) {

                ps.setString(1, username);
                ps.setString(2, date);

                try (ResultSet rs = ps.executeQuery()) {
                    status = rs.next();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
