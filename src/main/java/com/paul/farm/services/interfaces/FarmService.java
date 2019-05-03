package com.paul.farm.services.interfaces;

import com.paul.farm.models.Farm;

public interface FarmService {

    void renameFarm(String id, String newFarmName);

    void deleteFarm(String id);

    void createFarm(String id);

    void updateFarm(Farm farm);

    Farm getFarm(String id);

    void processFarm();

    void setOffline(String id);
}
