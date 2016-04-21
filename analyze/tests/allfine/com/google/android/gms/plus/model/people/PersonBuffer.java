package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_477;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.class_259;
import com.google.android.gms.internal.class_272;
import com.google.android.gms.internal.nz;
import com.google.android.gms.plus.model.people.Person;

public final class PersonBuffer extends DataBuffer<Person> {
    private final e<nz> anJ;

    public PersonBuffer(DataHolder var1) {
        super(var1);
        if(var1.method_5998() != null && var1.method_5998().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.anJ = new class_477(var1, class_272.CREATOR);
        } else {
            this.anJ = null;
        }
    }

    public Person get(int var1) {
        return (Person)(this.anJ != null?(Person)this.anJ.method_2894(var1):new class_259(this.II, var1));
    }
}
