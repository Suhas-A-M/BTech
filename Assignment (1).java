
import java.util.ArrayList;
import java.util.Scanner;

public class Simple {
	static int ID = 1;
	static int choice = 0;
	static ArrayList<manufacturer> Manufacturers = new ArrayList<>();
	static ArrayList<product> Products = new ArrayList<>();
	static ArrayList<customer> Customers = new ArrayList<>();
	static ArrayList<shop> Shops = new ArrayList<>();
	static ArrayList<delivery_agent> Agents = new ArrayList<>();
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		while(choice != 5)
		{
			
			System.out.println("\n\nChoose relevant option by typing the number : \n"
					+ "1. Manufacturer\n"
					+ "2. Customer\n"
					+ "3. Shop and WareHouse\n"
					+ "4. Delivery Agent\n"
					+ "5. Exit\n");
			choice = sc.nextInt();
			//System.out.println(choice);
			
			switch(choice) {
			case 1 : {
				manufacturer_func();
				break;
			}
			case 2 : {
				customer_func();
				break;
			}
			case 3 : {
				shop_func();
				break;
			}
			case 4 : {
				delivery_agent_func();
				break;
			}
			case 5 : {
				break;
			}
			default : {
				System.out.println("Invalid choice.\n");
				break;
			}
			}
			
		}
		sc.close();
		System.out.println("Thank you\n\n\tEND");
	}

	private static void delivery_agent_func() {
		int ch = 0;
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		
		while(ch != 6) {
			
			if(flag) {
				System.out.println("\n\nChoose relevant option : \n"
						+ "1. Create a profile\n"
						+ "2. Print all delivery agents\n"
						+ "3. Delete a delivery agent profile\n"
						+ "4. Back\n"
						+ "5. Exit\n");
				
				ch = s.nextInt();
				s.nextLine();
			}
			switch(ch) {
			case 1 : {
				delivery_agent d = new delivery_agent();
				System.out.println("Enter name : \n");
				
				d.name = s.nextLine();
				d.id = ID;
				
				System.out.println("\nEnter agent's zipcode : ");
				d.zipcode = s.nextInt();
				
				Agents.add(d);
				
				System.out.println("\nNew Profile Created  :)\nDelivery Agent's ID is " + d.id + "\n                 name is " + d.name
						+ "\n                 zipcode is " + d.zipcode + "\n");
				ID++;	
				break;
			}
			case 2 : {
				if(Agents.size() == 0) {
					System.out.println("\nNo Delivery agents available!\n");
					flag = true;
					break;
				}
				System.out.println("\nAll Delivery agents : \n   ID\tName\tZipcode\t Number of deliveries\n");
				int i = 1;
				for(delivery_agent d : Agents)
				{
					System.out.println(i++ + ". " + d.id + "\t" + d.name + "\t" + d.zipcode + "\t" + d.count);
				}
				break;
			}
			case 3 : {
				if(Agents.size() == 0) {
					System.out.println("\nNo Delivery Agents available!\n");
					flag = true;
					break;
				}
				System.out.println("Select the Agent to delete : \n");
				int i = 1;
				for(delivery_agent d : Agents)
				{
					System.out.println(i++ + ". ID : " + d.id + "\t Name : " + d.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					System.out.println("\nDelivery Agent " + Agents.get(a-1).id + "  " + Agents.get(a-1).name + "  deleted!  :)\n");
					Agents.remove(a-1);
					flag = true;
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("\nInvalid number!  :(\n");
					flag = false;
					continue;
				}
				break;
			}
			case 4 : {
				return;
			}
			case 5 : {
				choice = 5;
				return;
			}
			}
		}
		
	}

	private static void shop_func() {
		int ch = 0;
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		
		while(ch != 6) {
			
			if(flag) {
				System.out.println("\n\nChoose relevant option : \n"
						+ "1. Create a profile\n"
						+ "2. Add copies of a product to a shop\n"
						+ "3. List inventory of a shop\n"
						+ "4. Print all shops\n"
						+ "5. Delete a shop profile\n"
						+ "6. Back\n"
						+ "7. Exit\n");
				
				ch = s.nextInt();
				s.nextLine();
			}
			
			switch(ch) {
			case 1 : {
				shop sh = new shop();
				System.out.println("Enter name : \n");
				
				sh.name = s.nextLine();
				sh.id = ID;
				
				System.out.println("\nEnter shop zipcode : ");
				sh.zipcode = s.nextInt();
				
				Shops.add(sh);
				
				System.out.println("\nNew Profile Created  :)\nShop ID is " + sh.id + "\nShop name is " + sh.name
						+ "\nShop zipcode is " + sh.zipcode + "\n");
				ID++;	
				break;
			}
			case 2 : {
				if(Shops.size() == 0) {
					System.out.println("\nNo Shops available!\n");
					flag = true;
					break;
				}
				System.out.println("\nSelect the Shop\n");
				int i = 1;
				for(shop sh : Shops)
				{
					System.out.println(i++ + ". ID : " + sh.id + "\t Name : " + sh.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					
					if(Products.size() == 0) {
						System.out.println("\nNo products available!\n");
						break;
					}
					System.out.println("\nSelect the product to add copies : \n");
					int x = 1;
					System.out.println("   ID\tName\n");
					for(product p : Products) {
						System.out.println(x + ". " + p.id + "  " + p.name);
						x++;
					}
					int option = s.nextInt();
					
					if(option > 0 && option < x) {
						System.out.println("Enter number of copies : \n");
						int count = s.nextInt();
						int size = Shops.get(a-1).Inventory.Products.size();
						int y;
						for(y = 0; y < size; y++) {
							if(Shops.get(a-1).Inventory.Products.get(y).id == Products.get(option-1).id) {
								Shops.get(a-1).Inventory.Count.set(y, Shops.get(a-1).Inventory.Count.get(y) + count);
								System.out.println("\nCopies added!  :)\n");
								flag = true;
								break;
							}
						}
						if(y == size) {
							Shops.get(a-1).Inventory.Products.add(Products.get(option-1));
							Shops.get(a-1).Inventory.Count.add(count);
							System.out.println("\nCopies added!  :)\n");
							flag = true;
						}
					}
					else {
						System.out.println("\nInvalid number! :(\n");
						flag = false;
					}	
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("\nInvalid number!  :(\n");
					flag = false;
					continue;
				}
				break;
			}
			case 3 : {
				if(Shops.size() == 0) {
					System.out.println("\nNo Shops available!\n");
					flag = true;
					break;
				}
				System.out.println("Select the Shop\n");
				int i = 1;
				for(shop sh : Shops)
				{
					System.out.println(i++ + ". ID : " + sh.id + "\t Name : " + sh.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					System.out.println("\nInventory of the shop : \n");
					System.out.println("\n   ID Name   Count\n");
					for(int x = 0; x < Shops.get(a-1).Inventory.Products.size(); x++) {
						System.out.println(x+1 + ".  " + Shops.get(a-1).Inventory.Products.get(x).id + "  " + Shops.get(a-1).Inventory.Products.get(x).name + "  " +  Shops.get(a-1).Inventory.Count.get(x));
					}
					flag = true;
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("\nInvalid number!  :(\n");
					flag = false;
					continue;
				}
				break;
				
			}
			case 4 : {
				if(Shops.size() == 0) {
					System.out.println("\nNo Shops available!\n");
					flag = true;
					break;
				}
				System.out.println("\nAll shops : \n   ID\tName\tZipcode\n");
				int i = 1;
				for(shop sh : Shops)
				{
					System.out.println(i++ + ". " + sh.id + "\t" + sh.name + "\t" + sh.zipcode);
				}
				break;
			}
			case 5 : {
				if(Shops.size() == 0) {
					System.out.println("\nNo Shops available!\n");
					flag = true;
					break;
				}
				System.out.println("Select the Shop to delete : \n");
				int i = 1;
				for(shop sh : Shops)
				{
					System.out.println(i++ + ". ID : " + sh.id + "\t Name : " + sh.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					System.out.println("\nShop " + Shops.get(a-1).id + "  " + Shops.get(a-1).name + "  deleted!  :)\n");
					Shops.remove(a-1);
					flag = true;
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("\nInvalid number!  :(\n");
					flag = false;
					continue;
				}
				break;
			}
			case 6 : {
				return;
			}
			case 7 : {
				choice = 5;
				return;
			}
			}
		}
		
	}

	private static void customer_func() {
		int ch = 0;
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		
		while(ch != 7) {
			
			if(flag) {
				System.out.println("\n\nChoose relevant option : \n"
						+ "1. Create a profile\n"
						+ "2. Add an order\n"
						+ "3. Process an order\n"
						+ "4. List all the purchases made by a customer\n"
						+ "5. Print all customers\n"
						+ "6. Delete a customer profile\n"
						+ "7. Back\n"
						+ "8. Exit\n");
				
				ch = s.nextInt();
				s.nextLine();
			}
			
			
			switch(ch) {
			case 1 : {
				customer c = new customer();
				System.out.println("Enter name : \n");
				
				c.name = s.nextLine();
				c.id = ID;
				
				System.out.println("Enter customer's zipcode : ");
				c.zipcode = s.nextInt();
				
				Customers.add(c);
				
				System.out.println("New Profile Created  :)\nCustomer ID is " + c.id + "\nCustomer name is " + c.name
						+ "\nCustomer zipcode is " + c.zipcode + "\n");
				ID++;	
				break;
			}
			case 2 : {
				if(Customers.size() == 0) {
					System.out.println("\nNo Customers available!\n");
					flag = true;
					break;
				}
				System.out.println("Select the Customer\n");
				int i = 1;
				for(customer c : Customers)
				{
					System.out.println(i++ + ". ID : " + c.id + "\t Name : " + c.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					if(Products.size() == 0) {
						System.out.println("\nNo products available!\n");
						flag = false;
						break;
					}
					System.out.println("Select the product to add to wishlist : \n");
					int x = 1;
					System.out.println("   ID\tName\n");
					for(product p : Products) {
						System.out.println(x + ". " + p.id + "  " + p.name);
						x++;
					}
					int option = s.nextInt();
					if(option > 0 && option < x) {
						System.out.println("\nEnter number of copies : \n");
						int count = s.nextInt();
						int size = Customers.get(a-1).Products.size();
						int y;
						for(y = 0; y < size; y++) {
							if(Products.get(option-1).id == Customers.get(a-1).Products.get(y).id) {
								Customers.get(a-1).Count.set(y, Customers.get(a-1).Count.get(y) + count);
								System.out.println("Order of "  + count + " copies of Product(ID : " + Products.get(option-1).id + " Name : " + Products.get(option-1).name +  ") added!  :)\n");
								flag = true;
								break;
							}
						}
						if(y == size) {
							Customers.get(a-1).Products.add(Products.get(option-1));
							Customers.get(a-1).Count.add(count);
							System.out.println("Order of "  + count + " copies of Product(ID : " + Products.get(option-1).id + " Name : " + Products.get(option-1).name +  ") added!  :)\n");
							flag = true;
						}

					}
					else {
						System.out.println("\nInvalid number! :(\n");
						flag = false;
					}
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("\nInvalid number!  :(\n");
					flag = false;
					continue;
				}
				break;
			}
			case 3 : {
				if(Customers.size() == 0) {
					System.out.println("\nNo Customers available!\n");
					flag = true;
					break;
				}
				System.out.println("Select the Customer\n");
				int i = 1;
				for(customer c : Customers)
				{
					System.out.println(i++ + ". ID : " + c.id + "\t Name : " + c.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					if(Customers.get(a-1).Products.size() == 0) {
						System.out.println("\nNo orders to process!\n");
						flag = false;
						break;
					}
					if(Agents.size() == 0) {
						System.out.println("\nOrder cannot be processed. No Delivery Agents available  :(\n");
						flag = false;
						break;
					}
					System.out.println("\nSelect the order to process : \n");
					int x = 1;
					System.out.println("   ID\tName\tNumber of Copies\n");
					for(product p : Customers.get(a-1).Products) {
						System.out.println(x + ". " + p.id + "  " + p.name + "  " + Customers.get(a-1).Count.get(x-1));
						x++;
					}
					int option = s.nextInt();
					if(option > 0 && option < x) {
						boolean flag0 = false;
						for(shop sh : Shops) {
							if(sh.zipcode == Customers.get(a-1).zipcode) {
								int z = 0;
								for(product p : sh.Inventory.Products) {
									if((p.id == Customers.get(a-1).Products.get(option-1).id) && (sh.Inventory.Count.get(z) >= Customers.get(a-1).Count.get(option-1))) {
										sh.Inventory.Count.set(z, sh.Inventory.Count.get(z) - Customers.get(a-1).Count.get(option-1));
										Customers.get(a-1).Purchases.add(p);
										if(sh.Inventory.Count.get(z) == 0) sh.Inventory.Products.remove(z);
										Customers.get(a-1).Products.remove(option-1);
										int index = 0, y = 0, min = Agents.get(0).count;
										for(delivery_agent d : Agents) {
											if(d.count < min) index = y;
											y++;
										}
										Agents.get(index).count++;
										System.out.println("\nOrder is processed successfully!  :)  \n\nShop :-  ID : " + sh.id + "  Name : " + sh.name + "\nAppointed delivery agent :-  ID : " + Agents.get(index).id + "  Name : " + Agents.get(index).name);
										flag0 = true;
										break;
									}
									z++;
								}
								if(flag0) break;
							}
						}
						if(flag0 == false) {
							System.out.println("\nOrder cannot be processed. Product not available in your locality!  :(\n");
							flag = false;
							break;
						}
						break;
					}
					else {
						System.out.println("Invalid Number!  :(\n");
						flag = false;
					}
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("\nInvalid number!  :(\n");
					flag = false;
					continue;
				}
				break;
			}
			case 4 : {
				if(Customers.size() == 0) {
					System.out.println("\nNo Customers available!\n");
					flag = true;
					break;
				}
				System.out.println("Select the Customer\n");
				int i = 1;
				for(customer c : Customers)
				{
					System.out.println(i++ + ". ID : " + c.id + "\t Name : " + c.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					
					if(Customers.get(a-1).Purchases.size() == 0) {
						System.out.println("\nNo Purchases made!\n");
						flag = false;
						break;
					}
					System.out.println("\nAll purchases : \n");
					int x = 1;
					System.out.println("   ID\tName\n");
					for(product p : Customers.get(a-1).Purchases) {
						System.out.println(x + ". " + p.id + "  " + p.name);
					}
					flag = true;
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("\nInvalid number!  :(\n");
					flag = false;
					continue;
				}
				break;
			}
			case 5 : {
				if(Customers.size() == 0) {
					System.out.println("\nNo Customers available!\n");
					flag = true;
					break;
				}
				System.out.println("\nAll customers : \n");
				int i = 1;
				for(customer c : Customers)
				{
					System.out.println(i++ + ". ID : " + c.id + "\t Name : " + c.name + "\n");
				}
				break;
			}
			case 6 : {
				if(Customers.size() == 0) {
					System.out.println("\nNo Customers available!\n");
					flag = true;
					break;
				}
				System.out.println("Select the Customer to delete : \n");
				int i = 1;
				System.out.println("    ID\tName");
				for(customer c : Customers)
				{
					System.out.println(i++ + ".  " + c.id + "\t" + c.name);
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					System.out.println("Customer " + Customers.get(a-1).id + "  " + Customers.get(a-1).name + "  deleted!  :)\n");
					Customers.remove(a-1);
					flag = true;
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("\nInvalid number!  :(\n");
					flag = false;
					continue;
				}
				break;
			}
			case 7 : {
				return;
			}
			case 8 : {
				choice = 5;
				return;
			}
			}
		}
		
	}

	private static void manufacturer_func() {
		int ch = 0;
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		
		while(ch != 7) {
			
			if(flag) {
				System.out.println("\n\nChoose relevant option : \n"
						+ "1. Create a Profile\n"
						+ "2. Delete a manufacturer\n"
						+ "3. Delete a product\n"
						+ "4. Print all entities\n"
						+ "5. Add products to a manufacturer\n"
						+ "6. List products made by a manufacturer\n"
						+ "7. Back\n"
						+ "8. Exit\n");
				
				ch = s.nextInt();
				s.nextLine();
			}
			
			
			
			switch(ch) {
			case 1 : {
				manufacturer m = new manufacturer();
				System.out.println("Enter name : \n");
				
				m.name = s.nextLine();
				m.id = ID;
				
				Manufacturers.add(m);
				
				System.out.println("New Profile Created  :)\nManufacturer's name is " + m.name
						+ "\nManufacturer's ID is " + ID + "\n");
				ID++;
				
				
				break;
			}
			case 2 : {
				if(Manufacturers.size() == 0) {
					System.out.println("\nNo Manufacturers to delete!\n");
					flag = true;
					break;
				}
				System.out.println("Select the manufacturer to delete the profile : \n");
				
				int i = 1;
				for(manufacturer m : Manufacturers)
				{
					System.out.println(i++ + ". ID = " + m.id + "\t Name : " + m.name + "\n");
				}
				System.out.println(i + ". Back");
				
				
				int a = s.nextInt();
				if(a > 0 && a < i) {
					System.out.println("Deleted profile : \n\t" + Manufacturers.get(a-1).id + "\t" + Manufacturers.get(a-1).name + "  :)\n");
					Manufacturers.remove(a-1);
					flag = true;
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					flag = false;
					System.out.println("Invalid number!\n");
				}
				break;
				
			}
			case 3 : {
				if(Manufacturers.size() == 0) {
					System.out.println("\nNo Manufacturers available!\n");
					flag = true;
					break;
				}
				System.out.println("Select the manufactuerer\n");
				int i = 1;
				for(manufacturer m : Manufacturers)
				{
					System.out.println(i++ + ". ID = " + m.id + "\t Name : " + m.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					if(Manufacturers.get(a-1).Products.size() == 0) {
						System.out.println("\nNo products to delete!\n");
						flag = false;
						break;
					}
					System.out.println("Select the product to be deleted : \n");
					int x = 1;
					for(product p : Manufacturers.get(a-1).Products) {
						System.out.println(x + ". " + p.id + "  " + p.name);
						x++;
					}
					int option = s.nextInt();
					if(option > 0 && option < x) {
						product p = Manufacturers.get(a-1).Products.get(option-1);
						Manufacturers.get(a-1).Products.remove(option-1);
						System.out.println("Product :  " + p.id + "  " + p.name + "  deleted  :)\n");
						flag = true;
					}
					else {
						System.out.println("Invalid Number!\n");
						flag = false;
					}
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("Invalid Number!\n");
					flag = false;
				}
				break;
			}
			case 4 : {
				int i = 1;
				if(Manufacturers.size() == 0) {
					System.out.println("\nNo Manufacturers to show :(\n");
					flag = true;
					break;
				}
				System.out.println("All manufacturers and their products : \n");
				
				for(manufacturer m : Manufacturers) {
					System.out.println(i++ + ". ID : " + m.id + "\t Name : " + m.name + "\nProducts : \n\tID\tName");
					for(product p : m.Products) {
						System.out.println("\t" + p.id + "\t" + p.name);
					}
					System.out.println("\n");
				}
				break;
			}
			case 5 : {
				if(Manufacturers.size() == 0) {
					System.out.println("\nNo Manufacturers to show :(\n");
					flag = true;
					break;
				}
				System.out.println("Select the manufactuerer\n");
				int i = 1;
				for(manufacturer m : Manufacturers)
				{
					System.out.println(i++ + ". ID = " + m.id + "\t Name : " + m.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					
					System.out.println("Enter the product name : ");
					s.nextLine();
					String c = s.nextLine();
					
					int x = 0;
					
					for(product p : Products) {
						if(c.equals(p.name)) break;
						x++;
					}
					
					if(x < Products.size()) {
						product P = Products.get(x);
						if(Manufacturers.get(a-1).Products.contains(P)) {
							System.out.println("Product was already added before  :)\n");
							flag = true;
						}
						else {
							Manufacturers.get(a-1).Products.add(P);
							System.out.println("Product ID : " + P.id + "\t name : " + P.name + "\tadded  :)\n");
							flag = true;
						}
					}
					else {
						product z = new product();
						z.name = c;
						z.id = ID++;
						Products.add(z);
						Manufacturers.get(a-1).Products.add(z);
						System.out.println("Product ID : " + z.id + "\t name : " + z.name + "\tadded  :)\n");
						flag = true;
					}
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					flag = false;
					System.out.println("Invalid number!\n");
				}
				break;
			}
			case 6 : {
				
				if(Manufacturers.size() == 0) {
					System.out.println("\nNo Manufacturers to delete!\n");
					flag = true;
					break;
				}
				System.out.println("Select the manufactuerer\n");
				int i = 1;
				for(manufacturer m : Manufacturers)
				{
					System.out.println(i++ + ". ID = " + m.id + "\t Name : " + m.name + "\n");
				}
				System.out.println(i + ". Back");
				int a = s.nextInt();
				if(a > 0 && a < i) {
					if(Manufacturers.get(a-1).Products.size() > 0) {
						System.out.println("All products made by " + Manufacturers.get(a-1).name + ": \n");
						for(product p : Manufacturers.get(a-1).Products) {
							System.out.println("ID : " + p.id + "\tName : " + p.name);
						}
						System.out.println("\n");
						flag = true;
					}
					else {
						System.out.println("No products are made by " + Manufacturers.get(a-1).name + ".\n\n");
						flag = true;
					}
				}
				else if(a == i) {
					flag = true;
					continue;
				}
				else {
					System.out.println("Invalid Number!\n\n");
					flag = false;
					continue;
				}
				break;
			}
			case 7 : {
				return;
			}
			case 8 : {
				choice = 5;
				return;
			}
			}
		}
		return;		
	}

}

class entity {
	int id;
	String name;
}

class manufacturer extends entity {
	ArrayList<product> Products = new ArrayList<product>();
}

class product extends entity {
	int Manufacturer_id;
}

class customer extends entity {
	int zipcode;
	ArrayList<product> Products = new ArrayList<product>();
	ArrayList<Integer> Count = new ArrayList<Integer>();
	ArrayList<product> Purchases = new ArrayList<product>();
}

class inventory {
	ArrayList<product> Products = new ArrayList<product>();
	ArrayList<Integer> Count = new ArrayList<Integer>();
}

class shop extends entity {
	int zipcode;
	inventory Inventory = new inventory();
}

class delivery_agent extends entity {
	int zipcode;
	int count;
}
