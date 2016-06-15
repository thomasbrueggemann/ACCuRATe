package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_716;
import com.google.android.gms.internal.class_717;
import com.google.android.gms.internal.class_723;
import com.google.android.gms.internal.class_724;
import com.google.android.gms.internal.class_725;
import com.google.android.gms.internal.class_726;
import com.google.android.gms.internal.class_734;
import com.google.android.gms.internal.kr;
import com.google.android.gms.internal.ky;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.internal.ky
public class class_731 extends class_726 implements SafeParcelable {
   public static final class_725 CREATOR = new class_725();
   // $FF: renamed from: CK int
   private final int field_3367;
   // $FF: renamed from: NT com.google.android.gms.internal.kv
   private final class_734 field_3368;
   // $FF: renamed from: Oa android.os.Parcel
   private final Parcel field_3369;
   // $FF: renamed from: Ob int
   private final int field_3370;
   // $FF: renamed from: Oc int
   private int field_3371;
   // $FF: renamed from: Od int
   private int field_3372;
   private final String mClassName;

   class_731(int var1, Parcel var2, class_734 var3) {
      this.field_3367 = var1;
      this.field_3369 = (Parcel)class_335.method_2311(var2);
      this.field_3370 = 2;
      this.field_3368 = var3;
      if(this.field_3368 == null) {
         this.mClassName = null;
      } else {
         this.mClassName = this.field_3368.method_4274();
      }

      this.field_3371 = 2;
   }

   private class_731(SafeParcelable var1, class_734 var2, String var3) {
      this.field_3367 = 1;
      this.field_3369 = Parcel.obtain();
      var1.writeToParcel(this.field_3369, 0);
      this.field_3370 = 1;
      this.field_3368 = (class_734)class_335.method_2311(var2);
      this.mClassName = (String)class_335.method_2311(var3);
      this.field_3371 = 2;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.kr) com.google.android.gms.internal.ky
   public static <T extends kr & SafeParcelable> ky method_4247(T var0) {
      String var1 = var0.getClass().getCanonicalName();
      class_734 var2 = method_4253(var0);
      return new class_731((SafeParcelable)var0, var2, var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.kv, com.google.android.gms.internal.kr) void
   private static void method_4248(class_734 var0, class_726 var1) {
      Class var2 = var1.getClass();
      if(!var0.method_4269(var2)) {
         HashMap var3 = var1.method_4230();
         var0.method_4268(var2, var1.method_4230());
         Iterator var4 = var3.keySet().iterator();

         while(var4.hasNext()) {
            class_726.class_1680 var5 = (class_726.class_1680)var3.get((String)var4.next());
            Class var6 = var5.method_5326();
            if(var6 != null) {
               try {
                  method_4248(var0, (class_726)var6.newInstance());
               } catch (InstantiationException var9) {
                  throw new IllegalStateException("Could not instantiate an object of type " + var5.method_5326().getCanonicalName(), var9);
               } catch (IllegalAccessException var10) {
                  throw new IllegalStateException("Could not access object of type " + var5.method_5326().getCanonicalName(), var10);
               }
            }
         }
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, int, java.lang.Object) void
   private void method_4249(StringBuilder var1, int var2, Object var3) {
      switch(var2) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
         var1.append(var3);
         return;
      case 7:
         var1.append("\"").append(class_716.method_4193(var3.toString())).append("\"");
         return;
      case 8:
         var1.append("\"").append(class_723.method_4204((byte[])((byte[])var3))).append("\"");
         return;
      case 9:
         var1.append("\"").append(class_723.method_4205((byte[])((byte[])var3)));
         var1.append("\"");
         return;
      case 10:
         class_717.method_4195(var1, (HashMap)var3);
         return;
      case 11:
         throw new IllegalArgumentException("Method does not accept concrete type.");
      default:
         throw new IllegalArgumentException("Unknown type = " + var2);
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, com.google.android.gms.internal.kr$a, android.os.Parcel, int) void
   private void method_4250(StringBuilder var1, class_726.class_1680<?, ?> var2, Parcel var3, int var4) {
      switch(var2.method_5320()) {
      case 0:
         this.method_4256(var1, var2, this.a(var2, Integer.valueOf(class_705.method_4073(var3, var4))));
         return;
      case 1:
         this.method_4256(var1, var2, this.a(var2, class_705.method_4077(var3, var4)));
         return;
      case 2:
         this.method_4256(var1, var2, this.a(var2, Long.valueOf(class_705.method_4075(var3, var4))));
         return;
      case 3:
         this.method_4256(var1, var2, this.a(var2, Float.valueOf(class_705.method_4078(var3, var4))));
         return;
      case 4:
         this.method_4256(var1, var2, this.a(var2, Double.valueOf(class_705.method_4079(var3, var4))));
         return;
      case 5:
         this.method_4256(var1, var2, this.a(var2, class_705.method_4080(var3, var4)));
         return;
      case 6:
         this.method_4256(var1, var2, this.a(var2, Boolean.valueOf(class_705.method_4069(var3, var4))));
         return;
      case 7:
         this.method_4256(var1, var2, this.a(var2, class_705.method_4081(var3, var4)));
         return;
      case 8:
      case 9:
         this.method_4256(var1, var2, this.a(var2, class_705.method_4084(var3, var4)));
         return;
      case 10:
         this.method_4256(var1, var2, this.a(var2, method_4258(class_705.method_4083(var3, var4))));
         return;
      case 11:
         throw new IllegalArgumentException("Method does not accept concrete type.");
      default:
         throw new IllegalArgumentException("Unknown field out type = " + var2.method_5320());
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.lang.String, com.google.android.gms.internal.kr$a, android.os.Parcel, int) void
   private void method_4251(StringBuilder var1, String var2, class_726.class_1680<?, ?> var3, Parcel var4, int var5) {
      var1.append("\"").append(var2).append("\":");
      if(var3.method_5328()) {
         this.method_4250(var1, var3, var4, var5);
      } else {
         this.method_4255(var1, var3, var4, var5);
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.util.HashMap, android.os.Parcel) void
   private void method_4252(StringBuilder var1, HashMap<String, class_726.class_1680<?, ?>> var2, Parcel var3) {
      HashMap var4 = method_4254(var2);
      var1.append('{');
      int var6 = class_705.method_4059(var3);
      boolean var7 = false;

      while(var3.dataPosition() < var6) {
         int var9 = class_705.method_4058(var3);
         Entry var10 = (Entry)var4.get(Integer.valueOf(class_705.method_4065(var9)));
         if(var10 != null) {
            if(var7) {
               var1.append(",");
            }

            this.method_4251(var1, (String)var10.getKey(), (class_726.class_1680)var10.getValue(), var3, var9);
            var7 = true;
         }
      }

      if(var3.dataPosition() != var6) {
         throw new class_705.class_1425("Overread allowed size end=" + var6, var3);
      } else {
         var1.append('}');
      }
   }

   // $FF: renamed from: b (com.google.android.gms.internal.kr) com.google.android.gms.internal.kv
   private static class_734 method_4253(class_726 var0) {
      class_734 var1 = new class_734(var0.getClass());
      method_4248(var1, var0);
      var1.method_4272();
      var1.method_4271();
      return var1;
   }

   // $FF: renamed from: b (java.util.HashMap) java.util.HashMap
   private static HashMap<Integer, Entry<String, class_726.class_1680<?, ?>>> method_4254(HashMap<String, class_726.class_1680<?, ?>> var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(Integer.valueOf(((class_726.class_1680)var3.getValue()).method_5325()), var3);
      }

      return var1;
   }

   // $FF: renamed from: b (java.lang.StringBuilder, com.google.android.gms.internal.kr$a, android.os.Parcel, int) void
   private void method_4255(StringBuilder var1, class_726.class_1680<?, ?> var2, Parcel var3, int var4) {
      if(!var2.method_5323()) {
         switch(var2.method_5320()) {
         case 0:
            var1.append(class_705.method_4073(var3, var4));
            return;
         case 1:
            var1.append(class_705.method_4077(var3, var4));
            return;
         case 2:
            var1.append(class_705.method_4075(var3, var4));
            return;
         case 3:
            var1.append(class_705.method_4078(var3, var4));
            return;
         case 4:
            var1.append(class_705.method_4079(var3, var4));
            return;
         case 5:
            var1.append(class_705.method_4080(var3, var4));
            return;
         case 6:
            var1.append(class_705.method_4069(var3, var4));
            return;
         case 7:
            String var23 = class_705.method_4081(var3, var4);
            var1.append("\"").append(class_716.method_4193(var23)).append("\"");
            return;
         case 8:
            byte[] var21 = class_705.method_4084(var3, var4);
            var1.append("\"").append(class_723.method_4204(var21)).append("\"");
            return;
         case 9:
            byte[] var18 = class_705.method_4084(var3, var4);
            var1.append("\"").append(class_723.method_4205(var18));
            var1.append("\"");
            return;
         case 10:
            Bundle var6 = class_705.method_4083(var3, var4);
            Set var7 = var6.keySet();
            var7.size();
            var1.append("{");
            Iterator var10 = var7.iterator();

            for(boolean var11 = true; var10.hasNext(); var11 = false) {
               String var13 = (String)var10.next();
               if(!var11) {
                  var1.append(",");
               }

               var1.append("\"").append(var13).append("\"");
               var1.append(":");
               var1.append("\"").append(class_716.method_4193(var6.getString(var13))).append("\"");
            }

            var1.append("}");
            return;
         case 11:
            Parcel var5 = class_705.method_4056(var3, var4);
            var5.setDataPosition(0);
            this.method_4252(var1, var2.method_5330(), var5);
            return;
         default:
            throw new IllegalStateException("Unknown field type out");
         }
      } else {
         var1.append("[");
         label56:
         switch(var2.method_5320()) {
         case 0:
            class_724.method_4209(var1, class_705.method_4087(var3, var4));
            break;
         case 1:
            class_724.method_4211(var1, class_705.method_4089(var3, var4));
            break;
         case 2:
            class_724.method_4210(var1, class_705.method_4088(var3, var4));
            break;
         case 3:
            class_724.method_4208(var1, class_705.method_4090(var3, var4));
            break;
         case 4:
            class_724.method_4207(var1, class_705.method_4091(var3, var4));
            break;
         case 5:
            class_724.method_4211(var1, class_705.method_4092(var3, var4));
            break;
         case 6:
            class_724.method_4213(var1, class_705.method_4086(var3, var4));
            break;
         case 7:
            class_724.method_4212(var1, class_705.method_4053(var3, var4));
            break;
         case 8:
         case 9:
         case 10:
            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
         case 11:
            Parcel[] var33 = class_705.method_4057(var3, var4);
            int var34 = var33.length;
            int var35 = 0;

            while(true) {
               if(var35 >= var34) {
                  break label56;
               }

               if(var35 > 0) {
                  var1.append(",");
               }

               var33[var35].setDataPosition(0);
               this.method_4252(var1, var2.method_5330(), var33[var35]);
               ++var35;
            }
         default:
            throw new IllegalStateException("Unknown field type out.");
         }

         var1.append("]");
      }
   }

   // $FF: renamed from: b (java.lang.StringBuilder, com.google.android.gms.internal.kr$a, java.lang.Object) void
   private void method_4256(StringBuilder var1, class_726.class_1680<?, ?> var2, Object var3) {
      if(var2.method_5322()) {
         this.method_4257(var1, var2, (ArrayList)var3);
      } else {
         this.method_4249(var1, var2.method_5319(), var3);
      }
   }

   // $FF: renamed from: b (java.lang.StringBuilder, com.google.android.gms.internal.kr$a, java.util.ArrayList) void
   private void method_4257(StringBuilder var1, class_726.class_1680<?, ?> var2, ArrayList<?> var3) {
      var1.append("[");
      int var5 = var3.size();

      for(int var6 = 0; var6 < var5; ++var6) {
         if(var6 != 0) {
            var1.append(",");
         }

         this.method_4249(var1, var2.method_5319(), var3.get(var6));
      }

      var1.append("]");
   }

   // $FF: renamed from: g (android.os.Bundle) java.util.HashMap
   public static HashMap<String, String> method_4258(Bundle var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.put(var3, var0.getString(var3));
      }

      return var1;
   }

   // $FF: renamed from: bc (java.lang.String) java.lang.Object
   protected Object method_4226(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   // $FF: renamed from: bd (java.lang.String) boolean
   protected boolean method_4227(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   public int describeContents() {
      class_725 var10000 = CREATOR;
      return 0;
   }

   public int getVersionCode() {
      return this.field_3367;
   }

   // $FF: renamed from: hK () java.util.HashMap
   public HashMap<String, class_726.class_1680<?, ?>> method_4230() {
      return this.field_3368 == null?null:this.field_3368.method_4270(this.mClassName);
   }

   // $FF: renamed from: ic () android.os.Parcel
   public Parcel method_4259() {
      switch(this.field_3371) {
      case 0:
         this.field_3372 = class_704.method_4025(this.field_3369);
         class_704.method_4026(this.field_3369, this.field_3372);
         this.field_3371 = 2;
         break;
      case 1:
         class_704.method_4026(this.field_3369, this.field_3372);
         this.field_3371 = 2;
      }

      return this.field_3369;
   }

   // $FF: renamed from: id () com.google.android.gms.internal.kv
   class_734 method_4260() {
      switch(this.field_3370) {
      case 0:
         return null;
      case 1:
         return this.field_3368;
      case 2:
         return this.field_3368;
      default:
         throw new IllegalStateException("Invalid creation type: " + this.field_3370);
      }
   }

   public String toString() {
      class_335.method_2306(this.field_3368, "Cannot convert to JSON on client side.");
      Parcel var2 = this.method_4259();
      var2.setDataPosition(0);
      StringBuilder var3 = new StringBuilder(100);
      this.method_4252(var3, this.field_3368.method_4270(this.mClassName), var2);
      return var3.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_725 var10000 = CREATOR;
      class_725.method_4218(this, var1, var2);
   }
}
