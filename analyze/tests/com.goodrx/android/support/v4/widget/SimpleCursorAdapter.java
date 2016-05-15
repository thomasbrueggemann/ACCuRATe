package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.ResourceCursorAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
   private SimpleCursorAdapter.CursorToStringConverter mCursorToStringConverter;
   protected int[] mFrom;
   String[] mOriginalFrom;
   private int mStringConversionColumn = -1;
   protected int[] mTo;
   private SimpleCursorAdapter.ViewBinder mViewBinder;

   @Deprecated
   public SimpleCursorAdapter(Context var1, int var2, Cursor var3, String[] var4, int[] var5) {
      super(var1, var2, var3);
      this.mTo = var5;
      this.mOriginalFrom = var4;
      this.findColumns(var4);
   }

   public SimpleCursorAdapter(Context var1, int var2, Cursor var3, String[] var4, int[] var5, int var6) {
      super(var1, var2, var3, var6);
      this.mTo = var5;
      this.mOriginalFrom = var4;
      this.findColumns(var4);
   }

   private void findColumns(String[] var1) {
      if(this.mCursor != null) {
         int var2 = var1.length;
         if(this.mFrom == null || this.mFrom.length != var2) {
            this.mFrom = new int[var2];
         }

         for(int var3 = 0; var3 < var2; ++var3) {
            this.mFrom[var3] = this.mCursor.getColumnIndexOrThrow(var1[var3]);
         }
      } else {
         this.mFrom = null;
      }

   }

   public void bindView(View var1, Context var2, Cursor var3) {
      SimpleCursorAdapter.ViewBinder var4 = this.mViewBinder;
      int var5 = this.mTo.length;
      int[] var6 = this.mFrom;
      int[] var7 = this.mTo;

      for(int var8 = 0; var8 < var5; ++var8) {
         View var9 = var1.findViewById(var7[var8]);
         if(var9 != null) {
            boolean var10 = false;
            if(var4 != null) {
               var10 = var4.setViewValue(var9, var3, var6[var8]);
            }

            if(!var10) {
               String var11 = var3.getString(var6[var8]);
               if(var11 == null) {
                  var11 = "";
               }

               if(var9 instanceof TextView) {
                  this.setViewText((TextView)var9, var11);
               } else {
                  if(!(var9 instanceof ImageView)) {
                     throw new IllegalStateException(var9.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                  }

                  this.setViewImage((ImageView)var9, var11);
               }
            }
         }
      }

   }

   public void changeCursorAndColumns(Cursor var1, String[] var2, int[] var3) {
      this.mOriginalFrom = var2;
      this.mTo = var3;
      super.changeCursor(var1);
      this.findColumns(this.mOriginalFrom);
   }

   public CharSequence convertToString(Cursor var1) {
      return (CharSequence)(this.mCursorToStringConverter != null?this.mCursorToStringConverter.convertToString(var1):(this.mStringConversionColumn > -1?var1.getString(this.mStringConversionColumn):super.convertToString(var1)));
   }

   public SimpleCursorAdapter.CursorToStringConverter getCursorToStringConverter() {
      return this.mCursorToStringConverter;
   }

   public int getStringConversionColumn() {
      return this.mStringConversionColumn;
   }

   public SimpleCursorAdapter.ViewBinder getViewBinder() {
      return this.mViewBinder;
   }

   public void setCursorToStringConverter(SimpleCursorAdapter.CursorToStringConverter var1) {
      this.mCursorToStringConverter = var1;
   }

   public void setStringConversionColumn(int var1) {
      this.mStringConversionColumn = var1;
   }

   public void setViewBinder(SimpleCursorAdapter.ViewBinder var1) {
      this.mViewBinder = var1;
   }

   public void setViewImage(ImageView var1, String var2) {
      try {
         var1.setImageResource(Integer.parseInt(var2));
      } catch (NumberFormatException var4) {
         var1.setImageURI(Uri.parse(var2));
      }
   }

   public void setViewText(TextView var1, String var2) {
      var1.setText(var2);
   }

   public Cursor swapCursor(Cursor var1) {
      Cursor var2 = super.swapCursor(var1);
      this.findColumns(this.mOriginalFrom);
      return var2;
   }

   public interface CursorToStringConverter {
      CharSequence convertToString(Cursor var1);
   }

   public interface ViewBinder {
      boolean setViewValue(View var1, Cursor var2, int var3);
   }
}
