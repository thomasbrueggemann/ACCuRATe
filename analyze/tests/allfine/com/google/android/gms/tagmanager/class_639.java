package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.bk;
import com.google.android.gms.tagmanager.bz;
import com.google.android.gms.tagmanager.ck;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_562;
import com.google.android.gms.tagmanager.class_563;
import com.google.android.gms.tagmanager.class_564;
import com.google.android.gms.tagmanager.class_565;
import com.google.android.gms.tagmanager.class_566;
import com.google.android.gms.tagmanager.class_567;
import com.google.android.gms.tagmanager.class_568;
import com.google.android.gms.tagmanager.class_569;
import com.google.android.gms.tagmanager.class_570;
import com.google.android.gms.tagmanager.class_571;
import com.google.android.gms.tagmanager.class_572;
import com.google.android.gms.tagmanager.class_573;
import com.google.android.gms.tagmanager.class_574;
import com.google.android.gms.tagmanager.class_575;
import com.google.android.gms.tagmanager.class_576;
import com.google.android.gms.tagmanager.class_577;
import com.google.android.gms.tagmanager.class_578;
import com.google.android.gms.tagmanager.class_580;
import com.google.android.gms.tagmanager.class_581;
import com.google.android.gms.tagmanager.class_582;
import com.google.android.gms.tagmanager.class_583;
import com.google.android.gms.tagmanager.class_584;
import com.google.android.gms.tagmanager.class_585;
import com.google.android.gms.tagmanager.class_586;
import com.google.android.gms.tagmanager.class_587;
import com.google.android.gms.tagmanager.class_588;
import com.google.android.gms.tagmanager.class_589;
import com.google.android.gms.tagmanager.class_590;
import com.google.android.gms.tagmanager.class_591;
import com.google.android.gms.tagmanager.class_592;
import com.google.android.gms.tagmanager.class_593;
import com.google.android.gms.tagmanager.class_594;
import com.google.android.gms.tagmanager.class_597;
import com.google.android.gms.tagmanager.class_598;
import com.google.android.gms.tagmanager.class_599;
import com.google.android.gms.tagmanager.class_600;
import com.google.android.gms.tagmanager.class_601;
import com.google.android.gms.tagmanager.class_603;
import com.google.android.gms.tagmanager.class_604;
import com.google.android.gms.tagmanager.class_605;
import com.google.android.gms.tagmanager.class_606;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_630;
import com.google.android.gms.tagmanager.class_631;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_636;
import com.google.android.gms.tagmanager.class_638;
import com.google.android.gms.tagmanager.class_716;
import com.google.android.gms.tagmanager.class_77;
import com.google.android.gms.tagmanager.class_78;
import com.google.android.gms.tagmanager.class_83;
import com.google.android.gms.tagmanager.class_85;
import com.google.android.gms.tagmanager.cn;
import com.google.android.gms.tagmanager.cs;
import com.google.android.gms.tagmanager.dl;
import com.google.android.gms.tagmanager.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.ct
class class_639 {
    private static final bz<class_53.class_1172> aqS = new class_630(class_634.method_3556(), true);
    private final DataLayer aod;
    private final class_638.class_1807 aqT;
    private final class_83 aqU;
    private final Map<String, aj> aqV;
    private final Map<String, aj> aqW;
    private final Map<String, aj> aqX;
    private final k<class_638.class_1805, bz<class_53.class_1172>> aqY;
    private final k<String, class_639.class_1205> aqZ;
    private final Set<class_638.class_1809> ara;
    private final Map<String, class_639.class_1207> arb;
    private volatile String arc;
    private int ard;

    public class_639(Context var1, class_638.class_1807 var2, DataLayer var3, class_563.class_1783 var4, class_563.class_1783 var5, class_83 var6) {
        if(var2 == null) {
            throw new NullPointerException("resource cannot be null");
        } else {
            this.aqT = var2;
            this.ara = new HashSet(var2.method_5665());
            this.aod = var3;
            this.aqU = var6;
            class_716.class_1821 var7 = new class_716.class_1821() {
                // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$a, com.google.android.gms.tagmanager.bz) int
                public int method_2331(class_638.class_1805 var1, bz<class_53.class_1172> var2) {
                    return ((class_53.class_1172)var2.getObject()).qH();
                }

                // $FF: synthetic method
                public int sizeOf(Object var1, Object var2) {
                    return this.method_2331((class_638.class_1805)var1, (class_630)var2);
                }
            };
            this.aqY = (new class_716()).method_3917(1048576, var7);
            class_716.class_1821 var8 = new class_716.class_1821() {
                // $FF: renamed from: a (java.lang.String, com.google.android.gms.tagmanager.ct$b) int
                public int method_2332(String var1, class_639.class_1205 var2) {
                    return var1.length() + var2.getSize();
                }

                // $FF: synthetic method
                public int sizeOf(Object var1, Object var2) {
                    return this.method_2332((String)var1, (class_639.class_1205)var2);
                }
            };
            this.aqZ = (new class_716()).method_3917(1048576, var8);
            this.aqV = new HashMap();
            this.method_3612(new class_581(var1));
            this.method_3612(new class_563(var5));
            this.method_3612(new class_580(var3));
            this.method_3612(new class_582(var1, var3));
            this.aqW = new HashMap();
            this.method_3613(new class_597());
            this.method_3613(new class_598());
            this.method_3613(new class_599());
            this.method_3613(new class_603());
            this.method_3613(new class_604());
            this.method_3613(new class_605());
            this.method_3613(new class_606());
            this.method_3613(new class_601());
            this.method_3613(new class_600());
            this.aqX = new HashMap();
            this.method_3611(new class_567(var1));
            this.method_3611(new class_566(var1));
            this.method_3611(new class_568(var1));
            this.method_3611(new class_570(var1));
            this.method_3611(new class_569(var1));
            this.method_3611(new class_571(var1));
            this.method_3611(new class_564());
            this.method_3611(new class_565(this.aqT.getVersion()));
            this.method_3611(new class_563(var4));
            this.method_3611(new class_562(var3));
            this.method_3611(new class_561(var1));
            this.method_3611(new class_573());
            this.method_3611(new class_572());
            this.method_3611(new class_575(this));
            this.method_3611(new class_574());
            this.method_3611(new class_591());
            this.method_3611(new class_590(var1));
            this.method_3611(new class_589());
            this.method_3611(new class_594());
            this.method_3611(new class_592());
            this.method_3611(new class_593(var1));
            this.method_3611(new class_585());
            this.method_3611(new class_586());
            this.method_3611(new class_587());
            this.method_3611(new class_588());
            this.method_3611(new class_584(var1));
            this.method_3611(new class_577());
            this.method_3611(new class_576());
            this.method_3611(new class_583());
            this.method_3611(new class_578());
            this.arb = new HashMap();
            Iterator var9 = this.ara.iterator();

            while(var9.hasNext()) {
                class_638.class_1809 var14 = (class_638.class_1809)var9.next();
                if(var6.method_366()) {
                    method_3602(var14.method_5653(), var14.method_5654(), "add macro");
                    method_3602(var14.method_5658(), var14.method_5655(), "remove macro");
                    method_3602(var14.method_5651(), var14.method_5656(), "add tag");
                    method_3602(var14.method_5652(), var14.method_5657(), "remove tag");
                }

                for(int var15 = 0; var15 < var14.method_5653().size(); ++var15) {
                    class_638.class_1805 var20 = (class_638.class_1805)var14.method_5653().get(var15);
                    String var21 = "Unknown";
                    if(var6.method_366() && var15 < var14.method_5654().size()) {
                        var21 = (String)var14.method_5654().get(var15);
                    }

                    class_639.class_1207 var22 = method_3604(this.arb, method_3605(var20));
                    var22.method_2654(var14);
                    var22.method_2652(var14, var20);
                    var22.method_2653(var14, var21);
                }

                for(int var16 = 0; var16 < var14.method_5658().size(); ++var16) {
                    class_638.class_1805 var17 = (class_638.class_1805)var14.method_5658().get(var16);
                    String var18 = "Unknown";
                    if(var6.method_366() && var16 < var14.method_5655().size()) {
                        var18 = (String)var14.method_5655().get(var16);
                    }

                    class_639.class_1207 var19 = method_3604(this.arb, method_3605(var17));
                    var19.method_2654(var14);
                    var19.method_2655(var14, var17);
                    var19.method_2656(var14, var18);
                }
            }

            Iterator var10 = this.aqT.method_5666().entrySet().iterator();

            while(var10.hasNext()) {
                Entry var11 = (Entry)var10.next();
                Iterator var12 = ((List)var11.getValue()).iterator();

                while(var12.hasNext()) {
                    class_638.class_1805 var13 = (class_638.class_1805)var12.next();
                    if(!class_634.method_3547((class_53.class_1172)var13.method_5620().get(class_529.field_2370.toString())).booleanValue()) {
                        method_3604(this.arb, (String)var11.getKey()).method_2657(var13);
                    }
                }
            }

        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.d$a, java.util.Set, com.google.android.gms.tagmanager.dl) com.google.android.gms.tagmanager.bz
    private bz<class_53.class_1172> method_3597(class_53.class_1172 var1, Set<String> var2, dl var3) {
        if(!var1.field_1019) {
            return new class_630(var1, true);
        } else {
            switch(var1.type) {
                case 2:
                    class_53.class_1172 var14 = class_638.method_3595(var1);
                    var14.field_1021 = new class_53.class_1172[var1.field_1021.length];

                    for(int var15 = 0; var15 < var1.field_1021.length; ++var15) {
                        class_630 var16 = this.method_3597(var1.field_1021[var15], var2, var3.method_357(var15));
                        if(var16 == aqS) {
                            return aqS;
                        }

                        var14.field_1021[var15] = (class_53.class_1172)var16.getObject();
                    }

                    return new class_630(var14, false);
                case 3:
                    class_53.class_1172 var10 = class_638.method_3595(var1);
                    if(var1.field_1022.length != var1.field_1023.length) {
                        class_612.method_3456("Invalid serving value: " + var1.toString());
                        return aqS;
                    } else {
                        var10.field_1022 = new class_53.class_1172[var1.field_1022.length];
                        var10.field_1023 = new class_53.class_1172[var1.field_1022.length];

                        for(int var11 = 0; var11 < var1.field_1022.length; ++var11) {
                            class_630 var12 = this.method_3597(var1.field_1022[var11], var2, var3.method_358(var11));
                            class_630 var13 = this.method_3597(var1.field_1023[var11], var2, var3.method_359(var11));
                            if(var12 == aqS || var13 == aqS) {
                                return aqS;
                            }

                            var10.field_1022[var11] = (class_53.class_1172)var12.getObject();
                            var10.field_1023[var11] = (class_53.class_1172)var13.getObject();
                        }

                        return new class_630(var10, false);
                    }
                case 4:
                    if(var2.contains(var1.field_1024)) {
                        class_612.method_3456("Macro cycle detected.  Current macro reference: " + var1.field_1024 + "." + "  Previous macro references: " + var2.toString() + ".");
                        return aqS;
                    }

                    var2.add(var1.field_1024);
                    class_630 var8 = class_636.method_3578(this.method_3598(var1.field_1024, var2, var3.method_361()), var1.field_1018);
                    var2.remove(var1.field_1024);
                    return var8;
                case 5:
                case 6:
                default:
                    class_612.method_3456("Unknown type: " + var1.type);
                    return aqS;
                case 7:
                    class_53.class_1172 var4 = class_638.method_3595(var1);
                    var4.field_1017 = new class_53.class_1172[var1.field_1017.length];

                    for(int var5 = 0; var5 < var1.field_1017.length; ++var5) {
                        class_630 var6 = this.method_3597(var1.field_1017[var5], var2, var3.method_360(var5));
                        if(var6 == aqS) {
                            return aqS;
                        }

                        var4.field_1017[var5] = (class_53.class_1172)var6.getObject();
                    }

                    return new class_630(var4, false);
            }
        }
    }

    // $FF: renamed from: a (java.lang.String, java.util.Set, com.google.android.gms.tagmanager.bk) com.google.android.gms.tagmanager.bz
    private bz<class_53.class_1172> method_3598(String var1, Set<String> var2, bk var3) {
        ++this.ard;
        class_639.class_1205 var4 = (class_639.class_1205)this.aqZ.get(var1);
        if(var4 != null && !this.aqU.method_366()) {
            this.method_3601(var4.method_2648(), var2);
            this.ard += -1;
            return var4.method_2649();
        } else {
            class_639.class_1207 var5 = (class_639.class_1207)this.arb.get(var1);
            if(var5 == null) {
                class_612.method_3456(this.method_3606() + "Invalid macro: " + var1);
                this.ard += -1;
                return aqS;
            } else {
                class_630 var6 = this.method_3609(var1, var5.method_2658(), var5.method_2659(), var5.method_2660(), var5.method_2662(), var5.method_2661(), var2, var3.method_337());
                class_638.class_1805 var7;
                if(((Set)var6.getObject()).isEmpty()) {
                    var7 = var5.method_2663();
                } else {
                    if(((Set)var6.getObject()).size() > 1) {
                        class_612.method_3459(this.method_3606() + "Multiple macros active for macroName " + var1);
                    }

                    var7 = (class_638.class_1805)((Set)var6.getObject()).iterator().next();
                }

                if(var7 == null) {
                    this.ard += -1;
                    return aqS;
                } else {
                    class_630 var8 = this.method_3599(this.aqX, var7, var2, var3.method_338());
                    boolean var9;
                    if(var6.method_3528() && var8.method_3528()) {
                        var9 = true;
                    } else {
                        var9 = false;
                    }

                    class_630 var10;
                    if(var8 == aqS) {
                        var10 = aqS;
                    } else {
                        var10 = new class_630(var8.getObject(), var9);
                    }

                    class_53.class_1172 var11 = var7.method_5621();
                    if(var10.method_3528()) {
                        this.aqZ.method_386(var1, new class_639.class_1205(var10, var11));
                    }

                    this.method_3601(var11, var2);
                    this.ard += -1;
                    return var10;
                }
            }
        }
    }

    // $FF: renamed from: a (java.util.Map, com.google.android.gms.tagmanager.cr$a, java.util.Set, com.google.android.gms.tagmanager.ck) com.google.android.gms.tagmanager.bz
    private bz<class_53.class_1172> method_3599(Map<String, aj> var1, class_638.class_1805 var2, Set<String> var3, ck var4) {
        boolean var5 = true;
        class_53.class_1172 var6 = (class_53.class_1172)var2.method_5620().get(class_529.field_2332.toString());
        class_630 var9;
        if(var6 == null) {
            class_612.method_3456("No function id in properties");
            var9 = aqS;
        } else {
            String var7 = var6.field_1014;
            class_560 var8 = (class_560)var1.get(var7);
            if(var8 == null) {
                class_612.method_3456(var7 + " has no backing implementation.");
                return aqS;
            }

            var9 = (class_630)this.aqY.get(var2);
            if(var9 == null || this.aqU.method_366()) {
                HashMap var10 = new HashMap();
                Iterator var11 = var2.method_5620().entrySet().iterator();

                boolean var12;
                boolean var17;
                for(var12 = var5; var11.hasNext(); var12 = var17) {
                    Entry var14 = (Entry)var11.next();
                    class_78 var15 = var4.method_355((String)var14.getKey());
                    class_630 var16 = this.method_3597((class_53.class_1172)var14.getValue(), var3, var15.method_353((class_53.class_1172)var14.getValue()));
                    if(var16 == aqS) {
                        return aqS;
                    }

                    if(var16.method_3528()) {
                        var2.method_5619((String)var14.getKey(), (class_53.class_1172)var16.getObject());
                        var17 = var12;
                    } else {
                        var17 = false;
                    }

                    var10.put(var14.getKey(), var16.getObject());
                }

                if(!var8.method_3412(var10.keySet())) {
                    class_612.method_3456("Incorrect keys for function " + var7 + " required " + var8.method_3415() + " had " + var10.keySet());
                    return aqS;
                }

                if(!var12 || !var8.method_3413()) {
                    var5 = false;
                }

                class_630 var13 = new class_630(var8.method_3411(var10), var5);
                if(var5) {
                    this.aqY.method_386(var2, var13);
                }

                var4.method_356((class_53.class_1172)var13.getObject());
                return var13;
            }
        }

        return var9;
    }

    // $FF: renamed from: a (java.util.Set, java.util.Set, com.google.android.gms.tagmanager.ct$a, com.google.android.gms.tagmanager.cs) com.google.android.gms.tagmanager.bz
    private bz<Set<class_638.class_1805>> method_3600(Set<class_638.class_1809> var1, Set<String> var2, class_639.class_1206 var3, cs var4) {
        HashSet var5 = new HashSet();
        HashSet var6 = new HashSet();
        Iterator var7 = var1.iterator();

        boolean var8;
        boolean var13;
        for(var8 = true; var7.hasNext(); var8 = var13) {
            class_638.class_1809 var10 = (class_638.class_1809)var7.next();
            class_77 var11 = var4.method_363();
            class_630 var12 = this.method_3608(var10, var2, var11);
            if(((Boolean)var12.getObject()).booleanValue()) {
                var3.method_150(var10, var5, var6, var11);
            }

            if(var8 && var12.method_3528()) {
                var13 = true;
            } else {
                var13 = false;
            }
        }

        var5.removeAll(var6);
        var4.method_362(var5);
        return new class_630(var5, var8);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.d$a, java.util.Set) void
    private void method_3601(class_53.class_1172 var1, Set<String> var2) {
        if(var1 != null) {
            class_630 var3 = this.method_3597(var1, var2, new class_631());
            if(var3 != aqS) {
                Object var4 = class_634.method_3548((class_53.class_1172)var3.getObject());
                if(var4 instanceof Map) {
                    Map var8 = (Map)var4;
                    this.aod.push(var8);
                    return;
                }

                if(!(var4 instanceof List)) {
                    class_612.method_3459("pushAfterEvaluate: value not a Map or List");
                    return;
                }

                Iterator var5 = ((List)var4).iterator();

                while(var5.hasNext()) {
                    Object var6 = var5.next();
                    if(var6 instanceof Map) {
                        Map var7 = (Map)var6;
                        this.aod.push(var7);
                    } else {
                        class_612.method_3459("pushAfterEvaluate: value not a Map");
                    }
                }
            }
        }

    }

    // $FF: renamed from: a (java.util.List, java.util.List, java.lang.String) void
    private static void method_3602(List<class_638.class_1805> var0, List<String> var1, String var2) {
        if(var0.size() != var1.size()) {
            class_612.method_3457("Invalid resource: imbalance of rule names of functions for " + var2 + " operation. Using default rule name instead");
        }

    }

    // $FF: renamed from: a (java.util.Map, com.google.android.gms.tagmanager.aj) void
    private static void method_3603(Map<String, aj> var0, aj var1) {
        if(var0.containsKey(var1.method_3414())) {
            throw new IllegalArgumentException("Duplicate function type name: " + var1.method_3414());
        } else {
            var0.put(var1.method_3414(), var1);
        }
    }

    // $FF: renamed from: e (java.util.Map, java.lang.String) com.google.android.gms.tagmanager.ct$c
    private static class_639.class_1207 method_3604(Map<String, class_639.class_1207> var0, String var1) {
        class_639.class_1207 var2 = (class_639.class_1207)var0.get(var1);
        if(var2 == null) {
            var2 = new class_639.class_1207();
            var0.put(var1, var2);
        }

        return var2;
    }

    // $FF: renamed from: h (com.google.android.gms.tagmanager.cr$a) java.lang.String
    private static String method_3605(class_638.class_1805 var0) {
        return class_634.method_3543((class_53.class_1172)var0.method_5620().get(class_529.field_2395.toString()));
    }

    // $FF: renamed from: po () java.lang.String
    private String method_3606() {
        if(this.ard <= 1) {
            return "";
        } else {
            StringBuilder var1 = new StringBuilder();
            var1.append(Integer.toString(this.ard));

            for(int var3 = 2; var3 < this.ard; ++var3) {
                var1.append(' ');
            }

            var1.append(": ");
            return var1.toString();
        }
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$a, java.util.Set, com.google.android.gms.tagmanager.ck) com.google.android.gms.tagmanager.bz
    bz<Boolean> method_3607(class_638.class_1805 var1, Set<String> var2, ck var3) {
        class_630 var4 = this.method_3599(this.aqW, var1, var2, var3);
        Boolean var5 = class_634.method_3547((class_53.class_1172)var4.getObject());
        var3.method_356(class_634.method_3561(var5));
        return new class_630(var5, var4.method_3528());
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.util.Set, com.google.android.gms.tagmanager.cn) com.google.android.gms.tagmanager.bz
    bz<Boolean> method_3608(class_638.class_1809 var1, Set<String> var2, cn var3) {
        Iterator var4 = var1.method_5650().iterator();

        boolean var5;
        boolean var9;
        for(var5 = true; var4.hasNext(); var5 = var9) {
            class_630 var8 = this.method_3607((class_638.class_1805)var4.next(), var2, var3.method_351());
            if(((Boolean)var8.getObject()).booleanValue()) {
                var3.method_346(class_634.method_3561(Boolean.valueOf(false)));
                return new class_630(Boolean.valueOf(false), var8.method_3528());
            }

            if(var5 && var8.method_3528()) {
                var9 = true;
            } else {
                var9 = false;
            }
        }

        Iterator var6 = var1.method_5649().iterator();

        while(true) {
            while(var6.hasNext()) {
                class_630 var7 = this.method_3607((class_638.class_1805)var6.next(), var2, var3.method_352());
                if(!((Boolean)var7.getObject()).booleanValue()) {
                    var3.method_346(class_634.method_3561(Boolean.valueOf(false)));
                    return new class_630(Boolean.valueOf(false), var7.method_3528());
                }

                if(var5 && var7.method_3528()) {
                    var5 = true;
                } else {
                    var5 = false;
                }
            }

            var3.method_346(class_634.method_3561(Boolean.valueOf(true)));
            return new class_630(Boolean.valueOf(true), var5);
        }
    }

    // $FF: renamed from: a (java.lang.String, java.util.Set, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Set, com.google.android.gms.tagmanager.cs) com.google.android.gms.tagmanager.bz
    bz<Set<class_638.class_1805>> method_3609(String var1, Set<class_638.class_1809> var2, final Map<class_638.class_1809, List<class_638.class_1805>> var3, final Map<class_638.class_1809, List<String>> var4, final Map<class_638.class_1809, List<class_638.class_1805>> var5, final Map<class_638.class_1809, List<String>> var6, Set<String> var7, cs var8) {
        return this.method_3600(var2, var7, new class_639.class_1206() {
            // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cn) void
            public void method_150(class_638.class_1809 var1, Set<class_638.class_1805> var2, Set<class_638.class_1805> var3x, cn var4x) {
                List var5x = (List)var3.get(var1);
                List var6x = (List)var4.get(var1);
                if(var5x != null) {
                    var2.addAll(var5x);
                    var4x.method_347().method_354(var5x, var6x);
                }

                List var7 = (List)var5.get(var1);
                List var8 = (List)var6.get(var1);
                if(var7 != null) {
                    var3x.addAll(var7);
                    var4x.method_348().method_354(var7, var8);
                }

            }
        }, var8);
    }

    // $FF: renamed from: a (java.util.Set, com.google.android.gms.tagmanager.cs) com.google.android.gms.tagmanager.bz
    bz<Set<class_638.class_1805>> method_3610(Set<class_638.class_1809> var1, cs var2) {
        return this.method_3600(var1, new HashSet(), new class_639.class_1206() {
            // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cn) void
            public void method_150(class_638.class_1809 var1, Set<class_638.class_1805> var2, Set<class_638.class_1805> var3, cn var4) {
                var2.addAll(var1.method_5651());
                var3.addAll(var1.method_5652());
                var4.method_349().method_354(var1.method_5651(), var1.method_5656());
                var4.method_350().method_354(var1.method_5652(), var1.method_5657());
            }
        }, var2);
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.aj) void
    void method_3611(class_560 var1) {
        method_3603(this.aqX, var1);
    }

    // $FF: renamed from: b (com.google.android.gms.tagmanager.aj) void
    void method_3612(class_560 var1) {
        method_3603(this.aqV, var1);
    }

    // $FF: renamed from: c (com.google.android.gms.tagmanager.aj) void
    void method_3613(class_560 var1) {
        method_3603(this.aqW, var1);
    }

    // $FF: renamed from: cR (java.lang.String) com.google.android.gms.tagmanager.bz
    public bz<class_53.class_1172> method_3614(String var1) {
        this.ard = 0;
        class_85 var2 = this.aqU.method_364(var1);
        class_630 var3 = this.method_3598(var1, new HashSet(), var2.method_369());
        var2.method_371();
        return var3;
    }

    // $FF: renamed from: cS (java.lang.String) void
    void method_3615(String var1) {
        synchronized(this) {}

        try {
            this.arc = var1;
        } finally {
            ;
        }

    }

    // $FF: renamed from: cp (java.lang.String) void
    public void method_3616(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: k (java.util.List) void
    public void method_3617(List<class_51.class_1319> param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: pn () java.lang.String
    String method_3618() {
        synchronized(this) {}

        String var2;
        try {
            var2 = this.arc;
        } finally {
            ;
        }

        return var2;
    }

    interface class_1206 {
        // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.util.Set, java.util.Set, com.google.android.gms.tagmanager.cn) void
        void method_150(class_638.class_1809 var1, Set<class_638.class_1805> var2, Set<class_638.class_1805> var3, cn var4);
    }

    private static class class_1205 {
        private class_53.class_1172 aqE;
        private bz<class_53.class_1172> arj;

        public class_1205(bz<class_53.class_1172> var1, class_53.class_1172 var2) {
            this.arj = var1;
            this.aqE = var2;
        }

        public int getSize() {
            int var1 = ((class_53.class_1172)this.arj.getObject()).qH();
            int var2;
            if(this.aqE == null) {
                var2 = 0;
            } else {
                var2 = this.aqE.qH();
            }

            return var2 + var1;
        }

        // $FF: renamed from: oV () com.google.android.gms.internal.d$a
        public class_53.class_1172 method_2648() {
            return this.aqE;
        }

        // $FF: renamed from: pp () com.google.android.gms.tagmanager.bz
        public bz<class_53.class_1172> method_2649() {
            return this.arj;
        }
    }

    private static class class_1207 {
        private final Set<class_638.class_1809> ara = new HashSet();
        private final Map<class_638.class_1809, List<class_638.class_1805>> ark = new HashMap();
        private final Map<class_638.class_1809, List<class_638.class_1805>> arl = new HashMap();
        private final Map<class_638.class_1809, List<String>> arm = new HashMap();
        private final Map<class_638.class_1809, List<String>> arn = new HashMap();
        private class_638.class_1805 aro;

        // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, com.google.android.gms.tagmanager.cr$a) void
        public void method_2652(class_638.class_1809 var1, class_638.class_1805 var2) {
            Object var3 = (List)this.ark.get(var1);
            if(var3 == null) {
                var3 = new ArrayList();
                this.ark.put(var1, var3);
            }

            ((List)var3).add(var2);
        }

        // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e, java.lang.String) void
        public void method_2653(class_638.class_1809 var1, String var2) {
            Object var3 = (List)this.arm.get(var1);
            if(var3 == null) {
                var3 = new ArrayList();
                this.arm.put(var1, var3);
            }

            ((List)var3).add(var2);
        }

        // $FF: renamed from: b (com.google.android.gms.tagmanager.cr$e) void
        public void method_2654(class_638.class_1809 var1) {
            this.ara.add(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.tagmanager.cr$e, com.google.android.gms.tagmanager.cr$a) void
        public void method_2655(class_638.class_1809 var1, class_638.class_1805 var2) {
            Object var3 = (List)this.arl.get(var1);
            if(var3 == null) {
                var3 = new ArrayList();
                this.arl.put(var1, var3);
            }

            ((List)var3).add(var2);
        }

        // $FF: renamed from: b (com.google.android.gms.tagmanager.cr$e, java.lang.String) void
        public void method_2656(class_638.class_1809 var1, String var2) {
            Object var3 = (List)this.arn.get(var1);
            if(var3 == null) {
                var3 = new ArrayList();
                this.arn.put(var1, var3);
            }

            ((List)var3).add(var2);
        }

        // $FF: renamed from: i (com.google.android.gms.tagmanager.cr$a) void
        public void method_2657(class_638.class_1805 var1) {
            this.aro = var1;
        }

        // $FF: renamed from: pq () java.util.Set
        public Set<class_638.class_1809> method_2658() {
            return this.ara;
        }

        // $FF: renamed from: pr () java.util.Map
        public Map<class_638.class_1809, List<class_638.class_1805>> method_2659() {
            return this.ark;
        }

        // $FF: renamed from: ps () java.util.Map
        public Map<class_638.class_1809, List<String>> method_2660() {
            return this.arm;
        }

        // $FF: renamed from: pt () java.util.Map
        public Map<class_638.class_1809, List<String>> method_2661() {
            return this.arn;
        }

        // $FF: renamed from: pu () java.util.Map
        public Map<class_638.class_1809, List<class_638.class_1805>> method_2662() {
            return this.arl;
        }

        // $FF: renamed from: pv () com.google.android.gms.tagmanager.cr$a
        public class_638.class_1805 method_2663() {
            return this.aro;
        }
    }
}
