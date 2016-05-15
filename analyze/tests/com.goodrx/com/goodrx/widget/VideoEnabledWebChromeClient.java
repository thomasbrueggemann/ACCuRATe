package com.goodrx.widget;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.goodrx.widget.VideoEnabledWebView;

public class VideoEnabledWebChromeClient extends WebChromeClient implements OnCompletionListener, OnErrorListener, OnPreparedListener {
   private View activityNonVideoView;
   private ViewGroup activityVideoView;
   private boolean isVideoFullscreen;
   private View loadingView;
   private VideoEnabledWebChromeClient.ToggledFullscreenCallback toggledFullscreenCallback;
   private CustomViewCallback videoViewCallback;
   private FrameLayout videoViewContainer;
   private VideoEnabledWebView webView;

   public VideoEnabledWebChromeClient() {
   }

   public VideoEnabledWebChromeClient(View var1, ViewGroup var2) {
      this.activityNonVideoView = var1;
      this.activityVideoView = var2;
      this.loadingView = null;
      this.webView = null;
      this.isVideoFullscreen = false;
   }

   public VideoEnabledWebChromeClient(View var1, ViewGroup var2, View var3) {
      this.activityNonVideoView = var1;
      this.activityVideoView = var2;
      this.loadingView = var3;
      this.webView = null;
      this.isVideoFullscreen = false;
   }

   public VideoEnabledWebChromeClient(View var1, ViewGroup var2, View var3, VideoEnabledWebView var4) {
      this.activityNonVideoView = var1;
      this.activityVideoView = var2;
      this.loadingView = var3;
      this.webView = var4;
      this.isVideoFullscreen = false;
   }

   public View getVideoLoadingProgressView() {
      if(this.loadingView != null) {
         this.loadingView.setVisibility(0);
         return this.loadingView;
      } else {
         return super.getVideoLoadingProgressView();
      }
   }

   public boolean isVideoFullscreen() {
      return this.isVideoFullscreen;
   }

   public boolean onBackPressed() {
      if(this.isVideoFullscreen) {
         this.onHideCustomView();
         return true;
      } else {
         return false;
      }
   }

   public void onCompletion(MediaPlayer var1) {
      this.onHideCustomView();
   }

   public boolean onError(MediaPlayer var1, int var2, int var3) {
      return false;
   }

   public void onHideCustomView() {
      if(this.isVideoFullscreen) {
         this.activityVideoView.setVisibility(4);
         this.activityVideoView.removeView(this.videoViewContainer);
         this.activityNonVideoView.setVisibility(0);
         if(this.videoViewCallback != null && !this.videoViewCallback.getClass().getName().contains(".chromium.")) {
            this.videoViewCallback.onCustomViewHidden();
         }

         this.isVideoFullscreen = false;
         this.videoViewContainer = null;
         this.videoViewCallback = null;
         if(this.toggledFullscreenCallback != null) {
            this.toggledFullscreenCallback.toggledFullscreen(false);
         }
      }

   }

   public void onPrepared(MediaPlayer var1) {
      if(this.loadingView != null) {
         this.loadingView.setVisibility(8);
      }

   }

   public void onShowCustomView(View var1, int var2, CustomViewCallback var3) {
      this.onShowCustomView(var1, var3);
   }

   public void onShowCustomView(View var1, CustomViewCallback var2) {
      if(var1 instanceof FrameLayout) {
         FrameLayout var3 = (FrameLayout)var1;
         View var4 = var3.getFocusedChild();
         this.isVideoFullscreen = true;
         this.videoViewContainer = var3;
         this.videoViewCallback = var2;
         this.activityNonVideoView.setVisibility(4);
         this.activityVideoView.addView(this.videoViewContainer, new LayoutParams(-1, -1));
         this.activityVideoView.setVisibility(0);
         if(var4 instanceof VideoView) {
            VideoView var14 = (VideoView)var4;
            var14.setOnPreparedListener(this);
            var14.setOnCompletionListener(this);
            var14.setOnErrorListener(this);
         } else if(this.webView != null && this.webView.getSettings().getJavaScriptEnabled() && var4 instanceof SurfaceView) {
            String var5 = "javascript:" + "var _ytrp_html5_video_last;";
            String var6 = var5 + "var _ytrp_html5_video = document.getElementsByTagName(\'video\')[0];";
            String var7 = var6 + "if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {";
            String var8 = var7 + "_ytrp_html5_video_last = _ytrp_html5_video;";
            String var9 = var8 + "function _ytrp_html5_video_ended() {";
            String var10 = var9 + "_VideoEnabledWebView.notifyVideoEnd();";
            String var11 = var10 + "}";
            String var12 = var11 + "_ytrp_html5_video.addEventListener(\'ended\', _ytrp_html5_video_ended);";
            String var13 = var12 + "}";
            this.webView.loadUrl(var13);
         }

         if(this.toggledFullscreenCallback != null) {
            this.toggledFullscreenCallback.toggledFullscreen(true);
         }
      }

   }

   public void setOnToggledFullscreen(VideoEnabledWebChromeClient.ToggledFullscreenCallback var1) {
      this.toggledFullscreenCallback = var1;
   }

   public interface ToggledFullscreenCallback {
      void toggledFullscreen(boolean var1);
   }
}
