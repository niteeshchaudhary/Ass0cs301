import matplotlib.pyplot as plt
import numpy as np

w={}
clr=["red","green","blue","pink","yellow","brown","orange","black","purple","grey","#670056","green","blue","pink","yellow","brown","orange","black","purple","grey","#670056"]
plt.axis([0,100,0,1000])
fl=open("output.txt")
rng=fl.readline().split()
xaxs=[i for i in range(0,101,1)]
waxs={}
for i in range(int(rng[0]),int(rng[1])):
    yaxs=[]
    rd="abc"
    while rd:
        rd=fl.readline()
        arr=rd.split(" ")
        if len(arr)==4:
            if arr[1] in waxs.keys():
                waxs[arr[1]].append(round(float(arr[2])))
            else:
                waxs[arr[1]]=[round(float(arr[2]))]
            #xaxs.append(int(arr[2]))
            # p[arr[0]]=int(arr[2])
            # w[arr[1]]=arr[3]
fl.close()
for i in waxs.keys():
    if(int(rng[0])-int(rng[1])<21):
        plt.plot(xaxs,waxs[i],color=clr[int(i)-int(rng[0])-1],label=i)
    else:
        plt.plot(xaxs,waxs[i],label=i)

plt.legend()
plt.savefig("3blk.png")
plt.show()

