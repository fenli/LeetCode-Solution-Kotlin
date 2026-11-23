package p0765_serialize_and_deserialize_nary_tree

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

const val CHILDREN_SEPARATOR = "|"
const val NODE_SEPARATOR = "="

class Codec {
    fun serialize(root: Node?): String {
        if(root == null) return ""
        val sb = StringBuilder()
        bfs(root, sb)
        return sb.toString()
    }

    fun bfs(r: Node, sb: StringBuilder) {
        val queue = LinkedList<Node>()
        queue.add(r)
        sb.append(r.`val`).append(CHILDREN_SEPARATOR)
        while(queue.size > 0) {
            val qe = queue.poll()
            for(n in qe.children) {
                if(n != null) {
                    sb.append(n.`val`).append(NODE_SEPARATOR)
                    queue.add(n)
                }
            }
            sb.append(CHILDREN_SEPARATOR)
        }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): Node? {
        if(data.isEmpty()) return null
        val sq = LinkedList<String>(data.split(CHILDREN_SEPARATOR))
        if(sq.size == 0) return null
        val first = sq.poll()
        if(first.isEmpty()) return null
        val root = Node(first.toInt())

        val nq = LinkedList<Node>()
        nq.add(root)
        reconstruct(sq, nq)
        return root
    }

    fun reconstruct(sq: Queue<String>, nq: Queue<Node>) {
        while(sq.size > 1) {
            val str = sq.poll()
            val n = nq.poll()
            val clst = str.split(NODE_SEPARATOR)
            val mc = mutableListOf<Node>()
            for(s in clst) {
                if(s.isBlank()) {
                    continue
                }
                val nn = Node(s.toInt())
                nq.add(nn)
                mc.add(nn)
            }
            n.children = mc
        }
    }
}
