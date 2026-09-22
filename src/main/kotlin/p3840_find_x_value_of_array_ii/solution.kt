package p3840_find_x_value_of_array_ii

class Solution {

    private class Node(k: Int) {
        val cnt = IntArray(k)
        var prod = 1
    }

    private class SegTree(
        private val nums: IntArray,
        private val k: Int
    ) {
        private val n = nums.size
        private var s = 1
        private val tree: Array<Node>

        init {
            while (s < n) {
                s = s shl 1
            }

            tree = Array(2 * s) { Node(k) }

            for (i in 0 until n) {
                val aMod = nums[i] % k
                tree[s + i].cnt[aMod] = 1
                tree[s + i].prod = aMod
            }

            for (p in s - 1 downTo 1) {
                tree[p] = merge(tree[2 * p], tree[2 * p + 1])
            }
        }

        private fun merge(l: Node, r: Node): Node {
            val res = Node(k)

            for (i in 0 until k) {
                res.cnt[i] = l.cnt[i]
            }

            for (rB in 0 until k) {
                val c = r.cnt[rB]

                if (c != 0) {
                    val rValue = (l.prod * rB) % k
                    res.cnt[rValue] += c
                }
            }

            res.prod = (l.prod * r.prod) % k

            return res
        }

        fun update(idx: Int, value: Int) {
            var pos = s + idx
            val aMod = value % k

            tree[pos].cnt.fill(0)
            tree[pos].cnt[aMod] = 1
            tree[pos].prod = aMod

            pos = pos shr 1

            while (pos > 0) {
                tree[pos] = merge(tree[2 * pos], tree[2 * pos + 1])
                pos = pos shr 1
            }
        }

        fun query(left: Int, right: Int): Node {
            var l = left + s
            var r = right + s

            var cntL = Node(k)
            var cntR = Node(k)

            cntL.prod = 1
            cntR.prod = 1

            while (l < r) {
                if ((l and 1) == 1) {
                    cntL = merge(cntL, tree[l])
                    l++
                }

                if ((r and 1) == 1) {
                    r--
                    cntR = merge(tree[r], cntR)
                }

                l = l shr 1
                r = r shr 1
            }

            return merge(cntL, cntR)
        }
    }

    fun resultArray(
        nums: IntArray,
        k: Int,
        queries: Array<IntArray>
    ): IntArray {
        val st = SegTree(nums, k)
        val res = IntArray(queries.size)

        for (i in queries.indices) {
            val idx = queries[i][0]
            val value = queries[i][1]
            val start = queries[i][2]
            val x = queries[i][3]

            st.update(idx, value)

            val result = st.query(start, nums.size)
            res[i] = result.cnt[x]
        }

        return res
    }
}
