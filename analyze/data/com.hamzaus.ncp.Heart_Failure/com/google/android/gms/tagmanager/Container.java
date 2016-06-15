package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_467;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_521;
import com.google.android.gms.tagmanager.class_533;
import com.google.android.gms.tagmanager.class_537;
import com.google.android.gms.tagmanager.class_539;
import com.google.android.gms.tagmanager.class_540;
import com.google.android.gms.tagmanager.class_83;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {
   private final String aeq;
   private final DataLayer aer;
   private class_540 aes;
   private Map<String, Container.FunctionCallMacroCallback> aet = new HashMap();
   private Map<String, Container.FunctionCallTagCallback> aeu = new HashMap();
   private volatile long aev;
   private volatile String aew = "";
   private final Context mContext;

   Container(Context var1, DataLayer var2, String var3, long var4, class_51.class_961 var6) {
      this.mContext = var1;
      this.aer = var2;
      this.aeq = var3;
      this.aev = var4;
      this.method_4528(var6.field_879);
      if(var6.field_878 != null) {
         this.method_4531(var6.field_878);
      }

   }

   Container(Context var1, DataLayer var2, String var3, long var4, class_539.class_1301 var6) {
      this.mContext = var1;
      this.aer = var2;
      this.aeq = var3;
      this.aev = var4;
      this.method_4529(var6);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$f) void
   private void method_4528(class_51.class_965 var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         class_539.class_1301 var3;
         try {
            var3 = class_539.method_3041(var1);
         } catch (class_539.class_1305 var4) {
            class_515.method_2916("Not loading resource: " + var1 + " because it is invalid: " + var4.toString());
            return;
         }

         this.method_4529(var3);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.cq$c) void
   private void method_4529(class_539.class_1301 var1) {
      this.aew = var1.getVersion();
      class_83 var2 = this.method_4536(this.aew);
      this.method_4530(new class_540(this.mContext, var1, this.aer, new Container.class_1107(), new Container.class_1106(), var2));
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.cs) void
   private void method_4530(class_540 var1) {
      synchronized(this){}

      try {
         this.aes = var1;
      } finally {
         ;
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$i[]) void
   private void method_4531(class_51.class_960[] var1) {
      ArrayList var2 = new ArrayList();
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.add(var1[var4]);
      }

      this.method_4532().method_3066(var2);
   }

   // $FF: renamed from: li () com.google.android.gms.tagmanager.cs
   private class_540 method_4532() {
      synchronized(this){}

      class_540 var2;
      try {
         var2 = this.aes;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: bF (java.lang.String) com.google.android.gms.tagmanager.Container$FunctionCallMacroCallback
   Container.FunctionCallMacroCallback method_4533(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bG (java.lang.String) com.google.android.gms.tagmanager.Container$FunctionCallTagCallback
   Container.FunctionCallTagCallback method_4534(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bH (java.lang.String) void
   void method_4535(String var1) {
      this.method_4532().method_3062(var1);
   }

   // $FF: renamed from: bI (java.lang.String) com.google.android.gms.tagmanager.ag
   class_83 method_4536(String var1) {
      if(class_521.method_2948().method_2950().equals(class_521.class_1311.agA)) {
         ;
      }

      return new class_533();
   }

   public boolean getBoolean(String var1) {
      class_540 var2 = this.method_4532();
      if(var2 == null) {
         class_515.method_2916("getBoolean called for closed container.");
         return class_537.method_3017().booleanValue();
      } else {
         try {
            boolean var4 = class_537.method_3022((class_52.class_816)var2.method_3064(var1).getObject()).booleanValue();
            return var4;
         } catch (Exception var5) {
            class_515.method_2916("Calling getBoolean() threw an exception: " + var5.getMessage() + " Returning default value.");
            return class_537.method_3017().booleanValue();
         }
      }
   }

   public String getContainerId() {
      return this.aeq;
   }

   public double getDouble(String var1) {
      class_540 var2 = this.method_4532();
      if(var2 == null) {
         class_515.method_2916("getDouble called for closed container.");
         return class_537.method_3016().doubleValue();
      } else {
         try {
            double var4 = class_537.method_3012((class_52.class_816)var2.method_3064(var1).getObject()).doubleValue();
            return var4;
         } catch (Exception var6) {
            class_515.method_2916("Calling getDouble() threw an exception: " + var6.getMessage() + " Returning default value.");
            return class_537.method_3016().doubleValue();
         }
      }
   }

   public long getLastRefreshTime() {
      return this.aev;
   }

   public long getLong(String var1) {
      class_540 var2 = this.method_4532();
      if(var2 == null) {
         class_515.method_2916("getLong called for closed container.");
         return class_537.method_3015().longValue();
      } else {
         try {
            long var4 = class_537.method_3011((class_52.class_816)var2.method_3064(var1).getObject()).longValue();
            return var4;
         } catch (Exception var6) {
            class_515.method_2916("Calling getLong() threw an exception: " + var6.getMessage() + " Returning default value.");
            return class_537.method_3015().longValue();
         }
      }
   }

   public String getString(String var1) {
      class_540 var2 = this.method_4532();
      if(var2 == null) {
         class_515.method_2916("getString called for closed container.");
         return class_537.method_3019();
      } else {
         try {
            String var4 = class_537.method_3009((class_52.class_816)var2.method_3064(var1).getObject());
            return var4;
         } catch (Exception var5) {
            class_515.method_2916("Calling getString() threw an exception: " + var5.getMessage() + " Returning default value.");
            return class_537.method_3019();
         }
      }
   }

   public boolean isDefault() {
      return this.getLastRefreshTime() == 0L;
   }

   // $FF: renamed from: lh () java.lang.String
   String method_4537() {
      return this.aew;
   }

   public void registerFunctionCallMacroCallback(String param1, Container.FunctionCallMacroCallback param2) {
      // $FF: Couldn't be decompiled
   }

   public void registerFunctionCallTagCallback(String param1, Container.FunctionCallTagCallback param2) {
      // $FF: Couldn't be decompiled
   }

   void release() {
      this.aes = null;
   }

   public void unregisterFunctionCallMacroCallback(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void unregisterFunctionCallTagCallback(String param1) {
      // $FF: Couldn't be decompiled
   }

   public interface FunctionCallMacroCallback {
      Object getValue(String var1, Map<String, Object> var2);
   }

   public interface FunctionCallTagCallback {
      void execute(String var1, Map<String, Object> var2);
   }

   private class class_1107 implements class_467.class_1273 {
      private class_1107() {
      }

      // $FF: synthetic method
      class_1107(Object var2) {
         this();
      }

      // $FF: renamed from: b (java.lang.String, java.util.Map) java.lang.Object
      public Object method_867(String var1, Map<String, Object> var2) {
         Container.FunctionCallMacroCallback var3 = Container.this.method_4533(var1);
         return var3 == null?null:var3.getValue(var1, var2);
      }
   }

   private class class_1106 implements class_467.class_1273 {
      private class_1106() {
      }

      // $FF: synthetic method
      class_1106(Object var2) {
         this();
      }

      // $FF: renamed from: b (java.lang.String, java.util.Map) java.lang.Object
      public Object method_867(String var1, Map<String, Object> var2) {
         Container.FunctionCallTagCallback var3 = Container.this.method_4534(var1);
         if(var3 != null) {
            var3.execute(var1, var2);
         }

         return class_537.method_3019();
      }
   }
}
