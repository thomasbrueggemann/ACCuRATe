package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zzf;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
   private final zzf<T> zzavA = new zzf() {
      public void zza(T var1) {
         zza.this.zzavx = var1;
         Iterator var3 = zza.this.zzavz.iterator();

         while(var3.hasNext()) {
            ((zza.zza)var3.next()).zzb(zza.this.zzavx);
         }

         zza.this.zzavz.clear();
         zza.this.zzavy = null;
      }
   };
   private T zzavx;
   private Bundle zzavy;
   private LinkedList<zza.zza> zzavz;

   private void zza(Bundle var1, zza.zza var2) {
      if(this.zzavx != null) {
         var2.zzb(this.zzavx);
      } else {
         if(this.zzavz == null) {
            this.zzavz = new LinkedList();
         }

         this.zzavz.add(var2);
         if(var1 != null) {
            if(this.zzavy == null) {
               this.zzavy = (Bundle)var1.clone();
            } else {
               this.zzavy.putAll(var1);
            }
         }

         this.zza(this.zzavA);
      }
   }

   public static void zzb(FrameLayout var0) {
      final Context var1 = var0.getContext();
      final int var2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var1);
      String var3 = com.google.android.gms.common.internal.zzg.zzc(var1, var2, GooglePlayServicesUtil.zzao(var1));
      String var4 = com.google.android.gms.common.internal.zzg.zzh(var1, var2);
      LinearLayout var5 = new LinearLayout(var0.getContext());
      var5.setOrientation(1);
      var5.setLayoutParams(new LayoutParams(-2, -2));
      var0.addView(var5);
      TextView var6 = new TextView(var0.getContext());
      var6.setLayoutParams(new LayoutParams(-2, -2));
      var6.setText(var3);
      var5.addView(var6);
      if(var4 != null) {
         Button var7 = new Button(var1);
         var7.setLayoutParams(new LayoutParams(-2, -2));
         var7.setText(var4);
         var5.addView(var7);
         var7.setOnClickListener(new OnClickListener() {
            public void onClick(View var1x) {
               var1.startActivity(GooglePlayServicesUtil.zzbv(var2));
            }
         });
      }

   }

   private void zzeJ(int var1) {
      while(!this.zzavz.isEmpty() && ((zza.zza)this.zzavz.getLast()).getState() >= var1) {
         this.zzavz.removeLast();
      }

   }

   public void onCreate(final Bundle var1) {
      this.zza(var1, new zza.zza() {
         public int getState() {
            return 1;
         }

         public void zzb(LifecycleDelegate var1x) {
            zza.this.zzavx.onCreate(var1);
         }
      });
   }

   public View onCreateView(final LayoutInflater var1, final ViewGroup var2, final Bundle var3) {
      final FrameLayout var4 = new FrameLayout(var1.getContext());
      this.zza(var3, new zza.zza() {
         public int getState() {
            return 2;
         }

         public void zzb(LifecycleDelegate var1x) {
            var4.removeAllViews();
            var4.addView(zza.this.zzavx.onCreateView(var1, var2, var3));
         }
      });
      if(this.zzavx == null) {
         this.zza(var4);
      }

      return var4;
   }

   public void onDestroy() {
      if(this.zzavx != null) {
         this.zzavx.onDestroy();
      } else {
         this.zzeJ(1);
      }
   }

   public void onDestroyView() {
      if(this.zzavx != null) {
         this.zzavx.onDestroyView();
      } else {
         this.zzeJ(2);
      }
   }

   public void onInflate(final Activity var1, final Bundle var2, final Bundle var3) {
      this.zza(var3, new zza.zza() {
         public int getState() {
            return 0;
         }

         public void zzb(LifecycleDelegate var1x) {
            zza.this.zzavx.onInflate(var1, var2, var3);
         }
      });
   }

   public void onLowMemory() {
      if(this.zzavx != null) {
         this.zzavx.onLowMemory();
      }

   }

   public void onPause() {
      if(this.zzavx != null) {
         this.zzavx.onPause();
      } else {
         this.zzeJ(5);
      }
   }

   public void onResume() {
      this.zza((Bundle)null, (zza.zza)(new zza.zza() {
         public int getState() {
            return 5;
         }

         public void zzb(LifecycleDelegate var1) {
            zza.this.zzavx.onResume();
         }
      }));
   }

   public void onSaveInstanceState(Bundle var1) {
      if(this.zzavx != null) {
         this.zzavx.onSaveInstanceState(var1);
      } else if(this.zzavy != null) {
         var1.putAll(this.zzavy);
         return;
      }

   }

   protected void zza(FrameLayout var1) {
      zzb(var1);
   }

   protected abstract void zza(zzf<T> var1);

   public T zztU() {
      return this.zzavx;
   }

   private interface zza {
      int getState();

      void zzb(LifecycleDelegate var1);
   }
}
