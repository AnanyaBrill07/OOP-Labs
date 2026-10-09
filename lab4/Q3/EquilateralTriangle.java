package lab4.Q3;
public class EquilateralTriangle implements Triangle {
    private double side;

    
    public EquilateralTriangle(double side) {
        this.side = side;
    }

    @Override
    public double getLongestSideLength() {
        return side;
    }

    @Override
    public double getLargestAngle() {
        return 60.0;
    }

    @Override
    public double getPerimeter() {
        return side * 3;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}