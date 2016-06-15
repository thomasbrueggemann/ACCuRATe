package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
   Cursor mCursor;
   final Loader<Cursor>.ForceLoadContentObserver mObserver = new Loader.ForceLoadContentObserver();
   String[] mProjection;
   String mSelection;
   String[] mSelectionArgs;
   String mSortOrder;
   Uri mUri;

   public CursorLoader(Context var1) {
      super(var1);
   }

   public CursorLoader(Context var1, Uri var2, String[] var3, String var4, String[] var5, String var6) {
      super(var1);
      this.mUri = var2;
      this.mProjection = var3;
      this.mSelection = var4;
      this.mSelectionArgs = var5;
      this.mSortOrder = var6;
   }

   public void deliverResult(Cursor var1) {
      if(this.isReset()) {
         if(var1 != null) {
            var1.close();
         }
      } else {
         Cursor var2 = this.mCursor;
         this.mCursor = var1;
         if(this.isStarted()) {
            super.deliverResult(var1);
         }

         if(var2 != null && var2 != var1 && !var2.isClosed()) {
            var2.close();
            return;
         }
      }

   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      super.dump(var1, var2, var3, var4);
      var3.print(var1);
      var3.print("mUri=");
      var3.println(this.mUri);
      var3.print(var1);
      var3.print("mProjection=");
      var3.println(Arrays.toString(this.mProjection));
      var3.print(var1);
      var3.print("mSelection=");
      var3.println(this.mSelection);
      var3.print(var1);
      var3.print("mSelectionArgs=");
      var3.println(Arrays.toString(this.mSelectionArgs));
      var3.print(var1);
      var3.print("mSortOrder=");
      var3.println(this.mSortOrder);
      var3.print(var1);
      var3.print("mCursor=");
      var3.println(this.mCursor);
      var3.print(var1);
      var3.print("mContentChanged=");
      var3.println(this.mContentChanged);
   }

   public String[] getProjection() {
      return this.mProjection;
   }

   public String getSelection() {
      return this.mSelection;
   }

   public String[] getSelectionArgs() {
      return this.mSelectionArgs;
   }

   public String getSortOrder() {
      return this.mSortOrder;
   }

   public Uri getUri() {
      return this.mUri;
   }

   public Cursor loadInBackground() {
      Cursor var1 = this.getContext().getContentResolver().query(this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder);
      if(var1 != null) {
         var1.getCount();
         var1.registerContentObserver(this.mObserver);
      }

      return var1;
   }

   public void onCanceled(Cursor var1) {
      if(var1 != null && !var1.isClosed()) {
         var1.close();
      }

   }

   protected void onReset() {
      super.onReset();
      this.onStopLoading();
      if(this.mCursor != null && !this.mCursor.isClosed()) {
         this.mCursor.close();
      }

      this.mCursor = null;
   }

   protected void onStartLoading() {
      if(this.mCursor != null) {
         this.deliverResult(this.mCursor);
      }

      if(this.takeContentChanged() || this.mCursor == null) {
         this.forceLoad();
      }

   }

   protected void onStopLoading() {
      this.cancelLoad();
   }

   public void setProjection(String[] var1) {
      this.mProjection = var1;
   }

   public void setSelection(String var1) {
      this.mSelection = var1;
   }

   public void setSelectionArgs(String[] var1) {
      this.mSelectionArgs = var1;
   }

   public void setSortOrder(String var1) {
      this.mSortOrder = var1;
   }

   public void setUri(Uri var1) {
      this.mUri = var1;
   }
}
