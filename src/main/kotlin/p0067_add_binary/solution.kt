package p0067_add_binary

class Solution {
    fun addBinary(a: String, b: String): String {
        var carry = false
        return buildString {
            for (i in 0 until maxOf(a.length, b.length)) {
                val aa = a.getOrNull(a.length - 1 -i) ?: '0'
                val bb = b.getOrNull(b.length - 1 -i) ?: '0'

                if (aa == '1' && bb == '1') {
                    if (carry) insert(0, '1')
                    else {
                        insert(0, '0')
                        carry = true
                    }
                } else if (aa == '0' && bb == '0') {
                    if (carry) {
                        insert(0, '1')
                        carry = false
                    } else insert(0, '0')
                } else {
                    if (carry) insert(0, '0')
                    else insert(0, '1')
                }
            }

            if (carry) insert(0, '1')
        }
    }
}
