N = int(input())
word =[]
new = []

for i in range(N):
    n = input()
    word.append(n)
    
word = set(word)
    
for j in word:
    new.append((len(j),j))
        
new = sorted(new)
        
for word_len, word in new:
    print(word)
