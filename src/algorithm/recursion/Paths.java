package algorithm.recursion;

import java.awt.Point;
import java.util.ArrayList;

public class Paths {
	/*8.2 p176
	 * Imagine a robot sitting on the upper left hand corner of an NxN grid. The
	 * robot can only move in two directions: right and down. How many possible
	 * paths are there for the robot?
	 * 
	 * FOLLOW UP Imagine certain squares are “off limits”, such that the robot
	 * can not step on them. Design an algorithm to get all possible paths for
	 * the robot.
	 */

	// We can implement a simple recursive algorithm with backtracking:
	
	static ArrayList<Point> current_path = new ArrayList<Point>();

	public static boolean getPaths(int x, int y) {
		Point p = new Point(x, y);
		current_path.add(p);
		if (0 == x && 0 == y)
			return true; // current_path
		boolean success = false;
		if (x >= 1 && is_free(x - 1, y)) { // Try right
			success = getPaths(x - 1, y); // Free! Go right
		}
		if (!success && y >= 1 && is_free(x, y - 1)) { // Try down
			success = getPaths(x, y - 1); // Free! Go down
		}
		if (!success) {
			current_path.remove(p); // Wrong way!
		}
		return success;
	}

	private static boolean is_free(int i, int y) {

		return false;
	}
}
