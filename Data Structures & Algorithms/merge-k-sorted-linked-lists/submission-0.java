/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      List<Integer> nodes = new ArrayList<>();
      for (ListNode node:lists) {
        while (node!=null) {
            nodes.add(node.val);
            node=node.next;
        }
      }
      Collections.sort(nodes);
      ListNode ans=new ListNode(0);
      ListNode curr=ans;
      for (int node:nodes) {
        curr.next=new ListNode(node);
        curr=curr.next;
      }
      return ans.next;  

    }
}
