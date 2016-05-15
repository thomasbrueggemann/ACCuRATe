package com.facebook.imagepipeline.request;

import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;

public interface RepeatedPostprocessor extends Postprocessor {
   void setCallback(RepeatedPostprocessorRunner var1);
}
