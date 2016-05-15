package android.support.v7.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.OnFinished;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.MediaRouterThemeHelper;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.mediarouter.class_16;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MediaRouteControllerDialog extends AlertDialog {
   private static final String TAG = "MediaRouteControllerDialog";
   private static final int VOLUME_UPDATE_DELAY_MILLIS = 250;
   private ImageView mArtView;
   private boolean mAttachedToWindow;
   private final MediaRouteControllerDialog.MediaRouterCallback mCallback;
   private View mControlView;
   private MediaRouteControllerDialog.MediaControllerCallback mControllerCallback;
   private boolean mCreated;
   private MediaDescriptionCompat mDescription;
   private Button mDisconnectButton;
   private MediaControllerCompat mMediaController;
   private Drawable mMediaRouteConnectingDrawable;
   private Drawable mMediaRouteOnDrawable;
   private ImageButton mPlayPauseButton;
   private final MediaRouter.RouteInfo mRoute;
   private TextView mRouteNameView;
   private final MediaRouter mRouter;
   private ImageButton mSettingsButton;
   private PlaybackStateCompat mState;
   private Button mStopCastingButton;
   private TextView mSubtitleView;
   private TextView mTitleView;
   private boolean mVolumeControlEnabled;
   private LinearLayout mVolumeLayout;
   private SeekBar mVolumeSlider;
   private boolean mVolumeSliderTouched;

   public MediaRouteControllerDialog(Context var1) {
      this(var1, 0);
   }

   public MediaRouteControllerDialog(Context var1, int var2) {
      super(MediaRouterThemeHelper.createThemedContext(var1), var2);
      this.mVolumeControlEnabled = true;
      Context var3 = this.getContext();
      this.mControllerCallback = new MediaRouteControllerDialog.MediaControllerCallback(null);
      this.mRouter = MediaRouter.getInstance(var3);
      this.mCallback = new MediaRouteControllerDialog.MediaRouterCallback(null);
      this.mRoute = this.mRouter.getSelectedRoute();
      this.setMediaSession(this.mRouter.getMediaSessionToken());
   }

   private Drawable getIconDrawable() {
      if(this.mRoute.isConnecting()) {
         if(this.mMediaRouteConnectingDrawable == null) {
            this.mMediaRouteConnectingDrawable = MediaRouterThemeHelper.getThemeDrawable(this.getContext(), class_16.attr.mediaRouteConnectingDrawable);
         }

         return this.mMediaRouteConnectingDrawable;
      } else {
         if(this.mMediaRouteOnDrawable == null) {
            this.mMediaRouteOnDrawable = MediaRouterThemeHelper.getThemeDrawable(this.getContext(), class_16.attr.mediaRouteOnDrawable);
         }

         return this.mMediaRouteOnDrawable;
      }
   }

   private boolean isVolumeControlAvailable() {
      return this.mVolumeControlEnabled && this.mRoute.getVolumeHandling() == 1;
   }

   private void setMediaSession(MediaSessionCompat.Token var1) {
      if(this.mMediaController != null) {
         this.mMediaController.unregisterCallback(this.mControllerCallback);
         this.mMediaController = null;
      }

      if(var1 != null && this.mAttachedToWindow) {
         try {
            this.mMediaController = new MediaControllerCompat(this.getContext(), var1);
         } catch (RemoteException var8) {
            Log.e("MediaRouteControllerDialog", "Error creating media controller in setMediaSession.", var8);
         }

         if(this.mMediaController != null) {
            this.mMediaController.registerCallback(this.mControllerCallback);
         }

         MediaMetadataCompat var4;
         if(this.mMediaController == null) {
            var4 = null;
         } else {
            var4 = this.mMediaController.getMetadata();
         }

         MediaDescriptionCompat var5;
         if(var4 == null) {
            var5 = null;
         } else {
            var5 = var4.getDescription();
         }

         this.mDescription = var5;
         MediaControllerCompat var6 = this.mMediaController;
         PlaybackStateCompat var7 = null;
         if(var6 != null) {
            var7 = this.mMediaController.getPlaybackState();
         }

         this.mState = var7;
         this.update();
      }
   }

   private boolean update() {
      if(this.mRoute.isSelected() && !this.mRoute.isDefault()) {
         if(!this.mCreated) {
            return false;
         } else {
            this.updateVolume();
            this.mRouteNameView.setText(this.mRoute.getName());
            if(this.mRoute.canDisconnect()) {
               this.mDisconnectButton.setVisibility(0);
            } else {
               this.mDisconnectButton.setVisibility(8);
            }

            if(this.mRoute.getSettingsIntent() != null) {
               this.mSettingsButton.setVisibility(0);
            } else {
               this.mSettingsButton.setVisibility(8);
            }

            if(this.mControlView == null) {
               if(this.mDescription != null && this.mDescription.getIconBitmap() != null) {
                  this.mArtView.setImageBitmap(this.mDescription.getIconBitmap());
                  this.mArtView.setVisibility(0);
               } else if(this.mDescription != null && this.mDescription.getIconUri() != null) {
                  this.mArtView.setImageURI(this.mDescription.getIconUri());
                  this.mArtView.setVisibility(0);
               } else {
                  this.mArtView.setImageDrawable((Drawable)null);
                  this.mArtView.setVisibility(8);
               }

               CharSequence var1;
               if(this.mDescription == null) {
                  var1 = null;
               } else {
                  var1 = this.mDescription.getTitle();
               }

               boolean var2;
               if(!TextUtils.isEmpty(var1)) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               CharSequence var3;
               if(this.mDescription == null) {
                  var3 = null;
               } else {
                  var3 = this.mDescription.getSubtitle();
               }

               boolean var4;
               if(!TextUtils.isEmpty(var3)) {
                  var4 = true;
               } else {
                  var4 = false;
               }

               if(!var2 && !var4) {
                  this.mTitleView.setText(class_16.string.mr_media_route_controller_no_info_available);
                  this.mTitleView.setEnabled(false);
                  this.mTitleView.setVisibility(0);
                  this.mSubtitleView.setVisibility(8);
               } else {
                  this.mTitleView.setText(var1);
                  this.mTitleView.setEnabled(var2);
                  TextView var5 = this.mTitleView;
                  byte var6;
                  if(var2) {
                     var6 = 0;
                  } else {
                     var6 = 8;
                  }

                  var5.setVisibility(var6);
                  this.mSubtitleView.setText(var3);
                  TextView var7 = this.mSubtitleView;
                  byte var8;
                  if(var4) {
                     var8 = 0;
                  } else {
                     var8 = 8;
                  }

                  var7.setVisibility(var8);
               }

               if(this.mState != null) {
                  boolean var9;
                  if(this.mState.getState() != 6 && this.mState.getState() != 3) {
                     var9 = false;
                  } else {
                     var9 = true;
                  }

                  boolean var10;
                  if((516L & this.mState.getActions()) != 0L) {
                     var10 = true;
                  } else {
                     var10 = false;
                  }

                  boolean var11;
                  if((514L & this.mState.getActions()) != 0L) {
                     var11 = true;
                  } else {
                     var11 = false;
                  }

                  if(var9 && var11) {
                     this.mPlayPauseButton.setVisibility(0);
                     this.mPlayPauseButton.setImageResource(MediaRouterThemeHelper.getThemeResource(this.getContext(), class_16.attr.mediaRoutePauseDrawable));
                     this.mPlayPauseButton.setContentDescription(this.getContext().getResources().getText(class_16.string.mr_media_route_controller_pause));
                  } else if(!var9 && var10) {
                     this.mPlayPauseButton.setVisibility(0);
                     this.mPlayPauseButton.setImageResource(MediaRouterThemeHelper.getThemeResource(this.getContext(), class_16.attr.mediaRoutePlayDrawable));
                     this.mPlayPauseButton.setContentDescription(this.getContext().getResources().getText(class_16.string.mr_media_route_controller_play));
                  } else {
                     this.mPlayPauseButton.setVisibility(8);
                  }
               } else {
                  this.mPlayPauseButton.setVisibility(8);
               }
            }

            return true;
         }
      } else {
         this.dismiss();
         return false;
      }
   }

   private void updateVolume() {
      if(!this.mVolumeSliderTouched) {
         if(!this.isVolumeControlAvailable()) {
            this.mVolumeLayout.setVisibility(8);
            return;
         }

         this.mVolumeLayout.setVisibility(0);
         this.mVolumeSlider.setMax(this.mRoute.getVolumeMax());
         this.mVolumeSlider.setProgress(this.mRoute.getVolume());
      }

   }

   public View getMediaControlView() {
      return this.mControlView;
   }

   public MediaSessionCompat.Token getMediaSession() {
      return this.mMediaController == null?null:this.mMediaController.getSessionToken();
   }

   public MediaRouter.RouteInfo getRoute() {
      return this.mRoute;
   }

   public boolean isVolumeControlEnabled() {
      return this.mVolumeControlEnabled;
   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mAttachedToWindow = true;
      this.mRouter.addCallback(MediaRouteSelector.EMPTY, this.mCallback, 2);
      this.setMediaSession(this.mRouter.getMediaSessionToken());
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(class_16.layout.mr_media_route_controller_material_dialog_b);
      MediaRouteControllerDialog.ClickListener var2 = new MediaRouteControllerDialog.ClickListener(null);
      this.mDisconnectButton = (Button)this.findViewById(class_16.class_101.disconnect);
      this.mDisconnectButton.setOnClickListener(var2);
      this.mStopCastingButton = (Button)this.findViewById(class_16.class_101.stop);
      this.mStopCastingButton.setOnClickListener(var2);
      this.mSettingsButton = (ImageButton)this.findViewById(class_16.class_101.settings);
      this.mSettingsButton.setOnClickListener(var2);
      this.mArtView = (ImageView)this.findViewById(class_16.class_101.art);
      this.mTitleView = (TextView)this.findViewById(class_16.class_101.title);
      this.mSubtitleView = (TextView)this.findViewById(class_16.class_101.subtitle);
      this.mPlayPauseButton = (ImageButton)this.findViewById(class_16.class_101.play_pause);
      this.mPlayPauseButton.setOnClickListener(var2);
      this.mRouteNameView = (TextView)this.findViewById(class_16.class_101.route_name);
      this.mVolumeLayout = (LinearLayout)this.findViewById(class_16.class_101.media_route_volume_layout);
      this.mVolumeSlider = (SeekBar)this.findViewById(class_16.class_101.media_route_volume_slider);
      this.mVolumeSlider.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
         private final Runnable mStopTrackingTouch = new Runnable() {
            public void run() {
               if(MediaRouteControllerDialog.this.mVolumeSliderTouched) {
                  MediaRouteControllerDialog.this.mVolumeSliderTouched = false;
                  MediaRouteControllerDialog.this.updateVolume();
               }

            }
         };

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            if(var3) {
               MediaRouteControllerDialog.this.mRoute.requestSetVolume(var2);
            }

         }

         public void onStartTrackingTouch(SeekBar var1) {
            if(MediaRouteControllerDialog.this.mVolumeSliderTouched) {
               MediaRouteControllerDialog.this.mVolumeSlider.removeCallbacks(this.mStopTrackingTouch);
            } else {
               MediaRouteControllerDialog.this.mVolumeSliderTouched = true;
            }
         }

         public void onStopTrackingTouch(SeekBar var1) {
            MediaRouteControllerDialog.this.mVolumeSlider.postDelayed(this.mStopTrackingTouch, 250L);
         }
      });
      this.mCreated = true;
      if(this.update()) {
         this.mControlView = this.onCreateMediaControlView(var1);
         FrameLayout var3 = (FrameLayout)this.findViewById(class_16.class_101.media_route_control_frame);
         if(this.mControlView != null) {
            var3.findViewById(class_16.class_101.default_control_frame).setVisibility(8);
            var3.addView(this.mControlView);
         }
      }

   }

   public View onCreateMediaControlView(Bundle var1) {
      return null;
   }

   public void onDetachedFromWindow() {
      this.mRouter.removeCallback(this.mCallback);
      this.setMediaSession((MediaSessionCompat.Token)null);
      this.mAttachedToWindow = false;
      super.onDetachedFromWindow();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 != 25 && var1 != 24) {
         return super.onKeyDown(var1, var2);
      } else {
         MediaRouter.RouteInfo var3 = this.mRoute;
         byte var4;
         if(var1 == 25) {
            var4 = -1;
         } else {
            var4 = 1;
         }

         var3.requestUpdateVolume(var4);
         return true;
      }
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      return var1 != 25 && var1 != 24?super.onKeyUp(var1, var2):true;
   }

   public void setVolumeControlEnabled(boolean var1) {
      if(this.mVolumeControlEnabled != var1) {
         this.mVolumeControlEnabled = var1;
         if(this.mCreated) {
            this.updateVolume();
         }
      }

   }

   private final class ClickListener implements OnClickListener {
      private ClickListener() {
      }

      // $FF: synthetic method
      ClickListener(Object var2) {
         this();
      }

      public void onClick(View var1) {
         int var2 = var1.getId();
         if(var2 != class_16.class_101.stop && var2 != class_16.class_101.disconnect) {
            if(var2 == class_16.class_101.play_pause) {
               if(MediaRouteControllerDialog.this.mMediaController != null && MediaRouteControllerDialog.this.mState != null) {
                  if(MediaRouteControllerDialog.this.mState.getState() == 3) {
                     MediaRouteControllerDialog.this.mMediaController.getTransportControls().pause();
                     return;
                  }

                  MediaRouteControllerDialog.this.mMediaController.getTransportControls().play();
                  return;
               }
            } else if(var2 == class_16.class_101.settings) {
               IntentSender var5 = MediaRouteControllerDialog.this.mRoute.getSettingsIntent();
               if(var5 != null) {
                  try {
                     var5.sendIntent((Context)null, 0, (Intent)null, (OnFinished)null, (Handler)null);
                     MediaRouteControllerDialog.this.dismiss();
                     return;
                  } catch (Exception var7) {
                     Log.e("MediaRouteControllerDialog", "Error opening route settings.", var7);
                     return;
                  }
               }
            }
         } else {
            if(MediaRouteControllerDialog.this.mRoute.isSelected()) {
               MediaRouter var3 = MediaRouteControllerDialog.this.mRouter;
               byte var4;
               if(var2 == class_16.class_101.stop) {
                  var4 = 2;
               } else {
                  var4 = 1;
               }

               var3.unselect(var4);
            }

            MediaRouteControllerDialog.this.dismiss();
         }

      }
   }

   private final class MediaControllerCallback extends MediaControllerCompat.Callback {
      private MediaControllerCallback() {
      }

      // $FF: synthetic method
      MediaControllerCallback(Object var2) {
         this();
      }

      public void onMetadataChanged(MediaMetadataCompat var1) {
         MediaRouteControllerDialog var2 = MediaRouteControllerDialog.this;
         MediaDescriptionCompat var3;
         if(var1 == null) {
            var3 = null;
         } else {
            var3 = var1.getDescription();
         }

         var2.mDescription = var3;
         MediaRouteControllerDialog.this.update();
      }

      public void onPlaybackStateChanged(PlaybackStateCompat var1) {
         MediaRouteControllerDialog.this.mState = var1;
         MediaRouteControllerDialog.this.update();
      }

      public void onSessionDestroyed() {
         if(MediaRouteControllerDialog.this.mMediaController != null) {
            MediaRouteControllerDialog.this.mMediaController.unregisterCallback(MediaRouteControllerDialog.this.mControllerCallback);
            MediaRouteControllerDialog.this.mMediaController = null;
         }

      }
   }

   private final class MediaRouterCallback extends MediaRouter.Callback {
      private MediaRouterCallback() {
      }

      // $FF: synthetic method
      MediaRouterCallback(Object var2) {
         this();
      }

      public void onRouteChanged(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteControllerDialog.this.update();
      }

      public void onRouteUnselected(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteControllerDialog.this.update();
      }

      public void onRouteVolumeChanged(MediaRouter var1, MediaRouter.RouteInfo var2) {
         if(var2 == MediaRouteControllerDialog.this.mRoute) {
            MediaRouteControllerDialog.this.updateVolume();
         }

      }
   }
}
