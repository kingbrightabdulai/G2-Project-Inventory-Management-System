import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InventoryUI extends JFrame {
    private JTextField nameField, quantityField, priceField, descriptionField;
    private JButton addButton, updateButton, deleteButton, clearButton;
    private JTable inventoryTable;
    private DefaultTableModel tableModel;
    private JLabel totalItemsLabel, totalValueLabel;
    private List<Item> inventory;

    public InventoryUI() {
        inventory = new ArrayList<>();
        setTitle("Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Item Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        addButton = new JButton("Add Item");
        updateButton = new JButton("Update Item");
        deleteButton = new JButton("Delete Item");
        clearButton = new JButton("Clear All");

        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        inputPanel.add(clearButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table Panel
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Quantity", "Price", "Total Value", "Description"}, 0);
        inventoryTable = new JTable(tableModel);
        add(new JScrollPane(inventoryTable), BorderLayout.CENTER);

        // Statistics Panel
        JPanel statsPanel = new JPanel();
        totalItemsLabel = new JLabel("Total Items: 0");
        totalValueLabel = new JLabel("Total Inventory Value: $0.00");
        statsPanel.add(totalItemsLabel);
        statsPanel.add(totalValueLabel);

        add(statsPanel, BorderLayout.SOUTH);

        // Action Listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateItem();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItem();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        // Load Sample Data
        loadSampleData();
        updateStatistics();
    }

    private void loadSampleData() {
        // Sample data for initialization
        addItemToTable(new Item("Sample Item 1", 10, 5.0, "Sample Description 1"));
        addItemToTable(new Item("Sample Item 2", 20, 3.0, "Sample Description 2"));
    }

    private void addItem() {
        String name = nameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());
        String description = descriptionField.getText();
        addItemToTable(new Item(name, quantity, price, description));
        clearFields();
        updateStatistics();
    }

    private void addItemToTable(Item item) {
        int id = tableModel.getRowCount() + 1;
        double totalValue = item.quantity * item.price;
        tableModel.addRow(new Object[]{id, item.name, item.quantity, item.price, totalValue, item.description});
        inventory.add(item);
    }

    private void updateItem() {
        // Logic to update selected item
    }

    private void deleteItem() {
        // Logic to delete selected item
    }

    private void clearFields() {
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
        descriptionField.setText("");
    }

    private void updateStatistics() {
        totalItemsLabel.setText("Total Items: " + inventory.size());
        double totalValue = inventory.stream().mapToDouble(item -> item.quantity * item.price).sum();
        totalValueLabel.setText(String.format("Total Inventory Value: $%.2f", totalValue));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InventoryUI().setVisible(true);
            }
        });
    }

    class Item {
        String name;
        int quantity;
        double price;
        String description;

        public Item(String name, int quantity, double price, String description) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.description = description;
        }
    }
}