package xyc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MessageDB {
	public static String insertMessage(String mid,String cont,String sender,String receiver,String time){//插入
		String result = "fail";
		Connection conn=null;Statement stmt=null;			 
		int rs=0;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="insert into messages values('"+mid+"','"+cont+"','"+sender+"','"+receiver+"','"+time+"');";
				stmt=conn.createStatement();				
				rs=stmt.executeUpdate(sql);	
				if(rs>0)
					result = "success";
				
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
	
	public static String[]getID(String receiver){//通过receiver id 得到消息id数组
		String []result = null;
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from messages where receiver='"+receiver+"';";
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
	
	public static String[]getContent(String receiver){//通过receiver id 得到消息contents数组
		String []result = null;
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from messages where receiver='"+receiver+"';";
				stmt=conn.createStatement();				
				rs=stmt.executeQuery(sql);	
				int count = rs.getRow();
				if(count != 0){
					result = new String[count];
					int i = 0;
					while(rs.next()){
						result[i] = rs.getString(2);
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
	
	public static String[]getSender(String receiver){//通过receiver id 得到sender id数组
		String []result = null;
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from messages where receiver='"+receiver+"';";
				stmt=conn.createStatement();				
				rs=stmt.executeQuery(sql);	
				int count = rs.getRow();
				if(count != 0){
					result = new String[count];
					int i = 0;
					while(rs.next()){
						result[i] = rs.getString(3);
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
	
	public static String[]getTime(String receiver){//通过receiver id 得到time数组
		String []result = null;
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from messages where receiver='"+receiver+"';";
				stmt=conn.createStatement();				
				rs=stmt.executeQuery(sql);	
				int count = rs.getRow();
				if(count != 0){
					result = new String[count];
					int i = 0;
					while(rs.next()){
						result[i] = rs.getString(5);
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
