package hangman.love1.longmandictionaryvocabularytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Title_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    public void onStartClick(View view){
        Intent intent = new Intent(this, Setting_Activity.class);
        startActivity(intent);
    }
}
