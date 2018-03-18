package hangman.love1.longmandictionaryvocabularytest;

/**
 * Created by love1 on 2018/01/02.
 */

public class Reptiles extends Word {
    protected Reptiles(){
        assign();
    }

    private void assign(){
        assignToBoth("cobra", R.drawable.cobra);
        assignToBoth("iguana", R.drawable.iguana);
        assignToBoth("newt", R.drawable.newt);
    }
}
