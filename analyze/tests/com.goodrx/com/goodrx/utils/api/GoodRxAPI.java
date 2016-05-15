package com.goodrx.utils.api;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.goodrx.model.BestPharmacy;
import com.goodrx.model.Condition;
import com.goodrx.model.DrugEducation;
import com.goodrx.model.ImageResult;
import com.goodrx.model.ImprintResult;
import com.goodrx.model.Key;
import com.goodrx.model.LocationEntity;
import com.goodrx.model.MyRx;
import com.goodrx.model.News;
import com.goodrx.model.Pharmacy;
import com.goodrx.model.PopularDrug;
import com.goodrx.model.SearchResult;
import com.goodrx.utils.AccountInfoUtils;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.utils.tracker.GAHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import cz.msebera.android.httpclient.Header;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class GoodRxAPI {
   public static final String ABOUT_URL = "https://www.goodrx.com/mobile-api/v3/static-content/about";
   public static final String ADD_RX_URL = "https://www.goodrx.com/mobile-api/tracker-add";
   public static final String AMAZON_URL = "http://www.amazon.com/s/?tag=goo03b-30&field-keywords=";
   public static final String BASE_URL = "https://www.goodrx.com/mobile-api/";
   public static final String BEST_PHARMACY_SETTINGS_URL = "https://www.goodrx.com/mobile-api/best-pharmacy-settings";
   public static final String BEST_PHARMACY_URL = "https://www.goodrx.com/mobile-api/best-pharmacy";
   public static final String BLOG_URL = "https://www.goodrx.com/mobile-api/v3/blog/";
   public static final String CONDITION_CLASS_URL = "https://www.goodrx.com/mobile-api/v3/condition/";
   public static final String CONDITION_LIST_URL = "https://www.goodrx.com/mobile-api/v3/conditions";
   public static final String COUPON_EMAIL_URL = "https://www.goodrx.com/mobile-api/v3/coupon/email";
   public static final String COUPON_TEXT_URL = "https://www.goodrx.com/mobile-api/v3/coupon/text";
   public static final String COUPON_URL = "https://www.goodrx.com/mobile-api/v3/coupon/";
   public static final String DELETE_IMAGE_URL = "https://www.goodrx.com/mobile-api/myrx-remove-image";
   public static final String DRUG_CLASSES_URL = "https://www.goodrx.com/mobile-api/v3/drugclass/";
   public static final String DRUG_DETAIL_URL = "https://www.goodrx.com/mobile-api/v2/details/";
   public static final String DRUG_SEARCH_URL = "https://www.goodrx.com/mobile-api/v3/search";
   public static final String DRUG_URL = "https://www.goodrx.com/mobile-api/v3/drug/";
   public static final String FAQ_URL = "https://www.goodrx.com/mobile-api/v3/static-content/faq";
   public static final String FORGET_PASSWORD = "https://www.goodrx.com/mobile-api/forgot-password";
   public static final String GET_RX_URL = "https://www.goodrx.com/mobile-api/drug-trackers";
   public static final String IMAGE_UPLOAD_URL = "https://www.goodrx.com/mobile-api/myrx-image-upload";
   public static final String IMPRINT_SEARCH_URL = "https://www.goodrx.com/mobile-api/v3/pill-imprint";
   public static final String INFO_URL = "https://www.goodrx.com/mobile-api/v3/drug-education/";
   public static final String MYRX_IMAGE_URL = "https://www.goodrx.com/mobile-api/myrx-user-images";
   public static final String NEWS_URL = "https://www.goodrx.com/mobile-api/v3/drug-news/";
   public static final String PHARMACY_LIST_URL = "https://www.goodrx.com/mobile-api/my-pharmacies";
   public static final String PILL_IDENTIFIER_URL = "https://www.goodrx.com/mobile-api/v3/pill-identifier/";
   public static final String POPULAR_DRUGS = "https://www.goodrx.com/mobile-api/top-drugs";
   public static final String PRICE_URL_V3 = "https://www.goodrx.com/mobile-api/v3/price/";
   public static final String PRIVACY_URL = "https://www.goodrx.com/mobile-api/v3/static-content/privacy";
   public static final String REGISTER_ACCOUNT_URL = "https://www.goodrx.com/mobile-api/register";
   public static final String REGISTER_TOKEN_URL = "https://www.goodrx.com/mobile-api/register-for-token";
   public static final String REMINDER_SETTINGS_URL = "https://www.goodrx.com/mobile-api/tracker-save-reminder";
   public static final String REMOVE_RX_URL = "https://www.goodrx.com/mobile-api/tracker-remove";
   public static final String RX_EDIT_URL = "https://www.goodrx.com/mobile-api/tracker-edit";
   public static final String RX_NOTIFICATION_URL = "https://www.goodrx.com/mobile-api/myrx-notifications";
   public static final String RX_ORDER_URL = "https://www.goodrx.com/mobile-api/order-drug-trackers";
   public static final String SAVE_RX_DEFAULT_IMAGE_URL = "https://www.goodrx.com/mobile-api/myrx-save-default-image";
   public static final String SAVINGS_URL = "https://www.goodrx.com/mobile-api/v3/drug-tip";
   public static final String SET_LOCATION_URL = "https://www.goodrx.com/mobile-api/v3/location";
   public static final String STORE_PRICE_URL = "https://www.goodrx.com/mobile-api/v3/store/";
   public static final String SYNC_URL = "https://www.goodrx.com/mobile-api/sync-account";
   public static final String TERMS_URL = "https://www.goodrx.com/mobile-api/v3/static-content/terms";
   public static final String V3_BASE_URL = "https://www.goodrx.com/mobile-api/v3/";
   private static GoodRxAPI apiInstance;
   private Gson gson = new Gson();
   private JsonParser jsonParser = new JsonParser();

   public static GoodRxAPI getInstance() {
      if(apiInstance == null) {
         apiInstance = new GoodRxAPI();
      }

      return apiInstance;
   }

   public void addRx(final Activity var1, String var2, int var3, String var4, String var5, final OnRequestFinishListener<String> var6) {
      Key var7 = this.getToken(var1);
      if(var7 != null) {
         RequestParams var8 = new RequestParams();
         var8.add("token", var7.getToken());
         var8.add("token_id", var7.getToken_id());
         var8.add("drug_id", var2);
         var8.add("quantity", String.valueOf(var3));
         if(var4 != null) {
            var8.add("preferred_pharm", var4);
         }

         if(var5 != null) {
            var8.add("drug_image", var5);
         }

         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/tracker-add", var8, new MyResponseHandler(var1) {
            public void onSuccess(String var1x) {
               JsonObject var2 = GoodRxAPI.this.jsonParser.parse(var1x).getAsJsonObject();
               if(!var2.getAsJsonPrimitive("success").getAsBoolean()) {
                  JsonArray var3 = var2.getAsJsonArray("errors");
                  if(var3 != null && var3.size() > 0) {
                     DialogHelper.showErrorDialog(var1, var1.getString(2131427412), var3.get(0).getAsString());
                  }

                  var6.onFailure(0, "error");
               } else {
                  GAHelper.sendGoogleAnalyticsEvent(var1, var1.getString(2131427470), var1.getString(2131427580), (String)null);
                  GAHelper.sendGoogleAnalyticsEvent(var1, var1.getString(2131427469), var1.getString(2131427571), var1.getString(2131427574));
                  var6.onSuccess(var1x);
               }
            }
         });
      }
   }

   public void deleteImage(final Activity var1, String var2, String var3, final OnRequestFinishListener<String> var4) {
      Key var5 = this.getToken(var1);
      if(var5 != null) {
         RequestParams var6 = new RequestParams();
         var6.put("token", var5.getToken());
         var6.put("token_id", var5.getToken_id());
         var6.put("drug_id", var2);
         var6.put("image_id", var3);
         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/myrx-remove-image", var6, new MyResponseHandler(var1) {
            public void onSuccess(String var1) {
               var4.onSuccess(var1);
            }
         });
      }
   }

   public void getBestPharmacy(final Activity var1, final OnRequestFinishListener<BestPharmacy[]> var2) {
      Key var3 = this.getToken(var1);
      if(var3 != null) {
         RequestParams var4 = new RequestParams();
         var4.put("token", var3.getToken());
         var4.put("token_id", var3.getToken_id());
         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/best-pharmacy", var4, new MyResponseHandler(var1) {
            public void onSuccess(String var1) {
               Log.d("goodrx_mbp", var1);
               JsonObject var3 = GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject();
               Gson var4 = GoodRxAPI.this.gson;
               JsonArray var5 = var3.getAsJsonArray("top_pharms");
               Object var6;
               if(!(var4 instanceof Gson)) {
                  var6 = var4.fromJson((JsonElement)var5, (Class)BestPharmacy[].class);
               } else {
                  var6 = GsonInstrumentation.fromJson((Gson)var4, (JsonElement)var5, (Class)BestPharmacy[].class);
               }

               BestPharmacy[] var7 = (BestPharmacy[])var6;
               var2.onSuccess(var7);
            }
         });
      }
   }

   public void getBestPharmacyDistance(final Activity var1, final OnRequestFinishListener<Integer> var2) {
      Key var3 = this.getToken(var1);
      if(var3 != null) {
         RequestParams var4 = new RequestParams();
         var4.add("token", var3.getToken());
         var4.add("token_id", var3.getToken_id());
         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/best-pharmacy-settings", var4, new MyResponseHandler(var1) {
            public void onSuccess(String var1) {
               JsonObject var2x = GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject();

               try {
                  var2x.getAsJsonPrimitive("distance").getAsInt();
                  return;
               } catch (Exception var7) {
                  ;
               } finally {
                  var2.onSuccess(Integer.valueOf(3));
               }

            }
         });
      }
   }

   public void getClassDrugs(final Activity var1, String var2, final OnRequestFinishListener<String> var3) {
      CacheHttpRequestHelper.getInstance().getUsingCache("https://www.goodrx.com/mobile-api/v3/drugclass/" + var2, (RequestParams)null, 86400000L, new MyResponseHandler(var1) {
         public void onSuccess(String var1) {
            var3.onSuccess(var1);
         }
      });
   }

   public void getConditionClass(final Activity var1, String var2, final OnRequestFinishListener<String> var3) {
      CacheHttpRequestHelper.getInstance().getUsingCache("https://www.goodrx.com/mobile-api/v3/condition/" + var2, (RequestParams)null, 2592000000L, new MyResponseHandler(var1) {
         public void onSuccess(String var1) {
            var3.onSuccess(var1);
         }
      });
   }

   public void getConditions(final Activity var1, final OnRequestFinishListener<Condition[]> var2) {
      CacheHttpRequestHelper.getInstance().getUsingCache("https://www.goodrx.com/mobile-api/v3/conditions", (RequestParams)null, 2592000000L, new MyResponseHandler(var1) {
         public void onSuccess(String var1) {
            JsonObject var2x = GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject();
            Gson var3 = new Gson();
            JsonArray var4 = var2x.getAsJsonArray("conditions");
            Object var5;
            if(!(var3 instanceof Gson)) {
               var5 = var3.fromJson((JsonElement)var4, (Class)Condition[].class);
            } else {
               var5 = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var4, (Class)Condition[].class);
            }

            Condition[] var6 = (Condition[])var5;
            var2.onSuccess(var6);
         }
      });
   }

   public void getCouponInfo(final Activity var1, String var2, int var3, String var4, String var5, final OnRequestFinishListener<String> var6) {
      StringBuilder var7 = new StringBuilder("https://www.goodrx.com/mobile-api/v3/coupon/" + var5);
      var7.append("?pharmacy_id=").append(var4);
      var7.append("&drug_id=").append(var2);
      var7.append("&quantity=").append(var3);
      var7.append("&drug_object=1");
      var7.append("&drug_information=1");
      var7.append("&pharmacy_object=1");
      var7.append("&platform=Android");
      var7.append("&version=5.0.4");
      SharedPreferences var16 = var1.getSharedPreferences("ab_test", 0);
      if(var16 != null) {
         String var30 = var16.getString("result", (String)null);
         if(var30 != null) {
            var7.append("&ab=" + var30);
         }
      }

      SharedPreferences var17 = var1.getSharedPreferences("install_info", 0);
      long var18 = var17.getLong("install_date", 0L);
      String var20 = var17.getString("media_source", (String)null);
      String var21 = var17.getString("campaign", "");
      if(var21.length() > 0) {
         var21 = "_" + var21;
      }

      if(var18 > 1L && var20 != null) {
         DateTimeFormatter var25 = DateTimeFormat.forPattern("yyyy-MM-dd");
         DateTime var26 = new DateTime(var18);
         String var27 = var20.trim().replace(' ', '_');
         var21.trim().replace(' ', '_');
         var7.append("&c=" + var26.withDayOfWeek(1).toString(var25) + "_android_" + var27.toLowerCase());
      }

      CacheHttpRequestHelper var22 = CacheHttpRequestHelper.getInstance();
      String var23 = var7.toString();
      MyResponseHandler var24 = new MyResponseHandler(var1) {
         public void onSuccess(String var1) {
            var6.onSuccess(var1);
         }
      };
      var22.get(var23, (RequestParams)null, var24);
   }

   public void getDefaultImages(final Activity var1, String var2, String var3, String var4, final OnRequestFinishListener<ImageResult[]> var5) {
      String var6 = "https://www.goodrx.com/mobile-api/" + var2 + "/images?filter-brand=" + var2 + "&filter-form=" + var4 + "&filter-dosage=" + var3;
      CacheHttpRequestHelper.getInstance().getUsingCache(var6, (RequestParams)null, 2592000000L, new MyResponseHandler(var1) {
         public void onFailure(int var1, Header[] var2, byte[] var3, Throwable var4, String var5x) {
            if(var1 == 404) {
               var5.onFailure(404, "Image Not Found");
            } else {
               super.onFailure(var1, var2, var3, var4, var5x);
            }
         }

         public void onSuccess(String var1) {
            JsonObject var2 = GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject();
            Gson var3 = new Gson();
            JsonArray var4 = var2.getAsJsonArray("image_results");
            Object var5x;
            if(!(var3 instanceof Gson)) {
               var5x = var3.fromJson((JsonElement)var4, (Class)ImageResult[].class);
            } else {
               var5x = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var4, (Class)ImageResult[].class);
            }

            ImageResult[] var6 = (ImageResult[])var5x;
            var5.onSuccess(var6);
         }
      });
   }

   public void getDrugDetail(final Activity var1, String var2, String var3, String var4, Integer var5, boolean var6, final OnRequestFinishListener<String> var7) {
      String var8 = "https://www.goodrx.com/mobile-api/v3/drug/" + var2;
      RequestParams var9 = new RequestParams();
      var9.put("drug_equivalents", "1");
      if(var3 != null) {
         var9.put("form", var3);
      }

      if(var4 != null) {
         var9.put("dosage", var4);
      }

      if(var5 != null) {
         var9.put("quantity", (Object)var5);
      }

      if(var6) {
         var9.add("label_override", var2);
      }

      CacheHttpRequestHelper.getInstance().getUsingCache(var8, var9, 86400000L, new MyResponseHandler(var1) {
         public void onSuccess(String var1) {
            var7.onSuccess(var1);
         }
      });
   }

   public void getDrugDetail(Activity var1, String var2, boolean var3, OnRequestFinishListener<String> var4) {
      this.getDrugDetail(var1, var2, (String)null, (String)null, (Integer)null, var3, var4);
   }

   public void getImageRaw(final Activity var1, String var2, String var3, String var4, Integer var5, final OnRequestFinishListener<String> var6) {
      String var7 = "https://www.goodrx.com/mobile-api/" + var2 + "/images?";
      if(var3 != null) {
         var7 = var7 + "&filter-form=" + var3;
      }

      if(var4 != null) {
         var7 = var7 + "&filter-dosage=" + var4;
      }

      if(var3 != null || var4 != null) {
         var7 = var7 + "&filter-brand=" + var2;
      }

      if(var5 != null) {
         var7 = var7 + "&page=" + var5;
      }

      CacheHttpRequestHelper.getInstance().getUsingCache(var7, (RequestParams)null, 2592000000L, new MyResponseHandler(var1) {
         public void onFailure(int var1, Header[] var2, byte[] var3, Throwable var4, String var5) {
            if(var1 == 404) {
               var6.onFailure(404, "Image Not Found");
            } else {
               super.onFailure(var1, var2, var3, var4, var5);
            }
         }

         public void onSuccess(String var1) {
            var6.onSuccess(var1);
         }
      });
   }

   public void getInfo(final Activity var1, String var2, final OnRequestFinishListener<DrugEducation[]> var3) {
      String var4 = "https://www.goodrx.com/mobile-api/v3/drug-education/" + var2;
      CacheHttpRequestHelper.getInstance().getUsingCache(var4, (RequestParams)null, 86400000L, new MyResponseHandler(var1) {
         public void onFailure(int var1, Header[] var2, byte[] var3x, Throwable var4, String var5) {
            if(var1 == 404) {
               var3.onFailure(404, "Info not found");
            } else {
               super.onFailure(var1, var2, var3x, var4, var5);
            }
         }

         public void onSuccess(String var1) {
            JsonObject var2 = (new JsonParser()).parse(var1).getAsJsonObject();
            Gson var3x = new Gson();
            JsonArray var4 = var2.getAsJsonArray("results");
            Object var5;
            if(!(var3x instanceof Gson)) {
               var5 = var3x.fromJson((JsonElement)var4, (Class)DrugEducation[].class);
            } else {
               var5 = GsonInstrumentation.fromJson((Gson)var3x, (JsonElement)var4, (Class)DrugEducation[].class);
            }

            DrugEducation[] var6 = (DrugEducation[])var5;
            var3.onSuccess(var6);
         }
      });
   }

   public void getNewToken(final Activity var1, final OnRequestFinishListener<String> var2) {
      RequestParams var3 = new RequestParams();
      var3.put("udid", var1.getSharedPreferences("goodrx", 0).getString("adid", ""));
      CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/register-for-token", var3, new MyResponseHandler(var1) {
         public void onSuccess(String var1) {
            if(var1.length() != 0 && !var1.equals("null")) {
               var2.onSuccess(var1);
            } else {
               var2.onFailure(0, "");
            }
         }
      });
   }

   public void getNews(final Activity var1, String var2, final OnRequestFinishListener<News[]> var3) {
      String var4 = "https://www.goodrx.com/mobile-api/v3/drug-news/" + var2;
      CacheHttpRequestHelper.getInstance().getUsingCache(var4, (RequestParams)null, 86400000L, new MyResponseHandler(var1) {
         public void onFailure(int var1, Header[] var2, byte[] var3x, Throwable var4, String var5) {
            if(var1 == 404) {
               var3.onFailure(404, "News not found");
            } else {
               super.onFailure(var1, var2, var3x, var4, var5);
            }
         }

         public void onSuccess(String var1) {
            JsonObject var2 = GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject();
            Gson var3x = GoodRxAPI.this.gson;
            JsonArray var4 = var2.getAsJsonArray("results");
            Object var5;
            if(!(var3x instanceof Gson)) {
               var5 = var3x.fromJson((JsonElement)var4, (Class)News[].class);
            } else {
               var5 = GsonInstrumentation.fromJson((Gson)var3x, (JsonElement)var4, (Class)News[].class);
            }

            News[] var6 = (News[])var5;
            var3.onSuccess(var6);
         }
      });
   }

   public void getPharmacyList(final Activity var1, final OnRequestFinishListener<Pharmacy[]> var2) {
      Key var3 = this.getToken(var1);
      if(var3 != null) {
         RequestParams var4 = new RequestParams();
         var4.add("token", var3.getToken());
         var4.add("token_id", var3.getToken_id());
         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/my-pharmacies", var4, new MyResponseHandler(var1) {
            public void onSuccess(String param1) {
               // $FF: Couldn't be decompiled
            }
         });
      }
   }

   public void getPopularDrugs(final Activity var1, final OnRequestFinishListener<PopularDrug[]> var2) {
      CacheHttpRequestHelper.getInstance().getUsingCache("https://www.goodrx.com/mobile-api/top-drugs", (RequestParams)null, 259200000L, new MyResponseHandler(var1) {
         public void onSuccess(String var1) {
            Gson var2x = new Gson();
            Object var3;
            if(!(var2x instanceof Gson)) {
               var3 = var2x.fromJson(var1, PopularDrug[].class);
            } else {
               var3 = GsonInstrumentation.fromJson((Gson)var2x, var1, PopularDrug[].class);
            }

            PopularDrug[] var4 = (PopularDrug[])var3;
            var2.onSuccess(var4);
         }
      });
   }

   public void getRx(final Activity var1, final OnRequestFinishListener<MyRx[]> var2) {
      Key var3 = this.getToken(var1);
      if(var3 != null) {
         RequestParams var4 = new RequestParams();
         var4.add("token", var3.getToken());
         var4.add("token_id", var3.getToken_id());
         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/drug-trackers", var4, new MyResponseHandler(var1) {
            public void onSuccess(String var1) {
               JsonObject var2x = GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject();
               Gson var3 = GoodRxAPI.this.gson;
               JsonArray var4 = var2x.getAsJsonArray("my_trackers");
               Object var5;
               if(!(var3 instanceof Gson)) {
                  var5 = var3.fromJson((JsonElement)var4, (Class)MyRx[].class);
               } else {
                  var5 = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var4, (Class)MyRx[].class);
               }

               MyRx[] var6 = (MyRx[])var5;
               var2.onSuccess(var6);
            }
         });
      }
   }

   public void getSavingsTips(final Activity var1, String var2, Integer var3, final OnRequestFinishListener<String> var4) {
      RequestParams var5 = new RequestParams();
      var5.add("drug_id", var2);
      if(var3 != null) {
         var5.add("quantity", String.valueOf(var3));
      }

      CacheHttpRequestHelper.getInstance().getUsingCache("https://www.goodrx.com/mobile-api/v3/drug-tip", var5, 86400000L, new MyResponseHandler(var1) {
         public void onSuccess(String var1) {
            var4.onSuccess(var1);
         }
      });
   }

   public void getStaticContent(final Activity var1, String var2, final OnRequestFinishListener<String> var3) {
      RequestParams var4 = new RequestParams();
      var4.add("device", "android-phone");
      var4.add("rendered", "true");
      CacheHttpRequestHelper.getInstance().getUsingCache(var2, var4, 604800000L, new MyResponseHandler(var1) {
         public void onSuccess(String var1) {
            String var2 = (new JsonParser()).parse(var1).getAsJsonObject().getAsJsonPrimitive("content").getAsString();
            var3.onSuccess(var2);
         }
      });
   }

   public Key getToken(Activity var1) {
      Key var2 = AccountInfoUtils.getKey(var1);
      if(var2.isValid()) {
         return var2;
      } else {
         Utils.reinitTokens(var1);
         var1.finish();
         return null;
      }
   }

   public void register(final Activity var1, String var2, String var3, final OnRequestFinishListener<String> var4) {
      Key var5 = this.getToken(var1);
      if(var5 != null) {
         RequestParams var6 = new RequestParams();
         var6.add("email", var2);
         var6.add("password", var3);
         var6.add("token", var5.getToken());
         var6.add("token_id", var5.getToken_id());
         CacheHttpRequestHelper.getInstance().post("https://www.goodrx.com/mobile-api/register", var6, new MyResponseHandler(var1) {
            public void onSuccess(String var1) {
               JsonObject var2 = GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject();
               Log.d("goodrx", var1);
               if(var2.getAsJsonPrimitive("success").getAsBoolean()) {
                  var4.onSuccess(var1);
               } else {
                  var4.onFailure(0, var1);
               }
            }
         });
      }
   }

   public void removeRx(final Activity var1, final OnRequestFinishListener<String> var2, String... var3) {
      Key var4 = this.getToken(var1);
      if(var4 != null) {
         RequestParams var5 = new RequestParams();
         var5.add("token", var4.getToken());
         var5.add("token_id", var4.getToken_id());
         int var6 = var3.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            String var8 = var3[var7];
            var5.remove("drug_id");
            var5.add("drug_id", var8);
            CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/tracker-remove", var5, new MyResponseHandler(var1) {
               public void onSuccess(String var1) {
                  if(GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject().getAsJsonPrimitive("success").getAsBoolean() && var2 != null) {
                     var2.onSuccess("");
                  }

               }
            });
         }
      }

   }

   public void reorderRx(final Activity var1, final MyRx[] var2, final OnRequestFinishListener<String> var3) {
      Key var4 = AccountInfoUtils.getKey(var1);
      if(!var4.isValid()) {
         Utils.reinitTokens(var1);
         var1.finish();
      } else {
         RequestParams var5 = new RequestParams();
         var5.add("token", var4.getToken());
         var5.add("token_id", var4.getToken_id());

         for(int var6 = 0; var6 < var2.length; ++var6) {
            var5.add("position", var6 + 1 + "-" + var2[var6].getDrug().getDrug_id());
         }

         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/order-drug-trackers", var5, new MyResponseHandler(var1) {
            public void onSuccess(String var1x) {
               JsonObject var2x = (new JsonParser()).parse(var1x).getAsJsonObject();
               if(var2x.getAsJsonPrimitive("success").getAsBoolean()) {
                  MyRxUtils.saveRx(var1, var2);
                  var3.onSuccess("success");
               } else {
                  JsonArray var3x = var2x.getAsJsonArray("errors");
                  if(var3x.size() > 0) {
                     var3.onFailure(0, var3x.get(0).getAsString());
                     return;
                  }
               }

            }
         });
      }
   }

   public void replaceDrug(final Activity var1, String var2, String var3, int var4, String var5, String var6, final OnRequestFinishListener<String> var7) {
      Key var8 = this.getToken(var1);
      if(var8 != null) {
         if(var5 == null) {
            var5 = "";
         }

         RequestParams var9 = new RequestParams();
         var9.add("token", var8.getToken());
         var9.add("token_id", var8.getToken_id());
         var9.add("old_drug_id", var3);
         var9.add("new_drug_id", var2);
         var9.add("quantity", String.valueOf(var4));
         var9.add("preferred_pharm", var5);
         if(var6 != null) {
            var9.add("drug_image", var6);
         }

         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/tracker-edit", var9, new MyResponseHandler(var1) {
            public void onSuccess(String var1x) {
               JsonObject var2 = GoodRxAPI.this.jsonParser.parse(var1x).getAsJsonObject();
               if(!var2.getAsJsonPrimitive("success").getAsBoolean()) {
                  JsonArray var3 = var2.getAsJsonArray("errors");
                  if(var3 != null && var3.size() > 0) {
                     DialogHelper.showErrorDialog(var1, var1.getString(2131427412), var3.get(0).getAsString());
                  }

               } else {
                  var7.onSuccess(var1x);
               }
            }
         });
      }
   }

   public void saveBestPharmacySettings(final Activity var1, MyRx[] var2, int var3, final OnRequestFinishListener<String> var4) {
      Key var5 = this.getToken(var1);
      if(var5 != null) {
         RequestParams var6 = new RequestParams();
         var6.add("token", var5.getToken());
         var6.add("token_id", var5.getToken_id());
         LocationEntity var7 = LocationUtils.getLocationEntity(var1);
         if(var7 != null) {
            var6.add("set-coords", var7.getLatitude() + "," + var7.getLongitude());
            var6.add("distance", String.valueOf(var3));
            int var8 = var2.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               MyRx var10 = var2[var9];
               if(var10.getDrug().isConsidered()) {
                  var6.add("drug_considered", var10.getDrug().getDrug_id());
               }
            }

            CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/best-pharmacy-settings", var6, new MyResponseHandler(var1) {
               public void onSuccess(String var1) {
                  if(var4 != null) {
                     try {
                        if(GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject().getAsJsonPrimitive("success").getAsBoolean()) {
                           var4.onSuccess(var1);
                        } else {
                           var4.onFailure(0, "");
                        }
                     } catch (Exception var3) {
                        var4.onFailure(0, "");
                     }
                  }
               }
            });
            return;
         }
      }

   }

   public void saveDefaultImage(final Activity var1, String var2, ImageResult var3, final OnRequestFinishListener<String> var4) {
      Key var5 = this.getToken(var1);
      if(var5 != null) {
         byte var6;
         String var7;
         if(var3.getImage_id() == null) {
            var6 = 0;
            var7 = var3.getImage();
         } else {
            var6 = 1;
            var7 = var3.getImage_id();
         }

         RequestParams var8 = new RequestParams();
         var8.add("token", var5.getToken());
         var8.add("token_id", var5.getToken_id());
         var8.add("drug_id", var2);
         var8.add("drug_image", var7);
         var8.add("is_user_image", String.valueOf(var6));
         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/myrx-save-default-image", var8, new MyResponseHandler(var1) {
            public void onSuccess(String var1x) {
               JsonObject var2 = GoodRxAPI.this.jsonParser.parse(var1x).getAsJsonObject();
               if(var2.getAsJsonPrimitive("success").getAsBoolean()) {
                  var4.onSuccess(var1x);
               } else {
                  JsonArray var3 = var2.getAsJsonArray("errors");
                  if(var3.size() > 0) {
                     DialogHelper.showErrorDialog(var1, var1.getString(2131427570), var3.get(0).getAsString());
                     return;
                  }
               }

            }
         });
      }
   }

   public void saveReminder(final Activity var1, MyRx var2, final OnRequestFinishListener<String> var3) {
      Key var4 = this.getToken(var1);
      if(var4 != null) {
         MyRx.Reminder var5 = var2.getReminder();
         DateTime var6 = var5.getCombinedNextDate();
         DateTimeFormatter var7 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
         DateTime var8 = var6.toDateTime(DateTimeZone.UTC);
         RequestParams var9 = new RequestParams();
         var9.add("token", var4.getToken());
         var9.add("token_id", var4.getToken_id());
         var9.add("drug_id", var2.getDrug().getDrug_id());
         var9.add("reminder_active", String.valueOf(var5.isActive()));
         var9.add("reminder_interval", String.valueOf(var5.getInterval()));
         var9.add("next_reminder_date", var7.print((ReadableInstant)var8));
         var9.add("reminder_time_of_day", var5.getTime_of_day());
         CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/tracker-save-reminder", var9, new MyResponseHandler(var1) {
            public void onSuccess(String var1x) {
               JsonObject var2 = GoodRxAPI.this.jsonParser.parse(var1x).getAsJsonObject();
               if(var2.getAsJsonPrimitive("success").getAsBoolean()) {
                  var3.onSuccess(var1x);
               } else {
                  try {
                     String var4 = var2.getAsJsonPrimitive("errors").getAsString();
                     DialogHelper.showErrorDialog(var1, var1.getString(2131427570), var4);
                  } catch (Exception var5) {
                     ;
                  }
               }
            }
         });
      }
   }

   public void search(final Activity var1, String var2, boolean var3, final OnRequestFinishListener<SearchResult[]> var4) {
      if(this.getToken(var1) != null) {
         RequestParams var5 = new RequestParams();
         var5.put("search", var2);
         if(var3) {
            var5.put("trackable_only", "1");
         }

         CacheHttpRequestHelper.getInstance().getUsingCache("https://www.goodrx.com/mobile-api/v3/search", var5, 604800000L, new MyResponseHandler(var1) {
            public void onSuccess(String var1) {
               JsonObject var2 = GoodRxAPI.this.jsonParser.parse(var1).getAsJsonObject();
               Gson var3 = GoodRxAPI.this.gson;
               JsonArray var4x = var2.getAsJsonArray("results");
               Object var5;
               if(!(var3 instanceof Gson)) {
                  var5 = var3.fromJson((JsonElement)var4x, (Class)SearchResult[].class);
               } else {
                  var5 = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var4x, (Class)SearchResult[].class);
               }

               SearchResult[] var6 = (SearchResult[])var5;
               var4.onSuccess(var6);
            }
         });
      }
   }

   public void searchImprint(final Activity var1, String var2, final OnRequestFinishListener<ImprintResult[]> var3) {
      if(var2 != null && var2.length() != 0) {
         RequestParams var4 = new RequestParams();
         var4.add("search", var2);
         CacheHttpRequestHelper.getInstance().getUsingCache("https://www.goodrx.com/mobile-api/v3/pill-imprint", var4, 604800000L, new MyResponseHandler(var1) {
            public void onSuccess(String param1) {
               // $FF: Couldn't be decompiled
            }
         });
      }
   }

   public void signIn(final Activity var1, String var2, String var3, final OnRequestFinishListener<String> var4) {
      Key var5 = this.getToken(var1);
      if(var5 != null) {
         RequestParams var6 = new RequestParams();
         var6.add("token_id", var5.getToken_id());
         var6.add("token", var5.getToken());
         var6.add("email", var2);
         var6.add("password", var3);
         CacheHttpRequestHelper.getInstance().post("https://www.goodrx.com/mobile-api/sync-account", var6, new MyResponseHandler(var1) {
            public void onSuccess(String var1x) {
               JsonObject var2 = GoodRxAPI.this.jsonParser.parse(var1x).getAsJsonObject();
               if(!var2.getAsJsonPrimitive("success").getAsBoolean()) {
                  String var3 = var2.getAsJsonPrimitive("error").getAsString();
                  if(var3 != null && var3.length() > 0) {
                     DialogHelper.showErrorDialog(var1, var1.getString(2131427654), var3);
                     var4.onFailure(0, "");
                  }

               } else {
                  var4.onSuccess(var1x);
               }
            }
         });
      }
   }

   public void updateBestPharmacyLocation(Context var1) {
      MyRx[] var2 = MyRxUtils.getRx(var1);
      int var3 = MyRxUtils.getBestPharmacyDistance(var1);
      this.saveBestPharmacySettings((Activity)var1, var2, var3, (OnRequestFinishListener)null);
   }
}
