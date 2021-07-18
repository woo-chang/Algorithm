import sys


def next_permutation(arr):
    i = len(arr)-1
    while i > 0 and arr[i-1] >= arr[i]:
        i -= 1
    if i <= 0:
        return False
    j = len(arr)-1
    while arr[i-1] >= arr[j]:
        j -= 1
    arr[i-1], arr[j] = arr[j], arr[i-1]
    j = len(arr)-1
    while i < j:
        arr[i], arr[j] = arr[j], arr[i]
        i += 1
        j -= 1
    return True


def main():
    N = int(input())
    table = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
    sequence = [0 for _ in range(N//2)] + [1 for _ in range(N//2)]
    result = 1000000000
    while True:
        first = []
        second = []
        for i in range(N):
            if sequence[i] == 0:
                first.append(i)
            else:
                second.append(i)
        zero = 0
        one = 0
        for i in range(N//2):
            for j in range(N//2):
                if i == j:
                    continue
                zero += table[first[i]][first[j]]
                one += table[second[i]][second[j]]
        absNum = abs(zero-one)
        if result > absNum:
            result = absNum
        if not next_permutation(sequence):
            break
    print(result)


main()
