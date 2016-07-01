package example.firebase.mongo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import example.firebase.mongo.Model.PostContent;

public class AgosYJeroActivity extends AppCompatActivity {

    public TextView tvTitulo;
    public TextView tvDetalle;
    public TextView tvURL;
    public TextView tvAutor;
    public TextView tvRating;
    public Button btnGuardar;

    DatabaseReference mDatabase;
    DatabaseReference mPostsReference;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agos_yjero);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mPostsReference = mDatabase.child("posts");

        tvTitulo = (TextView)findViewById(R.id.txtTitulo);
        tvDetalle = (TextView)findViewById(R.id.txtDetalle);
        tvURL = (TextView)findViewById(R.id.txtURL);
        tvAutor = (TextView)findViewById(R.id.txtAuthor);
        tvRating = (TextView)findViewById(R.id.txtRating);

        btnGuardar = (Button)findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               guardarPost(v);
            }
        });


    }

    public void guardarPost(View v){
        String titulo = tvTitulo.getText().toString();
        String detalle = tvDetalle.getText().toString();
        String url = tvURL.getText().toString();
        String author = tvAutor.getText().toString();
        int rating = new Integer(tvRating.getText().toString());

        String key = mPostsReference.push().getKey();
        PostContent postContent = new PostContent(titulo, detalle, url, author, rating);
        Map<String, Object> postValues = postContent.toMap();

        Map<String, Object> newPostNode = new HashMap<>();
        newPostNode.put(key, postValues);

        mPostsReference.updateChildren(newPostNode);
    }


}
