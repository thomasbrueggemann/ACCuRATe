package com.newrelic.agent.android.harvest;

public class HarvestResponse {
   private static final String DISABLE_STRING = "DISABLE_NEW_RELIC";
   private String responseBody;
   private long responseTime;
   private int statusCode;

   public String getResponseBody() {
      return this.responseBody;
   }

   public HarvestResponse.Code getResponseCode() {
      HarvestResponse.Code var4;
      if(this.isOK()) {
         var4 = HarvestResponse.Code.field_466;
      } else {
         HarvestResponse.Code[] var1 = HarvestResponse.Code.values();
         int var2 = var1.length;
         int var3 = 0;

         while(true) {
            if(var3 >= var2) {
               return HarvestResponse.Code.UNKNOWN;
            }

            var4 = var1[var3];
            if(var4.getStatusCode() == this.statusCode) {
               break;
            }

            ++var3;
         }
      }

      return var4;
   }

   public long getResponseTime() {
      return this.responseTime;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public boolean isDisableCommand() {
      return HarvestResponse.Code.FORBIDDEN == this.getResponseCode() && "DISABLE_NEW_RELIC".equals(this.getResponseBody());
   }

   public boolean isError() {
      return this.statusCode >= 400;
   }

   public boolean isOK() {
      return !this.isError();
   }

   public boolean isUnknown() {
      return this.getResponseCode() == HarvestResponse.Code.UNKNOWN;
   }

   public void setResponseBody(String var1) {
      this.responseBody = var1;
   }

   public void setResponseTime(long var1) {
      this.responseTime = var1;
   }

   public void setStatusCode(int var1) {
      this.statusCode = var1;
   }

   public static enum Code {
      ENTITY_TOO_LARGE(413),
      FORBIDDEN(403),
      INTERNAL_SERVER_ERROR(500),
      INVALID_AGENT_ID(450),
      // $FF: renamed from: OK com.newrelic.agent.android.harvest.HarvestResponse$Code
      field_466(200),
      UNAUTHORIZED(401),
      UNKNOWN(-1),
      UNSUPPORTED_MEDIA_TYPE(415);

      int statusCode;

      static {
         HarvestResponse.Code[] var0 = new HarvestResponse.Code[]{field_466, UNAUTHORIZED, FORBIDDEN, ENTITY_TOO_LARGE, INVALID_AGENT_ID, UNSUPPORTED_MEDIA_TYPE, INTERNAL_SERVER_ERROR, UNKNOWN};
      }

      private Code(int var3) {
         this.statusCode = var3;
      }

      public int getStatusCode() {
         return this.statusCode;
      }

      public boolean isError() {
         return this != field_466;
      }

      public boolean isOK() {
         return !this.isError();
      }
   }
}
