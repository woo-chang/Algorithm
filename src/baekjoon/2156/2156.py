import sys


def main():
    n = int(sys.stdin.readline().rstrip())
    drink_amount = [0 for _ in range(n)]
    for i in range(n):
        drink_amount[i] = int(sys.stdin.readline().rstrip())
    dp = [[0, 0, 0] for _ in range(n)]
    dp[0][0] = 0
    dp[0][1] = drink_amount[0]
    dp[0][2] = drink_amount[0]
    for i in range(1, n):
        dp[i][0] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])
        dp[i][1] = dp[i-1][0] + drink_amount[i]
        dp[i][2] = dp[i-1][1] + drink_amount[i]
    print(max(dp[n-1][0], dp[n-1][1], dp[n-1][2]))


main()