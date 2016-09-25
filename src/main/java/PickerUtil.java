import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by aphexTinez on 9/24/16.
 */
public class PickerUtil {


  /*  public static List<String> getPlantsInTempRange(List<Plant> plants, int min, int max) {
        return plants.stream()
                .filter(isPlantInClimateRange(min,max))
                .collect(Collectors.toList());
    }*/

    public static ArrayList<Plant> getPlantsInGrowthCategory(List<Plant> plants, PlantConstants.GrowthCategory category) {
        Predicate p = null;
        if (category == PlantConstants.GrowthCategory.FAST) {
            p = isFastGrowthRate();
        }
        else if (category == PlantConstants.GrowthCategory.MEDIUM) {
            p = isMediumGrowthRate();
        }
        else if (category == PlantConstants.GrowthCategory.SLOW) {
            p = isSlowGrowthRate();
        }
        else {
            //TODO ERROR on not being in valid growth category
        }
        ArrayList<Plant> trimmedPlantList = filterPlantListWithPredicate(plants,p);
        return trimmedPlantList;
    }

    public static ArrayList<Plant> filterPlantListWithPredicate(List<Plant> plants, Predicate<Plant> p) {
        ArrayList<Plant> trimmedPlantList = (ArrayList<Plant>)plants.stream().filter(p).collect(Collectors.toList());
        return trimmedPlantList;
    }

    /*
    -plantVoteMap is Map for the plant of interest where key is String of the category for upvoting, and int value is the
    the number of upvotes the plant received for that category
    -categories is a List of UpvoteCategories that have been selected for consideration
    -totalCategories is an int count of the number of UpvoteCategories that have been selected for consideration
 */
    public static int getTotalUpvotes(Map<UpvoteCategory,Integer> plantVoteMap, List<UpvoteCategory> categories) {
        //from categories List of UpvoteCategories to consider, get IntStream of upvoteCount from plantVoteMap
        // and then get total sum over that IntStream to return
        return categories.stream()
                .mapToInt(plantVoteMap::get)
                .sum();
    }

    private static Predicate<Plant> isPlantInClimateRange(int min, int max) {
        return p -> p.getMinTemp() >= min && p.getMaxTemp() <= max;
    }

    private static Predicate<Plant> isSlowGrowthRate() {
        return p -> p.getHealthyGrowthRate() <= PlantConstants.SLOW_TO_MEDIUM_GROWTH_BOUNDARY;
    }

    private static Predicate<Plant> isMediumGrowthRate() {
        return p -> p.getHealthyGrowthRate() > PlantConstants.SLOW_TO_MEDIUM_GROWTH_BOUNDARY
                && p.getHealthyGrowthRate() <= PlantConstants.MEDIUM_TO_FAST_GROWTH_BOUNDARY;
    }

    private static Predicate<Plant> isFastGrowthRate() {
        return p -> p.getHealthyGrowthRate() > PlantConstants.MEDIUM_TO_FAST_GROWTH_BOUNDARY;
    }

}
