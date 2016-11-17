import timeit

times = []

for a in range(0,1000):
    start = timeit.default_timer()
    words = []
    small = 0
    med = 0
    large = 0

    with open('test.txt','r') as f:
        for line in f:
            for word in line.split():
               words.append(word)      

    for x in words:
        if(len(x) < 3):
            small+=1
        if(len(x) >= 3 and len(x) <7):
            med+=1
        if(len(x) > 7):
            large+=1

    stop = timeit.default_timer()
    times.append(stop-start)


total = 0
for b in times:
   total = total + b

print("Words with 1-3 characters: ",small)
print("Words with 3-7 characters: ",med)
print("Words with more than 7 characters: ",large)
print(total/1000)
