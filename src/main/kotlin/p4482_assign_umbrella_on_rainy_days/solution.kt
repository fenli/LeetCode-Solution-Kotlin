package p4482_assign_umbrella_on_rainy_days

class Solution {
    fun assignUmbrella(rain: IntArray): Array<String> {
        val n = rain.size
        val answer = Array(n) { "None" }

        var aliceCount = 0
        var bobCount = 0

        for (i in 0 until n) {
            val aliceNeeds = i < n - 1 &&
                rain[i] == 1 && rain[i + 1] == 1

            val bobNeeds = rain[i] == 1

            when {
                aliceNeeds && bobNeeds -> {
                    if (aliceCount <= bobCount) {
                        answer[i] = "Alice"
                        aliceCount++
                    } else {
                        answer[i] = "Bob"
                        bobCount++
                    }
                }

                aliceNeeds -> {
                    answer[i] = "Alice"
                    aliceCount++
                }

                bobNeeds -> {
                    answer[i] = "Bob"
                    bobCount++
                }
            }
        }

        return answer
    }
}
