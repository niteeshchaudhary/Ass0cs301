import subprocess
subprocess.check_call("javac CreateInpFile.java",shell=True)
subprocess.run("javac Ass0.java",shell=True)
subprocess.run("java CreateInpFile",shell=True)
subprocess.run("java Ass0",shell=True)
subprocess.run("python pltgraph.py",shell=True)