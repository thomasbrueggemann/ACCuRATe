package com.mobileapptracker;

import com.mobileapptracker.MATEncryption;
import com.mobileapptracker.MATEvent;
import com.mobileapptracker.MATParameters;
import com.mobileapptracker.MATPreloadData;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

class MATUrlBuilder {
   private static MATParameters params;

   public static JSONObject buildBody(JSONArray param0, String param1, String param2, JSONArray param3) {
      // $FF: Couldn't be decompiled
   }

   public static String buildDataUnencrypted(MATEvent param0) {
      // $FF: Couldn't be decompiled
   }

   public static String buildLink(MATEvent var0, MATPreloadData var1, boolean var2) {
      params = MATParameters.getInstance();
      StringBuilder var3 = (new StringBuilder("https://")).append(params.getAdvertiserId()).append(".");
      if(var2) {
         var3.append("debug.engine.mobileapptracking.com");
      } else {
         var3.append("engine.mobileapptracking.com");
      }

      var3.append("/serve?ver=").append(params.getSdkVersion());
      var3.append("&transaction_id=").append(UUID.randomUUID().toString());
      safeAppend(var3, "sdk", "android");
      safeAppend(var3, "action", params.getAction());
      safeAppend(var3, "advertiser_id", params.getAdvertiserId());
      safeAppend(var3, "package_name", params.getPackageName());
      safeAppend(var3, "referral_source", params.getReferralSource());
      safeAppend(var3, "referral_url", params.getReferralUrl());
      safeAppend(var3, "site_id", params.getSiteId());
      safeAppend(var3, "tracking_id", params.getTrackingId());
      if(var0.getEventId() != 0) {
         safeAppend(var3, "site_event_id", Integer.toString(var0.getEventId()));
      }

      if(!params.getAction().equals("session")) {
         safeAppend(var3, "site_event_name", var0.getEventName());
      }

      if(var1 != null) {
         var3.append("&attr_set=1");
         safeAppend(var3, "publisher_id", var1.publisherId);
         safeAppend(var3, "offer_id", var1.offerId);
         safeAppend(var3, "agency_id", var1.agencyId);
         safeAppend(var3, "publisher_ref_id", var1.publisherReferenceId);
         safeAppend(var3, "publisher_sub_publisher", var1.publisherSubPublisher);
         safeAppend(var3, "publisher_sub_site", var1.publisherSubSite);
         safeAppend(var3, "publisher_sub_campaign", var1.publisherSubCampaign);
         safeAppend(var3, "publisher_sub_adgroup", var1.publisherSubAdgroup);
         safeAppend(var3, "publisher_sub_ad", var1.publisherSubAd);
         safeAppend(var3, "publisher_sub_keyword", var1.publisherSubKeyword);
         safeAppend(var3, "advertiser_sub_publisher", var1.advertiserSubPublisher);
         safeAppend(var3, "advertiser_sub_site", var1.advertiserSubSite);
         safeAppend(var3, "advertiser_sub_campaign", var1.advertiserSubCampaign);
         safeAppend(var3, "advertiser_sub_adgroup", var1.advertiserSubAdgroup);
         safeAppend(var3, "advertiser_sub_ad", var1.advertiserSubAd);
         safeAppend(var3, "advertiser_sub_keyword", var1.advertiserSubKeyword);
         safeAppend(var3, "publisher_sub1", var1.publisherSub1);
         safeAppend(var3, "publisher_sub2", var1.publisherSub2);
         safeAppend(var3, "publisher_sub3", var1.publisherSub3);
         safeAppend(var3, "publisher_sub4", var1.publisherSub4);
         safeAppend(var3, "publisher_sub5", var1.publisherSub5);
      }

      String var7 = params.getAllowDuplicates();
      if(var7 != null && Integer.parseInt(var7) == 1) {
         var3.append("&skip_dup=1");
      }

      if(var2) {
         var3.append("&debug=1");
      }

      return var3.toString();
   }

   private static void safeAppend(StringBuilder param0, String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public static String updateAndEncryptData(String param0, MATEncryption param1) {
      // $FF: Couldn't be decompiled
   }
}
