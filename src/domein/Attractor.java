package domein;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Jodi
 */
public class Attractor {

    private final Vector pos;

    public Attractor(double x, double y) {
        pos = new Vector(x, y);
    }

    public Vector getPos() {
        return pos;
    }

    public void setX(double x) {
        this.pos.setX(x);
    }

    public void setY(double y) {
        this.pos.setY(y);
    }

    public void draw(GraphicsContext gtx) {
        gtx.setFill(Color.WHITE);
        gtx.fillOval(pos.getX(), pos.getY(), 5, 5);
    }
}
