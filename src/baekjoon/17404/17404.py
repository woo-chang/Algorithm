def main():
    n = int(input())
    colors = []
    answer = [[0, 0, 0] for _ in range(n)]
    for _ in range(n):
        colors.append(list(map(int, input().split())))
    answer[0] = colors[0]
    result = 999999999
    for i in range(3):
        for j in range(1, n):
            if j == 1:
                answer[j][i] = 999999999
                answer[j][(i+2) % 3] = answer[j-1][i] + colors[j][(i+2) % 3]
                answer[j][(i+1) % 3] = answer[j-1][i] + colors[j][(i+1) % 3]
            else:
                answer[j][0] = min(answer[j-1][1], answer[j-1][2]) + colors[j][0]  # R
                answer[j][1] = min(answer[j-1][0], answer[j-1][2]) + colors[j][1]  # G
                answer[j][2] = min(answer[j-1][0], answer[j-1][1]) + colors[j][2]  # B

        if result > min(answer[n-1][(i+1) % 3], answer[n-1][(i+2) % 3]):
            result = min(answer[n-1][(i+1) % 3], answer[n-1][(i+2) % 3])

    print(result)


main()