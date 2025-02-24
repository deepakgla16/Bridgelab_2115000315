// LegacyAPI class with a deprecated method
class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("This is an old feature. Use newFeature() instead.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

// Main class to test LegacyAPI
public class LegacyAPIMain {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // This will show a warning
        api.newFeature(); // Recommended method
    }
}
