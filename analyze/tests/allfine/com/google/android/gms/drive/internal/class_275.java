package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.class_89;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.class_197;
import com.google.android.gms.drive.internal.class_266;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.drive.internal.y
public class class_275 extends class_197.class_1305 {
    // $FF: renamed from: Oa int
    private final int field_828;
    // $FF: renamed from: Pe com.google.android.gms.drive.events.c
    private final class_89 field_829;
    // $FF: renamed from: Pf com.google.android.gms.drive.internal.y$a
    private final class_275.class_1718 field_830;
    // $FF: renamed from: Pg java.util.List
    private final List<Integer> field_831 = new ArrayList();

    public class_275(Looper var1, Context var2, int var3, class_89 var4) {
        this.field_828 = var3;
        this.field_829 = var4;
        this.field_830 = new class_275.class_1718(var1, var2);
    }

    // $FF: renamed from: bq (int) void
    public void method_1732(int var1) {
        this.field_831.add(Integer.valueOf(var1));
    }

    // $FF: renamed from: br (int) boolean
    public boolean method_1733(int var1) {
        return this.field_831.contains(Integer.valueOf(var1));
    }

    // $FF: renamed from: c (com.google.android.gms.drive.internal.OnEventResponse) void
    public void method_1000(OnEventResponse var1) throws RemoteException {
        DriveEvent var2 = var1.method_3527();
        boolean var3;
        if(this.field_828 == var2.getType()) {
            var3 = true;
        } else {
            var3 = false;
        }

        class_1090.method_5674(var3);
        class_1090.method_5674(this.field_831.contains(Integer.valueOf(var2.getType())));
        this.field_830.method_5844(this.field_829, var2);
    }

    private static class class_1718 extends Handler {
        private final Context mContext;

        private class_1718(Looper var1, Context var2) {
            super(var1);
            this.mContext = var2;
        }

        // $FF: synthetic method
        class_1718(Looper var1, Context var2, Object var3) {
            this(var1, var2);
        }

        // $FF: renamed from: a (com.google.android.gms.drive.events.c, com.google.android.gms.drive.events.DriveEvent) void
        public void method_5844(class_89 var1, DriveEvent var2) {
            this.sendMessage(this.obtainMessage(1, new Pair(var1, var2)));
        }

        public void handleMessage(Message var1) {
            switch(var1.what) {
                case 1:
                    Pair var2 = (Pair)var1.obj;
                    class_89 var3 = (class_89)var2.first;
                    DriveEvent var4 = (DriveEvent)var2.second;
                    switch(var4.getType()) {
                        case 1:
                            if(var3 instanceof DriveEvent.Listener) {
                                ((DriveEvent.Listener)var3).onEvent((ChangeEvent)var4);
                                return;
                            }

                            ((ChangeListener)var3).onChange((ChangeEvent)var4);
                            return;
                        case 2:
                            ((CompletionListener)var3).onCompletion((CompletionEvent)var4);
                            return;
                        default:
                            class_266.method_1686("EventCallback", "Unexpected event: " + var4);
                            return;
                    }
                default:
                    class_266.method_1684(this.mContext, "EventCallback", "Don\'t know how to handle this event");
            }
        }
    }
}
