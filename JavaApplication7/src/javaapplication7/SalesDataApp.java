
package javaapplication7;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SalesDataApp extends JFrame {

    private JButton loadButton;
    private JButton saveButton;
    private JTextArea salesTextArea;
    private JLabel yearsLabel;

    public SalesDataApp() {
        // Frame setup
        setTitle("Sales Data Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Top panel with buttons and label
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        loadButton = new JButton("Load Data");
        saveButton = new JButton("Save Data");
        yearsLabel = new JLabel("Number of Years: 2");  // read-only label

        topPanel.add(loadButton);
        topPanel.add(saveButton);
        topPanel.add(yearsLabel);

        add(topPanel, BorderLayout.NORTH);

        // Text area to display sales data
        salesTextArea = new JTextArea();
        salesTextArea.setLineWrap(true);
        salesTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(salesTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Button actions
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
    }

    // Load sample sales data into the text area
    private void loadData() {
        String data = "Product\tYear1\tYear2\n";
        data += "Microphone\t300\t250\n";
        data += "Speakers\t150\t200\n";
        data += "Mixing desk\t700\t600\n";
     
        salesTextArea.setText(data);
    }

    // Save text area content to a file
    private void saveData() {
        try (FileWriter writer = new FileWriter("sales_data.txt")) {
            writer.write(salesTextArea.getText());
            JOptionPane.showMessageDialog(this, "Data saved to sales_data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SalesDataApp app = new SalesDataApp();
            app.setVisible(true);
        });
    }
}


