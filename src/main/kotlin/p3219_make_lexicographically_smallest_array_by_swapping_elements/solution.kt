package p3219_make_lexicographically_smallest_array_by_swapping_elements

class Solution {

    fun lexicographicallySmallestArray(
        nums: IntArray,
        limit: Int
    ): IntArray {
        val n = nums.size

        val sorted = nums.clone()
        sorted.sort()

        val group = HashMap<Int, MutableList<Int>>()
        val groupId = HashMap<Int, Int>()
        val pos = HashMap<Int, Int>()

        var id = 1

        // Build groups
        group.getOrPut(id) { mutableListOf() }.add(sorted[0])

        for (i in 1 until n) {
            if (sorted[i] - sorted[i - 1] > limit) {
                id++
            }

            group.getOrPut(id) { mutableListOf() }.add(sorted[i])
        }

        // Store group id of every value
        id = 1

        for (i in 0 until n) {
            if (i > 0 && sorted[i] - sorted[i - 1] > limit) {
                id++
            }

            groupId[sorted[i]] = id
        }

        // Position pointer for each group
        for (i in 1..id) {
            pos[i] = 0
        }

        // Rebuild nums using the smallest
        // available value from its group
        for (i in 0 until n) {
            val grp = groupId[nums[i]]!!

            nums[i] = group[grp]!![pos[grp]!!]
            pos[grp] = pos[grp]!! + 1
        }

        return nums
    }
}
