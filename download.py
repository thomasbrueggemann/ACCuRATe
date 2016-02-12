#!/usr/bin/python

GOOGLE_LOGIN = GOOGLE_PASSWORD = AUTH_TOKEN = None

import csv, sys, os.path, warnings
from pprint import pprint
from Queue import Queue
from threading import Thread
from config import *
from libs.googleplayapi.googleplay import GooglePlayAPI
from libs.googleplayapi.helpers import sizeof_fmt

warnings.filterwarnings("ignore")

if (len(sys.argv) != 2):
	print "Usage: python download.py /path/to/download/folder"
	sys.exit(1);

# store download path from args
downloadPath = sys.argv[1]
if downloadPath[-1:] != "/":
	downloadPath = downloadPath + "/"

# Connect
api = GooglePlayAPI(ANDROID_ID)
api.login(GOOGLE_LOGIN, GOOGLE_PASSWORD, AUTH_TOKEN)

price = 0.0
free_apps = []
idx = []

# WORKER
class Worker(Thread):
    # Thread executing tasks from a given tasks queue
    def __init__(self, tasks):
        Thread.__init__(self)
        self.tasks = tasks
        self.daemon = True
        self.start()

    def run(self):
        while True:
            func, args, kargs = self.tasks.get()
            try:
                func(*args, **kargs)
            except Exception, e:
                print e
            finally:
                self.tasks.task_done()

# THREAD POOL
class ThreadPool:
    # Pool of threads consuming tasks from a queue
    def __init__(self, num_threads):
        self.tasks = Queue(num_threads)
        for _ in range(num_threads): Worker(self.tasks)

    def add_task(self, func, *args, **kargs):
        # Add a task to the queue
        self.tasks.put((func, args, kargs))

    def wait_completion(self):
        # Wait for completion of all the tasks in the queue
        self.tasks.join()

# DOWNLOAD
def download(packagename):

	# get the version code and the offer type from the app details
	m = api.details(packagename)
	doc = m.docV2
	vc = doc.details.appDetails.versionCode

	if len(doc.offer) > 0:

		ot = doc.offer[0].offerType

		filename = downloadPath + packagename + ".apk"

		# download file
		print "\nDownloading " + packagename + " %s..." % sizeof_fmt(doc.details.appDetails.installationSize),
		data = api.download(packagename, vc, ot)
		open(filename, "wb").write(data)
		idx.append(packagename + ".apk")

# MAIN
if __name__ == "__main__":

	# fill index with names from index.txt
	with open("index.txt", "rb") as idxfile:
		
		for i in idxfile.readlines():
			idx.append(i.replace("\n", ""))

	pool = ThreadPool(1)

	# read the app file
	# columns are:
	# trackId	artworkUrl	averageUserRating	badge	category	contentRating	description	developerEmail	developerId	developerName	developerPrivacy	developerWebsite	fileSize	formattedPrice	inAppPurchase	installs	price	releaseNotes	requiresAndroid	screenshotUrls	screenshotVideoUrls	trackName	trackViewUrl	updated	userRatingCount	userRatingCountDistribution	version
	with open("mhealth_v3i1e28_app12.csv", "rb") as csvfile:
		appreader = csv.reader(csvfile, delimiter='\t', quotechar='"')
		first = True

		# iterate rows in app dataset
		for row in appreader:

			# skip first header row
			if first == True:
				first = False
				continue

			# parse price and only include free apps
			if float(row[16]) == 0.0:
				free_apps.append(row)

				# check if file was already downloaded
				filename = downloadPath + row[0] + ".apk"
				if not os.path.isfile(filename) and not (row[0] + ".apk" in idx):

					# add to download queue
					pool.add_task(download, row[0])
			else:
				price = float(row[16]) + price

	# finished adding tasks to queue
	print len(free_apps), price
	pool.wait_completion()
