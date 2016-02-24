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

				# create output directory
				directory = "./output/" + f
				if not os.path.exists(directory):
					os.makedirs(directory)

				print "./decompileAPK.sh -o " + directory + " " + downloadPath + f

    			# call decompile script
				#subprocess.call("./decompileAPK.sh -o " + directory + " " + downloadPath + f, shell=True)
