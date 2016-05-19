package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Collections;
import java.util.List;

public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {
   private final SimpleProgressiveJpegConfig.DynamicValueConfig mDynamicValueConfig;

   public SimpleProgressiveJpegConfig() {
      this(new SimpleProgressiveJpegConfig.DefaultDynamicValueConfig());
   }

   public SimpleProgressiveJpegConfig(SimpleProgressiveJpegConfig.DynamicValueConfig var1) {
      this.mDynamicValueConfig = (SimpleProgressiveJpegConfig.DynamicValueConfig)Preconditions.checkNotNull(var1);
   }

   public int getNextScanNumberToDecode(int var1) {
      List var2 = this.mDynamicValueConfig.getScansToDecode();
      if(var2 != null && !var2.isEmpty()) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if(((Integer)var2.get(var3)).intValue() > var1) {
               return ((Integer)var2.get(var3)).intValue();
            }
         }

         return Integer.MAX_VALUE;
      } else {
         return var1 + 1;
      }
   }

   public QualityInfo getQualityInfo(int var1) {
      boolean var2;
      if(var1 >= this.mDynamicValueConfig.getGoodEnoughScanNumber()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return ImmutableQualityInfo.method_328(var1, var2, false);
   }

   private static class DefaultDynamicValueConfig implements SimpleProgressiveJpegConfig.DynamicValueConfig {
      private DefaultDynamicValueConfig() {
      }

      // $FF: synthetic method
      DefaultDynamicValueConfig(Object var1) {
         this();
      }

      public int getGoodEnoughScanNumber() {
         return 0;
      }

      public List<Integer> getScansToDecode() {
         return Collections.EMPTY_LIST;
      }
   }

   public interface DynamicValueConfig {
      int getGoodEnoughScanNumber();

      List<Integer> getScansToDecode();
   }
}
