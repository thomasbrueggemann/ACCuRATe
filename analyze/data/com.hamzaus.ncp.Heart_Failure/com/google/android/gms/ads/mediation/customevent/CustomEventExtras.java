package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
   // $FF: renamed from: sX java.util.HashMap
   private final HashMap<String, Object> field_3715 = new HashMap();

   public Object getExtra(String var1) {
      return this.field_3715.get(var1);
   }

   public void setExtra(String var1, Object var2) {
      this.field_3715.put(var1, var2);
   }
}
