# JUnit-5-testing
This assignment illustrates how to use parameterized tests in Java using JUnit 5.

Two classes were created, a test class called TestDemoTest that will test the functionality of a class called TestDemo.

First, let's take a look at the TestDemo class. It has two methods: addPositive and randomNumberSquared. The addPositive method takes in two integers and returns the sum of the two integers, but only if they are both positive numbers. If either of the numbers is not positive, it will throw an IllegalArgumentException. The randomNumberSquared method generates a random number between 1 and 10, squares it, and returns the result.

For the TestDemoTest class, the first thing you'll notice is the annotation @ParameterizedTest on the assertThatTwoPositiveNumbersAreAddedCorrectly method. This tells JUnit that this method is a parameterized test, which means that it will run multiple times with different input values.

The input values for the test method are supplied by the argumentsForAddPositive method, which is annotated with @MethodSource. This method returns a stream of Arguments objects, which are just a way to group together multiple input values for the test method. Each set of input values is wrapped in a call to arguments().

In the test method, the assertThat method is used from the AssertJ library to check that the result of the addPositive method is equal to the expected value. If the expectException variable is true, we use the assertThatThrownBy method to check that the correct exception is thrown.

Finally, I added a test method named assertThatNumberSquaredIsCorrect to test the randomNumberSquared method. To mock the TestDemo class, the Mockito.spy() method is used. This allows to control the behavior of the getRandomInt method, so we can test the randomNumberSquared method with known input values.

In summary, parameterized tests in JUnit 5 allow you to run a single test method multiple times with different input values. This makes it easy to test a method with a wide range of inputs and helps to ensure that your code is working correctly in all situations.

Hope you find this explanation helpful. Happy coding!
