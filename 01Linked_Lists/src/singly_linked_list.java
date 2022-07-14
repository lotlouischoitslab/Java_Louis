import java.util.*;
public class singly_linked_list {
	private ListNode head;
	private static class ListNode {
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void display() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " --> " );
			current = current.next;
		}
		System.out.print("null");
	}
	
	public int length(ListNode input) {
		if (input == null) {
			return 0;
		}
		return 1 + length(input.next);
	}
	
	public void insertfront(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertend(int value) {
		ListNode newNode = new ListNode(value);
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	public void insert(int position,int value) {
		if (position == 0) {
			insertfront(value);
		} else{
			ListNode previous = head;
			int count = 1;
			
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}
			ListNode node = new ListNode(value);
			ListNode current = previous.next;
			previous.next = node;
			node.next = current;
			
		}
	}
	
	public static void main(String[] args) {
		singly_linked_list sll = new singly_linked_list();
		sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		sll.head.next = second;
		second.next = third;
		third.next = fourth;
		
		sll.display();
		System.out.println();
		System.out.println("Length of Linked List: " + sll.length(sll.head));
		
		//Insert a node at the front
		sll.insertfront(5);
		sll.display();
		System.out.println();
		
		//Insert a node at the end
		sll.insertend(20);
		sll.display();
		System.out.println();
		
		//Insert a node at a given position
		sll.insert(1,7);
		sll.display();
		System.out.println();
		
	}
}
