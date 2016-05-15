package com.comscore.streaming;

import com.comscore.streaming.StreamSenseState;
import java.util.HashMap;

public interface StreamSenseListener {
   void onStateChange(StreamSenseState var1, StreamSenseState var2, HashMap<String, String> var3, long var4);
}
