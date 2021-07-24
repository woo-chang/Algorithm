def main():
    n = int(input())
    result = 0
    len_num = len(str(n))  # 자릿수 확인
    for i in range(len_num-1):
        sub_num = 9*(10**i)  # 해당 자릿수의 개수
        result += sub_num * (i+1)  # 해당 자릿수 계산
        n -= sub_num  # 계산한 숫자 제거
    result += n * len_num  # 남은 숫자 처리
    print(result)


main()