package designParttens.FactoryMethod;
//这是个通用的工厂模式的框架
public class FactoryMethod {
	public static void main(String[] args) {
		AbstractHumanFactory ah=new HumanFactory();
		Human white=ah.creatHuman(whiteHuman.class);
		white.getColor();
		white.talk();
		Human yellow=ah.creatHuman(yellowHuman.class);
		yellow.getColor();
		yellow.talk();
	}
}
//人类接口
interface Human{
	public void getColor();
	public void talk();
}
//实现类
class whiteHuman implements Human{
	public void getColor(){
		System.out.println("i am white");
	}
	public void talk(){
		System.out.println("say English");
	}
}
class yellowHuman implements Human{
	public void getColor(){
		System.out.println("i am yellow");
	}
	public void talk(){
		System.out.println("say chinese");
	}
}
//抽象工厂类
abstract class AbstractHumanFactory{
	//限制必须是class类型,并且必须是class的实现
	public abstract <T extends Human>T creatHuman(Class<T> c);
}
//实现类
class HumanFactory extends AbstractHumanFactory{
	@SuppressWarnings("unchecked")
	public  <T extends Human>T creatHuman(Class<T> c){
		Human human=null;
		try{
			human=(T)Class.forName(c.getName()).newInstance();
		}catch(Exception e){
			System.out.println("here is error");
		}
		return (T)human;
	}
}

