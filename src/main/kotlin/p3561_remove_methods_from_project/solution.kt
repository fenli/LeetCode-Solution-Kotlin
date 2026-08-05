package p3561_remove_methods_from_project

class Solution {

    class Node(val value: Int, val childs: MutableList<Node> = mutableListOf())

    fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): List<Int> {
        val nodes = Array<Node>(n) { i -> Node(i)}
        for ((a, b) in invocations) nodes[a].childs.add(nodes[b])
        val susNodes = susNodes(nodes[k], mutableSetOf())
        val outerNodes = mutableListOf<Int>()

        for (i in 0 until n) {
            if (!susNodes.contains(i)) {
                outerNodes.add(i)
                for (child in nodes[i].childs) {
                    if (susNodes.contains(child.value)) {
                        return (0..n-1).toList()
                    }
                }
            }
        }

        return outerNodes
    }

    fun susNodes(root: Node, set: MutableSet<Int>) : Set<Int> {
        set.add(root.value)
        for (child in root.childs) {
            if (!set.contains(child.value)) susNodes(child, set)
        }
        return set
    }
}
