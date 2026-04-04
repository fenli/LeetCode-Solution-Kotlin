/**
 * Problem : https://leetcode.com/problems/n-th-tribonacci-number/description/
 * Submission : https://leetcode.com/problems/n-th-tribonacci-number/submissions/1968383922
 */

class Solution1137 {
    fun tribonacci(n: Int): Int {
        val arr = IntArray(38)
        arr[0] = 0
        arr[1] = 1
        arr[2] = 1
        if (n == 0) return 0
        if (n == 1) return 1
        if (n == 2) return arr[0] + arr[1]
        for (i in 3..n) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1]
            if (i == n) return arr[i]
        }
        return -1
    }
}

fun main() {
    val solution = Solution1137()
    check(solution.tribonacci(4) == 4)
    check(solution.tribonacci(25) == 1389537)
}
