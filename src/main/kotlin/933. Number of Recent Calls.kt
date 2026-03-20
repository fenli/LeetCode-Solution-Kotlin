/**
 * Problem : https://leetcode.com/problems/number-of-recent-calls/description/
 * Submission : https://leetcode.com/problems/number-of-recent-calls/submissions/1953854250
 */

class RecentCounter() {

    private val calls = mutableListOf<Int>()

    fun ping(t: Int): Int {
        calls.add(t)
        return calls.count { t - it <= 3000 }
    }
}

fun main() {
    val recentCounter = RecentCounter()
    check(recentCounter.ping(1) == 1) // requests = [1], range is [-2999,1], return 1
    check(recentCounter.ping(100) == 2) // requests = [1, 100], range is [-2900,100], return 2
    check(recentCounter.ping(3001) == 3) // requests = [1, 100, 3001], range is [1,3001], return 3
    check(recentCounter.ping(3002) == 3) // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
}
