package com.example.kiemtra40;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class LinhKienAdapter extends BaseAdapter {
        private Activity activity;
        ArrayList<LinhKien> linhKiens;
        //private Context mContext;
        //private int mResource;
    /*                                                                //I want to use ArrayLists LinhKien[]
    public LinhKienAdapter(@NonNull Context context, int resource, @NonNull ArrayList<LinhKien> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }
*/
    public LinhKienAdapter(Activity activity, ArrayList<LinhKien> linhKiens){
        this.activity = activity;
        this.linhKiens = linhKiens;
    }

    @Override
    public int getCount() {
        return linhKiens.size();
    }

    @Override
    public Object getItem(int position) {
        return linhKiens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();

        convertView = layoutInflater.inflate(R.layout.hienthi, parent, false);

        ImageView imageView = convertView.findViewById(R.id.img);

        TextView txtten = convertView.findViewById(R.id.TxtTen);

        TextView txtgia = convertView.findViewById(R.id.TxtDong);
        String url = linhKiens.get(position).getAnh();
        String[] url_arr = url.split("/");
        int id = -1;
        switch (url_arr[2]){
            case "anh1.jpg":
                id = R.drawable.anh1;
                break;
            case "anh2.jpg":// đoạn này nhớ thêm vô, tương tự̣ ảnh 1
                id = R.drawable.anh2;
                break;
            case "anh3.jpg":
                id = R.drawable.anh3;
                break;
            case "anh4.jpg":
                id = R.drawable.anh4;
                break;
            case "anh5.jpg":
                id = R.drawable.anh5;
                break;
            case "anh6.jpg":
                id = R.drawable.anh6;
                break;
            case "anh7.jpg":
                id = R.drawable.anh7;
                break;
            case "anh8.jpg":
                id = R.drawable.anh8;
                break;
            case "anh9.jpg":
                id = R.drawable.anh9;
                break;
            default:
                id = R.drawable.ic_launcher_background;
        }
        imageView.setImageResource(id);

        txtten.setText(linhKiens.get(position).getTen());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgia.setText(decimalFormat.format(Integer.parseInt(linhKiens.get(position).getGia()))+"đ");

        return convertView;

    }
}
