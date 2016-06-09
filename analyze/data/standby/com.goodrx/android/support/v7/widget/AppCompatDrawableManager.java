package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v7.appcompat.class_22;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.ThemeUtils;
import android.support.v7.widget.TintInfo;
import android.support.v7.widget.TintResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class AppCompatDrawableManager {
   private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
   private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
   private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
   private static final AppCompatDrawableManager.ColorFilterLruCache COLOR_FILTER_CACHE;
   private static final boolean DEBUG = false;
   private static final Mode DEFAULT_MODE;
   private static AppCompatDrawableManager INSTANCE;
   private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
   private static final String TAG = "AppCompatDrawableManager";
   private static final int[] TINT_CHECKABLE_BUTTON_LIST;
   private static final int[] TINT_COLOR_CONTROL_NORMAL;
   private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
   private final Object mDelegateDrawableCacheLock = new Object();
   private final WeakHashMap<Context, LongSparseArray<WeakReference<ConstantState>>> mDelegateDrawableCaches = new WeakHashMap(0);
   private ArrayMap<String, AppCompatDrawableManager.InflateDelegate> mDelegates;
   private SparseArray<String> mKnownDrawableIdTags;
   private WeakHashMap<Context, SparseArray<ColorStateList>> mTintLists;
   private TypedValue mTypedValue;

   static {
      DEFAULT_MODE = Mode.SRC_IN;
      COLOR_FILTER_CACHE = new AppCompatDrawableManager.ColorFilterLruCache(6);
      int[] var0 = new int[]{class_22.drawable.abc_textfield_search_default_mtrl_alpha, class_22.drawable.abc_textfield_default_mtrl_alpha, class_22.drawable.abc_ab_share_pack_mtrl_alpha};
      COLORFILTER_TINT_COLOR_CONTROL_NORMAL = var0;
      int[] var1 = new int[]{class_22.drawable.abc_ic_search_api_mtrl_alpha, class_22.drawable.abc_ic_commit_search_api_mtrl_alpha};
      TINT_COLOR_CONTROL_NORMAL = var1;
      int[] var2 = new int[]{class_22.drawable.abc_textfield_activated_mtrl_alpha, class_22.drawable.abc_textfield_search_activated_mtrl_alpha, class_22.drawable.abc_cab_background_top_mtrl_alpha, class_22.drawable.abc_text_cursor_material};
      COLORFILTER_COLOR_CONTROL_ACTIVATED = var2;
      int[] var3 = new int[]{class_22.drawable.abc_popup_background_mtrl_mult, class_22.drawable.abc_cab_background_internal_bg, class_22.drawable.abc_menu_hardkey_panel_mtrl_mult};
      COLORFILTER_COLOR_BACKGROUND_MULTIPLY = var3;
      int[] var4 = new int[]{class_22.drawable.abc_tab_indicator_material, class_22.drawable.abc_textfield_search_material, class_22.drawable.abc_ratingbar_full_material};
      TINT_COLOR_CONTROL_STATE_LIST = var4;
      int[] var5 = new int[]{class_22.drawable.abc_btn_check_material, class_22.drawable.abc_btn_radio_material};
      TINT_CHECKABLE_BUTTON_LIST = var5;
   }

   private boolean addCachedDelegateDrawable(@NonNull Context param1, long param2, @NonNull Drawable param4) {
      // $FF: Couldn't be decompiled
   }

   private void addDelegate(@NonNull String var1, @NonNull AppCompatDrawableManager.InflateDelegate var2) {
      if(this.mDelegates == null) {
         this.mDelegates = new ArrayMap();
      }

      this.mDelegates.put(var1, var2);
   }

   private void addTintListToCache(@NonNull Context var1, @DrawableRes int var2, @NonNull ColorStateList var3) {
      if(this.mTintLists == null) {
         this.mTintLists = new WeakHashMap();
      }

      SparseArray var4 = (SparseArray)this.mTintLists.get(var1);
      if(var4 == null) {
         var4 = new SparseArray();
         this.mTintLists.put(var1, var4);
      }

      var4.append(var2, var3);
   }

   private static boolean arrayContains(int[] var0, int var1) {
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var0[var3] == var1) {
            return true;
         }
      }

      return false;
   }

   private ColorStateList createButtonColorStateList(Context var1, int var2) {
      int[][] var3 = new int[4][];
      int[] var4 = new int[4];
      int var5 = ThemeUtils.getThemeAttrColor(var1, var2);
      int var6 = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlHighlight);
      var3[0] = ThemeUtils.DISABLED_STATE_SET;
      var4[0] = ThemeUtils.getDisabledThemeAttrColor(var1, class_22.attr.colorButtonNormal);
      int var7 = 0 + 1;
      var3[var7] = ThemeUtils.PRESSED_STATE_SET;
      var4[var7] = ColorUtils.compositeColors(var6, var5);
      int var8 = var7 + 1;
      var3[var8] = ThemeUtils.FOCUSED_STATE_SET;
      var4[var8] = ColorUtils.compositeColors(var6, var5);
      int var9 = var8 + 1;
      var3[var9] = ThemeUtils.EMPTY_STATE_SET;
      var4[var9] = var5;
      int var10000 = var9 + 1;
      return new ColorStateList(var3, var4);
   }

   private ColorStateList createCheckableButtonColorStateList(Context var1) {
      int[][] var2 = new int[3][];
      int[] var3 = new int[3];
      var2[0] = ThemeUtils.DISABLED_STATE_SET;
      var3[0] = ThemeUtils.getDisabledThemeAttrColor(var1, class_22.attr.colorControlNormal);
      int var4 = 0 + 1;
      var2[var4] = ThemeUtils.CHECKED_STATE_SET;
      var3[var4] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated);
      int var5 = var4 + 1;
      var2[var5] = ThemeUtils.EMPTY_STATE_SET;
      var3[var5] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlNormal);
      int var10000 = var5 + 1;
      return new ColorStateList(var2, var3);
   }

   private ColorStateList createColoredButtonColorStateList(Context var1) {
      return this.createButtonColorStateList(var1, class_22.attr.colorAccent);
   }

   private ColorStateList createDefaultButtonColorStateList(Context var1) {
      return this.createButtonColorStateList(var1, class_22.attr.colorButtonNormal);
   }

   private ColorStateList createDefaultColorStateList(Context var1) {
      int var2 = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlNormal);
      int var3 = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated);
      int[][] var4 = new int[7][];
      int[] var5 = new int[7];
      var4[0] = ThemeUtils.DISABLED_STATE_SET;
      var5[0] = ThemeUtils.getDisabledThemeAttrColor(var1, class_22.attr.colorControlNormal);
      int var6 = 0 + 1;
      var4[var6] = ThemeUtils.FOCUSED_STATE_SET;
      var5[var6] = var3;
      int var7 = var6 + 1;
      var4[var7] = ThemeUtils.ACTIVATED_STATE_SET;
      var5[var7] = var3;
      int var8 = var7 + 1;
      var4[var8] = ThemeUtils.PRESSED_STATE_SET;
      var5[var8] = var3;
      int var9 = var8 + 1;
      var4[var9] = ThemeUtils.CHECKED_STATE_SET;
      var5[var9] = var3;
      int var10 = var9 + 1;
      var4[var10] = ThemeUtils.SELECTED_STATE_SET;
      var5[var10] = var3;
      int var11 = var10 + 1;
      var4[var11] = ThemeUtils.EMPTY_STATE_SET;
      var5[var11] = var2;
      int var10000 = var11 + 1;
      return new ColorStateList(var4, var5);
   }

   private ColorStateList createEditTextColorStateList(Context var1) {
      int[][] var2 = new int[3][];
      int[] var3 = new int[3];
      var2[0] = ThemeUtils.DISABLED_STATE_SET;
      var3[0] = ThemeUtils.getDisabledThemeAttrColor(var1, class_22.attr.colorControlNormal);
      int var4 = 0 + 1;
      var2[var4] = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
      var3[var4] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlNormal);
      int var5 = var4 + 1;
      var2[var5] = ThemeUtils.EMPTY_STATE_SET;
      var3[var5] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated);
      int var10000 = var5 + 1;
      return new ColorStateList(var2, var3);
   }

   private ColorStateList createSeekbarThumbColorStateList(Context var1) {
      int[][] var2 = new int[2][];
      int[] var3 = new int[2];
      var2[0] = ThemeUtils.DISABLED_STATE_SET;
      var3[0] = ThemeUtils.getDisabledThemeAttrColor(var1, class_22.attr.colorControlActivated);
      int var4 = 0 + 1;
      var2[var4] = ThemeUtils.EMPTY_STATE_SET;
      var3[var4] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated);
      int var10000 = var4 + 1;
      return new ColorStateList(var2, var3);
   }

   private ColorStateList createSpinnerColorStateList(Context var1) {
      int[][] var2 = new int[3][];
      int[] var3 = new int[3];
      var2[0] = ThemeUtils.DISABLED_STATE_SET;
      var3[0] = ThemeUtils.getDisabledThemeAttrColor(var1, class_22.attr.colorControlNormal);
      int var4 = 0 + 1;
      var2[var4] = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
      var3[var4] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlNormal);
      int var5 = var4 + 1;
      var2[var5] = ThemeUtils.EMPTY_STATE_SET;
      var3[var5] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated);
      int var10000 = var5 + 1;
      return new ColorStateList(var2, var3);
   }

   private ColorStateList createSwitchThumbColorStateList(Context var1) {
      int[][] var2 = new int[3][];
      int[] var3 = new int[3];
      ColorStateList var4 = ThemeUtils.getThemeAttrColorStateList(var1, class_22.attr.colorSwitchThumbNormal);
      int var10000;
      if(var4 != null && var4.isStateful()) {
         var2[0] = ThemeUtils.DISABLED_STATE_SET;
         var3[0] = var4.getColorForState(var2[0], 0);
         int var8 = 0 + 1;
         var2[var8] = ThemeUtils.CHECKED_STATE_SET;
         var3[var8] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated);
         int var9 = var8 + 1;
         var2[var9] = ThemeUtils.EMPTY_STATE_SET;
         var3[var9] = var4.getDefaultColor();
         var10000 = var9 + 1;
      } else {
         var2[0] = ThemeUtils.DISABLED_STATE_SET;
         var3[0] = ThemeUtils.getDisabledThemeAttrColor(var1, class_22.attr.colorSwitchThumbNormal);
         int var5 = 0 + 1;
         var2[var5] = ThemeUtils.CHECKED_STATE_SET;
         var3[var5] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated);
         int var6 = var5 + 1;
         var2[var6] = ThemeUtils.EMPTY_STATE_SET;
         var3[var6] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorSwitchThumbNormal);
         var10000 = var6 + 1;
      }

      return new ColorStateList(var2, var3);
   }

   private ColorStateList createSwitchTrackColorStateList(Context var1) {
      int[][] var2 = new int[3][];
      int[] var3 = new int[3];
      var2[0] = ThemeUtils.DISABLED_STATE_SET;
      var3[0] = ThemeUtils.getThemeAttrColor(var1, 16842800, 0.1F);
      int var4 = 0 + 1;
      var2[var4] = ThemeUtils.CHECKED_STATE_SET;
      var3[var4] = ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated, 0.3F);
      int var5 = var4 + 1;
      var2[var5] = ThemeUtils.EMPTY_STATE_SET;
      var3[var5] = ThemeUtils.getThemeAttrColor(var1, 16842800, 0.3F);
      int var10000 = var5 + 1;
      return new ColorStateList(var2, var3);
   }

   private static PorterDuffColorFilter createTintFilter(ColorStateList var0, Mode var1, int[] var2) {
      return var0 != null && var1 != null?getPorterDuffColorFilter(var0.getColorForState(var2, 0), var1):null;
   }

   public static AppCompatDrawableManager get() {
      if(INSTANCE == null) {
         INSTANCE = new AppCompatDrawableManager();
         installDefaultInflateDelegates(INSTANCE);
      }

      return INSTANCE;
   }

   private Drawable getCachedDelegateDrawable(@NonNull Context param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   public static PorterDuffColorFilter getPorterDuffColorFilter(int var0, Mode var1) {
      PorterDuffColorFilter var2 = COLOR_FILTER_CACHE.get(var0, var1);
      if(var2 == null) {
         var2 = new PorterDuffColorFilter(var0, var1);
         COLOR_FILTER_CACHE.put(var0, var1, var2);
      }

      return var2;
   }

   private ColorStateList getTintListFromCache(@NonNull Context var1, @DrawableRes int var2) {
      WeakHashMap var3 = this.mTintLists;
      ColorStateList var4 = null;
      if(var3 != null) {
         SparseArray var5 = (SparseArray)this.mTintLists.get(var1);
         var4 = null;
         if(var5 != null) {
            var4 = (ColorStateList)var5.get(var2);
         }
      }

      return var4;
   }

   private static void installDefaultInflateDelegates(@NonNull AppCompatDrawableManager var0) {
      int var1 = VERSION.SDK_INT;
      if(var1 < 21) {
         var0.addDelegate("vector", new AppCompatDrawableManager.VdcInflateDelegate());
         if(var1 >= 11) {
            var0.addDelegate("animated-vector", new AppCompatDrawableManager.AvdcInflateDelegate());
         }
      }

   }

   private Drawable loadDrawableFromDelegates(@NonNull Context param1, @DrawableRes int param2) {
      // $FF: Couldn't be decompiled
   }

   private void removeDelegate(@NonNull String var1, @NonNull AppCompatDrawableManager.InflateDelegate var2) {
      if(this.mDelegates != null && this.mDelegates.get(var1) == var2) {
         this.mDelegates.remove(var1);
      }

   }

   private static void setPorterDuffColorFilter(Drawable var0, int var1, Mode var2) {
      if(DrawableUtils.canSafelyMutateDrawable(var0)) {
         var0 = var0.mutate();
      }

      if(var2 == null) {
         var2 = DEFAULT_MODE;
      }

      var0.setColorFilter(getPorterDuffColorFilter(var1, var2));
   }

   private Drawable tintDrawable(@NonNull Context var1, @DrawableRes int var2, boolean var3, @NonNull Drawable var4) {
      ColorStateList var5 = this.getTintList(var1, var2);
      if(var5 != null) {
         if(DrawableUtils.canSafelyMutateDrawable(var4)) {
            var4 = var4.mutate();
         }

         var4 = DrawableCompat.wrap(var4);
         DrawableCompat.setTintList(var4, var5);
         Mode var9 = this.getTintMode(var2);
         if(var9 != null) {
            DrawableCompat.setTintMode(var4, var9);
         }
      } else {
         if(var2 == class_22.drawable.abc_cab_background_top_material) {
            Drawable[] var8 = new Drawable[]{this.getDrawable(var1, class_22.drawable.abc_cab_background_internal_bg), this.getDrawable(var1, class_22.drawable.abc_cab_background_top_mtrl_alpha)};
            return new LayerDrawable(var8);
         }

         if(var2 == class_22.drawable.abc_seekbar_track_material) {
            LayerDrawable var7 = (LayerDrawable)var4;
            setPorterDuffColorFilter(var7.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(var7.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(var7.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated), DEFAULT_MODE);
         } else if(var2 != class_22.drawable.abc_ratingbar_indicator_material && var2 != class_22.drawable.abc_ratingbar_small_material) {
            if(!tintDrawableUsingColorFilter(var1, var2, var4) && var3) {
               var4 = null;
            }
         } else {
            LayerDrawable var6 = (LayerDrawable)var4;
            setPorterDuffColorFilter(var6.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(var1, class_22.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(var6.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated), DEFAULT_MODE);
            setPorterDuffColorFilter(var6.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(var1, class_22.attr.colorControlActivated), DEFAULT_MODE);
         }
      }

      return var4;
   }

   public static void tintDrawable(Drawable var0, TintInfo var1, int[] var2) {
      if(DrawableUtils.canSafelyMutateDrawable(var0) && var0.mutate() != var0) {
         Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
      } else {
         if(!var1.mHasTintList && !var1.mHasTintMode) {
            var0.clearColorFilter();
         } else {
            ColorStateList var3;
            if(var1.mHasTintList) {
               var3 = var1.mTintList;
            } else {
               var3 = null;
            }

            Mode var4;
            if(var1.mHasTintMode) {
               var4 = var1.mTintMode;
            } else {
               var4 = DEFAULT_MODE;
            }

            var0.setColorFilter(createTintFilter(var3, var4, var2));
         }

         if(VERSION.SDK_INT <= 23) {
            var0.invalidateSelf();
            return;
         }
      }

   }

   private static boolean tintDrawableUsingColorFilter(@NonNull Context var0, @DrawableRes int var1, @NonNull Drawable var2) {
      Mode var3 = DEFAULT_MODE;
      int var4 = -1;
      int var6;
      boolean var7;
      if(arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, var1)) {
         var6 = class_22.attr.colorControlNormal;
         var7 = true;
      } else if(arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, var1)) {
         var6 = class_22.attr.colorControlActivated;
         var7 = true;
      } else if(arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, var1)) {
         var6 = 16842801;
         var7 = true;
         var3 = Mode.MULTIPLY;
      } else {
         int var5 = class_22.drawable.abc_list_divider_mtrl_alpha;
         var6 = 0;
         var7 = false;
         if(var1 == var5) {
            var6 = 16842800;
            var7 = true;
            var4 = Math.round(40.8F);
         }
      }

      if(var7) {
         if(DrawableUtils.canSafelyMutateDrawable(var2)) {
            var2 = var2.mutate();
         }

         var2.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(var0, var6), var3));
         if(var4 != -1) {
            var2.setAlpha(var4);
         }

         return true;
      } else {
         return false;
      }
   }

   public Drawable getDrawable(@NonNull Context var1, @DrawableRes int var2) {
      return this.getDrawable(var1, var2, false);
   }

   public Drawable getDrawable(@NonNull Context var1, @DrawableRes int var2, boolean var3) {
      Drawable var4 = this.loadDrawableFromDelegates(var1, var2);
      if(var4 == null) {
         var4 = ContextCompat.getDrawable(var1, var2);
      }

      if(var4 != null) {
         var4 = this.tintDrawable(var1, var2, var3, var4);
      }

      if(var4 != null) {
         DrawableUtils.fixDrawable(var4);
      }

      return var4;
   }

   public final ColorStateList getTintList(@NonNull Context var1, @DrawableRes int var2) {
      ColorStateList var3 = this.getTintListFromCache(var1, var2);
      if(var3 == null) {
         if(var2 == class_22.drawable.abc_edit_text_material) {
            var3 = this.createEditTextColorStateList(var1);
         } else if(var2 == class_22.drawable.abc_switch_track_mtrl_alpha) {
            var3 = this.createSwitchTrackColorStateList(var1);
         } else if(var2 == class_22.drawable.abc_switch_thumb_material) {
            var3 = this.createSwitchThumbColorStateList(var1);
         } else if(var2 != class_22.drawable.abc_btn_default_mtrl_shape && var2 != class_22.drawable.abc_btn_borderless_material) {
            if(var2 == class_22.drawable.abc_btn_colored_material) {
               var3 = this.createColoredButtonColorStateList(var1);
            } else if(var2 != class_22.drawable.abc_spinner_mtrl_am_alpha && var2 != class_22.drawable.abc_spinner_textfield_background_material) {
               if(arrayContains(TINT_COLOR_CONTROL_NORMAL, var2)) {
                  var3 = ThemeUtils.getThemeAttrColorStateList(var1, class_22.attr.colorControlNormal);
               } else if(arrayContains(TINT_COLOR_CONTROL_STATE_LIST, var2)) {
                  var3 = this.createDefaultColorStateList(var1);
               } else if(arrayContains(TINT_CHECKABLE_BUTTON_LIST, var2)) {
                  var3 = this.createCheckableButtonColorStateList(var1);
               } else if(var2 == class_22.drawable.abc_seekbar_thumb_material) {
                  var3 = this.createSeekbarThumbColorStateList(var1);
               }
            } else {
               var3 = this.createSpinnerColorStateList(var1);
            }
         } else {
            var3 = this.createDefaultButtonColorStateList(var1);
         }

         if(var3 != null) {
            this.addTintListToCache(var1, var2, var3);
         }
      }

      return var3;
   }

   final Mode getTintMode(int var1) {
      int var2 = class_22.drawable.abc_switch_thumb_material;
      Mode var3 = null;
      if(var1 == var2) {
         var3 = Mode.MULTIPLY;
      }

      return var3;
   }

   public final Drawable onDrawableLoadedFromResources(@NonNull Context var1, @NonNull TintResources var2, @DrawableRes int var3) {
      Drawable var4 = this.loadDrawableFromDelegates(var1, var3);
      if(var4 == null) {
         var4 = var2.superGetDrawable(var3);
      }

      return var4 != null?this.tintDrawable(var1, var3, false, var4):null;
   }

   private static class AvdcInflateDelegate implements AppCompatDrawableManager.InflateDelegate {
      private AvdcInflateDelegate() {
      }

      // $FF: synthetic method
      AvdcInflateDelegate(Object var1) {
         this();
      }

      public Drawable createFromXmlInner(@NonNull Context var1, @NonNull XmlPullParser var2, @NonNull AttributeSet var3, @Nullable Theme var4) {
         try {
            AnimatedVectorDrawableCompat var7 = AnimatedVectorDrawableCompat.createFromXmlInner(var1, var1.getResources(), var2, var3, var4);
            return var7;
         } catch (Exception var8) {
            Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", var8);
            return null;
         }
      }
   }

   private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
      public ColorFilterLruCache(int var1) {
         super(var1);
      }

      private static int generateCacheKey(int var0, Mode var1) {
         return 31 * (var0 + 31) + var1.hashCode();
      }

      PorterDuffColorFilter get(int var1, Mode var2) {
         return (PorterDuffColorFilter)this.get(Integer.valueOf(generateCacheKey(var1, var2)));
      }

      PorterDuffColorFilter put(int var1, Mode var2, PorterDuffColorFilter var3) {
         return (PorterDuffColorFilter)this.put(Integer.valueOf(generateCacheKey(var1, var2)), var3);
      }
   }

   private interface InflateDelegate {
      Drawable createFromXmlInner(@NonNull Context var1, @NonNull XmlPullParser var2, @NonNull AttributeSet var3, @Nullable Theme var4);
   }

   private static class VdcInflateDelegate implements AppCompatDrawableManager.InflateDelegate {
      private VdcInflateDelegate() {
      }

      // $FF: synthetic method
      VdcInflateDelegate(Object var1) {
         this();
      }

      public Drawable createFromXmlInner(@NonNull Context var1, @NonNull XmlPullParser var2, @NonNull AttributeSet var3, @Nullable Theme var4) {
         try {
            VectorDrawableCompat var7 = VectorDrawableCompat.createFromXmlInner(var1.getResources(), var2, var3, var4);
            return var7;
         } catch (Exception var8) {
            Log.e("VdcInflateDelegate", "Exception while inflating <vector>", var8);
            return null;
         }
      }
   }
}
