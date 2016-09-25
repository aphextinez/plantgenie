import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by aphexTinez on 9/24/16.
 */
public class PickerUtil {





    /*
        -plantVoteMap is Map for the plant of interest where key is String of the category for upvoting, and int value is the
        the number of upvotes the plant received for that category
        -categories is a List of UpvoteCategories that have been selected for consideration
        -totalCategories is an int count of the number of UpvoteCategories that have been selected for consideration
     */
    public static int getTotalUpvotes(Map<UpvoteCategory,Integer> plantVoteMap, List<UpvoteCategory> categories, int totalCategories) {
        //if every category option available has been selected return the sum total of votes for all categories
        if (categories.size() == totalCategories) {
            return plantVoteMap.values().stream().mapToInt(n -> n).sum();
        }
        //otherwise return sum total of votes for categories that are present in categories List
        else {
            return plantVoteMap.entrySet()
                    .stream()
                    .filter(n -> categories.contains(n.getKey()))   //filter to Stream containing category/votes where category key is present in categories List
                    .mapToInt(n -> n.getValue())   //map each category's number of votes value to IntStream
                    .sum();   //get sum over IntStream
        }
    }
}
