#!/usr/bin/python

GOOGLE_LOGIN = GOOGLE_PASSWORD = AUTH_TOKEN = None

import csv, sys, os.path, warnings, time
from pprint import pprint
from Queue import Queue
from threading import Thread
from config import *
from libs.googleplayapi.googleplay import GooglePlayAPI
from libs.googleplayapi.helpers import sizeof_fmt

warnings.filterwarnings("ignore")

if (len(sys.argv) != 3):
	print "Usage: python download.py /path/to/download/folder appId"
	sys.exit(1);

# store download path from args
downloadPath = sys.argv[1]
if downloadPath[-1:] != "/":
	downloadPath = downloadPath + "/"

appId = sys.argv[2]

# Connect
api = GooglePlayAPI(ANDROID_ID)
api.login(GOOGLE_LOGIN, GOOGLE_PASSWORD, AUTH_TOKEN)

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


	# check if file was already downloaded
	filename = downloadPath + appId + ".apk"
	if not os.path.isfile(filename):

		# add to download queue
		download(appId)
