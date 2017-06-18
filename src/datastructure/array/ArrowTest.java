package datastructure.array;


import static org.junit.Assert.*;

import org.junit.Test;

public class ArrowTest {

	@Test
	public void test() {
		int [] a={1,5,10,3};
		assertTrue(Arrow.mostVisitedPosition(10, a)==5);
		int [] b={2,1,5};
		assertTrue(Arrow.mostVisitedPosition(5, b)==1);
		int [] c={9,7,3,1};
		assertTrue(Arrow.mostVisitedPosition(9, c)==3);
	}

}
