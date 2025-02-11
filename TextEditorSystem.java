import java.util.Scanner;

class TextNode {
    String text;
    TextNode prev, next;

    public TextNode(String text) {
        this.text = text;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextNode head, tail, current;
    private int size;
    private final int MAX_HISTORY = 10;

    public TextEditor() {
        head = tail = current = null;
        size = 0;
    }

    // Add a new text state
    public void addState(String newText) {
        TextNode newNode = new TextNode(newText);
        
        if (current != null) {
            // Remove all redo states (forward history)
            current.next = null;
        }

        if (head == null) {
            head = tail = current = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        tail = current; // Update the tail pointer
        size++;

        // Ensure the history does not exceed MAX_HISTORY
        if (size > MAX_HISTORY) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
        }
    }

    // Undo the last action
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful. Current state: " + current.text);
        } else {
            System.out.println("No more undo actions available.");
        }
    }

    // Redo the undone action
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful. Current state: " + current.text);
        } else {
            System.out.println("No more redo actions available.");
        }
    }

    // Display the current text state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }
}

// Driver Code
public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nText Editor - Undo/Redo Functionality:");
            System.out.println("1. Add New Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String newText = scanner.nextLine();
                    editor.addState(newText);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
