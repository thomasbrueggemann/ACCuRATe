package com.newrelic.agent.android.instrumentation.io;

import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class StreamCompleteListenerManager {
   private boolean streamComplete = false;
   private ArrayList<StreamCompleteListener> streamCompleteListeners = new ArrayList();

   private boolean checkComplete() {
      // $FF: Couldn't be decompiled
   }

   private List<StreamCompleteListener> getStreamCompleteListeners() {
      // $FF: Couldn't be decompiled
   }

   public void addStreamCompleteListener(StreamCompleteListener param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean isComplete() {
      // $FF: Couldn't be decompiled
   }

   public void notifyStreamComplete(StreamCompleteEvent var1) {
      if(!this.checkComplete()) {
         Iterator var2 = this.getStreamCompleteListeners().iterator();

         while(var2.hasNext()) {
            ((StreamCompleteListener)var2.next()).streamComplete(var1);
         }
      }

   }

   public void notifyStreamError(StreamCompleteEvent var1) {
      if(!this.checkComplete()) {
         Iterator var2 = this.getStreamCompleteListeners().iterator();

         while(var2.hasNext()) {
            ((StreamCompleteListener)var2.next()).streamError(var1);
         }
      }

   }

   public void removeStreamCompleteListener(StreamCompleteListener param1) {
      // $FF: Couldn't be decompiled
   }
}
