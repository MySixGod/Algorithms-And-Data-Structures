class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        ans = nums[0]
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] > nums[l]:
                ans = min(ans, nums[l])
                l = mid + 1
            elif nums[mid] < nums[r]:
                ans = min(ans, nums[mid])
                r = mid - 1
            else:
                ans = min(ans, nums[mid], nums[r])
                break

        return ans
