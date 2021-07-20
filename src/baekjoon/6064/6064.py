import sys


def gcd(x, y):
    while y != 0:
        r = x % y
        x = y
        y = r
    return x


def lcm(x, y):
    return x * y / gcd(x, y)


def main():
    test_case = int(input())
    for _ in range(test_case):
        input_data = list(map(int, sys.stdin.readline().rstrip().split()))
        cnt = input_data[2] % (input_data[0] + 1)  # x의 범위가 <= M 이므로
        pivot_y = input_data[2]
        for i in range(input_data[1]):
            y = input_data[1] if pivot_y % input_data[1] == 0 else pivot_y % input_data[1]
            if y == input_data[3]:
                break
            cnt += input_data[0]
            pivot_y = y + input_data[0]
        if cnt > lcm(input_data[0], input_data[1]):
            print(-1)
        else:
            print(cnt)


main()