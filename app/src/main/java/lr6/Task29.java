package lr6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Task29 extends Frame implements ActionListener {
    private TextField widthField, heightField;
    private Button resizeButton;
    private ImagePanel imagePanel;

    public Task29() throws IOException {
        setTitle("Image size change tool");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Верхня панель з компонентами для введення розміру зображення
        Panel sizePanel = new Panel();
        sizePanel.add(new Label("Width:"));
        widthField = new TextField(5);
        sizePanel.add(widthField);

        sizePanel.add(new Label("Height:"));
        heightField = new TextField(5);
        sizePanel.add(heightField);

        resizeButton = new Button("Display image");
        resizeButton.addActionListener(this);
        sizePanel.add(resizeButton);

        add(sizePanel, BorderLayout.NORTH);

        // Нижня панель з компонентом для виведення зображення
        imagePanel = new ImagePanel();
        add(imagePanel, BorderLayout.CENTER);


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
        if (validateInput()) {
            int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());
            imagePanel.resizeImage(width, height);
        } else {
            // Вивести повідомлення про помилку, якщо введені дані некоректні
            System.out.println("Incorrect Data. Please enter width and height one more time.");
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

    private class ImagePanel extends Panel {
        private Image originalImage;
        private Image scaledImage;

        public ImagePanel() throws IOException {
            loadImage();  // Завантаження довільного зображення
        }

        private void loadImage() throws IOException {
            URL url = new URL("https://img.freepik.com/premium-vector/smooth-color-wave-vectorcurved-lines-rainbow-abstract-multicolored-wave-flow_206325-1410.jpg");
            Image image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image);
            originalImage = icon.getImage();
            scaledImage = originalImage;
        }

        public void resizeImage(int width, int height) {
            scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            repaint();  // Перемалювати панель для відображення нового зображення
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(scaledImage, 0, 0, this);
        }
    }
}
