package xyc;

public class PictureBean {
	private String uid;
	private String[] pic_path;
	
	public void setUid(String uid){this.uid = uid;}
	public String getUid(){return this.uid;}
	
	public String[] getPicPath(){return this.pic_path;}
	
	public void selectPic(){
		pic_path = PictureDB.selectPic(this.uid);
	} 
}
