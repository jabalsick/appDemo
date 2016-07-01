package example.firebase.mongo;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import example.firebase.mongo.Model.PostContent;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mDatabase;
    DatabaseReference mPostsReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mPostsReference = mDatabase.child("posts");
        FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  mDatabase.setValue(et.getText().toString());
                writeNewPost("Nuevo PostContent", "Este es el primer post de nuestra base.",
                        "http://www.ionlyhaveredpills.com/wp-content/uploads/2014/01/yoda-295x300.png");
            }
        });

        mPostsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                /*  String value = dataSnapshot.getValue(String.class);
                 tv.setText(value);*/

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }


    private void writeNewPost(String title, String detail, String imageUrl) {

        String key = mPostsReference.push().getKey();
        PostContent postContent = new PostContent(title, detail, imageUrl);
        Map<String, Object> postValues = postContent.toMap();

        Map<String, Object> newPostNode = new HashMap<>();
        newPostNode.put(key, postValues);

        mPostsReference.updateChildren(newPostNode);
    }

    private void irAListado(){

    }


}
