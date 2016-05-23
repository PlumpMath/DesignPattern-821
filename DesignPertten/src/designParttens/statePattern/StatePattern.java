package designParttens.statePattern;

public class StatePattern {
	public static void main(String[] args) {
		Context c=new Context();
		c.setLiftState(new StopingState());
		c.close();
		c.run();
		c.stop();
		c.open();
	}
}
abstract class LiftState{
	protected Context context;
	public void setContext(Context _context){
		this.context=_context;
	}
	public abstract void open();
	public abstract void close();
	public abstract void run();
	public abstract void stop();
}
class Context{
	public final static OpeningState os=new OpeningState();
	public final static ClosingState cs=new ClosingState();
	public final static RunningState rs=new RunningState();
	public final static StopingState ss=new StopingState();
	
	private LiftState liftState;
	public LiftState getLifeState(){
		return liftState;
	}
	public void setLiftState(LiftState liftState){
		this.liftState=liftState;
		this.liftState.setContext(this);
	}
	public void open(){
		this.liftState.open();
	}
	public void close(){
		this.liftState.close();	
	}
	public void run(){
		this.liftState.run();
	}
	public void stop(){
		this.liftState.stop();
	}
}
class OpeningState extends LiftState{
	@Override
	public void open() {		
	}
	@Override
	public void close() {	
	}
	@Override
	public void run() {	
	}
	@Override
	public void stop() {	
	}
	
}
class ClosingState extends LiftState{
	@Override
	public void open() {
		super.context.setLiftState(Context.os);
		super.context.getLifeState().open();
	}
	@Override
	public void close() {
		System.out.println("is closing");
	}
	@Override
	public void run() {
		super.context.setLiftState(Context.rs);
		super.context.getLifeState().run();
	}
	@Override
	public void stop() {
		super.context.setLiftState(Context.ss);
		super.context.getLifeState().stop();
	}	
}
class RunningState extends LiftState{
	@Override
	public void open() {	}
	@Override
	public void close() {	}
	@Override
	public void run() {
		System.out.println("is runing");		
	}
	@Override
	public void stop() {
		super.context.setLiftState(Context.ss);
		super.context.getLifeState().stop();		
	}	
}
class StopingState extends LiftState{
	@Override
	public void open() {
		super.context.setLiftState(Context.os);
		super.context.getLifeState().open();		
	}
	@Override
	public void close() {}
	@Override
	public void run() {
		super.context.setLiftState(Context.rs);
		super.context.getLifeState().run();		
	}
	@Override
	public void stop() {
		System.out.println("is stoping");		
	}
	
}
