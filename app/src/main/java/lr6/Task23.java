package lr6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task23 extends Frame implements ActionListener {
    private Canvas canvas;
    private CheckboxGroup colorCheckboxGroup;
    private Checkbox blackCheckbox, redCheckbox, greenCheckbox, blueCheckbox;
    private TextField centerXField, centerYField, semiMajorField, semiMinorField;

    public Task23() {
        setTitle("Elips drawing");

        canvas = new Canvas();
        canvas.setSize(400, 400);

        Panel parametersPanel = new Panel(new GridLayout(5, 2));
        parametersPanel.add(new Label("Color:"));

        colorCheckboxGroup = new CheckboxGroup();
        blackCheckbox = new Checkbox("Black", colorCheckboxGroup, true);
        redCheckbox = new Checkbox("Red", colorCheckboxGroup, false);
        greenCheckbox = new Checkbox("Green", colorCheckboxGroup, false);
        blueCheckbox = new Checkbox("Blue", colorCheckboxGroup, false);

        parametersPanel.add(blackCheckbox);
        parametersPanel.add(redCheckbox);
        parametersPanel.add(greenCheckbox);
        parametersPanel.add(blueCheckbox);
        parametersPanel.add(new Label("\n\nCoordinate of 'x' center:"));
        centerXField = new TextField();
        parametersPanel.add(centerXField);
        parametersPanel.add(new Label("\nCoordinate of 'y' center:"));
        centerYField = new TextField();
        parametersPanel.add(centerYField);
        parametersPanel.add(new Label("\nHalf axis 'a':"));
        semiMajorField = new TextField();
        parametersPanel.add(semiMajorField);
        parametersPanel.add(new Label("\nHalf axis 'b':"));
        semiMinorField = new TextField();
        parametersPanel.add(semiMinorField);

        Button drawButton = new Button("Display Elips");
        drawButton.addActionListener(this);

        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(parametersPanel, BorderLayout.SOUTH);
        add(drawButton, BorderLayout.NORTH);

        setSize(500, 500);
        setVisible(true);

        // Закриття вікна
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (validateInput()) {
            drawEllipse();
        } else {
            // Вивести повідомлення про помилку, якщо введені дані некоректні
            System.out.println("Data is not correct. Please enter correct coordinates and half axes");
        }
    }

    private boolean validateInput() {
        try {
            Integer.parseInt(centerXField.getText());
            Integer.parseInt(centerYField.getText());
            Integer.parseInt(semiMajorField.getText());
            Integer.parseInt(semiMinorField.getText());
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private void drawEllipse() {
        int centerX = Integer.parseInt(centerXField.getText());
        int centerY = Integer.parseInt(centerYField.getText());
        int semiMajor = Integer.parseInt(semiMajorField.getText());
        int semiMinor = Integer.parseInt(semiMinorField.getText());

        // Визначення кольору для малювання еліпса
        Color ellipseColor;
        if (blackCheckbox.getState()) {
            ellipseColor = Color.BLACK;
        } else if (redCheckbox.getState()) {
            ellipseColor = Color.RED;
        } else if (greenCheckbox.getState()) {
            ellipseColor = Color.GREEN;
        } else {
            ellipseColor = Color.BLUE;
        }

        // Визначення координат та розмірів для малювання еліпса
        int x = centerX - semiMajor;
        int y = centerY - semiMinor;
        int width = 2 * semiMajor;
        int height = 2 * semiMinor;

        Graphics g = canvas.getGraphics();
        g.setColor(ellipseColor);
        g.drawOval(x, y, width, height);
    }
}
