def find_max(candies, n):
    answer = 1
    for i in range(n):
        for j in range(n):
            r = j + 1
            d = i + 1
            sub_answer = 1
            while r < n and candies[i][j] == candies[i][r]:
                sub_answer += 1
                r += 1
            answer = max(answer, sub_answer)
            sub_answer = 1
            while d < n and candies[i][j] == candies[d][j]:
                sub_answer += 1
                d += 1
            answer = max(answer, sub_answer)
    return answer


def find_right(candies, n, row):
    answer = 1
    for i in range(n):
        r = i + 1
        sub_answer = 1
        while r < n and candies[row][i] == candies[row][r]:
            sub_answer += 1
            r += 1
        answer = max(answer, sub_answer)
    return answer


def find_down(candies, n, col):
    answer = 1
    for i in range(n):
        d = i + 1
        sub_answer = 1
        while d < n and candies[i][col] == candies[d][col]:
            sub_answer += 1
            d += 1
        answer = max(answer, sub_answer)
    return answer


def main():
    n = int(input())
    candies = []
    answer = 0
    for _ in range(n):
        candies.append(list(input()))
    answer = max(answer, find_max(candies, n))
    for i in range(n):
        for j in range(n):
            if j + 1 < n:
                candies[i][j], candies[i][j+1] = candies[i][j+1], candies[i][j]
                answer = max(answer, find_down(candies, n, j), find_down(candies, n, j+1), find_right(candies, n, i))
                candies[i][j], candies[i][j+1] = candies[i][j+1], candies[i][j]
            if i + 1 < n:
                candies[i][j], candies[i+1][j] = candies[i+1][j], candies[i][j]
                answer = max(answer, find_down(candies, n, j), find_right(candies, n, i), find_right(candies, n, i+1))
                candies[i][j], candies[i+1][j] = candies[i+1][j], candies[i][j]
    print(answer)


main()