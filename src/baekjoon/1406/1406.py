import sys


def main():
    right_stack = []
    init_str = input()
    left_stack = list(init_str)
    m = int(input())
    for _ in range(m):
        instruction = sys.stdin.readline().rstrip().split(' ')
        if instruction[0] == 'L':
            if left_stack:
                right_stack.append(left_stack.pop())
        elif instruction[0] == 'D':
            if right_stack:
                left_stack.append(right_stack.pop())
        elif instruction[0] == 'B':
            if left_stack:
                left_stack.pop()
        else:
            left_stack.append(instruction[1])
    right_stack.reverse()
    left_stack += right_stack
    print("".join(left_stack))


main()