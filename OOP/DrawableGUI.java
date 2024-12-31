import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawableGUI {
    private Shape[] drawables;
    private int index = 0;

    private JTextField typeField;
    private JTextField sizeField;
    private JTextField colorField;
    private JTextArea outputArea;
    private JFrame frame;

    public DrawableGUI(int size) {
        drawables = new Shape[size];
    }

    public void createGUI() {
        frame = new JFrame("Drawable OOP Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.CYAN);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel typeLabel = new JLabel("Circle/Cube: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(typeLabel, gbc);

        typeField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(typeField, gbc);

        JLabel sizeLabel = new JLabel("Radius/Side: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(sizeLabel, gbc);

        sizeField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(sizeField, gbc);

        JLabel colorLabel = new JLabel("Shape Color: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(colorLabel, gbc);

        colorField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(colorField, gbc);

        JButton addButton = new JButton("أضف الشكل");
        JButton calculateButton = new JButton("مجموع مساحاتهم");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        panel.add(addButton, gbc);

        gbc.gridy = 4;
        panel.add(calculateButton, gbc);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBackground(Color.black);
        outputArea.setForeground(Color.white);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleAddShape();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleCalculateTotalArea();
            }
        });

        frame.setVisible(true);
    }

    private void handleAddShape() {
        String type = typeField.getText().trim();
        String color = colorField.getText().trim();
        if (color.isEmpty()) {
            color = "null";
        }
        double size;

        try {
            size = Double.parseDouble(sizeField.getText().trim());

            if (index >= drawables.length) {
                JOptionPane.showMessageDialog(frame, "ممتلئة لا يمكن إضافة اكثر من 2", "خطأ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            switch (type.toLowerCase()) {
                case "circle":
                    drawables[index++] = new Circle(color, size);
                    outputArea.append("تمت إضافة: دائرة بنصف قطر " + size + " ولونها " + color + "\n");
                    break;
                case "cube":
                    drawables[index++] = new Cube(color, size);
                    outputArea.append("تمت إضافة : مكعب بجانب " + size + " ولونه " + color + "\n");
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "شكل غير مسموح ، يمكنك فقط إضافة دائرة ومكعب", "خطأ", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "مساحة خاطئة : من فضلك ادخل رقم صحيح", "خطأ", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleCalculateTotalArea() {
        double totalArea = 0;
        for (int i = 0; i < index; i++) {
            Shape shape = drawables[i];
            totalArea += shape.getArea();
        }
        outputArea.append("\nمجموع مساحات الاشكال : " + totalArea + "\n");
    }

    public static void main(String[] args) {
        DrawableGUI gui = new DrawableGUI(10);
        gui.createGUI();
    }
}
