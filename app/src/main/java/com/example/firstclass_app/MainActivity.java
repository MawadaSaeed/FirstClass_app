package com.example.firstclass_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity {

    private Spinner Colleges_Spinner;
    private EditText edtName;
    private RadioGroup rdGroup;
    private Switch swLastYear;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    public void setUpViews () {
        edtName = findViewById(R.id.edtName);
        rdGroup = findViewById(R.id.rdGroup);
        swLastYear = findViewById(R.id.swLastYear);
        txtResult = findViewById(R.id.txtResult);

        //Spinner
        Colleges_Spinner = findViewById(R.id.spinOne);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.College_Array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Colleges_Spinner.setAdapter(adapter);
    }

    public void btnSave_Click (View view){
        String msg = "";

        String name = edtName.getText().toString();
        if (!name.isEmpty())
            msg += "Name: " + name;

        int id = rdGroup.getCheckedRadioButtonId();
        if (id != -1){
            RadioButton rd = findViewById(id);
            msg += "\nGender: " + rd.getText().toString();
        }

        if (swLastYear.isChecked())
            msg += "\n" + swLastYear.getText().toString();

        AdapterView parent ;
        if (Colleges_Spinner.getSelectedItem() != null)
            msg += "\nCollege: " + Colleges_Spinner.getSelectedItem().toString();

        txtResult.setText(msg);
    }
}