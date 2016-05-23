package designParttens.bridgePattern;

public class BridgePattern {
	public static void main(String[] args) {
		HouseProduct hp=new HouseProduct();
		HouseCrop hc=new HouseCrop(hp);
		hc.makeMoney();
		Szc s=new Szc(new HouseProduct());
		s.makeMoney();
	}
}
abstract class Crop{
	private Product product;
	public Crop(Product _product){
		this.product=_product;
	}
	public void makeMoney(){
		this.product.beproducted();
		this.product.beselled();
	}
}
//know what i want
class HouseCrop extends Crop{
	public HouseCrop(HouseProduct hp){
		super(hp);
	}
	public void makeMoney(){
		super.makeMoney();
		System.out.println("get a lot of money");
	}
}
//not sure what i want
class Szc extends Crop{
	public Szc(Product p){
		super(p);
	}
	public void makeMoney(){
		super.makeMoney();
		System.out.println("got a lot lot lot money");
	}
}
abstract class Product{
	public abstract void beproducted();
	public abstract void beselled();
}
class HouseProduct extends Product{
	public void beproducted(){
		System.out.println("house is beproducted");
	}
	public void beselled(){
		System.out.println("beselled is selled");
	}
}


