package easy

/**
 * [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
 */
fun e70_climbStairs(n: Int): Int {
    // bottom-up approach
    var prev = 1 // number of ways to climb to (i - 2) step
    var curr = 1 // number of ways to climb to (i - 1) step
    /*
     * For each step i, the number of distinct ways to climb to that step is equal to the sum of the number of
     * distinct ways to climb to the previous two steps f(n - 1) + f(n - 2), because we can either take one step from
     * the i-1th step or two steps from the i-2th step. This recurrence relation is similar to the Fibonacci sequence.
     */
    for (i in 1 until n) {
        curr += prev.also { prev = curr }
    }
    return curr
}