package org.hbrs.se1.ws21.uebung11.test;

public class MyPoint {
    private double x,y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    @Override
    public boolean equals(MyPoint point) {
        if (this.x == point.x && this.y == point.y) {
            return true;
        }
        return false;
    }
}
