package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.bx
public final class class_190 implements MediationAdRequest {
   // $FF: renamed from: d java.util.Date
   private final Date field_604;
   // $FF: renamed from: f java.util.Set
   private final Set<String> field_605;
   // $FF: renamed from: g boolean
   private final boolean field_606;
   // $FF: renamed from: mj int
   private final int field_607;
   // $FF: renamed from: nP int
   private final int field_608;

   public class_190(Date var1, int var2, Set<String> var3, boolean var4, int var5) {
      this.field_604 = var1;
      this.field_607 = var2;
      this.field_605 = var3;
      this.field_606 = var4;
      this.field_608 = var5;
   }

   public Date getBirthday() {
      return this.field_604;
   }

   public int getGender() {
      return this.field_607;
   }

   public Set<String> getKeywords() {
      return this.field_605;
   }

   public boolean isTesting() {
      return this.field_606;
   }

   public int taggedForChildDirectedTreatment() {
      return this.field_608;
   }
}
