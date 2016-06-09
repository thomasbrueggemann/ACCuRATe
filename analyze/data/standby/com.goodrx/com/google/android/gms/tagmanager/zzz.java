package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.zzar;
import com.google.android.gms.tagmanager.zzas;
import com.google.android.gms.tagmanager.zzat;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class zzz implements zzar {
   private static final Object zzbhz = new Object();
   private static zzz zzbiM;
   private String zzbiN;
   private String zzbiO;
   private zzas zzbiP;
   private zzcd zzbic;

   private zzz(Context var1) {
      this(zzat.zzaZ(var1), new zzcs());
   }

   zzz(zzas var1, zzcd var2) {
      this.zzbiP = var1;
      this.zzbic = var2;
   }

   public static zzar zzaX(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public boolean zzgc(String var1) {
      if(!this.zzbic.zzlw()) {
         zzbg.zzaK("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
         return false;
      } else {
         if(this.zzbiN != null && this.zzbiO != null) {
            try {
               var1 = this.zzbiN + "?" + this.zzbiO + "=" + URLEncoder.encode(var1, "UTF-8");
               zzbg.method_354("Sending wrapped url hit: " + var1);
            } catch (UnsupportedEncodingException var3) {
               zzbg.zzd("Error wrapping URL for testing.", var3);
               return false;
            }
         }

         this.zzbiP.zzgg(var1);
         return true;
      }
   }
}
