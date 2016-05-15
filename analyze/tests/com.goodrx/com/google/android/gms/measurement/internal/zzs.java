package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.zzpz;

class zzs {
   final boolean zzaWY;
   final int zzaWZ;
   long zzaXa;
   float zzaXb;
   long zzaXc;
   float zzaXd;
   long zzaXe;
   float zzaXf;
   final boolean zzaXg;

   public zzs(zzpz.zzd var1) {
      boolean var2 = true;
      super();
      com.google.android.gms.common.internal.zzx.zzz(var1);
      boolean var4;
      if(var1.zzaZF != null && var1.zzaZF.intValue() != 0) {
         label55: {
            if(var1.zzaZF.intValue() != 4) {
               if(var1.zzaZH == null) {
                  var4 = false;
                  break label55;
               }
            } else if(var1.zzaZI == null || var1.zzaZJ == null) {
               var4 = false;
               break label55;
            }

            var4 = var2;
         }
      } else {
         var4 = false;
      }

      if(var4) {
         this.zzaWZ = var1.zzaZF.intValue();
         if(var1.zzaZG == null || !var1.zzaZG.booleanValue()) {
            var2 = false;
         }

         this.zzaWY = var2;
         if(var1.zzaZF.intValue() == 4) {
            if(this.zzaWY) {
               this.zzaXd = Float.parseFloat(var1.zzaZI);
               this.zzaXf = Float.parseFloat(var1.zzaZJ);
            } else {
               this.zzaXc = Long.parseLong(var1.zzaZI);
               this.zzaXe = Long.parseLong(var1.zzaZJ);
            }
         } else if(this.zzaWY) {
            this.zzaXb = Float.parseFloat(var1.zzaZH);
         } else {
            this.zzaXa = Long.parseLong(var1.zzaZH);
         }
      } else {
         this.zzaWZ = 0;
         this.zzaWY = false;
      }

      this.zzaXg = var4;
   }

   public Boolean zzac(long var1) {
      boolean var3 = true;
      if(!this.zzaXg) {
         return null;
      } else if(this.zzaWY) {
         return null;
      } else {
         switch(this.zzaWZ) {
         case 1:
            if(var1 >= this.zzaXa) {
               var3 = false;
            }

            return Boolean.valueOf(var3);
         case 2:
            if(var1 <= this.zzaXa) {
               var3 = false;
            }

            return Boolean.valueOf(var3);
         case 3:
            if(var1 != this.zzaXa) {
               var3 = false;
            }

            return Boolean.valueOf(var3);
         case 4:
            if(var1 < this.zzaXc || var1 > this.zzaXe) {
               var3 = false;
            }

            return Boolean.valueOf(var3);
         default:
            return null;
         }
      }
   }

   public Boolean zzi(float var1) {
      boolean var2 = true;
      if(!this.zzaXg) {
         return null;
      } else if(!this.zzaWY) {
         return null;
      } else {
         switch(this.zzaWZ) {
         case 1:
            if(var1 >= this.zzaXb) {
               var2 = false;
            }

            return Boolean.valueOf(var2);
         case 2:
            if(var1 <= this.zzaXb) {
               var2 = false;
            }

            return Boolean.valueOf(var2);
         case 3:
            boolean var3;
            if(var1 != this.zzaXb) {
               float var5;
               int var4 = (var5 = Math.abs(var1 - this.zzaXb) - 2.0F * Math.max(Math.ulp(var1), Math.ulp(this.zzaXb))) == 0.0F?0:(var5 < 0.0F?-1:1);
               var3 = false;
               if(var4 >= 0) {
                  return Boolean.valueOf(var3);
               }
            }

            var3 = var2;
            return Boolean.valueOf(var3);
         case 4:
            if(var1 < this.zzaXd || var1 > this.zzaXf) {
               var2 = false;
            }

            return Boolean.valueOf(var2);
         default:
            return null;
         }
      }
   }
}
