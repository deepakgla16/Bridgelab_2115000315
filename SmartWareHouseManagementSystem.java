import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
	private String name;

	public WarehouseItem(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public abstract void displayDetails();
}

class Electronics extends WarehouseItem{

	public Electronics(String name){
		super(name);
	}

	@Override
	public void displayDetails() {
		System.out.println(getName());
	}
}

class Groceries extends WarehouseItem{

	public Groceries(String name){
		super(name);
	}

	@Override
	public void displayDetails() {
		System.out.println(getName());
	}
}

class Furniture extends WarehouseItem{

	public Furniture(String name){
		super(name);
	}

	@Override
	public void displayDetails() {
		System.out.println(getName());
	}
}

class Storage<T extends WarehouseItem>{
	private List<T> items = new ArrayList<>();

	public void addItem(T item){
		items.add(item);
	}

	public void removeItem(T item){
		items.remove(item);
	}

	public List<T> getItems(){
		return items;
	}
}

class WarehouseUtils{
	public static void displayAllItems(List<? extends WarehouseItem> items){
		for(WarehouseItem item : items){
			item.displayDetails();
		}
	}
}

public class SmartWareHouseManagementSystem{
	public static void main(String[] args){
		Storage<Electronics> electronicsStorage = new Storage<>();
		Storage<Groceries> groceriesStorage = new Storage<>();
		Storage<Furniture> furnitureStorage = new Storage<>();

		electronicsStorage.addItem(new Electronics("Laptop"));
		electronicsStorage.addItem(new Electronics("Smartphone"));

		groceriesStorage.addItem(new Groceries("Milk"));
		groceriesStorage.addItem(new Groceries("Apple"));

		furnitureStorage.addItem(new Furniture("Chair"));
		furnitureStorage.addItem(new Furniture("Table"));

		System.out.println("Electronics Storage:");
		WarehouseUtils.displayAllItems(electronicsStorage.getItems());

		System.out.println("\nGroceries Storage:");
		WarehouseUtils.displayAllItems(groceriesStorage.getItems());

		System.out.println("\nFurniture Storage:");
		WarehouseUtils.displayAllItems(furnitureStorage.getItems());
	}
}
