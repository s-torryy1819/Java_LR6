package lr6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Task14 extends Frame implements ActionListener {

    private TextArea textArea;
    private Button blackButton;
    private Button redButton;
    private Button greenButton;
    private Button blueButton;
    private Button size12Button;
    private Button size14Button;
    private Button size16Button;

    public Task14() {
        setTitle("Text Editor");

        textArea = new TextArea("Text display");
        blackButton = new Button("Black");
        redButton = new Button("Red");
        greenButton = new Button("Green");
        blueButton = new Button("Blue");
        size12Button = new Button("12pt");
        size14Button = new Button("14pt");
        size16Button = new Button("16pt");

        // Додавання слухачів подій до кнопок
        blackButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        size12Button.addActionListener(this);
        size14Button.addActionListener(this);
        size16Button.addActionListener(this);

        updateButtonStyles();

        setLayout(new BorderLayout());

        Panel toolBarPanel = new Panel();
        toolBarPanel.add(blackButton);
        toolBarPanel.add(redButton);
        toolBarPanel.add(greenButton);
        toolBarPanel.add(blueButton);
        toolBarPanel.add(size12Button);
        toolBarPanel.add(size14Button);
        toolBarPanel.add(size16Button);

        add(toolBarPanel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);

        // Закриття вікна
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Визначення дій при натисканні на кожну кнопку
        if (e.getSource() == blackButton) {
            textArea.setForeground(Color.BLACK);
        } else if (e.getSource() == redButton) {
            textArea.setForeground(Color.RED);
        } else if (e.getSource() == greenButton) {
            textArea.setForeground(Color.GREEN);
        } else if (e.getSource() == blueButton) {
            textArea.setForeground(Color.BLUE);
        } else if (e.getSource() == size12Button) {
            textArea.setFont(new Font("Arial", Font.PLAIN, 12));
        } else if (e.getSource() == size14Button) {
            textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        } else if (e.getSource() == size16Button) {
            textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        }
    }

    private void updateButtonStyles() {
        // Оновлення написів на кнопках відповідно до кольору та шрифту текстової області
        blackButton.setForeground(Color.BLACK);
        redButton.setForeground(Color.RED);
        greenButton.setForeground(Color.GREEN);
        blueButton.setForeground(Color.BLUE);

        size12Button.setFont(new Font("Arial", Font.PLAIN, 12));
        size14Button.setFont(new Font("Arial", Font.PLAIN, 14));
        size16Button.setFont(new Font("Arial", Font.PLAIN, 16));
    }
}
