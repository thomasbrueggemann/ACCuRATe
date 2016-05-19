package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import com.facebook.drawee.controller.ControllerListener;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ForwardingControllerListener<INFO> implements ControllerListener<INFO> {
   private static final String TAG = "FdingControllerListener";
   private final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);

   public static <INFO> ForwardingControllerListener<INFO> create() {
      return new ForwardingControllerListener();
   }

   // $FF: renamed from: of (com.facebook.drawee.controller.ControllerListener) com.facebook.drawee.controller.ForwardingControllerListener
   public static <INFO> ForwardingControllerListener<INFO> method_347(ControllerListener<? super INFO> var0) {
      ForwardingControllerListener var1 = create();
      var1.addListener(var0);
      return var1;
   }

   // $FF: renamed from: of (com.facebook.drawee.controller.ControllerListener, com.facebook.drawee.controller.ControllerListener) com.facebook.drawee.controller.ForwardingControllerListener
   public static <INFO> ForwardingControllerListener<INFO> method_348(ControllerListener<? super INFO> var0, ControllerListener<? super INFO> var1) {
      ForwardingControllerListener var2 = create();
      var2.addListener(var0);
      var2.addListener(var1);
      return var2;
   }

   private void onException(String var1, Throwable var2) {
      synchronized(this){}

      try {
         Log.e("FdingControllerListener", var1, var2);
      } finally {
         ;
      }

   }

   public void addListener(ControllerListener<? super INFO> var1) {
      synchronized(this){}

      try {
         this.mListeners.add(var1);
      } finally {
         ;
      }

   }

   public void clearListeners() {
      synchronized(this){}

      try {
         this.mListeners.clear();
      } finally {
         ;
      }

   }

   public void onFailure(String param1, Throwable param2) {
      // $FF: Couldn't be decompiled
   }

   public void onFinalImageSet(String param1, @Nullable INFO param2, @Nullable Animatable param3) {
      // $FF: Couldn't be decompiled
   }

   public void onIntermediateImageFailed(String var1, Throwable var2) {
      int var3 = this.mListeners.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         ControllerListener var5 = (ControllerListener)this.mListeners.get(var4);

         try {
            var5.onIntermediateImageFailed(var1, var2);
         } catch (Exception var7) {
            this.onException("InternalListener exception in onIntermediateImageFailed", var7);
         }
      }

   }

   public void onIntermediateImageSet(String var1, @Nullable INFO var2) {
      int var3 = this.mListeners.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         ControllerListener var5 = (ControllerListener)this.mListeners.get(var4);

         try {
            var5.onIntermediateImageSet(var1, var2);
         } catch (Exception var7) {
            this.onException("InternalListener exception in onIntermediateImageSet", var7);
         }
      }

   }

   public void onRelease(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void onSubmit(String param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public void removeListener(ControllerListener<? super INFO> var1) {
      synchronized(this){}

      try {
         this.mListeners.remove(var1);
      } finally {
         ;
      }

   }
}
