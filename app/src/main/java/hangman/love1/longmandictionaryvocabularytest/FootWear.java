package hangman.love1.longmandictionaryvocabularytest;

/**
 * Created by love1 on 2018/01/01.
 */

public class FootWear extends Word {
    protected FootWear(){
        assign();
    }

    private void assign(){
        assignToBoth("brogues", R.drawable.brogues);
        assignToBoth("cleats", R.drawable.cleats);
        assignToBoth("loafers", R.drawable.loafers);
        assignToBoth("moccasins", R.drawable.moccasins);
        assignToBoth("thong sandals", R.drawable.thong_sandals);
    }
}
