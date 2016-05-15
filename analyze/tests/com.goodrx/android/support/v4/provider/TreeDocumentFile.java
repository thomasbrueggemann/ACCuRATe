package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.support.v4.provider.DocumentFile;
import android.support.v4.provider.DocumentsContractApi19;
import android.support.v4.provider.DocumentsContractApi21;

class TreeDocumentFile extends DocumentFile {
   private Context mContext;
   private Uri mUri;

   TreeDocumentFile(DocumentFile var1, Context var2, Uri var3) {
      super(var1);
      this.mContext = var2;
      this.mUri = var3;
   }

   public boolean canRead() {
      return DocumentsContractApi19.canRead(this.mContext, this.mUri);
   }

   public boolean canWrite() {
      return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
   }

   public DocumentFile createDirectory(String var1) {
      Uri var2 = DocumentsContractApi21.createDirectory(this.mContext, this.mUri, var1);
      return var2 != null?new TreeDocumentFile(this, this.mContext, var2):null;
   }

   public DocumentFile createFile(String var1, String var2) {
      Uri var3 = DocumentsContractApi21.createFile(this.mContext, this.mUri, var1, var2);
      return var3 != null?new TreeDocumentFile(this, this.mContext, var3):null;
   }

   public boolean delete() {
      return DocumentsContractApi19.delete(this.mContext, this.mUri);
   }

   public boolean exists() {
      return DocumentsContractApi19.exists(this.mContext, this.mUri);
   }

   public String getName() {
      return DocumentsContractApi19.getName(this.mContext, this.mUri);
   }

   public String getType() {
      return DocumentsContractApi19.getType(this.mContext, this.mUri);
   }

   public Uri getUri() {
      return this.mUri;
   }

   public boolean isDirectory() {
      return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
   }

   public boolean isFile() {
      return DocumentsContractApi19.isFile(this.mContext, this.mUri);
   }

   public long lastModified() {
      return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
   }

   public long length() {
      return DocumentsContractApi19.length(this.mContext, this.mUri);
   }

   public DocumentFile[] listFiles() {
      Uri[] var1 = DocumentsContractApi21.listFiles(this.mContext, this.mUri);
      DocumentFile[] var2 = new DocumentFile[var1.length];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2[var3] = new TreeDocumentFile(this, this.mContext, var1[var3]);
      }

      return var2;
   }

   public boolean renameTo(String var1) {
      Uri var2 = DocumentsContractApi21.renameTo(this.mContext, this.mUri, var1);
      if(var2 != null) {
         this.mUri = var2;
         return true;
      } else {
         return false;
      }
   }
}
