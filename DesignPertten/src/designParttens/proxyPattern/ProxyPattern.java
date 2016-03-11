package designParttens.proxyPattern;

public class ProxyPattern {
	public static void main(String[] args) {
		IGamePlayer igp=new GamePlayer("aaa");
		GamePlayerProxy gpp=new GamePlayerProxy(igp);
		gpp.login("bbb", "ccc");
		gpp.killBoss();
		gpp.upgrade();
	}
}
interface IGamePlayer{
	public void login(String name,String password);
	public void killBoss();
	public void upgrade();
}
class GamePlayer implements IGamePlayer{
	
	private String name="";
	
	public GamePlayer(String _name){
		this.name=_name;
	}
	
	public void login(String name,String password){
		System.out.println("name:"+name+",password"+password);
	}
	public void killBoss(){
		System.out.println(this.name+"  kill the boss");
	}
	public void upgrade(){
		System.out.println(this.name+"  is grading");
	}
}
class GamePlayerProxy implements IGamePlayer{
	private IGamePlayer gp=null;
	public GamePlayerProxy(IGamePlayer _gp){
		this.gp=_gp;
	}
	public void login(String name,String password){
		this.gp.login(name, password);
	}
	public void killBoss(){
		this.gp.killBoss();
	}
	public void upgrade(){
		this.gp.upgrade();
	}
}