package hangman.love1.longmandictionaryvocabularytest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Main_Activity extends Activity {
    private ArrayList<Word> wordList = new ArrayList<>();
    ImageView imageView;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.photo);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            ArrayList<String> categoryList = intent.getStringArrayListExtra("CategoryList");
            try {
                SQLiteOpenHelper vocabularyTestDatabaseHelper = new VocabularyTestDatabaseHelper(this);
                SQLiteDatabase db = vocabularyTestDatabaseHelper.getReadableDatabase();
                for (int i = 0; i < categoryList.size(); i++) {
                    String currentCategory = categoryList.get(i);
                    Cursor cursor = db.query("VOCABULARY",
                            new String[] {"NAME", "CATEGORY", "RESOURCE_ID"},
                            "CATEGORY = ?",
                            new String[]{currentCategory},
                            null, null, null);
                    String name = cursor.getString(0);
                    int resourceId = cursor.getInt(2);
                    Word word = new Word(name, resourceId);
                    wordList.add(word);
                }
            }
            catch (SQLiteException e){
                Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
            Collections.shuffle(wordList);
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
            Intent intent = new Intent(this, End_Activity.class);
            startActivity(intent);
        }
    }
}
