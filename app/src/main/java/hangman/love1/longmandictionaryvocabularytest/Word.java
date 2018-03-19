package hangman.love1.longmandictionaryvocabularytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by love1 on 2018/01/01.
 */

public class Word {
    private String name;
    private int resourceId;

    public static Map<String, Integer> MAP = new HashMap<>();
    public static ArrayList<String> WORDS = new ArrayList<>();

    Word(String name, int resourceId){
        this.name = name;
        this.resourceId = resourceId;
    }

    public String getName(){
        return name;
    }

    public int getResourceId(){
        return resourceId;
    }

    public void setUp(){
        Clothing clothing = new Clothing();
        FootWear footWear = new FootWear();
        KitchenVerb kitchenVerb = new KitchenVerb();
        MeatAndSeafood meatAndSeafood = new MeatAndSeafood();
        Reptiles reptiles = new Reptiles();
        BodyParts bodyParts = new BodyParts();
        Insects insects = new Insects();
        SeaAnimals seaAnimals = new SeaAnimals();
        Animals animals = new Animals();
    }

    protected void assignToBoth(String word, int id){
        MAP.put(word, id);
        WORDS.add(word);
    }
}
