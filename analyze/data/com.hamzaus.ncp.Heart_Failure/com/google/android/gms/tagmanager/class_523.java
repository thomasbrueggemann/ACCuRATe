package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_129;
import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_637;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_160;
import com.google.android.gms.tagmanager.class_510;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_521;
import com.google.android.gms.tagmanager.class_539;
import com.google.android.gms.tagmanager.class_68;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

// $FF: renamed from: com.google.android.gms.tagmanager.cp
class class_523 implements class_160.class_1198 {
   private final String aeq;
   private bg<class_129.class_1078> agK;
   private final ExecutorService agR;
   private final Context mContext;

   class_523(Context var1, String var2) {
      this.mContext = var1;
      this.aeq = var2;
      this.agR = Executors.newSingleThreadExecutor();
   }

   // $FF: renamed from: a (java.io.ByteArrayOutputStream) com.google.android.gms.tagmanager.cq$c
   private class_539.class_1301 method_2969(ByteArrayOutputStream var1) {
      try {
         class_539.class_1301 var4 = class_510.method_2909(var1.toString("UTF-8"));
         return var4;
      } catch (UnsupportedEncodingException var5) {
         class_515.method_2922("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
         return null;
      } catch (JSONException var6) {
         class_515.method_2919("Resource is a UTF-8 encoded string but doesn\'t contain a JSON container");
         return null;
      }
   }

   // $FF: renamed from: k (byte[]) com.google.android.gms.tagmanager.cq$c
   private class_539.class_1301 method_2970(byte[] var1) {
      try {
         class_539.class_1301 var4 = class_539.method_3041(class_51.class_965.method_1760(var1));
         return var4;
      } catch (class_637 var5) {
         class_515.method_2919("Resource doesn\'t contain a binary container");
         return null;
      } catch (class_539.class_1305 var6) {
         class_515.method_2919("Resource doesn\'t contain a binary container");
         return null;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
   public void method_246(bg<class_129.class_1078> var1) {
      this.agK = var1;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.lf$a) void
   public void method_247(final class_129.class_1078 var1) {
      this.agR.execute(new Runnable() {
         public void run() {
            class_523.this.method_2971(var1);
         }
      });
   }

   // $FF: renamed from: c (com.google.android.gms.internal.lf$a) boolean
   boolean method_2971(class_129.class_1078 var1) {
      File var2 = this.method_2973();

      FileOutputStream var3;
      try {
         var3 = new FileOutputStream(var2);
      } catch (FileNotFoundException var18) {
         class_515.method_2916("Error opening resource file for writing");
         return false;
      }

      try {
         var3.write(class_246.method_1720(var1));
         return true;
      } catch (IOException var19) {
         class_515.method_2919("Error writing resource to disk. Removing resource from disk.");
         var2.delete();
      } finally {
         try {
            var3.close();
         } catch (IOException var17) {
            class_515.method_2919("error closing stream for writing resource to disk");
         }

      }

      return false;
   }

   // $FF: renamed from: dn (int) com.google.android.gms.tagmanager.cq$c
   public class_539.class_1301 method_248(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: lr () void
   public void method_249() {
      this.agR.execute(new Runnable() {
         public void run() {
            class_523.this.method_2972();
         }
      });
   }

   // $FF: renamed from: mg () void
   void method_2972() {
      if(this.agK == null) {
         throw new IllegalStateException("callback must be set before execute");
      } else {
         this.agK.method_355();
         class_515.method_2918("Start loading resource from disk ...");
         if((class_521.method_2948().method_2950() == class_521.class_1311.agz || class_521.method_2948().method_2950() == class_521.class_1311.agA) && this.aeq.equals(class_521.method_2948().getContainerId())) {
            this.agK.method_353(class_68.class_818.agd);
         } else {
            FileInputStream var1;
            try {
               var1 = new FileInputStream(this.method_2973());
            } catch (FileNotFoundException var18) {
               class_515.method_2922("resource not on disk");
               this.agK.method_353(class_68.class_818.agd);
               return;
            }

            try {
               ByteArrayOutputStream var2 = new ByteArrayOutputStream();
               class_539.method_3042(var1, var2);
               this.agK.method_354(class_129.class_1078.method_1731(var2.toByteArray()));
            } catch (IOException var16) {
               class_515.method_2919("error reading resource from disk");
               this.agK.method_353(class_68.class_818.age);
            } finally {
               try {
                  var1.close();
               } catch (IOException var15) {
                  class_515.method_2919("error closing stream for reading resource from disk");
               }

            }

            class_515.method_2918("Load resource from disk finished.");
         }
      }
   }

   // $FF: renamed from: mh () java.io.File
   File method_2973() {
      String var1 = "resource_" + this.aeq;
      return new File(this.mContext.getDir("google_tagmanager", 0), var1);
   }

   public void release() {
      synchronized(this){}

      try {
         this.agR.shutdown();
      } finally {
         ;
      }

   }
}
