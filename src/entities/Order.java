package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities_enum.OrderStatus;

public class Order {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> requestedItens = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		requestedItens.add(item); 
	}
	
	public void removeItem(OrderItem item) {
		requestedItens.remove(item); 
	}
	
	public Double total() {
		double sum = 0;
		for(OrderItem item: requestedItens) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append("-----------------------------"+"\n");
		text.append("ORDER SUMMARY" + "\n");
		text.append("Order moment: " + sdf.format(moment) + "\n");
		text.append("Order status: " + status + "\n");
		text.append("Client: " + client.getName() + " " + client.getBirthDate() + " - " + client.getEmail()+ "\n");
		text.append("Order items: " + "\n");
		for(OrderItem item: requestedItens) {
			text.append(item.getProduct().getName()+", Quantity: " + item.getQuantity() +", Subtotal: "+item.subTotal()+"\n");
		}
		
		text.append("Total price: "+ String.format("%.2f", total()));
		
		return text.toString();
	}
	
}
