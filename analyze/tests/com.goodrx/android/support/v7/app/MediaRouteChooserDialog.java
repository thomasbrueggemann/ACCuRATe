package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.MediaRouterThemeHelper;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.mediarouter.class_16;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MediaRouteChooserDialog extends Dialog {
   private MediaRouteChooserDialog.RouteAdapter mAdapter;
   private boolean mAttachedToWindow;
   private final MediaRouteChooserDialog.MediaRouterCallback mCallback;
   private ListView mListView;
   private final MediaRouter mRouter;
   private ArrayList<MediaRouter.RouteInfo> mRoutes;
   private MediaRouteSelector mSelector;

   public MediaRouteChooserDialog(Context var1) {
      this(var1, 0);
   }

   public MediaRouteChooserDialog(Context var1, int var2) {
      super(MediaRouterThemeHelper.createThemedContext(var1), var2);
      this.mSelector = MediaRouteSelector.EMPTY;
      this.mRouter = MediaRouter.getInstance(this.getContext());
      this.mCallback = new MediaRouteChooserDialog.MediaRouterCallback();
   }

   @NonNull
   public MediaRouteSelector getRouteSelector() {
      return this.mSelector;
   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mAttachedToWindow = true;
      this.mRouter.addCallback(this.mSelector, this.mCallback, 1);
      this.refreshRoutes();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.getWindow().requestFeature(3);
      this.setContentView(class_16.layout.mr_media_route_chooser_dialog);
      this.setTitle(class_16.string.mr_media_route_chooser_title);
      this.getWindow().setFeatureDrawableResource(3, MediaRouterThemeHelper.getThemeResource(this.getContext(), class_16.attr.mediaRouteOffDrawable));
      this.mRoutes = new ArrayList();
      this.mAdapter = new MediaRouteChooserDialog.RouteAdapter(this.getContext(), this.mRoutes);
      this.mListView = (ListView)this.findViewById(class_16.class_101.media_route_list);
      this.mListView.setAdapter(this.mAdapter);
      this.mListView.setOnItemClickListener(this.mAdapter);
      this.mListView.setEmptyView(this.findViewById(16908292));
   }

   public void onDetachedFromWindow() {
      this.mAttachedToWindow = false;
      this.mRouter.removeCallback(this.mCallback);
      super.onDetachedFromWindow();
   }

   public boolean onFilterRoute(@NonNull MediaRouter.RouteInfo var1) {
      return !var1.isDefault() && var1.isEnabled() && var1.matchesSelector(this.mSelector);
   }

   public void onFilterRoutes(@NonNull List<MediaRouter.RouteInfo> var1) {
      int var2 = var1.size();

      while(true) {
         int var3 = var2 - 1;
         if(var2 <= 0) {
            return;
         }

         if(!this.onFilterRoute((MediaRouter.RouteInfo)var1.get(var3))) {
            var1.remove(var3);
            var2 = var3;
         } else {
            var2 = var3;
         }
      }
   }

   public void refreshRoutes() {
      if(this.mAttachedToWindow) {
         this.mRoutes.clear();
         this.mRoutes.addAll(this.mRouter.getRoutes());
         this.onFilterRoutes(this.mRoutes);
         Collections.sort(this.mRoutes, MediaRouteChooserDialog.RouteComparator.sInstance);
         this.mAdapter.notifyDataSetChanged();
      }

   }

   public void setRouteSelector(@NonNull MediaRouteSelector var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("selector must not be null");
      } else {
         if(!this.mSelector.equals(var1)) {
            this.mSelector = var1;
            if(this.mAttachedToWindow) {
               this.mRouter.removeCallback(this.mCallback);
               this.mRouter.addCallback(var1, this.mCallback, 1);
            }

            this.refreshRoutes();
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

      public void onRouteAdded(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteChooserDialog.this.refreshRoutes();
      }

      public void onRouteChanged(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteChooserDialog.this.refreshRoutes();
      }

      public void onRouteRemoved(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteChooserDialog.this.refreshRoutes();
      }

      public void onRouteSelected(MediaRouter var1, MediaRouter.RouteInfo var2) {
         MediaRouteChooserDialog.this.dismiss();
      }
   }

   private final class RouteAdapter extends ArrayAdapter<MediaRouter.RouteInfo> implements OnItemClickListener {
      private final LayoutInflater mInflater;

      public RouteAdapter(Context var1, List<MediaRouter.RouteInfo> var2) {
         super(var2, 0, var3);
         this.mInflater = LayoutInflater.from(var2);
      }

      public boolean areAllItemsEnabled() {
         return false;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         View var4 = var2;
         if(var2 == null) {
            var4 = this.mInflater.inflate(class_16.layout.mr_media_route_list_item, var3, false);
         }

         MediaRouter.RouteInfo var5 = (MediaRouter.RouteInfo)this.getItem(var1);
         TextView var6 = (TextView)var4.findViewById(16908308);
         TextView var7 = (TextView)var4.findViewById(16908309);
         var6.setText(var5.getName());
         String var8 = var5.getDescription();
         if(TextUtils.isEmpty(var8)) {
            var7.setVisibility(8);
            var7.setText("");
         } else {
            var7.setVisibility(0);
            var7.setText(var8);
         }

         var4.setEnabled(var5.isEnabled());
         return var4;
      }

      public boolean isEnabled(int var1) {
         return ((MediaRouter.RouteInfo)this.getItem(var1)).isEnabled();
      }

      public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
         MediaRouter.RouteInfo var6 = (MediaRouter.RouteInfo)this.getItem(var3);
         if(var6.isEnabled()) {
            var6.select();
            MediaRouteChooserDialog.this.dismiss();
         }

      }
   }

   private static final class RouteComparator implements Comparator<MediaRouter.RouteInfo> {
      public static final MediaRouteChooserDialog.RouteComparator sInstance = new MediaRouteChooserDialog.RouteComparator();

      public int compare(MediaRouter.RouteInfo var1, MediaRouter.RouteInfo var2) {
         return var1.getName().compareTo(var2.getName());
      }
   }
}
