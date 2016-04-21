package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.internal.class_268;
import com.google.android.gms.internal.class_340;
import com.google.android.gms.internal.class_342;
import com.google.android.gms.internal.class_348;
import com.google.android.gms.internal.class_350;
import com.google.android.gms.internal.class_351;
import com.google.android.gms.internal.class_354;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.internal.jp
public class class_269 extends class_268 implements SafeParcelable {
    public static final class_351 CREATOR = new class_351();
    // $FF: renamed from: BR int
    private final int field_789;
    // $FF: renamed from: MG com.google.android.gms.internal.jm
    private final class_354 field_790;
    // $FF: renamed from: MN android.os.Parcel
    private final Parcel field_791;
    // $FF: renamed from: MO int
    private final int field_792;
    // $FF: renamed from: MP int
    private int field_793;
    // $FF: renamed from: MQ int
    private int field_794;
    private final String mClassName;

    class_269(int var1, Parcel var2, class_354 var3) {
        this.field_789 = var1;
        this.field_791 = (Parcel)class_1090.method_5685(var2);
        this.field_792 = 2;
        this.field_790 = var3;
        if(this.field_790 == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.field_790.method_2363();
        }

        this.field_793 = 2;
    }

    private class_269(SafeParcelable var1, class_354 var2, String var3) {
        this.field_789 = 1;
        this.field_791 = Parcel.obtain();
        var1.writeToParcel(this.field_791, 0);
        this.field_792 = 1;
        this.field_790 = (class_354)class_1090.method_5685(var2);
        this.mClassName = (String)class_1090.method_5685(var3);
        this.field_793 = 2;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ji) com.google.android.gms.internal.jp
    public static <T extends ji & SafeParcelable> jp method_1700(T var0) {
        String var1 = var0.getClass().getCanonicalName();
        class_354 var2 = method_1706(var0);
        return new class_269((SafeParcelable)var0, var2, var1);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.jm, com.google.android.gms.internal.ji) void
    private static void method_1701(class_354 var0, class_268 var1) {
        Class var2 = var1.getClass();
        if(!var0.method_2358(var2)) {
            HashMap var3 = var1.method_1697();
            var0.method_2357(var2, var1.method_1697());
            Iterator var4 = var3.keySet().iterator();

            while(var4.hasNext()) {
                class_268.class_1299 var5 = (class_268.class_1299)var3.get((String)var4.next());
                Class var6 = var5.method_3883();
                if(var6 != null) {
                    try {
                        method_1701(var0, (class_268)var6.newInstance());
                    } catch (InstantiationException var9) {
                        throw new IllegalStateException("Could not instantiate an object of type " + var5.method_3883().getCanonicalName(), var9);
                    } catch (IllegalAccessException var10) {
                        throw new IllegalStateException("Could not access object of type " + var5.method_3883().getCanonicalName(), var10);
                    }
                }
            }
        }

    }

    // $FF: renamed from: a (java.lang.StringBuilder, int, java.lang.Object) void
    private void method_1702(StringBuilder var1, int var2, Object var3) {
        switch(var2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                var1.append(var3);
                return;
            case 7:
                var1.append("\"").append(class_342.method_2316(var3.toString())).append("\"");
                return;
            case 8:
                var1.append("\"").append(class_350.method_2344((byte[])((byte[])var3))).append("\"");
                return;
            case 9:
                var1.append("\"").append(class_350.method_2345((byte[])((byte[])var3)));
                var1.append("\"");
                return;
            case 10:
                class_340.method_2314(var1, (HashMap)var3);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + var2);
        }
    }

    // $FF: renamed from: a (java.lang.StringBuilder, com.google.android.gms.internal.ji$a, android.os.Parcel, int) void
    private void method_1703(StringBuilder var1, class_268.class_1299<?, ?> var2, Parcel var3, int var4) {
        switch(var2.method_3877()) {
            case 0:
                this.method_1709(var1, var2, this.a(var2, Integer.valueOf(class_824.method_4348(var3, var4))));
                return;
            case 1:
                this.method_1709(var1, var2, this.a(var2, class_824.method_4352(var3, var4)));
                return;
            case 2:
                this.method_1709(var1, var2, this.a(var2, Long.valueOf(class_824.method_4350(var3, var4))));
                return;
            case 3:
                this.method_1709(var1, var2, this.a(var2, Float.valueOf(class_824.method_4353(var3, var4))));
                return;
            case 4:
                this.method_1709(var1, var2, this.a(var2, Double.valueOf(class_824.method_4354(var3, var4))));
                return;
            case 5:
                this.method_1709(var1, var2, this.a(var2, class_824.method_4355(var3, var4)));
                return;
            case 6:
                this.method_1709(var1, var2, this.a(var2, Boolean.valueOf(class_824.method_4344(var3, var4))));
                return;
            case 7:
                this.method_1709(var1, var2, this.a(var2, class_824.method_4356(var3, var4)));
                return;
            case 8:
            case 9:
                this.method_1709(var1, var2, this.a(var2, class_824.method_4359(var3, var4)));
                return;
            case 10:
                this.method_1709(var1, var2, this.a(var2, method_1711(class_824.method_4358(var3, var4))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + var2.method_3877());
        }
    }

    // $FF: renamed from: a (java.lang.StringBuilder, java.lang.String, com.google.android.gms.internal.ji$a, android.os.Parcel, int) void
    private void method_1704(StringBuilder var1, String var2, class_268.class_1299<?, ?> var3, Parcel var4, int var5) {
        var1.append("\"").append(var2).append("\":");
        if(var3.method_3885()) {
            this.method_1703(var1, var3, var4, var5);
        } else {
            this.method_1708(var1, var3, var4, var5);
        }
    }

    // $FF: renamed from: a (java.lang.StringBuilder, java.util.HashMap, android.os.Parcel) void
    private void method_1705(StringBuilder var1, HashMap<String, class_268.class_1299<?, ?>> var2, Parcel var3) {
        HashMap var4 = method_1707(var2);
        var1.append('{');
        int var6 = class_824.method_4331(var3);
        boolean var7 = false;

        while(var3.dataPosition() < var6) {
            int var9 = class_824.method_4329(var3);
            Entry var10 = (Entry)var4.get(Integer.valueOf(class_824.method_4340(var9)));
            if(var10 != null) {
                if(var7) {
                    var1.append(",");
                }

                this.method_1704(var1, (String)var10.getKey(), (class_268.class_1299)var10.getValue(), var3, var9);
                var7 = true;
            }
        }

        if(var3.dataPosition() != var6) {
            throw new class_824.class_1307("Overread allowed size end=" + var6, var3);
        } else {
            var1.append('}');
        }
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ji) com.google.android.gms.internal.jm
    private static class_354 method_1706(class_268 var0) {
        class_354 var1 = new class_354(var0.getClass());
        method_1701(var1, var0);
        var1.method_2361();
        var1.method_2360();
        return var1;
    }

    // $FF: renamed from: b (java.util.HashMap) java.util.HashMap
    private static HashMap<Integer, Entry<String, class_268.class_1299<?, ?>>> method_1707(HashMap<String, class_268.class_1299<?, ?>> var0) {
        HashMap var1 = new HashMap();
        Iterator var2 = var0.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.put(Integer.valueOf(((class_268.class_1299)var3.getValue()).method_3882()), var3);
        }

        return var1;
    }

    // $FF: renamed from: b (java.lang.StringBuilder, com.google.android.gms.internal.ji$a, android.os.Parcel, int) void
    private void method_1708(StringBuilder var1, class_268.class_1299<?, ?> var2, Parcel var3, int var4) {
        if(!var2.method_3880()) {
            switch(var2.method_3877()) {
                case 0:
                    var1.append(class_824.method_4348(var3, var4));
                    return;
                case 1:
                    var1.append(class_824.method_4352(var3, var4));
                    return;
                case 2:
                    var1.append(class_824.method_4350(var3, var4));
                    return;
                case 3:
                    var1.append(class_824.method_4353(var3, var4));
                    return;
                case 4:
                    var1.append(class_824.method_4354(var3, var4));
                    return;
                case 5:
                    var1.append(class_824.method_4355(var3, var4));
                    return;
                case 6:
                    var1.append(class_824.method_4344(var3, var4));
                    return;
                case 7:
                    String var23 = class_824.method_4356(var3, var4);
                    var1.append("\"").append(class_342.method_2316(var23)).append("\"");
                    return;
                case 8:
                    byte[] var21 = class_824.method_4359(var3, var4);
                    var1.append("\"").append(class_350.method_2344(var21)).append("\"");
                    return;
                case 9:
                    byte[] var18 = class_824.method_4359(var3, var4);
                    var1.append("\"").append(class_350.method_2345(var18));
                    var1.append("\"");
                    return;
                case 10:
                    Bundle var6 = class_824.method_4358(var3, var4);
                    Set var7 = var6.keySet();
                    var7.size();
                    var1.append("{");
                    Iterator var10 = var7.iterator();

                    for(boolean var11 = true; var10.hasNext(); var11 = false) {
                        String var13 = (String)var10.next();
                        if(!var11) {
                            var1.append(",");
                        }

                        var1.append("\"").append(var13).append("\"");
                        var1.append(":");
                        var1.append("\"").append(class_342.method_2316(var6.getString(var13))).append("\"");
                    }

                    var1.append("}");
                    return;
                case 11:
                    Parcel var5 = class_824.method_4333(var3, var4);
                    var5.setDataPosition(0);
                    this.method_1705(var1, var2.method_3887(), var5);
                    return;
                default:
                    throw new IllegalStateException("Unknown field type out");
            }
        } else {
            var1.append("[");
            label56:
            switch(var2.method_3877()) {
                case 0:
                    class_348.method_2335(var1, class_824.method_4362(var3, var4));
                    break;
                case 1:
                    class_348.method_2337(var1, class_824.method_4364(var3, var4));
                    break;
                case 2:
                    class_348.method_2336(var1, class_824.method_4363(var3, var4));
                    break;
                case 3:
                    class_348.method_2334(var1, class_824.method_4365(var3, var4));
                    break;
                case 4:
                    class_348.method_2333(var1, class_824.method_4366(var3, var4));
                    break;
                case 5:
                    class_348.method_2337(var1, class_824.method_4367(var3, var4));
                    break;
                case 6:
                    class_348.method_2339(var1, class_824.method_4361(var3, var4));
                    break;
                case 7:
                    class_348.method_2338(var1, class_824.method_4328(var3, var4));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] var33 = class_824.method_4334(var3, var4);
                    int var34 = var33.length;
                    int var35 = 0;

                    while(true) {
                        if(var35 >= var34) {
                            break label56;
                        }

                        if(var35 > 0) {
                            var1.append(",");
                        }

                        var33[var35].setDataPosition(0);
                        this.method_1705(var1, var2.method_3887(), var33[var35]);
                        ++var35;
                    }
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }

            var1.append("]");
        }
    }

    // $FF: renamed from: b (java.lang.StringBuilder, com.google.android.gms.internal.ji$a, java.lang.Object) void
    private void method_1709(StringBuilder var1, class_268.class_1299<?, ?> var2, Object var3) {
        if(var2.method_3879()) {
            this.method_1710(var1, var2, (ArrayList)var3);
        } else {
            this.method_1702(var1, var2.method_3876(), var3);
        }
    }

    // $FF: renamed from: b (java.lang.StringBuilder, com.google.android.gms.internal.ji$a, java.util.ArrayList) void
    private void method_1710(StringBuilder var1, class_268.class_1299<?, ?> var2, ArrayList<?> var3) {
        var1.append("[");
        int var5 = var3.size();

        for(int var6 = 0; var6 < var5; ++var6) {
            if(var6 != 0) {
                var1.append(",");
            }

            this.method_1702(var1, var2.method_3876(), var3.get(var6));
        }

        var1.append("]");
    }

    // $FF: renamed from: e (android.os.Bundle) java.util.HashMap
    public static HashMap<String, String> method_1711(Bundle var0) {
        HashMap var1 = new HashMap();
        Iterator var2 = var0.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.put(var3, var0.getString(var3));
        }

        return var1;
    }

    // $FF: renamed from: ba (java.lang.String) java.lang.Object
    protected Object method_1693(String var1) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    // $FF: renamed from: bb (java.lang.String) boolean
    protected boolean method_1694(String var1) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        class_351 var10000 = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.field_789;
    }

    // $FF: renamed from: hf () java.util.HashMap
    public HashMap<String, class_268.class_1299<?, ?>> method_1697() {
        return this.field_790 == null?null:this.field_790.method_2359(this.mClassName);
    }

    // $FF: renamed from: hx () android.os.Parcel
    public Parcel method_1712() {
        switch(this.field_793) {
            case 0:
                this.field_794 = class_823.method_4298(this.field_791);
                class_823.method_4301(this.field_791, this.field_794);
                this.field_793 = 2;
                break;
            case 1:
                class_823.method_4301(this.field_791, this.field_794);
                this.field_793 = 2;
        }

        return this.field_791;
    }

    // $FF: renamed from: hy () com.google.android.gms.internal.jm
    class_354 method_1713() {
        switch(this.field_792) {
            case 0:
                return null;
            case 1:
                return this.field_790;
            case 2:
                return this.field_790;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.field_792);
        }
    }

    public String toString() {
        class_1090.method_5681(this.field_790, "Cannot convert to JSON on client side.");
        Parcel var2 = this.method_1712();
        var2.setDataPosition(0);
        StringBuilder var3 = new StringBuilder(100);
        this.method_1705(var3, this.field_790.method_2359(this.mClassName), var2);
        return var3.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_351 var10000 = CREATOR;
        class_351.method_2346(this, var1, var2);
    }
}
