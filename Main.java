/*Devin Durham
 * Spring 342 
 * Marriott
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc;
		try {
			sc = new Scanner(new File("./customer.txt"));
			int orderCount = 0;
			while (sc.hasNext()) {
				String line = sc.nextLine();
				System.out.println("Processing Order " + orderCount + ": " + line);
				parseLine(line);
				orderCount ++;
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
     testMyStack();
	 testBurger();
	
	}

	public static void parseLine(String line) {
		Burger maker = new Burger();
		String[] arr = line.toLowerCase().split(" "); 
		//Note ParseLine(String line) calls .toLowerCase()
		
		Boolean flag = false;
		 for (int i = 0; flag == false; i++) {
			 if (arr[i].equals("baron") && arr[i+1].equals( "burger")){
				 maker.Burger(true);
				 flag = true;	
			 } else if (arr[i].equals("burger")){
				 maker.Burger(false);
				 flag = true;
			 }
		 }
		 
		
		 for (int i = 0; i<arr.length; i++) {	

			if(arr[i].equals("with") && arr[i+1].equals("no")){
				 i+=2;
				while(i<arr.length && !arr[i].equals("but")){
					if(arr[i].equals("patties") ||arr[i].equals("cheese") 
							||arr[i].equals("veggies") ||arr[i].equals("sauce") ){
						
						maker.removeCategory(arr[i]);
						i++;
					} else{
						maker.removeIngredient(arr[i]);
						i++;
					}
				 }
				i++;
				 while(i < arr.length){
					 
					 if(arr[i].equals("patties") ||arr[i].equals("cheese") 
								||arr[i].equals("veggies") ||arr[i].equals("sauce") ){
							maker.addCategory(arr[i]);
							i++;
						} else{
							maker.addIngredient(arr[i]);
							i++;
						}	 
				 }
				 
			 }else if(arr[i].equals("with")){
				 i++; 
				 while(i<arr.length && !arr[i].equals("but")){
					 if(arr[i].equals("patties") ||arr[i].equals("cheese") 
								||arr[i].equals("veggies") ||arr[i].equals("sauce") ){
							maker.addCategory(arr[i]);
							i++;
						} else if(arr[i].toLowerCase().equals("cheddar")){
								maker.addCategory("cheese");
								maker.removeIngredient("pepperjack");
								maker.removeIngredient("mozzarella");
								i++;
						} else if(arr[i].toLowerCase().equals("pepperjack")){
							maker.addCategory("cheese");
							maker.removeIngredient("cheddar");
							maker.removeIngredient("mozzarella");
							i++;
						} else if(arr[i].toLowerCase().equals("mozzarella")){
							maker.addCategory("cheese");
							maker.removeIngredient("cheddar");
							maker.removeIngredient("pepperjack");
							i++;
						}else{
							maker.addIngredient(arr[i]);
							i++;
						}
						
					 
						
				 }
				 i+=2;
				 while(i < arr.length){
					 if(arr[i].equals("patties") ||arr[i].equals("cheese") 
								||arr[i].equals("veggies") ||arr[i].equals("sauces") ){
							maker.removeCategory(arr[i]);
							i++;
						} else{
							maker.removeIngredient(arr[i]);
							i++;
						}
					 }
			 }	 
		 }
		 for (int i = 0; i<arr.length; i++) {	
			  if(arr[i].equals("single")){

			 } else if (arr[i].equals("double")){
				 maker.addPatty();
					 
			 } else if(arr[i].equals("triple")){
				 maker.addPatty();
				 maker.addPatty();
			 
			 } else if(arr[i].equals("veggie") || arr[i].equals("chicken") 
					 || arr[i].equals("beef")){
				 maker.changePatties(arr[i]);

			 
			 }
		 }
		 
		 
		 System.out.println(maker.toString() + '\n');
	}

	private static void testMyStack() {
		//Note: testBurger() deals with MyStack<String>
		MyStack<Integer> IntStackTest = new MyStack<Integer>();
		
		if(!IntStackTest.toString().equals("[]")){
			System.out.println("Error: StackTest.toString() has failed");
			System.out.println(IntStackTest.toString());
		}
		
		if(!IntStackTest.isEmpty()){
			System.out.println("Error: StackTest.isEmpty() has failed");
			System.out.println(IntStackTest.toString());
		}
		IntStackTest.push(1);
		IntStackTest.push(2);
		IntStackTest.push(3);
		if(!IntStackTest.toString().equals("[3, 2, 1]")){
			System.out.println("Error: IntStackTest.push() has failed");
			System.out.println(IntStackTest.toString());			
		}
		IntStackTest.pop();
		if(!IntStackTest.toString().equals("[2, 1]")){
			System.out.println("Error: IntStackTest.pop() has failed");
			System.out.println(IntStackTest.toString());
		}
		if(!IntStackTest.peek().equals(2)){
			System.out.println("Error: IntStackTest.peek() has failed");
			System.out.println(IntStackTest.toString());
		}
		
		if(!(IntStackTest.size()==2)){
			System.out.println("Error: IntStackTest.size() has failed");
			System.out.println(IntStackTest.size());
		}
		
	}

	private static void testBurger() {
		//Note ParseLine(String line) calls .toLowerCase()
		Burger test = new Burger();
		Burger testBaron = new Burger();
		
		test.Burger(false);
		if(!test.CurrentList.toString().equals(test.BaseList.toString())){
			System.out.println("Error: test.toString has failed IF all test fail");
			System.out.println("Error: test.Burger(false) has failed");
			System.out.println(test.BaseList);
			System.out.println(test.CurrentList);
		}
		testBaron.Burger(true);
		if(!testBaron.CurrentList.toString().equals(testBaron.BaronList.toString())){
			System.out.println("Error: test.Burger(true) has failed");
			System.out.println(test.BaronList);
			System.out.println(test.CurrentList);	
		}
		
		test.changePatties("Chicken");
		if(!test.toString().equals("[Bun, Chicken, Bun]")){
			System.out.println("Error: test.changePatties('Chicken') has failed");
			System.out.println(test);
		}
		
		test.changePatties("Veggie");
		if(!test.toString().equals("[Bun, Veggie, Bun]")){
			System.out.println("Error: test.changePatties('Veggie') has failed");
			System.out.println(test);
		}
		
		test.changePatties("Beef");
		if(!test.toString().equals("[Bun, Beef, Bun]")){
			System.out.println("Error: test.changePatties('Beef') has failed");
			System.out.println(test);
		}
		
		testBaron.changePatties("Chicken");
		if(!testBaron.toString().equals("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, "
				+ "Tomato, Onions, Pepperjack, Mozzarella, Cheddar, Chicken, Mushrooms, "
				+ "Mustard, Ketchup, Bun]")){
			System.out.println("Error: testBaron.changePatties('Chicken') has failed");
			System.out.println(testBaron);
		}
		
		testBaron.changePatties("Veggie");
		if(!testBaron.toString().equals("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, "
				+ "Tomato, Onions, Pepperjack, Mozzarella, Cheddar, Veggie, Mushrooms, "
				+ "Mustard, Ketchup, Bun]")){
			System.out.println("Error: testBaron.changePatties('Veggie') has failed");
			System.out.println(testBaron);
		}
		
		testBaron.changePatties("Beef");
		if(!testBaron.toString().equals("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, "
				+ "Tomato, Onions, Pepperjack, Mozzarella, Cheddar, Beef, Mushrooms, "
				+ "Mustard, Ketchup, Bun]")){
			System.out.println("Error: testBaron.changePatties('Beef') has failed");
			System.out.println(testBaron);
		}
		
		test.addPatty();
		if(!test.toString().equals("[Bun, Beef, Beef, Bun]")){
			System.out.println("Error: test.addPatty() has failed");
			System.out.println(test);
		}
		
		test.addPatty();
		if(!test.toString().equals("[Bun, Beef, Beef, Beef, Bun]")){
			System.out.println("Error: test.addPatty().addPatty(); has failed");
			System.out.println(test);
		}
		test.removeIngredient("beef");
		if(!test.toString().equals("[Bun, Bun]")){
			System.out.println("Error: test.removeIngredient('beef'); has failed");
			System.out.println(test);
		}
		testBaron.removeIngredient("Mozzarella");
		testBaron.removeIngredient("Pickle");
		testBaron.removeIngredient("Mustard");
		if(!testBaron.toString().equals("[Bun, Mayonnaise, Baron-Sauce, Lettuce, "
				+ "Tomato, Onions, Pepperjack, Cheddar, Beef, Mushrooms, "
				+ "Ketchup, Bun]")){
			System.out.println("Error: testBaron.removeIngredient('Mozzarella "
					+ "//or pickle or Mustard//); has failed");
			System.out.println(testBaron);
		}
		//NOTE: im making a new basic burger called test2
		Burger test2 = new Burger();
		test2.Burger(false);
		test2.addCategory("cheese");
		test2.addCategory("veggies");
		test2.addCategory("sauce");
		if(!test2.toString().equals("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, "
				+ "Tomato, Onions, Pepperjack, Mozzarella, Cheddar, Beef, Mushrooms, "
				+ "Mustard, Ketchup, Bun]")){
			System.out.println("Error: test2.addCategory('cheese' //and veggies and sauce//); has failed");
			System.out.println(test2);
		}
		test2.removeCategory("cheese");
		test2.removeCategory("veggies");
		test2.removeCategory("sauce");
		if(!test2.toString().equals("[Bun, Beef, Bun]")){
			System.out.println("Error: test2.removeCategory('cheese' //and veggies and sauce//); has failed");
			System.out.println(test2);
		}
		test2.addIngredient("Pickle");
		test2.addIngredient("Mozzarella");
		test2.addIngredient("Ketchup");
		if(!test2.toString().equals("[Pickle, Bun, Mozzarella, Beef, Ketchup, Bun]")){
			System.out.println("Error: test2.addIngredient('Pickle' //and Mozz and Katchup//); has failed");
			System.out.println(test2);
		}
					
	}
}
