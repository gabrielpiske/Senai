import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Combo Box Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        
        JButton button = new JButton("Show Selected Item");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                JOptionPane.showMessageDialog(panel, "Selected Item: " + selected);
            }
        });
        
        panel.add(comboBox);
        panel.add(button);
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
