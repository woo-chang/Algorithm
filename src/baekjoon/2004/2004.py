def find_two(n):
    count = 0
    pivot = 2
    while pivot <= n:
        count += n // pivot
        pivot *= 2
    return count


def find_five(n):
    count = 0
    pivot = 5
    while pivot <= n:
        count += n // pivot
        pivot *= 5
    return count


def main():
    n, m = map(int, input().split(" "))
    two = 0
    five = 0
    two += find_two(n)
    two -= find_two(n-m)
    two -= find_two(m)
    five += find_five(n)
    five -= find_five(n-m)
    five -= find_five(m)
    print(min(two, five))


main()