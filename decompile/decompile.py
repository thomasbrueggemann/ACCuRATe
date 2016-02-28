import os, sys, subprocess

# MAIN
if __name__ == "__main__":

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
				print f

				pckName = f.replace(".apk", "")

				# create output directory
				directory = "./output/" + pckName
				if not os.path.exists(directory):
					os.makedirs(directory)

				# step 1
				subprocess.call("dex2jar/d2j-dex2jar.sh -o output/" + pckName + ".jar " + f, shell=True)

				# step 2
				s = "java -jar fernflower/fernflower.jar -hes=0 -hdc=0 -dgs=1 -ren=1 output/" + pckName + ".jar " + directory
				print s
				subprocess.call(s)

    			# call decompile script
				#subprocess.call("./decompileAPK.sh -o " + directory + " " + downloadPath + f, shell=True)
