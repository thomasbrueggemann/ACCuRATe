package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_55;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_564;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_619;
import com.google.android.gms.tagmanager.class_627;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_639;
import com.google.android.gms.tagmanager.class_640;
import com.google.android.gms.tagmanager.class_88;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {
   private final String aqm;
   private final DataLayer aqn;
   private class_640 aqo;
   private Map<String, Container.FunctionCallMacroCallback> aqp = new HashMap();
   private Map<String, Container.FunctionCallTagCallback> aqq = new HashMap();
   private volatile long aqr;
   private volatile String aqs = "";
   private final Context mContext;

   Container(Context var1, DataLayer var2, String var3, long var4, class_55.class_1260 var6) {
      this.mContext = var1;
      this.aqn = var2;
      this.aqm = var3;
      this.aqr = var4;
      this.method_5802(var6.field_721);
      if(var6.field_720 != null) {
         this.method_5805(var6.field_720);
      }

   }

   Container(Context var1, DataLayer var2, String var3, long var4, class_639.class_1684 var6) {
      this.mContext = var1;
      this.aqn = var2;
      this.aqm = var3;
      this.aqr = var4;
      this.method_5803(var6);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$f) void
   private void method_5802(class_55.class_1269 var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         class_639.class_1684 var3;
         try {
            var3 = class_639.method_3628(var1);
         } catch (class_639.class_1688 var4) {
            class_613.method_3491("Not loading resource: " + var1 + " because it is invalid: " + var4.toString());
            return;
         }

         this.method_5803(var3);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$c) void
   private void method_5803(class_639.class_1684 var1) {
      this.aqs = var1.getVersion();
      class_88 var2 = this.method_5810(this.aqs);
      this.method_5804(new class_640(this.mContext, var1, this.aqn, new Container.class_1442(), new Container.class_1439(), var2));
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.ct) void
   private void method_5804(class_640 var1) {
      synchronized(this){}

      try {
         this.aqo = var1;
      } finally {
         ;
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.c$i[]) void
   private void method_5805(class_55.class_1258[] var1) {
      ArrayList var2 = new ArrayList();
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.add(var1[var4]);
      }

      this.method_5806().method_3653(var2);
   }

   // $FF: renamed from: pk () com.google.android.gms.tagmanager.ct
   private class_640 method_5806() {
      synchronized(this){}

      class_640 var2;
      try {
         var2 = this.aqo;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: cp (java.lang.String) com.google.android.gms.tagmanager.Container$FunctionCallMacroCallback
   Container.FunctionCallMacroCallback method_5807(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cq (java.lang.String) com.google.android.gms.tagmanager.Container$FunctionCallTagCallback
   Container.FunctionCallTagCallback method_5808(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cr (java.lang.String) void
   void method_5809(String var1) {
      this.method_5806().method_3652(var1);
   }

   // $FF: renamed from: cs (java.lang.String) com.google.android.gms.tagmanager.ag
   class_88 method_5810(String var1) {
      if(class_619.method_3526().method_3528().equals(class_619.class_1644.ass)) {
         ;
      }

      return new class_627();
   }

   public boolean getBoolean(String var1) {
      class_640 var2 = this.method_5806();
      if(var2 == null) {
         class_613.method_3491("getBoolean called for closed container.");
         return class_635.method_3590().booleanValue();
      } else {
         try {
            boolean var4 = class_635.method_3583((class_57.class_1084)var2.method_3650(var1).getObject()).booleanValue();
            return var4;
         } catch (Exception var5) {
            class_613.method_3491("Calling getBoolean() threw an exception: " + var5.getMessage() + " Returning default value.");
            return class_635.method_3590().booleanValue();
         }
      }
   }

   public String getContainerId() {
      return this.aqm;
   }

   public double getDouble(String var1) {
      class_640 var2 = this.method_5806();
      if(var2 == null) {
         class_613.method_3491("getDouble called for closed container.");
         return class_635.method_3589().doubleValue();
      } else {
         try {
            double var4 = class_635.method_3582((class_57.class_1084)var2.method_3650(var1).getObject()).doubleValue();
            return var4;
         } catch (Exception var6) {
            class_613.method_3491("Calling getDouble() threw an exception: " + var6.getMessage() + " Returning default value.");
            return class_635.method_3589().doubleValue();
         }
      }
   }

   public long getLastRefreshTime() {
      return this.aqr;
   }

   public long getLong(String var1) {
      class_640 var2 = this.method_5806();
      if(var2 == null) {
         class_613.method_3491("getLong called for closed container.");
         return class_635.method_3588().longValue();
      } else {
         try {
            long var4 = class_635.method_3581((class_57.class_1084)var2.method_3650(var1).getObject()).longValue();
            return var4;
         } catch (Exception var6) {
            class_613.method_3491("Calling getLong() threw an exception: " + var6.getMessage() + " Returning default value.");
            return class_635.method_3588().longValue();
         }
      }
   }

   public String getString(String var1) {
      class_640 var2 = this.method_5806();
      if(var2 == null) {
         class_613.method_3491("getString called for closed container.");
         return class_635.method_3593();
      } else {
         try {
            String var4 = class_635.method_3579((class_57.class_1084)var2.method_3650(var1).getObject());
            return var4;
         } catch (Exception var5) {
            class_613.method_3491("Calling getString() threw an exception: " + var5.getMessage() + " Returning default value.");
            return class_635.method_3593();
         }
      }
   }

   public boolean isDefault() {
      return this.getLastRefreshTime() == 0L;
   }

   // $FF: renamed from: pj () java.lang.String
   String method_5811() {
      return this.aqs;
   }

   public void registerFunctionCallMacroCallback(String param1, Container.FunctionCallMacroCallback param2) {
      // $FF: Couldn't be decompiled
   }

   public void registerFunctionCallTagCallback(String param1, Container.FunctionCallTagCallback param2) {
      // $FF: Couldn't be decompiled
   }

   void release() {
      this.aqo = null;
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

   private class class_1442 implements class_564.class_1657 {
      private class_1442() {
      }

      // $FF: synthetic method
      class_1442(Object var2) {
         this();
      }

      // $FF: renamed from: b (java.lang.String, java.util.Map) java.lang.Object
      public Object method_1065(String var1, Map<String, Object> var2) {
         Container.FunctionCallMacroCallback var3 = Container.this.method_5807(var1);
         return var3 == null?null:var3.getValue(var1, var2);
      }
   }

   private class class_1439 implements class_564.class_1657 {
      private class_1439() {
      }

      // $FF: synthetic method
      class_1439(Object var2) {
         this();
      }

      // $FF: renamed from: b (java.lang.String, java.util.Map) java.lang.Object
      public Object method_1065(String var1, Map<String, Object> var2) {
         Container.FunctionCallTagCallback var3 = Container.this.method_5808(var1);
         if(var3 != null) {
            var3.execute(var1, var2);
         }

         return class_635.method_3593();
      }
   }
}
