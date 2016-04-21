package org.apache.cordova.camera;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.camera.ExifHelper;
import org.apache.cordova.camera.FileHelper;
import org.json.JSONArray;
import org.json.JSONException;

public class CameraLauncher extends CordovaPlugin implements MediaScannerConnectionClient {
    private static final int ALLMEDIA = 2;
    private static final int CAMERA = 1;
    private static final int CROP_CAMERA = 100;
    private static final int DATA_URL = 0;
    private static final int FILE_URI = 1;
    private static final String GET_All = "Get All";
    private static final String GET_PICTURE = "Get Picture";
    private static final String GET_VIDEO = "Get Video";
    private static final int JPEG = 0;
    private static final String LOG_TAG = "CameraLauncher";
    private static final int NATIVE_URI = 2;
    private static final int PHOTOLIBRARY = 0;
    private static final int PICTURE = 0;
    private static final int PNG = 1;
    private static final int SAVEDPHOTOALBUM = 2;
    private static final int VIDEO = 1;
    private boolean allowEdit;
    public CallbackContext callbackContext;
    private MediaScannerConnection conn;
    private boolean correctOrientation;
    private Uri croppedUri;
    private int encodingType;
    private Uri imageUri;
    private int mQuality;
    private int mediaType;
    private int numPics;
    private boolean orientationCorrected;
    private boolean saveToPhotoAlbum;
    private Uri scanMe;
    private int targetHeight;
    private int targetWidth;

    public static int calculateSampleSize(int var0, int var1, int var2, int var3) {
        return (float)var0 / (float)var1 > (float)var2 / (float)var3?var0 / var2:var1 / var3;
    }

    private void checkForDuplicateImage(int var1) {
        byte var2 = 1;
        Uri var3 = this.whichContentStore();
        Cursor var4 = this.queryImgDB(var3);
        int var5 = var4.getCount();
        if(var1 == 1 && this.saveToPhotoAlbum) {
            var2 = 2;
        }

        if(var5 - this.numPics == var2) {
            var4.moveToLast();
            int var7 = Integer.valueOf(var4.getString(var4.getColumnIndex("_id"))).intValue();
            if(var2 == 2) {
                --var7;
            }

            Uri var8 = Uri.parse(var3 + "/" + var7);
            this.cordova.getActivity().getContentResolver().delete(var8, (String)null, (String[])null);
            var4.close();
        }

    }

    private void cleanup(int var1, Uri var2, Uri var3, Bitmap var4) {
        if(var4 != null) {
            var4.recycle();
        }

        (new File(FileHelper.stripFileProtocol(var2.toString()))).delete();
        this.checkForDuplicateImage(var1);
        if(this.saveToPhotoAlbum && var3 != null) {
            this.scanForGallery(var3);
        }

        System.gc();
    }

    private File createCaptureFile(int var1) {
        if(var1 == 0) {
            return new File(this.getTempDirectoryPath(), ".Pic.jpg");
        } else if(var1 == 1) {
            return new File(this.getTempDirectoryPath(), ".Pic.png");
        } else {
            throw new IllegalArgumentException("Invalid Encoding Type: " + var1);
        }
    }

    private int getImageOrientation(Uri param1) {
        // $FF: Couldn't be decompiled
    }

    private Bitmap getRotatedBitmap(int var1, Bitmap var2, ExifHelper var3) {
        Matrix var4 = new Matrix();
        if(var1 == 180) {
            var4.setRotate((float)var1);
        } else {
            var4.setRotate((float)var1, (float)var2.getWidth() / 2.0F, (float)var2.getHeight() / 2.0F);
        }

        try {
            int var6 = var2.getWidth();
            int var7 = var2.getHeight();
            var2 = Bitmap.createBitmap(var2, 0, 0, var6, var7, var4, true);
            var3.resetOrientation();
            return var2;
        } catch (OutOfMemoryError var8) {
            return var2;
        }
    }

    private Bitmap getScaledBitmap(String var1) throws IOException {
        Bitmap var5;
        if(this.targetWidth <= 0 && this.targetHeight <= 0) {
            var5 = BitmapFactory.decodeStream(FileHelper.getInputStreamFromUriString(var1, this.cordova));
        } else {
            Options var2 = new Options();
            var2.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(FileHelper.getInputStreamFromUriString(var1, this.cordova), (Rect)null, var2);
            int var4 = var2.outWidth;
            var5 = null;
            if(var4 != 0) {
                int var6 = var2.outHeight;
                var5 = null;
                if(var6 != 0) {
                    int[] var7 = this.calculateAspectRatio(var2.outWidth, var2.outHeight);
                    var2.inJustDecodeBounds = false;
                    var2.inSampleSize = calculateSampleSize(var2.outWidth, var2.outHeight, this.targetWidth, this.targetHeight);
                    Bitmap var8 = BitmapFactory.decodeStream(FileHelper.getInputStreamFromUriString(var1, this.cordova), (Rect)null, var2);
                    var5 = null;
                    if(var8 != null) {
                        return Bitmap.createScaledBitmap(var8, var7[0], var7[1], true);
                    }
                }
            }
        }

        return var5;
    }

    private String getTempDirectoryPath() {
        File var1;
        if(Environment.getExternalStorageState().equals("mounted")) {
            var1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + this.cordova.getActivity().getPackageName() + "/cache/");
        } else {
            var1 = this.cordova.getActivity().getCacheDir();
        }

        var1.mkdirs();
        return var1.getAbsolutePath();
    }

    private Uri getUriFromMediaStore() {
        ContentValues var1 = new ContentValues();
        var1.put("mime_type", "image/jpeg");

        try {
            Uri var5 = this.cordova.getActivity().getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, var1);
            return var5;
        } catch (RuntimeException var7) {
            LOG.method_4279("CameraLauncher", "Can\'t write to external media storage.");

            try {
                Uri var4 = this.cordova.getActivity().getContentResolver().insert(Media.INTERNAL_CONTENT_URI, var1);
                return var4;
            } catch (RuntimeException var6) {
                LOG.method_4279("CameraLauncher", "Can\'t write to internal media storage.");
                return null;
            }
        }
    }

    private String ouputModifiedBitmap(Bitmap var1, Uri var2) throws IOException {
        String var3 = this.getTempDirectoryPath() + "/modified.jpg";
        FileOutputStream var4 = new FileOutputStream(var3);
        var1.compress(CompressFormat.JPEG, this.mQuality, var4);
        var4.close();
        String var6 = FileHelper.getRealPath(var2, this.cordova);
        ExifHelper var7 = new ExifHelper();
        if(var6 != null && this.encodingType == 0) {
            try {
                var7.createInFile(var6);
                var7.readExifData();
                if(this.correctOrientation && this.orientationCorrected) {
                    var7.resetOrientation();
                }

                var7.createOutFile(var3);
                var7.writeExifData();
            } catch (IOException var9) {
                var9.printStackTrace();
                return var3;
            }
        }

        return var3;
    }

    private void performCrop(Uri var1) {
        try {
            Intent var2 = new Intent("com.android.camera.action.CROP");
            var2.setDataAndType(var1, "image/*");
            var2.putExtra("crop", "true");
            if(this.targetWidth > 0) {
                var2.putExtra("outputX", this.targetWidth);
            }

            if(this.targetHeight > 0) {
                var2.putExtra("outputY", this.targetHeight);
            }

            if(this.targetHeight > 0 && this.targetWidth > 0 && this.targetWidth == this.targetHeight) {
                var2.putExtra("aspectX", 1);
                var2.putExtra("aspectY", 1);
            }

            this.croppedUri = Uri.fromFile(new File(this.getTempDirectoryPath(), System.currentTimeMillis() + ".jpg"));
            var2.putExtra("output", this.croppedUri);
            if(this.cordova != null) {
                this.cordova.startActivityForResult(this, var2, 100);
            }

        } catch (ActivityNotFoundException var4) {
            Log.e("CameraLauncher", "Crop operation not supported on this device");
            this.callbackContext.success(var1.toString());
        }
    }

    private void processResultFromCamera(int param1, Intent param2) throws IOException {
        // $FF: Couldn't be decompiled
    }

    private void processResultFromGallery(int var1, Intent var2) {
        Uri var3 = var2.getData();
        if(var3 == null) {
            if(this.croppedUri == null) {
                this.failPicture("null data from photo library");
                return;
            }

            var3 = this.croppedUri;
        }

        if(this.mediaType != 0) {
            this.callbackContext.success(var3.toString());
        } else if(this.targetHeight == -1 && this.targetWidth == -1 && (var1 == 1 || var1 == 2) && !this.correctOrientation) {
            this.callbackContext.success(var3.toString());
        } else {
            String var4 = var3.toString();
            String var5 = FileHelper.getMimeType(var4, this.cordova);
            if(!"image/jpeg".equalsIgnoreCase(var5) && !"image/png".equalsIgnoreCase(var5)) {
                Log.d("CameraLauncher", "I either have a null image path or bitmap");
                this.failPicture("Unable to retrieve path to picture!");
            } else {
                Bitmap var7;
                label80: {
                    Bitmap var14;
                    try {
                        var14 = this.getScaledBitmap(var4);
                    } catch (IOException var17) {
                        var17.printStackTrace();
                        var7 = null;
                        break label80;
                    }

                    var7 = var14;
                }

                if(var7 == null) {
                    Log.d("CameraLauncher", "I either have a null image path or bitmap");
                    this.failPicture("Unable to create bitmap!");
                } else {
                    if(this.correctOrientation) {
                        int var10 = this.getImageOrientation(var3);
                        if(var10 != 0) {
                            Matrix var11 = new Matrix();
                            var11.setRotate((float)var10);

                            try {
                                var7 = Bitmap.createBitmap(var7, 0, 0, var7.getWidth(), var7.getHeight(), var11, true);
                                this.orientationCorrected = true;
                            } catch (OutOfMemoryError var16) {
                                this.orientationCorrected = false;
                            }
                        }
                    }

                    if(var1 == 0) {
                        this.processPicture(var7);
                    } else if(var1 == 1 || var1 == 2) {
                        if((this.targetHeight <= 0 || this.targetWidth <= 0) && (!this.correctOrientation || !this.orientationCorrected)) {
                            this.callbackContext.success(var3.toString());
                        } else {
                            try {
                                String var9 = this.ouputModifiedBitmap(var7, var3);
                                this.callbackContext.success("file://" + var9 + "?" + System.currentTimeMillis());
                            } catch (Exception var15) {
                                var15.printStackTrace();
                                this.failPicture("Error retrieving image.");
                            }
                        }
                    }

                    if(var7 != null) {
                        var7.recycle();
                    }

                    System.gc();
                }
            }
        }
    }

    private Cursor queryImgDB(Uri var1) {
        return this.cordova.getActivity().getContentResolver().query(var1, new String[] {"_id"}, (String)null, (String[])null, (String)null);
    }

    private void scanForGallery(Uri var1) {
        this.scanMe = var1;
        if(this.conn != null) {
            this.conn.disconnect();
        }

        this.conn = new MediaScannerConnection(this.cordova.getActivity().getApplicationContext(), this);
        this.conn.connect();
    }

    private Uri whichContentStore() {
        return Environment.getExternalStorageState().equals("mounted")?Media.EXTERNAL_CONTENT_URI:Media.INTERNAL_CONTENT_URI;
    }

    private void writeUncompressedImage(Uri var1) throws FileNotFoundException, IOException {
        FileInputStream var2 = new FileInputStream(FileHelper.stripFileProtocol(this.imageUri.toString()));
        OutputStream var3 = this.cordova.getActivity().getContentResolver().openOutputStream(var1);
        byte[] var4 = new byte[4096];

        while(true) {
            int var5 = var2.read(var4);
            if(var5 == -1) {
                var3.flush();
                var3.close();
                var2.close();
                return;
            }

            var3.write(var4, 0, var5);
        }
    }

    public int[] calculateAspectRatio(int var1, int var2) {
        int var3 = this.targetWidth;
        int var4 = this.targetHeight;
        if(var3 <= 0 && var4 <= 0) {
            var3 = var1;
            var4 = var2;
        } else if(var3 > 0 && var4 <= 0) {
            var4 = var3 * var2 / var1;
        } else if(var3 <= 0 && var4 > 0) {
            var3 = var4 * var1 / var2;
        } else {
            double var5 = (double)var3 / (double)var4;
            double var7 = (double)var1 / (double)var2;
            if(var7 > var5) {
                var4 = var3 * var2 / var1;
            } else if(var7 < var5) {
                var3 = var4 * var1 / var2;
            }
        }

        return new int[] {var3, var4};
    }

    public boolean execute(String param1, JSONArray param2, CallbackContext param3) throws JSONException {
        // $FF: Couldn't be decompiled
    }

    public void failPicture(String var1) {
        this.callbackContext.error(var1);
    }

    public void getImage(int var1, int var2, int var3) {
        Intent var4 = new Intent();
        String var5 = "Get Picture";
        this.croppedUri = null;
        if(this.mediaType == 0) {
            var4.setType("image/*");
            if(this.allowEdit) {
                var4.setAction("android.intent.action.PICK");
                var4.putExtra("crop", "true");
                if(this.targetWidth > 0) {
                    var4.putExtra("outputX", this.targetWidth);
                }

                if(this.targetHeight > 0) {
                    var4.putExtra("outputY", this.targetHeight);
                }

                if(this.targetHeight > 0 && this.targetWidth > 0 && this.targetWidth == this.targetHeight) {
                    var4.putExtra("aspectX", 1);
                    var4.putExtra("aspectY", 1);
                }

                this.croppedUri = Uri.fromFile(this.createCaptureFile(var3));
                var4.putExtra("output", this.croppedUri);
            } else {
                var4.setAction("android.intent.action.GET_CONTENT");
                var4.addCategory("android.intent.category.OPENABLE");
            }
        } else if(this.mediaType == 1) {
            var4.setType("video/*");
            var5 = "Get Video";
            var4.setAction("android.intent.action.GET_CONTENT");
            var4.addCategory("android.intent.category.OPENABLE");
        } else if(this.mediaType == 2) {
            var4.setType("*/*");
            var5 = "Get All";
            var4.setAction("android.intent.action.GET_CONTENT");
            var4.addCategory("android.intent.category.OPENABLE");
        }

        if(this.cordova != null) {
            this.cordova.startActivityForResult(this, Intent.createChooser(var4, new String(var5)), 1 + var2 + 16 * (var1 + 1));
        }

    }

    public void onActivityResult(int var1, int var2, Intent var3) {
        int var4 = -1 + var1 / 16;
        int var5 = -1 + var1 % 16;
        if(var1 == 100) {
            if(var2 == -1) {
                this.callbackContext.success(this.croppedUri.toString());
                this.croppedUri = null;
            } else if(var2 == 0) {
                this.failPicture("Camera cancelled.");
            } else {
                this.failPicture("Did not complete!");
            }
        }

        if(var4 == 1) {
            if(var2 != -1) {
                if(var2 == 0) {
                    this.failPicture("Camera cancelled.");
                    return;
                }

                this.failPicture("Did not complete!");
                return;
            }

            try {
                this.processResultFromCamera(var5, var3);
            } catch (IOException var7) {
                var7.printStackTrace();
                this.failPicture("Error capturing image.");
                return;
            }
        } else if(var4 == 0 || var4 == 2) {
            if(var2 == -1 && var3 != null) {
                this.processResultFromGallery(var5, var3);
                return;
            } else if(var2 == 0) {
                this.failPicture("Selection cancelled.");
                return;
            } else {
                this.failPicture("Selection did not complete!");
                return;
            }
        }

    }

    public void onMediaScannerConnected() {
        try {
            this.conn.scanFile(this.scanMe.toString(), "image/*");
        } catch (IllegalStateException var2) {
            LOG.method_4282("CameraLauncher", "Can\'t scan file in MediaScanner after taking picture");
        }
    }

    public void onScanCompleted(String var1, Uri var2) {
        this.conn.disconnect();
    }

    public void processPicture(Bitmap var1) {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();

        try {
            if(var1.compress(CompressFormat.JPEG, this.mQuality, var2)) {
                String var4 = new String(Base64.encode(var2.toByteArray(), 2));
                this.callbackContext.success(var4);
            }
        } catch (Exception var5) {
            this.failPicture("Error compressing image.");
        }

    }

    public void takePicture(int var1, int var2) {
        this.numPics = this.queryImgDB(this.whichContentStore()).getCount();
        Intent var3 = new Intent("android.media.action.IMAGE_CAPTURE");
        File var4 = this.createCaptureFile(var2);
        var3.putExtra("output", Uri.fromFile(var4));
        this.imageUri = Uri.fromFile(var4);
        if(this.cordova != null) {
            this.cordova.startActivityForResult(this, var3, 1 + var1 + 32);
        }

    }
}
