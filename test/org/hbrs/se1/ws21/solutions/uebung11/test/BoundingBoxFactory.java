package org.hbrs.se1.ws21.solutions.uebung11.test;

public class BoundingBoxFactory {
	public static MyPrettyRectangle getBox(MyPrettyRectangle[] rect) {
		if(rect == null) return null;
		if (rect.length == 0) return new MyPrettyRectangle(0.0,0.0,0.0,0.0);
		double minX=100;
		double minY=100;
		double maxX=0; 
		double maxY=0;
		
		for (int i = 0; i < rect.length; i++) {
			if(rect[i].getReO().getX() > maxX ) {
				maxX = rect[i].getReO().getX();
			}
			if(rect[i].getLiU().getX() < minX ) {
				minX = rect[i].getLiU().getX();
			}
			if(rect[i].getReO().getY() > maxY ) {
				maxY = rect[i].getReO().getY();
			}
			if(rect[i].getLiU().getY() < minY ) {
				minY = rect[i].getLiU().getY();
			}
		}
		
		MyPrettyRectangle Box = new MyPrettyRectangle(minX, minY, maxX, maxY);
		
		return Box;
	}
}
