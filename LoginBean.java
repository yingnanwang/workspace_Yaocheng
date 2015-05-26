package xyc;

public class LoginBean {
	private String uid;      		
	private String pwd;      		
		
	private String name;
	private String sex;
	private String age;
	private String tel;
	private String address;
	private String email;
	private String icon_path;
	
	public void setUid(String uid){this.uid=uid;}   
	public String getUid(){return this.uid;}     	 
	public void setPwd(String pwd){this.pwd=pwd;}	
	public String getPwd(){return this.pwd;}		
	
	public void setName(String name){this.name = name;}
	public String getName(){return this.name;}    
	
	public void setSex(String sex){this.sex = sex;}
	public String getSex(){return this.sex;}    
	
	public void setTel(String tel){this.tel = tel;}
	public String getTel(){return this.tel;}    
	
	public void setAge(String age){this.age = age;}
	public String getAge(){return this.age;}    
	
	public void setAddress(String address){this.address = address;}
	public String getAddress(){return this.address;}    
	
	public void setEmail(String email){this.email = email;}
	public String getEmail(){return this.email;}    
	
	public void setIcon_path(String icon_path){this.icon_path = icon_path;}
	public String getIcon_path(){return this.icon_path;}    	
	
	public String verify(){							 
		String result="fail";						 			
			//LoginDB.getConnection();
			result=LoginDB.Login(uid,pwd);						  
			
			return result;								  
	}
	
	public String register(){
		String result="fail";
		
		result = LoginDB.Register(uid, pwd, name, sex, age, tel, address, email, icon_path);
		
		return result;
	}
}
