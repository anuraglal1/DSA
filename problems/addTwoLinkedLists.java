//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class addTwoLinkedLists {
    public static class Node {
        int val;
        Node next;

        public Node(Node next, int val) {
            this.val = val;
            this.next = next;
        }

        public Node() {};
    }


    public static void main(String[] args) {
        int[] input1 = {2, 2, 3, 4};
        int[] input2 = {9, 2, 9, 3};

        System.out.println("Printing lists");

        // create list
        Node list1 = create(input1);
        print(list1);
        System.out.println();
        Node list2 = create(input2);
        print(list2);
        System.out.println();

//        System.out.println("Printing reversed lists");

        // reverse list
        Node revList1 = reverse(list1);
//        print(revList1);
//        System.out.println();
        Node revList2 = reverse(list2);
//        print(revList2);
//        System.out.println();

        // Add both the lists
        Node res = add(revList1, revList2);
//        System.out.println("Printing reversed Sum list");
//        print(res);
//        System.out.println();


        // reverse the resultant list
//        System.out.println("Printing Result");
        Node reversedResult = reverse(res);
        print(reversedResult);


    }

    public static Node add(Node list1, Node list2) {
        Node iter1 = list1;
        Node iter2 = list2;
        Node res = new Node();
        Node iter = res;
        int carry = 0;

        while (iter1 != null && iter2 != null) {
            int sum = iter1.val + iter2.val + carry;
            carry = sum/10;
            iter.next = new Node(null, sum % 10);
            iter = iter.next;
            iter1 = iter1.next;
            iter2 = iter2.next;
        }

        if (carry > 0) {
            iter.next = new Node(null, carry);
        }

        return res.next;
    }

    public static Node reverse(Node list1) {
        Node curr = list1;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // create linkedList by inserting at end
    public static Node create(int[] arr) {
        Node head = new Node(null, arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(null, arr[i]);;
            temp = temp.next;
        }

        return head;
    }

    public static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}