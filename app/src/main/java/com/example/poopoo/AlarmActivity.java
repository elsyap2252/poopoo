package com.example.poopoo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlarmActivity extends AppCompatActivity {

    private NumberPicker numberPickerDays;
    private EditText messageReminder;
    private Switch switchEnable;
    private Button btnEdit, btnAm, btnPm;
    private TextView textTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alarm);

        // Inisialisasi view
        numberPickerDays = findViewById(R.id.numberPickerDays);
        messageReminder = findViewById(R.id.messageReminder);
        switchEnable = findViewById(R.id.switchEnable);
        btnEdit = findViewById(R.id.btnEdit);
        btnAm = findViewById(R.id.btnAm);
        btnPm = findViewById(R.id.btnPm);
        textTime = findViewById(R.id.textTime);

        // Setup picker
        numberPickerDays.setMinValue(1);
        numberPickerDays.setMaxValue(28);
        numberPickerDays.setValue(3);
        numberPickerDays.setWrapSelectorWheel(true);

        // Button AM dan PM
        btnAm.setOnClickListener(v -> {
            btnAm.setEnabled(false);
            btnPm.setEnabled(true);
        });

        btnPm.setOnClickListener(v -> {
            btnPm.setEnabled(false);
            btnAm.setEnabled(true);
        });
    }
}