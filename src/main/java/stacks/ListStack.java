package stacks;

/**
 * A singly linked list-based implementation of Stack ADT.
 * The code is modified from the code of Prof. Galles. 
 */
public class ListStack implements Stack {
	private Node top; // the top of the stack

	public ListStack() {
		top = null;
	}

	/** Push the new element on top of the stack */
	public void push(Object elem) {
		//top = new Node(elem, top);
		Node newNode = new Node(elem);
		newNode.setNext(top);
		top = newNode;
		// By passing top as the value of the "next" pointer,
		// we connect the new node to the rest of the list
	}

	/** Check if the stack is empty */
	public boolean empty() {
		return top == null;
	}

	/** Pop the element at the top of the stack and return its value */
	public Object pop() {
		Object poppedValue;

		if (top == null)
			return null;
		poppedValue = top.getElem();
		top = top.next();
		return poppedValue;

	}

	public Object peek() {
		return top.getElem();
	}

	/** Print elements of the stack, starting at the top */
	public String toString() {
		Node stackPtr = top;
		String result = "[";
		if (stackPtr != null) {
			result = result + top.getElem();
			for (stackPtr = stackPtr.next(); stackPtr != null; stackPtr = stackPtr.next()) {
				result = result + "," + stackPtr.getElem();
			}

		}
		result = result + "]";
		return result;
	}
}
