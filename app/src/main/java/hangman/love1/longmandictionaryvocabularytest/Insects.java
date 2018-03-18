package hangman.love1.longmandictionaryvocabularytest;

/**
 * Created by love1 on 2018/01/02.
 */

public class Insects extends Word {
    protected Insects(){
        assign();
    }

    private void assign(){
        assignToBoth("bumblebee", R.drawable.bumblebee);
        assignToBoth("caterpillar", R.drawable.caterpillar);
        assignToBoth("centipede", R.drawable.centipede);
        assignToBoth("cockroach", R.drawable.cockroach);
        assignToBoth("flea", R.drawable.flea);
        assignToBoth("larva", R.drawable.larva);
        assignToBoth("scorpion", R.drawable.scorpion);
        assignToBoth("slug", R.drawable.slug);
        assignToBoth("snail", R.drawable.snail);
        assignToBoth("termite", R.drawable.termite);
        assignToBoth("wasp", R.drawable.wasp);
    }
}
