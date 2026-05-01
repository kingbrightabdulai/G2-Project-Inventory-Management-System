# G2 Project - Inventory Management System

## Project Overview

**Inventory Management System** is a Java-based desktop application designed to help businesses manage product inventory efficiently. The system allows users to add, update, delete, and search items within inventory records in real-time. It provides a user-friendly graphical interface with comprehensive inventory statistics.

### Key Features
- ✅ Add, update, and delete inventory items
- ✅ Search items by name
- ✅ Real-time inventory statistics (total value, item count)
- ✅ Low stock item detection
- ✅ User-friendly Java Swing GUI
- ✅ Persistent inventory management
- ✅ Professional data structure implementation (ArrayList with Streams API)

---

## Team Information

**Team:** G2 Project  
**Contributor:** Ibrahim Abdulai

---

## Project Structure

```
G2-Project-Inventory-Management-System/
├── src/
│   ├── InventoryItem.java          (Model class - Ibrahim Abdulai)
│   ├── InventoryManager.java       (Business logic - Ibrahim Abdulai)
│   └── InventoryUI.java            (GUI class - Ibrahim Abdulai)
├── tests/
│   ├── InventoryItemTest.java      (6 unit tests)
│   └── InventoryManagerTest.java   (8 unit tests)
├── build/                          (Compiled classes directory)
├── dist/                           (Executable JAR file)
├── media/                          (Screenshots of running application)
├── build.xml                       (Apache Ant build script)
├── .gitignore                      (Git ignore configuration)
└── README.md                       (This file)
```

---

## Source Files and Their Purpose

### **InventoryItem.java**  
**Contributor:** Ibrahim Abdulai

Model class representing a single inventory item in the system.

**Key Components:**
- Properties: itemID, itemName, quantity, price, description
- Getters and setters for all properties
- `getTotalValue()` - Calculates total value (quantity × price)
- `toString()` - Displays item information
- `equals()` - Compares items by ID

**Complex Data Structures Used:**
- Uses properties to maintain item state

### **InventoryManager.java**  
**Contributor:** Ibrahim Abdulai

Business logic class that manages all inventory operations using an ArrayList data structure.

**Key Components:**
- `addItem()` - Add new items to inventory
- `removeItem()` - Remove items by ID
- `updateItem()` - Update existing item details
- `getItemByID()` - Retrieve item by ID
- `searchByName()` - Search items by name (uses Streams API)
- `getLowStockItems()` - Find items with low stock
- `getTotalInventoryValue()` - Calculate total inventory value
- `getAllItems()` - Retrieve all items

**Complex Data Structures Used:**
- ArrayList<InventoryItem> for storing inventory
- Java Streams API for filtering and mapping
- Lambda expressions for functional operations

### **InventoryUI.java**  
**Contributor:** Ibrahim Abdulai

Graphical User Interface class using Java Swing for user interaction.

**Key Components:**
- Input panel for adding/updating items
- Table panel displaying all inventory items
- Statistics panel showing total items and inventory value
- Action listeners for all operations (add, update, delete, search)
- Sample data loader for demonstration

**GUI Features:**
- JTextField inputs for item details
- JTable for displaying inventory
- JButtons for all operations
- JOptionPane for error messages and confirmations
- Real-time statistics updates

**Complex Data Structures Used:**
- DefaultTableModel for table management
- Event handling with ActionListener

---

## Interface Functionality

### Main Window
The application opens with a professional interface containing three main sections:

#### **1. Input Section (Top)**
- **Item Name:** Text field to enter the product name
- **Quantity:** Numeric field for item quantity
- **Price:** Numeric field for item price
- **Description:** Text field for item details
- **Buttons:**
  - Add Item: Add new item to inventory
  - Update Item: Modify selected item
  - Delete Item: Remove selected item
  - Clear All: Remove all items (with confirmation)

#### **2. Search Section**
- **Search Field:** Enter text to search items by name
- **Search Button:** Execute search operation
- **Refresh Button:** Display all items again

#### **3. Table Section (Center)**
Displays all inventory items in a table with columns:
- ID
- Item Name
- Quantity
- Price
- Total Value (auto-calculated)
- Description

#### **4. Statistics Section (Bottom)**
- Total Items: Shows the count of all items
- Total Inventory Value: Shows combined value of all items

---

## How to Run the Application

### Option 1: Run from Source Code (Direct Java)

1. Navigate to the project directory:
   ```bash
   cd G2-Project-Inventory-Management-System
   ```

2. Compile all Java files:
   ```bash
   javac src/*.java
   ```

3. Run the application:
   ```bash
   java -cp src InventoryUI
   ```

### Option 2: Using Apache Ant (Recommended)

1. Install Apache Ant (if not already installed)

2. Navigate to the project directory:
   ```bash
   cd G2-Project-Inventory-Management-System
   ```

3. Run the application:
   ```bash
   ant run
   ```

### Option 3: Run from JAR File

1. Build the JAR file:
   ```bash
   ant jar
   ```

2. Run the JAR file:
   ```bash
   java -jar dist/InventoryManagementSystem.jar
   ```

---

## Testing

The project includes comprehensive unit tests for all core classes.

### Run All Tests

```bash
ant run-tests
```

### Individual Test Execution

**Test InventoryItem class:**
```bash
cd tests
javac -cp ../src InventoryItemTest.java
java -cp ..:. InventoryItemTest
```

**Test InventoryManager class:**
```bash
cd tests
javac -cp ../src InventoryManagerTest.java
java -cp ..:. InventoryManagerTest
```

### Test Coverage

**InventoryItemTest.java (6 tests):**
1. Constructor and Getters
2. Setters
3. Total Value Calculation
4. Zero Quantity Total Value
5. Equals Method
6. ToString Method

**InventoryManagerTest.java (8 tests):**
1. Add Item
2. Remove Item
3. Update Item
4. Get Item By ID
5. Search By Name
6. Low Stock Items Detection
7. Total Inventory Value Calculation
8. Get Item Count

---

## Building the JAR File

### Using Ant

The easiest way to create the JAR file:

```bash
ant jar
```

This creates: `dist/InventoryManagementSystem.jar`

### Manual Compilation

```bash
# Compile source files
javac src/*.java

# Create manifest file (MANIFEST.MF)
echo "Main-Class: InventoryUI" > MANIFEST.MF

# Create JAR file
jar cfm dist/InventoryManagementSystem.jar MANIFEST.MF -C src .

# Run JAR file
java -jar dist/InventoryManagementSystem.jar
```

---

## System Requirements

- **Java Version:** JDK 8 or higher
- **Operating System:** Windows, macOS, or Linux
- **RAM:** Minimum 256 MB
- **Disk Space:** Minimum 10 MB

---

## Complex Data Structures Explanation

### 1. ArrayList Implementation
The `InventoryManager` class uses `ArrayList<InventoryItem>` to store inventory items:
```java
private ArrayList<InventoryItem> inventory;
```

**Advantages:**
- Dynamic size (grows as items are added)
- Fast random access by index
- Supports standard collection operations

### 2. Java Streams API
Modern functional programming approach for data filtering:
```java
return inventory.stream()
    .filter(item -> item.getItemName().toLowerCase().contains(name.toLowerCase()))
    .collect(Collectors.toList());
```

**Benefits:**
- Concise and readable code
- Lazy evaluation
- Supports lambda expressions
- Enables functional-style operations

### 3. Lambda Expressions
Used throughout the application for event handling and data processing:
```java
addButton.addActionListener(e -> handleAddItem());
```

---

## Technologies Used

- **Language:** Java (JDK 8+)
- **GUI Framework:** Java Swing
- **Build Tool:** Apache Ant
- **Data Structures:** ArrayList, Java Streams API
- **Version Control:** Git & GitHub
- **Testing:** JUnit-style custom assertions

---

## Screenshots

Screenshots of the running application are located in the `media/` folder:
- `screenshot1.png` - Initial application window
- `screenshot2.png` - Adding new item
- `screenshot3.png` - Populated inventory view

---

## Credits and Attribution

### Developers
- **Ibrahim Abdulai** - Created all three core classes (InventoryItem, InventoryManager, InventoryUI), unit tests, and documentation

### Resources and References

1. **Java Swing Tutorial** - Oracle Java Documentation
   - Used for GUI implementation
   - JTable, JFrame, JPanel, and event handling concepts

2. **Java ArrayList & Streams API** - Oracle Java Documentation
   - Collections framework best practices
   - Functional programming patterns

3. **Apache Ant Documentation** - Apache Software Foundation
   - Build automation setup

### External Resources
- Java Standard Library (java.util, javax.swing)
- IDE: Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans)

---

## Future Enhancement Ideas

1. **Database Integration** - Add persistent storage using SQLite or MySQL
2. **User Authentication** - Add login system for different users
3. **Export Features** - Export inventory to CSV or PDF
4. **Barcode Support** - Implement barcode scanning for items
5. **Multi-user Support** - Network-based inventory sharing
6. **Advanced Reports** - Generate detailed inventory reports
7. **Mobile App** - Create mobile version for on-the-go management
8. **Undo/Redo Functionality** - Add operation history

---

## License

This project is created for educational purposes as part of the G2 Project team assignment.

---

## Support and Questions

For questions or issues regarding this project, please contact:
- **Ibrahim Abdulai** - Team Lead

---

## Version History

- **Version 1.0** (2026-05-01) - Initial release with full CRUD operations, GUI, and comprehensive testing

---

## Conclusion

The Inventory Management System provides a complete solution for managing product inventory with a professional GUI, comprehensive testing, and well-documented code. The project demonstrates the use of complex data structures (ArrayList with Streams API), event-driven programming, and software engineering best practices.

Thank you for using the Inventory Management System!