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
import com.google.android.gms.dynamic.class_155;
import com.google.android.gms.dynamic.f;
import java.util.Iterator;
import java.util.LinkedList;

// $FF: renamed from: com.google.android.gms.dynamic.a
public abstract class class_381<T extends LifecycleDelegate> {
   // $FF: renamed from: LU com.google.android.gms.dynamic.LifecycleDelegate
   private T field_1688;
   // $FF: renamed from: LV android.os.Bundle
   private Bundle field_1689;
   // $FF: renamed from: LW java.util.LinkedList
   private LinkedList<class_381.class_811> field_1690;
   // $FF: renamed from: LX com.google.android.gms.dynamic.f
   private final f<T> field_1691 = new class_155() {
      // $FF: renamed from: a (com.google.android.gms.dynamic.LifecycleDelegate) void
      public void method_868(T var1) {
         class_381.this.field_1688 = var1;
         Iterator var3 = class_381.this.field_1690.iterator();

         while(var3.hasNext()) {
            ((class_381.class_811)var3.next()).method_54(class_381.this.field_1688);
         }

         class_381.this.field_1690.clear();
         class_381.this.field_1689 = null;
      }
   };

   // $FF: renamed from: a (android.os.Bundle, com.google.android.gms.dynamic.a$a) void
   private void method_2429(Bundle var1, class_381.class_811 var2) {
      if(this.field_1688 != null) {
         var2.method_54(this.field_1688);
      } else {
         if(this.field_1690 == null) {
            this.field_1690 = new LinkedList();
         }

         this.field_1690.add(var2);
         if(var1 != null) {
            if(this.field_1689 == null) {
               this.field_1689 = (Bundle)var1.clone();
            } else {
               this.field_1689.putAll(var1);
            }
         }

         this.method_2434(this.field_1691);
      }
   }

   // $FF: renamed from: b (android.widget.FrameLayout) void
   public static void method_2431(FrameLayout var0) {
      final Context var1 = var0.getContext();
      final int var2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var1);
      String var3 = GooglePlayServicesUtil.method_3842(var1, var2);
      String var4 = GooglePlayServicesUtil.method_3843(var1, var2);
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
               var1.startActivity(GooglePlayServicesUtil.method_3840(var1, var2));
            }
         });
      }

   }

   // $FF: renamed from: ca (int) void
   private void method_2432(int var1) {
      while(!this.field_1690.isEmpty() && ((class_381.class_811)this.field_1690.getLast()).getState() >= var1) {
         this.field_1690.removeLast();
      }

   }

   // $FF: renamed from: a (android.widget.FrameLayout) void
   protected void method_2433(FrameLayout var1) {
      method_2431(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
   protected abstract void method_2434(f<T> var1);

   // $FF: renamed from: gC () com.google.android.gms.dynamic.LifecycleDelegate
   public T method_2435() {
      return this.field_1688;
   }

   public void onCreate(final Bundle var1) {
      this.method_2429(var1, new class_381.class_811() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_54(LifecycleDelegate var1x) {
            class_381.this.field_1688.onCreate(var1);
         }

         public int getState() {
            return 1;
         }
      });
   }

   public View onCreateView(final LayoutInflater var1, final ViewGroup var2, final Bundle var3) {
      final FrameLayout var4 = new FrameLayout(var1.getContext());
      this.method_2429(var3, new class_381.class_811() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_54(LifecycleDelegate var1x) {
            var4.removeAllViews();
            var4.addView(class_381.this.field_1688.onCreateView(var1, var2, var3));
         }

         public int getState() {
            return 2;
         }
      });
      if(this.field_1688 == null) {
         this.method_2433(var4);
      }

      return var4;
   }

   public void onDestroy() {
      if(this.field_1688 != null) {
         this.field_1688.onDestroy();
      } else {
         this.method_2432(1);
      }
   }

   public void onDestroyView() {
      if(this.field_1688 != null) {
         this.field_1688.onDestroyView();
      } else {
         this.method_2432(2);
      }
   }

   public void onInflate(final Activity var1, final Bundle var2, final Bundle var3) {
      this.method_2429(var3, new class_381.class_811() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_54(LifecycleDelegate var1x) {
            class_381.this.field_1688.onInflate(var1, var2, var3);
         }

         public int getState() {
            return 0;
         }
      });
   }

   public void onLowMemory() {
      if(this.field_1688 != null) {
         this.field_1688.onLowMemory();
      }

   }

   public void onPause() {
      if(this.field_1688 != null) {
         this.field_1688.onPause();
      } else {
         this.method_2432(5);
      }
   }

   public void onResume() {
      this.method_2429((Bundle)null, new class_381.class_811() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_54(LifecycleDelegate var1) {
            class_381.this.field_1688.onResume();
         }

         public int getState() {
            return 5;
         }
      });
   }

   public void onSaveInstanceState(Bundle var1) {
      if(this.field_1688 != null) {
         this.field_1688.onSaveInstanceState(var1);
      } else if(this.field_1689 != null) {
         var1.putAll(this.field_1689);
         return;
      }

   }

   public void onStart() {
      this.method_2429((Bundle)null, new class_381.class_811() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_54(LifecycleDelegate var1) {
            class_381.this.field_1688.onStart();
         }

         public int getState() {
            return 4;
         }
      });
   }

   public void onStop() {
      if(this.field_1688 != null) {
         this.field_1688.onStop();
      } else {
         this.method_2432(4);
      }
   }

   private interface class_811 {
      // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
      void method_54(LifecycleDelegate var1);

      int getState();
   }
}
