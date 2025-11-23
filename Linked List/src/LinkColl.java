import java.util.LinkedList;

public class LinkColl {
  private static int size;
  private static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  private static Node head;
  private static Node tail;

  public void printLinkedList() {
    if (head == null) {
      System.out.println("LinkedList empty");
      return;
    }
    System.out.print("Printing the LL: ");
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public void addLast(int data) {
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }

    tail.next = newNode;
    tail = newNode;

  }

  public void addFirst(int data) {
    //step 1 :Create the new Node
    Node newNode = new Node(data);
    size++;
    if (head == null) {
      head = tail = newNode;
      return;
    }
    //step2
    newNode.next = head;
//step 3
    head = newNode;
  }
  private Node getMid(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;//mid
  }

  public Node mergeLL(Node head1, Node head2) {
    Node mergedLL = new Node(-1);
    Node temp = mergedLL;

    while (head1 != null && head2 != null) {
      if (head1.data <= head2.data) {
        temp.next = head1;
        head1 = head1.next;

      } else {
        temp.next = head2;
        head2 = head2.next;

      }
      temp = temp.next;
    }
    while (head1 != null) {
      temp.next = head1;
      head1 = head1.next;
      temp = temp.next;
    }

    while (head2 != null) {
      temp.next = head2;
      head2 = head2.next;
      temp = temp.next;
    }
    return mergedLL.next;
  }
  public Node mergesort(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node mideMode=getMid(head);
    Node rightHead = mideMode.next;
    mideMode.next = null;
    Node leftLL = mergesort(head);
    Node rightLL = mergesort(rightHead);
    return mergeLL(leftLL, rightLL);
  }
  public static void main(String[] args) {

    LinkColl ll=new LinkColl();
    ll.addFirst(1);
    ll.addFirst(2);
    ll.addFirst(3);
    ll.addFirst(4);
    ll.addFirst(5);
    ll.printLinkedList();
    ll.head=ll.mergesort(ll.head);
    ll.printLinkedList();

  }
}
