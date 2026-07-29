package p0146_lru_cache

fun main() {
    val lRUCache = LRUCache(2)
    lRUCache.put(1, 1) // cache is {1=1}
    lRUCache.put(2, 2) // cache is {1=1, 2=2}
    check(lRUCache.get(1) == 1) // return 1
    lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    check(lRUCache.get(2) == -1) // returns -1 (not found)
    lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    check(lRUCache.get(1) == -1) // return -1 (not found)
    check(lRUCache.get(3) == 3) // return 3
    check(lRUCache.get(4) == 4) // return 4
}
