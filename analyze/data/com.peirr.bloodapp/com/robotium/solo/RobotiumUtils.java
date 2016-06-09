package com.robotium.solo;

import android.view.View;
import android.widget.TextView;
import com.robotium.solo.ViewLocationComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RobotiumUtils {
   public static <T> ArrayList<T> filterViews(Class<T> var0, Iterable<?> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if(var4 != null && var0.isAssignableFrom(var4.getClass())) {
            var2.add(var0.cast(var4));
         }
      }

      return var2;
   }

   public static <T extends TextView> List<T> filterViewsByText(Iterable<T> var0, String var1) {
      return filterViewsByText(var0, Pattern.compile(var1));
   }

   public static <T extends TextView> List<T> filterViewsByText(Iterable<T> var0, Pattern var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         TextView var4 = (TextView)var3.next();
         if(var4 != null && var1.matcher(var4.getText()).matches()) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public static ArrayList<View> filterViewsToSet(Class<View>[] var0, Iterable<View> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(true) {
         while(true) {
            View var4;
            do {
               if(!var3.hasNext()) {
                  return var2;
               }

               var4 = (View)var3.next();
            } while(var4 == null);

            int var5 = var0.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               if(var0[var6].isAssignableFrom(var4.getClass())) {
                  var2.add(var4);
                  break;
               }
            }
         }
      }
   }

   public static int getNumberOfMatches(String var0, TextView var1, Set<TextView> var2) {
      if(var1 == null) {
         return var2.size();
      } else {
         Pattern var4;
         label32: {
            Pattern var8;
            try {
               var8 = Pattern.compile(var0);
            } catch (PatternSyntaxException var9) {
               var4 = Pattern.compile(var0, 16);
               break label32;
            }

            var4 = var8;
         }

         if(var4.matcher(var1.getText().toString()).find()) {
            var2.add(var1);
         }

         if(var1.getError() != null && var4.matcher(var1.getError().toString()).find()) {
            var2.add(var1);
         }

         if(var1.getText().toString().equals("") && var1.getHint() != null && var4.matcher(var1.getHint().toString()).find()) {
            var2.add(var1);
         }

         return var2.size();
      }
   }

   public static <T extends View> ArrayList<T> removeInvisibleViews(Iterable<T> var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         View var3 = (View)var2.next();
         if(var3 != null && var3.isShown()) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public static void sortViewsByLocationOnScreen(List<? extends View> var0) {
      Collections.sort(var0, new ViewLocationComparator());
   }

   public static void sortViewsByLocationOnScreen(List<? extends View> var0, boolean var1) {
      Collections.sort(var0, new ViewLocationComparator(var1));
   }
}
