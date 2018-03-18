package hangman.love1.longmandictionaryvocabularytest;

/**
 * Created by love1 on 2018/01/02.
 */

public class MeatAndSeafood extends Word {
    protected MeatAndSeafood(){
        assign();
    }

    private void assign(){
        assignToBoth("caviar", R.drawable.caviar);
        assignToBoth("mussel", R.drawable.mussel);
        assignToBoth("pastrami", R.drawable.pastrami);
        assignToBoth("salami", R.drawable.salami);
        assignToBoth("sardine", R.drawable.sardine);
    }
}
