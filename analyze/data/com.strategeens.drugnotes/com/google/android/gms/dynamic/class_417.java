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
import com.google.android.gms.dynamic.class_196;
import com.google.android.gms.dynamic.f;
import java.util.Iterator;
import java.util.LinkedList;

// $FF: renamed from: com.google.android.gms.dynamic.a
public abstract class class_417<T extends LifecycleDelegate> {
   // $FF: renamed from: Tu com.google.android.gms.dynamic.LifecycleDelegate
   private T field_1290;
   // $FF: renamed from: Tv android.os.Bundle
   private Bundle field_1291;
   // $FF: renamed from: Tw java.util.LinkedList
   private LinkedList<class_417.class_1079> field_1292;
   // $FF: renamed from: Tx com.google.android.gms.dynamic.f
   private final f<T> field_1293 = new class_196() {
      // $FF: renamed from: a (com.google.android.gms.dynamic.LifecycleDelegate) void
      public void method_1066(T var1) {
         class_417.this.field_1290 = var1;
         Iterator var3 = class_417.this.field_1292.iterator();

         while(var3.hasNext()) {
            ((class_417.class_1079)var3.next()).method_67(class_417.this.field_1290);
         }

         class_417.this.field_1292.clear();
         class_417.this.field_1291 = null;
      }
   };

   // $FF: renamed from: a (android.os.Bundle, com.google.android.gms.dynamic.a$a) void
   private void method_2756(Bundle var1, class_417.class_1079 var2) {
      if(this.field_1290 != null) {
         var2.method_67(this.field_1290);
      } else {
         if(this.field_1292 == null) {
            this.field_1292 = new LinkedList();
         }

         this.field_1292.add(var2);
         if(var1 != null) {
            if(this.field_1291 == null) {
               this.field_1291 = (Bundle)var1.clone();
            } else {
               this.field_1291.putAll(var1);
            }
         }

         this.method_2761(this.field_1293);
      }
   }

   // $FF: renamed from: b (android.widget.FrameLayout) void
   public static void method_2758(FrameLayout var0) {
      final Context var1 = var0.getContext();
      final int var2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var1);
      String var3 = GooglePlayServicesUtil.method_4803(var1, var2);
      String var4 = GooglePlayServicesUtil.method_4808(var1, var2);
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
               var1.startActivity(GooglePlayServicesUtil.method_4801(var2));
            }
         });
      }

   }

   // $FF: renamed from: cG (int) void
   private void method_2759(int var1) {
      while(!this.field_1292.isEmpty() && ((class_417.class_1079)this.field_1292.getLast()).getState() >= var1) {
         this.field_1292.removeLast();
      }

   }

   // $FF: renamed from: a (android.widget.FrameLayout) void
   protected void method_2760(FrameLayout var1) {
      method_2758(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
   protected abstract void method_2761(f<T> var1);

   // $FF: renamed from: je () com.google.android.gms.dynamic.LifecycleDelegate
   public T method_2762() {
      return this.field_1290;
   }

   public void onCreate(final Bundle var1) {
      this.method_2756(var1, new class_417.class_1079() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_67(LifecycleDelegate var1x) {
            class_417.this.field_1290.onCreate(var1);
         }

         public int getState() {
            return 1;
         }
      });
   }

   public View onCreateView(final LayoutInflater var1, final ViewGroup var2, final Bundle var3) {
      final FrameLayout var4 = new FrameLayout(var1.getContext());
      this.method_2756(var3, new class_417.class_1079() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_67(LifecycleDelegate var1x) {
            var4.removeAllViews();
            var4.addView(class_417.this.field_1290.onCreateView(var1, var2, var3));
         }

         public int getState() {
            return 2;
         }
      });
      if(this.field_1290 == null) {
         this.method_2760(var4);
      }

      return var4;
   }

   public void onDestroy() {
      if(this.field_1290 != null) {
         this.field_1290.onDestroy();
      } else {
         this.method_2759(1);
      }
   }

   public void onDestroyView() {
      if(this.field_1290 != null) {
         this.field_1290.onDestroyView();
      } else {
         this.method_2759(2);
      }
   }

   public void onInflate(final Activity var1, final Bundle var2, final Bundle var3) {
      this.method_2756(var3, new class_417.class_1079() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_67(LifecycleDelegate var1x) {
            class_417.this.field_1290.onInflate(var1, var2, var3);
         }

         public int getState() {
            return 0;
         }
      });
   }

   public void onLowMemory() {
      if(this.field_1290 != null) {
         this.field_1290.onLowMemory();
      }

   }

   public void onPause() {
      if(this.field_1290 != null) {
         this.field_1290.onPause();
      } else {
         this.method_2759(5);
      }
   }

   public void onResume() {
      this.method_2756((Bundle)null, new class_417.class_1079() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_67(LifecycleDelegate var1) {
            class_417.this.field_1290.onResume();
         }

         public int getState() {
            return 5;
         }
      });
   }

   public void onSaveInstanceState(Bundle var1) {
      if(this.field_1290 != null) {
         this.field_1290.onSaveInstanceState(var1);
      } else if(this.field_1291 != null) {
         var1.putAll(this.field_1291);
         return;
      }

   }

   public void onStart() {
      this.method_2756((Bundle)null, new class_417.class_1079() {
         // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
         public void method_67(LifecycleDelegate var1) {
            class_417.this.field_1290.onStart();
         }

         public int getState() {
            return 4;
         }
      });
   }

   public void onStop() {
      if(this.field_1290 != null) {
         this.field_1290.onStop();
      } else {
         this.method_2759(4);
      }
   }

   private interface class_1079 {
      // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
      void method_67(LifecycleDelegate var1);

      int getState();
   }
}
