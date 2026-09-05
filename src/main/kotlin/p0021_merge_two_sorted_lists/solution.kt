package p0021_merge_two_sorted_lists

import utils.ListNode

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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        var head: ListNode? = null
        var l1: ListNode? = null
        var l2: ListNode? = null
        if (list1!!.`val` <= list2!!.`val`) {
            head = list1
            l1 = list1
            l2 = list2
        } else {
            head = list2
            l1 = list2
            l2 = list1
        }

        while(l2 != null) {
            if (l1?.next != null && l1!!.next!!.`val` <= l2!!.`val`) {
                l1 = l1?.next
            } else {
                val temp = l1?.next
                l1?.next = l2
                l2 = temp
            }
        }

        return head
    }
}
