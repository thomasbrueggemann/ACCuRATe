package org.joda.time;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.DateTimeUtils;
import org.joda.time.IllegalInstantException;
import org.joda.time.JodaTimePermission;
import org.joda.time.LocalDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.UTCDateTimeZone;
import org.joda.time.DateTimeZone.LazyInit;
import org.joda.time.DateTimeZone.Stub;
import org.joda.time.format.FormatUtils;
import org.joda.time.tz.DefaultNameProvider;
import org.joda.time.tz.FixedDateTimeZone;
import org.joda.time.tz.NameProvider;
import org.joda.time.tz.Provider;

public abstract class DateTimeZone implements Serializable {
   private static final int MAX_MILLIS = 86399999;
   public static final DateTimeZone UTC;
   private static final AtomicReference<DateTimeZone> cDefault;
   private static final AtomicReference<NameProvider> cNameProvider;
   private static final AtomicReference<Provider> cProvider;
   private static final long serialVersionUID = 5546345482340108586L;
   private final String iID;

   static {
      UTC = UTCDateTimeZone.INSTANCE;
      cProvider = new AtomicReference();
      cNameProvider = new AtomicReference();
      cDefault = new AtomicReference();
   }

   protected DateTimeZone(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Id must not be null");
      } else {
         this.iID = var1;
      }
   }

   private static DateTimeZone fixedOffsetZone(String var0, int var1) {
      return (DateTimeZone)(var1 == 0?UTC:new FixedDateTimeZone(var0, (String)null, var1, var1));
   }

   @FromString
   public static DateTimeZone forID(String var0) {
      DateTimeZone var1;
      if(var0 == null) {
         var1 = getDefault();
      } else {
         if(var0.equals("UTC")) {
            return UTC;
         }

         var1 = getProvider().getZone(var0);
         if(var1 == null) {
            if(!var0.startsWith("+") && !var0.startsWith("-")) {
               throw new IllegalArgumentException("The datetime zone id \'" + var0 + "\' is not recognised");
            }

            int var2 = parseOffset(var0);
            if((long)var2 == 0L) {
               return UTC;
            }

            return fixedOffsetZone(printOffset(var2), var2);
         }
      }

      return var1;
   }

   public static DateTimeZone forOffsetHours(int var0) throws IllegalArgumentException {
      return forOffsetHoursMinutes(var0, 0);
   }

   public static DateTimeZone forOffsetHoursMinutes(int param0, int param1) throws IllegalArgumentException {
      // $FF: Couldn't be decompiled
   }

   public static DateTimeZone forOffsetMillis(int var0) {
      if(var0 >= -86399999 && var0 <= 86399999) {
         return fixedOffsetZone(printOffset(var0), var0);
      } else {
         throw new IllegalArgumentException("Millis out of range: " + var0);
      }
   }

   public static DateTimeZone forTimeZone(TimeZone var0) {
      DateTimeZone var4;
      if(var0 == null) {
         var4 = getDefault();
      } else {
         String var1 = var0.getID();
         if(var1 == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
         }

         if(var1.equals("UTC")) {
            return UTC;
         }

         String var2 = getConvertedId(var1);
         Provider var3 = getProvider();
         var4 = null;
         if(var2 != null) {
            var4 = var3.getZone(var2);
         }

         if(var4 == null) {
            var4 = var3.getZone(var1);
         }

         if(var4 == null) {
            if(var2 == null && (var1.startsWith("GMT+") || var1.startsWith("GMT-"))) {
               int var5 = parseOffset(var1.substring(3));
               if((long)var5 == 0L) {
                  return UTC;
               }

               return fixedOffsetZone(printOffset(var5), var5);
            }

            throw new IllegalArgumentException("The datetime zone id \'" + var1 + "\' is not recognised");
         }
      }

      return var4;
   }

   public static Set<String> getAvailableIDs() {
      return getProvider().getAvailableIDs();
   }

   private static String getConvertedId(String var0) {
      return (String)LazyInit.CONVERSION_MAP.get(var0);
   }

   public static DateTimeZone getDefault() {
      // $FF: Couldn't be decompiled
   }

   private static NameProvider getDefaultNameProvider() {
      // $FF: Couldn't be decompiled
   }

   private static Provider getDefaultProvider() {
      // $FF: Couldn't be decompiled
   }

   public static NameProvider getNameProvider() {
      NameProvider var0 = (NameProvider)cNameProvider.get();
      if(var0 == null) {
         var0 = getDefaultNameProvider();
         if(!cNameProvider.compareAndSet((Object)null, var0)) {
            var0 = (NameProvider)cNameProvider.get();
         }
      }

      return var0;
   }

   public static Provider getProvider() {
      Provider var0 = (Provider)cProvider.get();
      if(var0 == null) {
         var0 = getDefaultProvider();
         if(!cProvider.compareAndSet((Object)null, var0)) {
            var0 = (Provider)cProvider.get();
         }
      }

      return var0;
   }

   private static int parseOffset(String var0) {
      return -((int)LazyInit.OFFSET_FORMATTER.parseMillis(var0));
   }

   private static String printOffset(int var0) {
      StringBuffer var1 = new StringBuffer();
      if(var0 >= 0) {
         var1.append('+');
      } else {
         var1.append('-');
         var0 = -var0;
      }

      int var3 = var0 / 3600000;
      FormatUtils.appendPaddedInteger(var1, var3, 2);
      int var4 = var0 - var3 * 3600000;
      int var5 = var4 / '\uea60';
      var1.append(':');
      FormatUtils.appendPaddedInteger(var1, var5, 2);
      int var7 = var4 - var5 * '\uea60';
      if(var7 == 0) {
         return var1.toString();
      } else {
         int var8 = var7 / 1000;
         var1.append(':');
         FormatUtils.appendPaddedInteger(var1, var8, 2);
         int var10 = var7 - var8 * 1000;
         if(var10 == 0) {
            return var1.toString();
         } else {
            var1.append('.');
            FormatUtils.appendPaddedInteger(var1, var10, 3);
            return var1.toString();
         }
      }
   }

   public static void setDefault(DateTimeZone var0) throws SecurityException {
      SecurityManager var1 = System.getSecurityManager();
      if(var1 != null) {
         var1.checkPermission(new JodaTimePermission("DateTimeZone.setDefault"));
      }

      if(var0 == null) {
         throw new IllegalArgumentException("The datetime zone must not be null");
      } else {
         cDefault.set(var0);
      }
   }

   public static void setNameProvider(NameProvider var0) throws SecurityException {
      SecurityManager var1 = System.getSecurityManager();
      if(var1 != null) {
         var1.checkPermission(new JodaTimePermission("DateTimeZone.setNameProvider"));
      }

      if(var0 == null) {
         var0 = getDefaultNameProvider();
      }

      cNameProvider.set(var0);
   }

   public static void setProvider(Provider var0) throws SecurityException {
      SecurityManager var1 = System.getSecurityManager();
      if(var1 != null) {
         var1.checkPermission(new JodaTimePermission("DateTimeZone.setProvider"));
      }

      if(var0 == null) {
         var0 = getDefaultProvider();
      } else {
         validateProvider(var0);
      }

      cProvider.set(var0);
   }

   private static Provider validateProvider(Provider var0) {
      Set var1 = var0.getAvailableIDs();
      if(var1 != null && var1.size() != 0) {
         if(!var1.contains("UTC")) {
            throw new IllegalArgumentException("The provider doesn\'t support UTC");
         } else if(!UTC.equals(var0.getZone("UTC"))) {
            throw new IllegalArgumentException("Invalid UTC zone provided");
         } else {
            return var0;
         }
      } else {
         throw new IllegalArgumentException("The provider doesn\'t have any available ids");
      }
   }

   public long adjustOffset(long var1, boolean var3) {
      long var4 = var1 - 10800000L;
      long var6 = 10800000L + var1;
      long var8 = (long)this.getOffset(var4);
      long var10 = (long)this.getOffset(var6);
      if(var8 > var10) {
         long var12 = var8 - var10;
         long var14 = this.nextTransition(var4);
         long var16 = var14 - var12;
         long var18 = var14 + var12;
         if(var1 >= var16 && var1 < var18) {
            if(var1 - var16 >= var12) {
               if(!var3) {
                  return var1 - var12;
               }
            } else if(var3) {
               return var1 + var12;
            }
         }
      }

      return var1;
   }

   public long convertLocalToUTC(long var1, boolean var3) {
      int var8;
      label36: {
         long var4 = Long.MAX_VALUE;
         int var6 = this.getOffset(var1);
         int var7 = this.getOffset(var1 - (long)var6);
         if(var6 != var7 && (var3 || var6 < 0)) {
            long var11 = this.nextTransition(var1 - (long)var6);
            if(var11 == var1 - (long)var6) {
               var11 = var4;
            }

            long var13 = this.nextTransition(var1 - (long)var7);
            if(var13 != var1 - (long)var7) {
               var4 = var13;
            }

            if(var11 != var4) {
               if(var3) {
                  throw new IllegalInstantException(var1, this.getID());
               }

               var8 = var6;
               break label36;
            }
         }

         var8 = var7;
      }

      long var9 = var1 - (long)var8;
      if((var1 ^ var9) < 0L && (var1 ^ (long)var8) < 0L) {
         throw new ArithmeticException("Subtracting time zone offset caused overflow");
      } else {
         return var9;
      }
   }

   public long convertLocalToUTC(long var1, boolean var3, long var4) {
      int var6 = this.getOffset(var4);
      long var7 = var1 - (long)var6;
      return this.getOffset(var7) == var6?var7:this.convertLocalToUTC(var1, var3);
   }

   public long convertUTCToLocal(long var1) {
      int var3 = this.getOffset(var1);
      long var4 = var1 + (long)var3;
      if((var1 ^ var4) < 0L && (var1 ^ (long)var3) >= 0L) {
         throw new ArithmeticException("Adding time zone offset caused overflow");
      } else {
         return var4;
      }
   }

   public abstract boolean equals(Object var1);

   @ToString
   public final String getID() {
      return this.iID;
   }

   public long getMillisKeepLocal(DateTimeZone var1, long var2) {
      DateTimeZone var4;
      if(var1 == null) {
         var4 = getDefault();
      } else {
         var4 = var1;
      }

      return var4 == this?var2:var4.convertLocalToUTC(this.convertUTCToLocal(var2), false, var2);
   }

   public final String getName(long var1) {
      return this.getName(var1, (Locale)null);
   }

   public String getName(long var1, Locale var3) {
      if(var3 == null) {
         var3 = Locale.getDefault();
      }

      String var4 = this.getNameKey(var1);
      String var6;
      if(var4 == null) {
         var6 = this.iID;
      } else {
         NameProvider var5 = getNameProvider();
         if(var5 instanceof DefaultNameProvider) {
            var6 = ((DefaultNameProvider)var5).getName(var3, this.iID, var4, this.isStandardOffset(var1));
         } else {
            var6 = var5.getName(var3, this.iID, var4);
         }

         if(var6 == null) {
            return printOffset(this.getOffset(var1));
         }
      }

      return var6;
   }

   public abstract String getNameKey(long var1);

   public abstract int getOffset(long var1);

   public final int getOffset(ReadableInstant var1) {
      return var1 == null?this.getOffset(DateTimeUtils.currentTimeMillis()):this.getOffset(var1.getMillis());
   }

   public int getOffsetFromLocal(long var1) {
      long var3 = Long.MAX_VALUE;
      int var5 = this.getOffset(var1);
      long var6 = var1 - (long)var5;
      int var8 = this.getOffset(var6);
      int var11;
      if(var5 != var8) {
         if(var5 - var8 < 0) {
            long var13 = this.nextTransition(var6);
            if(var13 == var1 - (long)var5) {
               var13 = var3;
            }

            long var15 = this.nextTransition(var1 - (long)var8);
            if(var15 != var1 - (long)var8) {
               var3 = var15;
            }

            if(var13 != var3) {
               var11 = var5;
               return var11;
            }
         }
      } else if(var5 >= 0) {
         long var9 = this.previousTransition(var6);
         if(var9 < var6) {
            var11 = this.getOffset(var9);
            int var12 = var11 - var5;
            if(var6 - var9 <= (long)var12) {
               return var11;
            }
         }
      }

      return var8;
   }

   public final String getShortName(long var1) {
      return this.getShortName(var1, (Locale)null);
   }

   public String getShortName(long var1, Locale var3) {
      if(var3 == null) {
         var3 = Locale.getDefault();
      }

      String var4 = this.getNameKey(var1);
      String var6;
      if(var4 == null) {
         var6 = this.iID;
      } else {
         NameProvider var5 = getNameProvider();
         if(var5 instanceof DefaultNameProvider) {
            var6 = ((DefaultNameProvider)var5).getShortName(var3, this.iID, var4, this.isStandardOffset(var1));
         } else {
            var6 = var5.getShortName(var3, this.iID, var4);
         }

         if(var6 == null) {
            return printOffset(this.getOffset(var1));
         }
      }

      return var6;
   }

   public abstract int getStandardOffset(long var1);

   public int hashCode() {
      return 57 + this.getID().hashCode();
   }

   public abstract boolean isFixed();

   public boolean isLocalDateTimeGap(LocalDateTime var1) {
      if(this.isFixed()) {
         return false;
      } else {
         try {
            var1.toDateTime(this);
            return false;
         } catch (IllegalInstantException var3) {
            return true;
         }
      }
   }

   public boolean isStandardOffset(long var1) {
      return this.getOffset(var1) == this.getStandardOffset(var1);
   }

   public abstract long nextTransition(long var1);

   public abstract long previousTransition(long var1);

   public String toString() {
      return this.getID();
   }

   public TimeZone toTimeZone() {
      return TimeZone.getTimeZone(this.iID);
   }

   protected Object writeReplace() throws ObjectStreamException {
      return new Stub(this.iID);
   }
}
