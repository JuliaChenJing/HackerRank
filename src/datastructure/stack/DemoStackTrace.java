package datastructure.stack;

public class DemoStackTrace {
	
	public static void main(String[] args) {
		// demo code to know the stack information of method calls
		System.out.println("Execution starts from main method");
		methodA();
	}

	public static void methodA() {
		System.out.println("Now in methodA()");

		methodB();

	}

	public static void methodB() {
		System.out.println("Now in methodB()");
		{
			methodC();
		}
	}

	public static void methodC() 
	{
		System.out.println("Now in methodC()");
		int[] array = { 0, 1, 2 };
		try {
			System.out.println("The value is : " + array[5]);
		} catch (ArrayIndexOutOfBoundsException error) {
			System.out.println("Error while retrieving the value from the index: " + error.getMessage());
			System.out.println("The stack contens are :");
			error.printStackTrace();// Print the stack information from top to
									// bottom
		}
	}
}
/*
Execution starts from main methodjava.lang.ArrayIndexOutOfBoundsException: 5
Now in methodA()
Now in methodB()
Now in methodC()
Error while retrieving the value from the index: 5
The stack contens are :

	at package3.DemoStackTrace.methodC(DemoStackTrace.java:28)
	at package3.DemoStackTrace.methodB(DemoStackTrace.java:20)
	at package3.DemoStackTrace.methodA(DemoStackTrace.java:13)
	at package3.DemoStackTrace.main(DemoStackTrace.java:7)
*/
