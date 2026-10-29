package p4209_palindromic_path_queries_in_a_tree

class Solution {

    fun palindromePath(n: Int, edges: Array<IntArray>, s: String, queries: Array<String>): List<Boolean> {
        // ---------- CSR adjacency (no boxed lists) ----------
        val start = IntArray(n + 1)
        for (e in edges) {
            start[e[0] + 1]++
            start[e[1] + 1]++
        }
        for (i in 0 until n) start[i + 1] += start[i]
        val adj = IntArray(start[n])
        val pos = start.copyOf()
        for (e in edges) {
            adj[pos[e[0]]++] = e[1]
            adj[pos[e[1]]++] = e[0]
        }

        // ---------- BFS order: parent, depth (iterative, no recursion) ----------
        val parent = IntArray(n) { -1 }
        val depth = IntArray(n)
        val order = IntArray(n)
        var qh = 0
        var qt = 1
        while (qh < qt) {
            val u = order[qh++]
            for (k in start[u] until start[u + 1]) {
                val v = adj[k]
                if (v != parent[u]) {
                    parent[v] = u
                    depth[v] = depth[u] + 1
                    order[qt++] = v
                }
            }
        }

        // ---------- Subtree sizes + heavy child ----------
        val size = IntArray(n) { 1 }
        val heavy = IntArray(n) { -1 }
        for (i in n - 1 downTo 1) {
            val u = order[i]
            val p = parent[u]
            size[p] += size[u]
            if (heavy[p] == -1 || size[u] > size[heavy[p]]) heavy[p] = u
        }

        // ---------- Preorder tin (subtree = [tin, tin + size - 1]) and HLD heads ----------
        val tin = IntArray(n)
        val head = IntArray(n)
        for (i in 0 until n) {
            val u = order[i]
            var next = tin[u] + 1
            for (k in start[u] until start[u + 1]) {
                val v = adj[k]
                if (v != parent[u]) {
                    tin[v] = next
                    next += size[v]
                }
            }
            head[u] = if (i == 0 || heavy[parent[u]] != u) u else head[parent[u]]
        }

        // ---------- Fenwick (XOR), built in O(n) ----------
        val bit = IntArray(n + 1)
        val labels = s.toCharArray()
        for (i in 0 until n) {
            val m = 1 shl (labels[i] - 'a')
            bit[tin[i] + 1] = bit[tin[i] + 1] xor m
            val end = tin[i] + size[i] + 1
            if (end <= n) bit[end] = bit[end] xor m
        }
        for (i in 1..n) {
            val j = i + (i and -i)
            if (j <= n) bit[j] = bit[j] xor bit[i]
        }

        fun add(index: Int, value: Int) {
            var i = index
            while (i <= n) {
                bit[i] = bit[i] xor value
                i += i and -i
            }
        }

        fun prefix(index: Int): Int {
            var i = index
            var r = 0
            while (i > 0) {
                r = r xor bit[i]
                i -= i and -i
            }
            return r
        }

        // ---------- LCA via heavy-light decomposition: O(log n), O(n) memory ----------
        fun lca(a: Int, b: Int): Int {
            var u = a
            var v = b
            while (head[u] != head[v]) {
                if (depth[head[u]] > depth[head[v]]) u = parent[head[u]]
                else v = parent[head[v]]
            }
            return if (depth[u] < depth[v]) u else v
        }

        fun parseInt(str: String, from: Int, to: Int): Int {
            var r = 0
            for (i in from until to) r = r * 10 + (str[i] - '0')
            return r
        }

        // ---------- Process queries ----------
        val ans = ArrayList<Boolean>(queries.size)

        for (q in queries) {
            val sp1 = q.indexOf(' ')
            val sp2 = q.indexOf(' ', sp1 + 1)

            if (q[0] == 'u') {
                val u = parseInt(q, sp1 + 1, sp2)
                val c = q[sp2 + 1]
                val delta = (1 shl (labels[u] - 'a')) xor (1 shl (c - 'a'))
                if (delta != 0) {
                    labels[u] = c
                    add(tin[u] + 1, delta)
                    val end = tin[u] + size[u] + 1
                    if (end <= n) add(end, delta)
                }
            } else {
                val u = parseInt(q, sp1 + 1, sp2)
                val v = parseInt(q, sp2 + 1, q.length)
                val w = lca(u, v)
                val m = prefix(tin[u] + 1) xor prefix(tin[v] + 1) xor (1 shl (labels[w] - 'a'))
                ans.add(m and (m - 1) == 0)
            }
        }

        return ans
    }
}
