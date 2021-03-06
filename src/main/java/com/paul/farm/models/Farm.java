package com.paul.farm.models;

import com.paul.farm.enums.FieldType;
import com.paul.farm.models.animals.Animal;
import com.paul.farm.models.animals.Cow;
import com.paul.farm.models.animals.Sheep;
import com.paul.farm.models.crops.Crop;
import com.paul.farm.models.fields.Field;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "FARM")
public class Farm {

    @Id
    private String farmName;
    private int budget = 3000;
    private int grassSeed = 200;
    private int wheatSeed = 200;
    private int cornSeed = 200;
    private int totalMilk;
    private int totalEggs;
    private int totalBeef;
    private int totalWool;
    private int totalLamb;
    private double totalStraw;
    private int totalBread;
    private double totalCorn;
    private int totalWheat;
    private int totalChickens;
    private int totalCows;
    private int totalSheep;
    private boolean online;
    private List<Field> fields = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();
    private List<Crop> crops = new ArrayList<>();

    public Farm() {}

    public Farm(String id) {
        farmName = id;
        fields = Field.getStartingFields();
    }

    public boolean containsFieldWithAnimals(FieldType fieldType) {
        for (Field field: fields) {
            if (field.getFieldType() == fieldType && field.getNoOfAnimals() > 0) {
                return true;
            }
        }
        return false;
    }

    public void updateAnimalCount() {
        this.totalCows = 0;
        this.totalSheep = 0;
        this.totalChickens = 0;
        this.animals.stream().forEach(animal -> {
            if (animal instanceof Cow) {
                this.totalCows++;
            } else if (animal instanceof Sheep) {
                this.totalSheep++;
            } else {
                this.totalChickens++;
            }
        });

    }
}
