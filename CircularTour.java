import java.util.*;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    // Function to find the starting petrol pump index for the circular tour
    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0;  // Candidate starting point
        int totalSurplus = 0;  // Net surplus petrol
        int currentSurplus = 0;  // Surplus petrol in the current route

        for (int i = 0; i < pumps.length; i++) {
            int petrolGain = pumps[i].petrol - pumps[i].distance;
            totalSurplus += petrolGain;
            currentSurplus += petrolGain;

            // If current surplus is negative, reset the starting point
            if (currentSurplus < 0) {
                start = i + 1;  // Next station as the new candidate
                currentSurplus = 0;  // Reset current surplus
            }
        }

        // If total surplus is negative, the tour is not possible
        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int start = findStartingPoint(pumps);
        if (start != -1) {
            System.out.println("Start at petrol pump index: " + start);
        } else {
            System.out.println("No valid starting point found");
        }
    }
}
