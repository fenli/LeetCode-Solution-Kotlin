package p1477_product_of_the_last_k_numbers

class ProductOfNumbers() {
    var length = 0
    var lastZero = 0
    val prefixProduct = IntArray(40001) { 1 }

    fun add(num: Int) {
        length++
        if (num == 0) {
            lastZero = length
            prefixProduct[0] = 1
        } else {
            prefixProduct[length - lastZero] = prefixProduct[length - lastZero - 1] * num 
        }
    }

    fun getProduct(k: Int): Int {
        return if (length - k < lastZero) 0 
        else prefixProduct[length - lastZero] / prefixProduct[length - lastZero - k]
    }

}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * var obj = ProductOfNumbers()
 * obj.add(num)
 * var param_2 = obj.getProduct(k)
 */
