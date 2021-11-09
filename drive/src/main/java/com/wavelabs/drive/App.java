package com.wavelabs.drive;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}

	public int calculator(int a, int b, char operand) {
		switch (operand) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		default:
			return 0;
		}
	}

	public double circleArea(double radius) {

		return Math.PI * radius * radius;
	}

}
