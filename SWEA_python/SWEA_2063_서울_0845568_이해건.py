N = int(input())    
L = list(map(int, input().split()))

NEW_L = sorted(L)

M = N//2

print(NEW_L[M])