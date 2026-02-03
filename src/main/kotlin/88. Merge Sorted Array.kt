/**
 * Problem : https://leetcode.com/problems/merge-sorted-array/description/
 * Submission : https://leetcode.com/problems/merge-sorted-array/submissions/1906425605
 */

class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        for (x in 0 until n) {
            val n2 = nums2[x]
            var carry: Int? = null
            for (i in 0..m + x) {
                if (nums1[i] == 0 && i >= m + x) {
                    if (carry != null) {
                        nums1[i] = carry
                    } else {
                        nums1[i] = n2
                    }
                    break
                } else if (n2 < nums1[i] && carry == null) {
                    carry = nums1[i]
                    nums1[i] = n2
                } else if (carry != null) {
                    val temp = nums1[i]
                    nums1[i] = carry
                    carry = temp
                }
            }
        }
    }
}

fun main() {
    val solution = Solution88()

    // Case 1
    val n1 = intArrayOf(1, 2, 3, 0, 0, 0)
    solution.merge(n1, 3, intArrayOf(2, 5, 6), 3)
    check(n1.contentEquals(intArrayOf(1, 2, 2, 3, 5, 6)))

    // Case 2
    val n2 = intArrayOf(1)
    solution.merge(n2, 1, intArrayOf(), 0)
    check(n2.contentEquals(intArrayOf(1)))

    // Case 3
    val n3 = intArrayOf(0)
    solution.merge(n3, 0, intArrayOf(1), 1)
    check(n3.contentEquals(intArrayOf(1)))
}
