package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
 static Connection connection=null;
 //Cannot make a static reference to the non-static field connection
	public static Connection getDBConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=	
				DriverManager.
				getConnection("jdbc:mysql://localhost:3306/StudentRecord","root","root@123");
			}catch(Exception e)
		{
			System.out.println(e);		
		}
		return connection;
	}
	

}
