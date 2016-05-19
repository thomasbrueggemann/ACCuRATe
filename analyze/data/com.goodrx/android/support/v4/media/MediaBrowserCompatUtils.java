package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import java.util.List;

public class MediaBrowserCompatUtils {
   public static List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> var0, Bundle var1) {
      int var2 = var1.getInt("android.media.browse.extra.PAGE", -1);
      int var3 = var1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      if(var2 == -1 && var3 == -1) {
         return var0;
      } else {
         int var4 = var3 * (var2 - 1);
         int var5 = var4 + var3;
         if(var2 >= 1 && var3 >= 1 && var4 < var0.size()) {
            if(var5 > var0.size()) {
               var5 = var0.size();
            }

            return var0.subList(var4, var5);
         } else {
            return null;
         }
      }
   }

   public static boolean areSameOptions(Bundle var0, Bundle var1) {
      if(var0 != var1) {
         if(var0 == null) {
            if(var1.getInt("android.media.browse.extra.PAGE", -1) != -1 || var1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1) {
               return false;
            }
         } else if(var1 == null) {
            if(var0.getInt("android.media.browse.extra.PAGE", -1) != -1 || var0.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1) {
               return false;
            }
         } else if(var0.getInt("android.media.browse.extra.PAGE", -1) != var1.getInt("android.media.browse.extra.PAGE", -1) || var0.getInt("android.media.browse.extra.PAGE_SIZE", -1) != var1.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
            return false;
         }
      }

      return true;
   }

   public static boolean hasDuplicatedItems(Bundle var0, Bundle var1) {
      int var2;
      if(var0 == null) {
         var2 = -1;
      } else {
         var2 = var0.getInt("android.media.browse.extra.PAGE", -1);
      }

      int var3;
      if(var1 == null) {
         var3 = -1;
      } else {
         var3 = var1.getInt("android.media.browse.extra.PAGE", -1);
      }

      int var4;
      if(var0 == null) {
         var4 = -1;
      } else {
         var4 = var0.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      }

      int var5;
      if(var1 == null) {
         var5 = -1;
      } else {
         var5 = var1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      }

      int var6;
      int var7;
      if(var2 != -1 && var4 != -1) {
         var6 = var4 * (var2 - 1);
         var7 = -1 + var6 + var4;
      } else {
         var6 = 0;
         var7 = Integer.MAX_VALUE;
      }

      int var8;
      int var9;
      if(var3 != -1 && var5 != -1) {
         var8 = var5 * (var3 - 1);
         var9 = -1 + var8 + var5;
      } else {
         var8 = 0;
         var9 = Integer.MAX_VALUE;
      }

      return var6 <= var8 && var8 <= var7 || var6 <= var9 && var9 <= var7;
   }
}
