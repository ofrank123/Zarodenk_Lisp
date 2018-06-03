package eval;

/**********************
 * public class DefFunction
 * default function class to be included in the evaler's
 * HashMap.
 * 
 * @author Oliver Frank
 **********************/
public abstract class DefFunction {

    /************************
     * public runFunc
     * performs the functions' operation
     * on the list of args, return value is
     * a String, and will be null if the
     * function is void
     * 
     * @author Oliver Frank
     ************************/
    public String runFunc(String[] args);
}
