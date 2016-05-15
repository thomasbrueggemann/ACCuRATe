package com.facebook.imagepipeline.request;

import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;

public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements RepeatedPostprocessor {
   private RepeatedPostprocessorRunner mCallback;

   private RepeatedPostprocessorRunner getCallback() {
      synchronized(this){}

      RepeatedPostprocessorRunner var2;
      try {
         var2 = this.mCallback;
      } finally {
         ;
      }

      return var2;
   }

   public void setCallback(RepeatedPostprocessorRunner var1) {
      synchronized(this){}

      try {
         this.mCallback = var1;
      } finally {
         ;
      }

   }

   public void update() {
      RepeatedPostprocessorRunner var1 = this.getCallback();
      if(var1 != null) {
         var1.update();
      }

   }
}
