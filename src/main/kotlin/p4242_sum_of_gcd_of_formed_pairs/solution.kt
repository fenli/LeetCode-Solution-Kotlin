package p4242_sum_of_gcd_of_formed_pairs

class Solution {
    fun gcdSum(nums: IntArray): Long {
        val prefixGcd = IntArray(nums.size)
        var sum = 0L
        var mx = 0
        for (i in nums.indices) {
            mx = Math.max(nums[i], mx)
            prefixGcd[i] = gcd(nums[i], mx)
        }
        
        prefixGcd.sort()

        for (i in 0 until prefixGcd.size / 2) {
            sum += gcd(prefixGcd[i], prefixGcd[prefixGcd.size -1 -i])
        }

        return sum
    }

    private tailrec fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
