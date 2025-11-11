func climbStairs(n int) int {
    prev := 1
    prev2 := 1
    for i := 2; i <= n; i++ {
        curri := prev + prev2
        prev2 = prev
        prev = curri
    }
    return prev
}