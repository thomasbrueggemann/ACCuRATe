package com.comscore.measurement;

import com.comscore.measurement.Label;

public class PrivilegedLabel extends Label {
   // $FF: renamed from: a java.lang.Boolean
   private Boolean field_125 = Boolean.valueOf(true);

   public PrivilegedLabel(String var1, String var2, Boolean var3) {
      super(var1, var2, var3);
   }

   public Boolean getPrivileged() {
      return this.field_125;
   }
}
