def str_append(s, count):
    if count == 1:
        return str(s)
    else:
        return str(s) + ", "


def main():
    input_list = list(map(int, input().split(" ")))
    circle_list = []
    position = - 1
    count = input_list[0]
    answer = '<'
    for i in range(input_list[0]):
        circle_list.append(i+1)
    while count > 0:
        if count > input_list[1]:
            position += input_list[1]
            position = position % count
            answer += str_append(circle_list[position], count)
            del circle_list[position]
            position -= 1
        else:
            dis = input_list[1] % count
            position += dis
            position = position % count
            answer += str_append(circle_list[position], count)
            del circle_list[position]
            position -= 1
        count -= 1
    answer += '>'
    print(answer)


main()