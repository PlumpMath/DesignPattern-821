package designParttens.builderPattern;

import java.util.ArrayList;

public class BuilderPattern {
	public static void main(String[] args) {
		Directory d=new Directory();
		d.getCarModel().run();
	}
}
abstract class Model{
	private ArrayList<String> sequence=new ArrayList<String>();	
	protected abstract void start();
	protected abstract void stop();
	protected abstract void fly();
	final public void run(){
		for(int i=0;i<sequence.size();i++){
			String type=sequence.get(i);
			if("start".equals(type)){
				this.start();
			}else if("stop".equals(type)){
				this.stop();
			}else if("fly".equals(type)){
				this.fly();
			}
		}
	}
	public  void setSequence(ArrayList<String> sequence){
		this.sequence=sequence;
	}
}
class carModel extends Model{
	protected void start(){
		System.out.println("start");
	}
	protected void stop(){
		System.out.println("stop");
	}
	protected void fly(){
		System.out.println("fly");
	}
}

abstract class Builder{
	public abstract void setSequence(ArrayList<String> sequence);
	public abstract Model getModel();
}
class carBuilder extends Builder{
	private Model m=new carModel();
	
	public void setSequence(ArrayList<String> sequence){
		this.m.setSequence(sequence);
	}
	public Model getModel(){
		return this.m;
	}
}
class Directory{
	private ArrayList<String> sequence=new ArrayList<String>();
	private carBuilder cb=new carBuilder();
	
	public carModel getCarModel(){
		sequence.clear();
		sequence.add("stop");
		sequence.add("fly");
		sequence.add("start");
		cb.setSequence(sequence);
		return (carModel)cb.getModel();
	}
	
	
	
}

