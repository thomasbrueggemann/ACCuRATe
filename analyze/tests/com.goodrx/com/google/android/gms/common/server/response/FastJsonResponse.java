package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zza;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class FastJsonResponse {
   private void zza(StringBuilder var1, FastJsonResponse.Field var2, Object var3) {
      if(var2.zzrj() == 11) {
         var1.append(((FastJsonResponse)var2.zzrt().cast(var3)).toString());
      } else if(var2.zzrj() == 7) {
         var1.append("\"");
         var1.append(zznb.zzcU((String)var3));
         var1.append("\"");
      } else {
         var1.append(var3);
      }
   }

   private void zza(StringBuilder var1, FastJsonResponse.Field var2, ArrayList<Object> var3) {
      var1.append("[");
      int var5 = 0;

      for(int var6 = var3.size(); var5 < var6; ++var5) {
         if(var5 > 0) {
            var1.append(",");
         }

         Object var8 = var3.get(var5);
         if(var8 != null) {
            this.zza(var1, var2, var8);
         }
      }

      var1.append("]");
   }

   public String toString() {
      Map var1 = this.zzrl();
      StringBuilder var2 = new StringBuilder(100);
      Iterator var3 = var1.keySet().iterator();

      while(var3.hasNext()) {
         String var6 = (String)var3.next();
         FastJsonResponse.Field var7 = (FastJsonResponse.Field)var1.get(var6);
         if(this.zza(var7)) {
            Object var8 = this.zza(var7, this.zzb(var7));
            if(var2.length() == 0) {
               var2.append("{");
            } else {
               var2.append(",");
            }

            var2.append("\"").append(var6).append("\":");
            if(var8 == null) {
               var2.append("null");
            } else {
               switch(var7.zzrk()) {
               case 8:
                  var2.append("\"").append(zzmo.zzj((byte[])((byte[])var8))).append("\"");
                  break;
               case 9:
                  var2.append("\"").append(zzmo.zzk((byte[])((byte[])var8))).append("\"");
                  break;
               case 10:
                  zznc.zza(var2, (HashMap)var8);
                  break;
               default:
                  if(var7.zzrp()) {
                     this.zza(var2, var7, (ArrayList)var8);
                  } else {
                     this.zza(var2, var7, var8);
                  }
               }
            }
         }
      }

      if(var2.length() > 0) {
         var2.append("}");
      } else {
         var2.append("{}");
      }

      return var2.toString();
   }

   protected <O, I> I zza(FastJsonResponse.Field<I, O> var1, Object var2) {
      if(var1.zzamU != null) {
         var2 = var1.convertBack(var2);
      }

      return var2;
   }

   protected boolean zza(FastJsonResponse.Field var1) {
      return var1.zzrk() == 11?(var1.zzrq()?this.zzcQ(var1.zzrr()):this.zzcP(var1.zzrr())):this.zzcO(var1.zzrr());
   }

   protected Object zzb(FastJsonResponse.Field var1) {
      String var2 = var1.zzrr();
      if(var1.zzrt() != null) {
         boolean var3;
         if(this.zzcN(var1.zzrr()) == null) {
            var3 = true;
         } else {
            var3 = false;
         }

         Object[] var4 = new Object[]{var1.zzrr()};
         zzx.zza(var3, "Concrete field shouldn\'t be value object: %s", var4);
         HashMap var5;
         if(var1.zzrq()) {
            var5 = this.zzrn();
         } else {
            var5 = this.zzrm();
         }

         if(var5 != null) {
            return var5.get(var2);
         } else {
            try {
               String var7 = "get" + Character.toUpperCase(var2.charAt(0)) + var2.substring(1);
               Object var8 = this.getClass().getMethod(var7, new Class[0]).invoke(this, new Object[0]);
               return var8;
            } catch (Exception var9) {
               throw new RuntimeException(var9);
            }
         }
      } else {
         return this.zzcN(var1.zzrr());
      }
   }

   protected abstract Object zzcN(String var1);

   protected abstract boolean zzcO(String var1);

   protected boolean zzcP(String var1) {
      throw new UnsupportedOperationException("Concrete types not supported");
   }

   protected boolean zzcQ(String var1) {
      throw new UnsupportedOperationException("Concrete type arrays not supported");
   }

   public abstract Map<String, FastJsonResponse.Field<?, ?>> zzrl();

   public HashMap<String, Object> zzrm() {
      return null;
   }

   public HashMap<String, Object> zzrn() {
      return null;
   }

   public static class Field<I, O> implements SafeParcelable {
      public static final zza CREATOR = new zza();
      private final int mVersionCode;
      protected final int zzamL;
      protected final boolean zzamM;
      protected final int zzamN;
      protected final boolean zzamO;
      protected final String zzamP;
      protected final int zzamQ;
      protected final Class<? extends FastJsonResponse> zzamR;
      protected final String zzamS;
      private FieldMappingDictionary zzamT;
      private FastJsonResponse.zza<I, O> zzamU;

      Field(int var1, int var2, boolean var3, int var4, boolean var5, String var6, int var7, String var8, ConverterWrapper var9) {
         this.mVersionCode = var1;
         this.zzamL = var2;
         this.zzamM = var3;
         this.zzamN = var4;
         this.zzamO = var5;
         this.zzamP = var6;
         this.zzamQ = var7;
         if(var8 == null) {
            this.zzamR = null;
            this.zzamS = null;
         } else {
            this.zzamR = SafeParcelResponse.class;
            this.zzamS = var8;
         }

         if(var9 == null) {
            this.zzamU = null;
         } else {
            this.zzamU = var9.zzrh();
         }
      }

      protected Field(int var1, boolean var2, int var3, boolean var4, String var5, int var6, Class<? extends FastJsonResponse> var7, FastJsonResponse.zza<I, O> var8) {
         this.mVersionCode = 1;
         this.zzamL = var1;
         this.zzamM = var2;
         this.zzamN = var3;
         this.zzamO = var4;
         this.zzamP = var5;
         this.zzamQ = var6;
         this.zzamR = var7;
         if(var7 == null) {
            this.zzamS = null;
         } else {
            this.zzamS = var7.getCanonicalName();
         }

         this.zzamU = var8;
      }

      public static FastJsonResponse.Field zza(String var0, int var1, FastJsonResponse.zza<?, ?> var2, boolean var3) {
         return new FastJsonResponse.Field(var2.zzrj(), var3, var2.zzrk(), false, var0, var1, (Class)null, var2);
      }

      public static <T extends FastJsonResponse> FastJsonResponse.Field<T, T> zza(String var0, int var1, Class<T> var2) {
         return new FastJsonResponse.Field(11, false, 11, false, var0, var1, var2, (FastJsonResponse.zza)null);
      }

      public static <T extends FastJsonResponse> FastJsonResponse.Field<ArrayList<T>, ArrayList<T>> zzb(String var0, int var1, Class<T> var2) {
         return new FastJsonResponse.Field(11, true, 11, true, var0, var1, var2, (FastJsonResponse.zza)null);
      }

      public static FastJsonResponse.Field<Integer, Integer> zzi(String var0, int var1) {
         return new FastJsonResponse.Field(0, false, 0, false, var0, var1, (Class)null, (FastJsonResponse.zza)null);
      }

      public static FastJsonResponse.Field<Double, Double> zzj(String var0, int var1) {
         return new FastJsonResponse.Field(4, false, 4, false, var0, var1, (Class)null, (FastJsonResponse.zza)null);
      }

      public static FastJsonResponse.Field<Boolean, Boolean> zzk(String var0, int var1) {
         return new FastJsonResponse.Field(6, false, 6, false, var0, var1, (Class)null, (FastJsonResponse.zza)null);
      }

      public static FastJsonResponse.Field<String, String> zzl(String var0, int var1) {
         return new FastJsonResponse.Field(7, false, 7, false, var0, var1, (Class)null, (FastJsonResponse.zza)null);
      }

      public static FastJsonResponse.Field<ArrayList<String>, ArrayList<String>> zzm(String var0, int var1) {
         return new FastJsonResponse.Field(7, true, 7, true, var0, var1, (Class)null, (FastJsonResponse.zza)null);
      }

      public I convertBack(O var1) {
         return this.zzamU.convertBack(var1);
      }

      public int describeContents() {
         zza var10000 = CREATOR;
         return 0;
      }

      public int getVersionCode() {
         return this.mVersionCode;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("Field\n");
         var1.append("            versionCode=").append(this.mVersionCode).append('\n');
         var1.append("                 typeIn=").append(this.zzamL).append('\n');
         var1.append("            typeInArray=").append(this.zzamM).append('\n');
         var1.append("                typeOut=").append(this.zzamN).append('\n');
         var1.append("           typeOutArray=").append(this.zzamO).append('\n');
         var1.append("        outputFieldName=").append(this.zzamP).append('\n');
         var1.append("      safeParcelFieldId=").append(this.zzamQ).append('\n');
         var1.append("       concreteTypeName=").append(this.zzru()).append('\n');
         if(this.zzrt() != null) {
            var1.append("     concreteType.class=").append(this.zzrt().getCanonicalName()).append('\n');
         }

         StringBuilder var11 = var1.append("          converterName=");
         String var12;
         if(this.zzamU == null) {
            var12 = "null";
         } else {
            var12 = this.zzamU.getClass().getCanonicalName();
         }

         var11.append(var12).append('\n');
         return var1.toString();
      }

      public void writeToParcel(Parcel var1, int var2) {
         zza var10000 = CREATOR;
         zza.zza(this, var1, var2);
      }

      public void zza(FieldMappingDictionary var1) {
         this.zzamT = var1;
      }

      public int zzrj() {
         return this.zzamL;
      }

      public int zzrk() {
         return this.zzamN;
      }

      public boolean zzrp() {
         return this.zzamM;
      }

      public boolean zzrq() {
         return this.zzamO;
      }

      public String zzrr() {
         return this.zzamP;
      }

      public int zzrs() {
         return this.zzamQ;
      }

      public Class<? extends FastJsonResponse> zzrt() {
         return this.zzamR;
      }

      String zzru() {
         return this.zzamS == null?null:this.zzamS;
      }

      public boolean zzrv() {
         return this.zzamU != null;
      }

      ConverterWrapper zzrw() {
         return this.zzamU == null?null:ConverterWrapper.zza(this.zzamU);
      }

      public Map<String, FastJsonResponse.Field<?, ?>> zzrx() {
         zzx.zzz(this.zzamS);
         zzx.zzz(this.zzamT);
         return this.zzamT.zzcR(this.zzamS);
      }
   }

   public interface zza<I, O> {
      I convertBack(O var1);

      int zzrj();

      int zzrk();
   }
}
