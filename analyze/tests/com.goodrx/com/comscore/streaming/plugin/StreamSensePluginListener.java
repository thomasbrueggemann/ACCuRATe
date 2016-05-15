package com.comscore.streaming.plugin;

import com.comscore.streaming.StreamSenseEventType;
import com.comscore.streaming.StreamSenseState;
import java.util.HashMap;

public interface StreamSensePluginListener {
   void onGetLabels(StreamSenseEventType var1, HashMap<String, String> var2);

   void onPostStateChange(StreamSenseState var1);

   boolean onPreStateChange(StreamSenseState var1, StreamSenseEventType var2, boolean var3);
}
