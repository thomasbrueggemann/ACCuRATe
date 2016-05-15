package org.parceler;

import android.os.Parcelable;
import org.parceler.NonParcelRepository;
import org.parceler.ParcelWrapper;
import org.parceler.Parcels.1;
import org.parceler.Parcels.NullParcelable;
import org.parceler.Parcels.ParcelCodeRepository;

public final class Parcels {
   private static final NullParcelable NULL_PARCELABLE = new NullParcelable((1)null);
   private static final ParcelCodeRepository REPOSITORY = new ParcelCodeRepository();

   static {
      REPOSITORY.loadRepository(NonParcelRepository.getInstance());
   }

   public static <T> T unwrap(Parcelable var0) {
      return var0 == null?null:((ParcelWrapper)var0).getParcel();
   }

   public static <T> Parcelable wrap(Class<? extends T> var0, T var1) {
      return (Parcelable)(var1 == null?NULL_PARCELABLE:REPOSITORY.get(var0).buildParcelable(var1));
   }

   public static <T> Parcelable wrap(T var0) {
      return (Parcelable)(var0 == null?NULL_PARCELABLE:wrap(var0.getClass(), var0));
   }
}
