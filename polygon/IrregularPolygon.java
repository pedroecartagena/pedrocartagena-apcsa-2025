package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        Double perim = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double point1 = myPolygon.get(i);
            Point2D.Double point2 = myPolygon.get((i + 1) % myPolygon.size());
            perim += point1.distance(point2);
        }
        return perim;
    }

    public double area() {
        // TODO: Calculate the area.
        Double area = 0.0;
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            for (Point2D.Double point : myPolygon) {
                myDrawingTool.move(point.getX(), point.getY());
            };
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
