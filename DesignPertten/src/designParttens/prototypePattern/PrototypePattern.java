package designParttens.prototypePattern;

import java.util.Random;



public class PrototypePattern {
	private static final int MAX_COUNT=6;
	public static void main(String[] args) {
		int i=0;
		Mail mail=new Mail(new AdvTemplate());
		mail.setTail("XX银行所有");
		while(i<MAX_COUNT){
			Mail cloneMail=mail.clone();
			cloneMail.setAppellation(getRandString(5)+"先生/女士");
			cloneMail.setReceiver(getRandString(5)+"@"+getRandString(8)+".com");
			sendMail(cloneMail);
			i++;
		}
		
	}
	public static String getRandString(int maxLength){
		String source="abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb=new StringBuffer();
		Random rd=new Random();
		for(int i=0;i<maxLength;i++){
			sb.append(source.charAt(rd.nextInt(source.length())));
		}
		return sb.toString();
	}
	public static void sendMail(Mail mail){
		System.out.println("标题:"+mail.getSubject()+"\t收件人:"+mail.getReceiver()+"\t..发送成功");
	}
}
class Mail implements Cloneable{
	private String receiver;
	private String subject;
	private String appellation;
	private String context;
	private String tail;
	public Mail(AdvTemplate advTemple){
		this.subject=advTemple.getAdvSubject();
		this.context=advTemple.getAdvContext();
	}
	public Mail clone(){
		Mail mail=null;
		try{
			mail=(Mail)super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return mail;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAppellation() {
		return appellation;
	}
	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getTail() {
		return tail;
	}
	public void setTail(String tail) {
		this.tail = tail;
	}
	
}
class AdvTemplate{
	private String advSubject="XX信用卡抽奖活动";
	private String advContext="只要刷卡就送100万";
	public String getAdvSubject() {
		return this.advSubject;
	}
	
	public String getAdvContext() {
		return this.advContext;
	}
	
	
	
}