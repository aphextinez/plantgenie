import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.Assert;

/**
 *
 * Test class to test the functionality of the PickerUtil
 *
 * Created by aphexTinez on 9/24/16.
 */

public class PickerUtilTest {

    @Test
    public void getTotalUpvotesTest() {

        Map<UpvoteCategory,Integer> voteMap = new HashMap<>();
        voteMap.put(UpvoteCategory.DISEASE_RESISTANCE, 700);
        voteMap.put(UpvoteCategory.PESK_RESISTANCE, 500);
        voteMap.put(UpvoteCategory.OVERALL_EASE, 800);

        ArrayList<UpvoteCategory> categories = new ArrayList<>();
        categories.add(UpvoteCategory.DISEASE_RESISTANCE);
        categories.add(UpvoteCategory.OVERALL_EASE);

        int ret = PickerUtil.getTotalUpvotes(voteMap,categories);
        Assert.assertEquals(1500,ret);

        categories.add(UpvoteCategory.PESK_RESISTANCE);
        ret = PickerUtil.getTotalUpvotes(voteMap,categories);
        Assert.assertEquals(2000,ret);
    }

    @Test
    public void getPlantsInGrowthCategoryTest() {
        Plant plant1 = new Plant("fern");
        plant1.setHealthyGrowthRate(30);
        Plant plant2 = new Plant("bamboo");
        plant2.setHealthyGrowthRate(5);
        Plant plant3 = new Plant("maple");
        plant3.setHealthyGrowthRate(120);
        List<Plant> testPlants = new ArrayList<>();
        testPlants.add(plant1);
        testPlants.add(plant2);
        testPlants.add(plant3);
        List<Plant> retPlants = PickerUtil.getPlantsInGrowthCategory(testPlants, PlantConstants.GrowthCategory.SLOW);
        Assert.assertEquals(plant2, retPlants.get(0));
        retPlants = PickerUtil.getPlantsInGrowthCategory(testPlants, PlantConstants.GrowthCategory.MEDIUM);
        Assert.assertEquals(plant1, retPlants.get(0));
        retPlants = PickerUtil.getPlantsInGrowthCategory(testPlants, PlantConstants.GrowthCategory.FAST);
        Assert.assertEquals(plant3, retPlants.get(0));
    }

    @Test
    public void getPlantsInTempRageTest() {
        Plant plant1 = new Plant("fern");
        plant1.setMaxTemp(100);
        plant1.setMinTemp(50);
        Plant plant2 = new Plant("banana tree");
        plant2.setMaxTemp(120);
        plant2.setMinTemp(80);
        Plant plant3 = new Plant("wheat");
        plant3.setMaxTemp(120);
        plant3.setMinTemp(49);
        List<Plant> testPlants = new ArrayList<>();
        testPlants.add(plant1);
        testPlants.add(plant2);
        testPlants.add(plant3);
        List<Plant> retPlants = PickerUtil.getPlantsInTempRange(testPlants,50, 120);
        Assert.assertEquals(plant3, retPlants.get(0));

    }


}
