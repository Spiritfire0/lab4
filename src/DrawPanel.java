import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Just a single image, TODO: Generalize
    Dictionary<Car,BufferedImage> carToImage;
    // To keep track of a list of single cars position
    Point carPoint = new Point();
    ArrayList<Car> cars;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.cars = cars;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
        // Print an error message in case file is not found with a try/catch block
        for (Car car : cars) {
            try {
                String imgPath = "pics/" + car.modelName + ".jpg";
                carToImage.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream(imgPath)));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Car car: cars) {
            int x = (int) Math.round(car.getPosition()[0]);
            int y = (int) Math.round(car.getPosition()[1]);
            g.drawImage(carToImage.get(car), x, y, null); // see javadoc for more info on the parameters
        }

    }
}
