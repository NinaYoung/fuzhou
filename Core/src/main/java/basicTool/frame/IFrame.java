package basicTool.frame;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A annotation that describes the frame represented by the page object.
 * <p>
 * Any Toolkit Page Object that is annotated with the @IFrame class-level annotation, or whose parent is annotated with
 * such an annotation is a Frame Page Object. The @IFrame annotation has a mandatory parameter, name, that specifies the
 * name of the frame where the elements defined on the current page reside. If a frame resides inside another frame
 * provide the dotted notation as the frame name, which includes the name of every containing frame starting from the
 * root context. For example, the 'broadcast' frame resides inside the 'contents' frame which resides in the root
 * context, so the frame name in this case would be 'contents.broadcast'.
 * <p>
 * For example:
 * 
 * <pre>
 * &#64;IFrame(name="contents.broadcast")
 * public class FramePage extends MyAppWebPage {
 *  
 *  ... // Rest of class declaration
 * }
 * </pre>
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
public @interface IFrame {
    /**
     * @return the name of the frame.
     */
    String id() default FrameNavigator.NO_SUCH_FRAME;

    String name() default FrameNavigator.NO_SUCH_FRAME;

    String cssLocator() default FrameNavigator.NO_SUCH_FRAME;
}
