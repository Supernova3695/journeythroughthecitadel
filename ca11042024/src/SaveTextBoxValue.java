import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import javax.swing.ImageIcon;

public class SaveTextBoxValue extends JFrame{
    private static JLabel directionsLabel = new JLabel("Enter name");
    private static JLabel outputLabel = new JLabel();
    private static JTextField nameBox = new JTextField(25);
    private static JButton nameButton = new JButton("Save");
    private static JButton startGameButton = new JButton("Start");
    public static void main(String[] args) throws Exception {
        SaveTextBoxValue window = new SaveTextBoxValue();
        window.setSize(500,500);
        window.setVisible(true);
        window.setTitle("Cobalt Assault");

        window.setLayout(new FlowLayout());
        //window.setLayout(new GridLayout(3, 2));

        //color/format
        window.getContentPane().setBackground(new Color(71, 71, 71));
        nameBox.setForeground(new Color(71, 71, 71));
        //directionsLabel.setFont(new Font("SansSeriff", Font.PLAIN, 18));

        window.getContentPane().add(directionsLabel);
        window.getContentPane().add(nameBox);
        window.getContentPane().add(nameButton);
        window.getContentPane().add(startGameButton);
        window.getContentPane().add(outputLabel);

        

        //add an action listener
        nameButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                buttonClick(e);//function that handles the event
                String text = nameBox.getText(); 
                saveToFile(text); 
            }
        });
        startGameButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                buttonClick(e);//function that handles the event
                 
                
            }
        });

        //add swing objects here
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end of main
    public static void buttonClick(ActionEvent e){
        //code to respond to button
        //JOptionPane.showMessageDialog(null, "Button Works!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        String username = nameBox.getText();
        String outputMessage = "Hello there " + username;
        outputLabel.setText(outputMessage);
    }
        private static void saveToFile(String text) { 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("names.txt", true))) { 
            writer.write(text); 
            writer.newLine(); // Adds a new line after the text 
            JOptionPane.showMessageDialog(null, "Name saved successfully to file names.txt!"); 
        } catch (IOException e) { 
            JOptionPane.showMessageDialog(null, "Error saving text: " + e.getMessage()); 
        } 
        } 
}
