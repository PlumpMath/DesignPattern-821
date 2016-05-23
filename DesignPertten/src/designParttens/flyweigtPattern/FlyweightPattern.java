package designParttens.flyweigtPattern;

import java.util.HashMap;

public class FlyweightPattern {
	public static void main(String[] args) {
		for(int i=0;i<4;i++){
			String subject="subject"+i;
			for(int j=0;j<30;j++){
				String key=subject+"postAddress"+j;
				SignInfoFactory.getSignInfo(key);
			}
		}
		SignInfo signInfo=SignInfoFactory.getSignInfo("subject1postAddress1");
		
	}
}
class SignInfo{
	private String id;
	private String location;
	private String subject;
	private String postAddress;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPostAddress() {
		return postAddress;
	}
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}	
}
class SignInfoPool extends SignInfo{
	private String key;
	public SignInfoPool(String _key){
		this.key=_key;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}	
}
class SignInfoFactory{
	private static HashMap<String,SignInfo> pool=new HashMap<String,SignInfo>();

	public static SignInfo getSignInfo(String key){
		SignInfo result=null;
		if(!pool.containsKey(key)){
			System.out.println(key+"put into pool");
			result=new SignInfoPool(key);
			pool.put(key, result);
			
		}else{
			result=pool.get(key);
			System.out.println(key+"get from the pool");
		}
		return result;
	}
}

