package stacks;

/* A class representing a node in a singly linked list */
public class Node {
	private Object elem;
	private Node next;
	
	public Node(Object elem, Node next) {
		this.elem = elem;
		this.next  = next;
	}
	
	public Node(Object elem) {
		this.elem = elem;
		next = null;
	}
	
	public Object getElem() {
		return elem;
	}
	
	public void setElem(Object elem) {
		this.elem = elem;
	}
	
	public Node next() {
		return next;
	}
	
	public void setNext(Node other) {
		next = other;
	}

	@Override
	public String toString() {
		return elem + ", ";
	}
}
