package designParttens.observerPattern;


import java.util.Observable;
import java.util.Observer;

public class ObserverPattern {
	public static void main(String[] args) {
		Observer lisi=new Lisi();
		HanFeiZi hfz=new HanFeiZi();
		hfz.addObserver(lisi);
		hfz.havaBreakfast();
	}
}

interface IHanFeiZi{
	public void havaBreakfast();
	public void havefun();
}
class HanFeiZi extends Observable implements IHanFeiZi{	
	public void havaBreakfast(){
		System.out.println("hanfeizi is having breakfast");
		super.setChanged();
		super.notifyObservers("hangfeizi eating ");
	}
	public void havefun(){
		System.out.println("hanfeizi is yeleing");
		super.setChanged();
		super.notifyObservers("hangfeizi zhengzai yule");
	}
}
class Lisi implements Observer{		
	private void reportQingshihuang(String report){
		System.out.println("hangziziyou active>>>"+report);
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("report to qingshihuang");
		this.reportQingshihuang(arg.toString());
		System.out.println("report over");
	}		
}