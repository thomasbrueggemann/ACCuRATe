#!/usr/bin/python

# Do not remove
GOOGLE_LOGIN = GOOGLE_PASSWORD = AUTH_TOKEN = None

import csv, sys
from pprint import pprint

from libs.googleplayapi.config import *
from libs.googleplayapi.googleplay import GooglePlayAPI
from libs.googleplayapi.helpers import sizeof_fmt

# Connect
api = GooglePlayAPI(ANDROID_ID)
#api.login(GOOGLE_LOGIN, GOOGLE_PASSWORD, AUTH_TOKEN)

price = 0.0
free_apps = []

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
		else:
			price = float(row[16]) + price

print len(free_apps), price
