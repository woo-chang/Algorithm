import sys


def main():
    t = int(input())
    while t > 0:
        t -= 1
        ps = list(sys.stdin.readline().rstrip())
        stack = []
        flag = True
        for p in ps:
            if p == '(':
                stack.append('(')
            else:
                if stack:
                    stack.pop()
                else:
                    flag = False
                    break
        if flag and len(stack) == 0:
            print("YES")
        else:
            print("NO")


main()