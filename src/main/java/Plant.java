/**
 * Created by aphexTinez on 9/24/16.
 *
 * Plant is a class that is used to describe the plants that will be the focus of plant genie,
 * which for now simply means having the attributes that will be considered during plant selection.
 *
 */
public class Plant {

    public final String plantName;   //the plant's name
    public int healthyGrowthRate;    //what can be considered the typical growth rate of a healthy instance of this plant
    public int minTemp;              //the minimum temperature that the plant can tolerate
    public int maxTemp;              //the maximum temperature that the plant can tolerate

    /**
     *  Class constructor
     */
    public Plant(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantName() { return this.plantName; }

    public int getHealthyGrowthRate() { return this.healthyGrowthRate; }

    public int getMinTemp() { return this.minTemp; }

    public int getMaxTemp() { return this.maxTemp; }

    public void setHealthyGrowthRate(int rate) { this.healthyGrowthRate = rate; }

    public void setMinTemp(int temp){ this.minTemp = temp; }

    public void setMaxTemp(int temp) { this.maxTemp = temp; }




}
