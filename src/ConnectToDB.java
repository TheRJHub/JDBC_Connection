import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDB {
    public static void main(String[] args) {
        try {
            //1st step: load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");//create obj for class-internally it is using reflexion api
            //class.forname()-unchecked exception- so ClassNotFoundException is there
            //2nd step: establish connection
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava?user=root && password=rajat");//this is a static query ?-task, what is sql injection ?
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "rajat123");
           //getConnection()-return type is connection
            System.out.println(connection);
            String sql="insert into student (sid,name,percentage) VALUES (2,'Razz',97.2),(3,'RRR',77.2),(4,'Raj',67.2)";
            //String sql="alter table student add column age int";
//            String sql="alter table student rename to students";
            //String sql="drop table students";
            Statement stmt =connection.createStatement();
            //3rd step: To Execute query
            stmt.execute(sql);
            //close connection
            connection.close();
            System.out.println("Driver class loaded...");
        }catch (ClassNotFoundException c){
            System.out.println("Class Not exist");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//factory design pattern