import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
public class GadgetShop {
    private ArrayList<Gadget> gadgets;
    private JTextField modelTextField, priceTextField, weightTextField, sizeTextField,
            initialCreditTextField, initialMemoryTextField, phoneNumberTextField,
            durationTextField, downloadSizeTextField, displayNumberTextField;

    // Constructor
    public GadgetShop() {
        gadgets = new ArrayList<>();
    }

    // Method to add a mobile phone to the gadget shop
    public void addMobile(String model, double price, int weight, String size, int initialCredit) {
        Mobile mobile = new Mobile(model, price, weight, size, initialCredit);
        gadgets.add(mobile);
    }

    // Method to add an MP3 player to the gadget shop
    public void addMP3(String model, double price, int weight, String size, int initialMemory) {
        MP3 mp3 = new MP3(model, price, weight, size, initialMemory);
        gadgets.add(mp3);
    }

    // Method to display all gadgets in the gadget shop
public void displayAll() {
    if (gadgets.isEmpty()) {
        System.out.println("No Gadgets to display");
    } else {
        for (int i = 0; i < gadgets.size(); i++) {
            Gadget gadget = gadgets.get(i);
            System.out.println("Display Number: " + i);
            gadget.display();
        }
    }
}

    

    // Method to make a phone call
    public void makeCall(int displayNumber, String phoneNumber, int duration) {
        if (displayNumber >= 0 && displayNumber < gadgets.size()) {
            Gadget gadget = gadgets.get(displayNumber);
            if (gadget instanceof Mobile) {
                Mobile mobile = (Mobile) gadget;
                mobile.makeCall(phoneNumber, duration);
            } else {
                System.out.println("Error: Displayed gadget is not a mobile phone.");
            }
        } else {
            System.out.println("Error: Invalid display number.");
        }
    }

    // Method to download music
    public void downloadMusic(int displayNumber, int downloadSize) {
        if (displayNumber >= 0 && displayNumber < gadgets.size()) {
            Gadget gadget = gadgets.get(displayNumber);
            if (gadget instanceof MP3) {
                MP3 mp3 = (MP3) gadget;
                mp3.downloadMusic(downloadSize);
            } else {
                System.out.println("Error: Displayed gadget is not an MP3 player.");
            }
        } else {
            System.out.println("Error: Invalid display number.");
        }
    }

    // Method to clear all text fields
    public void clearTextFields() {
        modelTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        sizeTextField.setText("");
        initialCreditTextField.setText("");
        initialMemoryTextField.setText("");
        phoneNumberTextField.setText("");
        durationTextField.setText("");
        downloadSizeTextField.setText("");
        displayNumberTextField.setText("");
    }

    // Main method
    public static void main(String[] args) {
        GadgetShop gadgetShop = new GadgetShop();
        gadgetShop.createGUI();
    }

    // Method to create GUI components
    public void createGUI() {
        JFrame frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        // Create text fields
        modelTextField = new JTextField(10);
        priceTextField = new JTextField(10);
        weightTextField = new JTextField(10);
        sizeTextField = new JTextField(10);
        initialCreditTextField = new JTextField(10);
        initialMemoryTextField = new JTextField(10);
        phoneNumberTextField = new JTextField(10);
        durationTextField = new JTextField(10);
        downloadSizeTextField = new JTextField(10);
        displayNumberTextField = new JTextField(10);

        // Create buttons
        JButton addMobileButton = new JButton("Add Mobile");
        JButton addMP3Button = new JButton("Add MP3");
        JButton clearButton = new JButton("Clear");
        JButton displayAllButton = new JButton("Display All");
        JButton makeCallButton = new JButton("Make a Call");
        JButton downloadMusicButton = new JButton("Download Music");

        // Add action listeners to buttons
        addMobileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String model = modelTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                int weight = Integer.parseInt(weightTextField.getText());
                String size = sizeTextField.getText();
                int initialCredit = Integer.parseInt(initialCreditTextField.getText());
                addMobile(model, price, weight, size, initialCredit);
            }
        });

        addMP3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String model = modelTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                int weight = Integer.parseInt(weightTextField.getText());
                String size = sizeTextField.getText();
                int initialMemory = Integer.parseInt(initialMemoryTextField.getText());
                addMP3(model, price, weight, size, initialMemory);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });
makeCallButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            // Parse display number
            int displayNumber = Integer.parseInt(displayNumberTextField.getText());
            // Parse duration
            int duration = Integer.parseInt(durationTextField.getText());
            // Get phone number
            String phoneNumber = phoneNumberTextField.getText();
            
            // Validate display number
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                JOptionPane.showMessageDialog(null, "Invalid display number.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit method if display number is invalid
            }
            
            // Retrieve gadget from the gadgets list
            Gadget gadget = gadgets.get(displayNumber);
            
            // Check if the gadget is an instance of Mobile
            if (gadget instanceof Mobile) {
                // Cast gadget to Mobile
                Mobile mobile = (Mobile) gadget;
                // Call makeCall method
                mobile.makeCall(phoneNumber, duration);
            } else {
                JOptionPane.showMessageDialog(null, "Selected gadget is not a mobile phone.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for display number or duration.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});


downloadMusicButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            // Parse display number
            int displayNumber = Integer.parseInt(displayNumberTextField.getText());
            // Parse download size
            int downloadSize = Integer.parseInt(downloadSizeTextField.getText());
            
            // Validate display number
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                JOptionPane.showMessageDialog(null, "Invalid display number.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit method if display number is invalid
            }
            
            // Retrieve gadget from the gadgets list
            Gadget gadget = gadgets.get(displayNumber);
            
            // Check if the gadget is an instance of MP3
            if (gadget instanceof MP3) {
                // Cast gadget to MP3
                MP3 mp3 = (MP3) gadget;
                // Call downloadMusic method
                mp3.downloadMusic(downloadSize);
            } else {
                JOptionPane.showMessageDialog(null, "Selected gadget is not an MP3 player.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input for display number or download size.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});


        // Add components to panel
        panel.add(new JLabel("Model: "));
        panel.add(modelTextField);
        panel.add(new JLabel("Price: "));
        panel.add(priceTextField);
        panel.add(new JLabel("Weight: "));
        panel.add(weightTextField);
        panel.add(new JLabel("Size: "));
        panel.add(sizeTextField);
        panel.add(new JLabel("Initial Credit: "));
        panel.add(initialCreditTextField);
        panel.add(new JLabel("Initial Memory: "));
        panel.add(initialMemoryTextField);
        panel.add(new JLabel("Phone Number: "));
        panel.add(phoneNumberTextField);
        panel.add(new JLabel("Duration: "));
        panel.add(durationTextField);
        panel.add(new JLabel("Download Size: "));
        panel.add(downloadSizeTextField);
        panel.add(new JLabel("Display Number: "));
        panel.add(displayNumberTextField);
        panel.add(addMobileButton);
        panel.add(addMP3Button);
        panel.add(clearButton);
        panel.add(displayAllButton);
        panel.add(makeCallButton);
        panel.add(downloadMusicButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}