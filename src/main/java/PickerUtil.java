import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by aphexTinez on 9/24/16.
 *
 * PickerUtil is a class of basic utility helper functions for plant selection based on inputs.
 *
 */
public class PickerUtil {

    /**
     * Returns a List of Plants that satisfy the Predicate of their climate range including a temperature range passed in (min - max)
     *
     * @param plants list of plants passed in to filter
     * @param min the minimum temperature that needs to be tolerated by the plant in order to qualify
     * @param max the maximum temperature that needs to be tolerated by the plant in order to qualify
     * @return the list of plants that have qualified as being able to tolerate the temperature range passed in
     */
    public static List<Plant> getPlantsInTempRange(List<Plant> plants, int min, int max) {
        return filterPlantListWithPredicate(plants, isPlantInClimateRange(min,max));
    }

    /**
     * Returns a List of Plants that satisfy the Predicate of being in the GrowthCategory, category.
     * The predicate is set based on the GrowthCategory, category.
     * If the predicate is not set that means that an invalid category was passed in and an error is thrown.
     *
     * @param plants list of plants passed in to filter
     * @param category the category of growth speed that is desired to filter for
     * @return the list of plants that have qualified as being in the desired growth speed category
     */
    public static List<Plant> getPlantsInGrowthCategory(List<Plant> plants, PlantConstants.GrowthCategory category) {
        Predicate p = null;
        switch(category) {
            case SLOW:
                p = isSlowGrowthRate();
                break;
            case MEDIUM:
                p = isMediumGrowthRate();
                break;
            case FAST:
                p = isFastGrowthRate();
                break;
            default:
                throw new IllegalArgumentException("Invalid GrowthCategory!");
        }

        List<Plant> trimmedPlantList = filterPlantListWithPredicate(plants,p);
        return trimmedPlantList;
    }

    /**
     * Returns a List of Plants that satisfy the Predicate, p.
     *
     * @param plants the list of plants to filter
     * @param p the Predicate against which to filter the list of plants
     * @return the list of plants that satisfy the Predicate p
     */
    public static List<Plant> filterPlantListWithPredicate(List<Plant> plants, Predicate<Plant> p) {
        return plants.stream().filter(p).collect(Collectors.toList());
    }

    /**
     *  Returns the total number of upvotes a Plant has received in the plant genie community in the categories
     *  of interest
     *
     *  @param plantVoteMap is Map for the Plant of interest where key is the category of upvotes, and int value is the
     *  the number of upvotes the plant received for that category
     *  @param categories is a List of UpvoteCategories that have been selected for consideration
     *  @return the number of total upvotes from the categories of interest
     */
    public static int getTotalUpvotes(Map<UpvoteCategory,Integer> plantVoteMap, List<UpvoteCategory> categories) {
        //from categories List of UpvoteCategories to consider, get IntStream of upvoteCount from plantVoteMap
        // and then get total sum over that IntStream to return
        return categories.stream()
                .mapToInt(plantVoteMap::get)
                .sum();
    }

    /**
     * Predicate to check that a plant's minimum tolerable temperature is at least the minimum temperature in the desired range,
     * and that the plant's maximum tolerable temperature is at least the maximum temperature in the desired range, to see that
     * the plant could survive in the temperature range passed in.
     *
     * @param min lowest temperature the plant needs to be able to tolerate
     * @param max highest temperature the plant needs to be able to tolerate
     * @return true if the required temperature range falls within the temperature range of a plant, false if it does not
     */
    private static Predicate<Plant> isPlantInClimateRange(int min, int max) {
        return p -> p.getMinTemp() <= min && p.getMaxTemp() >= max;
    }

    /**
     * Predicate to check if a plant's growth category is slow
     *
     * @return true if the plant's growth rate falls in the category of a slow growth rate, false if it is not
     */
    private static Predicate<Plant> isSlowGrowthRate() {
        return p -> p.getHealthyGrowthRate() <= PlantConstants.SLOW_TO_MEDIUM_GROWTH_BOUNDARY;
    }

    /**
     * Predicate to check if a plant's growth rate is medium
     *
     * @return true if the plant's growth rate falls in the category of a medium growth rate, false if it does not
     */
    private static Predicate<Plant> isMediumGrowthRate() {
        return p -> p.getHealthyGrowthRate() > PlantConstants.SLOW_TO_MEDIUM_GROWTH_BOUNDARY
                && p.getHealthyGrowthRate() <= PlantConstants.MEDIUM_TO_FAST_GROWTH_BOUNDARY;
    }

    /**
     * Predicate to check if a plant's growth rate is fast
     *
     * @return true if the plant's growth rate falls in the category of a fast growth rate, false if it does not
     */
    private static Predicate<Plant> isFastGrowthRate() {
        return p -> p.getHealthyGrowthRate() > PlantConstants.MEDIUM_TO_FAST_GROWTH_BOUNDARY;
    }

}
