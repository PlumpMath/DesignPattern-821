package designParttens.visitorPattern;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {
	public static void main(String[] args) {
		for(Employee em:mockEmployee()){
			em.accept(new Visitor());
		}
	}
	public static List<Employee> mockEmployee(){
		List<Employee> emplist=new ArrayList<Employee>();
		ComEmployee su=new ComEmployee();
		su.setJob("coding");
		su.setName("su");
		su.setSalary(100);
		su.setSex(0);
		emplist.add(su);
		Manage dong=new Manage();
		dong.setPerferance("hahaha");
		dong.setName("dong");
		dong.setSalary(10);
		dong.setSex(1);
		emplist.add(dong);
		return emplist;
	}
}
abstract class Employee{
	public static final int MALE=0;
	public static final int FMAINL=1;
	private String name;
	private int salary;
	private int sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	protected abstract void accept(IVisitor visitor);
}
class ComEmployee extends Employee{
	private String job;
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	protected void accept(IVisitor visitor) {
		visitor.visit(this);		
	}	
}
class Manage extends Employee{
	private String perferance;
	public String getPerferance() {
		return perferance;
	}
	public void setPerferance(String perferance) {
		this.perferance = perferance;
	}
	@Override
	protected void accept(IVisitor visitor) {
		visitor.visit(this);		
	}	
}
interface IVisitor{
	public void visit(ComEmployee ce);
	public void visit(Manage manage);
}
class Visitor implements IVisitor{
	@Override
	public void visit(ComEmployee ce) {
		System.out.println(this.getComInfo(ce));		
	}
	@Override
	public void visit(Manage m) {
		System.out.println(this.getManagerInfo(m));		
	}
	private String getBasicInfo(Employee e){
		String info="name:"+e.getName()+",salary:"+e.getSalary()+",sex"+(e.getSex()==e.FMAINL?"woman":"man");
		return info;
	}
	private String getManagerInfo(Manage m){
		String basic=this.getBasicInfo(m);
		String other="perferance:"+m.getPerferance();
		return basic+other;
	}
	private String getComInfo(ComEmployee ce){
		String basic=this.getBasicInfo(ce);
		String other="job:"+ce.getJob();
		return basic+other;
	}
}

	