package task5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DequesTest {

	@Test
	void test() {
		DequeueImplementation deque = new DequeueImplementation();
		deque.addLast("a");
		deque.addLast("b");
		assertTrue(deque.size() == 2, "Test failed, size should be 2");
		assertTrue("a".equals(deque.peekFirst()), "First element should be ‘a‘");
		assertTrue("b".equals(deque.peekLast()), "Last element should be ‘b'");
		// dequeue
		assertTrue("a".equals(deque.removeFirst()), "Expected element is ‘a'");
		assertTrue("b".equals(deque.removeFirst()), "Expected element is 'b'");
		assertTrue(deque.size() == 0, "Test failed, size should be 0");
		assertTrue(deque.peekFirst() == null, "List is empty, peekFirst() should return null");
		assertTrue(deque.peekLast() == null, "List is empty, peekLast() should return null");
		// push
		deque.addFirst("a");
		deque.addFirst("b");
		assertTrue(deque.size() == 2, "Test failed, size should be 2");
		assertTrue("b".equals(deque.peekFirst()), "Expected element is ‘b‘");
		assertTrue("a".equals(deque.peekLast()), "Expected element is ‘a'");
		// pop
		assertTrue("b".equals(deque.removeFirst()), "Expected element is ‘b‘");
		assertTrue("a".equals(deque.removeFirst()), "Expected element is ‘a‘'");
		assertTrue(deque.size() == 0, "Test failed, size should be 0");
	}

}
