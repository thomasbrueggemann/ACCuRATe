package com.google.android.gms.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;

// $FF: renamed from: com.google.android.gms.internal.jh
public class class_346 implements OnClickListener {
   // $FF: renamed from: Mx android.support.v4.app.Fragment
   private final Fragment field_1038;
   // $FF: renamed from: My int
   private final int field_1039;
   private final Intent mIntent;
   // $FF: renamed from: nB android.app.Activity
   private final Activity field_1040;

   public class_346(Activity var1, Intent var2, int var3) {
      this.field_1040 = var1;
      this.field_1038 = null;
      this.mIntent = var2;
      this.field_1039 = var3;
   }

   public class_346(Fragment var1, Intent var2, int var3) {
      this.field_1040 = null;
      this.field_1038 = var1;
      this.mIntent = var2;
      this.field_1039 = var3;
   }

   public void onClick(DialogInterface param1, int param2) {
      // $FF: Couldn't be decompiled
   }
}
