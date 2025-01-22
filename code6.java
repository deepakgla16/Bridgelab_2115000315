package Assignment2;
public class code6 {
    public static void main(String[] args) {
        // Fee and discount percentage
        double fee = 125000.0;
        double discountPercent = 10.0;

        // Calculate discount and discounted fee
        double discount = (fee * discountPercent) / 100;
        double discountedFee = fee - discount;

        // Output the results
        System.out.printf(
            "The discount amount is INR %.2f and final discounted fee is INR %.2f\n",
            discount, discountedFee
        );
    }
}
