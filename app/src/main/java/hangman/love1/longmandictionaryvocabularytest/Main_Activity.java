package hangman.love1.longmandictionaryvocabularytest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Main_Activity extends Activity {
    VocabularyTestDatabaseHelper myDb;
    private ArrayList<Word> wordList = new ArrayList<>();
    ImageView imageView;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new VocabularyTestDatabaseHelper(this);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            ArrayList<String> categoryList = intent.getStringArrayListExtra("CategoryList");
            for (int i = 0; i < categoryList.size(); i++) {
                String currentCategory = categoryList.get(i);
                addElement(currentCategory);
            }
            Collections.shuffle(wordList);
            refresh();
        }
        else{
            ArrayList<String> nameArray = savedInstanceState.getStringArrayList("nameList");
            ArrayList<Integer> resourceArray = savedInstanceState.getIntegerArrayList("resourceList");
            for (int i = 0; i < nameArray.size(); i++){
                Word word = new Word(nameArray.get(i), resourceArray.get(i));
                wordList.add(word);
            }
            Word currentWord = wordList.get(wordList.size() - 1);
            key = currentWord.getName();
            if (imageView == null)
                imageView = (ImageView)findViewById(R.id.photo);
            imageView.setImageResource(currentWord.getResourceId());
            EditText editText = (EditText)findViewById(R.id.typedAnswer);
            editText.setText(savedInstanceState.getString("currentEditText"));
        }
    }

    private void addElement(String category){
        Cursor cursor = myDb.getCursorByCategory(category);
        if (cursor.getCount() == 0)
            return;
        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            int resourceId = cursor.getInt(2);
            Word word = new Word(name, resourceId);
            wordList.add(word);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        ArrayList<String> nameArray = new ArrayList<>();
        ArrayList<Integer> resourceArray = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++){
            Word word = wordList.get(i);
            nameArray.add(word.getName());
            resourceArray.add(word.getResourceId());
        }
        savedInstanceState.putStringArrayList("nameList", nameArray);
        savedInstanceState.putIntegerArrayList("resourceList", resourceArray);
        EditText editText = (EditText)findViewById(R.id.typedAnswer);
        String typedAnswer = editText.getText().toString();
        savedInstanceState.putString("currentEditText", typedAnswer);
    }

    public void onSubmitClick(View view){
        EditText editText = (EditText)findViewById(R.id.typedAnswer);
        String typedAnswer = editText.getText().toString().trim();
        if (typedAnswer.equals(key)){
            CharSequence text = "Correct!!";
            Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
            toast.show();

            editText.setText("");
            wordList.remove(wordList.size() - 1);

            refresh();
        }
        else{
            CharSequence text = "Wrong!!";
            Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
            toast.show();

            editText.setText("");
        }
    }

    public void onGiveUpClick(View view){
        CharSequence text = key + " is the correct answer";
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
        wordList.remove(wordList.size() - 1);

        refresh();
    }

    private void refresh(){
        if (wordList.size() > 0) {
            Word word = wordList.get(wordList.size() - 1);
            key = word.getName();
            if (imageView == null)
                imageView = (ImageView)findViewById(R.id.photo);
            imageView.setImageResource(word.getResourceId());
        }
        else{
            Intent intent = new Intent(this, End_Activity.class);
            startActivity(intent);
        }
    }
}
