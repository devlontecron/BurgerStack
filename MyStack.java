/*Devin Durham
 * Spring 342 
 * Marriott
 */

public class MyStack <Type> {
	
	private class Node{
	
		Type item;
		Node next;
		
		public Node (Type theItem, Node theNode){
			item = theItem;
			next = theNode;
		}

	}
	
	public Node top = null;
	private int stackSize;
		
	public boolean isEmpty(){
		return top == null;	
		
	}
	
	public void push(Type item){
		stackSize++;
		top = new Node(item, top);
			
	}
	
	public Type pop(){
		stackSize--;
			Type x = top.item;
			top = top.next;
			return x;
	}

	public Type peek(){
		return top.item;	
	}
	
	public int size(){
        return stackSize;
	}
	
	
    public String toString() {
		
		
    	MyStack<Type> temp = new MyStack<Type>() ;
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i<this.size()+i; i++ ){
        	sb.append(peek());
        	temp.push(this.pop());
        	
        	if (i<this.size()+i){
        		sb.append(", ");
        	}
        }     
        for(int i = 0; i<temp.size()+i; i++ ){
            this.push(temp.pop());
        }       
        sb.append("]");
        return sb.toString();
    }
}
