#!/bin/bash

# loop all apk files in current directory
for FILE in ./*.apk; do

	FOLDER=${FILE/.apk/""}
	FOLDER=$(echo $FOLDER| cut -c 3-100000)
	echo $FOLDER

	# create output folder for decompiled classes
	rm -R "output/$FOLDER"
	mkdir -p "output/$FOLDER"

	# extract .jar from .apk
	dex2jar/d2j-dex2jar.sh -o "output/$FOLDER/$FOLDER.jar" "$FOLDER.apk"

	# decompile jar archive
	java -jar fernflower/fernflower.jar -ren=1 "output/$FOLDER/$FOLDER.jar" "output/$FOLDER/"
done