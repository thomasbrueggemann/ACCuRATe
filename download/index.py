import os, sys

# MAIN
if __name__ == "__main__":

	if (len(sys.argv) != 2):
		print "Usage: python index.py /path/to/download/folder"
		sys.exit(1);

	# store download path from args
	downloadPath = sys.argv[1]
	if downloadPath[-1:] != "/":
		downloadPath = downloadPath + "/"

	with open("index.txt", "w") as idxfile:
		for subdir, dirs, files in os.walk(downloadPath):
		    for f in files:
		    	if f[0] != ".":
					print f
					idxfile.write(f + "\n")
