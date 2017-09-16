package com.rishabhchauhan.proxynotes;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] videoTitles;
    String[] videoDes;
    String[] videoDuration;
    String[] videoURL;
    int[] images = {R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        videoTitles = res.getStringArray(R.array.titles);
        videoDes = res.getStringArray(R.array.description);
        videoDuration = res.getStringArray(R.array.duration);
        videoURL = res.getStringArray(R.array.url);

        list = (ListView) findViewById(R.id.listView);

        ProxyAdapter adapter = new ProxyAdapter(this, videoTitles, images, videoDes, videoURL, videoDuration);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int progress, long l) {
                if (progress == 0){
                    Intent mf = new Intent(view.getContext(), VideoViewActivity.class);
                    startActivityForResult(mf,0);
                }
                if (progress == 1){
                    Intent mf = new Intent(view.getContext(), Video2.class);
                    startActivityForResult(mf,1);
                }
                if (progress == 2){
                    Intent mf = new Intent(view.getContext(), Video3.class);
                    startActivityForResult(mf,2);
                }
                if (progress == 3){
                    Intent mf = new Intent(view.getContext(), Video4.class);
                    startActivityForResult(mf,3);
                }
                if (progress == 4){
                    Intent mf = new Intent(view.getContext(), Video5.class);
                    startActivityForResult(mf,4);
                }
                if (progress == 5){
                    Intent mf = new Intent(view.getContext(), Video6.class);
                    startActivityForResult(mf,5);
                }
                if (progress == 6){
                    Intent mf = new Intent(view.getContext(), Video7.class);
                    startActivityForResult(mf,6);
                }
                if (progress == 7){
                    Intent mf = new Intent(view.getContext(), Video8.class);
                    startActivityForResult(mf,7);
                }
                if (progress == 8){
                    Intent mf = new Intent(view.getContext(), Video9.class);
                    startActivityForResult(mf,8);
                }
                if (progress == 9){
                    Intent mf = new Intent(view.getContext(), Video10.class);
                    startActivityForResult(mf,9);
                }
            }
        });
    }
}

class ProxyAdapter extends ArrayAdapter<String>{

    Context context;
    int[] images;
    String[] titleArray;
    String[] desArray;
    String[] urlArray;
    String[] durArray;

    ProxyAdapter(Context c, String[] titles, int i[], String[] desc, String[] url, String[] dur){

        super(c, R.layout.single_row, R.id.textView,titles);
        this.context = c;
        this.images = i;
        this.titleArray = titles;
        this.desArray = desc;
        this.urlArray = url;
        this.durArray = dur;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row, parent, false);

        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        TextView myTitle = (TextView) row.findViewById(R.id.textView);
        TextView myDes = (TextView) row.findViewById(R.id.textView2);
        TextView myURL = (TextView) row.findViewById(R.id.textView3);
        TextView myDur = (TextView) row.findViewById(R.id.textView4);

        myImage.setImageResource(images[position]);
        myTitle.setText(titleArray[position]);
        myDes.setText(desArray[position]);
        myURL.setText(urlArray[position]);
        myDur.setText(durArray[position]);

        return row;
    }
}