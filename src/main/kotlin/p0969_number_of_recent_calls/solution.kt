package p0969_number_of_recent_calls

class RecentCounter() {

    private val calls = mutableListOf<Int>()

    fun ping(t: Int): Int {
        calls.add(t)
        return calls.count { t - it <= 3000 }
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */
