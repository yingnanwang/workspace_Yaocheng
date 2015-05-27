package xyc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PictureDB {
	public static String[]selectPic(String uid){

		String []result = null;
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from pictures where user_name='"+uid+"';";
				stmt=conn.createStatement();				
				rs=stmt.executeQuery(sql);	
				int count = rs.getRow();
				if(count != 0){
					result = new String[count];
					int i = 0;
					while(rs.next()){
						result[i] = rs.getString(1);
						i++;
					}
					return result;
				}
				else return null;
			}}
		catch(SQLException e){e.printStackTrace();}			
		finally{
			try{
				if(rs!=null){rs.close();rs=null;}			
				if(stmt!=null){stmt.close();stmt=null;}		
				if(conn!=null){conn.close();conn=null;}		
			}
			catch(SQLException e){e.printStackTrace();}		
		}
		return null;
	}
	
	public static Connection getConnection(){				
		Connection conn=null;								
		try{
			Context initial=new InitialContext();			
			DataSource ds=(DataSource)initial.lookup("java:comp/env/jdbc/pic_manager");
			conn=ds.getConnection();						
		}
		catch(NamingException e){e.printStackTrace();}		
		catch(SQLException e){e.printStackTrace();}			
		return conn;										
	}
}
