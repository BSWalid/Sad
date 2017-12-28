package logintest;


import java.sql.*;

public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public DBConnect() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/devfest", "root", "");
            st = con.createStatement();
        } 
        catch (Exception ex) 
        {
            System.out.println("Error: " + ex);
        }
    }    
    
    public ResultSet getData(String query) 
    {
        try 
        {
            rs= st.executeQuery(query);
            rs.next();
        } 
        catch(Exception ex) 
        {
            System.out.println("\n\n++++++++\n"+ex);
        }
        return rs;
    }
    
    public void setData(String query)
    {
        try 
        {
            st.executeUpdate(query);
        } 
        catch(Exception ex) 
        {
            System.out.println(ex);
        }
    }
}

