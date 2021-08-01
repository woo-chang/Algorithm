import sys


def main():
    n = int(input())
    num_list = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    stack = []
    result = [0 for _ in range(n)]
    for i in range(n):
        while stack and num_list[stack[-1]] < num_list[i]:
            result[stack.pop()] = str(num_list[i])
        stack.append(i)
    while stack:
        result[stack.pop()] = "-1"
    print(" ".join(result))


main()