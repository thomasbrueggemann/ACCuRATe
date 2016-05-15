package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.barcode.zza;
import com.google.android.gms.vision.barcode.zzb;
import com.google.android.gms.vision.barcode.zzc;
import com.google.android.gms.vision.barcode.zzd;
import com.google.android.gms.vision.barcode.zze;
import com.google.android.gms.vision.barcode.zzf;
import com.google.android.gms.vision.barcode.zzg;
import com.google.android.gms.vision.barcode.zzh;
import com.google.android.gms.vision.barcode.zzi;
import com.google.android.gms.vision.barcode.zzj;
import com.google.android.gms.vision.barcode.zzk;
import com.google.android.gms.vision.barcode.zzl;
import com.google.android.gms.vision.barcode.zzm;

public class Barcode implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   public Barcode.CalendarEvent calendarEvent;
   public Barcode.ContactInfo contactInfo;
   public Point[] cornerPoints;
   public String displayValue;
   public Barcode.DriverLicense driverLicense;
   public Barcode.Email email;
   public int format;
   public Barcode.GeoPoint geoPoint;
   public Barcode.Phone phone;
   public String rawValue;
   public Barcode.Sms sms;
   public Barcode.UrlBookmark url;
   public int valueFormat;
   final int versionCode;
   public Barcode.WiFi wifi;

   public Barcode() {
      this.versionCode = 1;
   }

   public Barcode(int var1, int var2, String var3, String var4, int var5, Point[] var6, Barcode.Email var7, Barcode.Phone var8, Barcode.Sms var9, Barcode.WiFi var10, Barcode.UrlBookmark var11, Barcode.GeoPoint var12, Barcode.CalendarEvent var13, Barcode.ContactInfo var14, Barcode.DriverLicense var15) {
      this.versionCode = var1;
      this.format = var2;
      this.rawValue = var3;
      this.displayValue = var4;
      this.valueFormat = var5;
      this.cornerPoints = var6;
      this.email = var7;
      this.phone = var8;
      this.sms = var9;
      this.wifi = var10;
      this.url = var11;
      this.geoPoint = var12;
      this.calendarEvent = var13;
      this.contactInfo = var14;
      this.driverLicense = var15;
   }

   public int describeContents() {
      zzb var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb var10000 = CREATOR;
      zzb.zza(this, var1, var2);
   }

   public static class Address implements SafeParcelable {
      public static final zza CREATOR = new zza();
      public String[] addressLines;
      public int type;
      final int versionCode;

      public Address() {
         this.versionCode = 1;
      }

      public Address(int var1, int var2, String[] var3) {
         this.versionCode = var1;
         this.type = var2;
         this.addressLines = var3;
      }

      public int describeContents() {
         zza var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zza var10000 = CREATOR;
         zza.zza(this, var1, var2);
      }
   }

   public static class CalendarDateTime implements SafeParcelable {
      public static final zzc CREATOR = new zzc();
      public int day;
      public int hours;
      public boolean isUtc;
      public int minutes;
      public int month;
      public String rawValue;
      public int seconds;
      final int versionCode;
      public int year;

      public CalendarDateTime() {
         this.versionCode = 1;
      }

      public CalendarDateTime(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, String var9) {
         this.versionCode = var1;
         this.year = var2;
         this.month = var3;
         this.day = var4;
         this.hours = var5;
         this.minutes = var6;
         this.seconds = var7;
         this.isUtc = var8;
         this.rawValue = var9;
      }

      public int describeContents() {
         zzc var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzc var10000 = CREATOR;
         zzc.zza(this, var1, var2);
      }
   }

   public static class CalendarEvent implements SafeParcelable {
      public static final zzd CREATOR = new zzd();
      public String description;
      public Barcode.CalendarDateTime end;
      public String location;
      public String organizer;
      public Barcode.CalendarDateTime start;
      public String status;
      public String summary;
      final int versionCode;

      public CalendarEvent() {
         this.versionCode = 1;
      }

      public CalendarEvent(int var1, String var2, String var3, String var4, String var5, String var6, Barcode.CalendarDateTime var7, Barcode.CalendarDateTime var8) {
         this.versionCode = var1;
         this.summary = var2;
         this.description = var3;
         this.location = var4;
         this.organizer = var5;
         this.status = var6;
         this.start = var7;
         this.end = var8;
      }

      public int describeContents() {
         zzd var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzd var10000 = CREATOR;
         zzd.zza(this, var1, var2);
      }
   }

   public static class ContactInfo implements SafeParcelable {
      public static final zze CREATOR = new zze();
      public Barcode.Address[] addresses;
      public Barcode.Email[] emails;
      public Barcode.PersonName name;
      public String organization;
      public Barcode.Phone[] phones;
      public String title;
      public String[] urls;
      final int versionCode;

      public ContactInfo() {
         this.versionCode = 1;
      }

      public ContactInfo(int var1, Barcode.PersonName var2, String var3, String var4, Barcode.Phone[] var5, Barcode.Email[] var6, String[] var7, Barcode.Address[] var8) {
         this.versionCode = var1;
         this.name = var2;
         this.organization = var3;
         this.title = var4;
         this.phones = var5;
         this.emails = var6;
         this.urls = var7;
         this.addresses = var8;
      }

      public int describeContents() {
         zze var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zze var10000 = CREATOR;
         zze.zza(this, var1, var2);
      }
   }

   public static class DriverLicense implements SafeParcelable {
      public static final zzf CREATOR = new zzf();
      public String addressCity;
      public String addressState;
      public String addressStreet;
      public String addressZip;
      public String birthDate;
      public String documentType;
      public String expiryDate;
      public String firstName;
      public String gender;
      public String issueDate;
      public String issuingCountry;
      public String lastName;
      public String licenseNumber;
      public String middleName;
      final int versionCode;

      public DriverLicense() {
         this.versionCode = 1;
      }

      public DriverLicense(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15) {
         this.versionCode = var1;
         this.documentType = var2;
         this.firstName = var3;
         this.middleName = var4;
         this.lastName = var5;
         this.gender = var6;
         this.addressStreet = var7;
         this.addressCity = var8;
         this.addressState = var9;
         this.addressZip = var10;
         this.licenseNumber = var11;
         this.issueDate = var12;
         this.expiryDate = var13;
         this.birthDate = var14;
         this.issuingCountry = var15;
      }

      public int describeContents() {
         zzf var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzf var10000 = CREATOR;
         zzf.zza(this, var1, var2);
      }
   }

   public static class Email implements SafeParcelable {
      public static final zzg CREATOR = new zzg();
      public String address;
      public String body;
      public String subject;
      public int type;
      final int versionCode;

      public Email() {
         this.versionCode = 1;
      }

      public Email(int var1, int var2, String var3, String var4, String var5) {
         this.versionCode = var1;
         this.type = var2;
         this.address = var3;
         this.subject = var4;
         this.body = var5;
      }

      public int describeContents() {
         zzg var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzg var10000 = CREATOR;
         zzg.zza(this, var1, var2);
      }
   }

   public static class GeoPoint implements SafeParcelable {
      public static final zzh CREATOR = new zzh();
      public double lat;
      public double lng;
      final int versionCode;

      public GeoPoint() {
         this.versionCode = 1;
      }

      public GeoPoint(int var1, double var2, double var4) {
         this.versionCode = var1;
         this.lat = var2;
         this.lng = var4;
      }

      public int describeContents() {
         zzh var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzh var10000 = CREATOR;
         zzh.zza(this, var1, var2);
      }
   }

   public static class PersonName implements SafeParcelable {
      public static final zzi CREATOR = new zzi();
      public String first;
      public String formattedName;
      public String last;
      public String middle;
      public String prefix;
      public String pronunciation;
      public String suffix;
      final int versionCode;

      public PersonName() {
         this.versionCode = 1;
      }

      public PersonName(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
         this.versionCode = var1;
         this.formattedName = var2;
         this.pronunciation = var3;
         this.prefix = var4;
         this.first = var5;
         this.middle = var6;
         this.last = var7;
         this.suffix = var8;
      }

      public int describeContents() {
         zzi var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzi var10000 = CREATOR;
         zzi.zza(this, var1, var2);
      }
   }

   public static class Phone implements SafeParcelable {
      public static final zzj CREATOR = new zzj();
      public String number;
      public int type;
      final int versionCode;

      public Phone() {
         this.versionCode = 1;
      }

      public Phone(int var1, int var2, String var3) {
         this.versionCode = var1;
         this.type = var2;
         this.number = var3;
      }

      public int describeContents() {
         zzj var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzj var10000 = CREATOR;
         zzj.zza(this, var1, var2);
      }
   }

   public static class Sms implements SafeParcelable {
      public static final zzk CREATOR = new zzk();
      public String message;
      public String phoneNumber;
      final int versionCode;

      public Sms() {
         this.versionCode = 1;
      }

      public Sms(int var1, String var2, String var3) {
         this.versionCode = var1;
         this.message = var2;
         this.phoneNumber = var3;
      }

      public int describeContents() {
         zzk var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzk var10000 = CREATOR;
         zzk.zza(this, var1, var2);
      }
   }

   public static class UrlBookmark implements SafeParcelable {
      public static final zzl CREATOR = new zzl();
      public String title;
      public String url;
      final int versionCode;

      public UrlBookmark() {
         this.versionCode = 1;
      }

      public UrlBookmark(int var1, String var2, String var3) {
         this.versionCode = var1;
         this.title = var2;
         this.url = var3;
      }

      public int describeContents() {
         zzl var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzl var10000 = CREATOR;
         zzl.zza(this, var1, var2);
      }
   }

   public static class WiFi implements SafeParcelable {
      public static final zzm CREATOR = new zzm();
      public int encryptionType;
      public String password;
      public String ssid;
      final int versionCode;

      public WiFi() {
         this.versionCode = 1;
      }

      public WiFi(int var1, String var2, String var3, int var4) {
         this.versionCode = var1;
         this.ssid = var2;
         this.password = var3;
         this.encryptionType = var4;
      }

      public int describeContents() {
         zzm var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzm var10000 = CREATOR;
         zzm.zza(this, var1, var2);
      }
   }
}
