package com.goodrx.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.goodrx.model.Notice;
import org.parceler.ParcelWrapper;

public class Notice$$Parcelable implements Parcelable, ParcelWrapper<Notice> {
   public static final Notice$$Parcelable.Creator$$6 CREATOR = new Notice$$Parcelable.Creator$$6();
   private Notice notice$$0;

   public Notice$$Parcelable(Parcel var1) {
      Notice var2;
      if(var1.readInt() == -1) {
         var2 = null;
      } else {
         var2 = this.readcom_goodrx_model_Notice(var1);
      }

      this.notice$$0 = var2;
   }

   public Notice$$Parcelable(Notice var1) {
      this.notice$$0 = var1;
   }

   private Notice readcom_goodrx_model_Notice(Parcel var1) {
      Notice var2 = new Notice();
      var2.short_description = var1.readString();
      var2.tip_category = var1.readString();
      var2.link = var1.readString();
      var2.icon = var1.readString();
      var2.name = var1.readString();
      var2.tip_type = var1.readString();
      var2.long_description = var1.readString();
      var2.title = var1.readString();
      var2.link_text = var1.readString();
      var2.slug = var1.readString();
      return var2;
   }

   private void writecom_goodrx_model_Notice(Notice var1, Parcel var2, int var3) {
      var2.writeString(var1.short_description);
      var2.writeString(var1.tip_category);
      var2.writeString(var1.link);
      var2.writeString(var1.icon);
      var2.writeString(var1.name);
      var2.writeString(var1.tip_type);
      var2.writeString(var1.long_description);
      var2.writeString(var1.title);
      var2.writeString(var1.link_text);
      var2.writeString(var1.slug);
   }

   public int describeContents() {
      return 0;
   }

   public Notice getParcel() {
      return this.notice$$0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.notice$$0 == null) {
         var1.writeInt(-1);
      } else {
         var1.writeInt(1);
         this.writecom_goodrx_model_Notice(this.notice$$0, var1, var2);
      }
   }

   public static final class Creator$$6 implements Creator<Notice$$Parcelable> {
      public Notice$$Parcelable createFromParcel(Parcel var1) {
         return new Notice$$Parcelable(var1);
      }

      public Notice$$Parcelable[] newArray(int var1) {
         return new Notice$$Parcelable[var1];
      }
   }
}
