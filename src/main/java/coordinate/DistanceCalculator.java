package coordinate;

import java.awt.*;

public class DistanceCalculator {
	public double calculateTwoPointDistance(Point pointA, Point pointB) {
		return Math.sqrt(Math.pow(pointA.x - pointB.x,2) + Math.pow(pointA.y - pointB.y,2));
	}
}
