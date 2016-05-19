package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class CursorFilter extends Filter {
   CursorFilter.CursorFilterClient mClient;

   CursorFilter(CursorFilter.CursorFilterClient var1) {
      this.mClient = var1;
   }

   public CharSequence convertResultToString(Object var1) {
      return this.mClient.convertToString((Cursor)var1);
   }

   protected FilterResults performFiltering(CharSequence var1) {
      Cursor var2 = this.mClient.runQueryOnBackgroundThread(var1);
      FilterResults var3 = new FilterResults();
      if(var2 != null) {
         var3.count = var2.getCount();
         var3.values = var2;
         return var3;
      } else {
         var3.count = 0;
         var3.values = null;
         return var3;
      }
   }

   protected void publishResults(CharSequence var1, FilterResults var2) {
      Cursor var3 = this.mClient.getCursor();
      if(var2.values != null && var2.values != var3) {
         this.mClient.changeCursor((Cursor)var2.values);
      }

   }

   interface CursorFilterClient {
      void changeCursor(Cursor var1);

      CharSequence convertToString(Cursor var1);

      Cursor getCursor();

      Cursor runQueryOnBackgroundThread(CharSequence var1);
   }
}
