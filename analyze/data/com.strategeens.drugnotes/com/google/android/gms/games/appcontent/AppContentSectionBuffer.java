package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.appcontent.AppContentSection;
import com.google.android.gms.games.appcontent.AppContentSectionRef;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends g<AppContentSection> {
   // $FF: renamed from: XX java.util.ArrayList
   private final ArrayList<DataHolder> field_1605;

   // $FF: renamed from: f (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2987(int var1, int var2) {
      return this.method_2998(var1, var2);
   }

   // $FF: renamed from: h (int, int) com.google.android.gms.games.appcontent.AppContentSection
   protected AppContentSection method_2998(int var1, int var2) {
      return new AppContentSectionRef(this.field_1605, var1, var2);
   }

   // $FF: renamed from: ha () java.lang.String
   protected String method_2988() {
      return "section_id";
   }

   // $FF: renamed from: hc () java.lang.String
   protected String method_2989() {
      return "card_id";
   }

   public void release() {
      super.release();
      int var1 = this.field_1605.size();

      for(int var2 = 1; var2 < var1; ++var2) {
         DataHolder var3 = (DataHolder)this.field_1605.get(var2);
         if(var3 != null) {
            var3.close();
         }
      }

   }
}
