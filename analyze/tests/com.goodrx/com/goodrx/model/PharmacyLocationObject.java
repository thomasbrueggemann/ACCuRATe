package com.goodrx.model;

import android.location.Location;
import android.util.Log;
import com.goodrx.model.DataQ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;

public class PharmacyLocationObject {
   String address;
   String city;
   DataQ data_q;
   String description;
   String discount_description;
   String discount_program_cost;
   String discount_program_disclaimer;
   String discount_program_length;
   String discount_program_name;
   String discount_program_url;
   double distance;
   String fax;
   // $FF: renamed from: id java.lang.String
   String field_454;
   String is_blacklisted;
   String is_valid;
   Double latitude;
   String location;
   Double longitude;
   String nabp_approved;
   String nabp_display_name;
   String name;
   String ncpdp;
   String npi;
   String pharmacy_id;
   String phone;
   String state;
   String store_type;
   String url;
   String url_display;
   String zipcode;

   private String convertTimeRange(String var1) {
      if(!var1.contains("-")) {
         return "0000";
      } else {
         String[] var2 = var1.split("-");
         StringBuilder var3 = new StringBuilder();
         var3.append(this.convertTo24(var2[0]));
         var3.append(this.convertTo24(var2[1]));
         return var3.toString();
      }
   }

   private String convertTo24(String var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("hha");
      SimpleDateFormat var3 = new SimpleDateFormat("HH");

      try {
         String var5 = var3.format(var2.parse(var1));
         return var5;
      } catch (ParseException var6) {
         return "00";
      }
   }

   public String getAddress() {
      return this.address;
   }

   public String getCity() {
      return this.city;
   }

   public DataQ getData_q() {
      return this.data_q;
   }

   public String getDescription() {
      return this.description;
   }

   public String getDiscount_description() {
      return this.discount_description;
   }

   public String getDiscount_program_cost() {
      return this.discount_program_cost;
   }

   public String getDiscount_program_disclaimer() {
      return this.discount_program_disclaimer;
   }

   public String getDiscount_program_length() {
      return this.discount_program_length;
   }

   public String getDiscount_program_name() {
      return this.discount_program_name;
   }

   public String getDiscount_program_url() {
      return this.discount_program_url;
   }

   public double getDistance() {
      return this.distance;
   }

   public String getFax() {
      return this.fax;
   }

   public String getFullAddress() {
      return this.address + " " + this.city + ", " + this.state + " " + this.zipcode;
   }

   public String getId() {
      return this.field_454;
   }

   public String getIs_blacklisted() {
      return this.is_blacklisted;
   }

   public String getIs_valid() {
      return this.is_valid;
   }

   public Double getLatitude() {
      return this.latitude;
   }

   public String getLocation() {
      return this.location;
   }

   public Location getLocationObject() {
      Location var1 = new Location("pharmacy_location");
      var1.setLatitude(this.latitude.doubleValue());
      var1.setLongitude(this.longitude.doubleValue());
      return var1;
   }

   public Double getLongitude() {
      return this.longitude;
   }

   public String getNabp_approved() {
      return this.nabp_approved;
   }

   public String getNabp_display_name() {
      return this.nabp_display_name;
   }

   public String getName() {
      return this.name;
   }

   public String getNcpdp() {
      return this.ncpdp;
   }

   public String getNpi() {
      return this.npi;
   }

   public String getPharmacy_id() {
      return this.pharmacy_id;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getState() {
      return this.state;
   }

   public String getStore_type() {
      return this.store_type;
   }

   public String getUrl() {
      return this.url;
   }

   public String getUrl_display() {
      return this.url_display;
   }

   public String getZipcode() {
      return this.zipcode;
   }

   public Map<String, Integer> initIndexMap() {
      HashMap var1 = new HashMap();
      var1.put("mon", Integer.valueOf(0));
      var1.put("tue", Integer.valueOf(1));
      var1.put("wed", Integer.valueOf(2));
      var1.put("thu", Integer.valueOf(3));
      var1.put("fri", Integer.valueOf(4));
      var1.put("sat", Integer.valueOf(5));
      var1.put("sun", Integer.valueOf(6));
      return var1;
   }

   public boolean isOpen() {
      if(this.getData_q() == null) {
         return false;
      } else {
         String[][] var1 = this.getData_q().getHours();
         if(var1 != null && var1.length != 0 && var1[0].length != 0) {
            Map var2 = this.initIndexMap();
            StringBuilder var3 = new StringBuilder();

            for(int var4 = 0; var4 < var1[0].length; ++var4) {
               if(!var1[0][var4].contains("-")) {
                  var3.append(this.convertTimeRange(var1[1][var4]));
               } else {
                  String[] var11 = var1[0][var4].split("-");
                  int var12 = ((Integer)var2.get(var11[0].trim().toLowerCase())).intValue();
                  int var13 = ((Integer)var2.get(var11[1].trim().toLowerCase())).intValue();
                  String var14 = this.convertTimeRange(var1[1][var4]);

                  for(int var15 = var12; var15 <= var13; ++var15) {
                     var3.append(var14);
                  }
               }
            }

            Log.d("goodrx_store_open_time", var3.toString());
            DateTime var6 = new DateTime();
            int var7 = -1 + var6.dayOfWeek().get();
            int var8 = var6.getHourOfDay();
            String var9 = var3.substring(var7 * 4, 4 + var7 * 4);
            int[] var10 = new int[]{Integer.valueOf(var9.substring(0, 2)).intValue(), Integer.valueOf(var9.substring(2)).intValue()};
            if(var10[1] == 0) {
               var10[1] = 24;
            }

            if(var10[0] <= var8 && var10[1] > var8) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }
}
