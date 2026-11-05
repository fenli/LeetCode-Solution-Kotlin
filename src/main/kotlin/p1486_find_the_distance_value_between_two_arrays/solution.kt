package p1486_find_the_distance_value_between_two_arrays

class Solution {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int =
        arr1.count { element -> arr2.none { Math.abs(element - it) <= d } }
}
