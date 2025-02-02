class Person {
    private String name;
    private int age;

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Person original = new Person("Alice", 30);
        Person copy = new Person(original);

        System.out.println("Original Person: " + original.getName() + ", Age: " + original.getAge());
        System.out.println("Copied Person: " + copy.getName() + ", Age: " + copy.getAge());
    }
}
