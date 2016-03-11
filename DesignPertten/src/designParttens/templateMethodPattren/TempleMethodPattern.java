package designParttens.templateMethodPattren;


import java.io.IOException;



//根据钩子的返回结果改变了模板方法的执行结果
public class TempleMethodPattern {
	public static void main(String[] args) throws IOException {
		car c=new car();
		//根据true和false来让车响不响
		c.setFlag(false);
		c.run();
	}
}
abstract class Model{
	protected abstract void start();
	protected abstract void stop();
	protected abstract void alarm();
	public void run(){
		this.start();
		this.stop();
		if(isAlarm()){
			this.alarm();
		}
	}
	public boolean isAlarm(){
		return true;
	}
}
class car extends Model{
	protected void start(){
		System.out.println("start___");
	}
	protected void stop(){
		System.out.println("stop___");
	}
	protected void alarm(){
		System.out.println("alarm");
	}
	public boolean flag=true;
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	public boolean isAlarm(){
		return this.flag;
	}
}

