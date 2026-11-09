package p1710_find_servers_that_handled_most_number_of_requests

class Solution {
    fun busiestServers(k: Int, arrival: IntArray, load: IntArray): List<Int> {
        val availableServers = TreeSet<Int>() { a, b -> a - b }
        val busyServers = PriorityQueue<Pair<Int, Int>>() { a, b -> a.second - b.second } // Pair of (server, availableTime)
        val requestsTaken = IntArray(k) { 0 }

        for (i in 0 until k) {
            availableServers.add(i)
        }

        for (requestNumber in 0 until arrival.size) {
            while (busyServers.isNotEmpty() && busyServers.peek().second <= arrival[requestNumber]) {
                availableServers.add(busyServers.poll().first)
            }

            if (availableServers.isNotEmpty()) {
                val server = availableServers.ceiling(requestNumber % k) ?: availableServers.first()
                requestsTaken[server]++
                availableServers.remove(server)
                busyServers.offer(Pair(server, arrival[requestNumber] + load[requestNumber]))
            }
        }

        var maxLoad = 0
        var result = mutableListOf<Int>()
        for ((server, load) in requestsTaken.withIndex()) {
            if (load > maxLoad) {
                maxLoad = load
                result = mutableListOf(server)
            } else if (load == maxLoad) {
                result.add(server)
            }
        }

        return result
    }
}
