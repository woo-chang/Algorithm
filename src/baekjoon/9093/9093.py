import sys


def main():
    c = int(input())
    while c > 0:
        result = ''
        c -= 1
        stack = []
        sentence = sys.stdin.readline().rstrip()
        for s in sentence:
            if s == ' ':
                while stack:
                    result += stack.pop()
                result += ' '
            else:
                stack.append(s)
        while stack:
            result += stack.pop()
        print(result)


main()