package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class ForwardingRequestListener implements RequestListener {
   private static final String TAG = "ForwardingRequestListener";
   private final List<RequestListener> mRequestListeners;

   public ForwardingRequestListener(Set<RequestListener> var1) {
      this.mRequestListeners = new ArrayList(var1.size());
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         RequestListener var3 = (RequestListener)var2.next();
         this.mRequestListeners.add(var3);
      }

   }

   private void onException(String var1, Throwable var2) {
      FLog.method_398("ForwardingRequestListener", var1, var2);
   }

   public void onProducerEvent(String var1, String var2, String var3) {
      int var4 = this.mRequestListeners.size();

      for(int var5 = 0; var5 < var4; ++var5) {
         RequestListener var6 = (RequestListener)this.mRequestListeners.get(var5);

         try {
            var6.onProducerEvent(var1, var2, var3);
         } catch (Exception var8) {
            this.onException("InternalListener exception in onIntermediateChunkStart", var8);
         }
      }

   }

   public void onProducerFinishWithCancellation(String var1, String var2, @Nullable Map<String, String> var3) {
      int var4 = this.mRequestListeners.size();

      for(int var5 = 0; var5 < var4; ++var5) {
         RequestListener var6 = (RequestListener)this.mRequestListeners.get(var5);

         try {
            var6.onProducerFinishWithCancellation(var1, var2, var3);
         } catch (Exception var8) {
            this.onException("InternalListener exception in onProducerFinishWithCancellation", var8);
         }
      }

   }

   public void onProducerFinishWithFailure(String var1, String var2, Throwable var3, @Nullable Map<String, String> var4) {
      int var5 = this.mRequestListeners.size();

      for(int var6 = 0; var6 < var5; ++var6) {
         RequestListener var7 = (RequestListener)this.mRequestListeners.get(var6);

         try {
            var7.onProducerFinishWithFailure(var1, var2, var3, var4);
         } catch (Exception var9) {
            this.onException("InternalListener exception in onProducerFinishWithFailure", var9);
         }
      }

   }

   public void onProducerFinishWithSuccess(String var1, String var2, @Nullable Map<String, String> var3) {
      int var4 = this.mRequestListeners.size();

      for(int var5 = 0; var5 < var4; ++var5) {
         RequestListener var6 = (RequestListener)this.mRequestListeners.get(var5);

         try {
            var6.onProducerFinishWithSuccess(var1, var2, var3);
         } catch (Exception var8) {
            this.onException("InternalListener exception in onProducerFinishWithSuccess", var8);
         }
      }

   }

   public void onProducerStart(String var1, String var2) {
      int var3 = this.mRequestListeners.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         RequestListener var5 = (RequestListener)this.mRequestListeners.get(var4);

         try {
            var5.onProducerStart(var1, var2);
         } catch (Exception var7) {
            this.onException("InternalListener exception in onProducerStart", var7);
         }
      }

   }

   public void onRequestCancellation(String var1) {
      int var2 = this.mRequestListeners.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         RequestListener var4 = (RequestListener)this.mRequestListeners.get(var3);

         try {
            var4.onRequestCancellation(var1);
         } catch (Exception var6) {
            this.onException("InternalListener exception in onRequestCancellation", var6);
         }
      }

   }

   public void onRequestFailure(ImageRequest var1, String var2, Throwable var3, boolean var4) {
      int var5 = this.mRequestListeners.size();

      for(int var6 = 0; var6 < var5; ++var6) {
         RequestListener var7 = (RequestListener)this.mRequestListeners.get(var6);

         try {
            var7.onRequestFailure(var1, var2, var3, var4);
         } catch (Exception var9) {
            this.onException("InternalListener exception in onRequestFailure", var9);
         }
      }

   }

   public void onRequestStart(ImageRequest var1, Object var2, String var3, boolean var4) {
      int var5 = this.mRequestListeners.size();

      for(int var6 = 0; var6 < var5; ++var6) {
         RequestListener var7 = (RequestListener)this.mRequestListeners.get(var6);

         try {
            var7.onRequestStart(var1, var2, var3, var4);
         } catch (Exception var9) {
            this.onException("InternalListener exception in onRequestStart", var9);
         }
      }

   }

   public void onRequestSuccess(ImageRequest var1, String var2, boolean var3) {
      int var4 = this.mRequestListeners.size();

      for(int var5 = 0; var5 < var4; ++var5) {
         RequestListener var6 = (RequestListener)this.mRequestListeners.get(var5);

         try {
            var6.onRequestSuccess(var1, var2, var3);
         } catch (Exception var8) {
            this.onException("InternalListener exception in onRequestSuccess", var8);
         }
      }

   }

   public boolean requiresExtraMap(String var1) {
      int var2 = this.mRequestListeners.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         if(((RequestListener)this.mRequestListeners.get(var3)).requiresExtraMap(var1)) {
            return true;
         }
      }

      return false;
   }
}
