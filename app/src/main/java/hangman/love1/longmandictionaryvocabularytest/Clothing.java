package hangman.love1.longmandictionaryvocabularytest;

/**
 * Created by love1 on 2018/01/01.
 */

public class Clothing extends Word{
    protected Clothing(){
        assign();
    }

    private void assign(){
        assignToBoth("blouse", R.drawable.blouse);
        assignToBoth("cardigan", R.drawable.cardigan);
        assignToBoth("gown", R.drawable.gown);
        assignToBoth("polo shirt", R.drawable.polo_shirt);
        assignToBoth("tuxedo", R.drawable.tuxedo);
    }
}
