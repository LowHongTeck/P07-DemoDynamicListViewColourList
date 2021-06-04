package sg.edu.rp.c346.id20043679.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;
    EditText etIndexElement;

    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAdditem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);

        alColours = new ArrayList<String>();

        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int position = Integer.parseInt(etIndexElement.getText().toString());

                alColours.add(position, colour);
                aaColour.notifyDataSetChanged();
            }
        });
        lvColour.setAdapter(aaColour);

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, "You selected "+colour, Toast.LENGTH_SHORT).show();
            }
        });

    }


}