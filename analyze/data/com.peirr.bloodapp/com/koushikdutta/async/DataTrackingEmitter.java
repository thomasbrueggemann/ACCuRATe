package com.koushikdutta.async;

import com.koushikdutta.async.DataEmitter;

public interface DataTrackingEmitter extends DataEmitter {
   int getBytesRead();

   DataTrackingEmitter.DataTracker getDataTracker();

   void setDataEmitter(DataEmitter var1);

   void setDataTracker(DataTrackingEmitter.DataTracker var1);

   public interface DataTracker {
      void onData(int var1);
   }
}
