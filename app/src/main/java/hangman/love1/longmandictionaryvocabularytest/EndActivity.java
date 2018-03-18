package hangman.love1.longmandictionaryvocabularytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
    }

    public void onEndClick(View view){
        finishAffinity();
    }

    public void onResetClick(View view){
        Intent intent = new Intent(this, Main_Activity.class);
        startActivity(intent);
    }
}
