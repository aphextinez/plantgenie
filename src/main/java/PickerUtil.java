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
        else {
            //from categories List of UpvoteCategories to consider, get IntStream of upvoteCount from plantVoteMap
            // and then get total sum over that IntStream to return
            return categories.stream().mapToInt(plantVoteMap::get).sum();
        }
    }


}
