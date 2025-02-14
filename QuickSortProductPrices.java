import java.util.Arrays;

public class QuickSortProductPrices {
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }
    
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        
        return i + 1;
    }
    
    public static void main(String[] args) {
        int[] productPrices = {1200, 500, 700, 1500, 900, 300};
        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));
        
        quickSort(productPrices, 0, productPrices.length - 1);
        
        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
    }
}
