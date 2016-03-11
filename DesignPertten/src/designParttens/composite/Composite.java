package designParttens.composite;

import java.util.ArrayList;

public class Composite {
	public static void main(String[] args) {
		Branch ceo=compositeCropTree();
		System.out.println(ceo.getInfo());
		System.out.println(getTreeInfo(ceo));;
		
	}
	public static Branch compositeCropTree(){
		Branch root=new Branch("r","rrr",1);
		Branch del=new Branch("d","ddd",2);
		Branch sal=new Branch("s","sss",3);
		Leaf z=new Leaf("z","zzz",11);
		Leaf y=new Leaf("y","yyy",12);
		Leaf x=new Leaf("x","xxx",13);
		Leaf w=new Leaf("w","www",14);
		root.addSubordinate(del);
		root.addSubordinate(sal);
		del.addSubordinate(z);
		del.addSubordinate(y);
		sal.addSubordinate(x);
		sal.addSubordinate(w);
		return root;
	}
	public static String getTreeInfo(Branch branch){
		ArrayList<Crop> subordinateList=branch.getSubordinate();
		String info="";
		for(Crop c:subordinateList){
			if(c instanceof Leaf){
				info=info+c.getInfo()+"\n";
			}else{
				info=info+c.getInfo()+"\n"+getTreeInfo((Branch)c);
			}
		}
		return info;
	}
}
abstract class Crop{
	private String name="";
	private String position="";
	private int salary=0;
	public Crop(String _name,String _position,int _salary){
		this.name=_name;
		this.position=_position;
		this.salary=_salary;
	}
	public String getInfo(){
		String info="Name:"+this.name+" Position:"+this.position+" Salary:"+this.salary;
		return info;
	}
}
class Leaf extends Crop{

	public Leaf(String _name, String _position, int _salary) {
		super(_name, _position, _salary);
		
	}
	
}
class Branch extends Crop{	
	public Branch(String _name, String _position, int _salary) {
		super(_name, _position, _salary);
		
	}
	ArrayList<Crop> subordinate=new ArrayList<Crop>();
	
	public void addSubordinate(Crop del){
		this.subordinate.add(del);
	}
	public ArrayList<Crop> getSubordinate(){
		return this.subordinate;
	}	
}













