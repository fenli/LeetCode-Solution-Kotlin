package p3576_find_subtree_sizes_after_changes

class Solution {
    // Complexity:
    // Time O(N) and Space O(N) where N is the length of parent.
    fun findSubtreeSizes(
        parent: IntArray,
        s: String,
    ): IntArray {
        val adjacencyList = buildAdjacencyList(parent)
        val ancestors = Array(26) { mutableListOf<Int>() }
        val subtreeSizes = IntArray(parent.size)
        dfs(0, parent, s, adjacencyList, ancestors, subtreeSizes)
        return subtreeSizes
    }

    private fun buildAdjacencyList(parent: IntArray): List<List<Int>> {
        val n = parent.size
        val adjList = List(n) { mutableListOf<Int>() }
        for (i in 1..<n) {
            adjList[parent[i]].add(i)
        }
        return adjList
    }

    private fun dfs(
        node: Int,
        parent: IntArray,
        s: String,
        adjacencyList: List<List<Int>>,
        ancestors: Array<MutableList<Int>>,
        subtreeSizes: IntArray,
    ) {
        val cIdx = s[node] - 'a'

        ancestors[cIdx].add(node)
        for (child in adjacencyList[node]) {
            dfs(child, parent, s, adjacencyList, ancestors, subtreeSizes)
        }
        ancestors[cIdx].removeLast()

        subtreeSizes[node]++
        if (node == 0) {
            return
        }
        val newParent = ancestors[cIdx].lastOrNull() ?: parent[node]
        subtreeSizes[newParent] += subtreeSizes[node]
    }
}
