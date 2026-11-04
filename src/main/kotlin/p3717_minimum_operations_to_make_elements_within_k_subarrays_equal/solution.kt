package p3717_minimum_operations_to_make_elements_within_k_subarrays_equal

class Window(
    private val nums: IntArray,
    private val x: Int
) {
    private val odd = x and 1

    // Order by value, then by index.
    private val order = Comparator<Int> { a, b ->
        if (nums[a] != nums[b]) {
            nums[a].compareTo(nums[b])
        } else {
            a.compareTo(b)
        }
    }

    // Indices of the window.
    private val s = TreeSet(order)

    // Index of the (h+1)-th smallest element.
    private var mid: Int

    private var low = 0L
    private var total = 0L

    init {
        for (i in 0 until x) {
            s.add(i)
            total += nums[i]
        }

        val it = s.iterator()

        for (i in 0 until x / 2) {
            low += nums[it.next()]
        }

        mid = it.next()
    }

    fun cost(): Long {
        // Larger half minus smaller half.
        return total - 2 * low - odd.toLong() * nums[mid]
    }

    fun slide(`in`: Int): Long {
        val out = `in` - x

        s.add(`in`)

        if (order.compare(`in`, mid) < 0) {
            // `in` joins the low half and pushes its largest up.
            mid = s.lower(mid)!!
            low += nums[`in`] - nums[mid]
        }

        if (order.compare(out, mid) < 0) {
            // `out` leaves the low half: mid moves down into it.
            low += nums[mid] - nums[out]
            mid = s.higher(mid)!!
        } else if (out == mid) {
            mid = s.higher(mid)!!
        }

        s.remove(out)
        total += nums[`in`] - nums[out]

        return cost()
    }
}

class Solution {
    fun minOperations(nums: IntArray, x: Int, k: Int): Long {
        val n = nums.size
        val win = Window(nums, x)

        val cost = LongArray(n - x + 1)
        cost[0] = win.cost()

        for (i in x until n) {
            cost[i - x + 1] = win.slide(i)
        }

        // best[i]: minimum operations for windows placed so far
        // inside nums[0 until i).
        var best = LongArray(n + 1)

        for (j in 0 until k) {
            val layer = LongArray(n + 1)

            for (i in 0 until x) {
                layer[i] = Long.MAX_VALUE / 2
            }

            for (i in x..n) {
                layer[i] = minOf(
                    layer[i - 1],
                    best[i - x] + cost[i - x]
                )
            }

            best = layer
        }

        return best[n]
    }
}
