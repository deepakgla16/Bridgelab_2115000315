// Parent class Animal
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Dog class that overrides makeSound() method
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Main class to test the Dog class
public class AnimalDog {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Polymorphism
        myDog.makeSound();  // Output: Woof! Woof!
    }
}
