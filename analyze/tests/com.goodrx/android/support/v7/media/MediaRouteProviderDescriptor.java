package android.support.v7.media;

import android.os.Bundle;
import android.support.v7.media.MediaRouteDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MediaRouteProviderDescriptor {
   private static final String KEY_ROUTES = "routes";
   private final Bundle mBundle;
   private List<MediaRouteDescriptor> mRoutes;

   private MediaRouteProviderDescriptor(Bundle var1, List<MediaRouteDescriptor> var2) {
      this.mBundle = var1;
      this.mRoutes = var2;
   }

   // $FF: synthetic method
   MediaRouteProviderDescriptor(Bundle var1, List var2, Object var3) {
      this(var1, var2);
   }

   private void ensureRoutes() {
      if(this.mRoutes == null) {
         ArrayList var1 = this.mBundle.getParcelableArrayList("routes");
         if(var1 != null && !var1.isEmpty()) {
            int var2 = var1.size();
            this.mRoutes = new ArrayList(var2);

            for(int var3 = 0; var3 < var2; ++var3) {
               this.mRoutes.add(MediaRouteDescriptor.fromBundle((Bundle)var1.get(var3)));
            }
         } else {
            this.mRoutes = Collections.emptyList();
         }
      }

   }

   public static MediaRouteProviderDescriptor fromBundle(Bundle var0) {
      return var0 != null?new MediaRouteProviderDescriptor(var0, (List)null):null;
   }

   public Bundle asBundle() {
      return this.mBundle;
   }

   public List<MediaRouteDescriptor> getRoutes() {
      this.ensureRoutes();
      return this.mRoutes;
   }

   public boolean isValid() {
      this.ensureRoutes();
      int var1 = this.mRoutes.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         MediaRouteDescriptor var3 = (MediaRouteDescriptor)this.mRoutes.get(var2);
         if(var3 == null || !var3.isValid()) {
            return false;
         }
      }

      return true;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediaRouteProviderDescriptor{ ");
      var1.append("routes=").append(Arrays.toString(this.getRoutes().toArray()));
      var1.append(", isValid=").append(this.isValid());
      var1.append(" }");
      return var1.toString();
   }

   public static final class Builder {
      private final Bundle mBundle;
      private ArrayList<MediaRouteDescriptor> mRoutes;

      public Builder() {
         this.mBundle = new Bundle();
      }

      public Builder(MediaRouteProviderDescriptor var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("descriptor must not be null");
         } else {
            this.mBundle = new Bundle(var1.mBundle);
            var1.ensureRoutes();
            if(!var1.mRoutes.isEmpty()) {
               this.mRoutes = new ArrayList(var1.mRoutes);
            }

         }
      }

      public MediaRouteProviderDescriptor.Builder addRoute(MediaRouteDescriptor var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("route must not be null");
         } else {
            if(this.mRoutes == null) {
               this.mRoutes = new ArrayList();
            } else if(this.mRoutes.contains(var1)) {
               throw new IllegalArgumentException("route descriptor already added");
            }

            this.mRoutes.add(var1);
            return this;
         }
      }

      public MediaRouteProviderDescriptor.Builder addRoutes(Collection<MediaRouteDescriptor> var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("routes must not be null");
         } else {
            if(!var1.isEmpty()) {
               Iterator var2 = var1.iterator();

               while(var2.hasNext()) {
                  this.addRoute((MediaRouteDescriptor)var2.next());
               }
            }

            return this;
         }
      }

      public MediaRouteProviderDescriptor build() {
         if(this.mRoutes != null) {
            int var1 = this.mRoutes.size();
            ArrayList var2 = new ArrayList(var1);

            for(int var3 = 0; var3 < var1; ++var3) {
               var2.add(((MediaRouteDescriptor)this.mRoutes.get(var3)).asBundle());
            }

            this.mBundle.putParcelableArrayList("routes", var2);
         }

         return new MediaRouteProviderDescriptor(this.mBundle, this.mRoutes);
      }
   }
}
