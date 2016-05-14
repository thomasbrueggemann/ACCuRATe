#!/bin/bash
clear

if [ "$#" -ne 2 ]; then
	echo "Usage: ./decompile.sh input_path output_path"
	exit
fi

INPUT=$1
OUTPUT=$2

# loop all apk files in current directory
for FILE in $INPUT/*.apk; do

	FOLDER=${FILE/.apk/""}
	START=${#INPUT}
	START=$((START+2))
	FOLDER=$(echo $FOLDER| cut -c ${START}-100000)

	# check if folder exists
	if [ -d "$OUTPUT/$FOLDER" ]; then
		continue
	fi

	echo $FOLDER

	# create output folder for decompiled classes
	#rm -R "$OUTPUT/$FOLDER"
	mkdir -p "$OUTPUT/$FOLDER"

	# extract .jar from .apk
	dex2jar/d2j-dex2jar.sh -o "$OUTPUT/$FOLDER.jar" "$INPUT/$FOLDER.apk"

	# extract resources from apk files
	java -Xms512m -Xmx1024m -jar apktool/apktool_2.0.3.jar decode -f "$INPUT/$FOLDER.apk" -o "$OUTPUT/$FOLDER/"
	rm -Rf "$OUTPUT/$FOLDER/smali"
	rm "$OUTPUT/$FOLDER/apktool.yml"

	# decompile jar archive
	java -Xms512m -Xmx1024m -jar fernflower/fernflower.jar -log=ERROR -dgs=1 -ren=1 "$OUTPUT/$FOLDER.jar" "$OUTPUT/$FOLDER/"
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