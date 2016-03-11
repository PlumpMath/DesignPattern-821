package designParttens.facadePattern;

public class FacadePattern {
	public static void main(String[] args) {
		PostOffice po=new PostOffice();
		String context="hello";
		String address="songjaing";
		po.sendLetter(context, address);
	}
}
interface ILetterProcess{
	public void writeContext(String context);
	public void fillEnvelope(String address);
	public void LetterIntoEnvelope();
	public void sendLetter();
}
class LetterProcessImpl implements ILetterProcess{
	@Override
	public void writeContext(String context) {
		System.out.println("write:>>>"+context);
		
	}
	@Override
	public void fillEnvelope(String address) {
		System.out.println("address>>>"+address);
		
	}
	@Override
	public void LetterIntoEnvelope() {
		System.out.println("put the letter into envelope");
		
	}
	@Override
	public void sendLetter() {
		System.out.println("send letter to one");
		
	}
}
class Police{
	public void checkLetter(ILetterProcess process){
		System.out.println("check the letter>>"+process+">>>have done");
	}
}
class PostOffice{
	private ILetterProcess process=new LetterProcessImpl();
	private Police p=new Police();
	public void sendLetter(String context,String address){
		process.writeContext(context);
		process.fillEnvelope(address);
		p.checkLetter(process);
		process.LetterIntoEnvelope();
		process.sendLetter();
	}
}