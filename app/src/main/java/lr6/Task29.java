package lr6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task29 extends JFrame implements ActionListener {
    private JTextField widthField, heightField;
    private JButton resizeButton;
    private ImagePanel imagePanel;

    public Task29() {
        setTitle("Picture size change");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Верхня панель з компонентами для введення розміру зображення
        JPanel sizePanel = new JPanel();
        sizePanel.add(new JLabel("Width:"));
        widthField = new JTextField(5);
        sizePanel.add(widthField);
        sizePanel.add(new JLabel("Height:"));
        heightField = new JTextField(5);
        sizePanel.add(heightField);
        resizeButton = new JButton("Display picture");
        resizeButton.addActionListener(this);
        sizePanel.add(resizeButton);

        // Нижня панель з компонентом для виведення зображення
        imagePanel = new ImagePanel();

        // Розташування компонентів у вікні
        setLayout(new BorderLayout());
        add(sizePanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);

        pack();  // Автоматично розмістити компоненти у вікні
        setLocationRelativeTo(null);  // Розміщення вікна по центру екрану
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
            int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());
            imagePanel.resizeImage(width, height);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect data, please enter correct width and height",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateInput() {
        try {
            int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());
            return width > 0 && height > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private class ImagePanel extends JPanel {
        private Image originalImage;
        private Image scaledImage;

        public ImagePanel() {
            loadImage();  // Завантаження довільного зображення
        }

        private void loadImage() {
            //  логіка завантаження зображення
            // Наприклад, можна використати ImageIcon:
            ImageIcon icon = new ImageIcon("tree-736885_1280");
            originalImage = icon.getImage();
            scaledImage = originalImage;
        }

        public void resizeImage(int width, int height) {
            scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            repaint();  // Перемалювати панель для відображення нового зображення
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaledImage, 0, 0, this);
        }
    }
}
