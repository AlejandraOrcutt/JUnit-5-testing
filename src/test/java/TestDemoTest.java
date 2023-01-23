import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {

	 private TestDemo testDemo;

	    @BeforeEach
	    public void setUp() {
	        testDemo = new TestDemo();
	    }

	    @ParameterizedTest
	    @MethodSource("TestDemoTest#argumentsForAddPositive")
	    public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
	        if (!expectException) {
	            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	        } else {
	            assertThatThrownBy(() -> testDemo.addPositive(a, b))
	                .isInstanceOf(IllegalArgumentException.class);
	        }
	    }

	    static Stream<Arguments> argumentsForAddPositive() {
	        return Stream.of(
	            Arguments.of(2, 4, 6, false), // exception is NOT expected
	            Arguments.of(0, 0, 0, true),  //exception is expected
	          
	         // test cases
	            Arguments.of(2, 3, 5, false), // a and b are positive numbers
	            Arguments.of(-1, 3, 0, true), // a is a negative number
	            Arguments.of(0, 3, 0, true), //a is zero
	            Arguments.of(2, -1, 0, true), // b is a negative number
	            Arguments.of(2, 0, 0, true)  // b is zero
	        );
	    }

	    @Test
	    public void assertThatNumberSquaredIsCorrect() {
	        TestDemo mockDemo = spy(testDemo);
	        when(mockDemo.getRandomInt()).thenReturn(5);
	        assertThat(mockDemo.randomNumberSquared()).isEqualTo(25);
	    }
	}

	//or this is a simpler way to test the addPositive() method:
	//

	//public class TestDemoTest {
	//
//	    private TestDemo testDemo;
	//
//	    @BeforeEach
//	    void setUp(){
//	        testDemo = new TestDemo();
//	    }
	//
//	    @Test
//	    void testPositiveNumbers(){
//	        assertEquals(5, testDemo.addPositive(2, 3));
//	    }
	//
//	    @Test
//	    void testNegativeA(){
//	        assertThrows(IllegalArgumentException.class, () -> testDemo.addPositive(-1, 3));
//	    }
	//
//	    @Test
//	    void testNegativeB(){
//	        assertThrows(IllegalArgumentException.class, () -> testDemo.addPositive(2, -1));
//	    }
	//
//	    @Test
//	    void testZeroA(){
//	        assertThrows(IllegalArgumentException.class, () -> testDemo.addPositive(0, 3));
//	    }
	//
//	    @Test
//	    void testZeroB(){
//	        assertThrows(IllegalArgumentException.class, () -> testDemo.addPositive(2, 0));
//	    }
	//}
