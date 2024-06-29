package studentmanagementsystem;
import java.sql.*;
import java.util.*;


public class StudentManagementSystem {
    private static DBconfig dbconfig = DBconfig.getInstance();
    
    
    public static void dashboard() throws Exception{
        Scanner s=new Scanner(System.in);
        System.out.println("---------------------------------------------------------");
        System.out.println("  Welcome to Developers Stack Student Management System  ");
        System.out.println("---------------------------------------------------------\n");
        System.out.println("1 Insert New Student");
        System.out.println("2 Delete Student");
        System.out.println("3 View All Student");
        System.out.println("4 Log Out");
        
        System.out.println("Enter Your Choice : ");
        int choice=s.nextInt();
        
        switch (choice){
            case 1:
                insertStudent();
                break;
            case 2:
                deleteStudent();
                break;
            case 3:
                getAllStudent();
                break;    
            case 4:
                logout();
                break;
            default:
                System.out.println("Invalid Choice Try Again!!");
                System.out.println("\033[H\033[2J");
                dashboard();
                break;
    }


                
    }
    
    public static void main(String[] args)throws Exception {
        dashboard();
    }
    
    public static void getAllStudent() throws Exception{
        System.out.println("-------------------");
        System.out.println(" VIEW ALL STUDENTS ");
        System.out.println("-------------------\n");
        String sql = "SELECT * FROM Student";
        try(Connection con=dbconfig.dbConnection()){
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            String name="";
            while( rs.next())
            {
            name=rs.getString("name");
            System.out.println(name);
            }
        }
            System.out.println("\033[H\033[2J");
            dashboard();
    }

    public static void insertStudent() throws Exception{
        System.out.println("--------------------");
        System.out.println(" INSERT NEW STUDENT ");
        System.out.println("--------------------\n");
        
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Your Name? ");
        String name=s.nextLine();
        
        System.out.println("Enter Your Age? ");
        int age=s.nextInt();
        
        System.out.println("Enter Your Department? ");
        String department=s.nextLine();
        
        System.out.println("Enter Your District? ");
        String district=s.nextLine();
        
        System.out.println("Enter Your NIC? ");
        String nic=s.nextLine();
        
        System.out.println("Enter Your Gender? ");
        String gender=s.nextLine();
        
        String sql = "INSERT INTO Student (name,age,department,district,nic,gender)" + "VALUES (?,?,?,?,?,?)";
        
        try (Connection con=dbconfig.dbConnection() ) {
        
        PreparedStatement ps=con.prepareStatement(sql);
            ps .setString(1,name);
            ps .setInt(2,age);
            ps .setString(3,department);
            ps .setString(4,district);
            ps .setString(5,nic);
            ps .setString(6,gender);
       
       int row=ps.executeUpdate();
       System.out.println(row);
       }
       catch (Exception e){
       System.out.println(e);
       }
       dashboard();
       
    }
    
    public static void deleteStudent()throws Exception {
        System.out.println("-----------------");
        System.out.println(" DELETE STUDENTS ");
        System.out.println("-----------------\n");
        Connection con=dbconfig.dbConnection();
        int id=2;
        String sql="DELETE FROM STUDENT WHERE student_ID=?";
    
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        int row =st.executeUpdate();
        System.out.println(row);
        dashboard();
    }
    
    
    public static void logout() throws Exception{
        System.out.println("Logging Out......!!!!!!");
    }
   
    
 
}
      




