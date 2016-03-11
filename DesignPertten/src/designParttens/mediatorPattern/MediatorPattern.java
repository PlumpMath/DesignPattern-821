package designParttens.mediatorPattern;

import java.util.Random;

public class MediatorPattern {
	public static void main(String[] args) {
		AbstractMediator mediator=new Mediator();
		System.out.println("采购人员采购电脑");
		Purchase purchase=new Purchase(mediator);
		purchase.buyIBMComputer(100);
		System.out.println("销售人员销售电脑");
		Sale sale=new Sale(mediator);
		sale.sellIBMComputer(1);
		System.out.println("库存管理人员清理仓库");
		Stock stock=new Stock(mediator);
		stock.clearStock();
	}
}
abstract class AbstractMediator{
	protected Purchase purchase;
	protected Sale sale;
	protected Stock stock;
	public AbstractMediator(){
		purchase=new Purchase(this);
		sale=new Sale(this);
		stock=new Stock(this);
	}
	public abstract void execute(String str,Object...objects);
}
class Mediator extends AbstractMediator{
	public void execute(String str,Object...objects){
		if("parchase.buy".equals(str)){
			this.buyComputer((Integer)objects[0]);
		}else if("sale.sell".equals(str)){
			this.sellComputer((Integer)objects[0]);
		}else if("sale.offsell".equals(str)){
			this.offsell();
		}else if("stock.clear".equals(str)){
			this.clearStock();
		}
	}
	public void buyComputer(int number){
		int saleStatus=super.sale.getSaleStatus();
		if(saleStatus>80){
			System.out.println("采购IBM电脑："+number+"台");
			super.stock.increase(number);
		}else{
			int buyNumber=number/2;
			System.out.println("采购IBM电脑："+buyNumber+"台");
		}
	}
	public void sellComputer(int number){
		if(super.stock.getStockNumber()<number){
			super.purchase.buyIBMComputer(number);
		}
		super.stock.decrease(number);
	}
	private void offsell(){
		System.out.println("折价销售IBM电脑："+stock.getStockNumber()+"台");
	}
	private void clearStock(){
		super.sale.offSale();
		super.purchase.refuseBuyIBM();
	}
	
}

abstract class AbstractColleague{
	protected AbstractMediator mediator;
	public AbstractColleague(AbstractMediator _abstractMediator){
		this.mediator=_abstractMediator;
	}
}
class Purchase extends AbstractColleague{
	public Purchase(AbstractMediator _mediator){
		super(_mediator);
	}
	public  void buyIBMComputer(int number){
		super.mediator.execute("parchase.buy", number);
	}
	public void refuseBuyIBM(){
		System.out.println("不在采购IBM电脑");
	}
}
class Stock extends AbstractColleague{
	public Stock(AbstractMediator _mediator){
		super(_mediator);
	}
	private static int COMPUTER_NUMBER=100;
	public void increase(int number){
		COMPUTER_NUMBER=COMPUTER_NUMBER+number;
		System.out.println("库存量为："+COMPUTER_NUMBER);
	}
	public void decrease(int number){
		COMPUTER_NUMBER=COMPUTER_NUMBER-number;
		System.out.println("库存量为："+COMPUTER_NUMBER);
	}
	public int getStockNumber(){
		return COMPUTER_NUMBER;
	}
	public void clearStock(){
		System.out.println("清理存货量为："+COMPUTER_NUMBER);
		super.mediator.execute("stock.clear");
	}
}
class Sale extends AbstractColleague{
	public Sale(AbstractMediator _mediator){
		super(_mediator);
	}
	public void sellIBMComputer(int number){
		super.mediator.execute("sale.sell", number);
	}
	public int getSaleStatus(){
		Random rd=new Random(System.currentTimeMillis());
		int SaleStatus=rd.nextInt(100);
		System.out.println("IBM电脑的销售情况为：" +SaleStatus);
		return SaleStatus;
	}
	public void offSale(){
		super.mediator.execute("sale.offsell");
	}
}