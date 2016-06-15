package com.squareup.okhttp.internal.spdy;

final class Settings {
   static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
   static final int COUNT = 10;
   static final int CURRENT_CWND = 5;
   static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
   static final int DOWNLOAD_BANDWIDTH = 2;
   static final int DOWNLOAD_RETRANS_RATE = 6;
   static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
   static final int FLOW_CONTROL_OPTIONS = 9;
   static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
   static final int INITIAL_WINDOW_SIZE = 7;
   static final int MAX_CONCURRENT_STREAMS = 4;
   static final int PERSISTED = 2;
   static final int PERSIST_VALUE = 1;
   static final int ROUND_TRIP_TIME = 3;
   static final int UPLOAD_BANDWIDTH = 1;
   private int persistValue;
   private int persisted;
   private int set;
   private final int[] values = new int[10];

   int flags(int var1) {
      boolean var2 = this.isPersisted(var1);
      int var3 = 0;
      if(var2) {
         var3 = 0 | 2;
      }

      if(this.persistValue(var1)) {
         var3 |= 1;
      }

      return var3;
   }

   int get(int var1) {
      return this.values[var1];
   }

   int getClientCertificateVectorSize(int var1) {
      if((256 & this.set) != 0) {
         var1 = this.values[8];
      }

      return var1;
   }

   int getCurrentCwnd(int var1) {
      if((32 & this.set) != 0) {
         var1 = this.values[5];
      }

      return var1;
   }

   int getDownloadBandwidth(int var1) {
      if((4 & this.set) != 0) {
         var1 = this.values[2];
      }

      return var1;
   }

   int getDownloadRetransRate(int var1) {
      if((64 & this.set) != 0) {
         var1 = this.values[6];
      }

      return var1;
   }

   int getInitialWindowSize(int var1) {
      if((128 & this.set) != 0) {
         var1 = this.values[7];
      }

      return var1;
   }

   int getMaxConcurrentStreams(int var1) {
      if((16 & this.set) != 0) {
         var1 = this.values[4];
      }

      return var1;
   }

   int getRoundTripTime(int var1) {
      if((8 & this.set) != 0) {
         var1 = this.values[3];
      }

      return var1;
   }

   int getUploadBandwidth(int var1) {
      if((2 & this.set) != 0) {
         var1 = this.values[1];
      }

      return var1;
   }

   boolean isFlowControlDisabled() {
      int var1;
      if((512 & this.set) != 0) {
         var1 = this.values[9];
      } else {
         var1 = 0;
      }

      int var2 = var1 & 1;
      boolean var3 = false;
      if(var2 != 0) {
         var3 = true;
      }

      return var3;
   }

   boolean isPersisted(int var1) {
      return (1 << var1 & this.persisted) != 0;
   }

   boolean isSet(int var1) {
      return (1 << var1 & this.set) != 0;
   }

   void merge(Settings var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         if(var1.isSet(var2)) {
            this.set(var2, var1.flags(var2), var1.get(var2));
         }
      }

   }

   boolean persistValue(int var1) {
      return (1 << var1 & this.persistValue) != 0;
   }

   void set(int var1, int var2, int var3) {
      if(var1 < this.values.length) {
         int var4 = 1 << var1;
         this.set |= var4;
         if((var2 & 1) != 0) {
            this.persistValue |= var4;
         } else {
            this.persistValue &= ~var4;
         }

         if((var2 & 2) != 0) {
            this.persisted |= var4;
         } else {
            this.persisted &= ~var4;
         }

         this.values[var1] = var3;
      }
   }

   int size() {
      return Integer.bitCount(this.set);
   }
}
