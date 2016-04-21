package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.class_204;
import com.google.android.gms.dynamic.f;
import java.util.Iterator;
import java.util.LinkedList;

// $FF: renamed from: com.google.android.gms.dynamic.a
public abstract class class_428<T extends LifecycleDelegate> {
    // $FF: renamed from: RX com.google.android.gms.dynamic.LifecycleDelegate
    private T field_1574;
    // $FF: renamed from: RY android.os.Bundle
    private Bundle field_1575;
    // $FF: renamed from: RZ java.util.LinkedList
    private LinkedList<class_428.class_1168> field_1576;
    // $FF: renamed from: Sa com.google.android.gms.dynamic.f
    private final f<T> field_1577 = new class_204() {
        // $FF: renamed from: a (com.google.android.gms.dynamic.LifecycleDelegate) void
        public void method_1058(T var1) {
            class_428.this.field_1574 = var1;
            Iterator var3 = class_428.this.field_1576.iterator();

            while(var3.hasNext()) {
                ((class_428.class_1168)var3.next()).method_77(class_428.this.field_1574);
            }

            class_428.this.field_1576.clear();
            class_428.this.field_1575 = null;
        }
    };

    // $FF: renamed from: a (android.os.Bundle, com.google.android.gms.dynamic.a$a) void
    private void method_2701(Bundle var1, class_428.class_1168 var2) {
        if(this.field_1574 != null) {
            var2.method_77(this.field_1574);
        } else {
            if(this.field_1576 == null) {
                this.field_1576 = new LinkedList();
            }

            this.field_1576.add(var2);
            if(var1 != null) {
                if(this.field_1575 == null) {
                    this.field_1575 = (Bundle)var1.clone();
                } else {
                    this.field_1575.putAll(var1);
                }
            }

            this.method_2706(this.field_1577);
        }
    }

    // $FF: renamed from: b (android.widget.FrameLayout) void
    public static void method_2703(FrameLayout var0) {
        final Context var1 = var0.getContext();
        final int var2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var1);
        String var3 = GooglePlayServicesUtil.method_4969(var1, var2);
        String var4 = GooglePlayServicesUtil.method_4970(var1, var2);
        LinearLayout var5 = new LinearLayout(var0.getContext());
        var5.setOrientation(1);
        var5.setLayoutParams(new LayoutParams(-2, -2));
        var0.addView(var5);
        TextView var6 = new TextView(var0.getContext());
        var6.setLayoutParams(new LayoutParams(-2, -2));
        var6.setText(var3);
        var5.addView(var6);
        if(var4 != null) {
            Button var7 = new Button(var1);
            var7.setLayoutParams(new LayoutParams(-2, -2));
            var7.setText(var4);
            var5.addView(var7);
            var7.setOnClickListener(new OnClickListener() {
                public void onClick(View var1x) {
                    var1.startActivity(GooglePlayServicesUtil.method_4967(var1, var2));
                }
            });
        }

    }

    // $FF: renamed from: cv (int) void
    private void method_2704(int var1) {
        while(!this.field_1576.isEmpty() && ((class_428.class_1168)this.field_1576.getLast()).getState() >= var1) {
            this.field_1576.removeLast();
        }

    }

    // $FF: renamed from: a (android.widget.FrameLayout) void
    protected void method_2705(FrameLayout var1) {
        method_2703(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.dynamic.f) void
    protected abstract void method_2706(f<T> var1);

    // $FF: renamed from: it () com.google.android.gms.dynamic.LifecycleDelegate
    public T method_2707() {
        return this.field_1574;
    }

    public void onCreate(final Bundle var1) {
        this.method_2701(var1, new class_428.class_1168() {
            // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
            public void method_77(LifecycleDelegate var1x) {
                class_428.this.field_1574.onCreate(var1);
            }

            public int getState() {
                return 1;
            }
        });
    }

    public View onCreateView(final LayoutInflater var1, final ViewGroup var2, final Bundle var3) {
        final FrameLayout var4 = new FrameLayout(var1.getContext());
        this.method_2701(var3, new class_428.class_1168() {
            // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
            public void method_77(LifecycleDelegate var1x) {
                var4.removeAllViews();
                var4.addView(class_428.this.field_1574.onCreateView(var1, var2, var3));
            }

            public int getState() {
                return 2;
            }
        });
        if(this.field_1574 == null) {
            this.method_2705(var4);
        }

        return var4;
    }

    public void onDestroy() {
        if(this.field_1574 != null) {
            this.field_1574.onDestroy();
        } else {
            this.method_2704(1);
        }
    }

    public void onDestroyView() {
        if(this.field_1574 != null) {
            this.field_1574.onDestroyView();
        } else {
            this.method_2704(2);
        }
    }

    public void onInflate(final Activity var1, final Bundle var2, final Bundle var3) {
        this.method_2701(var3, new class_428.class_1168() {
            // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
            public void method_77(LifecycleDelegate var1x) {
                class_428.this.field_1574.onInflate(var1, var2, var3);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if(this.field_1574 != null) {
            this.field_1574.onLowMemory();
        }

    }

    public void onPause() {
        if(this.field_1574 != null) {
            this.field_1574.onPause();
        } else {
            this.method_2704(5);
        }
    }

    public void onResume() {
        this.method_2701((Bundle)null, new class_428.class_1168() {
            // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
            public void method_77(LifecycleDelegate var1) {
                class_428.this.field_1574.onResume();
            }

            public int getState() {
                return 5;
            }
        });
    }

    public void onSaveInstanceState(Bundle var1) {
        if(this.field_1574 != null) {
            this.field_1574.onSaveInstanceState(var1);
        } else if(this.field_1575 != null) {
            var1.putAll(this.field_1575);
            return;
        }

    }

    public void onStart() {
        this.method_2701((Bundle)null, new class_428.class_1168() {
            // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
            public void method_77(LifecycleDelegate var1) {
                class_428.this.field_1574.onStart();
            }

            public int getState() {
                return 4;
            }
        });
    }

    public void onStop() {
        if(this.field_1574 != null) {
            this.field_1574.onStop();
        } else {
            this.method_2704(4);
        }
    }

    private interface class_1168 {
        // $FF: renamed from: b (com.google.android.gms.dynamic.LifecycleDelegate) void
        void method_77(LifecycleDelegate var1);

        int getState();
    }
}
