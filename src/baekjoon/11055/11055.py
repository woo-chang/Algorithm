def main():
    n = int(input())
    num_list = list(map(int, input().rstrip().split()))
    dp = [0] * n
    dp[0] = num_list[0]
    for i in range(1, n):
        for j in range(i):
            if num_list[i] > num_list[j]:
                if dp[i] < dp[j]:
                    dp[i] = dp[j]
        dp[i] += num_list[i]
    print(max(dp))


main()