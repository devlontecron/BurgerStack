/*Devin Durham
 * Spring 342 
 * Marriott
 */

public class Burger {

	String bun = "Bun";
	String mayo = "Mayonnaise";
	String BS = "Baron-Sauce";
	String lets = "Lettuce";
	String tom = "Tomato";
	String oni = "Onions";
	String pep = "Pepperjack";
	String ched = "Cheddar";
	String pat = "Patty";
	String mush = "Mushrooms";
	String must = "Mustard";
	String ketch = "Ketchup";
	String moz = "Mozzarella";
	String beef = "Beef";
	String chi = "Chicken";
	String veg = "Veggie";
	String pic = "Pickle";
	

	MyStack<String> BaronList = new MyStack<String>();
	MyStack<String> BaseList = new MyStack<String>();

	MyStack<String> CurrentList = new MyStack<String>();
	MyStack<String> TempList = new MyStack<String>();
	MyStack<String> TempListB = new MyStack<String>();

	private void BuildLists() {

		BaronList.push(bun);
		BaronList.push(ketch);
		BaronList.push(must);
		BaronList.push(mush);
		BaronList.push(beef);
		BaronList.push(ched);
		BaronList.push(moz);
		BaronList.push(pep);
		BaronList.push(oni);
		BaronList.push(tom);
		BaronList.push(lets);
		BaronList.push(BS);
		BaronList.push(mayo);
		BaronList.push(bun);
		BaronList.push(pic);

		BaseList.push(bun);
		BaseList.push(beef);
		BaseList.push(bun);

	}

	public void Burger(boolean theWorks) {
		BuildLists();
		if (theWorks) {
			CurrentList = BaseList;
			addCategory("veggies");
			addCategory("cheese");
			addCategory("sauce");
			
		} else {
			CurrentList = BaseList;
			
		}
	}

	public void changePatties(String pattyType) {
		while (CurrentList.top != null) {
			if (CurrentList.peek() == chi || CurrentList.peek() == veg || 
					CurrentList.peek() == beef) {
				CurrentList.pop();
				TempList.push(pattyType);
			} else {
				TempList.push(CurrentList.pop());
			}
		}
		while (TempList.top != null) {
			CurrentList.push(TempList.pop());
		}
	}

	public void addPatty() {
		
		Boolean foundCheese = false;
		while(CurrentList.top != null && !foundCheese){
			if(CurrentList.peek().equals(pep) || CurrentList.peek().equals(moz) 
					|| CurrentList.peek().equals(ched) ){
				TempList.push(beef);
				TempList.push(CurrentList.pop());
				foundCheese = true;
			} else{
				TempList.push(CurrentList.pop());
			}
		}
		while(TempList.top!= null){
			CurrentList.push(TempList.pop());
		}
		if (!foundCheese){
			addIngredient(beef);	
	}
	}

	public void addCategory(String type) {	
		//Tried to make a patty category type. it runs but doesnt produce the correct output
		/*		 
		if (type.equals("patties")) {
			removeCategory("patties");
			addIngredient(veg);
			addIngredient(beef);
			addIngredient(chi);

			while(BaronList.top != null){
				if(BaronList.peek().toLowerCase().equals("beef")){
					TempList.push(beef);
					TempList.push(chi);
					TempList.push(veg);
					TempListB.push(BaronList.pop());
					TempListB.push(chi);
					TempListB.push(veg);
				} else if(BaronList.peek().toLowerCase().equals(CurrentList.peek().toLowerCase())) {
					TempList.push(CurrentList.pop());
					TempListB.push(BaronList.pop());
				} else {
					TempListB.push(BaronList.pop());
					}
			}
			while(TempList.top!= null){
				CurrentList.push(TempList.pop());
			}
			while(TempListB.top!= null){
				BaronList.push(TempListB.pop());
			}
		} else if (type.equals("cheese")) {
		*/
		if (type.equals("cheese")) {
			addIngredient(pep);
			addIngredient(ched);
			addIngredient(moz);
		} else if (type.equals("veggies")) {
			addIngredient(pic);
			addIngredient(lets);
			addIngredient(tom);
			addIngredient(oni);
			addIngredient(mush);

		} else if (type.equals("sauce")) {
			addIngredient(ketch);
			addIngredient(must);
			addIngredient(mayo);
			addIngredient(BS);
		}
			
	}
		
	public void removeCategory(String type) {
		if (type.equals("patties")) {
			removeIngredient(beef);
			removeIngredient(veg);
			removeIngredient(chi);
		
		} else if (type.equals("cheese")) {
			removeIngredient(pep);
			removeIngredient(ched);
			removeIngredient(moz);

		} else if (type.equals("veggies")) {
			removeIngredient(pic);
			removeIngredient(lets);
			removeIngredient(tom);
			removeIngredient(oni);
			removeIngredient(mush);

		} else if (type.equals("sauce")) {
			removeIngredient(ketch);
			removeIngredient(must);
			removeIngredient(mayo);
			removeIngredient(BS);
		}
	}

	public void addIngredient(String type) {
			while (BaronList.top != null) {
				if (BaronList.peek().toLowerCase().equals(type.toLowerCase())) {
					TempListB.push(BaronList.pop());
					TempList.push(type);
				} else if (BaronList.peek().toLowerCase().equals(CurrentList.peek().toLowerCase())) {
					TempList.push(CurrentList.pop());
					TempListB.push(BaronList.pop());
				} else {
					TempListB.push(BaronList.pop());
					}
				}
			while (TempList.top != null) {
				CurrentList.push(TempList.pop());
			}
			while(TempListB.top != null){
				BaronList.push(TempListB.pop());
			}
	}
	
	public void removeIngredient(String type) {
		while (CurrentList.top != null) {
			if (CurrentList.peek().toLowerCase().equals(type.toLowerCase())) {
				CurrentList.pop();
			} else {
				TempList.push(CurrentList.pop());
			}
		}
		while (TempList.top != null) {
			CurrentList.push(TempList.pop());
		}
	}
	
	public String toString() {
		MyStack<String> temp = new MyStack<String>();
		final StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < CurrentList.size() + i; i++) {
			sb.append(CurrentList.peek());
			temp.push(CurrentList.pop());

			if (i < CurrentList.size() + i) {
				sb.append(", ");
			}
		}
		for (int i = 0; i < temp.size() + i; i++) {
			CurrentList.push(temp.pop());
		}
		sb.append("]");
		return sb.toString();
	}

}
