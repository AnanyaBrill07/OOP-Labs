package lab4.Q4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriangleManager {
    private List<Triangle> triangles;

    
    public TriangleManager(boolean isArrayList) {
        if (isArrayList) {
            this.triangles = new ArrayList<>();
        } else {
            this.triangles = new LinkedList<>();
        }
    }

   
    public void addTriangle(Triangle t) {
        if (t == null) {
            throw new IllegalArgumentException("Triangle cannot be null");
        }
        triangles.add(t);
    }

    public Triangle findTriangleWithLargestPerimeter() {
        if (triangles.isEmpty()) {
            return null;
        }

        Triangle largestTriangle = triangles.get(0);
        double maxPerimeter = largestTriangle.getPerimeter();

        for (Triangle t : triangles) {
            double currentPerimeter = t.getPerimeter();
            if (currentPerimeter > maxPerimeter) {
                maxPerimeter = currentPerimeter;
                largestTriangle = t;
            }
        }

        return largestTriangle;
    }

   
    public List<Triangle> getTriangles() {
        return triangles;
    }
}