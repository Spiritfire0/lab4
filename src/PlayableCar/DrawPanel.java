package PlayableCar;

import WhatIsACar.Car;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    HashMap<Car,BufferedImage> carToImage;
    // To keep track of a list of single cars position
    ComponentHolder componentHolder;

    JFrame frame = new JFrame();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ComponentHolder ch) {
        this.carToImage = new HashMap<Car, BufferedImage>();
        this.componentHolder = ch;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        // Print an error message in case file is not found with a try/catch block
        for (AvailableCars car : AvailableCars.values()) {
            try {
                String imgPath = "/pics/" + car + ".jpg";
                carToImage.put(car.toString(), ImageIO.read(DrawPanel.class.getResourceAsStream(imgPath)));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Car car: componentHolder.components) {
            int x = (int) Math.round(car.getPosition()[0]);
            int y = (int) Math.round(car.getPosition()[1]);
            g.drawImage(carToImage.get(car.modelName), x, y + 94 * componentHolder.components.indexOf(car), null);
            // see javadoc for more info on the parameters
        }

    }
}
