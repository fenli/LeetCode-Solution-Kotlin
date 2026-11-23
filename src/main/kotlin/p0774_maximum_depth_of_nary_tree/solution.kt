package p0774_maximum_depth_of_nary_tree

class Solution {

    fun maxDepth(root: Node?) = depth(root, 0)

    fun depth(node: Node?, acc: Int): Int = when {
        node == null -> acc
        node.children.isNotEmpty() -> node
            .children
            .map{ depth(it, acc + 1) }
            .maxOrNull() 
            ?: 0
        else -> acc + 1
    }
}
