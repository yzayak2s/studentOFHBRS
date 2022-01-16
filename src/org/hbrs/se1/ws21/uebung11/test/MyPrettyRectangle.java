package org.hbrs.se1.ws21.uebung11.test;

public class MyPrettyRectangle {
    private double x1, y1, x2, y2;
    private boolean cont = false;
    //MyPrettyRectangle left = new MyPrettyRectangle(0.0, 1.0, 3.0, 3.0);
    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean contains(MyPrettyRectangle rectangle) {
        if(this.x1 <= rectangle.x1 && this.y1 <= rectangle.y1 && this.x2 >= rectangle.x2 && this.y2 >= rectangle.y2){
            cont = true;
        }
        return cont;
    }

    public MyPoint getCenter() {

        return new MyPoint((this.x1+this.x2)/2,(this.y1+this.y2)/2);
    }

    public double getArea(MyPrettyRectangle rectangle){
        return (rectangle.x2-rectangle.x1)*(rectangle.y2-rectangle.y1);
    }

    public double getPerimeter(MyPrettyRectangle rectangle){
        return 2*((rectangle.x2-rectangle.x1)+(rectangle.y2-rectangle.y1));
    }
}
