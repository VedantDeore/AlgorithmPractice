func canPartition(nums []int) bool {
    n := len(nums)
	if n == 0 {
		return false
	}

	totalSum := 0
	for i := 0; i < n; i++ {
		totalSum += nums[i]
	}
	if totalSum%2 != 0 {
		return false
	}

	k := totalSum / 2

	prev := make([]bool, k+1)
	prev[0] = true
	if nums[0] <= k {
		prev[nums[0]] = true
	}

	for index := 1; index < n; index++ {
		curr := make([]bool, k+1)
		curr[0] = true
		for target := 1; target <= k; target++ {
			nottake := prev[target]
			take := false
			if target >= nums[index] {
				take = prev[target-nums[index]]
			}
			curr[target] = take || nottake
		}
		prev = curr
	}

	return prev[k]
}