H, M = map(int, input().split())

if (45 > M):
    M = 60 - (45-M)
    if (H == 0):
        H = 23
    else:
        H -= 1
else:
    M -= 45
print (H, M)