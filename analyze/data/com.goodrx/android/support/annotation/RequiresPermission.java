package android.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
public @interface RequiresPermission {
   String[] allOf() default {};

   String[] anyOf() default {};

   boolean conditional() default false;

   String value() default "";

   @Target({ElementType.FIELD})
   public @interface Read {
      RequiresPermission value();
   }

   @Target({ElementType.FIELD})
   public @interface Write {
      RequiresPermission value();
   }
}
