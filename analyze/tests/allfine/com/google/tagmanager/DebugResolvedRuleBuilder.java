package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.ArrayUtils;
import com.google.tagmanager.DebugResolvedFunctionCallBuilder;
import com.google.tagmanager.DebugValueBuilder;
import com.google.tagmanager.Log;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.ResolvedFunctionCallTranslatorList;
import com.google.tagmanager.ResolvedRuleBuilder;
import com.google.tagmanager.ResourceUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

class DebugResolvedRuleBuilder implements ResolvedRuleBuilder {
    ResolvedFunctionCallTranslatorList addMacrosHolder;
    ResolvedFunctionCallTranslatorList addTagsHolder;
    ResolvedFunctionCallTranslatorList removeMacrosHolder;
    ResolvedFunctionCallTranslatorList removeTagsHolder;
    Debug.ResolvedRule resolvedRule;

    public DebugResolvedRuleBuilder(Debug.ResolvedRule var1) {
        this.resolvedRule = var1;
        this.addMacrosHolder = new DebugResolvedRuleBuilder.DebugResolvedFunctionCallListTranslator(1);
        this.removeMacrosHolder = new DebugResolvedRuleBuilder.DebugResolvedFunctionCallListTranslator(2);
        this.addTagsHolder = new DebugResolvedRuleBuilder.DebugResolvedFunctionCallListTranslator(3);
        this.removeTagsHolder = new DebugResolvedRuleBuilder.DebugResolvedFunctionCallListTranslator(4);
    }

    public static Debug.ResolvedFunctionCall translateExpandedFunctionCall(ResourceUtil.ExpandedFunctionCall var0) {
        Debug.ResolvedFunctionCall var1 = new Debug.ResolvedFunctionCall();

        Debug.ResolvedProperty var4;
        for(Iterator var2 = var0.getProperties().entrySet().iterator(); var2.hasNext(); var1.properties = ArrayUtils.appendToArray(var1.properties, var4)) {
            Entry var3 = (Entry)var2.next();
            var4 = new Debug.ResolvedProperty();
            var4.key = (String)var3.getKey();
            var4.value = DebugValueBuilder.copyImmutableValue((TypeSystem.Value)var3.getValue());
        }

        return var1;
    }

    public ResolvedFunctionCallBuilder createNegativePredicate() {
        Debug.ResolvedFunctionCall var1 = new Debug.ResolvedFunctionCall();
        this.resolvedRule.negativePredicates = ArrayUtils.appendToArray(this.resolvedRule.negativePredicates, var1);
        return new DebugResolvedFunctionCallBuilder(var1);
    }

    public ResolvedFunctionCallBuilder createPositivePredicate() {
        Debug.ResolvedFunctionCall var1 = new Debug.ResolvedFunctionCall();
        this.resolvedRule.positivePredicates = ArrayUtils.appendToArray(this.resolvedRule.positivePredicates, var1);
        return new DebugResolvedFunctionCallBuilder(var1);
    }

    public ResolvedFunctionCallTranslatorList getAddedMacroFunctions() {
        return this.addMacrosHolder;
    }

    public ResolvedFunctionCallTranslatorList getAddedTagFunctions() {
        return this.addTagsHolder;
    }

    public ResolvedFunctionCallTranslatorList getRemovedMacroFunctions() {
        return this.removeMacrosHolder;
    }

    public ResolvedFunctionCallTranslatorList getRemovedTagFunctions() {
        return this.removeTagsHolder;
    }

    public void setValue(TypeSystem.Value var1) {
        this.resolvedRule.result = DebugValueBuilder.copyImmutableValue(var1);
    }

    class DebugResolvedFunctionCallListTranslator implements ResolvedFunctionCallTranslatorList {
        private final int type;

        DebugResolvedFunctionCallListTranslator(int var2) {
            this.type = var2;
        }

        public void translateAndAddAll(List<ResourceUtil.ExpandedFunctionCall> var1, List<String> var2) {
            ArrayList var3 = new ArrayList(var1.size());

            for(int var4 = 0; var4 < var1.size(); ++var4) {
                var3.add(DebugResolvedRuleBuilder.translateExpandedFunctionCall((ResourceUtil.ExpandedFunctionCall)var1.get(var4)));
                if(var4 < var2.size()) {
                    ((Debug.ResolvedFunctionCall)var3.get(var4)).associatedRuleName = (String)var2.get(var4);
                } else {
                    ((Debug.ResolvedFunctionCall)var3.get(var4)).associatedRuleName = "Unknown";
                }
            }

            Debug.ResolvedFunctionCall[] var5 = (Debug.ResolvedFunctionCall[])var3.toArray(new Debug.ResolvedFunctionCall[0]);
            switch(this.type) {
                case 1:
                    DebugResolvedRuleBuilder.this.resolvedRule.addMacros = var5;
                    return;
                case 2:
                    DebugResolvedRuleBuilder.this.resolvedRule.removeMacros = var5;
                    return;
                case 3:
                    DebugResolvedRuleBuilder.this.resolvedRule.addTags = var5;
                    return;
                case 4:
                    DebugResolvedRuleBuilder.this.resolvedRule.removeTags = var5;
                    return;
                default:
                    Log.method_5503("unknown type in translateAndAddAll: " + this.type);
            }
        }
    }

    class Type {
        static final int ADD_MACROS = 1;
        static final int ADD_TAGS = 3;
        static final int REMOVE_MACROS = 2;
        static final int REMOVE_TAGS = 4;
    }
}
