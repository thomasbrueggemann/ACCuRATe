import os, sys, subprocess

# MAIN
if __name__ == "__main__":

	pathToScript = os.path.realpath(__file__)
	homePath = "/".join(pathToScript.split("/")[:-1]) + "/"


	subprocess.call("java -v")
	sys.exit()

	if (len(sys.argv) != 2):
		print "Usage: python decompile.py /path/to/download/folder"
		sys.exit(1);

	# store download path from args
	downloadPath = sys.argv[1]
	if downloadPath[-1:] != "/":
		downloadPath = downloadPath + "/"

	# walk the apks folder
	for subdir, dirs, files in os.walk(downloadPath):
	    for f in files:

	    	# do we have a apk file?
	    	if ".apk" in f:

				pckName = f.replace(".apk", "")

				# create output directory
				directory = homePath + "output/" + pckName + "/"
				if not os.path.exists(directory):
					os.makedirs(directory)

				# step 1
				# extract the jar file from apk
				subprocess.call("dex2jar/d2j-dex2jar.sh -o " + homePath + "output/" + pckName + ".jar " + f, shell=True)

				# step 2
				# decompile the jar file bytecode
				s = "java -jar " + homePath + "fernflower/fernflower.jar -hes=0 -hdc=0 -dgs=1 -ren=1 " + homePath + "output/" + pckName + ".jar " + directory
				print s
				subprocess.call(s, shell=True)

				# step 2b
				# unzip the jar file into folder
				s = "unzip " + homePath + "output" + pckName + "/" + pckName + ".jar"
				subprocess.call(s)

    			# call decompile script
				#subprocess.call("./decompileAPK.sh -o " + directory + " " + downloadPath + f, shell=True)
