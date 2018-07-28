package com.example.ajumal.listview;

import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class DicActivity extends AppCompatActivity {

    private static final String[] words = {
            "ee", "ee1",
            "dd", "dd1",
            "ff", "ff1"
    };

    private Map <String, String> dictionary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic);

        dictionary = new HashMap<>();
        for (int i = 0; i<words.length; i+=2) {
            dictionary.put(words[i], words[i+1]);
        }
        ListView list = (ListView)findViewById(R.id.idList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
//                Toast.makeText(DicActivity.this, word, Toast.LENGTH_SHORT).show();
                String val = dictionary.get(word);
                Toast.makeText(DicActivity.this, val, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
