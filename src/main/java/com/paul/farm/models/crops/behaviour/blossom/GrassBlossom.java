package com.paul.farm.models.crops.behaviour.blossom;

import com.paul.farm.models.Farm;
import com.paul.farm.models.crops.Crop;
import com.paul.farm.models.fields.GrowingField;
import lombok.Data;

@Data
public class GrassBlossom implements Blossom {

    @Override
    public void blossom(Farm farm, Crop crop) {
        crop.setBlossomed(true);
        farm.setGrassSeed(farm.getGrassSeed() + 5);//when grass seed blossoms it produces more grass seed
        farm.setTotalStraw(farm.getTotalStraw() + 10.0);
    }
}
