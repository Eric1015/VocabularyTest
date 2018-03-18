package hangman.love1.longmandictionaryvocabularytest;

/**
 * Created by love1 on 2018/01/02.
 */

public class SeaAnimals extends Word {
    protected SeaAnimals(){
        assign();
    }

    private void assign(){
        assignToBoth("bass", R.drawable.bass);
        assignToBoth("catfish", R.drawable.catfish);
        assignToBoth("sea lion", R.drawable.sea_lion);
        assignToBoth("sea urchin", R.drawable.sea_urchin);
        assignToBoth("shoal", R.drawable.shoal);
        assignToBoth("stingray", R.drawable.stingray);
        assignToBoth("swordfish", R.drawable.swordfish);
        assignToBoth("walrus", R.drawable.walrus);
    }
}
