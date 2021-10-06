def main():
    n = int(input())
    dp = [0] * (n+1)
    dp[0] = 1
    for i in range(1, n+1):
        if i % 2 != 0:
            continue
        else:
            dp[i] += dp[i-2] * 3
            t = i - 4
            while t >= 0:
                dp[i] += dp[t] * 2
                t -= 2
    print(dp[n])


main()