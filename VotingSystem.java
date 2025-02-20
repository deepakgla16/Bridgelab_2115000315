import java.util.*;

class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>(); // Fast lookup
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>(); // Order of voting
    private TreeMap<String, Integer> sortedResults = new TreeMap<>(); // Sorted by candidate name

    // Cast a vote
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, voteMap.get(candidate));
    }

    // Display votes in the order they were cast
    public void displayVotesInOrder() {
        System.out.println("\nVotes in Order of Casting:");
        for (Map.Entry<String, Integer> entry : orderedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display sorted results
    public void displaySortedResults() {
        sortedResults.putAll(voteMap); // Copy votes to TreeMap for sorting
        System.out.println("\nSorted Voting Results:");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Find the winner (Candidate with maximum votes)
    public String findWinner() {
        return Collections.max(voteMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Casting votes
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        // Display results
        system.displayVotesInOrder();
        system.displaySortedResults();

        // Winner
        System.out.println("\nWinner: " + system.findWinner());
    }
}
