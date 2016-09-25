/**
 * Created by aphexTinez on 9/24/16.
 *
 * PlantConstants is a class of constants that can be associated with Plants and their attributes and would likely be referenced.
 *
 */
public class PlantConstants {
    public static final int SLOW_TO_MEDIUM_GROWTH_BOUNDARY = 20;   //growth rate in cm/month. maximum boundary for slow growth rate, minimum boundary for medium growth rate
    public static final int MEDIUM_TO_FAST_GROWTH_BOUNDARY = 100;  //growth rate in cm/month. maximum boundary for medium growth rate, minimum boundary for fast growth rate.
    public enum GrowthCategory {SLOW,MEDIUM,FAST};
}
