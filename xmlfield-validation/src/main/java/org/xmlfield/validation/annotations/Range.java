package org.xmlfield.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD})
public @interface Range {

    double min() default 0;

    double max() default Double.MAX_VALUE;


}
