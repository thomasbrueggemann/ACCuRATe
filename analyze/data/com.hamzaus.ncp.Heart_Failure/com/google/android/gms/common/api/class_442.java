package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// $FF: renamed from: com.google.android.gms.common.api.b
public abstract class class_442 implements Releasable, Result {
   // $FF: renamed from: DD com.google.android.gms.common.data.DataHolder
   protected final DataHolder field_2015;
   // $FF: renamed from: yw com.google.android.gms.common.api.Status
   protected final Status field_2016;

   protected class_442(DataHolder var1) {
      this.field_2016 = new Status(var1.getStatusCode());
      this.field_2015 = var1;
   }

   public Status getStatus() {
      return this.field_2016;
   }

   public void release() {
      if(this.field_2015 != null) {
         this.field_2015.close();
      }

   }
}
