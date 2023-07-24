package entity;

public class Caculator {
	
	int result = 0;
	
	public Caculator(int num1, int num2, String op) {
		
		if (op.equals("+")) {
			result = num1 + num2;
		} else if (op.equals("-")) {
			result = num1 - num2;
		} else if (op.equals("*")) {
			result = num1 * num2;
		} else if (op.equals("/")) {
			result = num1 / num2;
		}
		
	}
	
	public int GetResult() {
		return result;
	}
}
