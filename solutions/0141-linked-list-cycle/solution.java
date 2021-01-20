/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public boolean hasCycle(ListNode head) {
        ListNode fst = head;
        ListNode snd = head;
        
        int listNodeSize = 0;
        while (head != null) {
            listNodeSize++;
            if (listNodeSize >= 3) {
                break;
            }
        }
        
        // A linkedList needs to have at least 3 nodes to form a cycle
        if (listNodeSize < 3) {
            return false;
        }
        
        while (head != null) {
            fst = fst.next;
            
            // edge case
            if (snd.next == null) {
                break;
            }
            
            // edge case
            if (snd.next.next == null) {
                break;
            }
            snd = snd.next.next;
            
            if (fst == snd) {
                return true;
            }
            
            head = head.next;
        }
        
        return false;
    }
    
}
