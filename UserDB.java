package xyc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDB{
	public static String getIconPath(String id){
		String result = null;								 
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;					
		try{
			conn = getConnection();							
			if(conn!=null){									
				sql="select icon_path from users where user_name='"+id+"';";
				stmt=conn.createStatement();				
				rs=stmt.executeQuery(sql);					
				if(rs.next()){result = rs.getString(1);}			
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
		return result;		
	}
	
	public static String changeIconPath(String id,String path){//改用户头像
		String result="fail";								 
		Connection conn=null;Statement stmt=null;			 
		int rs=0;String sql=null;					
		try{
			conn = getConnection();							
			if(conn!=null){									
				sql="update users set users.address = '"+path+"' where user_id = '"+id+"';";
				stmt=conn.createStatement();				
				rs=stmt.executeUpdate(sql);					
				if(rs>0){result="success";}			
			}}
		catch(SQLException e){e.printStackTrace();}			
		finally{
			try{
						
				if(stmt!=null){stmt.close();stmt=null;}		
				if(conn!=null){conn.close();conn=null;}		
			}
			catch(SQLException e){e.printStackTrace();}		
		}
		return result;		
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