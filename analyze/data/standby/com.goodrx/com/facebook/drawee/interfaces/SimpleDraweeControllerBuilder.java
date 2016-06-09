package com.facebook.drawee.interfaces;

import android.net.Uri;
import com.facebook.drawee.interfaces.DraweeController;
import javax.annotation.Nullable;

public interface SimpleDraweeControllerBuilder {
   DraweeController build();

   SimpleDraweeControllerBuilder setCallerContext(Object var1);

   SimpleDraweeControllerBuilder setOldController(@Nullable DraweeController var1);

   SimpleDraweeControllerBuilder setUri(Uri var1);

   SimpleDraweeControllerBuilder setUri(@Nullable String var1);
}
