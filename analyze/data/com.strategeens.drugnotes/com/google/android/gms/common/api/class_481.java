package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// $FF: renamed from: com.google.android.gms.common.api.b
public abstract class class_481 implements Releasable, Result {
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   protected final Status field_1666;
   // $FF: renamed from: JG com.google.android.gms.common.data.DataHolder
   protected final DataHolder field_1667;

   protected class_481(DataHolder var1) {
      this.field_1666 = new Status(var1.getStatusCode());
      this.field_1667 = var1;
   }

   public Status getStatus() {
      return this.field_1666;
   }

   public void release() {
      if(this.field_1667 != null) {
         this.field_1667.close();
      }

   }
}
