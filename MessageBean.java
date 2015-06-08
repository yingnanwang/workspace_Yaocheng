package xyc;

public class MessageBean {
	private String reciver;
	private String[] message_id;
	private String[] contents;
	private String[] sender_id;
	private String[] time;
	
	public void getReciver(String rec){
		this.reciver = rec;
	}
	public  String[] getMesID(){
		return this.message_id;		
	}
	public String[] getContents(){
		return this.contents;
	}
	public String[] getSender(){
		return this.sender_id;
	}
	public String[] getTime(){
		return this.time;
	}
	
	public String add(String mid,String cont,String sender,String receiver,String time){
		String result = "fail";
		result = MessageDB.insertMessage(mid, cont, sender, receiver, time);
		return result;
	}
	
	public void selectMID(String recv){
		message_id = MessageDB.getID(recv);
	}
	public void selectCon(String recv){
		contents = MessageDB.getContent(recv);
	}
	public void selectSender(String recv){
		sender_id = MessageDB.getSender(recv);
	}
	public void selectTime(String recv){
		time = MessageDB.getTime(recv);
	}
}
