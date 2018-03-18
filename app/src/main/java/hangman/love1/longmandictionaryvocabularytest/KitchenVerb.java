package hangman.love1.longmandictionaryvocabularytest;

/**
 * Created by love1 on 2018/01/02.
 */

public class KitchenVerb extends Word {
    protected KitchenVerb(){
        assign();
    }

    private void assign(){
        assignToBoth("beat", R.drawable.beat);
        assignToBoth("carve", R.drawable.carve);
        assignToBoth("grate", R.drawable.grate);
        assignToBoth("knead", R.drawable.knead);
        assignToBoth("sift", R.drawable.sift);
        assignToBoth("sprinkle", R.drawable.sprinkle);
        assignToBoth("whisk", R.drawable.whisk);
    }
}
