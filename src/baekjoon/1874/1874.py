import sys


def main():
    n = int(input())
    num_list = [int(input()) for _ in range(n)]
    index = 1
    answer = ''
    stack = []
    for num in num_list:
        if index <= num:
            while index <= num:
                stack.append(index)
                answer += '+\n'
                index += 1
            stack.pop()
            answer += '-\n'
        else:
            if stack[-1] != num:
                print('NO')
                sys.exit(0)
            else:
                stack.pop()
                answer += '-\n'
    print(answer, end='')


main()