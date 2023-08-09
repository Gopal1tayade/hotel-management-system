package hotel.management.system;
import java.sql.*;

public class Connection_ {
    Connection c;
    Statement s;
    Connection_(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","gopal@9881");
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
