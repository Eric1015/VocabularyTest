package hangman.love1.longmandictionaryvocabularytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by love1 on 2018/01/01.
 */

public class Word {
    public static Map<String, Integer> MAP = new HashMap<>();
    public static ArrayList<String> WORDS = new ArrayList<>();

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
