/**
 * Created by aphexTinez on 9/24/16.
 */
public class Plant {

    public final String plantName;
    public int healthyGrowthRate;
    public int minTemp;
    public int maxTemp;

    public Plant(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantName() { return this.plantName; }

    public int getHealthyGrowthRate() { return this.healthyGrowthRate; }

    public int getMinTemp() { return this.minTemp; }

    public int getMaxTemp() { return this.maxTemp; }

    public void setHealthyGrowthRate(int rate) { this.healthyGrowthRate = rate; }

    public void setminTemp(int temp){ this.minTemp = temp; }

    public void setMaxTemp(int temp) { this.maxTemp = temp; }




}
