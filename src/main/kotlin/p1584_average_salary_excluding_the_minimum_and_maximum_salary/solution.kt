package p1584_average_salary_excluding_the_minimum_and_maximum_salary

class Solution {
    fun average(salary: IntArray): Double {
        var max = salary[0]
        var min = salary[0]
        var sum = 0
        for (s in salary) {
            sum += s
            max = maxOf(max, s)
            min = minOf(min, s)
        }

        return (sum - max - min).toDouble() / (salary.size - 2)
    }
}
