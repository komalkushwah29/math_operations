import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Code_2 extends JFrame implements ActionListener {

    private JTextField inputField;
    private JTextArea resultArea;
    private JButton generateButton;
    private JComboBox<String> operationBox;

    public Code_2() {
        setTitle("Math Operations");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window

        // Main content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setBackground(Color.WHITE);
        JLabel inputLabel = new JLabel("Enter a number:");
        inputLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        inputField = new JTextField(10);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        // Operation Panel
        JPanel operationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        operationPanel.setBackground(Color.WHITE);
        JLabel operationLabel = new JLabel("Select Operation:");
        operationLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        String[] operations = { "Multiplication Table", "Square", "Cube", "Factorial" };
        operationBox = new JComboBox<>(operations);
        operationBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        operationPanel.add(operationLabel);
        operationPanel.add(operationBox);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);
        generateButton = new JButton("Generate");
        generateButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        generateButton.setBackground(new Color(70, 130, 180));
        generateButton.setForeground(Color.WHITE);
        generateButton.setFocusPainted(false);
        generateButton.addActionListener(this);
        buttonPanel.add(generateButton);

        // Result Area
        resultArea = new JTextArea(10, 35);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Result"));

        // Add all panels
        contentPanel.add(inputPanel);
        contentPanel.add(operationPanel);
        contentPanel.add(buttonPanel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPanel.add(scrollPane);

        add(contentPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputText = inputField.getText().trim();
        String selectedOperation = (String) operationBox.getSelectedItem();

        try {
            int number = Integer.parseInt(inputText);
            StringBuilder result = new StringBuilder();

            switch (selectedOperation) {
                case "Multiplication Table":
                    result.append("Multiplication Table for ").append(number).append(":\n");
                    for (int i = 1; i <= 10; i++) {
                        result.append(number).append(" x ").append(i).append(" = ").append(number * i).append("\n");
                    }
                    break;

                case "Square":
                    result.append("Square of ").append(number).append(" is ").append(number * number);
                    break;

                case "Cube":
                    result.append("Cube of ").append(number).append(" is ").append(number * number * number);
                    break;

                case "Factorial":
                    long fact = 1;
                    for (int i = 1; i <= number; i++) {
                        fact *= i;
                    }
                    result.append("Factorial of ").append(number).append(" is ").append(fact);
                    break;
            }

            resultArea.setText(result.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Code_2().setVisible(true));
    }
}
