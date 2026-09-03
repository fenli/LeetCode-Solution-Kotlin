package p4258_construct_uniform_parity_array_ii

class Solution {

    fun uniformArray(nums1: IntArray): Boolean {
        var mn = nums1[0]
        var hasOdd = false
        for (v in nums1) {
            if (v < mn) mn = v
            if ((v and 1) == 1) hasOdd = true
        }

        if ((mn and 1) == 1) return true
        return !hasOdd
    }
}

