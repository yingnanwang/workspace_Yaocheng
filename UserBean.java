package xyc;

public class UserBean {
	private String uid;
	private String path;
	
	public void setUID(String uid){this.uid = uid;}
	public String getPath(){return this.path;}
	
	public void selectPath(){
		path = UserDB.getIconPath(uid);
	}
	
	public String changePath(String path){
		return UserDB.changeIconPath(uid, path);
	}
}
