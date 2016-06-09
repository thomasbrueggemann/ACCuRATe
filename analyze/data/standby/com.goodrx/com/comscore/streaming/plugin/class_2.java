package com.comscore.streaming.plugin;

import com.comscore.streaming.StreamSenseEventType;
import com.comscore.streaming.StreamSenseState;
import com.comscore.streaming.plugin.StreamSensePlugin;
import com.comscore.streaming.plugin.StreamSensePluginListener;
import com.comscore.streaming.plugin.class_1;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.comscore.streaming.plugin.a
class class_2 implements Runnable {
   // $FF: renamed from: a com.comscore.streaming.plugin.StreamSensePlugin
   // $FF: synthetic field
   final StreamSensePlugin field_3;

   class_2(StreamSensePlugin var1) {
      this.field_3 = var1;
   }

   public void run() {
      if(StreamSensePlugin.method_127(this.field_3) && StreamSensePlugin.method_133(this.field_3) != null) {
         if(StreamSensePlugin.method_143(this.field_3)) {
            StreamSensePlugin.method_129(this.field_3, false);
         } else {
            long var1 = StreamSensePlugin.method_133(this.field_3).getPosition();
            StreamSenseState var3 = this.field_3.getState();
            long var4 = System.currentTimeMillis();
            boolean var8;
            if(!StreamSensePlugin.method_145(this.field_3).isEmpty() && var1 == StreamSensePlugin.method_123(this.field_3, 0)) {
               StreamSensePlugin.method_146(this.field_3).set(-1 + StreamSensePlugin.method_146(this.field_3).size(), Long.valueOf(var4));
               var8 = false;
            } else {
               label167: {
                  StreamSensePlugin.method_145(this.field_3).add(Long.valueOf(Math.abs(var1)));
                  StreamSensePlugin.method_146(this.field_3).add(Long.valueOf(var4));
                  if(StreamSensePlugin.method_145(this.field_3).size() > 1 && StreamSensePlugin.method_123(this.field_3, 0) < StreamSensePlugin.method_123(this.field_3, 1)) {
                     long var25 = StreamSensePlugin.method_123(this.field_3, 0);
                     long var27 = StreamSensePlugin.method_131(this.field_3, 0);
                     StreamSensePlugin.method_145(this.field_3).clear();
                     StreamSensePlugin.method_146(this.field_3).clear();
                     StreamSensePlugin.method_145(this.field_3).add(Long.valueOf(var25));
                     StreamSensePlugin.method_146(this.field_3).add(Long.valueOf(var27));
                     if(StreamSensePlugin.method_148(this.field_3)) {
                        var8 = true;
                        break label167;
                     }
                  } else if(StreamSensePlugin.method_145(this.field_3).size() < StreamSensePlugin.method_149(this.field_3)) {
                     return;
                  }

                  var8 = false;
               }

               if(StreamSensePlugin.method_145(this.field_3).size() > StreamSensePlugin.method_150(this.field_3)) {
                  StreamSensePlugin.method_145(this.field_3).remove(0);
                  StreamSensePlugin.method_146(this.field_3).remove(0);
               }

               if(StreamSensePlugin.method_148(this.field_3) && !var8) {
                  var8 = StreamSensePlugin.method_151(this.field_3);
               }
            }

            switch(class_1.field_2[this.field_3.getState().ordinal()]) {
            case 1:
            case 2:
            case 3:
               if(StreamSensePlugin.method_152(this.field_3) && var1 > StreamSensePlugin.method_153(this.field_3) && !var8 && !StreamSensePlugin.method_128(this.field_3, var1)) {
                  Iterator var18 = StreamSensePlugin.method_154(this.field_3).iterator();

                  while(var18.hasNext() && ((StreamSensePluginListener)var18.next()).onPreStateChange(this.field_3.getState(), StreamSenseEventType.PLAY, StreamSensePlugin.method_155(this.field_3))) {
                     ;
                  }

                  if(StreamSensePlugin.method_155(this.field_3) && !StreamSensePlugin.method_156(this.field_3)) {
                     HashMap var21 = new HashMap();
                     var21.put("ns_st_ui", "seek");
                     this.field_3.notify(StreamSenseEventType.PLAY, var21, var1);
                  } else {
                     this.field_3.notify(StreamSenseEventType.PLAY, (HashMap)null, ((Long)StreamSensePlugin.method_145(this.field_3).get(0)).longValue());
                  }

                  StreamSensePlugin.method_137(this.field_3, false);
                  StreamSensePlugin.method_141(this.field_3, false);
               } else if(StreamSensePlugin.method_148(this.field_3) && var8) {
                  StreamSensePlugin.method_137(this.field_3, true);
               }
               break;
            case 4:
               if(StreamSensePlugin.method_148(this.field_3) && var8) {
                  Iterator var15 = StreamSensePlugin.method_154(this.field_3).iterator();

                  while(var15.hasNext() && ((StreamSensePluginListener)var15.next()).onPreStateChange(this.field_3.getState(), StreamSenseEventType.PAUSE, false)) {
                     ;
                  }

                  this.field_3.notify(StreamSenseEventType.PAUSE, (HashMap)null, StreamSensePlugin.method_153(this.field_3));
                  StreamSensePlugin.method_137(this.field_3, true);
               } else if(StreamSensePlugin.method_157(this.field_3) && StreamSensePlugin.method_128(this.field_3, var1)) {
                  Iterator var13 = StreamSensePlugin.method_154(this.field_3).iterator();

                  while(var13.hasNext() && ((StreamSensePluginListener)var13.next()).onPreStateChange(this.field_3.getState(), StreamSenseEventType.END, false)) {
                     ;
                  }

                  this.field_3.notify(StreamSenseEventType.END, (HashMap)null, StreamSensePlugin.method_133(this.field_3).getDuration());
                  StreamSensePlugin.method_137(this.field_3, false);
               } else if(StreamSensePlugin.method_158(this.field_3) && Math.abs(var1 - StreamSensePlugin.method_153(this.field_3)) <= (long)StreamSensePlugin.method_159(this.field_3)) {
                  Iterator var9 = StreamSensePlugin.method_154(this.field_3).iterator();

                  while(var9.hasNext() && ((StreamSensePluginListener)var9.next()).onPreStateChange(this.field_3.getState(), StreamSenseEventType.PAUSE, false)) {
                     ;
                  }

                  this.field_3.notify(StreamSenseEventType.PAUSE, (HashMap)null, StreamSensePlugin.method_153(this.field_3));
               }
            }

            if(var3 != this.field_3.getState()) {
               Iterator var12 = StreamSensePlugin.method_154(this.field_3).iterator();

               while(var12.hasNext()) {
                  ((StreamSensePluginListener)var12.next()).onPostStateChange(this.field_3.getState());
               }

               if(this.field_3.getState() == StreamSenseState.PAUSED) {
                  StreamSensePlugin.method_145(this.field_3).clear();
                  StreamSensePlugin.method_146(this.field_3).clear();
               }
            }

            StreamSensePlugin.method_132(this.field_3, var1);
         }
      } else {
         StreamSensePlugin.method_140(this.field_3);
      }
   }
}
