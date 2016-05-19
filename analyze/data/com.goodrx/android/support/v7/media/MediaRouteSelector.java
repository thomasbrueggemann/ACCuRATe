package android.support.v7.media;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MediaRouteSelector {
   public static final MediaRouteSelector EMPTY = new MediaRouteSelector(new Bundle(), (List)null);
   private static final String KEY_CONTROL_CATEGORIES = "controlCategories";
   private final Bundle mBundle;
   private List<String> mControlCategories;

   private MediaRouteSelector(Bundle var1, List<String> var2) {
      this.mBundle = var1;
      this.mControlCategories = var2;
   }

   // $FF: synthetic method
   MediaRouteSelector(Bundle var1, List var2, Object var3) {
      this(var1, var2);
   }

   private void ensureControlCategories() {
      if(this.mControlCategories == null) {
         this.mControlCategories = this.mBundle.getStringArrayList("controlCategories");
         if(this.mControlCategories == null || this.mControlCategories.isEmpty()) {
            this.mControlCategories = Collections.emptyList();
         }
      }

   }

   public static MediaRouteSelector fromBundle(@Nullable Bundle var0) {
      return var0 != null?new MediaRouteSelector(var0, (List)null):null;
   }

   public Bundle asBundle() {
      return this.mBundle;
   }

   public boolean contains(MediaRouteSelector var1) {
      if(var1 != null) {
         this.ensureControlCategories();
         var1.ensureControlCategories();
         return this.mControlCategories.containsAll(var1.mControlCategories);
      } else {
         return false;
      }
   }

   public boolean equals(Object var1) {
      if(var1 instanceof MediaRouteSelector) {
         MediaRouteSelector var2 = (MediaRouteSelector)var1;
         this.ensureControlCategories();
         var2.ensureControlCategories();
         return this.mControlCategories.equals(var2.mControlCategories);
      } else {
         return false;
      }
   }

   public List<String> getControlCategories() {
      this.ensureControlCategories();
      return this.mControlCategories;
   }

   public boolean hasControlCategory(String var1) {
      if(var1 != null) {
         this.ensureControlCategories();
         int var2 = this.mControlCategories.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            if(((String)this.mControlCategories.get(var3)).equals(var1)) {
               return true;
            }
         }
      }

      return false;
   }

   public int hashCode() {
      this.ensureControlCategories();
      return this.mControlCategories.hashCode();
   }

   public boolean isEmpty() {
      this.ensureControlCategories();
      return this.mControlCategories.isEmpty();
   }

   public boolean isValid() {
      this.ensureControlCategories();
      return !this.mControlCategories.contains((Object)null);
   }

   public boolean matchesControlFilters(List<IntentFilter> var1) {
      if(var1 != null) {
         this.ensureControlCategories();
         int var2 = this.mControlCategories.size();
         if(var2 != 0) {
            int var3 = var1.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               IntentFilter var5 = (IntentFilter)var1.get(var4);
               if(var5 != null) {
                  for(int var6 = 0; var6 < var2; ++var6) {
                     if(var5.hasCategory((String)this.mControlCategories.get(var6))) {
                        return true;
                     }
                  }
               }
            }
         }
      }

      return false;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediaRouteSelector{ ");
      var1.append("controlCategories=").append(Arrays.toString(this.getControlCategories().toArray()));
      var1.append(" }");
      return var1.toString();
   }

   public static final class Builder {
      private ArrayList<String> mControlCategories;

      public Builder() {
      }

      public Builder(@NonNull MediaRouteSelector var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("selector must not be null");
         } else {
            var1.ensureControlCategories();
            if(!var1.mControlCategories.isEmpty()) {
               this.mControlCategories = new ArrayList(var1.mControlCategories);
            }

         }
      }

      @NonNull
      public MediaRouteSelector.Builder addControlCategories(@NonNull Collection<String> var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("categories must not be null");
         } else {
            if(!var1.isEmpty()) {
               Iterator var2 = var1.iterator();

               while(var2.hasNext()) {
                  this.addControlCategory((String)var2.next());
               }
            }

            return this;
         }
      }

      @NonNull
      public MediaRouteSelector.Builder addControlCategory(@NonNull String var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("category must not be null");
         } else {
            if(this.mControlCategories == null) {
               this.mControlCategories = new ArrayList();
            }

            if(!this.mControlCategories.contains(var1)) {
               this.mControlCategories.add(var1);
            }

            return this;
         }
      }

      @NonNull
      public MediaRouteSelector.Builder addSelector(@NonNull MediaRouteSelector var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("selector must not be null");
         } else {
            this.addControlCategories(var1.getControlCategories());
            return this;
         }
      }

      @NonNull
      public MediaRouteSelector build() {
         if(this.mControlCategories == null) {
            return MediaRouteSelector.EMPTY;
         } else {
            Bundle var1 = new Bundle();
            var1.putStringArrayList("controlCategories", this.mControlCategories);
            return new MediaRouteSelector(var1, this.mControlCategories);
         }
      }
   }
}
