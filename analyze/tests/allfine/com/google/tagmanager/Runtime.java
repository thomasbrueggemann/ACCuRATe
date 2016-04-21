package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.proto.Serving;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.AdvertiserIdMacro;
import com.google.tagmanager.AdvertisingTrackingEnabledMacro;
import com.google.tagmanager.AdwordsClickReferrerMacro;
import com.google.tagmanager.AppIdMacro;
import com.google.tagmanager.AppNameMacro;
import com.google.tagmanager.AppVersionMacro;
import com.google.tagmanager.ArbitraryPixelTag;
import com.google.tagmanager.Cache;
import com.google.tagmanager.CacheFactory;
import com.google.tagmanager.ConstantMacro;
import com.google.tagmanager.ContainerVersionMacro;
import com.google.tagmanager.ContainsPredicate;
import com.google.tagmanager.CustomFunctionCall;
import com.google.tagmanager.DataLayer;
import com.google.tagmanager.DataLayerMacro;
import com.google.tagmanager.DataLayerWriteTag;
import com.google.tagmanager.DeviceIdMacro;
import com.google.tagmanager.DeviceNameMacro;
import com.google.tagmanager.EncodeMacro;
import com.google.tagmanager.EndsWithPredicate;
import com.google.tagmanager.EqualsPredicate;
import com.google.tagmanager.EventInfoBuilder;
import com.google.tagmanager.EventInfoDistributor;
import com.google.tagmanager.EventMacro;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.GreaterEqualsPredicate;
import com.google.tagmanager.GreaterThanPredicate;
import com.google.tagmanager.GtmVersionMacro;
import com.google.tagmanager.HashMacro;
import com.google.tagmanager.InstallReferrerMacro;
import com.google.tagmanager.JoinerMacro;
import com.google.tagmanager.LanguageMacro;
import com.google.tagmanager.LessEqualsPredicate;
import com.google.tagmanager.LessThanPredicate;
import com.google.tagmanager.Log;
import com.google.tagmanager.MacroEvaluationInfoBuilder;
import com.google.tagmanager.MobileAdwordsUniqueIdMacro;
import com.google.tagmanager.NoopEventInfoDistributor;
import com.google.tagmanager.NoopValueBuilder;
import com.google.tagmanager.ObjectAndStatic;
import com.google.tagmanager.OsVersionMacro;
import com.google.tagmanager.PlatformMacro;
import com.google.tagmanager.RandomMacro;
import com.google.tagmanager.RegexGroupMacro;
import com.google.tagmanager.RegexPredicate;
import com.google.tagmanager.ResolutionMacro;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.ResolvedPropertyBuilder;
import com.google.tagmanager.ResolvedRuleBuilder;
import com.google.tagmanager.ResourceUtil;
import com.google.tagmanager.RuleEvaluationStepInfoBuilder;
import com.google.tagmanager.RuntimeVersionMacro;
import com.google.tagmanager.SdkVersionMacro;
import com.google.tagmanager.StartsWithPredicate;
import com.google.tagmanager.TimeMacro;
import com.google.tagmanager.Types;
import com.google.tagmanager.UniversalAnalyticsTag;
import com.google.tagmanager.ValueBuilder;
import com.google.tagmanager.ValueEscapeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class Runtime {
    static final String DEFAULT_RULE_NAME = "Unknown";
    private static final ObjectAndStatic<TypeSystem.Value> DEFAULT_VALUE_AND_STATIC = new ObjectAndStatic(Types.getDefaultValue(), true);
    static final String EXPERIMENT_SUPPLEMENTAL_NAME_PREFIX = "gaExperiment:";
    private static final int MAX_CACHE_SIZE = 1048576;
    private final EventInfoDistributor eventInfoDistributor;
    private volatile String mCurrentEventName;
    private final DataLayer mDataLayer;
    private final Cache<ResourceUtil.ExpandedFunctionCall, ObjectAndStatic<TypeSystem.Value>> mFunctionCallCache;
    private final Cache<String, Runtime.CachedMacro> mMacroEvaluationCache;
    private final Map<String, Runtime.MacroInfo> mMacroLookup;
    private final Map<String, FunctionCallImplementation> mMacroMap;
    private final Map<String, FunctionCallImplementation> mPredicateMap;
    private final ResourceUtil.ExpandedResource mResource;
    private final Set<ResourceUtil.ExpandedRule> mRules;
    private final Map<String, FunctionCallImplementation> mTrackingTagMap;

    public Runtime(Context var1, ResourceUtil.ExpandedResource var2, DataLayer var3, CustomFunctionCall.CustomEvaluator var4, CustomFunctionCall.CustomEvaluator var5) {
        this(var1, var2, var3, var4, var5, new NoopEventInfoDistributor());
    }

    public Runtime(Context var1, ResourceUtil.ExpandedResource var2, DataLayer var3, CustomFunctionCall.CustomEvaluator var4, CustomFunctionCall.CustomEvaluator var5, EventInfoDistributor var6) {
        if(var2 == null) {
            throw new NullPointerException("resource cannot be null");
        } else {
            this.mResource = var2;
            this.mRules = new HashSet(var2.getRules());
            this.mDataLayer = var3;
            this.eventInfoDistributor = var6;
            CacheFactory.CacheSizeManager var7 = new CacheFactory.CacheSizeManager() {
                public int sizeOf(ResourceUtil.ExpandedFunctionCall var1, ObjectAndStatic<TypeSystem.Value> var2) {
                    return ((TypeSystem.Value)var2.getObject()).getCachedSize();
                }
            };
            this.mFunctionCallCache = (new CacheFactory()).createCache(1048576, var7);
            CacheFactory.CacheSizeManager var8 = new CacheFactory.CacheSizeManager() {
                public int sizeOf(String var1, Runtime.CachedMacro var2) {
                    return var1.length() + var2.getSize();
                }
            };
            this.mMacroEvaluationCache = (new CacheFactory()).createCache(1048576, var8);
            this.mTrackingTagMap = new HashMap();
            this.addTrackingTag(new ArbitraryPixelTag(var1));
            this.addTrackingTag(new CustomFunctionCall(var5));
            this.addTrackingTag(new DataLayerWriteTag(var3));
            this.addTrackingTag(new UniversalAnalyticsTag(var1, var3));
            this.mPredicateMap = new HashMap();
            this.addPredicate(new ContainsPredicate());
            this.addPredicate(new EndsWithPredicate());
            this.addPredicate(new EqualsPredicate());
            this.addPredicate(new GreaterEqualsPredicate());
            this.addPredicate(new GreaterThanPredicate());
            this.addPredicate(new LessEqualsPredicate());
            this.addPredicate(new LessThanPredicate());
            this.addPredicate(new RegexPredicate());
            this.addPredicate(new StartsWithPredicate());
            this.mMacroMap = new HashMap();
            this.addMacro(new AdvertiserIdMacro(var1));
            this.addMacro(new AdvertisingTrackingEnabledMacro());
            this.addMacro(new AdwordsClickReferrerMacro(var1));
            this.addMacro(new AppIdMacro(var1));
            this.addMacro(new AppNameMacro(var1));
            this.addMacro(new AppVersionMacro(var1));
            this.addMacro(new ConstantMacro());
            this.addMacro(new ContainerVersionMacro(this));
            this.addMacro(new CustomFunctionCall(var4));
            this.addMacro(new DataLayerMacro(var3));
            this.addMacro(new DeviceIdMacro(var1));
            this.addMacro(new DeviceNameMacro());
            this.addMacro(new EncodeMacro());
            this.addMacro(new EventMacro(this));
            this.addMacro(new GtmVersionMacro());
            this.addMacro(new HashMacro());
            this.addMacro(new InstallReferrerMacro(var1));
            this.addMacro(new JoinerMacro());
            this.addMacro(new LanguageMacro());
            this.addMacro(new MobileAdwordsUniqueIdMacro(var1));
            this.addMacro(new OsVersionMacro());
            this.addMacro(new PlatformMacro());
            this.addMacro(new RandomMacro());
            this.addMacro(new RegexGroupMacro());
            this.addMacro(new ResolutionMacro(var1));
            this.addMacro(new RuntimeVersionMacro());
            this.addMacro(new SdkVersionMacro());
            this.addMacro(new TimeMacro());
            this.mMacroLookup = new HashMap();
            Iterator var9 = this.mRules.iterator();

            while(var9.hasNext()) {
                ResourceUtil.ExpandedRule var14 = (ResourceUtil.ExpandedRule)var9.next();
                if(var6.debugMode()) {
                    verifyFunctionAndNameListSizes(var14.getAddMacros(), var14.getAddMacroRuleNames(), "add macro");
                    verifyFunctionAndNameListSizes(var14.getRemoveMacros(), var14.getRemoveMacroRuleNames(), "remove macro");
                    verifyFunctionAndNameListSizes(var14.getAddTags(), var14.getAddTagRuleNames(), "add tag");
                    verifyFunctionAndNameListSizes(var14.getRemoveTags(), var14.getRemoveTagRuleNames(), "remove tag");
                }

                for(int var15 = 0; var15 < var14.getAddMacros().size(); ++var15) {
                    ResourceUtil.ExpandedFunctionCall var20 = (ResourceUtil.ExpandedFunctionCall)var14.getAddMacros().get(var15);
                    String var21 = "Unknown";
                    if(var6.debugMode() && var15 < var14.getAddMacroRuleNames().size()) {
                        var21 = (String)var14.getAddMacroRuleNames().get(var15);
                    }

                    Runtime.MacroInfo var22 = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(var20));
                    var22.addRule(var14);
                    var22.addAddMacroForRule(var14, var20);
                    var22.addAddMacroRuleNameForRule(var14, var21);
                }

                for(int var16 = 0; var16 < var14.getRemoveMacros().size(); ++var16) {
                    ResourceUtil.ExpandedFunctionCall var17 = (ResourceUtil.ExpandedFunctionCall)var14.getRemoveMacros().get(var16);
                    String var18 = "Unknown";
                    if(var6.debugMode() && var16 < var14.getRemoveMacroRuleNames().size()) {
                        var18 = (String)var14.getRemoveMacroRuleNames().get(var16);
                    }

                    Runtime.MacroInfo var19 = getOrAddMacroInfo(this.mMacroLookup, getFunctionName(var17));
                    var19.addRule(var14);
                    var19.addRemoveMacroForRule(var14, var17);
                    var19.addRemoveMacroRuleNameForRule(var14, var18);
                }
            }

            Iterator var10 = this.mResource.getAllMacros().entrySet().iterator();

            while(var10.hasNext()) {
                Entry var11 = (Entry)var10.next();
                Iterator var12 = ((List)var11.getValue()).iterator();

                while(var12.hasNext()) {
                    ResourceUtil.ExpandedFunctionCall var13 = (ResourceUtil.ExpandedFunctionCall)var12.next();
                    if(!Types.valueToBoolean((TypeSystem.Value)var13.getProperties().get(Key.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                        getOrAddMacroInfo(this.mMacroLookup, (String)var11.getKey()).setDefault(var13);
                    }
                }
            }

        }
    }

    private static void addFunctionImplToMap(Map<String, FunctionCallImplementation> var0, FunctionCallImplementation var1) {
        if(var0.containsKey(var1.getInstanceFunctionId())) {
            throw new IllegalArgumentException("Duplicate function type name: " + var1.getInstanceFunctionId());
        } else {
            var0.put(var1.getInstanceFunctionId(), var1);
        }
    }

    private ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateGenericToRun(Set<ResourceUtil.ExpandedRule> var1, Set<String> var2, Runtime.AddRemoveSetPopulator var3, RuleEvaluationStepInfoBuilder var4) {
        HashSet var5 = new HashSet();
        HashSet var6 = new HashSet();
        boolean var7 = true;
        Iterator var8 = var1.iterator();

        while(true) {
            while(var8.hasNext()) {
                ResourceUtil.ExpandedRule var10 = (ResourceUtil.ExpandedRule)var8.next();
                ResolvedRuleBuilder var11 = var4.createResolvedRuleBuilder();
                ObjectAndStatic var12 = this.evaluatePredicatesInRule(var10, var2, var11);
                if(((Boolean)var12.getObject()).booleanValue()) {
                    var3.rulePassed(var10, var5, var6, var11);
                }

                if(var7 && var12.isStatic()) {
                    var7 = true;
                } else {
                    var7 = false;
                }
            }

            var5.removeAll(var6);
            var4.setEnabledFunctions(var5);
            return new ObjectAndStatic(var5, var7);
        }
    }

    private ObjectAndStatic<TypeSystem.Value> evaluateMacroReferenceCycleDetection(String var1, Set<String> var2, MacroEvaluationInfoBuilder var3) {
        Runtime.CachedMacro var4 = (Runtime.CachedMacro)this.mMacroEvaluationCache.get(var1);
        if(var4 != null && !this.eventInfoDistributor.debugMode()) {
            this.pushUnevaluatedValueToDataLayer(var4.getPushAfterEvaluate(), var2);
            return var4.getObjectAndStatic();
        } else {
            Runtime.MacroInfo var5 = (Runtime.MacroInfo)this.mMacroLookup.get(var1);
            if(var5 == null) {
                Log.method_5503("Invalid macro: " + var1);
                return DEFAULT_VALUE_AND_STATIC;
            } else {
                ObjectAndStatic var6 = this.calculateMacrosToRun(var1, var5.getRules(), var5.getAddMacros(), var5.getAddMacroRuleNames(), var5.getRemoveMacros(), var5.getRemoveMacroRuleNames(), var2, var3.createRulesEvaluation());
                ResourceUtil.ExpandedFunctionCall var7;
                if(((Set)var6.getObject()).isEmpty()) {
                    var7 = var5.getDefault();
                } else {
                    if(((Set)var6.getObject()).size() > 1) {
                        Log.method_5509("Multiple macros active for macroName " + var1);
                    }

                    var7 = (ResourceUtil.ExpandedFunctionCall)((Set)var6.getObject()).iterator().next();
                }

                if(var7 == null) {
                    return DEFAULT_VALUE_AND_STATIC;
                } else {
                    ObjectAndStatic var8 = this.executeFunction(this.mMacroMap, var7, var2, var3.createResult());
                    boolean var9;
                    if(var6.isStatic() && var8.isStatic()) {
                        var9 = true;
                    } else {
                        var9 = false;
                    }

                    ObjectAndStatic var11;
                    if(var8 == DEFAULT_VALUE_AND_STATIC) {
                        var11 = DEFAULT_VALUE_AND_STATIC;
                    } else {
                        Object var10 = var8.getObject();
                        var11 = new ObjectAndStatic(var10, var9);
                    }

                    TypeSystem.Value var12 = var7.getPushAfterEvaluate();
                    if(var11.isStatic()) {
                        this.mMacroEvaluationCache.put(var1, new Runtime.CachedMacro(var11, var12));
                    }

                    this.pushUnevaluatedValueToDataLayer(var12, var2);
                    return var11;
                }
            }
        }
    }

    private ObjectAndStatic<TypeSystem.Value> executeFunction(Map<String, FunctionCallImplementation> var1, ResourceUtil.ExpandedFunctionCall var2, Set<String> var3, ResolvedFunctionCallBuilder var4) {
        TypeSystem.Value var5 = (TypeSystem.Value)var2.getProperties().get(Key.FUNCTION.toString());
        ObjectAndStatic var8;
        if(var5 == null) {
            Log.method_5503("No function id in properties");
            var8 = DEFAULT_VALUE_AND_STATIC;
        } else {
            String var6 = var5.functionId;
            FunctionCallImplementation var7 = (FunctionCallImplementation)var1.get(var6);
            if(var7 == null) {
                Log.method_5503(var6 + " has no backing implementation.");
                return DEFAULT_VALUE_AND_STATIC;
            }

            var8 = (ObjectAndStatic)this.mFunctionCallCache.get(var2);
            if(var8 == null || this.eventInfoDistributor.debugMode()) {
                HashMap var9 = new HashMap();
                boolean var10 = true;

                ObjectAndStatic var16;
                Entry var14;
                for(Iterator var11 = var2.getProperties().entrySet().iterator(); var11.hasNext(); var9.put(var14.getKey(), var16.getObject())) {
                    var14 = (Entry)var11.next();
                    ResolvedPropertyBuilder var15 = var4.createResolvedPropertyBuilder((String)var14.getKey());
                    var16 = this.macroExpandValue((TypeSystem.Value)var14.getValue(), var3, var15.createPropertyValueBuilder((TypeSystem.Value)var14.getValue()));
                    if(var16 == DEFAULT_VALUE_AND_STATIC) {
                        return DEFAULT_VALUE_AND_STATIC;
                    }

                    if(var16.isStatic()) {
                        var2.updateCacheableProperty((String)var14.getKey(), (TypeSystem.Value)var16.getObject());
                    } else {
                        var10 = false;
                    }
                }

                if(!var7.hasRequiredKeys(var9.keySet())) {
                    Log.method_5503("Incorrect keys for function " + var6 + " required " + var7.getRequiredKeys() + " had " + var9.keySet());
                    return DEFAULT_VALUE_AND_STATIC;
                }

                boolean var12;
                if(var10 && var7.isCacheable()) {
                    var12 = true;
                } else {
                    var12 = false;
                }

                ObjectAndStatic var13 = new ObjectAndStatic(var7.evaluate(var9), var12);
                if(var12) {
                    this.mFunctionCallCache.put(var2, var13);
                }

                var4.setFunctionResult((TypeSystem.Value)var13.getObject());
                return var13;
            }
        }

        return var8;
    }

    private static String getFunctionName(ResourceUtil.ExpandedFunctionCall var0) {
        return Types.valueToString((TypeSystem.Value)var0.getProperties().get(Key.INSTANCE_NAME.toString()));
    }

    private static Runtime.MacroInfo getOrAddMacroInfo(Map<String, Runtime.MacroInfo> var0, String var1) {
        Runtime.MacroInfo var2 = (Runtime.MacroInfo)var0.get(var1);
        if(var2 == null) {
            var2 = new Runtime.MacroInfo();
            var0.put(var1, var2);
        }

        return var2;
    }

    private ObjectAndStatic<TypeSystem.Value> macroExpandValue(TypeSystem.Value var1, Set<String> var2, ValueBuilder var3) {
        if(!var1.containsReferences) {
            return new ObjectAndStatic(var1, true);
        } else {
            switch(var1.type) {
                case 2:
                    TypeSystem.Value var14 = ResourceUtil.newValueBasedOnValue(var1);
                    var14.listItem = new TypeSystem.Value[var1.listItem.length];

                    for(int var15 = 0; var15 < var1.listItem.length; ++var15) {
                        ObjectAndStatic var16 = this.macroExpandValue(var1.listItem[var15], var2, var3.getListItem(var15));
                        if(var16 == DEFAULT_VALUE_AND_STATIC) {
                            return DEFAULT_VALUE_AND_STATIC;
                        }

                        var14.listItem[var15] = (TypeSystem.Value)var16.getObject();
                    }

                    return new ObjectAndStatic(var14, false);
                case 3:
                    TypeSystem.Value var10 = ResourceUtil.newValueBasedOnValue(var1);
                    if(var1.mapKey.length != var1.mapValue.length) {
                        Log.method_5503("Invalid serving value: " + var1.toString());
                        return DEFAULT_VALUE_AND_STATIC;
                    } else {
                        var10.mapKey = new TypeSystem.Value[var1.mapKey.length];
                        var10.mapValue = new TypeSystem.Value[var1.mapKey.length];

                        for(int var11 = 0; var11 < var1.mapKey.length; ++var11) {
                            ObjectAndStatic var12 = this.macroExpandValue(var1.mapKey[var11], var2, var3.getMapKey(var11));
                            ObjectAndStatic var13 = this.macroExpandValue(var1.mapValue[var11], var2, var3.getMapValue(var11));
                            if(var12 == DEFAULT_VALUE_AND_STATIC || var13 == DEFAULT_VALUE_AND_STATIC) {
                                return DEFAULT_VALUE_AND_STATIC;
                            }

                            var10.mapKey[var11] = (TypeSystem.Value)var12.getObject();
                            var10.mapValue[var11] = (TypeSystem.Value)var13.getObject();
                        }

                        return new ObjectAndStatic(var10, false);
                    }
                case 4:
                    if(var2.contains(var1.macroReference)) {
                        Log.method_5503("Macro cycle detected.  Current macro reference: " + var1.macroReference + "." + "  Previous macro references: " + var2.toString() + ".");
                        return DEFAULT_VALUE_AND_STATIC;
                    }

                    var2.add(var1.macroReference);
                    ObjectAndStatic var8 = ValueEscapeUtil.applyEscapings(this.evaluateMacroReferenceCycleDetection(var1.macroReference, var2, var3.createValueMacroEvaluationInfoExtension()), var1.escaping);
                    var2.remove(var1.macroReference);
                    return var8;
                case 5:
                case 6:
                default:
                    Log.method_5503("Unknown type: " + var1.type);
                    return DEFAULT_VALUE_AND_STATIC;
                case 7:
                    TypeSystem.Value var4 = ResourceUtil.newValueBasedOnValue(var1);
                    var4.templateToken = new TypeSystem.Value[var1.templateToken.length];

                    for(int var5 = 0; var5 < var1.templateToken.length; ++var5) {
                        ObjectAndStatic var6 = this.macroExpandValue(var1.templateToken[var5], var2, var3.getTemplateToken(var5));
                        if(var6 == DEFAULT_VALUE_AND_STATIC) {
                            return DEFAULT_VALUE_AND_STATIC;
                        }

                        var4.templateToken[var5] = (TypeSystem.Value)var6.getObject();
                    }

                    return new ObjectAndStatic(var4, false);
            }
        }
    }

    private void pushUnevaluatedValueToDataLayer(TypeSystem.Value var1, Set<String> var2) {
        if(var1 != null) {
            ObjectAndStatic var3 = this.macroExpandValue(var1, var2, new NoopValueBuilder());
            if(var3 != DEFAULT_VALUE_AND_STATIC) {
                Object var4 = Types.valueToObject((TypeSystem.Value)var3.getObject());
                if(var4 instanceof Map) {
                    Map var8 = (Map)var4;
                    this.mDataLayer.push(var8);
                    return;
                }

                if(!(var4 instanceof List)) {
                    Log.method_5509("pushAfterEvaluate: value not a Map or List");
                    return;
                }

                Iterator var5 = ((List)var4).iterator();

                while(var5.hasNext()) {
                    Object var6 = var5.next();
                    if(var6 instanceof Map) {
                        Map var7 = (Map)var6;
                        this.mDataLayer.push(var7);
                    } else {
                        Log.method_5509("pushAfterEvaluate: value not a Map");
                    }
                }
            }
        }

    }

    private static void verifyFunctionAndNameListSizes(List<ResourceUtil.ExpandedFunctionCall> var0, List<String> var1, String var2) {
        if(var0.size() != var1.size()) {
            Log.method_5505("Invalid resource: imbalance of rule names of functions for " + var2 + " operation. Using default rule name instead");
        }

    }

    @VisibleForTesting
    void addMacro(FunctionCallImplementation var1) {
        addFunctionImplToMap(this.mMacroMap, var1);
    }

    @VisibleForTesting
    void addPredicate(FunctionCallImplementation var1) {
        addFunctionImplToMap(this.mPredicateMap, var1);
    }

    @VisibleForTesting
    void addTrackingTag(FunctionCallImplementation var1) {
        addFunctionImplToMap(this.mTrackingTagMap, var1);
    }

    @VisibleForTesting
    ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateMacrosToRun(String var1, Set<ResourceUtil.ExpandedRule> var2, final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> var3, final Map<ResourceUtil.ExpandedRule, List<String>> var4, final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> var5, final Map<ResourceUtil.ExpandedRule, List<String>> var6, Set<String> var7, RuleEvaluationStepInfoBuilder var8) {
        return this.calculateGenericToRun(var2, var7, new Runtime.AddRemoveSetPopulator() {
            public void rulePassed(ResourceUtil.ExpandedRule var1, Set<ResourceUtil.ExpandedFunctionCall> var2, Set<ResourceUtil.ExpandedFunctionCall> var3x, ResolvedRuleBuilder var4x) {
                List var5x = (List)var3.get(var1);
                List var6x = (List)var4.get(var1);
                if(var5x != null) {
                    var2.addAll(var5x);
                    var4x.getAddedMacroFunctions().translateAndAddAll(var5x, var6x);
                }

                List var7 = (List)var5.get(var1);
                List var8 = (List)var6.get(var1);
                if(var7 != null) {
                    var3x.addAll(var7);
                    var4x.getRemovedMacroFunctions().translateAndAddAll(var7, var8);
                }

            }
        }, var8);
    }

    @VisibleForTesting
    ObjectAndStatic<Set<ResourceUtil.ExpandedFunctionCall>> calculateTagsToRun(Set<ResourceUtil.ExpandedRule> var1, RuleEvaluationStepInfoBuilder var2) {
        return this.calculateGenericToRun(var1, new HashSet(), new Runtime.AddRemoveSetPopulator() {
            public void rulePassed(ResourceUtil.ExpandedRule var1, Set<ResourceUtil.ExpandedFunctionCall> var2, Set<ResourceUtil.ExpandedFunctionCall> var3, ResolvedRuleBuilder var4) {
                var2.addAll(var1.getAddTags());
                var3.addAll(var1.getRemoveTags());
                var4.getAddedTagFunctions().translateAndAddAll(var1.getAddTags(), var1.getAddTagRuleNames());
                var4.getRemovedTagFunctions().translateAndAddAll(var1.getRemoveTags(), var1.getRemoveTagRuleNames());
            }
        }, var2);
    }

    public ObjectAndStatic<TypeSystem.Value> evaluateMacroReference(String var1) {
        EventInfoBuilder var2 = this.eventInfoDistributor.createMacroEvalutionEventInfo(var1);
        ObjectAndStatic var3 = this.evaluateMacroReferenceCycleDetection(var1, new HashSet(), var2.createMacroEvaluationInfoBuilder());
        var2.processEventInfo();
        return var3;
    }

    @VisibleForTesting
    ObjectAndStatic<Boolean> evaluatePredicate(ResourceUtil.ExpandedFunctionCall var1, Set<String> var2, ResolvedFunctionCallBuilder var3) {
        ObjectAndStatic var4 = this.executeFunction(this.mPredicateMap, var1, var2, var3);
        Boolean var5 = Types.valueToBoolean((TypeSystem.Value)var4.getObject());
        var3.setFunctionResult(Types.objectToValue(var5));
        return new ObjectAndStatic(var5, var4.isStatic());
    }

    @VisibleForTesting
    ObjectAndStatic<Boolean> evaluatePredicatesInRule(ResourceUtil.ExpandedRule var1, Set<String> var2, ResolvedRuleBuilder var3) {
        boolean var4 = true;
        Iterator var5 = var1.getNegativePredicates().iterator();

        while(var5.hasNext()) {
            ObjectAndStatic var8 = this.evaluatePredicate((ResourceUtil.ExpandedFunctionCall)var5.next(), var2, var3.createNegativePredicate());
            if(((Boolean)var8.getObject()).booleanValue()) {
                var3.setValue(Types.objectToValue(Boolean.valueOf(false)));
                return new ObjectAndStatic(Boolean.valueOf(false), var8.isStatic());
            }

            if(var4 && var8.isStatic()) {
                var4 = true;
            } else {
                var4 = false;
            }
        }

        Iterator var6 = var1.getPositivePredicates().iterator();

        while(true) {
            while(var6.hasNext()) {
                ObjectAndStatic var7 = this.evaluatePredicate((ResourceUtil.ExpandedFunctionCall)var6.next(), var2, var3.createPositivePredicate());
                if(!((Boolean)var7.getObject()).booleanValue()) {
                    var3.setValue(Types.objectToValue(Boolean.valueOf(false)));
                    return new ObjectAndStatic(Boolean.valueOf(false), var7.isStatic());
                }

                if(var4 && var7.isStatic()) {
                    var4 = true;
                } else {
                    var4 = false;
                }
            }

            var3.setValue(Types.objectToValue(Boolean.valueOf(true)));
            return new ObjectAndStatic(Boolean.valueOf(true), var4);
        }
    }

    public void evaluateTags(String param1) {
        // $FF: Couldn't be decompiled
    }

    String getCurrentEventName() {
        synchronized(this) {}

        String var2;
        try {
            var2 = this.mCurrentEventName;
        } finally {
            ;
        }

        return var2;
    }

    public ResourceUtil.ExpandedResource getResource() {
        return this.mResource;
    }

    @VisibleForTesting
    void setCurrentEventName(String var1) {
        synchronized(this) {}

        try {
            this.mCurrentEventName = var1;
        } finally {
            ;
        }

    }

    public void setSupplementals(List<Serving.Supplemental> param1) {
        // $FF: Couldn't be decompiled
    }

    interface AddRemoveSetPopulator {
        void rulePassed(ResourceUtil.ExpandedRule var1, Set<ResourceUtil.ExpandedFunctionCall> var2, Set<ResourceUtil.ExpandedFunctionCall> var3, ResolvedRuleBuilder var4);
    }

    private static class CachedMacro {
        private ObjectAndStatic<TypeSystem.Value> mObjectAndStatic;
        private TypeSystem.Value mPushAfterEvaluate;

        public CachedMacro(ObjectAndStatic<TypeSystem.Value> var1) {
            this(var1, (TypeSystem.Value)null);
        }

        public CachedMacro(ObjectAndStatic<TypeSystem.Value> var1, TypeSystem.Value var2) {
            this.mObjectAndStatic = var1;
            this.mPushAfterEvaluate = var2;
        }

        public ObjectAndStatic<TypeSystem.Value> getObjectAndStatic() {
            return this.mObjectAndStatic;
        }

        public TypeSystem.Value getPushAfterEvaluate() {
            return this.mPushAfterEvaluate;
        }

        public int getSize() {
            int var1 = ((TypeSystem.Value)this.mObjectAndStatic.getObject()).getCachedSize();
            int var2;
            if(this.mPushAfterEvaluate == null) {
                var2 = 0;
            } else {
                var2 = this.mPushAfterEvaluate.getCachedSize();
            }

            return var2 + var1;
        }
    }

    private static class MacroInfo {
        private final Map<ResourceUtil.ExpandedRule, List<String>> mAddMacroNames = new HashMap();
        private final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> mAddMacros = new HashMap();
        private ResourceUtil.ExpandedFunctionCall mDefault;
        private final Map<ResourceUtil.ExpandedRule, List<String>> mRemoveMacroNames = new HashMap();
        private final Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> mRemoveMacros = new HashMap();
        private final Set<ResourceUtil.ExpandedRule> mRules = new HashSet();

        public void addAddMacroForRule(ResourceUtil.ExpandedRule var1, ResourceUtil.ExpandedFunctionCall var2) {
            Object var3 = (List)this.mAddMacros.get(var1);
            if(var3 == null) {
                var3 = new ArrayList();
                this.mAddMacros.put(var1, var3);
            }

            ((List)var3).add(var2);
        }

        public void addAddMacroRuleNameForRule(ResourceUtil.ExpandedRule var1, String var2) {
            Object var3 = (List)this.mAddMacroNames.get(var1);
            if(var3 == null) {
                var3 = new ArrayList();
                this.mAddMacroNames.put(var1, var3);
            }

            ((List)var3).add(var2);
        }

        public void addRemoveMacroForRule(ResourceUtil.ExpandedRule var1, ResourceUtil.ExpandedFunctionCall var2) {
            Object var3 = (List)this.mRemoveMacros.get(var1);
            if(var3 == null) {
                var3 = new ArrayList();
                this.mRemoveMacros.put(var1, var3);
            }

            ((List)var3).add(var2);
        }

        public void addRemoveMacroRuleNameForRule(ResourceUtil.ExpandedRule var1, String var2) {
            Object var3 = (List)this.mRemoveMacroNames.get(var1);
            if(var3 == null) {
                var3 = new ArrayList();
                this.mRemoveMacroNames.put(var1, var3);
            }

            ((List)var3).add(var2);
        }

        public void addRule(ResourceUtil.ExpandedRule var1) {
            this.mRules.add(var1);
        }

        public Map<ResourceUtil.ExpandedRule, List<String>> getAddMacroRuleNames() {
            return this.mAddMacroNames;
        }

        public Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> getAddMacros() {
            return this.mAddMacros;
        }

        public ResourceUtil.ExpandedFunctionCall getDefault() {
            return this.mDefault;
        }

        public Map<ResourceUtil.ExpandedRule, List<String>> getRemoveMacroRuleNames() {
            return this.mRemoveMacroNames;
        }

        public Map<ResourceUtil.ExpandedRule, List<ResourceUtil.ExpandedFunctionCall>> getRemoveMacros() {
            return this.mRemoveMacros;
        }

        public Set<ResourceUtil.ExpandedRule> getRules() {
            return this.mRules;
        }

        public void setDefault(ResourceUtil.ExpandedFunctionCall var1) {
            this.mDefault = var1;
        }
    }
}
