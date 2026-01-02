# Inventory Management System

A console-based inventory management application built with Java and Object-Oriented Programming (OOP) principles. Manage items with features like adding, viewing, removing, sorting, and persistent file storage.

## Features

- **Add Items**: Create new inventory items with name, price, quantity, and category
- **View Inventory**: Display all items in a formatted table
- **Remove Items**: Delete items by name
- **Input Validation**: Prevents invalid data entry
- **User-Friendly Menu**: Intuitive console-based navigation

- **Duplicate Prevention**: Cannot add items with the same name
- **Sorting**: Sort inventory by name (A-Z) or price (Low-High)
- **File Persistence**: Save and load inventory from `inventory.txt`
- **Item Details**: Track quantity and category for each item
- **Error Handling**: Robust error handling for file operations and user input

## Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **IDE**: Eclipse (recommended) or any Java IDE
- **Operating System**: Windows, macOS, or Linux

## Installation

### Method 1: Using Eclipse IDE

1. **Open Eclipse**
2. **Create New Project**:
   - File → New → Java Project
   - Name: `InventorySystem`
   - Click Finish

3. **Add Source Files**:
   - Right-click `src` folder → New → Class
   - Create three classes: `Main`, `InventorySystem`, `Item`
   - Copy the content from each provided file

4. **Run the Program**:
   - Right-click `Main.java` → Run As → Java Application

### Method 2: Command Line Compilation

1. **Save all files** in the same directory

2. **Compile**:
   ```bash
   javac Main.java InventorySystem.java Item.java
   ```

3. **Run**:
   ```bash
   java Main
   ```

## Usage Guide

### Starting the Application

When you run the program, you'll see:

```
===== Welcome to the Enhanced Inventory System =====
Load inventory from file (inventory.txt)? (Y/N): 
```

- Enter `Y` to load previously saved data
- Enter `N` to start with an empty inventory

### Main Menu

```
Choose an option:
1. Add Item
2. View All Items
3. Remove Item
4. Sort Items
5. Save Inventory
6. Exit
Enter choice: 
```

### Adding Items

**Example Flow**:

```
Enter choice: 1
Enter item name: Laptop
Enter item price: 899.99
Enter quantity: 5
Enter category: Electronics
Item added successfully!
```

**Features**:
- Duplicate names are rejected
- Price must be a valid decimal number
- Quantity must be a whole number
- Category is a text field

### Viewing Inventory

```
Enter choice: 2

===== Current Inventory =====
Name: Laptop         | Price: $899.99   | Qty: 5     | Category: Electronics
Name: Mouse          | Price: $25.50    | Qty: 20    | Category: Accessories
Name: Keyboard       | Price: $75.00    | Qty: 15    | Category: Accessories
```

### Removing Items

```
Enter choice: 3
Enter the name of the item to remove: Mouse
Item removed successfully!
```

**Note**: Item names are case-insensitive

### Sorting Items

```
Enter choice: 4
Sort by:
1. Name (A—Z)
2. Price (Low—High)
Enter choice: 1
Items sorted by name.
```

**Sorting Options**:
- **By Name**: Alphabetical order (case-insensitive)
- **By Price**: Ascending order (lowest to highest)

### Saving Inventory

```
Enter choice: 5
Inventory saved to inventory.txt
```

**Auto-Save**: Inventory is automatically saved when you exit (option 6)

### Exiting the Program

```
Enter choice: 6
Inventory saved to inventory.txt
Exiting program. Goodbye!
```

## Data Persistence

### File Format

The inventory is saved to `inventory.txt` in CSV format:

```
Laptop,899.99,5,Electronics
Mouse,25.50,20,Accessories
Keyboard,75.00,15,Accessories
```

**Format**: `name,price,quantity,category`

### Loading Data

- **Automatic**: When you select "Y" at startup
- **File Location**: Same directory as the program
- **Error Handling**: Invalid lines are skipped with a message

### Manual File Editing

You can manually edit `inventory.txt`:

1. Open the file in a text editor
2. Follow the format: `name,price,quantity,category`
3. Save the file
4. Load it when starting the program

**Example**:
```
Smartphone,699.00,10,Electronics
Headphones,149.99,25,Accessories
Tablet,399.50,8,Electronics
```

## Class Documentation

### Item.java

**Purpose**: Represents a single inventory item

**Fields**:
- `String name` - Item name
- `double price` - Item price
- `int quantity` - Stock quantity
- `String category` - Item category

**Methods**:
- `getName()` - Returns item name
- `getPrice()` - Returns item price
- `getQuantity()` - Returns quantity
- `getCategory()` - Returns category
- `toString()` - Formatted string for display
- `toFileString()` - CSV format for file saving
- `fromFileString(String)` - Creates Item from CSV string

### InventorySystem.java

**Purpose**: Main system logic and user interface

**Fields**:
- `ArrayList<Item> inventory` - List of all items
- `Scanner scanner` - User input handler
- `FILE_NAME` - Constant for save file name

**Methods**:
- `start()` - Main program loop
- `addItem()` - Add new item with validation
- `viewItems()` - Display all items
- `removeItem()` - Remove item by name
- `sortItems()` - Sort inventory
- `saveToFile()` - Save to `inventory.txt`
- `loadFromFile()` - Load from `inventory.txt`
- `getIntInput()` - Validated integer input
- `getDoubleInput()` - Validated double input

### Main.java

**Purpose**: Application entry point

**Method**:
- `main(String[] args)` - Creates and starts InventorySystem

## Input Validation

The system validates all user input:

### Integer Validation
```
Enter choice: abc
Invalid input. Please enter a whole number: 
```

### Double Validation
```
Enter item price: invalid
Invalid input. Please enter a valid number: 
```

### Duplicate Detection
```
Enter item name: Laptop
Error: An item with this name already exists.
```

### Empty Inventory Handling
```
Inventory is empty. Nothing to sort.
```

## Example Usage Scenarios

### Scenario 1: Electronics Store

```
Add Items:
1. Laptop      - $899.99  - 5 units   - Electronics
2. Smartphone  - $699.00  - 10 units  - Electronics
3. Headphones  - $149.99  - 25 units  - Accessories

Sort by Price:
1. Headphones  - $149.99
2. Smartphone  - $699.00
3. Laptop      - $899.99
```

### Scenario 2: Office Supplies

```
Add Items:
1. Pen         - $1.50    - 100 units - Stationery
2. Notebook    - $3.99    - 50 units  - Stationery
3. Stapler     - $12.00   - 20 units  - Tools

Sort by Name:
1. Notebook    - $3.99
2. Pen         - $1.50
3. Stapler     - $12.00
```

### Scenario 3: Persistent Storage

```
Session 1:
- Add: Laptop, Mouse, Keyboard
- Exit (auto-saves)

Session 2:
- Load: Y (loads 3 items)
- Add: Monitor
- View: Shows all 4 items
```

## Troubleshooting

### Issue: "No save file found"

**Cause**: First time running or `inventory.txt` was deleted

**Solution**: This is normal! Just start adding items and save them.

### Issue: Compilation Errors

**Cause**: Missing class files or incorrect directory

**Solution**:
```bash
# Ensure all three files are in the same directory
ls *.java
# Should show: Main.java  InventorySystem.java  Item.java

# Compile all together
javac *.java
```

### Issue: "Error loading inventory"

**Cause**: Corrupted `inventory.txt` file

**Solution**:
1. Open `inventory.txt` in a text editor
2. Check format: `name,price,quantity,category`
3. Fix any malformed lines or delete the file to start fresh

### Issue: Scanner Not Reading Input

**Cause**: Eclipse console configuration

**Solution**:
- Run → Run Configurations → Common tab
- Check "Allocate console"
- Apply and run again

### Issue: File Not Saving

**Cause**: Permission issues or incorrect path

**Solution**:
```bash
# Check write permissions
ls -l inventory.txt  # Linux/Mac
dir inventory.txt    # Windows

# Run from correct directory
pwd  # Check current directory
```

## Advanced Features

### Case-Insensitive Operations

All name comparisons are case-insensitive:
- `"Laptop"` = `"laptop"` = `"LAPTOP"`

### Automatic Data Cleanup

Invalid entries in `inventory.txt` are automatically skipped during loading.

### Flexible Categories

Categories are free-form text:
- Electronics
- Accessories
- Office Supplies
- Stationery
- Tools
- Furniture
- Any custom category

## Code Quality Features

- ✅ **OOP Principles**: Proper encapsulation and separation of concerns
- ✅ **Clean Code**: Meaningful variable names and method names
- ✅ **Error Handling**: Try-catch blocks for file operations
- ✅ **Input Validation**: Robust handling of user input
- ✅ **Modular Design**: Separate classes for different responsibilities
- ✅ **Code Reusability**: Generic input methods

## Future Enhancements

Potential features for future versions:

- 🔍 **Search Functionality**: Find items by name or category
- 📊 **Advanced Statistics**: Total value, low stock alerts
- 💰 **Price Updates**: Modify existing item prices
- 📈 **Stock Management**: Increase/decrease quantities
- 🏷️ **Category Filtering**: View items by category only
- 📋 **Export Formats**: JSON, XML, Excel export
- 🔐 **User Authentication**: Password protection
- 🌐 **Database Integration**: MySQL/PostgreSQL support
- 📱 **GUI Version**: JavaFX or Swing interface
- 📝 **Transaction Log**: Track all inventory changes
- 🔔 **Notifications**: Low stock warnings
- 💵 **Currency Support**: Multiple currency formats

## Support

For issues or questions:

1. **Compilation Issues**: Verify Java version with `java -version`
2. **File Problems**: Check file permissions and location
3. **Input Issues**: Ensure proper data types are entered
4. **Eclipse Problems**: Clean and rebuild project (Project → Clean)


**Language**: Java 8+  
**IDE**: Eclipse (recommended)  
**Dependencies**: None (uses standard Java libraries)
