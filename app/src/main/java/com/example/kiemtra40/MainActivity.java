package com.example.kiemtra40;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private EditText Hinh, ten, gia;
    private Button toi, lui, timkien, tacgia, thoat;
    private ListView lv_lk;
    private ArrayList<LinhKien> linhKiens = new ArrayList<>();
    LinhKienAdapter adapter;
    int check;
    int move = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        //sự kiện
        tacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tacgia();
            }
        });

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        timkien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timkiem();
            }
        });

        toi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lv_lk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hinh.setText(linhKiens.get(position).getAnh());
                ten.setText(linhKiens.get(position).getTen());
                gia.setText(linhKiens.get(position).getGia());
                check = position;
            }
        });

        toi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (move < linhKiens.size()) {
                    move++;
                    Hinh.setText(linhKiens.get(move).getAnh());
                    ten.setText(linhKiens.get(move).getTen());
                    gia.setText(linhKiens.get(move).getGia());
                }
            }
        });
        lui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (move >= 0) {
                    move--;
                    Hinh.setText(linhKiens.get(move).getAnh());
                    ten.setText(linhKiens.get(move).getTen());
                    gia.setText(linhKiens.get(move).getGia());
                }

            }
        });
    }

    public void xuLyTiep() {
        Hinh.setText("");
        ten.setText("");
        gia.setText("");
    }

    public void AnhXa() {
        Hinh = (EditText) findViewById(R.id.ed_anh);
        ten = (EditText) findViewById(R.id.ed_Ten);
        gia = (EditText) findViewById(R.id.ed_Gia);

        lui = (Button) findViewById(R.id.lui);
        toi = (Button) findViewById(R.id.toi);
        timkien = (Button) findViewById(R.id.timkiem);
        tacgia = (Button) findViewById(R.id.tacgia);
        thoat = (Button) findViewById(R.id.thoat);

        lv_lk = (ListView) findViewById(R.id.lv_lk);
        db = openOrCreateDatabase("LinhKien.db", MODE_PRIVATE, null);

        String sql = "CREATE TABLE IF NOT EXISTS tblinhkien(id integer primary key AUTOINCREMENT, anh BLOB, ten text, gia int)";
        db.execSQL(sql);
    }

    //     private void insertest(){
//         String sql = "INSERT INTO tblinhkien (anh, ten, gia) VALUES ('res/@drawable/anh1.jpg','Huy Khang', '0848741399')";
//         db.execSQL(sql) ;
    //    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_them) {
            String str_ten = ten.getText().toString();
            String str_gia = gia.getText().toString();
            String str_anh = Hinh.getText().toString();
            LinhKien linhKien = new LinhKien(str_anh, str_ten, str_gia);
            linhKiens.add(linhKien);
            adapter = new LinhKienAdapter(this, linhKiens);
            lv_lk.setAdapter(adapter);
            Toast.makeText(this, "Bạn đã thêm linh kiện mới.", Toast.LENGTH_SHORT).show();
            Hinh.setText("");
            ten.setText("");
            gia.setText("");
        }
        if (id == R.id.menu_sua) {
            linhKiens.get(check).setAnh(Hinh.getText().toString());
            linhKiens.get(check).setTen(ten.getText().toString());
            linhKiens.get(check).setGia(gia.getText().toString());
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Bạn đã cập nhật thành công.", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.menu_xoa) {
            linhKiens.remove(check);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Bạn đã Xoa thành công.", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void tacgia() {
        Intent intent = new Intent(this, gioithieutacgia.class);
        this.startActivity(intent);
    }

    public void timkiem() {
        String name = ten.getText().toString();
        for (int i = 0;i<linhKiens.size();i++){
            if (name.equals(linhKiens.get(i).getTen())){
                Toast.makeText(getApplicationContext(), "Hinh ảnh: "+linhKiens.get(i).getAnh()+"\nTên: "+linhKiens.get(i).getTen()+"\nGía: "+linhKiens.get(i).getGia(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}