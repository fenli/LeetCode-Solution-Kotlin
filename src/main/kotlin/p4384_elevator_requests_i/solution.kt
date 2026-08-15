package p4384_elevator_requests_i

class Solution {
    fun elevatorRequests(n: Int, requests: IntArray): Int {
        var curr = 0
        var time = 0
        for (fl in requests) {
            time += Math.abs(fl - curr)
            curr = fl
        }

        return time
    }
}
