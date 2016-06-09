package com.koushikdutta.ion.builder;

import com.koushikdutta.ion.builder.BitmapBuilder;
import com.koushikdutta.ion.builder.BitmapFutureBuilder;
import com.koushikdutta.ion.builder.FutureBuilder;
import com.koushikdutta.ion.builder.ImageViewBuilder;
import com.koushikdutta.ion.builder.ImageViewFutureBuilder;
import com.koushikdutta.ion.builder.LoadImageViewFutureBuilder;
import com.koushikdutta.ion.builder.MultipartBodyBuilder;
import com.koushikdutta.ion.builder.RequestBuilder;
import com.koushikdutta.ion.builder.UrlEncodedBuilder;

public interface Builders {
   public interface Any {
   }

   public interface class_3 extends RequestBuilder<Builders.class_5, Builders.class_3, Builders.class_7, Builders.class_8>, Builders.class_5 {
   }

   public interface class_4<A extends Builders.class_4<?>> extends BitmapBuilder<A>, BitmapFutureBuilder, Builders.class_6<A> {
   }

   public interface class_5 extends FutureBuilder, ImageViewFutureBuilder {
   }

   public interface class_6<A extends Builders.class_6<?>> extends ImageViewBuilder<A>, ImageViewFutureBuilder {
   }

   public interface class_7 extends MultipartBodyBuilder<Builders.class_7>, Builders.class_5 {
   }

   public interface class_8 extends UrlEncodedBuilder<Builders.class_8>, Builders.class_5 {
   }

   public interface ImageView {
   }

   public interface class_9<A extends Builders.class_9<?>> extends ImageViewBuilder<A>, BitmapBuilder<A>, LoadImageViewFutureBuilder {
   }
}
