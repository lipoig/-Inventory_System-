public class Item {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Item(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Name: %-15s | Price: $%-8.2f | Qty: %-5d | Category: %s",
                name, price, quantity, category);
    }

    // Convert item to a line for file saving
    public String toFileString() {
        return name + "," + price + "," + quantity + "," + category;
    }

    // Create item from a line in the file
    public static Item fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            try {
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                String category = parts[3];
                return new Item(name, price, quantity, category);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}
