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
	public static String[]getID(String uid){//通过用户id得到图片id数组

		String []result = null;
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from pictures where user_name='"+uid+"';";
				stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=stmt.executeQuery(sql);	
				 int count = 0;
			        try {
			        	rs.last();
			            count = rs.getRow();
			        } catch (Exception e) {
			            // TODO: handle exception
			            e.printStackTrace();
			        }
			        rs.first();
			        
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
	
	public static String[]getTitle(String uid){//通过用户id得到图片标题数组

		String []result = null;
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from pictures where user_name='"+uid+"';";
				stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=stmt.executeQuery(sql);	
				 int count = 0;
			        try {
			        	rs.last();
			            count = rs.getRow();
			        } catch (Exception e) {
			            // TODO: handle exception
			            e.printStackTrace();
			        }
			        rs.first();
			        
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
	
	public static String[]getPath(String uid){//通过用户id得到图片路径数组

		String []result = null;
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from pictures where user_name='"+uid+"';";
				stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=stmt.executeQuery(sql);	
				 int count = 0;
			        try {
			        	rs.last();
			            count = rs.getRow();
			        } catch (Exception e) {
			            // TODO: handle exception
			            e.printStackTrace();
			        }
			        rs.first();
			        
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
	
	public static int[]getFav(String uid){//通过用户id得到图片点赞数组

		int []result = null;
		Connection conn=null;Statement stmt=null;			 
		ResultSet rs=null;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="select * from pictures where user_name='"+uid+"';";
				stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);				
				rs=stmt.executeQuery(sql);	
				 int count = 0;
			        try {
			        	rs.last();
			            count = rs.getRow();
			        } catch (Exception e) {
			            // TODO: handle exception
			            e.printStackTrace();
			        }
			        rs.first();
			        
				if(count != 0){
					result = new int[count];
					int i = 0;
					while(rs.next()){
						result[i] = rs.getInt(4);
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
	
	public static String setFav(String pic_id,int fav){//根据图片id修改点赞次数
		String result = "fail";
		Connection conn=null;Statement stmt=null;			 
		int rs=0;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="update pictures set pictures.favourite = "+fav+" where picture_id = '"+pic_id+"';";
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
	
	public static String deletePic(String pic_id){//根据图片id删除
		String result = "fail";
		Connection conn=null;Statement stmt=null;			 
		int rs=0;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="delete pictures where picture_id = '"+pic_id+"';";
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
	
	public static String addPic(String pic_id,String pic_title,String uid,int fav,String path){//插入新条目
		String result = "fail";
		Connection conn=null;Statement stmt=null;			 
		int rs=0;String sql=null;
		try{
			conn=getConnection();							
			if(conn!=null){									
				sql="insert into pictures values('"+pic_id+"','"+pic_title+"','"+uid+"',"+fav+",'"+path+"');";
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
