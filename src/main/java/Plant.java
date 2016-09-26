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
    public int minTemp;              //the minimum temperature that the plant can tolerate, F
    public int maxTemp;              //the maximum temperature that the plant can tolerate, F

    /**
     *  Class constructor that takes in the name of the plant required for initialization
     */
    public Plant(String plantName) {
        this.plantName = plantName;
    }

    /**
     *
     * @return the name of the plant
     */
    public String getPlantName() { return this.plantName; }

    /**
     *
     * @return the growth rate for the plant that would be considered a typical growing rate of a healthy instance of this plant
     */
    public int getHealthyGrowthRate() { return this.healthyGrowthRate; }

    /**
     *
     * @return the minimum temperature that the plant can tolerate, F
     */
    public int getMinTemp() { return this.minTemp; }

    /**
     * @return the maximum temperature that the plant can tolerate, F
     */
    public int getMaxTemp() { return this.maxTemp; }

    /**
     *
     * @param rate is the growth rate for the plant that would be considered a typical growing rate of a healthy instance of this plant
     */
    public void setHealthyGrowthRate(int rate) { this.healthyGrowthRate = rate; }

    /**
     *
     * @param temp is the minimum temperature that the plant can tolerate, F
     */
    public void setMinTemp(int temp){ this.minTemp = temp; }

    /**
     *
     * @param temp is the maximum temperature that the plant can tolerate, F
     */
    public void setMaxTemp(int temp) { this.maxTemp = temp; }


}
