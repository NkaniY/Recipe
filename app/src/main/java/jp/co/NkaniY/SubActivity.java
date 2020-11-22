package jp.co.NkaniY;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        // MainActivityからintentで受け取ったものを取り出す
        String selectedText1 = intent.getStringExtra("Text");
        int selectedPhoto = intent.getIntExtra("Photo", 0);
        String selectedText2 = intent.getStringExtra("Text2");

        TextView textView1 = findViewById(R.id.selected_text);
        textView1.setText(selectedText1);
        ImageView  imageView = findViewById(R.id.selected_photo);
        imageView.setImageResource(selectedPhoto);
        TextView textView2 = findViewById(R.id.selected_recipe);
        textView2.setText(selectedText2);
    }
}

