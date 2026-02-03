package p0071_simplify_path

class Solution {
    fun simplifyPath(path: String): String {
        val canonical = Stack<String>()

        var temp: String = ""
        for (c in path) {
            when(c) {
                '/' -> {
                    if (!temp.isEmpty()) {
                        if (temp == "..") {
                            if (!canonical.isEmpty()) canonical.pop()
                        } else if (temp != ".") {
                            canonical.add(temp)
                        }
                        temp = ""
                    }
                }
                else -> { 
                    temp += c 
                }
            }
        }

        if (temp == "..") {
            if (!canonical.isEmpty()) canonical.pop()
        } else if (!temp.isEmpty() && temp != ".") canonical.push(temp)

        return serialize(canonical)
    }

    fun serialize(paths: List<String>): String {
        if (paths.isEmpty()) return "/"
        var pathStr = ""
        paths.forEach { pathStr += "/" + it }
        return pathStr
    }
}
