package android.support.v7.media;

import android.os.Bundle;
import android.support.v7.media.MediaRouteSelector;

public final class MediaRouteDiscoveryRequest {
   private static final String KEY_ACTIVE_SCAN = "activeScan";
   private static final String KEY_SELECTOR = "selector";
   private final Bundle mBundle;
   private MediaRouteSelector mSelector;

   private MediaRouteDiscoveryRequest(Bundle var1) {
      this.mBundle = var1;
   }

   public MediaRouteDiscoveryRequest(MediaRouteSelector var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("selector must not be null");
      } else {
         this.mBundle = new Bundle();
         this.mSelector = var1;
         this.mBundle.putBundle("selector", var1.asBundle());
         this.mBundle.putBoolean("activeScan", var2);
      }
   }

   private void ensureSelector() {
      if(this.mSelector == null) {
         this.mSelector = MediaRouteSelector.fromBundle(this.mBundle.getBundle("selector"));
         if(this.mSelector == null) {
            this.mSelector = MediaRouteSelector.EMPTY;
         }
      }

   }

   public static MediaRouteDiscoveryRequest fromBundle(Bundle var0) {
      return var0 != null?new MediaRouteDiscoveryRequest(var0):null;
   }

   public Bundle asBundle() {
      return this.mBundle;
   }

   public boolean equals(Object var1) {
      boolean var2 = var1 instanceof MediaRouteDiscoveryRequest;
      boolean var3 = false;
      if(var2) {
         MediaRouteDiscoveryRequest var4 = (MediaRouteDiscoveryRequest)var1;
         boolean var5 = this.getSelector().equals(var4.getSelector());
         var3 = false;
         if(var5) {
            boolean var6 = this.isActiveScan();
            boolean var7 = var4.isActiveScan();
            var3 = false;
            if(var6 == var7) {
               var3 = true;
            }
         }
      }

      return var3;
   }

   public MediaRouteSelector getSelector() {
      this.ensureSelector();
      return this.mSelector;
   }

   public int hashCode() {
      int var1 = this.getSelector().hashCode();
      byte var2;
      if(this.isActiveScan()) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      return var2 ^ var1;
   }

   public boolean isActiveScan() {
      return this.mBundle.getBoolean("activeScan");
   }

   public boolean isValid() {
      this.ensureSelector();
      return this.mSelector.isValid();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DiscoveryRequest{ selector=").append(this.getSelector());
      var1.append(", activeScan=").append(this.isActiveScan());
      var1.append(", isValid=").append(this.isValid());
      var1.append(" }");
      return var1.toString();
   }
}
