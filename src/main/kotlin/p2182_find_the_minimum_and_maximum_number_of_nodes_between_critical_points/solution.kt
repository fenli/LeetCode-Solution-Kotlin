package p2182_find_the_minimum_and_maximum_number_of_nodes_between_critical_points

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

    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        var prev = head
        var cur = head?.next
        var idx = 1
        var firstCritical = -1
        var lastCritical = -1
        var minDist = Int.MAX_VALUE

        while (cur?.next != null) {
            val next = cur.next

            val isMax = cur.`val` > prev!!.`val` && cur.`val` > next.`val`
            val isMin = cur.`val` < prev.`val` && cur.`val` < next.`val`

            if (isMax || isMin) {
                if (lastCritical == -1) {
                    firstCritical = idx
                } else {
                    minDist = minOf(minDist, idx - lastCritical)
                }
                lastCritical = idx
            }

            prev = cur
            cur = next
            idx++
        }

        if (firstCritical == -1 || firstCritical == lastCritical) {
            return intArrayOf(-1, -1)
        }

        val maxDist = lastCritical - firstCritical

        return intArrayOf(minDist, maxDist)
    }
}

