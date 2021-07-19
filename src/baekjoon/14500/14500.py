import sys

dx = [0, 0, -1, 1]  # x축 이동 : 위, 아래, 왼쪽, 오른쪽
dy = [-1, 1, 0, 0]  # y축 이동 : 위, 아래, 왼쪽, 오른쪽
path_table = []  # 이동 경로를 나타내기 위한 테이블
table = []  # 좌표에 따른 값을 저장하기 위한 테이블
N = []
answer = 0


def tetro(x, y, now_sum, cnt):
    global answer
    if cnt == 4:
        if answer < now_sum:
            answer = now_sum
            return

    if x < 0 or y < 0 or x >= N[1] or y >= N[0]:
        return
    if cnt > 4:
        return
    if path_table[y][x] == 1:
        return

    path_table[y][x] = 1

    for i in range(4):
        tetro(x+dx[i], y+dy[i], now_sum+table[y][x], cnt+1)

    path_table[y][x] = 0


def main():
    global N
    global path_table

    N = list(map(int, sys.stdin.readline().rstrip().split()))
    for _ in range(N[0]):
        table.append(list(map(int, sys.stdin.readline().rstrip().split())))
    path_table = [[0 for j in range(N[1])] for i in range(N[0])]

    global answer
    for i in range(N[0]):
        for j in range(N[1]):
            tetro(j, i, 0, 0)  # 한 점에서 3칸을 이동하는 나머지 경우는 재귀로 해결
            # 예외 적으로 처리하는 부분은 if 문으로 따로 해결
            if j+2 < N[1]:
                sub_sum = table[i][j] + table[i][j+1] + table[i][j+2]
                if i+1 < N[0]:
                    sub_sum2 = sub_sum + table[i+1][j+1]
                    if answer < sub_sum2:
                        answer = sub_sum2
                if i-1 >= 0:
                    sub_sum2 = sub_sum + table[i-1][j+1]
                    if answer < sub_sum2:
                        answer = sub_sum2
            if i+2 < N[0]:
                sub_sum = table[i][j] + table[i+1][j] + table[i+2][j]
                if j+1 < N[1]:
                    sub_sum2 = sub_sum + table[i+1][j+1]
                    if answer < sub_sum2:
                        answer = sub_sum2
                if j-1 >= 0:
                    sub_sum2 = sub_sum + table[i+1][j-1]
                    if answer < sub_sum2:
                        answer = sub_sum2

    print(answer)


main()
