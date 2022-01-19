package org.hbrs.se1.ws21.uebung11.test;

public class BoundingBoxFactory {
    public MyPrettyRectangle boundingbox(MyPrettyRectangle[] rectangles){
        if(rectangles == null) return null;
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for (MyPrettyRectangle rec:rectangles) {
            //if(rec.x1 <= x1) x1 = rec.x1;
            //if(rec.y1 <= x1) x1 = rec.y1;
            //if(rec.x2 <= x1) x1 = rec.x2;
            //if(rec.y2 <= x1) x1 = rec.y2;
        }

        return new MyPrettyRectangle(x1,y1,x2,y2);
    }
}
