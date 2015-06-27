package home.api.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created by alex on 6/27/2015.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({PARAMETER, FIELD})
public @interface SetUsernameEvent {
}
