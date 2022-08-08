import matplotlib.pyplot as plt
import numpy as np


clr=["red","green","blue","pink","yellow","brown","orange","black","purple","grey","#670056","green","blue","pink","yellow","brown","orange","black","purple","grey","#670056"]
plt.axis([0,1,0,1000])
fl=open("output.txt")
rng=fl.readline().split()

waxs={}
waxp={}
xaxs=list(map(lambda i:i/100,[i for i in range(0,101,1)]))
for i in range(int(rng[0]),int(rng[1])):
    yaxs=[]
    rd="abc"
    while rd:
        rd=fl.readline()
        arr=rd.split(" ")
        if len(arr)==4:
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
for i in waxs.keys():
    if(int(rng[0])-int(rng[1])<21):
        plt.plot(xaxs,waxs[i],color=clr[int(i)-int(rng[0])],label=i)
    else:
        plt.plot(xaxs,waxs[i],label=i)
plt.xlabel("Probability(Sensor ON)")
plt.ylabel("Time taken to Cross(seconds)")
plt.legend()
plt.savefig("3blk.png")
plt.show()
plt.axis([0.85,1,0,1])
for i in waxp.keys():
    if(int(rng[0])-int(rng[1])<21):
        plt.plot(xaxs,waxp[i],color=clr[int(i)-int(rng[0])-1],label=i)
    else:
        plt.plot(xaxs,waxp[i],label=i)

plt.xlabel("Probability(Sensor ON)")
plt.ylabel("Probability(Crossing Border)")
plt.legend()
plt.savefig("3blkp.png")
plt.show()

