package designParttens.abstractFactoryPattern;

public class AbstractFactoryPattern {
	public static void main(String[] args) {
		humanFactory manf=new manFactory();
		humanFactory womanf=new woamnFactory();
		Hman wwoman=womanf.creatWhite();
		Hman yman=manf.creatYellow();
		wwoman.getColor();
		wwoman.talk();
		wwoman.getSex();
		yman.getColor();
		yman.getSex();
		yman.talk();
	}
	
}
interface Hman{
	public void getColor();
	public void talk();
	public void getSex();
}
//白种人
abstract class wHuman implements Hman{
	public void getColor(){
		System.out.println("my skin is white");
	}
	public void talk(){
		System.out.println("talk in english");
	}
}
class wMan extends wHuman{
	public void getSex(){
		System.out.println("i am man in white");
	}
}
class wWoman extends wHuman{
	public void getSex(){
		System.out.println("i am woman in white");
	}
}
//黄种人
abstract class yHuman implements Hman{
	public void getColor(){
		System.out.println("my skin is yellow");
	}
	public void talk(){
		System.out.println("talk in chinese");
	}
}
class yMan extends yHuman{
	public void getSex(){
		System.out.println("i am man in yellow");
	}
}
class yWoman extends yHuman{
	public void getSex(){
		System.out.println("i am woman in yellow");
	}
}
//造人工厂
interface humanFactory{
	public Hman creatWhite();
	public Hman creatYellow();
}
//男性造人工厂
class manFactory implements humanFactory{	
	public Hman creatWhite() {		
		return new wMan();
	}	
	public Hman creatYellow() {		
		return new yMan();
	}	
}
//女性造人工厂
class woamnFactory implements humanFactory{	
	public Hman creatWhite() {
		return new wWoman();
	}
	public Hman creatYellow() {
		return new yWoman();
	}	
}
