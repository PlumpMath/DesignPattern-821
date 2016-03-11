package designParttens.chainOfResponsibility;

import java.util.ArrayList;
import java.util.Random;

public class ChainOfResponsilibity {
	public static void main(String[] args) {
		Random rd=new Random();
		ArrayList<IWoman> woman=new ArrayList<IWoman>();
		for(int i=0;i<5;i++){
			woman.add(new Woman(rd.nextInt(4),"我要出去逛街"));
		}
		Handler father=new Father();
		Handler husband=new Husband();
		Handler son=new Son();
		father.setHandler(husband);
		husband.setHandler(son);
		for(IWoman w:woman){
			father.HandleMessage(w);
		}
	}
}
interface IWoman{
	public int getType();
	public String getRequest();
}
class Woman implements IWoman{
	private final static int NOTMARRY=1;
	private final static int MARRYED=2;
	private final static int HUSBANDDIE=3;
	
	private int type=0;
	private String request="";
	public Woman(int _type,String _request){
		this.type=_type;
		switch(this.type){
			case NOTMARRY:
					this.request="女儿的请求是"+_request;
					break;
			case MARRYED:
				this.request="妻子的请求是"+_request;
				break;
			case HUSBANDDIE:
				this.request="母亲的请求是"+_request;
				break;				
		}
	}
	public int getType(){
		return this.type;
	}
	public String getRequest(){
		return this.request;
	}


}
abstract class Handler{
	public final static int FATHER=1;
	public final static int HUSBAND=2;
	public final static int SON=3;
	
	private int level=0;
	private Handler nextHandler;
	public Handler(int _level){
		this.level=_level;
	}
	public final void HandleMessage(IWoman woman){
		if(woman.getType()==this.level){
			this.response(woman);
		}else{
			if(this.nextHandler!=null){
				this.nextHandler.HandleMessage(woman);
			}else{
				System.out.println("there is no place to response\n");
			}
		}
	}
	public void setHandler(Handler _handler){
		this.nextHandler=_handler;
	}
	protected abstract void response(IWoman woman);
}
class Father extends Handler{
	public Father(){
		super(Handler.FATHER);
	}
	protected void response(IWoman woman){
		System.out.println("女儿向父亲请示");
		System.out.println(woman.getRequest());
		System.out.println("父亲的答案是：同意\n");
	}
}
class Husband extends Handler{
	public Husband(){
		super(Handler.HUSBAND);
	}
	protected void response(IWoman woman){
		System.out.println("妻子向丈夫请示");
		System.out.println(woman.getRequest());
		System.out.println("丈夫的答案是：同意\n");
	}
}
class Son extends Handler{
	public Son(){
		super(Handler.SON);
	}
	protected void response(IWoman woman){
		System.out.println("母亲向儿子请示");
		System.out.println(woman.getRequest());
		System.out.println("儿子的答案是：同意\n");
	}
}