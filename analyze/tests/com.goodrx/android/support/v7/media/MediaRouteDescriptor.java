package android.support.v7.media;

import android.content.IntentFilter;
import android.content.IntentSender;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MediaRouteDescriptor {
   private static final String KEY_CAN_DISCONNECT = "canDisconnect";
   private static final String KEY_CONNECTING = "connecting";
   private static final String KEY_CONTROL_FILTERS = "controlFilters";
   private static final String KEY_DESCRIPTION = "status";
   private static final String KEY_ENABLED = "enabled";
   private static final String KEY_EXTRAS = "extras";
   private static final String KEY_ID = "id";
   private static final String KEY_NAME = "name";
   private static final String KEY_PLAYBACK_STREAM = "playbackStream";
   private static final String KEY_PLAYBACK_TYPE = "playbackType";
   private static final String KEY_PRESENTATION_DISPLAY_ID = "presentationDisplayId";
   private static final String KEY_SETTINGS_INTENT = "settingsIntent";
   private static final String KEY_VOLUME = "volume";
   private static final String KEY_VOLUME_HANDLING = "volumeHandling";
   private static final String KEY_VOLUME_MAX = "volumeMax";
   private final Bundle mBundle;
   private List<IntentFilter> mControlFilters;

   private MediaRouteDescriptor(Bundle var1, List<IntentFilter> var2) {
      this.mBundle = var1;
      this.mControlFilters = var2;
   }

   // $FF: synthetic method
   MediaRouteDescriptor(Bundle var1, List var2, Object var3) {
      this(var1, var2);
   }

   private void ensureControlFilters() {
      if(this.mControlFilters == null) {
         this.mControlFilters = this.mBundle.getParcelableArrayList("controlFilters");
         if(this.mControlFilters == null) {
            this.mControlFilters = Collections.emptyList();
         }
      }

   }

   public static MediaRouteDescriptor fromBundle(Bundle var0) {
      return var0 != null?new MediaRouteDescriptor(var0, (List)null):null;
   }

   public Bundle asBundle() {
      return this.mBundle;
   }

   public boolean canDisconnectAndKeepPlaying() {
      return this.mBundle.getBoolean("canDisconnect", false);
   }

   public List<IntentFilter> getControlFilters() {
      this.ensureControlFilters();
      return this.mControlFilters;
   }

   public String getDescription() {
      return this.mBundle.getString("status");
   }

   public Bundle getExtras() {
      return this.mBundle.getBundle("extras");
   }

   public String getId() {
      return this.mBundle.getString("id");
   }

   public String getName() {
      return this.mBundle.getString("name");
   }

   public int getPlaybackStream() {
      return this.mBundle.getInt("playbackStream", -1);
   }

   public int getPlaybackType() {
      return this.mBundle.getInt("playbackType", 1);
   }

   public int getPresentationDisplayId() {
      return this.mBundle.getInt("presentationDisplayId", -1);
   }

   public IntentSender getSettingsActivity() {
      return (IntentSender)this.mBundle.getParcelable("settingsIntent");
   }

   public int getVolume() {
      return this.mBundle.getInt("volume");
   }

   public int getVolumeHandling() {
      return this.mBundle.getInt("volumeHandling", 0);
   }

   public int getVolumeMax() {
      return this.mBundle.getInt("volumeMax");
   }

   public boolean isConnecting() {
      return this.mBundle.getBoolean("connecting", false);
   }

   public boolean isEnabled() {
      return this.mBundle.getBoolean("enabled", true);
   }

   public boolean isValid() {
      this.ensureControlFilters();
      return !TextUtils.isEmpty(this.getId()) && !TextUtils.isEmpty(this.getName()) && !this.mControlFilters.contains((Object)null);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("MediaRouteDescriptor{ ");
      var1.append("id=").append(this.getId());
      var1.append(", name=").append(this.getName());
      var1.append(", description=").append(this.getDescription());
      var1.append(", isEnabled=").append(this.isEnabled());
      var1.append(", isConnecting=").append(this.isConnecting());
      var1.append(", controlFilters=").append(Arrays.toString(this.getControlFilters().toArray()));
      var1.append(", playbackType=").append(this.getPlaybackType());
      var1.append(", playbackStream=").append(this.getPlaybackStream());
      var1.append(", volume=").append(this.getVolume());
      var1.append(", volumeMax=").append(this.getVolumeMax());
      var1.append(", volumeHandling=").append(this.getVolumeHandling());
      var1.append(", presentationDisplayId=").append(this.getPresentationDisplayId());
      var1.append(", extras=").append(this.getExtras());
      var1.append(", isValid=").append(this.isValid());
      var1.append(" }");
      return var1.toString();
   }

   public static final class Builder {
      private final Bundle mBundle;
      private ArrayList<IntentFilter> mControlFilters;

      public Builder(MediaRouteDescriptor var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("descriptor must not be null");
         } else {
            this.mBundle = new Bundle(var1.mBundle);
            var1.ensureControlFilters();
            if(!var1.mControlFilters.isEmpty()) {
               this.mControlFilters = new ArrayList(var1.mControlFilters);
            }

         }
      }

      public Builder(String var1, String var2) {
         this.mBundle = new Bundle();
         this.setId(var1);
         this.setName(var2);
      }

      public MediaRouteDescriptor.Builder addControlFilter(IntentFilter var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("filter must not be null");
         } else {
            if(this.mControlFilters == null) {
               this.mControlFilters = new ArrayList();
            }

            if(!this.mControlFilters.contains(var1)) {
               this.mControlFilters.add(var1);
            }

            return this;
         }
      }

      public MediaRouteDescriptor.Builder addControlFilters(Collection<IntentFilter> var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("filters must not be null");
         } else {
            if(!var1.isEmpty()) {
               Iterator var2 = var1.iterator();

               while(var2.hasNext()) {
                  this.addControlFilter((IntentFilter)var2.next());
               }
            }

            return this;
         }
      }

      public MediaRouteDescriptor build() {
         if(this.mControlFilters != null) {
            this.mBundle.putParcelableArrayList("controlFilters", this.mControlFilters);
         }

         return new MediaRouteDescriptor(this.mBundle, this.mControlFilters);
      }

      public MediaRouteDescriptor.Builder setCanDisconnect(boolean var1) {
         this.mBundle.putBoolean("canDisconnect", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setConnecting(boolean var1) {
         this.mBundle.putBoolean("connecting", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setDescription(String var1) {
         this.mBundle.putString("status", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setEnabled(boolean var1) {
         this.mBundle.putBoolean("enabled", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setExtras(Bundle var1) {
         this.mBundle.putBundle("extras", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setId(String var1) {
         this.mBundle.putString("id", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setName(String var1) {
         this.mBundle.putString("name", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setPlaybackStream(int var1) {
         this.mBundle.putInt("playbackStream", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setPlaybackType(int var1) {
         this.mBundle.putInt("playbackType", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setPresentationDisplayId(int var1) {
         this.mBundle.putInt("presentationDisplayId", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setSettingsActivity(IntentSender var1) {
         this.mBundle.putParcelable("settingsIntent", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setVolume(int var1) {
         this.mBundle.putInt("volume", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setVolumeHandling(int var1) {
         this.mBundle.putInt("volumeHandling", var1);
         return this;
      }

      public MediaRouteDescriptor.Builder setVolumeMax(int var1) {
         this.mBundle.putInt("volumeMax", var1);
         return this;
      }
   }
}
