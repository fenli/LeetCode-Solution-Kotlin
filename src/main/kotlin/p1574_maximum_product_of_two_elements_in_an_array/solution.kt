package p1574_maximum_product_of_two_elements_in_an_array

class Solution {
    fun maxProduct(nums: IntArray): Int {
        var n1 = -1
        var n2 = -1
        for (n in nums) {
            if (n1 < n2) n1 = maxOf(n1, n)
            else n2 = maxOf(n2, n)
        }

        return (n1-1) * (n2-1)
    }
}
