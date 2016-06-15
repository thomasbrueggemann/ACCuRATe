package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_468;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.class_256;
import com.google.android.gms.internal.class_730;
import com.google.android.gms.internal.pi;
import com.google.android.gms.plus.model.people.Person;

public final class PersonBuffer extends DataBuffer<Person> {
   private final e<pi> apT;

   public PersonBuffer(DataHolder var1) {
      super(var1);
      if(var1.method_5837() != null && var1.method_5837().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
         this.apT = new class_468(var1, class_730.CREATOR);
      } else {
         this.apT = null;
      }
   }

   public Person get(int var1) {
      return (Person)(this.apT != null?(Person)this.apT.method_2977(var1):new class_256(this.JG, var1));
   }
}
