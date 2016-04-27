#!/bin/bash

java -Xmx4g -cp soot-trunk.jar:soot-infoflow.jar:soot-infoflow-android.jar:slf4j-api-1.7.5.jar:slf4j-simple-1.7.5.jar:axml-2.0.jar soot.jimple.infoflow.android.TestApps.Test "D:\Callbacks_Button1.apk" /Volumes/Macintosh/Users/thomasbruggemann/Library/Android/sdk/platforms