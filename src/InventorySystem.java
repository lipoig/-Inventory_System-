import java.io.*;
import java.util.*;

public class InventorySystem {
    private static final String FILE_NAME = "inventory.txt";
    private ArrayList<Item> inventory = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Main program loop
    public void start() {
        System.out.println("===== Welcome to the Enhanced Inventory System =====");

        // Optional load
        System.out.print("Load inventory from file (" + FILE_NAME + ")? (Y/N): ");
        String loadChoice = scanner.nextLine().trim();
        if (loadChoice.equalsIgnoreCase("Y") || loadChoice.equalsIgnoreCase("YES")) {
            loadFromFile();
        } else {
            System.out.println("Starting with an empty inventory.");
        }

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Remove Item");
            System.out.println("4. Sort Items");
            System.out.println("5. Save Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> addItem();
                case 2 -> viewItems();
                case 3 -> removeItem();
                case 4 -> sortItems();
                case 5 -> saveToFile();
                case 6 -> {
                    saveToFile();
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine().trim();

        // Check for duplicates
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.println("Error: An item with this name already exists.");
                return;
            }
        }

        System.out.print("Enter item price: ");
        double price = getDoubleInput();

        System.out.print("Enter quantity: ");
        int quantity = getIntInput();

        System.out.print("Enter category: ");
        String category = scanner.nextLine().trim();

        inventory.add(new Item(name, price, quantity, category));
        System.out.println("Item added successfully!");
    }

    private void viewItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n===== Current Inventory =====");
        for (Item item : inventory) {
            System.out.println(item);
        }
    }

    private void removeItem() {
        System.out.print("Enter the name of the item to remove: ");
        String name = scanner.nextLine().trim();

        boolean removed = inventory.removeIf(item -> item.getName().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }

    private void sortItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty. Nothing to sort.");
            return;
        }

        System.out.println("Sort by:");
        System.out.println("1. Name (A–Z)");
        System.out.println("2. Price (Low–High)");
        System.out.print("Enter choice: ");
        int sortChoice = getIntInput();

        switch (sortChoice) {
            case 1 -> {
                inventory.sort(Comparator.comparing(Item::getName, String.CASE_INSENSITIVE_ORDER));
                System.out.println("Items sorted by name.");
            }
            case 2 -> {
                inventory.sort(Comparator.comparingDouble(Item::getPrice));
                System.out.println("Items sorted by price.");
            }
            default -> System.out.println("Invalid sort option.");
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Item item : inventory) {
                writer.write(item.toFileString());
                writer.newLine();
            }
            System.out.println("Inventory saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No save file found (" + FILE_NAME + "). Starting with empty inventory.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            inventory.clear();
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                Item item = Item.fromFileString(line);
                if (item != null) {
                    inventory.add(item);
                    count++;
                }
            }
            System.out.println("Loaded " + count + " items from " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }

    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a whole number: ");
            }
        }
    }

    private double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}
