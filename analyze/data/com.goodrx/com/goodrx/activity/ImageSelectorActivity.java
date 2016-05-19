package com.goodrx.activity;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.activity.ImageCropperActivity;
import com.goodrx.model.ImageResult;
import com.goodrx.model.Key;
import com.goodrx.model.MyRx;
import com.goodrx.utils.AccountInfoUtils;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.PasscodeManager;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.ArrayUtils;

public class ImageSelectorActivity extends BaseActivityWithPasscode {
   public static final String DOSAGE_SLUG = "dosage_slug";
   public static final String DRUG_ID = "drug_id";
   public static final String DRUG_SLUG = "drug_slug";
   public static final String FORM_SLUG = "form_slug";
   public static final String IMAGE_URL = "image_url";
   public static final String IS_IN_MYRX = "is_in_myrx";
   private boolean defaultImageDeleted;
   private int defaultIndex;
   private String dosageSlug;
   private String drugId;
   private String drugSlug;
   private String formSlug;
   private GoodRxAPI goodRxAPI;
   ViewPager imagePager;
   private ImageSelectorActivity.ImagePagerAdapter imagePagerAdapter;
   private String imagePath;
   private ImageResult[] imageResults;
   private boolean isInMyRx;
   View layoutPhoto;
   View layoutSave;
   MyProgressBar myProgressBar;
   TextView txtCompany;
   TextView txtDescription;
   TextView txtEmpty;
   TextView txtName;
   TextView txtSave;
   TextView txtTitle;

   private File createImageFile() throws IOException {
      String var1 = (new SimpleDateFormat("yyyyMMdd_HHmmss")).format(new Date());
      return File.createTempFile("JPEG_" + var1 + "_", ".jpg", this.getExternalCacheDir());
   }

   public static void launchWithDefaultImages(BaseActivityWithPasscode var0, View var1, String var2, String var3, String var4, String var5, String var6) {
      ActivityOptionsCompat var7 = ActivityOptionsCompat.makeSceneTransitionAnimation(var0, var1, var0.getString(2131427994));
      Intent var8 = new Intent(var0, ImageSelectorActivity.class);
      var8.putExtra("image_url", var6);
      var8.putExtra("is_in_myrx", false);
      var8.putExtra("drug_id", var5);
      var8.putExtra("drug_slug", var2);
      var8.putExtra("form_slug", var3);
      var8.putExtra("dosage_slug", var4);
      ActivityCompat.startActivityForResult(var0, var8, 11, var7.toBundle());
   }

   public static void launchWithUserImages(BaseActivityWithPasscode var0, View var1, String var2, String var3) {
      ActivityOptionsCompat var4 = ActivityOptionsCompat.makeSceneTransitionAnimation(var0, var1, var0.getString(2131427994));
      Intent var5 = new Intent(var0, ImageSelectorActivity.class);
      var5.putExtra("image_url", var2);
      var5.putExtra("is_in_myrx", true);
      var5.putExtra("drug_id", var3);
      ActivityCompat.startActivityForResult(var0, var5, 11, var4.toBundle());
   }

   private void openCamera() {
      if(Utils.checkCameraHardware(this)) {
         Intent var1 = new Intent("android.media.action.IMAGE_CAPTURE");
         if(var1.resolveActivity(this.getPackageManager()) != null) {
            try {
               File var3 = this.createImageFile();
               var1.putExtra("output", Uri.fromFile(var3));
               this.startActivityForResult(var1, 12);
               this.imagePath = var3.getAbsolutePath();
               return;
            } catch (Exception var4) {
               var4.printStackTrace();
               return;
            }
         }
      }

   }

   private void requestPermissions() {
      ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, 20);
   }

   public void deleteImage(String var1, final int var2) {
      if(this.imagePager.getCurrentItem() != -1 + this.imageResults.length) {
         boolean var3;
         if(this.imagePager.getCurrentItem() == var2) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.defaultImageDeleted = var3;
         this.imagePager.setCurrentItem(1 + this.imagePager.getCurrentItem(), true);
         this.txtTitle.setAlpha(0.0F);
         this.goodRxAPI.deleteImage(this, this.drugId, var1, new OnRequestFinishListener() {
            public void onSuccess(String var1) {
               ImageSelectorActivity.this.myProgressBar.dismiss();
               ImageSelectorActivity.this.getUserImages(Integer.valueOf(var2));
            }
         });
      }
   }

   public void getDefaultImages() {
      this.goodRxAPI.getDefaultImages(this, this.drugSlug, this.dosageSlug, this.formSlug, new OnRequestFinishListener() {
         public void onSuccess(ImageResult[] var1) {
            ImageSelectorActivity.this.imageResults = var1;
            ImageSelectorActivity.this.updateUI(ImageSelectorActivity.this.getIntent().getStringExtra("image_url"));
         }
      });
   }

   public void getUserImages(final Integer var1) {
      Key var2 = AccountInfoUtils.getKey(this);
      if(!var2.isValid()) {
         Utils.reinitTokens(this);
         this.finish();
      } else {
         this.myProgressBar.show();
         RequestParams var3 = new RequestParams();
         var3.add("token", var2.getToken());
         var3.add("token_id", var2.getToken_id());
         var3.add("drug_id", this.drugId);
         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/myrx-user-images", var3, new MyResponseHandler(this) {
            public void onSuccess(String param1) {
               // $FF: Couldn't be decompiled
            }
         });
      }
   }

   public void initData() {
      if(this.isInMyRx) {
         this.getUserImages((Integer)null);
      } else {
         if(VERSION.SDK_INT >= 21) {
            (new Handler()).postDelayed(new Runnable() {
               public void run() {
                  ImageSelectorActivity.this.getDefaultImages();
               }
            }, 300L);
         } else {
            this.getDefaultImages();
         }

         this.layoutPhoto.setVisibility(8);
         this.txtSave.setText(2131428005);
      }
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(var1 == 12) {
         PasscodeManager.getInstance().refreshTimeStamp(this);
         if(var2 == -1) {
            Intent var4 = new Intent(this, ImageCropperActivity.class);
            var4.putExtra("path", this.imagePath);
            var4.putExtra("drug_id", this.drugId);
            this.startActivityForResult(var4, 13);
         } else {
            try {
               File var7 = new File(this.imagePath);
               if(var7.exists()) {
                  var7.delete();
                  return;
               }
            } catch (Exception var9) {
               return;
            }
         }
      } else if(var1 == 13 && var2 == -1) {
         this.getUserImages(Integer.valueOf(0));
         return;
      }

   }

   public void onBackPressed() {
      if(this.defaultImageDeleted && this.imageResults.length > 0) {
         this.saveDefaultImage(this.imageResults[0]);
      } else if(VERSION.SDK_INT >= 21) {
         this.imagePager.setCurrentItem(this.defaultIndex, false);
         (new Handler()).postDelayed(new Runnable() {
            public void run() {
               ImageSelectorActivity.super.onBackPressed();
            }
         }, 1L);
      } else {
         super.onBackPressed();
      }
   }

   public void onButtonClicked(View var1) {
      int var2 = var1.getId();
      if(var2 == 2131886286) {
         int var3 = this.imagePager.getCurrentItem();
         if(this.imageResults != null && this.imageResults.length != 0) {
            if(this.isInMyRx) {
               this.saveDefaultImage(this.imageResults[var3]);
               return;
            }

            Intent var4 = new Intent();
            var4.putExtra("image_url", this.imageResults[var3].getImage());
            this.setResult(-1, var4);
            this.finish();
            return;
         }

         this.finish();
      } else {
         if(var2 == 2131886285) {
            this.onBackPressed();
            return;
         }

         if(var2 == 2131886292) {
            this.tryOpenCamera();
            return;
         }
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427839);
      this.setContentView(2130968618);
      ButterKnife.bind(this);
      this.getSupportActionBar().hide();
      this.shouldOverrideBackAnimation(false);
      this.isInMyRx = this.getIntent().getBooleanExtra("is_in_myrx", false);
      this.drugId = this.getIntent().getStringExtra("drug_id");
      if(!this.isInMyRx) {
         this.drugSlug = this.getIntent().getStringExtra("drug_slug");
         this.formSlug = this.getIntent().getStringExtra("form_slug");
         this.dosageSlug = this.getIntent().getStringExtra("dosage_slug");
      }

      String var2 = this.getIntent().getStringExtra("image_url");
      ImageResult[] var3 = new ImageResult[]{new ImageResult((String)null, "", "", var2, "")};
      this.imagePagerAdapter = new ImageSelectorActivity.ImagePagerAdapter(var3);
      this.imagePager.setAdapter(this.imagePagerAdapter);
      this.imagePager.setCurrentItem(0, false);
      this.imagePager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
         public void onPageSelected(int var1) {
            super.onPageSelected(var1);
            ImageSelectorActivity.this.updateTextViews(var1);
         }
      });
      this.goodRxAPI = GoodRxAPI.getInstance();
      this.initData();
   }

   public void onRequestPermissionsResult(int var1, @NonNull String[] var2, @NonNull int[] var3) {
      if(var1 == 20) {
         View var4 = this.findViewById(2131886250);
         if(var3.length == 2 && var3[0] == 0 && var3[1] == 0) {
            this.openCamera();
         } else if(var3[0] == 0) {
            Utils.makeSnackBar(var4, this.getString(2131427908)).show();
         } else if(var3[1] == 0) {
            Utils.makeSnackBar(var4, this.getString(2131427458)).show();
         } else {
            Utils.makeSnackBar(var4, this.getString(2131427455)).show();
         }
      } else {
         super.onRequestPermissionsResult(var1, var2, var3);
      }
   }

   public void saveDefaultImage(final ImageResult var1) {
      this.myProgressBar.show();
      this.goodRxAPI.saveDefaultImage(this, this.drugId, var1, new OnRequestFinishListener() {
         public void onSuccess(String var1x) {
            ImageSelectorActivity.this.myProgressBar.dismiss();
            MyRx[] var2 = MyRxUtils.getRx(ImageSelectorActivity.this);
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               MyRx var8 = var2[var4];
               if(var8.getDrug().getDrug_id().equals(ImageSelectorActivity.this.drugId)) {
                  var8.getDrug().setImage(var1.getImage());
                  break;
               }
            }

            ImageSelectorActivity.this.defaultIndex = ImageSelectorActivity.this.imagePager.getCurrentItem();
            MyRxUtils.saveRx(ImageSelectorActivity.this, var2);
            Intent var6 = new Intent();
            var6.putExtra("image_url", var1.getImage());
            ImageSelectorActivity.this.setResult(-1, var6);
            ImageSelectorActivity.this.finish();
         }
      });
   }

   public void tryOpenCamera() {
      if(ActivityCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0 && ActivityCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
         this.openCamera();
      } else {
         this.requestPermissions();
      }
   }

   public void updateImagePager(final ImageResult[] var1, final int var2) {
      if(VERSION.SDK_INT < 21 && var2 != 0) {
         this.imagePagerAdapter.update(var1);
         this.imagePager.setCurrentItem(var2, false);
      } else {
         (new Handler()).postDelayed(new Runnable() {
            public void run() {
               ImageSelectorActivity.this.imagePagerAdapter.update(var1);
               ImageSelectorActivity.this.imagePager.setAdapter(ImageSelectorActivity.this.imagePagerAdapter);
               ImageSelectorActivity.this.imagePager.setCurrentItem(var2, false);
            }
         }, 300L);
      }
   }

   public void updateTextViews(int var1) {
      int var2 = this.imageResults.length;
      int var3 = var1 + 1;
      TextView var4 = this.txtTitle;
      String var5 = this.getString(2131427880);
      Object[] var6 = new Object[]{Integer.valueOf(var3), Integer.valueOf(var2)};
      var4.setText(String.format(var5, var6));
      this.txtName.setText(this.imageResults[var1].getProduct_name_long());
      this.txtDescription.setText(this.imageResults[var1].getDescription());
      this.txtCompany.setText(this.imageResults[var1].getCompany_name());
   }

   public void updateUI(String var1) {
      String[] var2 = new String[this.imageResults.length];

      for(int var3 = 0; var3 < this.imageResults.length; ++var3) {
         var2[var3] = this.imageResults[var3].getImage();
      }

      if(!Utils.isInteger(var1)) {
         this.defaultIndex = ArrayUtils.indexOf(var2, var1);
      } else {
         for(int var4 = 0; var4 < this.imageResults.length; ++var4) {
            if(var1.equals(this.imageResults[var4].getImage_id())) {
               this.defaultIndex = var4;
               break;
            }
         }
      }

      if(this.defaultIndex < 0 || this.defaultIndex > -1 + this.imageResults.length) {
         this.defaultIndex = -1 + this.imagePager.getCurrentItem();
      }

      if(this.defaultIndex >= 0) {
         ImageLoader.getInstance().loadImage(var2[this.defaultIndex], new ImageLoadingListener() {
            public void onLoadingCancelled(String var1, View var2) {
            }

            public void onLoadingComplete(String var1, View var2, Bitmap var3) {
               ImageSelectorActivity.this.updateImagePager(ImageSelectorActivity.this.imageResults, ImageSelectorActivity.this.defaultIndex);
            }

            public void onLoadingFailed(String var1, View var2, FailReason var3) {
            }

            public void onLoadingStarted(String var1, View var2) {
            }
         });
         this.updateTextViews(this.defaultIndex);
         ValueAnimator var5 = ValueAnimator.ofFloat(new float[]{0.0F, 1.0F});
         var5.setDuration(1500L);
         var5.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator var1) {
               float var2 = ((Float)var1.getAnimatedValue()).floatValue();
               ImageSelectorActivity.this.txtTitle.setAlpha(var2);
               ImageSelectorActivity.this.txtName.setAlpha(var2);
               ImageSelectorActivity.this.txtDescription.setAlpha(var2);
               ImageSelectorActivity.this.txtCompany.setAlpha(var2);
               ImageSelectorActivity.this.layoutPhoto.setAlpha(var2);
               ImageSelectorActivity.this.layoutSave.setAlpha(var2);
            }
         });
         var5.start();
      }
   }

   private class ImagePagerAdapter extends PagerAdapter {
      public ImageResult[] imageResults;

      public ImagePagerAdapter(ImageResult[] var2) {
         this.imageResults = var2;
      }

      public void destroyItem(ViewGroup var1, int var2, Object var3) {
         var1.removeView((View)var3);
      }

      public int getCount() {
         return this.imageResults.length;
      }

      public int getItemPosition(Object var1) {
         return -2;
      }

      public Object instantiateItem(ViewGroup var1, final int var2) {
         View var3 = View.inflate(ImageSelectorActivity.this, 2130968694, (ViewGroup)null);
         ImageView var4 = (ImageView)var3.findViewById(2131886495);
         if(this.imageResults[var2].getImage() != null) {
            ImageLoader.getInstance().displayImage(this.imageResults[var2].getImage(), var4);
         } else {
            var4.setImageResource(2130837674);
         }

         ImageView var5 = (ImageView)var3.findViewById(2131886496);
         if(this.imageResults[var2].getImage_id() != null) {
            var5.setVisibility(0);
            var5.setOnClickListener(new OnClickListener() {
               public void onClick(View var1) {
                  AlertDialog.Builder var2x = new AlertDialog.Builder(var1.getContext());
                  var2x.setTitle(2131427805);
                  var2x.setMessage(2131427806);
                  var2x.setPositiveButton(2131427801, new android.content.DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface var1, int var2x) {
                        ImageSelectorActivity.this.deleteImage(ImagePagerAdapter.this.imageResults[var2].getImage_id(), var2);
                     }
                  });
                  var2x.setNegativeButton(2131427459, (android.content.DialogInterface.OnClickListener)null);
                  DialogHelper.showDialog(var2x);
               }
            });
         } else {
            var5.setVisibility(8);
         }

         var1.addView(var3, 0);
         return var3;
      }

      public boolean isViewFromObject(View var1, Object var2) {
         return var1 == var2;
      }

      public void update(ImageResult[] var1) {
         this.imageResults = var1;
         this.notifyDataSetChanged();
      }
   }
}
