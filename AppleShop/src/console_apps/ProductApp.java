package console_apps;

import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Product;

public class ProductApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Product p = new Product();
		System.out.println(p); // implicitly: system.out.println(p.toString())  -both are equivalent statements-
		
		Product p2 = new Product("iPad Pro 12.9", 1289.00);
		System.out.println(p2);
		
//		System.out.println("Enter a model:");
//		String model = input.nextLine();
//		System.out.println("Enter the original price:");
//		double op = input.nextDouble();
//		Product p3 = new Product(model, op);
//		System.out.println(p3);
//		input.close();
		
	}

}
