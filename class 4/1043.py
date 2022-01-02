import sys
input = sys.stdin.readline

m = int(input().split()[1])
t = set(map(int, input().split()[1:]))
party_list = []
possible_party = [1 for _ in range(m)]
for _ in range(m):
    party_list.append(set(map(int,input().split()[1:])))
for _ in range(m):
    for i, party in enumerate(party_list):
        if t.intersection(party):
            possible_party[i] = 0
            t = t.union(party)
            
print(sum(possible_party))