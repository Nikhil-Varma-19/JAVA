import java.net.InetSocketAddress;

public class LL {


    public static int size;
    public  static class Node{
        int data;
        Node next;

        public  Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public  static  Node head;
    public  static  Node tail;

    // add first
    public void addFirst(int data){
        //step 1 :Create the new Node
        LL.Node newNode=new LL.Node(data);
        size++;
        if(head == null){
            head =tail=newNode;
            return;
        }
        //step2
        newNode.next=head;
//step 3
        head=newNode;
    }


    //addlast

    public void addLast(int data){
        LL.Node newNode=new LL.Node(data);
        size++;
        if(head == null){
            head =tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;

    }

    //print linkedList
    public void printLinkedList(){
        if(head == null) {
            System.out.println("LinkedList empty");
            return;
        }
        Node temp =head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.println();
    }

    // addMiddle

    public  void addMiddle(int idx,int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node temp = head;// travser or iteration
        Node newNode = new Node(data);
        size++;
        int i =0;

        //iterated to index-1
        while (i< idx-1){
            temp=temp.next;
            i++;
        }
        // i== idx-1 temp -> pre
        newNode.next=temp.next;
        temp.next=newNode;
    }

    //removeFirst

    public int removeFirst(){

        if(size == 0){
            System.out.println("Empty LinkedList");
            return  Integer.MAX_VALUE;
        }else if (size == 1){
            int val = head.data;
            head=tail=null;
            size--;
            return  val;
        }
        int val= head.data;
        head=head.next;
        size--;
        return val;
    }

    //removeLast

    public int removeLast(){
        if(size == 0){
            System.out.println("Empty LinkedList");
            return  Integer.MAX_VALUE;
        }else if (size == 1){
            int val = head.data;
            head=tail=null;
            size--;
            return  val;
        }

        Node temp=head;
// this will give the second last node of ll
        for (int i = 0; i < size-2; i++) {
            temp=temp.next;
        }
        int val =temp.next.data;
        temp.next=null;
        temp=tail;
        size--;
        return val;
    }

    //remove in the Middle
    public int removeMiddle(int idx){
        if(size == 0){
            System.out.println("Empty LinkedList");
            return  Integer.MAX_VALUE;
        }else if (size == 1){
            int val = head.data;
            head=tail=null;
            size--;
            return  val;
        }
        Node temp=head;
        int i=0;
        while (i<idx-1){
            temp=temp.next;
            i++;
        }
        //k==i-1
        int val=temp.next.data;
        temp.next=temp.next.next;
        size--;
        return val;
    }


    /*  Searck key by iteration */
    public void searchkeyitera(int key){
        Node temp=head;
        int i=0;// what idx it is present
        while (temp !=null){
            if(temp.data == key){
                System.out.println("Key Found on index :"+i);
                return;
            }
            temp=temp.next;
            i++;
        }
        System.out.println("Key is not Present");
    }

    /*  Searck key by recursion */
    public void searchkeyrecur(Node head,int key,int i){
        if(head == null){
            System.out.println("Not Found");
            return;
        }
        if(head.data == key){
            System.out.println("Found: "+i);
            return;
        }
        searchkeyrecur(head.next,key,i+1);
        // i++ is a postfix increment operation. It evaluates to the current value of i, and then increments i by 1. So, when i is passed to the recursive call, it's the current value of i, not the value after incrementing.

    }


    /* Reverse the linked List  */
    public void revserlist(){
        Node prev = null;
        Node curr  =head;
        Node next;
        while (curr != null ){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;

    }
    /* Reverse the linked List using recur */
    public  Node  revserRec(Node head){// Node Method is created so return statement in mandatory
        //base case
        if(head == null || head.next == null) {
            return  head;
        }

        Node newHead= revserRec(head.next);
        head.next.next=head;
        head.next=null;

        return newHead;

    }

    public static void main(String[] args) {
        LL linkedList = new LL();
        linkedList.addFirst(2);
        linkedList.addLast(3);
         linkedList.addFirst(1);
     //  linkedList.printLinkedList();
        linkedList.addMiddle(2,4);
        linkedList.printLinkedList();
        System.out.println("Size of LL "+ size);
//       linkedList.removeLast();
//        linkedList.removeMiddle(2);
//       linkedList.printLinkedList();
//        System.out.println("Size of LL "+ size);



        /*  Search key   */
        //    start
/*
        LL searchkey = new LL();
        searchkey.addFirst(5);
        searchkey.addFirst(4);
        searchkey.addFirst(3);

        searchkey.addFirst(2);
        searchkey.addFirst(1);
        searchkey.addLast(6);
        searchkey.addLast(7);
        searchkey.printLinkedList();
        searchkey.searchkeyitera(6);
*/
        /* using recursion*/
//      searchkey.searchkeyrecur(LL.head,5,0);


// end

        // ---->      // Reverse the Linked List
        //start

//        LL Linkedlist = new LL();
//       Linkedlist.addLast(1);
//        Linkedlist.addLast(2);
//        Linkedlist.addLast(3);
//        Linkedlist.addLast(4);
//        Linkedlist.addLast(5);
//        Linkedlist.addFirst(0);
//        Linkedlist.printLinkedList();
//        System.out.println("Reverse the LinkedList");
//      head=  Linkedlist.revserRec(head);
//        Linkedlist.printLinkedList();



        //end



    }
}