package designParttens.adapterPattern;

import java.util.HashMap;
import java.util.Map;

public class AdapterPattern {
	public static void main(String[] args) {		
		IUserInfo iu=new OuterUserInfo();
		iu.getUserName();
	}
}
interface IUserInfo{
	public String getUserName();
	public String getHomeAddress();
	public String getMobileTel();
	public String getOfficeTel();
	public String getJobPosition();
	public String getHomeTel();
}
interface IOuterUser{
	public Map<String,String> getUserBasicInfo();
	public Map<String,String> getUserOfferInfo();
	public Map<String,String> getHomeInfo();
 }
class OuterUser implements IOuterUser{
	public Map<String,String> getUserBasicInfo(){
		HashMap<String,String> hash=new HashMap<String,String>();
		hash.put("userName", "aaa");
		return hash;
	}
	public Map<String,String> getUserOfferInfo(){
		HashMap<String,String> hash=new HashMap<String,String>();
		hash.put("officeTel", "1111");
		return hash;
	}
	public Map<String,String> getHomeInfo(){
		HashMap<String,String> hash=new HashMap<String,String>();
		hash.put("HomeTel", "22222222");
		return hash;
	}
}

class OuterUserInfo extends OuterUser implements IUserInfo{
	private Map<String,String> basicInfo=super.getUserBasicInfo();
	private Map<String,String> officeInfo=super.getUserOfferInfo();
	private Map<String,String> homeInfo=super.getHomeInfo();
	public String getUserName(){
		String name=basicInfo.get("userName");
		System.out.println(name);
		return name;
	}
	@Override
	public String getHomeAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getMobileTel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getOfficeTel() {
		String officeT=officeInfo.get("officeTel");
		System.out.println(officeT);
		return officeT;
	}
	@Override
	public String getJobPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getHomeTel() {
		String homeTel=homeInfo.get("HomeTel");
		System.out.println(homeTel);
		return homeTel;
	}
}
