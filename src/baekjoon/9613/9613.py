import sys


def gcd(a, b):
    while b != 0:
        r = a % b
        a = b
        b = r
    return a


def main():
    t = int(input())
    for _ in range(t):
        input_list = list(map(int, sys.stdin.readline().rstrip().split(" ")))
        num_list = input_list[1:]
        num_list.sort()
        i, j = 0, 0
        answer = 0
        list_length = len(num_list)
        while i < list_length-1:
            # if i != 0 and num_list[i-1] == num_list[i]:
            #     i += 1
            #     continue
            j = i + 1
            while j < list_length:
                # if num_list[i] == num_list[j] or num_list[j-1] == num_list[j]:
                #     j += 1
                #     continue
                answer += gcd(num_list[i], num_list[j])
                j += 1
            i += 1
        print(answer)


main()