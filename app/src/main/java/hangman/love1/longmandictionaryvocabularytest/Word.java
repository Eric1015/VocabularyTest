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
}
