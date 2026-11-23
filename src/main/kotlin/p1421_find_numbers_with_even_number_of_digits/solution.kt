package p1421_find_numbers_with_even_number_of_digits

class Solution {
    fun findNumbers(nums: IntArray): Int {
        return nums.count { abs(it).toString().length % 2 == 0 }
    }
}
