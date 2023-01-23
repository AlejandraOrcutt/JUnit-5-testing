import java.util.Random;

public class TestDemo {
	
	    public int addPositive(int a, int b) {
	        if (a <= 0 || b <= 0) {
	            throw new IllegalArgumentException();
	        }
	        return a + b;
	    }

	    int getRandomInt() {
	        Random random = new Random();
	        return random.nextInt(10) + 1;
	    }


		public int randomNumberSquared() {
			int randomInt = getRandomInt();
	        return randomInt * randomInt;
		}

}
