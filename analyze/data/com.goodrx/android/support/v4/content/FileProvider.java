package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
   private static final String ATTR_NAME = "name";
   private static final String ATTR_PATH = "path";
   private static final String[] COLUMNS = new String[]{"_display_name", "_size"};
   private static final File DEVICE_ROOT = new File("/");
   private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
   private static final String TAG_CACHE_PATH = "cache-path";
   private static final String TAG_EXTERNAL = "external-path";
   private static final String TAG_FILES_PATH = "files-path";
   private static final String TAG_ROOT_PATH = "root-path";
   private static HashMap<String, FileProvider.PathStrategy> sCache = new HashMap();
   private FileProvider.PathStrategy mStrategy;

   private static File buildPath(File var0, String... var1) {
      int var2 = var1.length;
      int var3 = 0;

      File var4;
      File var6;
      for(var4 = var0; var3 < var2; var4 = var6) {
         String var5 = var1[var3];
         if(var5 != null) {
            var6 = new File(var4, var5);
         } else {
            var6 = var4;
         }

         ++var3;
      }

      return var4;
   }

   private static Object[] copyOf(Object[] var0, int var1) {
      Object[] var2 = new Object[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   private static String[] copyOf(String[] var0, int var1) {
      String[] var2 = new String[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   private static FileProvider.PathStrategy getPathStrategy(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static Uri getUriForFile(Context var0, String var1, File var2) {
      return getPathStrategy(var0, var1).getUriForFile(var2);
   }

   private static int modeToMode(String var0) {
      if("r".equals(var0)) {
         return 268435456;
      } else if(!"w".equals(var0) && !"wt".equals(var0)) {
         if("wa".equals(var0)) {
            return 704643072;
         } else if("rw".equals(var0)) {
            return 939524096;
         } else if("rwt".equals(var0)) {
            return 1006632960;
         } else {
            throw new IllegalArgumentException("Invalid mode: " + var0);
         }
      } else {
         return 738197504;
      }
   }

   private static FileProvider.PathStrategy parsePathStrategy(Context var0, String var1) throws IOException, XmlPullParserException {
      FileProvider.SimplePathStrategy var2 = new FileProvider.SimplePathStrategy(var1);
      XmlResourceParser var3 = var0.getPackageManager().resolveContentProvider(var1, 128).loadXmlMetaData(var0.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
      if(var3 == null) {
         throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
      } else {
         while(true) {
            int var4 = var3.next();
            if(var4 == 1) {
               return var2;
            }

            if(var4 == 2) {
               String var5 = var3.getName();
               String var6 = var3.getAttributeValue((String)null, "name");
               String var7 = var3.getAttributeValue((String)null, "path");
               File var9;
               if("root-path".equals(var5)) {
                  var9 = buildPath(DEVICE_ROOT, new String[]{var7});
               } else if("files-path".equals(var5)) {
                  var9 = buildPath(var0.getFilesDir(), new String[]{var7});
               } else if("cache-path".equals(var5)) {
                  var9 = buildPath(var0.getCacheDir(), new String[]{var7});
               } else {
                  boolean var8 = "external-path".equals(var5);
                  var9 = null;
                  if(var8) {
                     var9 = buildPath(Environment.getExternalStorageDirectory(), new String[]{var7});
                  }
               }

               if(var9 != null) {
                  var2.addRoot(var6, var9);
               }
            }
         }
      }
   }

   public void attachInfo(Context var1, ProviderInfo var2) {
      super.attachInfo(var1, var2);
      if(var2.exported) {
         throw new SecurityException("Provider must not be exported");
      } else if(!var2.grantUriPermissions) {
         throw new SecurityException("Provider must grant uri permissions");
      } else {
         this.mStrategy = getPathStrategy(var1, var2.authority);
      }
   }

   public int delete(Uri var1, String var2, String[] var3) {
      return this.mStrategy.getFileForUri(var1).delete()?1:0;
   }

   public String getType(Uri var1) {
      File var2 = this.mStrategy.getFileForUri(var1);
      int var3 = var2.getName().lastIndexOf(46);
      if(var3 >= 0) {
         String var4 = var2.getName().substring(var3 + 1);
         String var5 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var4);
         if(var5 != null) {
            return var5;
         }
      }

      return "application/octet-stream";
   }

   public Uri insert(Uri var1, ContentValues var2) {
      throw new UnsupportedOperationException("No external inserts");
   }

   public boolean onCreate() {
      return true;
   }

   public ParcelFileDescriptor openFile(Uri var1, String var2) throws FileNotFoundException {
      return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(var1), modeToMode(var2));
   }

   public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5) {
      File var6 = this.mStrategy.getFileForUri(var1);
      if(var2 == null) {
         var2 = COLUMNS;
      }

      String[] var7 = new String[var2.length];
      Object[] var8 = new Object[var2.length];
      String[] var9 = var2;
      int var10 = var2.length;
      int var11 = 0;

      int var17;
      int var12;
      for(var12 = 0; var11 < var10; var12 = var17) {
         String var16 = var9[var11];
         if("_display_name".equals(var16)) {
            var7[var12] = "_display_name";
            var17 = var12 + 1;
            var8[var12] = var6.getName();
         } else if("_size".equals(var16)) {
            var7[var12] = "_size";
            var17 = var12 + 1;
            var8[var12] = Long.valueOf(var6.length());
         } else {
            var17 = var12;
         }

         ++var11;
      }

      String[] var13 = copyOf(var7, var12);
      Object[] var14 = copyOf(var8, var12);
      MatrixCursor var15 = new MatrixCursor(var13, 1);
      var15.addRow(var14);
      return var15;
   }

   public int update(Uri var1, ContentValues var2, String var3, String[] var4) {
      throw new UnsupportedOperationException("No external updates");
   }

   interface PathStrategy {
      File getFileForUri(Uri var1);

      Uri getUriForFile(File var1);
   }

   static class SimplePathStrategy implements FileProvider.PathStrategy {
      private final String mAuthority;
      private final HashMap<String, File> mRoots = new HashMap();

      public SimplePathStrategy(String var1) {
         this.mAuthority = var1;
      }

      public void addRoot(String var1, File var2) {
         if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("Name must not be empty");
         } else {
            File var4;
            try {
               var4 = var2.getCanonicalFile();
            } catch (IOException var5) {
               throw new IllegalArgumentException("Failed to resolve canonical path for " + var2, var5);
            }

            this.mRoots.put(var1, var4);
         }
      }

      public File getFileForUri(Uri var1) {
         String var2 = var1.getEncodedPath();
         int var3 = var2.indexOf(47, 1);
         String var4 = Uri.decode(var2.substring(1, var3));
         String var5 = Uri.decode(var2.substring(var3 + 1));
         File var6 = (File)this.mRoots.get(var4);
         if(var6 == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + var1);
         } else {
            File var7 = new File(var6, var5);

            File var9;
            try {
               var9 = var7.getCanonicalFile();
            } catch (IOException var10) {
               throw new IllegalArgumentException("Failed to resolve canonical path for " + var7);
            }

            if(!var9.getPath().startsWith(var6.getPath())) {
               throw new SecurityException("Resolved path jumped beyond configured root");
            } else {
               return var9;
            }
         }
      }

      public Uri getUriForFile(File var1) {
         String var3;
         try {
            var3 = var1.getCanonicalPath();
         } catch (IOException var11) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + var1);
         }

         Entry var4 = null;
         Iterator var5 = this.mRoots.entrySet().iterator();

         while(true) {
            Entry var9;
            String var10;
            do {
               do {
                  if(!var5.hasNext()) {
                     if(var4 == null) {
                        throw new IllegalArgumentException("Failed to find configured root that contains " + var3);
                     }

                     String var6 = ((File)var4.getValue()).getPath();
                     String var7;
                     if(var6.endsWith("/")) {
                        var7 = var3.substring(var6.length());
                     } else {
                        var7 = var3.substring(1 + var6.length());
                     }

                     String var8 = Uri.encode((String)var4.getKey()) + '/' + Uri.encode(var7, "/");
                     return (new Builder()).scheme("content").authority(this.mAuthority).encodedPath(var8).build();
                  }

                  var9 = (Entry)var5.next();
                  var10 = ((File)var9.getValue()).getPath();
               } while(!var3.startsWith(var10));
            } while(var4 != null && var10.length() <= ((File)var4.getValue()).getPath().length());

            var4 = var9;
         }
      }
   }
}
