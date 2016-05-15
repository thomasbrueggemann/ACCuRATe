package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.Iterator;
import java.util.List;

public class zzc implements zzf<String> {
   // $FF: synthetic method
   public Object zzB(Object var1) {
      return this.zzdh((String)var1);
   }

   public <T> String zza(com.google.android.gms.drive.metadata.zzb<T> var1, T var2) {
      Object[] var3 = new Object[]{var1.getName(), var2};
      return String.format("contains(%s,%s)", var3);
   }

   public <T> String zza(Operator var1, MetadataField<T> var2, T var3) {
      Object[] var4 = new Object[]{var1.getTag(), var2.getName(), var3};
      return String.format("cmp(%s,%s,%s)", var4);
   }

   public String zza(Operator var1, List<String> var2) {
      StringBuilder var3 = new StringBuilder(var1.getTag() + "(");
      Iterator var4 = var2.iterator();

      for(String var5 = ""; var4.hasNext(); var5 = ",") {
         String var6 = (String)var4.next();
         var3.append(var5);
         var3.append(var6);
      }

      return var3.append(")").toString();
   }

   // $FF: synthetic method
   public Object zzb(com.google.android.gms.drive.metadata.zzb var1, Object var2) {
      return this.zza(var1, var2);
   }

   // $FF: synthetic method
   public Object zzb(Operator var1, MetadataField var2, Object var3) {
      return this.zza(var1, var2, var3);
   }

   // $FF: synthetic method
   public Object zzb(Operator var1, List var2) {
      return this.zza(var1, var2);
   }

   public String zzd(MetadataField<?> var1) {
      Object[] var2 = new Object[]{var1.getName()};
      return String.format("fieldOnly(%s)", var2);
   }

   public <T> String zzd(MetadataField<T> var1, T var2) {
      Object[] var3 = new Object[]{var1.getName(), var2};
      return String.format("has(%s,%s)", var3);
   }

   public String zzdh(String var1) {
      return String.format("not(%s)", new Object[]{var1});
   }

   public String zzdi(String var1) {
      return String.format("fullTextSearch(%s)", new Object[]{var1});
   }

   // $FF: synthetic method
   public Object zzdj(String var1) {
      return this.zzdi(var1);
   }

   // $FF: synthetic method
   public Object zze(MetadataField var1) {
      return this.zzd(var1);
   }

   // $FF: synthetic method
   public Object zze(MetadataField var1, Object var2) {
      return this.zzd(var1, var2);
   }

   public String zztN() {
      return "all()";
   }

   public String zztO() {
      return "ownedByMe()";
   }

   // $FF: synthetic method
   public Object zztP() {
      return this.zztO();
   }

   // $FF: synthetic method
   public Object zztQ() {
      return this.zztN();
   }
}
