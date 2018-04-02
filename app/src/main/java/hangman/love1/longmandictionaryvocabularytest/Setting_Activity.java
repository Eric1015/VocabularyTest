package hangman.love1.longmandictionaryvocabularytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Setting_Activity extends Activity {
    private List<String> categoryList = new ArrayList<>();
    private List<Switch> switches = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_);
        Switch switch2 = (Switch)findViewById(R.id.switch2);
        Switch switch3 = (Switch)findViewById(R.id.switch3);
        Switch switch4 = (Switch)findViewById(R.id.switch4);
        switches.add(switch2);
        switches.add(switch3);
        switches.add(switch4);
    }

    public void onStartButtonClickSetting(View v){
        Intent intent = new Intent(this, Main_Activity.class);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        boolean on = switch1.isChecked();
        if (on){
            categoryList = Arrays.asList(getResources().getStringArray(R.array.category_list));
        }
        else{
            List<String> list = Arrays.asList(getResources().getStringArray(R.array.choice_list));
            for (int i = 0; i < switches.size(); i++){
                if (switches.get(i).isChecked()){
                    categoryList.add(list.get(i + 2));
                }
            }
        }
        ArrayList<String> finalList = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++){
            finalList.add(categoryList.get(i));
        }
        intent.putExtra("CategoryList", finalList);
        startActivity(intent);
    }

    public void onSwitch1Click(View view){
       boolean on = ((Switch) view).isChecked();
        if (on){
            for (int i = 0; i < switches.size(); i++)
                switches.get(i).setVisibility(View.INVISIBLE);
        }
        else{
            for (int i = 0; i < switches.size(); i++)
                switches.get(i).setVisibility(View.VISIBLE);
        }
    }

}
