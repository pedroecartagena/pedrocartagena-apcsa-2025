package polygon;

public class Main {
    public static void main(String [] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();
        myPolygon.add(new java.awt.geom.Point2D.Double(0, 0));
        myPolygon.add(new java.awt.geom.Point2D.Double(4, 0));
        myPolygon.add(new java.awt.geom.Point2D.Double(4, 3));
        myPolygon.draw();

        TestSuite.run();
    }
    
}
