package com.google.android.gms.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;

// $FF: renamed from: com.google.android.gms.internal.ha
public class class_351 implements OnClickListener {
   // $FF: renamed from: FS android.support.v4.app.Fragment
   private final Fragment field_1516;
   // $FF: renamed from: FT int
   private final int field_1517;
   private final Intent mIntent;
   // $FF: renamed from: oe android.app.Activity
   private final Activity field_1518;

   public class_351(Activity var1, Intent var2, int var3) {
      this.field_1518 = var1;
      this.field_1516 = null;
      this.mIntent = var2;
      this.field_1517 = var3;
   }

   public class_351(Fragment var1, Intent var2, int var3) {
      this.field_1518 = null;
      this.field_1516 = var1;
      this.mIntent = var2;
      this.field_1517 = var3;
   }

   public void onClick(DialogInterface param1, int param2) {
      // $FF: Couldn't be decompiled
   }
}
