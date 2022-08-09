import matplotlib.pyplot as plt
import numpy as np

# List of colors
clr=["red","green","blue","pink","yellow","brown","orange","black","purple","grey","#670056","green","blue","pink","yellow","brown","orange","black","purple","grey","#670056"]
# range of x and y axis on graph
plt.axis([0,1,0,1000])
#opening output file
fl=open("output.txt")
#spliting fist line to get range of width of borde 
rng=fl.readline().split()
#dictionaries to store data from input file
waxs,waxp={},{}
# data to keep on x axis 0 0.01 0.02 ...... 0.99 1.00 
xaxs=list(map(lambda i:i/100,[i for i in range(0,101,1)]))
# itterating from min-with to max-width
for i in range(int(rng[0]),int(rng[1])):
    #storing time value for each with from prob 0 to 1
    yaxs=[]
    rd=True # making while condition true initially 
    while rd:
        rd=fl.readline()#reading each line of output file
        arr=rd.split(" ")#splitting the line-> prob given | width | time taken| success probability to cross
        if len(arr)==4:#storing time corresponding to given probability
            if arr[1] in waxs.keys():
                waxs[arr[1]].append(round(float(arr[2])))
                waxp[arr[1]].append(float(arr[3]))
            else:
                waxs[arr[1]]=[round(float(arr[2]))]
                waxp[arr[1]]=[float(arr[3])]
            #xaxs.append(int(arr[2]))
            # p[arr[0]]=int(arr[2])
            # w[arr[1]]=arr[3]
fl.close()
for i in waxs.keys():#plotting each case(width range) on same graph of time taken
    if(int(rng[0])-int(rng[1])<21):
        plt.plot(xaxs,waxs[i],color=clr[int(i)-int(rng[0])],label=i)
    else:
        plt.plot(xaxs,waxs[i],label=i)
plt.xlabel("Probability(Sensor ON)")
plt.ylabel("Time taken to Cross(seconds)")
plt.legend()
plt.savefig("3blk.png")#saving graph
plt.show()#showing graph
plt.axis([0.85,1,0,1])

for i in waxp.keys():#plotting each case(width range) of probability of success
    if(int(rng[0])-int(rng[1])<21):
        plt.plot(xaxs,waxp[i],color=clr[int(i)-int(rng[0])-1],label=i)
    else:
        plt.plot(xaxs,waxp[i],label=i)

plt.xlabel("Probability(Sensor ON)")
plt.ylabel("Probability(Crossing Border)")
plt.legend()
plt.savefig("3blkp.png")
plt.show()

