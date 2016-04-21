package org.apache.cordova.camera;

import android.media.ExifInterface;
import java.io.IOException;

public class ExifHelper {
    private String aperture = null;
    private String datetime = null;
    private String exposureTime = null;
    private String flash = null;
    private String focalLength = null;
    private String gpsAltitude = null;
    private String gpsAltitudeRef = null;
    private String gpsDateStamp = null;
    private String gpsLatitude = null;
    private String gpsLatitudeRef = null;
    private String gpsLongitude = null;
    private String gpsLongitudeRef = null;
    private String gpsProcessingMethod = null;
    private String gpsTimestamp = null;
    private ExifInterface inFile = null;
    private String iso = null;
    private String make = null;
    private String model = null;
    private String orientation = null;
    private ExifInterface outFile = null;
    private String whiteBalance = null;

    public void createInFile(String var1) throws IOException {
        this.inFile = new ExifInterface(var1);
    }

    public void createOutFile(String var1) throws IOException {
        this.outFile = new ExifInterface(var1);
    }

    public int getOrientation() {
        int var1 = Integer.parseInt(this.orientation);
        if(var1 != 1) {
            if(var1 == 6) {
                return 90;
            }

            if(var1 == 3) {
                return 180;
            }

            if(var1 == 8) {
                return 270;
            }
        }

        return 0;
    }

    public void readExifData() {
        this.aperture = this.inFile.getAttribute("FNumber");
        this.datetime = this.inFile.getAttribute("DateTime");
        this.exposureTime = this.inFile.getAttribute("ExposureTime");
        this.flash = this.inFile.getAttribute("Flash");
        this.focalLength = this.inFile.getAttribute("FocalLength");
        this.gpsAltitude = this.inFile.getAttribute("GPSAltitude");
        this.gpsAltitudeRef = this.inFile.getAttribute("GPSAltitudeRef");
        this.gpsDateStamp = this.inFile.getAttribute("GPSDateStamp");
        this.gpsLatitude = this.inFile.getAttribute("GPSLatitude");
        this.gpsLatitudeRef = this.inFile.getAttribute("GPSLatitudeRef");
        this.gpsLongitude = this.inFile.getAttribute("GPSLongitude");
        this.gpsLongitudeRef = this.inFile.getAttribute("GPSLongitudeRef");
        this.gpsProcessingMethod = this.inFile.getAttribute("GPSProcessingMethod");
        this.gpsTimestamp = this.inFile.getAttribute("GPSTimeStamp");
        this.iso = this.inFile.getAttribute("ISOSpeedRatings");
        this.make = this.inFile.getAttribute("Make");
        this.model = this.inFile.getAttribute("Model");
        this.orientation = this.inFile.getAttribute("Orientation");
        this.whiteBalance = this.inFile.getAttribute("WhiteBalance");
    }

    public void resetOrientation() {
        this.orientation = "1";
    }

    public void writeExifData() throws IOException {
        if(this.outFile != null) {
            if(this.aperture != null) {
                this.outFile.setAttribute("FNumber", this.aperture);
            }

            if(this.datetime != null) {
                this.outFile.setAttribute("DateTime", this.datetime);
            }

            if(this.exposureTime != null) {
                this.outFile.setAttribute("ExposureTime", this.exposureTime);
            }

            if(this.flash != null) {
                this.outFile.setAttribute("Flash", this.flash);
            }

            if(this.focalLength != null) {
                this.outFile.setAttribute("FocalLength", this.focalLength);
            }

            if(this.gpsAltitude != null) {
                this.outFile.setAttribute("GPSAltitude", this.gpsAltitude);
            }

            if(this.gpsAltitudeRef != null) {
                this.outFile.setAttribute("GPSAltitudeRef", this.gpsAltitudeRef);
            }

            if(this.gpsDateStamp != null) {
                this.outFile.setAttribute("GPSDateStamp", this.gpsDateStamp);
            }

            if(this.gpsLatitude != null) {
                this.outFile.setAttribute("GPSLatitude", this.gpsLatitude);
            }

            if(this.gpsLatitudeRef != null) {
                this.outFile.setAttribute("GPSLatitudeRef", this.gpsLatitudeRef);
            }

            if(this.gpsLongitude != null) {
                this.outFile.setAttribute("GPSLongitude", this.gpsLongitude);
            }

            if(this.gpsLongitudeRef != null) {
                this.outFile.setAttribute("GPSLongitudeRef", this.gpsLongitudeRef);
            }

            if(this.gpsProcessingMethod != null) {
                this.outFile.setAttribute("GPSProcessingMethod", this.gpsProcessingMethod);
            }

            if(this.gpsTimestamp != null) {
                this.outFile.setAttribute("GPSTimeStamp", this.gpsTimestamp);
            }

            if(this.iso != null) {
                this.outFile.setAttribute("ISOSpeedRatings", this.iso);
            }

            if(this.make != null) {
                this.outFile.setAttribute("Make", this.make);
            }

            if(this.model != null) {
                this.outFile.setAttribute("Model", this.model);
            }

            if(this.orientation != null) {
                this.outFile.setAttribute("Orientation", this.orientation);
            }

            if(this.whiteBalance != null) {
                this.outFile.setAttribute("WhiteBalance", this.whiteBalance);
            }

            this.outFile.saveAttributes();
        }
    }
}
