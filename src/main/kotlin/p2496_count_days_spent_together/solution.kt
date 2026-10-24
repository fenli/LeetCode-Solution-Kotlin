package p2496_count_days_spent_together

class Solution {

    fun countDaysTogether(
        arriveAlice: String,
        leaveAlice: String,
        arriveBob: String,
        leaveBob: String,
    ): Int {
        val a0 = dayOfNonLeapYear(arriveAlice)
        val a1 = dayOfNonLeapYear(leaveAlice)
        val b0 = dayOfNonLeapYear(arriveBob)
        val b1 = dayOfNonLeapYear(leaveBob)
        return (minOf(a1, b1) - maxOf(a0, b0) + 1).coerceAtLeast(0)
    }

    private fun dayOfNonLeapYear(date: String): Int {
        val month = date.substring(0, 2).toInt()
        val day = date.substring(3, 5).toInt()
        if (month == 1) {
            return day
        }

        val daysAtMonthEnds = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        for (i in 2..12) {
            daysAtMonthEnds[i] += daysAtMonthEnds[i - 1]
        }

        return daysAtMonthEnds[month - 1] + day
    }
}
