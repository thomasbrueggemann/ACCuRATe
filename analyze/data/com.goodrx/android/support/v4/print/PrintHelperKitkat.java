package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.pdf.PdfDocument.Page;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.CancellationSignal.OnCancelListener;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class PrintHelperKitkat {
   public static final int COLOR_MODE_COLOR = 2;
   public static final int COLOR_MODE_MONOCHROME = 1;
   private static final String LOG_TAG = "PrintHelperKitkat";
   private static final int MAX_PRINT_SIZE = 3500;
   public static final int ORIENTATION_LANDSCAPE = 1;
   public static final int ORIENTATION_PORTRAIT = 2;
   public static final int SCALE_MODE_FILL = 2;
   public static final int SCALE_MODE_FIT = 1;
   int mColorMode = 2;
   final Context mContext;
   Options mDecodeOptions = null;
   private final Object mLock = new Object();
   int mOrientation = 1;
   int mScaleMode = 2;

   PrintHelperKitkat(Context var1) {
      this.mContext = var1;
   }

   // $FF: synthetic method
   static Object access$400(PrintHelperKitkat var0) {
      return var0.mLock;
   }

   private Bitmap convertBitmapForColorMode(Bitmap var1, int var2) {
      if(var2 != 1) {
         return var1;
      } else {
         Bitmap var3 = Bitmap.createBitmap(var1.getWidth(), var1.getHeight(), Config.ARGB_8888);
         Canvas var4 = new Canvas(var3);
         Paint var5 = new Paint();
         ColorMatrix var6 = new ColorMatrix();
         var6.setSaturation(0.0F);
         var5.setColorFilter(new ColorMatrixColorFilter(var6));
         var4.drawBitmap(var1, 0.0F, 0.0F, var5);
         var4.setBitmap((Bitmap)null);
         return var3;
      }
   }

   private Matrix getMatrix(int var1, int var2, RectF var3, int var4) {
      Matrix var5 = new Matrix();
      float var6 = var3.width() / (float)var1;
      float var7;
      if(var4 == 2) {
         var7 = Math.max(var6, var3.height() / (float)var2);
      } else {
         var7 = Math.min(var6, var3.height() / (float)var2);
      }

      var5.postScale(var7, var7);
      var5.postTranslate((var3.width() - var7 * (float)var1) / 2.0F, (var3.height() - var7 * (float)var2) / 2.0F);
      return var5;
   }

   private Bitmap loadBitmap(Uri var1, Options var2) throws FileNotFoundException {
      if(var1 != null && this.mContext != null) {
         InputStream var3 = null;

         Bitmap var7;
         try {
            var3 = this.mContext.getContentResolver().openInputStream(var1);
            var7 = BitmapFactory.decodeStream(var3, (Rect)null, var2);
         } finally {
            if(var3 != null) {
               try {
                  var3.close();
               } catch (IOException var12) {
                  Log.w("PrintHelperKitkat", "close fail ", var12);
               }
            }

         }

         return var7;
      } else {
         throw new IllegalArgumentException("bad argument to loadBitmap");
      }
   }

   private Bitmap loadConstrainedBitmap(Uri param1, int param2) throws FileNotFoundException {
      // $FF: Couldn't be decompiled
   }

   public int getColorMode() {
      return this.mColorMode;
   }

   public int getOrientation() {
      return this.mOrientation;
   }

   public int getScaleMode() {
      return this.mScaleMode;
   }

   public void printBitmap(final String var1, final Bitmap var2, final PrintHelperKitkat.OnPrintFinishCallback var3) {
      if(var2 != null) {
         final int var4 = this.mScaleMode;
         PrintManager var5 = (PrintManager)this.mContext.getSystemService("print");
         MediaSize var6 = MediaSize.UNKNOWN_PORTRAIT;
         if(var2.getWidth() > var2.getHeight()) {
            var6 = MediaSize.UNKNOWN_LANDSCAPE;
         }

         PrintAttributes var7 = (new Builder()).setMediaSize(var6).setColorMode(this.mColorMode).build();
         var5.print(var1, new PrintDocumentAdapter() {
            private PrintAttributes mAttributes;

            public void onFinish() {
               if(var3 != null) {
                  var3.onFinish();
               }

            }

            public void onLayout(PrintAttributes var1x, PrintAttributes var2x, CancellationSignal var3x, LayoutResultCallback var4x, Bundle var5) {
               byte var6 = 1;
               this.mAttributes = var2x;
               PrintDocumentInfo var7 = (new android.print.PrintDocumentInfo.Builder(var1)).setContentType(var6).setPageCount(var6).build();
               if(var2x.equals(var1x)) {
                  var6 = 0;
               }

               var4x.onLayoutFinished(var7, (boolean)var6);
            }

            public void onWrite(PageRange[] var1x, ParcelFileDescriptor var2x, CancellationSignal var3x, WriteResultCallback var4x) {
               PrintedPdfDocument var5 = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.mAttributes);
               Bitmap var6 = PrintHelperKitkat.this.convertBitmapForColorMode(var2, this.mAttributes.getColorMode());

               try {
                  Page var9 = var5.startPage(1);
                  RectF var10 = new RectF(var9.getInfo().getContentRect());
                  Matrix var11 = PrintHelperKitkat.this.getMatrix(var6.getWidth(), var6.getHeight(), var10, var4);
                  var9.getCanvas().drawBitmap(var6, var11, (Paint)null);
                  var5.finishPage(var9);

                  try {
                     var5.writeTo(new FileOutputStream(var2x.getFileDescriptor()));
                     PageRange[] var15 = new PageRange[]{PageRange.ALL_PAGES};
                     var4x.onWriteFinished(var15);
                  } catch (IOException var21) {
                     Log.e("PrintHelperKitkat", "Error writing printed content", var21);
                     var4x.onWriteFailed((CharSequence)null);
                  }
               } finally {
                  if(var5 != null) {
                     var5.close();
                  }

                  if(var2x != null) {
                     try {
                        var2x.close();
                     } catch (IOException var20) {
                        ;
                     }
                  }

                  if(var6 != var2) {
                     var6.recycle();
                  }

               }

            }
         }, var7);
      }
   }

   public void printBitmap(final String var1, final Uri var2, final PrintHelperKitkat.OnPrintFinishCallback var3) throws FileNotFoundException {
      PrintDocumentAdapter var4 = new PrintDocumentAdapter() {
         private PrintAttributes mAttributes;
         Bitmap mBitmap;
         AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
         // $FF: synthetic field
         final int val$fittingMode;

         {
            this.val$fittingMode = var5;
            this.mBitmap = null;
         }

         private void cancelLoad() {
            // $FF: Couldn't be decompiled
         }

         public void onFinish() {
            super.onFinish();
            this.cancelLoad();
            if(this.mLoadBitmap != null) {
               this.mLoadBitmap.cancel(true);
            }

            if(var3 != null) {
               var3.onFinish();
            }

            if(this.mBitmap != null) {
               this.mBitmap.recycle();
               this.mBitmap = null;
            }

         }

         public void onLayout(final PrintAttributes var1x, final PrintAttributes var2x, final CancellationSignal var3x, final LayoutResultCallback var4, Bundle var5) {
            byte var6 = 1;
            this.mAttributes = var2x;
            if(var3x.isCanceled()) {
               var4.onLayoutCancelled();
            } else if(this.mBitmap != null) {
               PrintDocumentInfo var7 = (new android.print.PrintDocumentInfo.Builder(var1)).setContentType(var6).setPageCount(var6).build();
               if(var2x.equals(var1x)) {
                  var6 = 0;
               }

               var4.onLayoutFinished(var7, (boolean)var6);
            } else {
               this.mLoadBitmap = (new AsyncTask() {
                  protected Bitmap doInBackground(Uri... var1xx) {
                     try {
                        Bitmap var3xx = PrintHelperKitkat.this.loadConstrainedBitmap(var2, 3500);
                        return var3xx;
                     } catch (FileNotFoundException var4x) {
                        return null;
                     }
                  }

                  protected void onCancelled(Bitmap var1xx) {
                     var4.onLayoutCancelled();
                     mLoadBitmap = null;
                  }

                  protected void onPostExecute(Bitmap var1xx) {
                     byte var2xx = 1;
                     super.onPostExecute(var1xx);
                     mBitmap = var1xx;
                     if(var1xx != null) {
                        PrintDocumentInfo var3xx = (new android.print.PrintDocumentInfo.Builder(var1)).setContentType(var2xx).setPageCount(var2xx).build();
                        if(var2x.equals(var1x)) {
                           var2xx = 0;
                        }

                        var4.onLayoutFinished(var3xx, (boolean)var2xx);
                     } else {
                        var4.onLayoutFailed((CharSequence)null);
                     }

                     mLoadBitmap = null;
                  }

                  protected void onPreExecute() {
                     var3x.setOnCancelListener(new OnCancelListener() {
                        public void onCancel() {
                           cancelLoad();
                           cancel(false);
                        }
                     });
                  }
               }).execute(new Uri[0]);
            }
         }

         public void onWrite(PageRange[] var1x, ParcelFileDescriptor var2x, CancellationSignal var3x, WriteResultCallback var4) {
            PrintedPdfDocument var5 = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.mAttributes);
            Bitmap var6 = PrintHelperKitkat.this.convertBitmapForColorMode(this.mBitmap, this.mAttributes.getColorMode());

            try {
               Page var9 = var5.startPage(1);
               RectF var10 = new RectF(var9.getInfo().getContentRect());
               Matrix var11 = PrintHelperKitkat.this.getMatrix(this.mBitmap.getWidth(), this.mBitmap.getHeight(), var10, this.val$fittingMode);
               var9.getCanvas().drawBitmap(var6, var11, (Paint)null);
               var5.finishPage(var9);

               try {
                  var5.writeTo(new FileOutputStream(var2x.getFileDescriptor()));
                  PageRange[] var15 = new PageRange[]{PageRange.ALL_PAGES};
                  var4.onWriteFinished(var15);
               } catch (IOException var21) {
                  Log.e("PrintHelperKitkat", "Error writing printed content", var21);
                  var4.onWriteFailed((CharSequence)null);
               }
            } finally {
               if(var5 != null) {
                  var5.close();
               }

               if(var2x != null) {
                  try {
                     var2x.close();
                  } catch (IOException var20) {
                     ;
                  }
               }

               if(var6 != this.mBitmap) {
                  var6.recycle();
               }

            }

         }
      };
      PrintManager var5 = (PrintManager)this.mContext.getSystemService("print");
      Builder var6 = new Builder();
      var6.setColorMode(this.mColorMode);
      if(this.mOrientation == 1) {
         var6.setMediaSize(MediaSize.UNKNOWN_LANDSCAPE);
      } else if(this.mOrientation == 2) {
         var6.setMediaSize(MediaSize.UNKNOWN_PORTRAIT);
      }

      var5.print(var1, var4, var6.build());
   }

   public void setColorMode(int var1) {
      this.mColorMode = var1;
   }

   public void setOrientation(int var1) {
      this.mOrientation = var1;
   }

   public void setScaleMode(int var1) {
      this.mScaleMode = var1;
   }

   public interface OnPrintFinishCallback {
      void onFinish();
   }
}
