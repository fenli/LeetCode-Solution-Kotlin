package p1528_kids_with_the_greatest_number_of_candies

class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val result = mutableListOf<Boolean>()
        val max = candies.max()
        for (n in candies) {
            result.add(n + extraCandies >= max)
        }
        return result
    }
}
