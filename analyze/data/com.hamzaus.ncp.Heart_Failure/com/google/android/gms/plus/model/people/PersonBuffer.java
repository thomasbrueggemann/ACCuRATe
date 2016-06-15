package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_436;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.class_211;
import com.google.android.gms.internal.class_288;
import com.google.android.gms.internal.kt;
import com.google.android.gms.plus.model.people.Person;

public final class PersonBuffer extends DataBuffer<Person> {
   private final e<kt> adW;

   public PersonBuffer(DataHolder var1) {
      super(var1);
      if(var1.method_4563() != null && var1.method_4563().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
         this.adW = new class_436(var1, class_288.CREATOR);
      } else {
         this.adW = null;
      }
   }

   public Person get(int var1) {
      return (Person)(this.adW != null?(Person)this.adW.method_2617(var1):new class_211(this.DD, var1));
   }
}
