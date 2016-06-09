package android.support.v4.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

class DocumentsContractApi19 {
   private static final String TAG = "DocumentFile";

   public static boolean canRead(Context var0, Uri var1) {
      return var0.checkCallingOrSelfUriPermission(var1, 1) == 0 && !TextUtils.isEmpty(getRawType(var0, var1));
   }

   public static boolean canWrite(Context var0, Uri var1) {
      if(var0.checkCallingOrSelfUriPermission(var1, 2) == 0) {
         String var2 = getRawType(var0, var1);
         int var3 = queryForInt(var0, var1, "flags", 0);
         if(!TextUtils.isEmpty(var2)) {
            if((var3 & 4) != 0) {
               return true;
            }

            if("vnd.android.document/directory".equals(var2) && (var3 & 8) != 0) {
               return true;
            }

            if(!TextUtils.isEmpty(var2) && (var3 & 2) != 0) {
               return true;
            }
         }
      }

      return false;
   }

   private static void closeQuietly(AutoCloseable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (RuntimeException var3) {
            throw var3;
         } catch (Exception var4) {
            return;
         }
      }

   }

   public static boolean delete(Context var0, Uri var1) {
      return DocumentsContract.deleteDocument(var0.getContentResolver(), var1);
   }

   public static boolean exists(Context var0, Uri var1) {
      ContentResolver var2 = var0.getContentResolver();
      Cursor var3 = null;
      boolean var11 = false;

      int var7;
      label49: {
         try {
            var11 = true;
            var3 = var2.query(var1, new String[]{"document_id"}, (String)null, (String[])null, (String)null);
            var7 = var3.getCount();
            var11 = false;
            break label49;
         } catch (Exception var12) {
            Log.w("DocumentFile", "Failed query: " + var12);
            var11 = false;
         } finally {
            if(var11) {
               closeQuietly(var3);
            }
         }

         closeQuietly(var3);
         return false;
      }

      boolean var8;
      if(var7 > 0) {
         var8 = true;
      } else {
         var8 = false;
      }

      closeQuietly(var3);
      return var8;
   }

   public static String getName(Context var0, Uri var1) {
      return queryForString(var0, var1, "_display_name", (String)null);
   }

   private static String getRawType(Context var0, Uri var1) {
      return queryForString(var0, var1, "mime_type", (String)null);
   }

   public static String getType(Context var0, Uri var1) {
      String var2 = getRawType(var0, var1);
      if("vnd.android.document/directory".equals(var2)) {
         var2 = null;
      }

      return var2;
   }

   public static boolean isDirectory(Context var0, Uri var1) {
      return "vnd.android.document/directory".equals(getRawType(var0, var1));
   }

   public static boolean isDocumentUri(Context var0, Uri var1) {
      return DocumentsContract.isDocumentUri(var0, var1);
   }

   public static boolean isFile(Context var0, Uri var1) {
      String var2 = getRawType(var0, var1);
      return !"vnd.android.document/directory".equals(var2) && !TextUtils.isEmpty(var2);
   }

   public static long lastModified(Context var0, Uri var1) {
      return queryForLong(var0, var1, "last_modified", 0L);
   }

   public static long length(Context var0, Uri var1) {
      return queryForLong(var0, var1, "_size", 0L);
   }

   private static int queryForInt(Context var0, Uri var1, String var2, int var3) {
      return (int)queryForLong(var0, var1, var2, (long)var3);
   }

   private static long queryForLong(Context var0, Uri var1, String var2, long var3) {
      ContentResolver var5 = var0.getContentResolver();
      Cursor var6 = null;

      try {
         var6 = var5.query(var1, new String[]{var2}, (String)null, (String[])null, (String)null);
         if(var6.moveToFirst() && !var6.isNull(0)) {
            long var10 = var6.getLong(0);
            return var10;
         }

         return var3;
      } catch (Exception var14) {
         Log.w("DocumentFile", "Failed query: " + var14);
      } finally {
         closeQuietly(var6);
      }

      return var3;
   }

   private static String queryForString(Context var0, Uri var1, String var2, String var3) {
      ContentResolver var4 = var0.getContentResolver();
      Cursor var5 = null;

      try {
         var5 = var4.query(var1, new String[]{var2}, (String)null, (String[])null, (String)null);
         if(var5.moveToFirst() && !var5.isNull(0)) {
            String var9 = var5.getString(0);
            return var9;
         }

         return var3;
      } catch (Exception var12) {
         Log.w("DocumentFile", "Failed query: " + var12);
      } finally {
         closeQuietly(var5);
      }

      return var3;
   }
}
