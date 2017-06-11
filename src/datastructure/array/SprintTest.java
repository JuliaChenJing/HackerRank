package datastructure.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class SprintTest {

	@Test
	public void test() {
		int [] a={1,5,10,3};
		assertTrue(Sprint.mostVisitedPosition(10, a)==5);
		int [] b={2,1,5};
		assertTrue(Sprint.mostVisitedPosition(5, b)==1);
		int [] c={9,7,3,1};
		assertTrue(Sprint.mostVisitedPosition(9, c)==3);
	}

}
