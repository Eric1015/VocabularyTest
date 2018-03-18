package hangman.love1.longmandictionaryvocabularytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Setting_Activity extends Activity {
    private ArrayList<String> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_);
    }

    public void onStartButtonClickSetting(View v){
        Intent intent = new Intent(this, Main_Activity.class);
        intent.putExtra("CategoryList", categoryList);
        startActivity(intent);
    }
}
