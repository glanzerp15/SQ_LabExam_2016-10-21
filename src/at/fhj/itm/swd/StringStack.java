package at.fhj.itm.swd;

import java.util.logging.Logger;

/**
 * Stack Implementation of <code>Stack</code> Interface. supports Strings and
 * must be initialized with max. number of of items.
 * 
 * @see Stack
 */
public class StringStack implements Stack {
	/**
	 * stores the string values of this stack
	 */
	// hint: change visibility!
	private String[] elementData;
	final static Logger logger = Logger.getLogger("Testlogger");

	/**
	 * is the position counter of the top item
	 */
	private int elementIndex;

	/**
	 * Constructor that initializes the stack with the given size.
	 *
	 * @param capacity
	 *            the size of the initialized stack. If the size is lower than
	 *            0, the Constructor will throw an exception
	 */
	public StringStack(int capacity) {
		logger.info("Capacity:" + capacity);
		if (capacity <= 0)
		{
			logger.warning("Capacity IllegalArgumentException: " + capacity);
			throw new IllegalArgumentException("size must be = 0");
		}

		elementData = new String[capacity];
		elementIndex = 0;
	}

	@Override
	public boolean isEmpty() {
		if(elementIndex == 0)
		{
			logger.info("Stack is empty");
			return true;
		}
		logger.info("Stack is not empty");
		return false;
	}


	@Override
	public String pop() {
		if (elementIndex == 0)
		{
			logger.warning("Capacity IllegalArgumentException:" + elementIndex + " elementIndex");
			throw new IllegalStateException();
		}
		elementIndex--;
		String element = elementData[elementIndex];
		
		// returns the element and decrement the counter
		// hint: change below
		elementData[elementIndex] = null;
		return element;

	}

	public String[] getElementData() {
		return elementData;
	}

	public int getElementIndex() {
		return elementIndex;
	}

	@Override
	public void push(String item) {
		if (elementIndex == elementData.length)
			throw new ArrayIndexOutOfBoundsException();
		
		elementIndex++;
		
		// add element to array and increment the counter
		elementData[elementIndex - 1] = item;

		
		
	}
}
