package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.class_539;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.f;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.drive.query.c
public class class_859 implements f<String> {
   // $FF: renamed from: a (com.google.android.gms.drive.metadata.b, java.lang.Object) java.lang.String
   public <T> String method_4784(b<T> var1, T var2) {
      Object[] var3 = new Object[]{var1.getName(), var2};
      return String.format("contains(%s,%s)", var3);
   }

   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.Operator, com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.String
   public <T> String method_4785(Operator var1, MetadataField<T> var2, T var3) {
      Object[] var4 = new Object[]{var1.getTag(), var2.getName(), var3};
      return String.format("cmp(%s,%s,%s)", var4);
   }

   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.Operator, java.util.List) java.lang.String
   public String method_4786(Operator var1, List<String> var2) {
      StringBuilder var3 = new StringBuilder(var1.getTag() + "(");
      Iterator var4 = var2.iterator();

      for(String var5 = ""; var4.hasNext(); var5 = ",") {
         String var6 = (String)var4.next();
         var3.append(var5);
         var3.append(var6);
      }

      return var3.append(")").toString();
   }

   // $FF: renamed from: b (com.google.android.gms.drive.metadata.b, java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_925(class_539 var1, Object var2) {
      return this.method_4784(var1, var2);
   }

   // $FF: renamed from: b (com.google.android.gms.drive.query.internal.Operator, com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_926(Operator var1, MetadataField var2, Object var3) {
      return this.method_4785(var1, var2, var3);
   }

   // $FF: renamed from: b (com.google.android.gms.drive.query.internal.Operator, java.util.List) java.lang.Object
   // $FF: synthetic method
   public Object method_927(Operator var1, List var2) {
      return this.method_4786(var1, var2);
   }

   // $FF: renamed from: bq (java.lang.String) java.lang.String
   public String method_4787(String var1) {
      return String.format("not(%s)", new Object[]{var1});
   }

   // $FF: renamed from: c (com.google.android.gms.drive.metadata.MetadataField) java.lang.String
   public String method_4788(MetadataField<?> var1) {
      Object[] var2 = new Object[]{var1.getName()};
      return String.format("fieldOnly(%s)", var2);
   }

   // $FF: renamed from: c (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.String
   public <T> String method_4789(MetadataField<T> var1, T var2) {
      Object[] var3 = new Object[]{var1.getName(), var2};
      return String.format("has(%s,%s)", var3);
   }

   // $FF: renamed from: d (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
   // $FF: synthetic method
   public Object method_928(MetadataField var1) {
      return this.method_4788(var1);
   }

   // $FF: renamed from: d (com.google.android.gms.drive.metadata.MetadataField, java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_929(MetadataField var1, Object var2) {
      return this.method_4789(var1, var2);
   }

   // $FF: renamed from: j (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_930(Object var1) {
      return this.method_4787((String)var1);
   }

   // $FF: renamed from: jc () java.lang.String
   public String method_4790() {
      return "all()";
   }

   // $FF: renamed from: jd () java.lang.Object
   // $FF: synthetic method
   public Object method_931() {
      return this.method_4790();
   }
}
