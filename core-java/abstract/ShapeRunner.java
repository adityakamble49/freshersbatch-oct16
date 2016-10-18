public class ShapeRunner {

    public static void main(String[] args){

        Shape[] shapeArray = new Shape[6];
        shapeArray[0] = new Line();
        shapeArray[1] = new Rectangle();
        shapeArray[2] = new Cube();
        shapeArray[3] = new Point();
        shapeArray[4] = new Circle();
        shapeArray[5] = new Cylinder();

        for(int i=0; i<shapeArray.length; i++){
            shapeArray[i].draw();
        }
    }
}

abstract class Shape {
    public abstract void draw();
}

class Line extends Shape{
    public void draw(){
        System.out.println("Drawing Line");
    };
}

class Rectangle extends Line {
    public void draw(){
        System.out.println("Drawing Rectangle");
    }
}

class Cube extends Line {
    public void draw(){
        System.out.println("Drawing Cube");
    }
}

class Point extends Shape{
    public void draw(){
        System.out.println("Drawing Point");
    };
}

class Circle extends Point {
    public void draw(){
        System.out.println("Drawing Circle");
    }
}

class Cylinder extends Point {
    public void draw(){
        System.out.println("Drawing Cylinder");
    }
}
