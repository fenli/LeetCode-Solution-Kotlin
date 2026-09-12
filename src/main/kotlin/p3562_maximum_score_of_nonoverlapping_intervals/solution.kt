package p3562_maximum_score_of_nonoverlapping_intervals

class Solution {
    fun maximumWeight(intervals: List<List<Int>>): IntArray {
        val n = intervals.size
        val arr = Array(n) { IntArray(4) }

        for (i in 0 until n) {
            arr[i][0] = intervals[i][0]
            arr[i][1] = intervals[i][1]
            arr[i][2] = intervals[i][2]
            arr[i][3] = i
        }

        arr.sortBy { it[1] }

        val dpWeight = Array(n + 1) { LongArray(5) }
        val dpList = Array(n + 1) {
            Array(5) { mutableListOf<Int>() }
        }

        for (i in 1..n) {
            val l = arr[i - 1][0]
            val w = arr[i - 1][2].toLong()
            val id = arr[i - 1][3]

            var low = 1
            var high = i - 1
            var prev = 0

            while (low <= high) {
                val mid = low + (high - low) / 2

                if (arr[mid - 1][1] < l) {
                    prev = mid
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }

            for (k in 1..4) {
                val skipW = dpWeight[i - 1][k]
                val skipList = dpList[i - 1][k]

                val takeW = dpWeight[prev][k - 1] + w
                val takeList = dpList[prev][k - 1].toMutableList()

                takeList.add(id)
                takeList.sort()

                when {
                    takeW > skipW -> {
                        dpWeight[i][k] = takeW
                        dpList[i][k] = takeList
                    }

                    takeW == skipW -> {
                        if (isLexicographicallySmaller(takeList, skipList)) {
                            dpWeight[i][k] = takeW
                            dpList[i][k] = takeList
                        } else {
                            dpWeight[i][k] = skipW
                            dpList[i][k] = skipList
                        }
                    }

                    else -> {
                        dpWeight[i][k] = skipW
                        dpList[i][k] = skipList
                    }
                }
            }
        }

        return dpList[n][4].toIntArray()
    }

    private fun isLexicographicallySmaller(
        a: List<Int>,
        b: List<Int>
    ): Boolean {
        val size = minOf(a.size, b.size)

        for (i in 0 until size) {
            if (a[i] != b[i]) {
                return a[i] < b[i]
            }
        }

        return a.size < b.size
    }
}
