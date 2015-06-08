package xyc;

public class PictureBean {
	private String uid;
	private String[] pic_path;
	private int[]fav;
	private String[] title;
	private String[] pic_id;
	
	public void setUid(String uid){this.uid = uid;}
	
	public String getUid(){return this.uid;}
	public String[] getPicPath(){return this.pic_path;}
	public String[] getPicID(){return this.pic_id;}
	public int[] getPicFav(){return this.fav;}
	public String[] getTitle(){return this.title;}
	
	public void selectID(){
		pic_id = PictureDB.getID(this.uid);
	} 
	
	public void selectTitle(){
		title = PictureDB.getTitle(this.uid);
	}
	
	public void selectPath(){
		pic_path = PictureDB.getPath(this.uid);
	}
	
	public void selectFav(){
		fav = PictureDB.getFav(this.uid);
	}
	
	public String delete(String picID){
		if(PictureDB.deletePic(picID).compareTo("success")==0)
			return "success";
		else return "fail";
	}
	
	public String setFav(String picID,int fav){
		if(PictureDB.setFav(picID, fav).compareTo("success")==0)
			return "success";
		else return "fail";
	}
	
	public String add(String picID,String title,String uid,int fav,String path){
		if(PictureDB.addPic(picID, title, uid, fav, path).compareTo("success")==0)
			return "success";
		else return "fail";
	}
}
