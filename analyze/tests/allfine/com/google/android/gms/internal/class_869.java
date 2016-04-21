package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.class_293;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

// $FF: renamed from: com.google.android.gms.internal.nt
public final class class_869 implements People {
    public Person getCurrentPerson(GoogleApiClient var1) {
        return Plus.method_2182(var1, Plus.field_1032).getCurrentPerson();
    }

    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient var1, final Collection<String> var2) {
        return var1.method_897(new class_869.class_1518(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1241(class_293 var1) {
                var1.method_1846(this, var2);
            }
        });
    }

    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient var1, final String... var2) {
        return var1.method_897(new class_869.class_1518(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1240(class_293 var1) {
                var1.method_1849(this, var2);
            }
        });
    }

    public PendingResult<People.LoadPeopleResult> loadConnected(GoogleApiClient var1) {
        return var1.method_897(new class_869.class_1518(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1238(class_293 var1) {
                var1.method_1851(this);
            }
        });
    }

    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient var1, final int var2, final String var3) {
        return var1.method_897(new class_869.class_1518(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1242(class_293 var1) {
                this.a(var1.method_1843(this, var2, var3));
            }
        });
    }

    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient var1, final String var2) {
        return var1.method_897(new class_869.class_1518(null) {
            // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
            protected void method_1239(class_293 var1) {
                this.a(var1.method_1853(this, var2));
            }
        });
    }

    private abstract static class class_1518 extends Plus.class_1173<People.LoadPeopleResult> {
        private class_1518() {
        }

        // $FF: synthetic method
        class_1518(Object var1) {
            this();
        }

        // $FF: renamed from: aD (com.google.android.gms.common.api.Status) com.google.android.gms.plus.People$LoadPeopleResult
        public People.LoadPeopleResult method_1237(final Status var1) {
            return new People.LoadPeopleResult() {
                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                public Status getStatus() {
                    return var1;
                }

                public void release() {
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1237(var1);
        }
    }
}
