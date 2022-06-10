def pos(num):
    if num == 0:
        return [3, 1]
    
    x = (num-1) // 3
    y = (num-1) % 3
    return [x, y]

def distance(start, end):
    return abs(start[0]-end[0]) + abs(start[1]-end[1])
    
def solution(numbers, hand):
    left = [1, 4, 7]
    right = [3, 6, 9]
    left_pos = [3, 0]
    right_pos = [3, 2]
    result = ''
    num_size = len(numbers)
    for i in range(num_size):
        print(left_pos, right_pos)
        if numbers[i] in left:
            result += "L"
            left_pos = pos(numbers[i])
        elif numbers[i] in right:
            result += "R"
            right_pos = pos(numbers[i])
        else:
            num_pos = pos(numbers[i])
            left_dis = distance(left_pos, num_pos)
            right_dis = distance(right_pos, num_pos)
            if left_dis > right_dis:
                result += "R"
                right_pos = num_pos[:]
            elif left_dis < right_dis:
                result += "L"
                left_pos = num_pos[:]
            else:
                if hand[0] == 'l':
                    result += "L"
                    left_pos = pos(numbers[i])
                else:
                    result += "R"
                    right_pos = pos(numbers[i])
                
    return result