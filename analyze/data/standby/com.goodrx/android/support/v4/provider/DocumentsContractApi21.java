package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

class DocumentsContractApi21 {
   private static final String TAG = "DocumentFile";

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

   public static Uri createDirectory(Context var0, Uri var1, String var2) {
      return createFile(var0, var1, "vnd.android.document/directory", var2);
   }

   public static Uri createFile(Context var0, Uri var1, String var2, String var3) {
      return DocumentsContract.createDocument(var0.getContentResolver(), var1, var2, var3);
   }

   public static Uri[] listFiles(Context param0, Uri param1) {
      // $FF: Couldn't be decompiled
   }

   public static Uri prepareTreeUri(Uri var0) {
      return DocumentsContract.buildDocumentUriUsingTree(var0, DocumentsContract.getTreeDocumentId(var0));
   }

   public static Uri renameTo(Context var0, Uri var1, String var2) {
      return DocumentsContract.renameDocument(var0.getContentResolver(), var1, var2);
   }
}
