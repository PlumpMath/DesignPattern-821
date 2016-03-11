package designParttens.commandPattern;

public class CommandPattern {
	public static void main(String[] args) {
		Invoker i=new Invoker();
		Command c=new RequireCommand();
		i.setCommand(c);
		i.action();
	}
}
abstract class Command{
	protected Requirement re=new Requirement();
	protected PageGroup pg=new PageGroup();
	protected CodingGroup cg=new CodingGroup();
	public abstract void excute();
}
class RequireCommand extends Command{
	public void excute(){
		super.re.find();
		super.re.add();
		super.re.plan();
	}
}
class Invoker{
	private Command c;
	public void setCommand(Command _c){
		this.c=_c;
	}
	public void action(){
		c.excute();
	}
}


abstract class Group{
	public abstract void find();
	public abstract void add();
	public abstract void delete();
	public abstract void change();
	public abstract void plan();
}
class Requirement extends Group{
	public  void find(){
		System.out.println("找到需求组");
	}
	public void add(){
		System.out.println("需求增加");
	}
	public void delete(){
		System.out.println("需求删除");
	}
	public void change(){
		System.out.println("需求改变");
	}
	public void plan(){
		System.out.println("需求计划变更");
	}
}
class PageGroup extends Group{
	public  void find(){
		System.out.println("找到美工组");
	}
	public void add(){
		System.out.println("美工增加");
	}
	public void delete(){
		System.out.println("美工删除");
	}
	public void change(){
		System.out.println("美工改变");
	}
	public void plan(){
		System.out.println("美工计划变更");
	}
}
class CodingGroup extends Group{
	public  void find(){
		System.out.println("找到编码组");
	}
	public void add(){
		System.out.println("编码增加");
	}
	public void delete(){
		System.out.println("编码删除");
	}
	public void change(){
		System.out.println("编码改变");
	}
	public void plan(){
		System.out.println("编码计划变更");
	}
}