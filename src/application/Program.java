package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities_enum.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Date date = new Date();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String Status = sc.next();
		
		Order newOrder = new Order(date, OrderStatus.valueOf(Status), client); 
		
		System.out.print("How many items to this order: ");
		int quantityItems = sc.nextInt();
		
		for(int i = 1; i<=quantityItems; i++) {
			
			System.out.println("Enter #" + i + "item data:");
			System.out.print("Product Name: ");
			String productName = sc.next();
			System.out.print("Product Price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			newOrder.addItem(new OrderItem(productQuantity, productPrice, new Product(productName, productPrice)));
			
		}
		
		System.out.print(newOrder);
		sc.close();
	}
}
