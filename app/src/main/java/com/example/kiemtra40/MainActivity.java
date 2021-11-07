 package com.example.kiemtra40;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity{

    EditText Hinh, ten, gia;
    ImageButton toi, lui, timkien, tacgia, thoat;
    ListView lv_lk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

//      Create data
        ArrayList<LinhKien> arrayList = new ArrayList<>();

        arrayList.add(new LinhKien(R.drawable.anh1,"Nguyen Thi A", "600.000"));
        arrayList.add(new LinhKien(R.drawable.anh2,"Nguyen Thi A", "600.000"));
        arrayList.add(new LinhKien(R.drawable.anh3,"Nguyen Thi A", "600.000"));
        arrayList.add(new LinhKien(R.drawable.anh4,"Nguyen Thi A", "600.000"));
        arrayList.add(new LinhKien(R.drawable.anh5,"Nguyen Thi A", "600.000"));
        arrayList.add(new LinhKien(R.drawable.anh6,"Nguyen Thi A", "600.000"));
        arrayList.add(new LinhKien(R.drawable.anh7,"Nguyen Thi A", "600.000"));
        arrayList.add(new LinhKien(R.drawable.anh8,"Nguyen Thi A", "600.000"));
        arrayList.add(new LinhKien(R.drawable.anh9,"Nguyen Thi A", "600.000"));

//      we make custom adapter

        LinhKienAdapter linhKienAdapter = new LinhKienAdapter(this, R.layout.hienthi, arrayList);

        lv_lk.setAdapter(linhKienAdapter);

    }

    public void AnhXa(){
        Hinh = (EditText) findViewById(R.id.ed_anh);
        ten = (EditText) findViewById(R.id.ed_Ten);
        gia = (EditText) findViewById(R.id.ed_Gia);

        toi =  (ImageButton) findViewById(R.id.toi);
        lui =  (ImageButton) findViewById(R.id.lui);
        timkien =  (ImageButton) findViewById(R.id.search);
        tacgia =  (ImageButton) findViewById(R.id.ad);
        thoat =  (ImageButton) findViewById(R.id.exit);

        lv_lk = (ListView) findViewById(R.id.lv_lk);
    }
     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu, menu);
         return true;
     }

     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         int id = item.getItemId();

         if (id == R.id.menu_them) {
             Toast.makeText(this, "Bạn đã Click vào thêm", Toast.LENGTH_SHORT).show();
         }
         if (id == R.id.menu_sua) {
             Toast.makeText(this, "Bạn đã Click vào sửa", Toast.LENGTH_SHORT).show();
         }
         if (id == R.id.menu_xoa) {
             Toast.makeText(this, "Bạn đã Click vào xóa", Toast.LENGTH_SHORT).show();
         }

         return super.onOptionsItemSelected(item);
     }

 }