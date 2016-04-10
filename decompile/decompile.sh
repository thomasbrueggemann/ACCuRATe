#!/bin/bash
clear

INPUT=$1
OUTPUT=$2

# loop all apk files in current directory
for FILE in $INPUT/*.apk; do

	FOLDER=${FILE/.apk/""}
	FOLDER=$(echo $FOLDER| cut -c 3-100000)
	echo $FOLDER

	# create output folder for decompiled classes
	rm -R "$OUTPUT/$FOLDER"
	mkdir -p "$OUTPUT/$FOLDER"

	# extract .jar from .apk
	dex2jar/d2j-dex2jar.sh -o "$OUTPUT/$FOLDER.jar" "$FOLDER.apk"

	# extract resources from apk files
	java -jar apktool/apktool_2.0.3.jar decode -f "$FOLDER.apk" -o "$OUTPUT/$FOLDER/"
	rm -Rf "$OUTPUT/$FOLDER/smali"
	rm "$OUTPUT/$FOLDER/apktool.yml"

	# decompile jar archive
	java -jar fernflower/fernflower.jar -ren=1 "$OUTPUT/$FOLDER.jar" "$OUTPUT/$FOLDER/"
	unzip "$OUTPUT/$FOLDER/$FOLDER.jar" -d "$OUTPUT/$FOLDER/"
	rm "$OUTPUT/$FOLDER.jar" 
	rm "$OUTPUT/$FOLDER/$FOLDER.jar"

	# format the java files to make them human 
	# readable for possible inspections
	for f in $(find "$OUTPUT/$FOLDER/" -name '*.java'); do 
		echo "Format: $f"
		astyle/build/mac/bin/astyle -n -q --style=java -s4 -xc -S -K -j $f
	done
done