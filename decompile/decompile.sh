#!/bin/bash
clear

# loop all apk files in current directory
for FILE in ./*.apk; do

	FOLDER=${FILE/.apk/""}
	FOLDER=$(echo $FOLDER| cut -c 3-100000)
	echo $FOLDER

	# create output folder for decompiled classes
	rm -R "output/$FOLDER"
	mkdir -p "output/$FOLDER"

	# extract .jar from .apk
	dex2jar/d2j-dex2jar.sh -o "output/$FOLDER.jar" "$FOLDER.apk"

	# extract resources from apk files
	java -jar apktool/apktool_2.0.3.jar decode -f "$FOLDER.apk" -o "output/$FOLDER/"
	rm -Rf "output/$FOLDER/smali"
	rm "output/$FOLDER/apktool.yml"

	# decompile jar archive
	java -jar fernflower/fernflower.jar -ren=1 "output/$FOLDER.jar" "output/$FOLDER/"
	unzip "output/$FOLDER/$FOLDER.jar" -d "output/$FOLDER/"
	rm "output/$FOLDER.jar" 
	rm "output/$FOLDER/$FOLDER.jar"

	# format the java files to make them human 
	# readable for possible inspections
	for f in $(find "output/$FOLDER/" -name '*.java'); do 
		echo "Format: $f"
		astyle/build/mac/bin/astyle -n -q --style=java -s4 -xc -S -K -j $f
	done
done