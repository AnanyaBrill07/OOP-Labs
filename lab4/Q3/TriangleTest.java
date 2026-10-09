package lab4.Q3;
public class TriangleTest {
    public static void main(String[] args) {
        
        Triangle eqTriangle = new EquilateralTriangle(5.0);

        System.out.println("=== Equilateral Triangle ===");
        System.out.println("Longest Side Length: " + eqTriangle.getLongestSideLength());
        System.out.println("Largest Angle: " + eqTriangle.getLargestAngle() + "°");
        System.out.println("Perimeter: " + eqTriangle.getPerimeter());

        System.out.println();

        
        Triangle rightTriangle = new RightTriangle(3.0, 4.0, 5.0);

        System.out.println("=== Right Triangle ===");
        System.out.println("Longest Side Length: " + rightTriangle.getLongestSideLength());
        System.out.println("Largest Angle: " + rightTriangle.getLargestAngle() + "°");
        System.out.println("Perimeter: " + rightTriangle.getPerimeter());
    }
}