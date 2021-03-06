package at.fhj.itm.swd;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class StringStackTest {
	@Rule
	public TestName testname = new TestName();
	final static Logger logger = Logger.getLogger("Testlogger");

	private StringStack s;

	@Before
	public void setup() {
		logger.info("Starting test: " + testname.getMethodName());
		s = new StringStack(5);
	}

	/**
	 * check that Elements are removed from stack to avoid memory leaks!
	 */
	@Test
	public void testStringStackContent() {

		assertTrue(areAllArrayElementsNull(s.getElementData()));

		logger.info(s.getElementIndex()+ "");
		
		s.push("aaa");
		s.push("bbb");
		s.push("ccc");
		s.push("ddd");
		s.push("eee");

		logger.info(s.getElementIndex()+ "");

		
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();

		logger.info(s.getElementIndex()+ "");

		
		assertTrue(areAllArrayElementsNull(s.getElementData()));

	}

	/*
	 * helper method to check if all array elements are null references
	 * if all elements are null - true is returned
	 * if at least one element is found not to be null - false is returned.
	 */
	
	public boolean areAllArrayElementsNull(String[] array) {

		for (String str : array) {
			if (str != null)
			{
				logger.info("String is not empty");
				return false;
			}
		}
		return true;
	}

	/**
	 * tests if stack is empty after initialization
	 * 
	 * use two asserts - assertTrue to check it's empty - assertFalse to check
	 * it's not empty
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(s.isEmpty());
		s.push("one");
		assertFalse(s.isEmpty());
		s.pop();
		assertTrue(s.isEmpty());
	}

	/**
	 * tests push and pop function
	 * 
	 * do following test - use push, 1 or x times - use pull, as often as you
	 * use push - use isEmpty to check that's empty again - assert every content
	 * of the stack in the correct ordering
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPushPop() {
				
		assertTrue(s.isEmpty());

		s.push("aaa");		

		assertFalse(s.isEmpty());

		s.pop();
		
		
		assertTrue(s.isEmpty());
	}

	/**
	 * use pop on empty stack an exception must be "expected" (!) it's not valid
	 * to use an if else case (!)
	 */
	@Test(expected = IllegalStateException.class)
	public void testPopEmptyStack() {
		s.pop(); // !!!
	}

	/**
	 * use push more often than the size of the stack is defined e.g. stack has
	 * a size of 5 so you have to call push 6 times (!)
	 *  further more an exception must be "expected"
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testPushFullStack() {
		
		for(int x = 0; x <= s.getElementData().length; x++)
		{
			s.push("aaa");
		}
	}
}
