def solution(board, moves):
    answer = 0
    height = len(board)
    block_count = []
    stack_bucket = []
    moves = [m-1 for m in moves]
    # 각 열 당 높이를 미리 구해둠
    for i in range(height):
        exist = False;
        for j in range(height):
            if board[j][i] == 0:
                continue
            exist = True;
            block_count.append(height-j)
            break
        if not exist:
            block_count.append(0)
    
    # moves 동작을 수행
    # block이 존재하면
    # 1. 스택 Top과 비교해서 같으면 삭제
    # 2. 스택 Top과 비교해서 같지 않으면 push
    # block이 존재하지 않으면 아무동작 X
    for move in moves:
        now_count = block_count[move]
        if now_count != 0:
            if not stack_bucket:
                stack_bucket.append(board[height-now_count][move])
            else:
                if stack_bucket[-1] == board[height-now_count][move]:
                    stack_bucket.pop()
                    answer += 2
                else:
                    stack_bucket.append(board[height-now_count][move])
            block_count[move] -= 1
    return answer