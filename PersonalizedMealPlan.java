import java.util.ArrayList;
import java.util.List;

interface MealPlan{
	String getMealName();
	void displayMeal();
}

class VegetarianMeal implements MealPlan{
	private String mealName;

	public VegetarianMeal(String mealName){
		this.mealName = mealName;
	}

	@Override
	public String getMealName(){
		return mealName;
	}

	@Override
	public void displayMeal(){
		System.out.println("Vegetarian Meal: " + mealName);
	}
}

class VeganMeal implements MealPlan{
	private String mealName;

	public VeganMeal(String mealName){
		this.mealName = mealName;
	}

	@Override
	public String getMealName(){
		return mealName;
	}

	@Override
	public void displayMeal(){
		System.out.println("Vegan Meal: " + mealName);
	}
}

class Meal<T extends MealPlan>{
	private List<T> meals = new ArrayList<>();

	public void addMeal(T meal){
		meals.add(meal);
	}

	public List<T> getMeals(){
		return meals;
	}

	public void displayMeals(){
		for(T meal : meals) {
			meal.displayMeal();
		}
	}
}

class MealPlanGenerator{
	public static <T extends MealPlan> void generateMealPlan(Meal<T> mealPlan){
		System.out.println("Generated Meal Plan:");
		mealPlan.displayMeals();
	}
}

public class PersonalizedMealPlan{
	public static void main(String[] args){
		Meal<VegetarianMeal> vegetarianMealPlan = new Meal<>();
		vegetarianMealPlan.addMeal(new VegetarianMeal("abc"));
		vegetarianMealPlan.addMeal(new VegetarianMeal("def"));

		Meal<VeganMeal> veganMealPlan = new Meal<>();
		veganMealPlan.addMeal(new VeganMeal("pqr"));
		veganMealPlan.addMeal(new VeganMeal("xyz"));

		MealPlanGenerator.generateMealPlan(vegetarianMealPlan);
		MealPlanGenerator.generateMealPlan(veganMealPlan);
	}
}
