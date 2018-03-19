package hangman.love1.longmandictionaryvocabularytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Setting_Activity extends Activity implements AdapterView.OnItemSelectedListener{
    private ArrayList<String> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_);
        Spinner spinner = (Spinner)findViewById(R.id.category_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onStartButtonClickSetting(View v){
        Intent intent = new Intent(this, Main_Activity.class);
        intent.putExtra("CategoryList", categoryList);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        String item = parent.getItemAtPosition(pos).toString();
        TextView currentList = (TextView)findViewById(R.id.selected_categories);
        if (item.equals("All"))
            currentList.setText("All");
        else if (!item.equals("Select")){
            CharSequence currentSequence = currentList.getText();
            String current = currentSequence.toString();
            current += " ";
            current += item;
            currentList.setText(current);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent){
        CharSequence text = "No items selected";
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
