package hangman.love1.longmandictionaryvocabularytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main_Activity extends Activity {
    ImageView imageView;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_test);
        imageView = (ImageView)findViewById(R.id.photo);
        if (savedInstanceState == null) {
            Word word = new Word();
            int a = 0;
            word.setUp();
            refresh();
        }
        else{
            Word.WORDS = savedInstanceState.getStringArrayList("wordArray");
            key = savedInstanceState.getString("currentWord");
            imageView.setImageResource(Word.MAP.get(key));
            EditText editText = (EditText)findViewById(R.id.typedAnswer);
            editText.setText(savedInstanceState.getString("currentEditText"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putStringArrayList("wordArray", Word.WORDS);
        savedInstanceState.putString("currentWord", key);
        EditText editText = (EditText)findViewById(R.id.typedAnswer);
        String typedAnswer = editText.getText().toString();
        savedInstanceState.putString("currentEditText", typedAnswer);
    }

    public void onSubmitClick(View view){
        EditText editText = (EditText)findViewById(R.id.typedAnswer);
        String typedAnswer = editText.getText().toString().trim();
        if (typedAnswer.equals(key)){
            CharSequence text = "Correct!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();

            editText.setText("");

            refresh();
        }
        else{
            CharSequence text = "Wrong!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, text, duration);
            toast.show();

            editText.setText("");
        }
    }

    public void onGiveUpClick(View view){
        CharSequence text = key + " is the correct answer";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();

        refresh();
    }

    private void refresh(){
        if (Word.WORDS.size() != 0) {
            int randomIndex = (int) (Math.random() * Word.WORDS.size());
            key = Word.WORDS.remove(randomIndex);
            imageView.setImageResource(Word.MAP.get(key));
        }
        else{
            Intent intent = new Intent(this, EndActivity.class);
            startActivity(intent);
        }
    }
}
