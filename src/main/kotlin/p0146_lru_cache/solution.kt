package p0146_lru_cache

class LRUCache(val capacity: Int) {

    var age = 0
    val ages = HashMap<Int, Int>(capacity)
    val cache = HashMap<Int, Int>(capacity)

    fun get(key: Int): Int {
        if (cache.contains(key)) {
            ages[key] = age++
            return cache[key]!!
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        if (cache.size >= capacity && !cache.contains(key)) {
            val lruKey = ages.minBy { it.value }.key
            cache.remove(lruKey)
            ages.remove(lruKey)
        }

        ages[key] = age++
        cache[key] = value
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
