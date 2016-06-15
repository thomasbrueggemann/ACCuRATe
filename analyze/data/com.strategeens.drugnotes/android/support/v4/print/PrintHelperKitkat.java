package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
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
   static Object access$300(PrintHelperKitkat var0) {
      return var0.mLock;
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

   public void printBitmap(final String var1, final Bitmap var2) {
      if(var2 != null) {
         final int var3 = this.mScaleMode;
         PrintManager var4 = (PrintManager)this.mContext.getSystemService("print");
         MediaSize var5 = MediaSize.UNKNOWN_PORTRAIT;
         if(var2.getWidth() > var2.getHeight()) {
            var5 = MediaSize.UNKNOWN_LANDSCAPE;
         }

         PrintAttributes var6 = (new Builder()).setMediaSize(var5).setColorMode(this.mColorMode).build();
         var4.print(var1, new PrintDocumentAdapter() {
            private PrintAttributes mAttributes;

            public void onLayout(PrintAttributes var1x, PrintAttributes var2x, CancellationSignal var3x, LayoutResultCallback var4, Bundle var5) {
               byte var6 = 1;
               this.mAttributes = var2x;
               PrintDocumentInfo var7 = (new android.print.PrintDocumentInfo.Builder(var1)).setContentType(var6).setPageCount(var6).build();
               if(var2x.equals(var1x)) {
                  var6 = 0;
               }

               var4.onLayoutFinished(var7, (boolean)var6);
            }

            public void onWrite(PageRange[] var1x, ParcelFileDescriptor var2x, CancellationSignal var3x, WriteResultCallback var4) {
               PrintedPdfDocument var5 = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.mAttributes);

               try {
                  Page var8 = var5.startPage(1);
                  RectF var9 = new RectF(var8.getInfo().getContentRect());
                  Matrix var10 = PrintHelperKitkat.this.getMatrix(var2.getWidth(), var2.getHeight(), var9, var3);
                  var8.getCanvas().drawBitmap(var2, var10, (Paint)null);
                  var5.finishPage(var8);

                  try {
                     var5.writeTo(new FileOutputStream(var2x.getFileDescriptor()));
                     PageRange[] var14 = new PageRange[]{PageRange.ALL_PAGES};
                     var4.onWriteFinished(var14);
                  } catch (IOException var20) {
                     Log.e("PrintHelperKitkat", "Error writing printed content", var20);
                     var4.onWriteFailed((CharSequence)null);
                  }
               } finally {
                  if(var5 != null) {
                     var5.close();
                  }

                  if(var2x != null) {
                     try {
                        var2x.close();
                     } catch (IOException var19) {
                        ;
                     }
                  }

               }

            }
         }, var6);
      }
   }

   public void printBitmap(final String var1, final Uri var2) throws FileNotFoundException {
      PrintDocumentAdapter var3 = new PrintDocumentAdapter() {
         AsyncTask<Uri, Boolean, Bitmap> loadBitmap;
         private PrintAttributes mAttributes;
         Bitmap mBitmap;
         // $FF: synthetic field
         final int val$fittingMode;

         {
            this.val$fittingMode = var4;
            this.mBitmap = null;
         }

         private void cancelLoad() {
            // $FF: Couldn't be decompiled
         }

         public void onFinish() {
            super.onFinish();
            this.cancelLoad();
            this.loadBitmap.cancel(true);
         }

         public void onLayout(final PrintAttributes var1x, final PrintAttributes var2x, final CancellationSignal var3, final LayoutResultCallback var4, Bundle var5) {
            byte var6 = 1;
            if(var3.isCanceled()) {
               var4.onLayoutCancelled();
               this.mAttributes = var2x;
            } else if(this.mBitmap != null) {
               PrintDocumentInfo var8 = (new android.print.PrintDocumentInfo.Builder(var1)).setContentType(var6).setPageCount(var6).build();
               if(var2x.equals(var1x)) {
                  var6 = 0;
               }

               var4.onLayoutFinished(var8, (boolean)var6);
            } else {
               this.loadBitmap = new AsyncTask() {
                  protected Bitmap doInBackground(Uri... var1xx) {
                     try {
                        Bitmap var3x = PrintHelperKitkat.this.loadConstrainedBitmap(var2, 3500);
                        return var3x;
                     } catch (FileNotFoundException var4x) {
                        return null;
                     }
                  }

                  protected void onCancelled(Bitmap var1xx) {
                     var4.onLayoutCancelled();
                  }

                  protected void onPostExecute(Bitmap var1xx) {
                     byte var2xx = 1;
                     super.onPostExecute(var1xx);
                     mBitmap = var1xx;
                     if(var1xx != null) {
                        PrintDocumentInfo var3x = (new android.print.PrintDocumentInfo.Builder(var1)).setContentType(var2xx).setPageCount(var2xx).build();
                        if(var2x.equals(var1x)) {
                           var2xx = 0;
                        }

                        var4.onLayoutFinished(var3x, (boolean)var2xx);
                     } else {
                        var4.onLayoutFailed((CharSequence)null);
                     }
                  }

                  protected void onPreExecute() {
                     var3.setOnCancelListener(new OnCancelListener() {
                        public void onCancel() {
                           cancelLoad();
                           cancel(false);
                        }
                     });
                  }
               };
               this.loadBitmap.execute(new Uri[0]);
               this.mAttributes = var2x;
            }
         }

         public void onWrite(PageRange[] var1x, ParcelFileDescriptor var2x, CancellationSignal var3, WriteResultCallback var4) {
            PrintedPdfDocument var5 = new PrintedPdfDocument(PrintHelperKitkat.this.mContext, this.mAttributes);

            try {
               Page var8 = var5.startPage(1);
               RectF var9 = new RectF(var8.getInfo().getContentRect());
               Matrix var10 = PrintHelperKitkat.this.getMatrix(this.mBitmap.getWidth(), this.mBitmap.getHeight(), var9, this.val$fittingMode);
               var8.getCanvas().drawBitmap(this.mBitmap, var10, (Paint)null);
               var5.finishPage(var8);

               try {
                  var5.writeTo(new FileOutputStream(var2x.getFileDescriptor()));
                  PageRange[] var14 = new PageRange[]{PageRange.ALL_PAGES};
                  var4.onWriteFinished(var14);
               } catch (IOException var20) {
                  Log.e("PrintHelperKitkat", "Error writing printed content", var20);
                  var4.onWriteFailed((CharSequence)null);
               }
            } finally {
               if(var5 != null) {
                  var5.close();
               }

               if(var2x != null) {
                  try {
                     var2x.close();
                  } catch (IOException var19) {
                     ;
                  }
               }

            }

         }
      };
      PrintManager var4 = (PrintManager)this.mContext.getSystemService("print");
      Builder var5 = new Builder();
      var5.setColorMode(this.mColorMode);
      if(this.mOrientation == 1) {
         var5.setMediaSize(MediaSize.UNKNOWN_LANDSCAPE);
      } else if(this.mOrientation == 2) {
         var5.setMediaSize(MediaSize.UNKNOWN_PORTRAIT);
      }

      var4.print(var1, var3, var5.build());
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
}
