import timeit

times = []

for ol in range(0,1000):
    start = timeit.default_timer()
    num = []

    text = open('nums.txt','r')
    for line in text:
        num.append(int(line))

    num1 = list(num)
    num2 = list(num)

    'Insertion Sort'
    for index in range(1,len(num)):

         currentvalue = num[index]
         position = index

         while position>0 and num[position-1]>currentvalue:
             num[position]=num[position-1]
             position = position-1

         num[position]=currentvalue

    'Quick Sort'
    def quickSort(alist):
       quickSortHelper(alist,0,len(alist)-1)

    def quickSortHelper(alist,first,last):
       if first<last:

           splitpoint = partition(alist,first,last)

           quickSortHelper(alist,first,splitpoint-1)
           quickSortHelper(alist,splitpoint+1,last)


    def partition(alist,first,last):
       pivotvalue = alist[first]

       leftmark = first+1
       rightmark = last

       done = False
       while not done:

           while leftmark <= rightmark and alist[leftmark] <= pivotvalue:
               leftmark = leftmark + 1

           while alist[rightmark] >= pivotvalue and rightmark >= leftmark:
               rightmark = rightmark -1

           if rightmark < leftmark:
               done = True
           else:
               temp = alist[leftmark]
               alist[leftmark] = alist[rightmark]
               alist[rightmark] = temp

       temp = alist[first]
       alist[first] = alist[rightmark]
       alist[rightmark] = temp


       return rightmark
    quickSort(num1)

    'Bubble sort'
    for passnum in range(len(num2)-1,0,-1):
            for i in range(passnum):
                if num2[i]>num2[i+1]:
                    temp = num2[i]
                    num2[i] = num2[i+1]
                    num2[i+1] = temp


    stop = timeit.default_timer()
    times.append(stop - start)
    

total = 0
for fe in times:
    total = total + fe
print(total/len(times))

