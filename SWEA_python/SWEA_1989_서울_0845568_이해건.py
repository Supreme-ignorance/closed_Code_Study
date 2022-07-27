T = int(input())

test_case = [input() for _ in range(T)]

N = 0
    
while N < T:
    
    if test_case[N] == test_case[N][::-1]:
        N = N + 1
        print(f'#{N} 1')
    else:
        N = N + 1
        print(f'#{N} 0')