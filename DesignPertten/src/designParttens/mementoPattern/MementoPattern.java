package designParttens.mementoPattern;

public class MementoPattern {
	public static void main(String[] args) {
		Boy b=new Boy();
		b.setState("高兴");
		System.out.println(b.getState());
		Caretaker ct=new Caretaker();
		ct.setMemento(b.createMemento());
		b.changeState();
		System.out.println(b.getState());
		b.restoreMemento(ct.getMemento());
		System.out.println(b.getState());
	}
}
class Memento{
	private String state="";
	public Memento(String _state){
		this.state=_state;
	}
	public void setState(String _state){
		this.state=_state;
	}
	public String getState(){
		return this.state;
	}
}
class Boy{
	private String state="";
	public void changeState(){
		this.state="心情不好";
	}
	public void setState(String _state){
		this.state=_state;
	}
	public String getState(){
		return this.state;
	}
	public Memento createMemento(){
		return new Memento(this.state);
	}
	public void restoreMemento(Memento _memento){
		this.setState(_memento.getState());
	}
}
class Caretaker{
	private Memento memento;
	public void setMemento(Memento _memento){
		this.memento=_memento;
	}
	public Memento getMemento(){
		return this.memento;
	}
}








