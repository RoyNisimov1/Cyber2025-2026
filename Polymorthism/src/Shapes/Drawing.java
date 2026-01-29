package Shapes;

public class Drawing {
    private Shape[] shapes;
    private int count;
    public Drawing() {
        shapes = new Shape[100];
        count = 0;
    }

    public Shape[] getShapes(){
        Shape[] s = new Shape[shapes.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = shapes[i];
        }
        return s;
    }

    public void addShape(Shape shape) {
        if (count < shapes.length) {
            shapes[count++] = shape;
        }
    }
    @Override
    public String toString() {
        String str = "Shapes in the diagram:\n";
        for (int i = 0; i < count; i++)
        str += shapes[i].getClass().getSimpleName() + " area=" +
                shapes[i].area() + "\n";
        return str;
    }

    public double totalArea(){
        double s = 0.0;
        for(Shape shape: shapes){
            if (shape!=null)
                s+=shape.area();
        }
        return s;
    }




}
