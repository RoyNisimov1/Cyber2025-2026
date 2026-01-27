package Shapes;

public class Program {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();

        drawing.addShape(new Rectangle(4, 5));
        drawing.addShape(new Square(3));
        drawing.addShape(new Circle(2));
        drawing.addShape(new Triangle(6, 7));
        drawing.addShape(new Rectangle(2, 8));
        drawing.addShape(new Square(4));
        drawing.addShape(new Circle(3));
        drawing.addShape(new Triangle(3, 4));
        System.out.println(drawing);
        System.out.println("Total area:" + drawing.totalArea());
        System.out.println("Amount of circles:" + drawing.numberOfCircles());

        System.out.println(numOfShapeWithMaxArea(drawing));
        // index 6

        //2 rects
        //2 squares
        //2 circles
        //2 triangle

    }

    public static int numOfShapeWithMaxArea(Drawing d){
        Shape[] s = d.getShapes();
        int currentMaxInt = 0;
        double currentMaxArea = s[0].area();
        for (int i = 0; i < s.length; i++) {
            if(s[i] != null){
                if(currentMaxArea < s[i].area()){
                    currentMaxArea = s[i].area();
                    currentMaxInt = i;
                }
            }
        }
        return currentMaxInt;
    }
}
