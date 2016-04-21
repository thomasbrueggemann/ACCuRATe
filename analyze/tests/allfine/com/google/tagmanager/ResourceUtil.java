package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.proto.Serving;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.Log;
import com.google.tagmanager.Types;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ResourceUtil {
    private static final int BUFFER_SIZE = 1024;

    public static void copyStream(InputStream var0, OutputStream var1) throws IOException {
        byte[] var2 = new byte[1024];

        while(true) {
            int var3 = var0.read(var2);
            if(var3 == -1) {
                return;
            }

            var1.write(var2, 0, var3);
        }
    }

    private static ResourceUtil.ExpandedFunctionCall expandFunctionCall(Serving.FunctionCall var0, Serving.Resource var1, TypeSystem.Value[] var2, int var3) throws ResourceUtil.InvalidResourceException {
        ResourceUtil.ExpandedFunctionCallBuilder var4 = ResourceUtil.ExpandedFunctionCall.newBuilder();
        int[] var5 = var0.property;
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Integer var8 = Integer.valueOf(var5[var7]);
            Serving.Property var9 = (Serving.Property)getWithBoundsCheck((Object[])var1.property, var8.intValue(), "properties");
            String var10 = (String)getWithBoundsCheck((Object[])var1.key, var9.key, "keys");
            TypeSystem.Value var11 = (TypeSystem.Value)getWithBoundsCheck((Object[])var2, var9.value, "values");
            if(Key.PUSH_AFTER_EVALUATE.toString().equals(var10)) {
                var4.setPushAfterEvaluate(var11);
            } else {
                var4.addProperty(var10, var11);
            }
        }

        return var4.build();
    }

    private static ResourceUtil.ExpandedRule expandRule(Serving.Rule var0, List<ResourceUtil.ExpandedFunctionCall> var1, List<ResourceUtil.ExpandedFunctionCall> var2, List<ResourceUtil.ExpandedFunctionCall> var3, Serving.Resource var4) {
        ResourceUtil.ExpandedRuleBuilder var5 = ResourceUtil.ExpandedRule.newBuilder();
        int[] var6 = var0.positivePredicate;
        int var7 = var6.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            var5.addPositivePredicate((ResourceUtil.ExpandedFunctionCall)var3.get(Integer.valueOf(var6[var8]).intValue()));
        }

        int[] var9 = var0.negativePredicate;
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            var5.addNegativePredicate((ResourceUtil.ExpandedFunctionCall)var3.get(Integer.valueOf(var9[var11]).intValue()));
        }

        int[] var12 = var0.addTag;
        int var13 = var12.length;

        for(int var14 = 0; var14 < var13; ++var14) {
            var5.addAddTag((ResourceUtil.ExpandedFunctionCall)var1.get(Integer.valueOf(var12[var14]).intValue()));
        }

        int[] var15 = var0.addTagRuleName;
        int var16 = var15.length;

        for(int var17 = 0; var17 < var16; ++var17) {
            Integer var45 = Integer.valueOf(var15[var17]);
            var5.addAddTagRuleName(var4.value[var45.intValue()].string);
        }

        int[] var18 = var0.removeTag;
        int var19 = var18.length;

        for(int var20 = 0; var20 < var19; ++var20) {
            var5.addRemoveTag((ResourceUtil.ExpandedFunctionCall)var1.get(Integer.valueOf(var18[var20]).intValue()));
        }

        int[] var21 = var0.removeTagRuleName;
        int var22 = var21.length;

        for(int var23 = 0; var23 < var22; ++var23) {
            Integer var42 = Integer.valueOf(var21[var23]);
            var5.addRemoveTagRuleName(var4.value[var42.intValue()].string);
        }

        int[] var24 = var0.addMacro;
        int var25 = var24.length;

        for(int var26 = 0; var26 < var25; ++var26) {
            var5.addAddMacro((ResourceUtil.ExpandedFunctionCall)var2.get(Integer.valueOf(var24[var26]).intValue()));
        }

        int[] var27 = var0.addMacroRuleName;
        int var28 = var27.length;

        for(int var29 = 0; var29 < var28; ++var29) {
            Integer var39 = Integer.valueOf(var27[var29]);
            var5.addAddMacroRuleName(var4.value[var39.intValue()].string);
        }

        int[] var30 = var0.removeMacro;
        int var31 = var30.length;

        for(int var32 = 0; var32 < var31; ++var32) {
            var5.addRemoveMacro((ResourceUtil.ExpandedFunctionCall)var2.get(Integer.valueOf(var30[var32]).intValue()));
        }

        int[] var33 = var0.removeMacroRuleName;
        int var34 = var33.length;

        for(int var35 = 0; var35 < var34; ++var35) {
            Integer var36 = Integer.valueOf(var33[var35]);
            var5.addRemoveMacroRuleName(var4.value[var36.intValue()].string);
        }

        return var5.build();
    }

    private static TypeSystem.Value expandValue(int var0, Serving.Resource var1, TypeSystem.Value[] var2, Set<Integer> var3) throws ResourceUtil.InvalidResourceException {
        if(var3.contains(Integer.valueOf(var0))) {
            logAndThrow("Value cycle detected.  Current value reference: " + var0 + "." + "  Previous value references: " + var3 + ".");
        }

        TypeSystem.Value var4 = (TypeSystem.Value)getWithBoundsCheck((Object[])var1.value, var0, "values");
        if(var2[var0] != null) {
            return var2[var0];
        } else {
            TypeSystem.Value var7;
            var3.add(Integer.valueOf(var0));
            int var6 = var4.type;
            var7 = null;
            label54:
            switch(var6) {
                case 1:
                case 5:
                case 6:
                case 8:
                    var7 = var4;
                    break;
                case 2:
                    Serving.ServingValue var32 = getServingValue(var4);
                    var7 = newValueBasedOnValue(var4);
                    var7.listItem = new TypeSystem.Value[var32.listItem.length];
                    int[] var33 = var32.listItem;
                    int var34 = var33.length;
                    int var35 = 0;
                    int var36 = 0;

                    while(true) {
                        if(var35 >= var34) {
                            break label54;
                        }

                        int var37 = var33[var35];
                        TypeSystem.Value[] var38 = var7.listItem;
                        int var39 = var36 + 1;
                        var38[var36] = expandValue(var37, var1, var2, var3);
                        ++var35;
                        var36 = var39;
                    }
                case 3:
                    var7 = newValueBasedOnValue(var4);
                    Serving.ServingValue var17 = getServingValue(var4);
                    if(var17.mapKey.length != var17.mapValue.length) {
                        logAndThrow("Uneven map keys (" + var17.mapKey.length + ") and map values (" + var17.mapValue.length + ")");
                    }

                    var7.mapKey = new TypeSystem.Value[var17.mapKey.length];
                    var7.mapValue = new TypeSystem.Value[var17.mapKey.length];
                    int[] var18 = var17.mapKey;
                    int var19 = var18.length;
                    int var20 = 0;

                    int var31;
                    for(int var21 = 0; var20 < var19; var21 = var31) {
                        int var29 = var18[var20];
                        TypeSystem.Value[] var30 = var7.mapKey;
                        var31 = var21 + 1;
                        var30[var21] = expandValue(var29, var1, var2, var3);
                        ++var20;
                    }

                    int[] var22 = var17.mapValue;
                    int var23 = var22.length;
                    int var24 = 0;
                    int var25 = 0;

                    while(true) {
                        if(var24 >= var23) {
                            break label54;
                        }

                        int var26 = var22[var24];
                        TypeSystem.Value[] var27 = var7.mapValue;
                        int var28 = var25 + 1;
                        var27[var25] = expandValue(var26, var1, var2, var3);
                        ++var24;
                        var25 = var28;
                    }
                case 4:
                    var7 = newValueBasedOnValue(var4);
                    var7.macroReference = Types.valueToString(expandValue(getServingValue(var4).macroNameReference, var1, var2, var3));
                    break;
                case 7:
                    var7 = newValueBasedOnValue(var4);
                    Serving.ServingValue var9 = getServingValue(var4);
                    var7.templateToken = new TypeSystem.Value[var9.templateToken.length];
                    int[] var10 = var9.templateToken;
                    int var11 = var10.length;
                    int var12 = 0;

                    int var16;
                    for(int var13 = 0; var12 < var11; var13 = var16) {
                        int var14 = var10[var12];
                        TypeSystem.Value[] var15 = var7.templateToken;
                        var16 = var13 + 1;
                        var15[var13] = expandValue(var14, var1, var2, var3);
                        ++var12;
                    }
            }

            if(var7 == null) {
                logAndThrow("Invalid value: " + var4);
            }

            var2[var0] = var7;
            var3.remove(Integer.valueOf(var0));
            return var7;
        }
    }

    public static ResourceUtil.ExpandedResource getExpandedResource(Serving.Resource var0) throws ResourceUtil.InvalidResourceException {
        TypeSystem.Value[] var1 = new TypeSystem.Value[var0.value.length];

        for(int var2 = 0; var2 < var0.value.length; ++var2) {
            expandValue(var2, var0, var1, new HashSet(0));
        }

        ResourceUtil.ExpandedResourceBuilder var3 = ResourceUtil.ExpandedResource.newBuilder();
        ArrayList var4 = new ArrayList();

        for(int var5 = 0; var5 < var0.tag.length; ++var5) {
            var4.add(expandFunctionCall(var0.tag[var5], var0, var1, var5));
        }

        ArrayList var6 = new ArrayList();

        for(int var7 = 0; var7 < var0.predicate.length; ++var7) {
            var6.add(expandFunctionCall(var0.predicate[var7], var0, var1, var7));
        }

        ArrayList var8 = new ArrayList();

        for(int var9 = 0; var9 < var0.macro.length; ++var9) {
            ResourceUtil.ExpandedFunctionCall var16 = expandFunctionCall(var0.macro[var9], var0, var1, var9);
            var3.addMacro(var16);
            var8.add(var16);
        }

        Serving.Rule[] var10 = var0.rule;
        int var11 = var10.length;

        for(int var12 = 0; var12 < var11; ++var12) {
            var3.addRule(expandRule(var10[var12], var4, var8, var6, var0));
        }

        var3.setVersion(var0.version);
        var3.setResourceFormatVersion(var0.resourceFormatVersion);
        return var3.build();
    }

    private static Serving.ServingValue getServingValue(TypeSystem.Value var0) throws ResourceUtil.InvalidResourceException {
        if((Serving.ServingValue)var0.getExtension(Serving.ServingValue.ext) == null) {
            logAndThrow("Expected a ServingValue and didn\'t get one. Value is: " + var0);
        }

        return (Serving.ServingValue)var0.getExtension(Serving.ServingValue.ext);
    }

    private static <T> T getWithBoundsCheck(List<T> var0, int var1, String var2) throws ResourceUtil.InvalidResourceException {
        if(var1 < 0 || var1 >= var0.size()) {
            logAndThrow("Index out of bounds detected: " + var1 + " in " + var2);
        }

        return var0.get(var1);
    }

    private static <T> T getWithBoundsCheck(T[] var0, int var1, String var2) throws ResourceUtil.InvalidResourceException {
        if(var1 < 0 || var1 >= var0.length) {
            logAndThrow("Index out of bounds detected: " + var1 + " in " + var2);
        }

        return var0[var1];
    }

    private static void logAndThrow(String var0) throws ResourceUtil.InvalidResourceException {
        Log.method_5503(var0);
        throw new ResourceUtil.InvalidResourceException(var0);
    }

    public static TypeSystem.Value newValueBasedOnValue(TypeSystem.Value var0) {
        TypeSystem.Value var1 = new TypeSystem.Value();
        var1.type = var0.type;
        var1.escaping = (int[])var0.escaping.clone();
        if(var0.containsReferences) {
            var1.containsReferences = var0.containsReferences;
        }

        return var1;
    }

    public static class ExpandedFunctionCall {
        private final Map<String, TypeSystem.Value> mPropertiesMap;
        private final TypeSystem.Value mPushAfterEvaluate;

        private ExpandedFunctionCall(Map<String, TypeSystem.Value> var1, TypeSystem.Value var2) {
            this.mPropertiesMap = var1;
            this.mPushAfterEvaluate = var2;
        }

        // $FF: synthetic method
        ExpandedFunctionCall(Map var1, TypeSystem.Value var2, Object var3) {
            this(var1, var2);
        }

        public static ResourceUtil.ExpandedFunctionCallBuilder newBuilder() {
            return new ResourceUtil.ExpandedFunctionCallBuilder();
        }

        public Map<String, TypeSystem.Value> getProperties() {
            return Collections.unmodifiableMap(this.mPropertiesMap);
        }

        public TypeSystem.Value getPushAfterEvaluate() {
            return this.mPushAfterEvaluate;
        }

        public String toString() {
            return "Properties: " + this.getProperties() + " pushAfterEvaluate: " + this.mPushAfterEvaluate;
        }

        public void updateCacheableProperty(String var1, TypeSystem.Value var2) {
            this.mPropertiesMap.put(var1, var2);
        }
    }

    public static class ExpandedFunctionCallBuilder {
        private final Map<String, TypeSystem.Value> mPropertiesMap;
        private TypeSystem.Value mPushAfterEvaluate;

        private ExpandedFunctionCallBuilder() {
            this.mPropertiesMap = new HashMap();
        }

        // $FF: synthetic method
        ExpandedFunctionCallBuilder(Object var1) {
            this();
        }

        public ResourceUtil.ExpandedFunctionCallBuilder addProperty(String var1, TypeSystem.Value var2) {
            this.mPropertiesMap.put(var1, var2);
            return this;
        }

        public ResourceUtil.ExpandedFunctionCall build() {
            return new ResourceUtil.ExpandedFunctionCall(this.mPropertiesMap, this.mPushAfterEvaluate);
        }

        public ResourceUtil.ExpandedFunctionCallBuilder setPushAfterEvaluate(TypeSystem.Value var1) {
            this.mPushAfterEvaluate = var1;
            return this;
        }
    }

    public static class ExpandedResource {
        private final Map<String, List<ResourceUtil.ExpandedFunctionCall>> mMacros;
        private final int mResourceFormatVersion;
        private final List<ResourceUtil.ExpandedRule> mRules;
        private final String mVersion;

        private ExpandedResource(List<ResourceUtil.ExpandedRule> var1, Map<String, List<ResourceUtil.ExpandedFunctionCall>> var2, String var3, int var4) {
            this.mRules = Collections.unmodifiableList(var1);
            this.mMacros = Collections.unmodifiableMap(var2);
            this.mVersion = var3;
            this.mResourceFormatVersion = var4;
        }

        // $FF: synthetic method
        ExpandedResource(List var1, Map var2, String var3, int var4, Object var5) {
            this(var1, var2, var3, var4);
        }

        public static ResourceUtil.ExpandedResourceBuilder newBuilder() {
            return new ResourceUtil.ExpandedResourceBuilder();
        }

        public Map<String, List<ResourceUtil.ExpandedFunctionCall>> getAllMacros() {
            return this.mMacros;
        }

        public List<ResourceUtil.ExpandedFunctionCall> getMacros(String var1) {
            return (List)this.mMacros.get(var1);
        }

        public int getResourceFormatVersion() {
            return this.mResourceFormatVersion;
        }

        public List<ResourceUtil.ExpandedRule> getRules() {
            return this.mRules;
        }

        public String getVersion() {
            return this.mVersion;
        }

        public String toString() {
            return "Rules: " + this.getRules() + "  Macros: " + this.mMacros;
        }
    }

    public static class ExpandedResourceBuilder {
        private final Map<String, List<ResourceUtil.ExpandedFunctionCall>> mMacros;
        private int mResourceFormatVersion;
        private final List<ResourceUtil.ExpandedRule> mRules;
        private String mVersion;

        private ExpandedResourceBuilder() {
            this.mRules = new ArrayList();
            this.mMacros = new HashMap();
            this.mVersion = "";
            this.mResourceFormatVersion = 0;
        }

        // $FF: synthetic method
        ExpandedResourceBuilder(Object var1) {
            this();
        }

        public ResourceUtil.ExpandedResourceBuilder addMacro(ResourceUtil.ExpandedFunctionCall var1) {
            String var2 = Types.valueToString((TypeSystem.Value)var1.getProperties().get(Key.INSTANCE_NAME.toString()));
            Object var3 = (List)this.mMacros.get(var2);
            if(var3 == null) {
                var3 = new ArrayList();
                this.mMacros.put(var2, var3);
            }

            ((List)var3).add(var1);
            return this;
        }

        public ResourceUtil.ExpandedResourceBuilder addRule(ResourceUtil.ExpandedRule var1) {
            this.mRules.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedResource build() {
            return new ResourceUtil.ExpandedResource(this.mRules, this.mMacros, this.mVersion, this.mResourceFormatVersion);
        }

        public ResourceUtil.ExpandedResourceBuilder setResourceFormatVersion(int var1) {
            this.mResourceFormatVersion = var1;
            return this;
        }

        public ResourceUtil.ExpandedResourceBuilder setVersion(String var1) {
            this.mVersion = var1;
            return this;
        }
    }

    public static class ExpandedRule {
        private final List<String> mAddMacroRuleNames;
        private final List<ResourceUtil.ExpandedFunctionCall> mAddMacros;
        private final List<String> mAddTagRuleNames;
        private final List<ResourceUtil.ExpandedFunctionCall> mAddTags;
        private final List<ResourceUtil.ExpandedFunctionCall> mNegativePredicates;
        private final List<ResourceUtil.ExpandedFunctionCall> mPositivePredicates;
        private final List<String> mRemoveMacroRuleNames;
        private final List<ResourceUtil.ExpandedFunctionCall> mRemoveMacros;
        private final List<String> mRemoveTagRuleNames;
        private final List<ResourceUtil.ExpandedFunctionCall> mRemoveTags;

        private ExpandedRule(List<ResourceUtil.ExpandedFunctionCall> var1, List<ResourceUtil.ExpandedFunctionCall> var2, List<ResourceUtil.ExpandedFunctionCall> var3, List<ResourceUtil.ExpandedFunctionCall> var4, List<ResourceUtil.ExpandedFunctionCall> var5, List<ResourceUtil.ExpandedFunctionCall> var6, List<String> var7, List<String> var8, List<String> var9, List<String> var10) {
            this.mPositivePredicates = Collections.unmodifiableList(var1);
            this.mNegativePredicates = Collections.unmodifiableList(var2);
            this.mAddTags = Collections.unmodifiableList(var3);
            this.mRemoveTags = Collections.unmodifiableList(var4);
            this.mAddMacros = Collections.unmodifiableList(var5);
            this.mRemoveMacros = Collections.unmodifiableList(var6);
            this.mAddMacroRuleNames = Collections.unmodifiableList(var7);
            this.mRemoveMacroRuleNames = Collections.unmodifiableList(var8);
            this.mAddTagRuleNames = Collections.unmodifiableList(var9);
            this.mRemoveTagRuleNames = Collections.unmodifiableList(var10);
        }

        // $FF: synthetic method
        ExpandedRule(List var1, List var2, List var3, List var4, List var5, List var6, List var7, List var8, List var9, List var10, Object var11) {
            this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
        }

        public static ResourceUtil.ExpandedRuleBuilder newBuilder() {
            return new ResourceUtil.ExpandedRuleBuilder();
        }

        public List<String> getAddMacroRuleNames() {
            return this.mAddMacroRuleNames;
        }

        public List<ResourceUtil.ExpandedFunctionCall> getAddMacros() {
            return this.mAddMacros;
        }

        public List<String> getAddTagRuleNames() {
            return this.mAddTagRuleNames;
        }

        public List<ResourceUtil.ExpandedFunctionCall> getAddTags() {
            return this.mAddTags;
        }

        public List<ResourceUtil.ExpandedFunctionCall> getNegativePredicates() {
            return this.mNegativePredicates;
        }

        public List<ResourceUtil.ExpandedFunctionCall> getPositivePredicates() {
            return this.mPositivePredicates;
        }

        public List<String> getRemoveMacroRuleNames() {
            return this.mRemoveMacroRuleNames;
        }

        public List<ResourceUtil.ExpandedFunctionCall> getRemoveMacros() {
            return this.mRemoveMacros;
        }

        public List<String> getRemoveTagRuleNames() {
            return this.mRemoveTagRuleNames;
        }

        public List<ResourceUtil.ExpandedFunctionCall> getRemoveTags() {
            return this.mRemoveTags;
        }

        public String toString() {
            return "Positive predicates: " + this.getPositivePredicates() + "  Negative predicates: " + this.getNegativePredicates() + "  Add tags: " + this.getAddTags() + "  Remove tags: " + this.getRemoveTags() + "  Add macros: " + this.getAddMacros() + "  Remove macros: " + this.getRemoveMacros();
        }
    }

    public static class ExpandedRuleBuilder {
        private final List<String> mAddMacroRuleNames;
        private final List<ResourceUtil.ExpandedFunctionCall> mAddMacros;
        private final List<String> mAddTagRuleNames;
        private final List<ResourceUtil.ExpandedFunctionCall> mAddTags;
        private final List<ResourceUtil.ExpandedFunctionCall> mNegativePredicates;
        private final List<ResourceUtil.ExpandedFunctionCall> mPositivePredicates;
        private final List<String> mRemoveMacroRuleNames;
        private final List<ResourceUtil.ExpandedFunctionCall> mRemoveMacros;
        private final List<String> mRemoveTagRuleNames;
        private final List<ResourceUtil.ExpandedFunctionCall> mRemoveTags;

        private ExpandedRuleBuilder() {
            this.mPositivePredicates = new ArrayList();
            this.mNegativePredicates = new ArrayList();
            this.mAddTags = new ArrayList();
            this.mRemoveTags = new ArrayList();
            this.mAddMacros = new ArrayList();
            this.mRemoveMacros = new ArrayList();
            this.mAddMacroRuleNames = new ArrayList();
            this.mRemoveMacroRuleNames = new ArrayList();
            this.mAddTagRuleNames = new ArrayList();
            this.mRemoveTagRuleNames = new ArrayList();
        }

        // $FF: synthetic method
        ExpandedRuleBuilder(Object var1) {
            this();
        }

        public ResourceUtil.ExpandedRuleBuilder addAddMacro(ResourceUtil.ExpandedFunctionCall var1) {
            this.mAddMacros.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRuleBuilder addAddMacroRuleName(String var1) {
            this.mAddMacroRuleNames.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRuleBuilder addAddTag(ResourceUtil.ExpandedFunctionCall var1) {
            this.mAddTags.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRuleBuilder addAddTagRuleName(String var1) {
            this.mAddTagRuleNames.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRuleBuilder addNegativePredicate(ResourceUtil.ExpandedFunctionCall var1) {
            this.mNegativePredicates.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRuleBuilder addPositivePredicate(ResourceUtil.ExpandedFunctionCall var1) {
            this.mPositivePredicates.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRuleBuilder addRemoveMacro(ResourceUtil.ExpandedFunctionCall var1) {
            this.mRemoveMacros.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRuleBuilder addRemoveMacroRuleName(String var1) {
            this.mRemoveMacroRuleNames.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRuleBuilder addRemoveTag(ResourceUtil.ExpandedFunctionCall var1) {
            this.mRemoveTags.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRuleBuilder addRemoveTagRuleName(String var1) {
            this.mRemoveTagRuleNames.add(var1);
            return this;
        }

        public ResourceUtil.ExpandedRule build() {
            return new ResourceUtil.ExpandedRule(this.mPositivePredicates, this.mNegativePredicates, this.mAddTags, this.mRemoveTags, this.mAddMacros, this.mRemoveMacros, this.mAddMacroRuleNames, this.mRemoveMacroRuleNames, this.mAddTagRuleNames, this.mRemoveTagRuleNames);
        }
    }

    public static class InvalidResourceException extends Exception {
        public InvalidResourceException(String var1) {
            super(var1);
        }
    }
}
