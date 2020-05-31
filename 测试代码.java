package danyuanceshi;

import java.util.Random;

import org.junit.Test;

public class MethodsTest {

/*	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMethods() {
		
	}*/

	@Test
	public void testCheck() {
		String[][] lifeMap = new String[4][4];
		Methods cs=new Methods();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
	            int num = new Random().nextInt(2);
	            if (num == 1)
	                lifeMap[i][j] = "●";
	            else if (num == 0)
	                lifeMap[i][j] = "○";
	        }
		}
	}

	@Test
	public void testNextMap() {
		String[][] lifeMap = new String[4][4];
		
	}

	@Test
	public void testPrintLifeMap() {
		for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 3)
                    System.out.println("😃");
                else
                    System.out.print("😭");
            }
        }
	}

}
