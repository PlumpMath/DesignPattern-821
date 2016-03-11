package designParttens.strategyPattern;

public class StrategyPattern {
	public static void main(String[] args) {
		Context ct=new Context(new DackDoor());
		ct.operate();
		ct=new Context(new GreenLight());
		ct.operate();
	}
}
interface IStrategy{
	public void operate();
}
class DackDoor implements IStrategy{
	public void operate(){
		System.out.println("open the door");
	}
}
class GreenLight implements IStrategy{
	public void operate(){
		System.out.println("the GreenLight is light");
	}
}
class Context{
	private IStrategy is;
	public Context(IStrategy _is){
		this.is=_is;
	}
	public void operate(){
		this.is.operate();
	}
}