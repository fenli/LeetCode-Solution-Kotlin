package p1392_find_the_difference_of_two_arrays

class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val nums1set = hashSetOf<Int>()
        for (n in nums1) nums1set.add(n)

        val nums2set = hashSetOf<Int>()
        for (n in nums2) nums2set.add(n)

        return listOf(
            nums1set.filterNot { nums2set.contains(it) },
            nums2set.filterNot { nums1set.contains(it) }
        )
    }
}
