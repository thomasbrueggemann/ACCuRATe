package com.goodrx.utils;

import android.content.Context;
import com.goodrx.model.DrugDetail;
import com.goodrx.model.RecentSearch;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HistoryRecordOperator {
   public static File SEARCH_HISTORY_FILE;
   public static final String SEARCH_HISTORY_FILE_NAME = "search_history";

   public static void deleteAll(Context var0) {
      save(new ArrayList(), var0);
   }

   public static List<RecentSearch> getAll(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static List<DrugDetail> getDrugDetailList(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private static File getHistoryFile(Context var0) {
      if(SEARCH_HISTORY_FILE != null) {
         return SEARCH_HISTORY_FILE;
      } else {
         SEARCH_HISTORY_FILE = new File(var0.getFilesDir(), "search_history");
         return SEARCH_HISTORY_FILE;
      }
   }

   private static int getIndex(List<RecentSearch> var0, RecentSearch var1) {
      for(int var2 = 0; var2 < var0.size(); ++var2) {
         if(((RecentSearch)var0.get(var2)).equals(var1)) {
            return var2;
         }
      }

      return -1;
   }

   public static void save(List<RecentSearch> param0, Context param1) {
      // $FF: Couldn't be decompiled
   }

   public static void update(RecentSearch var0, Context var1) {
      List var2 = getAll(var1);
      int var3 = getIndex(var2, var0);
      if(var3 != -1) {
         var2.remove(var3);
      }

      var2.add(0, var0);
      save(var2, var1);
   }
}
