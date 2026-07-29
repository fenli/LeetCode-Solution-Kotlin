package p0071_simplify_path

fun main() {
    val solution = Solution()
    check(solution.simplifyPath("/home/") == "/home")
    check(solution.simplifyPath("/home//foo/") == "/home/foo")
    check(solution.simplifyPath("/home/user/Documents/../Pictures") == "/home/user/Pictures")
    check(solution.simplifyPath("/../") == "/")
    check(solution.simplifyPath("/.../a/../b/c/../d/./") == "/.../b/d")
}
