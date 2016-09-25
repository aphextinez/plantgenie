import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by aphexTinez on 9/24/16.
 */

public class PickerUtilTest {

    @Test
    public void getTotalUpvotesTest() {

        Map<UpvoteCategory,Integer> voteMap = new HashMap<UpvoteCategory,Integer>();
        voteMap.put(UpvoteCategory.DISEASE_RESISTANCE, 700);
        voteMap.put(UpvoteCategory.PESK_RESISTANCE, 500);
        voteMap.put(UpvoteCategory.OVERALL_EASE, 800);

        ArrayList<UpvoteCategory> categories = new ArrayList<UpvoteCategory>();
        categories.add(UpvoteCategory.DISEASE_RESISTANCE);
        categories.add(UpvoteCategory.OVERALL_EASE);

        int ret = PickerUtil.getTotalUpvotes(voteMap,categories,3);
        Assert.assertEquals(1500,ret);

        categories.add(UpvoteCategory.PESK_RESISTANCE);
        ret = PickerUtil.getTotalUpvotes(voteMap,categories,3);
        Assert.assertEquals(2000,ret);
    }

}
