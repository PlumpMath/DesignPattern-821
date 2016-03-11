package designParttens.singletion;

import java.util.ArrayList;
import java.util.Random;

public class Singleton {
	public static void main(String[] args) {
//		for(int day=0;day<3;day++){
//			Emperor em=Emperor.getInstance();			
//			em.say();
//		}
		for(int i=1;i<5;i++){
			Emperors es=Emperors.getInstance();
			System.out.println("第"+i+"个人拜");
			es.say();
		}
	}
}
class Emperor{
	//懒汉式
//	private final static Emperor em=new Emperor();
//	private Emperor(){};
//	public static Emperor getInstance(){
//		return em;
//	}
	//饿汉式，有并发性，关键字修饰
	private static Emperor em=null;
	private Emperor(){};
	public synchronized static Emperor getInstance(){
		if(em==null){
			em=new Emperor();
		}
		return em;
	}
	public  void say(){
		System.out.println("i am s");
	}
}
//多例模式
class Emperors{
	private static int MaxEmp=2;
	private static int count=0;
	
	private static ArrayList<String> nameList=new ArrayList<String>();
	private static ArrayList<Emperors> empList=new ArrayList<Emperors>();
	
	private Emperors(){};
	private Emperors(String _name){
		nameList.add(_name);
	}
	static{
		for(int i=0;i<MaxEmp;i++){
			empList.add(new Emperors("皇帝"+i));
		}
	}
	public static Emperors getInstance(){
		Random r=new Random();
		count=r.nextInt(MaxEmp);
		return empList.get(count);
	}
	public void say(){
		System.out.println(nameList.get(count));
	}
}