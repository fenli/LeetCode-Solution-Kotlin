package p0206_reverse_linked_list

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var reversed: ListNode? = null
        var current = head

        while(current != null) {
            val temp = reversed
            reversed = ListNode(current.`val`)
            reversed.next = temp
            
            current = current.next
        }

        return reversed
    }
}
