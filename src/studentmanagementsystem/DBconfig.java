
package studentmanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBconfig {
    private static DBconfig instance;
    
    private DBconfig(){
    }
    
    static synchronized DBconfig getInstance(){
        if(instance==null){
            instance=new DBconfig();
        }
        return instance;
    }
    
      public Connection dbConnection () throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://127.0.0.1:3306/devAcademy";
        String user="root";
        String password="Thanu@321";
         Connection con=DriverManager.getConnection(url,user,password);
         return con;
    }
      
    
    
}
