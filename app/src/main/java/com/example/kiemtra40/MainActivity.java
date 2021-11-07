 package com.example.kiemtra40;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    EditText anh, ten, gia;
    ImageButton toi, lui, timkien, tacgia, thoat;
    ListView lv_lk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anh = findViewById(R.id.editAnh);
        ten = findViewById(R.id.editTen);
        gia = findViewById(R.id.editGia);

        toi =  findViewById(R.id.toi);
        lui =  findViewById(R.id.lui);
        timkien =  findViewById(R.id.search);
        tacgia =  findViewById(R.id.ad);
        thoat =  findViewById(R.id.exit);

        lv_lk = findViewById(R.id.lv_lk);

    }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu, menu);
         return true;
     }

     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         int id = item.getItemId();

         if (id == R.id.add) {
             Toast.makeText(this, "Bạn đã Click vào Thêm", Toast.LENGTH_SHORT).show();
         }
         if (id == R.id.edit) {
             Toast.makeText(this, "Bạn đã Click vào sửa", Toast.LENGTH_SHORT).show();
         }
         if (id == R.id.delete) {
             Toast.makeText(this, "Bạn đã Click vào xóa", Toast.LENGTH_SHORT).show();
         }

         return super.onOptionsItemSelected(item);
     }
 }