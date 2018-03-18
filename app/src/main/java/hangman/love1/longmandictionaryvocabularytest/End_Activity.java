package hangman.love1.longmandictionaryvocabularytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class End_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
    }

    public void onDoneClick(View view){
        finishAffinity();
    }

    public void onStartAgainClick(View view){
        Intent intent = new Intent(this, Setting_Activity.class);
        startActivity(intent);
    }
}
