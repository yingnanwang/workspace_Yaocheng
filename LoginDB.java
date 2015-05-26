package xyc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDB {
	public static String Login(String uid,String pwd){
		String result="fail";								 
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;					
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from users where user_name='"+uid+"'"+
				" and password='"+pwd+"';";
				stmt=conn.createStatement();				
				rs=stmt.executeQuery(sql);					
				if(rs.next()){result="success";}			
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
	public static String uidDuplication(String uid){
		String result="fail";
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from users where user_name='"+uid+"';";
				stmt=conn.createStatement();				
				rs=stmt.executeQuery(sql);					
				if(rs.next()){result="fail";}
				else {result="success";}
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

	public static String Register(String uid,String pwd ,String name,String sex,String age,String tel,String address,String email,String icon_path){
		String result="fail";
		Connection conn=null;Statement stmt=null;			 
		String sql=null;	
		int i = 0;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="insert into users(user_name,password,name,sex,age,tel,address,email,icon_path) values('"+uid+"','"+pwd+"','"+name+"','"+sex+"','"+age+"','"+tel+"','"+address+"','"+email+"','"+icon_path+"');";
				stmt=conn.createStatement();				
				i=stmt.executeUpdate(sql);				
				if(i == 1){result="success";}			
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
