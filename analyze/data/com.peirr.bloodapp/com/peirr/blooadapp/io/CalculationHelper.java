package com.peirr.blooadapp.io;

import android.text.TextUtils;
import android.util.Log;
import com.peirr.blooadapp.io.PreBypassCalculation;
import java.util.Map;

public class CalculationHelper {
   public static PreBypassCalculation calculate(Map<String, String> var0) {
      PreBypassCalculation var1 = new PreBypassCalculation();
      boolean var2;
      if(Integer.valueOf((String)var0.get("cardiac")).intValue() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      var1.cardiac = var2;
      float var3;
      if(TextUtils.isEmpty((CharSequence)var0.get("required_hb"))) {
         var3 = 0.0F;
      } else {
         var3 = Float.valueOf((String)var0.get("required_hb")).floatValue();
      }

      var1.requiredHb = var3;
      float var4;
      if(TextUtils.isEmpty((CharSequence)var0.get("rbc_required"))) {
         var4 = 0.0F;
      } else {
         var4 = Float.valueOf((String)var0.get("rbc_required")).floatValue();
      }

      var1.rbc = var4;
      if(!var1.cardiac) {
         var1.preOpHb = Float.valueOf((String)var0.get("preop_lab_level")).floatValue();
         var1.expectedLoss = Float.valueOf((String)var0.get("first_pass_removed")).floatValue();
      }

      var1.age = Integer.valueOf((String)var0.get("age")).intValue();
      var1.height = Float.valueOf((String)var0.get("height")).floatValue();
      var1.weight = Float.valueOf((String)var0.get("weight")).floatValue();
      boolean var5 = ((String)var0.get("gender")).equals("0");
      Integer.valueOf((String)var0.get("cardiac")).intValue();
      float var7 = calculateBloodVolume(var1.height, var1.weight, var5);
      Log.i("[BLOOD VOLUME]", String.valueOf(var7));
      float var13;
      if(var1.cardiac) {
         var13 = calculateInitialHbOnPump(var7, Float.valueOf((String)var0.get("preop_lab_level")).floatValue(), Float.valueOf((String)var0.get("first_pass_removed")).floatValue(), Float.valueOf((String)var0.get("prime_volume")).floatValue(), Float.valueOf((String)var0.get("fluid_prebypass")).floatValue(), Float.valueOf((String)var0.get("urine_prebypass")).floatValue());
         var1.predictedHbOnPump = Float.valueOf(var13).floatValue();
      } else {
         float var9 = calculatePostOperativeHB(var1.preOpHb, var7, var1.expectedLoss);
         var1.predictedHbOnPump = Float.valueOf(var9).floatValue();
         Log.i("[Post HB]", String.valueOf(var9));
         float var11 = calculateNumberRBCtoAchieveSpecificPostOpHB(var1.requiredHb, var7, var9);
         var1.numberOfUnitsRBCNecessary = Float.valueOf(var11).floatValue();
         Log.i("[RBC Required]", String.valueOf(var11));
         var13 = 0.0F;
      }

      if(var1.requiredHb > 0.0F && var1.cardiac) {
         float var21 = calculateNumberOfUnitsRBCNecessary(var1.requiredHb, var7, Float.valueOf((String)var0.get("prime_volume")).floatValue(), Float.valueOf((String)var0.get("fluid_prebypass")).floatValue(), Float.valueOf((String)var0.get("urine_prebypass")).floatValue(), var1.predictedHbOnPump, Float.valueOf((String)var0.get("first_pass_removed")).floatValue());
         Log.i("[NUMBER OF NECESSARY RBC = ]", String.valueOf(var21));
         var1.numberOfUnitsRBCNecessary = var21;
      }

      if(var1.rbc > 0.0F) {
         float var14 = Float.valueOf((String)var0.get("first_pass_removed")).floatValue();
         float var15 = Float.valueOf((String)var0.get("prime_volume")).floatValue();
         float var16 = Float.valueOf((String)var0.get("fluid_prebypass")).floatValue();
         float var17 = Float.valueOf((String)var0.get("urine_prebypass")).floatValue();
         float var18 = var1.rbc;
         float var19 = calculatePredictedInitialHbOnPump(var13, var7, var14, var15, var16, var17, var18);
         Log.i("[PREDICTED INITIAL HB ON PUMP = ]", String.valueOf(var19));
         var1.predictedHbOnPump = var19;
      }

      var1.bloodvolume = var7;
      var1.actualPumpHb = Float.valueOf((String)var0.get("preop_lab_level")).floatValue();
      var1.operation = (String)var0.get("operation");
      return var1;
   }

   public static float calculateBloodVolume(float var0, float var1, boolean var2) {
      float var3;
      if(var2) {
         var3 = var0 * var0 * 0.3669F * var0 + 0.6014F + 0.03219F * var1;
      } else {
         var3 = 0.3561F * var0 * var0 * var0 + 0.1833F + 0.03308F * var1;
         if(var1 < 35.0F) {
            return 70.0F * var1 / 1000.0F;
         }
      }

      return var3;
   }

   public static float calculateInitialHbOnPump(float var0, float var1, float var2, float var3, float var4, float var5) {
      float var6 = var1 * (var0 - var2) / (var3 + var0 + var4 - var2 - var5);
      Log.i("[PREDICTED HB ON PUMP]", String.valueOf(var6));
      return var6;
   }

   public static float calculateNumberOfUnitsRBCNecessary(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      return 10.0F * ((var3 + var1 + var2 - var6 - var4) * (var0 - var5) / 1.0F / 50.0F);
   }

   public static float calculateNumberRBCtoAchieveSpecificPostOpHB(float var0, float var1, float var2) {
      return 10.0F * var1 * (var0 - var2) / 50.0F;
   }

   public static float calculatePostOperativeHB(float var0, float var1, float var2) {
      return var0 * (var1 - var2) / var1;
   }

   public static float calculatePredictedInitialHbOnPump(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      return var0 + 50.0F * var6 / (var4 + var1 + var3 - var2 - var5) / 10.0F;
   }
}
