package lr6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Task6 extends Frame {
    private TextField textField;
    private Choice fontChoice;
    private Choice colorChoice;
    private Canvas canvas;

    public Task6() {
        setTitle("Row display:");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Верхня панель
        Label label = new Label("Row:");
        add(label);

        textField = new TextField(20);
        add(textField);

        Label fontLabel = new Label("Garniture:");
        add(fontLabel);

        fontChoice = new Choice();
        fontChoice.add("Times New Roman");
        fontChoice.add("Arial");
        fontChoice.add("Verdana");
        add(fontChoice);

        Label colorLabel = new Label("Color:");
        add(colorLabel);

        colorChoice = new Choice();
        colorChoice.add("Black");
        colorChoice.add("Red");
        colorChoice.add("Green");
        colorChoice.add("Blue");
        add(colorChoice);

        Button displayButton = new Button("Display a Row");
        add(displayButton);

        // Нижня панель
        canvas = new Canvas();
        canvas.setSize(380, 150);
        add(canvas);
        setVisible(true);

        // Обробник події для кнопки "Вивести рядок"
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText();
            }
        });

        // Закриття вікна
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    private void displayText() {
        String text = textField.getText();
        String fontName = fontChoice.getSelectedItem();
        String colorName = colorChoice.getSelectedItem();

        // Встановлюємо шрифт
        Font selectedFont = new Font(fontName, Font.PLAIN, 14); // Розмір 14 за замовчуванням

        // Встановлюємо колір
        Color color;
        switch (colorName) {
            case "Black":
                color = Color.BLACK;
                break;
            case "Red":
                color = Color.RED;
                break;
            case "Green":
                color = Color.GREEN;
                break;
            case "Blue":
                color = Color.BLUE;
                break;
            default:
                color = Color.BLACK; // за замовчуванням
        }

        // Виводимо рядок на Canvas
        Graphics g = canvas.getGraphics();
        g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g.setColor(color);
        g.setFont(selectedFont);
        g.drawString(text, 50, 80);
    }
}
