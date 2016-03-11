package designParttens.decoratePattern;

public class DecoratePattern {
	public static void main(String[] args) {
		SchoolReport sr=new FouthSchoolReport();
		sr=new HighSchoolDecorator(sr);
		sr=new SortDecorator(sr);
		sr.report();
		sr.sign("three");
	}
}
abstract class SchoolReport{
	public abstract void report();
	public abstract void sign(String name);
}
class FouthSchoolReport extends SchoolReport{
	public void report(){
		System.out.println("maths is 69,chinese is 68");
		System.out.println("please sign>>>");
	}
	public void sign(String name){
		System.out.println("name:"+name);
	}
}
abstract class Decorator extends SchoolReport{
	private SchoolReport sr;
	public Decorator(SchoolReport _sr){ 
		this.sr=_sr;
	}
	public void report(){
		this.sr.report();
	}
	public void sign(String name){
		this.sr.sign(name);
	}
}


class HighSchoolDecorator extends Decorator{
	public HighSchoolDecorator(SchoolReport sr){
		super(sr);
	}
	private void reportHighScore(){
		System.out.println("Highest score maths is 80,chinese 80");
	}
	public void report(){
		this.reportHighScore();
		super.report();
	}
}
class SortDecorator extends Decorator{
	public SortDecorator(SchoolReport sr){
		super(sr);
	}
	private void reportSort(){
		System.out.println("my sort is 38");
	}
	public void report(){
		super.report();
		this.reportSort();
	}
}
