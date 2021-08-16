def main():
    n = int(input())
    table = [0] * (n+1)
    table[0] = 1
    table[1] = 1
    for i in range(2, n+1):
        table[i] = table[i-1] + 2 * table[i-2]
        table[i] %= 10007
    print(table[n])


main()