package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.internal.class_299;
import com.google.android.gms.internal.class_336;

public final class ExecutionOptions {
   public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
   public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
   public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
   // $FF: renamed from: OA int
   private final int field_3399;
   // $FF: renamed from: Oy java.lang.String
   private final String field_3400;
   // $FF: renamed from: Oz boolean
   private final boolean field_3401;

   public ExecutionOptions(String var1, boolean var2, int var3) {
      this.field_3400 = var1;
      this.field_3401 = var2;
      this.field_3399 = var3;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.ExecutionOptions) void
   public static void method_4305(GoogleApiClient var0, ExecutionOptions var1) {
      class_299 var2 = (class_299)var0.method_941(Drive.field_2928);
      if(var1.method_4310() && !var2.method_2078()) {
         throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
      }
   }

   // $FF: renamed from: ba (int) boolean
   public static boolean method_4306(int var0) {
      switch(var0) {
      case 1:
         return true;
      default:
         return false;
      }
   }

   // $FF: renamed from: bb (int) boolean
   public static boolean method_4307(int var0) {
      switch(var0) {
      case 0:
      case 1:
         return true;
      default:
         return false;
      }
   }

   // $FF: renamed from: bj (java.lang.String) boolean
   public static boolean method_4308(String var0) {
      return var0 != null && !var0.isEmpty() && var0.length() <= 65536;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(var1 != this) {
            ExecutionOptions var3 = (ExecutionOptions)var1;
            if(!class_336.equal(this.field_3400, var3.field_3400) || this.field_3399 != var3.field_3399 || this.field_3401 != var3.field_3401) {
               return false;
            }
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_3400, Integer.valueOf(this.field_3399), Boolean.valueOf(this.field_3401)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: iv () java.lang.String
   public String method_4309() {
      return this.field_3400;
   }

   // $FF: renamed from: iw () boolean
   public boolean method_4310() {
      return this.field_3401;
   }

   // $FF: renamed from: ix () int
   public int method_4311() {
      return this.field_3399;
   }

   public static final class Builder {
      // $FF: renamed from: OA int
      private int field_3231 = 0;
      // $FF: renamed from: Oy java.lang.String
      private String field_3232;
      // $FF: renamed from: Oz boolean
      private boolean field_3233;

      public ExecutionOptions build() {
         if(this.field_3231 == 1 && !this.field_3233) {
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
         } else {
            return new ExecutionOptions(this.field_3232, this.field_3233, this.field_3231);
         }
      }

      public ExecutionOptions.Builder setConflictStrategy(int var1) {
         if(!ExecutionOptions.method_4307(var1)) {
            throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + var1);
         } else {
            this.field_3231 = var1;
            return this;
         }
      }

      public ExecutionOptions.Builder setNotifyOnCompletion(boolean var1) {
         this.field_3233 = var1;
         return this;
      }

      public ExecutionOptions.Builder setTrackingTag(String var1) {
         if(!ExecutionOptions.method_4308(var1)) {
            Object[] var2 = new Object[]{Integer.valueOf(65536)};
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", var2));
         } else {
            this.field_3232 = var1;
            return this;
         }
      }
   }
}
