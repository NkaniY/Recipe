package jp.co.NkaniY;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    private static final String[] scenes = {
            "からあげ",
            "棒棒鶏",
            "豚の角煮",
    };

    private static final int[] photos = {
            R.drawable.ventnor,
            R.drawable.ventnor,
            R.drawable.ventnor,
    };

    private static final String[] recipe = {
            "揚げます",
            "茹でます",
            "煮ます",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.list, scenes, photos,recipe);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        // クリックリスナーをセット
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {

        Intent intent = new Intent(
                this.getApplicationContext(), SubActivity.class);

        // clickされたpositionのtextとphotoのID
        String selectedText1 = scenes[position];
        int selectedPhoto = photos[position];
        String selectedText2 = recipe[position];
        // インテントにセット
        intent.putExtra("Text", selectedText1);
        intent.putExtra("Photo", selectedPhoto);
        intent.putExtra("Text2", selectedText2);

        // SubActivityへ遷移
        startActivity(intent);
    }
}