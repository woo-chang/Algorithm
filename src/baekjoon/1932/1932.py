import sys


def main():
    n = int(sys.stdin.readline().rstrip())
    num_triangle = []
    dp = [[0]*(i+1) for i in range(n)]
    for i in range(n):
        l = list(map(int, sys.stdin.readline().rstrip().split()))
        num_triangle.append(l)
    for i in range(n-1, -1, -1):
        for j in range(i+1):
            if i == n-1:
                dp[i][j] = num_triangle[i][j]
            else:
                dp[i][j] = max(dp[i+1][j], dp[i+1][j+1]) + num_triangle[i][j]
    print(dp[0][0])


main()