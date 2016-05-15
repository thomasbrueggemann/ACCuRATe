package com.goodrx.activity;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.view.View;
import com.edmodo.cropper.CropImageView;
import com.goodrx.model.Key;
import com.goodrx.utils.AccountInfoUtils;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.Utils;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageCropperActivity extends BaseActivityWithPasscode {
   private final int IMAGE_MAX_LENGTH = 2048;
   private CropImageView cropImageView;
   private String drugId;

   private File saveBitmapToFile(String param1, Bitmap param2) {
      // $FF: Couldn't be decompiled
   }

   private Bitmap scaleDown(Bitmap var1, int var2) {
      int var3 = Math.max(var1.getWidth(), var1.getHeight());
      if(var3 < var2) {
         return var1;
      } else {
         double var4 = (double)var2 / (double)var3;
         return ThumbnailUtils.extractThumbnail(var1, (int)(var4 * (double)var1.getWidth()), (int)(var4 * (double)var1.getHeight()), 2);
      }
   }

   public void onButtonClicked(View var1) {
      Bitmap var2 = this.cropImageView.getCroppedImage();
      this.uploadImage(this.saveBitmapToFile(this.drugId, var2));
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427828);
      this.setContentView(2130968616);
      this.getSupportActionBar().hide();
      this.drugId = this.getIntent().getStringExtra("drug_id");
      File var2 = new File(this.getIntent().getStringExtra("path"));
      Bitmap var3 = this.scaleDown(BitmapFactoryInstrumentation.decodeFile(var2.getAbsolutePath()), 2048);
      this.cropImageView = (CropImageView)this.findViewById(2131886279);
      this.cropImageView.setAspectRatio(600, 419);
      this.cropImageView.setFixedAspectRatio(true);
      this.cropImageView.setGuidelines(1);
      this.cropImageView.setImageBitmap(var3);

      try {
         var2.delete();
      } catch (Exception var5) {
         ;
      }
   }

   public void showError(String var1) {
      DialogHelper.showErrorDialog(this, this.getString(2131427570), var1);
   }

   public void uploadImage(final File var1) {
      if(var1 != null && var1.exists()) {
         Key var2 = AccountInfoUtils.getKey(this);
         if(!var2.isValid()) {
            Utils.reinitTokens(this);
            this.finish();
         } else {
            final MyProgressBar var3 = (MyProgressBar)this.findViewById(2131886399);
            var3.show();

            try {
               RequestParams var4 = new RequestParams();
               var4.put("token", var2.getToken());
               var4.put("token_id", var2.getToken_id());
               var4.put("drug_id", this.drugId);
               var4.put("drug_image", var1, "image/jpeg");
               CacheHttpRequestHelper.getInstance().post("https://www.goodrx.com/mobile-api/myrx-image-upload", var4, new MyResponseHandler(this) {
                  public void onSuccess(String var1x) {
                     var3.dismiss();

                     try {
                        var1.delete();
                        new JSONObject;
                        JSONObject var5 = JSONObjectInstrumentation.init(var1x);
                        if(var5.getBoolean("success")) {
                           ImageCropperActivity.this.setResult(-1);
                           ImageCropperActivity.this.finish();
                           return;
                        }

                        JSONArray var6 = var5.getJSONArray("errors");
                        if(var6.length() > 0) {
                           ImageCropperActivity.this.showError(var6.getString(0));
                           return;
                        }
                     } catch (JSONException var7) {
                        var7.printStackTrace();
                     }

                  }
               });
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }
      } else {
         this.showError("Unknown Error");
      }
   }
}
