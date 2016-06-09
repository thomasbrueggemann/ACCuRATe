package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilderHoneycomb;
import android.support.v4.app.TaskStackBuilderJellybean;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable<Intent> {
   private static final TaskStackBuilder.TaskStackBuilderImpl IMPL;
   private static final String TAG = "TaskStackBuilder";
   private final ArrayList<Intent> mIntents = new ArrayList();
   private final Context mSourceContext;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new TaskStackBuilder.TaskStackBuilderImplHoneycomb();
      } else {
         IMPL = new TaskStackBuilder.TaskStackBuilderImplBase();
      }
   }

   private TaskStackBuilder(Context var1) {
      this.mSourceContext = var1;
   }

   public static TaskStackBuilder create(Context var0) {
      return new TaskStackBuilder(var0);
   }

   public static TaskStackBuilder from(Context var0) {
      return create(var0);
   }

   public TaskStackBuilder addNextIntent(Intent var1) {
      this.mIntents.add(var1);
      return this;
   }

   public TaskStackBuilder addNextIntentWithParentStack(Intent var1) {
      ComponentName var2 = var1.getComponent();
      if(var2 == null) {
         var2 = var1.resolveActivity(this.mSourceContext.getPackageManager());
      }

      if(var2 != null) {
         this.addParentStack(var2);
      }

      this.addNextIntent(var1);
      return this;
   }

   public TaskStackBuilder addParentStack(Activity var1) {
      boolean var2 = var1 instanceof TaskStackBuilder.SupportParentable;
      Intent var3 = null;
      if(var2) {
         var3 = ((TaskStackBuilder.SupportParentable)var1).getSupportParentActivityIntent();
      }

      if(var3 == null) {
         var3 = NavUtils.getParentActivityIntent(var1);
      }

      if(var3 != null) {
         ComponentName var4 = var3.getComponent();
         if(var4 == null) {
            var4 = var3.resolveActivity(this.mSourceContext.getPackageManager());
         }

         this.addParentStack(var4);
         this.addNextIntent(var3);
      }

      return this;
   }

   public TaskStackBuilder addParentStack(ComponentName param1) {
      // $FF: Couldn't be decompiled
   }

   public TaskStackBuilder addParentStack(Class<?> var1) {
      return this.addParentStack(new ComponentName(this.mSourceContext, var1));
   }

   public Intent editIntentAt(int var1) {
      return (Intent)this.mIntents.get(var1);
   }

   public Intent getIntent(int var1) {
      return this.editIntentAt(var1);
   }

   public int getIntentCount() {
      return this.mIntents.size();
   }

   public Intent[] getIntents() {
      Intent[] var1 = new Intent[this.mIntents.size()];
      if(var1.length != 0) {
         var1[0] = (new Intent((Intent)this.mIntents.get(0))).addFlags(268484608);

         for(int var2 = 1; var2 < var1.length; ++var2) {
            var1[var2] = new Intent((Intent)this.mIntents.get(var2));
         }
      }

      return var1;
   }

   public PendingIntent getPendingIntent(int var1, int var2) {
      return this.getPendingIntent(var1, var2, (Bundle)null);
   }

   public PendingIntent getPendingIntent(int var1, int var2, Bundle var3) {
      if(this.mIntents.isEmpty()) {
         throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
      } else {
         Intent[] var4 = (Intent[])this.mIntents.toArray(new Intent[this.mIntents.size()]);
         var4[0] = (new Intent(var4[0])).addFlags(268484608);
         return IMPL.getPendingIntent(this.mSourceContext, var4, var1, var2, var3);
      }
   }

   public Iterator<Intent> iterator() {
      return this.mIntents.iterator();
   }

   public void startActivities() {
      this.startActivities((Bundle)null);
   }

   public void startActivities(Bundle var1) {
      if(this.mIntents.isEmpty()) {
         throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
      } else {
         Intent[] var2 = (Intent[])this.mIntents.toArray(new Intent[this.mIntents.size()]);
         var2[0] = (new Intent(var2[0])).addFlags(268484608);
         if(!ContextCompat.startActivities(this.mSourceContext, var2, var1)) {
            Intent var3 = new Intent(var2[-1 + var2.length]);
            var3.addFlags(268435456);
            this.mSourceContext.startActivity(var3);
         }

      }
   }

   public interface SupportParentable {
      Intent getSupportParentActivityIntent();
   }

   interface TaskStackBuilderImpl {
      PendingIntent getPendingIntent(Context var1, Intent[] var2, int var3, int var4, Bundle var5);
   }

   static class TaskStackBuilderImplBase implements TaskStackBuilder.TaskStackBuilderImpl {
      public PendingIntent getPendingIntent(Context var1, Intent[] var2, int var3, int var4, Bundle var5) {
         Intent var6 = new Intent(var2[-1 + var2.length]);
         var6.addFlags(268435456);
         return PendingIntent.getActivity(var1, var3, var6, var4);
      }
   }

   static class TaskStackBuilderImplHoneycomb implements TaskStackBuilder.TaskStackBuilderImpl {
      public PendingIntent getPendingIntent(Context var1, Intent[] var2, int var3, int var4, Bundle var5) {
         var2[0] = (new Intent(var2[0])).addFlags(268484608);
         return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(var1, var3, var2, var4);
      }
   }

   static class TaskStackBuilderImplJellybean implements TaskStackBuilder.TaskStackBuilderImpl {
      public PendingIntent getPendingIntent(Context var1, Intent[] var2, int var3, int var4, Bundle var5) {
         var2[0] = (new Intent(var2[0])).addFlags(268484608);
         return TaskStackBuilderJellybean.getActivitiesPendingIntent(var1, var3, var2, var4, var5);
      }
   }
}
