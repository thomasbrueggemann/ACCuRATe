package com.goodrx.model;

import android.app.Activity;
import com.goodrx.activity.price.RxPriceActivity;
import com.goodrx.model.GlobalSearchableItem;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;

public class MyRx implements GlobalSearchableItem {
   public static final int MYRX_STATUS_FAILED = 2;
   public static final int MYRX_STATUS_NORMAL = 0;
   public static final int MYRX_STATUS_PROCESSING = 1;
   private MyRx.Drug drug;
   private String folderPath;
   private boolean highlight;
   private MyRx.PreferredPharmacy preferred_pharmacy;
   private MyRx.Reminder reminder;
   private MyRx.Slug slug;
   private int status;

   public MyRx() {
      this.status = 0;
   }

   public MyRx(int var1) {
      this.status = var1;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof MyRx)) {
         return false;
      } else {
         MyRx var2 = (MyRx)var1;
         return this.drug.drug_id.equals(var2.getDrug().getDrug_id());
      }
   }

   public String getDisplay() {
      String var1;
      if(this.drug.selected_drug.equalsIgnoreCase(this.drug.getBrand())) {
         var1 = this.drug.getSelected_drug() + " (brand drug)";
      } else {
         var1 = this.drug.getSelected_drug();
         String var2 = this.drug.getBrand();
         if(var2 != null && var2.length() > 0) {
            return var1 + " (generic " + var2 + ")";
         }
      }

      return var1;
   }

   public MyRx.Drug getDrug() {
      return this.drug;
   }

   public String getFolderPath() {
      return this.folderPath;
   }

   public MyRx.PreferredPharmacy getPreferredPharmacy() {
      return this.preferred_pharmacy;
   }

   public MyRx.Reminder getReminder() {
      return this.reminder;
   }

   public String getSearchDisplay() {
      return this.getDisplay();
   }

   public String getSearchType() {
      return MyRx.class.getName();
   }

   public MyRx.Slug getSlug() {
      return this.slug;
   }

   public int getStatus() {
      return this.status;
   }

   public boolean isHighlight() {
      return this.highlight;
   }

   public void onClick(Activity var1) {
      Gson var2 = new Gson();
      String var3;
      if(!(var2 instanceof Gson)) {
         var3 = var2.toJson((Object)this);
      } else {
         var3 = GsonInstrumentation.toJson((Gson)var2, (Object)this);
      }

      RxPriceActivity.launch(var1, var3);
   }

   public void setFolderPath(String var1) {
      this.folderPath = var1;
   }

   public void setHighlight(boolean var1) {
      this.highlight = var1;
   }

   public void setStatus(int var1) {
      this.status = var1;
   }

   public class Drug {
      private String brand;
      private boolean considered;
      private String dosage;
      private String drug_form;
      private String drug_id;
      private String generic;
      private String image;
      private Double low_price;
      private int position;
      private String qty_form;
      private int quantity;
      private String selected_drug;

      public String getAmount() {
         return this.qty_form + " " + this.dosage;
      }

      public String getBrand() {
         return this.brand;
      }

      public String getDosage() {
         return this.dosage;
      }

      public String getDrug_form() {
         return this.drug_form;
      }

      public String getDrug_id() {
         return this.drug_id;
      }

      public String getGeneric() {
         return this.generic;
      }

      public String getImage() {
         return this.image == null?"":this.image;
      }

      public Double getLow_price() {
         return this.low_price;
      }

      public int getPosition() {
         return this.position;
      }

      public String getQty_form() {
         return this.qty_form;
      }

      public int getQuantity() {
         return this.quantity;
      }

      public String getSelected_drug() {
         return this.selected_drug;
      }

      public boolean isConsidered() {
         return this.considered;
      }

      public void setConsidered(Boolean var1) {
         this.considered = var1.booleanValue();
      }

      public void setImage(String var1) {
         this.image = var1;
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface MyRxStatus {
   }

   public class PreferredPharmacy {
      private double distance;
      private String name;
      private String pharm_id;
      private Double price;

      public double getDistance() {
         return this.distance;
      }

      public String getName() {
         return this.name;
      }

      public String getPharm_id() {
         return this.pharm_id;
      }

      public Double getPrice() {
         return this.price;
      }
   }

   public class Reminder {
      private boolean active;
      private int interval;
      private String next_date;
      private String time_of_day;

      public DateTime getCombinedNextDate() {
         String[] var1 = this.time_of_day.split(":");
         int var2 = Integer.valueOf(var1[0]).intValue();
         int var3 = Integer.valueOf(var1[1]).intValue();
         MutableDateTime var4 = new MutableDateTime(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").withZoneUTC().parseDateTime(this.next_date).toDateTime(DateTimeZone.getDefault()));
         var4.setHourOfDay(var2);
         var4.setMinuteOfHour(var3);
         return var4.toDateTime();
      }

      public int getDayLeft() {
         return Days.daysBetween((ReadableInstant)(new DateTime(new Date(), DateTimeZone.getDefault())).withTimeAtStartOfDay(), (ReadableInstant)this.getCombinedNextDate().withTimeAtStartOfDay()).getDays();
      }

      public String getFormatedNextDate(String var1) {
         return DateTimeFormat.forPattern(var1).print((ReadableInstant)this.getCombinedNextDate());
      }

      public int getInterval() {
         return this.interval;
      }

      public String getNext_date() {
         return this.next_date;
      }

      public String getTime_of_day() {
         return this.time_of_day;
      }

      public boolean isActive() {
         return this.active;
      }

      public boolean isOverdue() {
         return this.getDayLeft() <= 0;
      }

      public void rescheduleNextDate(int var1) {
         DateTime var2 = (new DateTime(new Date(), DateTimeZone.getDefault())).plusDays(var1);
         int var3 = var2.getYear();
         int var4 = var2.getMonthOfYear();
         int var5 = var2.getDayOfMonth();
         String[] var6 = this.time_of_day.split(":");
         DateTime var7 = (new DateTime(var3, var4, var5, Integer.valueOf(var6[0]).intValue(), Integer.valueOf(var6[1]).intValue(), DateTimeZone.getDefault())).toDateTime(DateTimeZone.UTC);
         this.setNext_date(var7.getYear(), var7.getMonthOfYear(), var7.getDayOfMonth(), var7.getHourOfDay(), var7.getMinuteOfHour());
      }

      public void setActive(boolean var1) {
         this.active = var1;
      }

      public void setInterval(int var1) {
         this.interval = var1;
      }

      public void setNext_date(int var1, int var2, int var3, int var4, int var5) {
         this.next_date = var1 + "-" + var2 + "-" + var3 + " " + var4 + ":" + var5;
      }

      public void setTime_of_day(int var1, int var2) {
         this.time_of_day = var1 + ":" + var2;
      }
   }

   public class Slug {
      private String dosage;
      private String drug;
      private String drug_form;

      public String getDosage() {
         return this.dosage;
      }

      public String getDrug() {
         return this.drug;
      }

      public String getDrug_form() {
         return this.drug_form;
      }
   }
}
