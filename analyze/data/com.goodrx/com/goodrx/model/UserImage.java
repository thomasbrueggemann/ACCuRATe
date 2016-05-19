package com.goodrx.model;

import com.goodrx.model.ImageResult;

public class UserImage {
   private String image;
   private String image_id;

   public ImageResult toImageResult(String var1, String var2, String var3) {
      return new ImageResult(this.image_id, var1, var2, this.image, var3);
   }
}
