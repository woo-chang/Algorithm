import sys

my_num = []


def n_to_m(n, m, select, my_pick):
    if select == m:
        for i in range(m):
            if i == m-1:
                sys.stdout.write(str(my_pick[i]))
            else:
                sys.stdout.write(str(my_pick[i]) + " ")
        sys.stdout.write("\n")
        return;

    for i in range(n):
        my_pick[select] = my_num[i]
        n_to_m(n, m, select+1, my_pick)


def main():
    global my_num
    n, m = list(map(int, input().split()))
    my_num = list(map(int, input().split()))
    my_num.sort()
    n_to_m(n, m, 0, [0 for _ in range(m)])


main()