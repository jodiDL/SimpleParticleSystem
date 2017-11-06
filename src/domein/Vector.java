package domein;

/**
 *
 * @author Jodi
 */
public class Vector {
    private double x,y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void touchObject(){
        this.x = -x * 0.3;
        this.y = -y * 0.3;
    }
    
    public void add(Vector v){
       this.x += v.getX();
       this.y += v.getY();
    }
    
    public double magSq() {
        double x = this.x;
        double y = this.y;
        return (x*x + y*y);
    }
    
    public void setMag(double mag){
        double old_mag = Math.sqrt((x*x + y*y));
        
        this.x = x * mag / old_mag;
        this.y = y * mag / old_mag;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    @Override
    public String toString(){
        return "("+x + ", " + y +")";
    }
    
}
