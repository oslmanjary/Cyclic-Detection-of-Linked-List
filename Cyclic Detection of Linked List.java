/* Program for the detection of cyclic nature of linked list*/


import java.util.*;
public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
	}
static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode fastptr = head;
        SinglyLinkedListNode slowptr = head;
        while(true){
            if(fastptr.next==null||fastptr.next.next==null){
                return false;
            }
            else{
                if(fastptr.next==slowptr){
                    return true;
                }
            }
            fastptr=fastptr.next.next;
            slowptr = slowptr.next;
        }


    }
	public static void main(String[] args){
		SinglyLinkedList sll = new SinglyLinkedList();
		Solution s = new Solution();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		while(input!=-1){
			sll.insertNode(input);
			input = sc.nextInt();
		}
		sll.tail.next=sll.head;
		boolean result = s.hasCycle(sll.head);
		//System.out.println(result);
	}
}