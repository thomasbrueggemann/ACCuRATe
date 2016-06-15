package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

// $FF: renamed from: com.google.android.gms.drive.events.b
public class class_588 {
   // $FF: renamed from: a (int, com.google.android.gms.drive.DriveId) boolean
   public static boolean method_3316(int var0, DriveId var1) {
      return var1 != null || method_3317(var0);
   }

   // $FF: renamed from: aK (int) boolean
   public static boolean method_3317(int var0) {
      return (6L & (long)(1 << var0)) != 0L;
   }
}
