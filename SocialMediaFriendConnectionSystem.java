import java.util.*;

class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;  // List to store friend connections
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head = null;

    // Add a new user to the system
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    // Find a user by ID
    private User findUser(int userID) {
        User current = head;
        while (current != null) {
            if (current.userID == userID) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIDs.contains(userID2)) {
            user1.friendIDs.add(userID2);
        }
        if (!user2.friendIDs.contains(userID1)) {
            user2.friendIDs.add(userID1);
        }

        System.out.println(user1.name + " and " + user2.name + " are now friends!");
    }

    // Remove a friend connection
    public void removeFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIDs.remove((Integer) userID2);
        user2.friendIDs.remove((Integer) userID1);

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        User user = findUser(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friendIDs.isEmpty()) {
            System.out.println("No friends yet.");
            return;
        }

        for (int friendID : user.friendIDs) {
            User friend = findUser(friendID);
            if (friend != null) {
                System.out.println("UserID: " + friend.userID + ", Name: " + friend.name);
            }
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        Set<Integer> mutualFriends = new HashSet<>(user1.friendIDs);
        mutualFriends.retainAll(user2.friendIDs);  // Find intersection

        System.out.println("Mutual friends of " + user1.name + " and " + user2.name + ":");
        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends.");
            return;
        }

        for (int friendID : mutualFriends) {
            User friend = findUser(friendID);
            if (friend != null) {
                System.out.println("UserID: " + friend.userID + ", Name: " + friend.name);
            }
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String nameOrID) {
        User current = head;
        boolean found = false;

        while (current != null) {
            if (current.name.equalsIgnoreCase(nameOrID) || String.valueOf(current.userID).equals(nameOrID)) {
                System.out.println("User Found - ID: " + current.userID + ", Name: " + current.name + ", Age: " + current.age);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User current = head;
        while (current != null) {
            System.out.println("User: " + current.name + " has " + current.friendIDs.size() + " friends.");
            current = current.next;
        }
    }
}

// Driver Code
public class SocialMediaFriendConnectionSystem {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSocial Media Friend Manager:");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends of a User");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter User ID, Name, Age: ");
                    sm.addUser(scanner.nextInt(), scanner.next(), scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter two User IDs to connect as friends: ");
                    sm.addFriend(scanner.nextInt(), scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter two User IDs to remove friendship: ");
                    sm.removeFriend(scanner.nextInt(), scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter User ID to view friends: ");
                    sm.displayFriends(scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Enter two User IDs to find mutual friends: ");
                    sm.findMutualFriends(scanner.nextInt(), scanner.nextInt());
                    break;
                case 6:
                    System.out.print("Enter User Name or User ID to search: ");
                    sm.searchUser(scanner.next());
                    break;
                case 7:
                    sm.countFriends();
                    break;
                case 8:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
