/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node newH = null;
        Node tHead = head;
        while(tHead != null){
            Node cn = tHead.next;
            Node newNode = new Node(tHead.val);
            tHead.next = newNode;
            newNode.next = cn;
            if(newH == null){
                newH = newNode;
            }
            tHead = cn;
        }
        
        tHead = head.next;
        Node pHead = head;
        while(tHead != null){
            Node pRandom = pHead.random;
            if(pRandom != null){
                tHead.random = pRandom.next;
            }else{
                tHead.random = null;
            }
            tHead = tHead.next;
            pHead = pHead.next;
            if(tHead != null){
                tHead = tHead.next;
                pHead = pHead.next;
            }
        }

        tHead = head.next;
        pHead = head;

        while(tHead!=null){
            Node oNext = tHead.next;
            if(oNext != null){
                tHead.next = oNext.next;
                pHead.next = oNext;
                pHead = oNext;
                tHead = oNext.next;
            }else{
                pHead.next = null;
                tHead = tHead.next;
            }
        }
        return newH;
    }
}