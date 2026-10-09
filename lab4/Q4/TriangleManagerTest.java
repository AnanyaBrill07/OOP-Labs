package lab4.Q4;
public class TriangleManagerTest {
    public static void main(String[] args) {
        
        TriangleManager manager = new TriangleManager(true);

        
        Triangle eq1 = new EquilateralTriangle(3.0);   
        Triangle eq2 = new EquilateralTriangle(10.0);  
        Triangle right1 = new RightTriangle(3.0, 4.0, 5.0);

        
        manager.addTriangle(eq1);
        manager.addTriangle(eq2);
        manager.addTriangle(right1);

        System.out.println("Total triangles added: " + manager.getTriangles().size());

        
        Triangle largest = manager.findTriangleWithLargestPerimeter();
        if (largest != null) {
            System.out.println("Largest Perimeter: " + largest.getPerimeter());
            System.out.println("Longest Side Length: " + largest.getLongestSideLength());
        }

        
        try {
            manager.addTriangle(null);
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught expected exception: " + e.getMessage());
        }
    }
}