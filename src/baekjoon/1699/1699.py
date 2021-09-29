def main():
    n = int(input())
    table = [k for k in range(100001)]
    for i in range(2, n+1):
        j = 1
        while j * j <= i:
            table[i] = min(table[i], table[i - j*j] + 1)
            j += 1
    print(table[n])


main()