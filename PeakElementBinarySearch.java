public class PeakElementBinarySearch {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoids overflow

            // If mid element is greater than the next element, search left half
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else { // Otherwise, search right half
                left = mid + 1;
            }
        }

        return left; // Index of the peak element
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 12, 4, 2}; // Example array with peak at index 3

        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element: " + nums[peakIndex]);
    }
}
