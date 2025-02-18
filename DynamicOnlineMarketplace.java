import java.util.ArrayList;
import java.util.List;

abstract class ProductCategory{
	private String name;

	public ProductCategory(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}

class BookCategory extends ProductCategory{
	public BookCategory(){
		super("Books");
	}
}

class ClothingCategory extends ProductCategory{
	public ClothingCategory(){
		super("Clothing");
	}
}

class GadgetCategory extends ProductCategory{
	public GadgetCategory(){
		super("Gadgets");
	}
}

class Product<T extends ProductCategory>{
	private String name;
	private double price;
	private T category;

	public Product(String name, double price, T category){
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getName(){
		return name;
	}

	public double getPrice(){
		return price;
	}

	public T getCategory(){
		return category;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public void displayDetails(){
		System.out.println(name + " - " + category.getName() + " - Rs." + price);
	}
}

class Marketplace{
	private List<Product<? extends ProductCategory>> catalog = new ArrayList<>();

	public void addProduct(Product<? extends ProductCategory> product){
		catalog.add(product);
	}

	public List<Product<? extends ProductCategory>> getCatalog(){
		return catalog;
	}

	public static <T extends Product<?>> void applyDiscount(T product, double percentage){
		double discountedPrice = product.getPrice() * (1 - percentage / 100);
		product.setPrice(discountedPrice);
	}
}

public class DynamicOnlineMarketplace{
	public static void main(String[] args){
		Marketplace marketplace = new Marketplace();

		Product<BookCategory> book = new Product<>("Java Programming", 49.99, new BookCategory());
		Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 29.99, new ClothingCategory());
	Product<GadgetCategory> phone = new Product<>("Smartphone", 599.99, new GadgetCategory());

		marketplace.addProduct(book);
		marketplace.addProduct(shirt);
		marketplace.addProduct(phone);

		System.out.println("Before Discount:");
		for(Product<? extends ProductCategory> product : marketplace.getCatalog()){
			product.displayDetails();
		}

		Marketplace.applyDiscount(book, 10);
		Marketplace.applyDiscount(shirt, 20);
		Marketplace.applyDiscount(phone, 15);

		System.out.println("\nAfter Discount:");
		for(Product<? extends ProductCategory> product : marketplace.getCatalog()){
			product.displayDetails();
		}
	}
}
