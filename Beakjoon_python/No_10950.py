import sys

T = int(sys.stdin.readline())
AB = [list(map(int,sys.stdin.readline().split())) for _ in range(T)]

for i in AB:
    print (i[0]+i[1])