def main():
    s = input()
    stack = []
    index = 0
    str_len = len(s)
    result = ''
    while index < str_len:
        if s[index] == "<":
            while stack:
                result += stack.pop()
            while s[index] != ">":
                result += s[index]
                index += 1
            result += s[index]
        else:
            if s[index] == " ":
                while stack:
                    result += stack.pop()
                result += " "
            else:
                stack.append(s[index])
        index += 1
    while stack:
        result += stack.pop()
    print(result)


main()