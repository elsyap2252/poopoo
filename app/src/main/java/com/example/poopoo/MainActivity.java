package com.example.poopoo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    // Deklarasi komponen UI
    private TextView dayText, monthText, yearText, hourText, minuteText, ampmText;
    private LinearLayout datePickerLayout, timePickerLayout;
    private EditText notesEditText;
    private Button btnSavePoo;

    // Untuk menyimpan pilihan pengguna
    private String selectedDate, selectedTime, selectedShape, selectedColor, selectedSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        dayText = findViewById(R.id.dayText);
        monthText = findViewById(R.id.monthText);
        yearText = findViewById(R.id.yearText);
        hourText = findViewById(R.id.hourText);
        minuteText = findViewById(R.id.minuteText);
        ampmText = findViewById(R.id.ampmText);
        notesEditText = findViewById(R.id.notesEditText);
        btnSavePoo = findViewById(R.id.btnSavePoo);

        // Pilih tanggal
        datePickerLayout = findViewById(R.id.datePickerLayout);
        datePickerLayout.setOnClickListener(v -> showDatePicker());

        // Pilih waktu
        timePickerLayout = findViewById(R.id.timePickerLayout);
        timePickerLayout.setOnClickListener(v -> showTimePicker());

        // Pilih shape
        setupShapeSelection();

        // Pilih color
        setupColorSelection();

        // Pilih size
        setupSizeSelection();

        // Tombol simpan
        btnSavePoo.setOnClickListener(v -> savePoopDetails());
    }

    private void showDatePicker() {
        // Anda dapat menggunakan DatePickerDialog di sini, misalnya untuk memilih tanggal
        Toast.makeText(this, "Date picker clicked", Toast.LENGTH_SHORT).show();
        // Setel tanggal yang dipilih ke TextView dayText, monthText, yearText
        // Implementasi DatePickerDialog disesuaikan di sini
    }

    private void showTimePicker() {
        // Anda dapat menggunakan TimePickerDialog di sini, misalnya untuk memilih waktu
        Toast.makeText(this, "Time picker clicked", Toast.LENGTH_SHORT).show();
        // Setel waktu yang dipilih ke TextView hourText, minuteText, ampmText
        // Implementasi TimePickerDialog disesuaikan di sini
    }

    private void setupShapeSelection() {
        LinearLayout shapeContainer = findViewById(R.id.dateContainer); // Perlu diperbaiki sesuai layout
        // Setiap CircleImageView mewakili sebuah bentuk
        CircleImageView shape1 = findViewById(R.id.poopshape1);
        CircleImageView shape2 = findViewById(R.id.poopshape2);
        CircleImageView shape3 = findViewById(R.id.poopshape3);
        CircleImageView shape4 = findViewById(R.id.poopshape4);
        CircleImageView shape5 = findViewById(R.id.poopshape5);
        CircleImageView shape6 = findViewById(R.id.poopshape6);

        shape1.setOnClickListener(v -> selectedShape = "Shape 1");
        shape2.setOnClickListener(v -> selectedShape = "Shape 2");
        shape3.setOnClickListener(v -> selectedShape = "Shape 3");
        shape4.setOnClickListener(v -> selectedShape = "Shape 4");
        shape5.setOnClickListener(v -> selectedShape = "Shape 5");
        shape6.setOnClickListener(v -> selectedShape = "Shape 6");
    }

    private void setupColorSelection() {
        // Setiap View mewakili sebuah warna
        View colorYellow = findViewById(R.id.colorYellow);
        View colorBrown = findViewById(R.id.colorBrown);
        View colorRed = findViewById(R.id.colorRed);
        View colorBlack = findViewById(R.id.colorBlack);
        View colorGreen = findViewById(R.id.colorGreen);

        colorYellow.setOnClickListener(v -> selectedColor = "Yellow");
        colorBrown.setOnClickListener(v -> selectedColor = "Brown");
        colorRed.setOnClickListener(v -> selectedColor = "Red");
        colorBlack.setOnClickListener(v -> selectedColor = "Black");
        colorGreen.setOnClickListener(v -> selectedColor = "Green");
    }

    private void setupSizeSelection() {
        // Setiap View mewakili sebuah ukuran
        View size1 = findViewById(R.id.size1);
        View size2 = findViewById(R.id.size2);
        View size3 = findViewById(R.id.size3);
        View size4 = findViewById(R.id.size4);
        View size5 = findViewById(R.id.size5);

        size1.setOnClickListener(v -> selectedSize = "Small");
        size2.setOnClickListener(v -> selectedSize = "Medium");
        size3.setOnClickListener(v -> selectedSize = "Large");
        size4.setOnClickListener(v -> selectedSize = "X-Large");
        size5.setOnClickListener(v -> selectedSize = "XX-Large");
    }

    private void savePoopDetails() {
        // Ambil nilai catatan dari EditText
        String notes = notesEditText.getText().toString();

        // Ambil nilai pilihan pengguna
        selectedDate = dayText.getText().toString() + "/" + monthText.getText().toString() + "/" + yearText.getText().toString();
        selectedTime = hourText.getText().toString() + ":" + minuteText.getText().toString() + " " + ampmText.getText().toString();

        // Menampilkan detail yang telah dipilih
        String message = "Poop Details Saved:\n" +
                "Date: " + selectedDate + "\n" +
                "Time: " + selectedTime + "\n" +
                "Shape: " + selectedShape + "\n" +
                "Color: " + selectedColor + "\n" +
                "Size: " + selectedSize + "\n" +
                "Notes: " + notes;

        // Tampilkan pesan sukses
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
