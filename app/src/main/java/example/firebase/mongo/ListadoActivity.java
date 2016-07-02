package example.firebase.mongo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import example.firebase.mongo.Model.PostContent;
import example.firebase.mongo.ViewHolders.PostViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

public class ListadoActivity extends AppCompatActivity {

    private RecyclerView postsRecycler;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<PostContent,PostViewHolder> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        postsRecycler = (RecyclerView) findViewById(R.id.posts_recycler_view);
        postsRecycler.setHasFixedSize(true);

        //DEFINO EL ADAPTER PARA EL RECYCLER VIEW
        // @param PostContent.class  clase del modelo que vamos a mostrar
        // @param R.layout.post_layout  layout del item
        // @param PostViewHolder.class  clase del ViewHolder del RecyclerView
        // @param PostViewHolder.class  clase del ViewHolder del RecyclerView
        // @param mDatabase.child("posts")  referencia de Firebase de donde voy a obtener el listado

        mAdapter = new FirebaseRecyclerAdapter<PostContent, PostViewHolder>(PostContent.class, R.layout.post_layout,
                PostViewHolder.class, mDatabase.child("posts")) {

         // ESTOS SON LOS PARAMETROS QUE RECIBE EL METODO "populateViewHolder"
         // @param PostViewHolder ViewHolder para el RecyclerView
         // @param PostContent  El objeto que contiene la data que vamos a mostrar en el item del listado
         // @param position  posicion de la view en la lista que vamos a mostrar.
            @Override
            protected void populateViewHolder(final PostViewHolder postViewHolder, final PostContent post, final int position) {

                postViewHolder.tituloView.setText(post.getTitle());
                postViewHolder.detailView.setText(post.getDetail());
                postViewHolder.ratingView.setText(Integer.toString(post.getRating()));
                postViewHolder.authorView.setText(post.getAuthor());

                //Aca ponemos la url de la imagen en el ImageView por medio de la librería GLIDE.
                Glide.with(ListadoActivity.this) //context
                        .load(post.getImageUrl()) // URL
                        .override(300,200)
                        .into(postViewHolder.postImageView); // imageView donde pongo la imagen

            }
        };

        postsRecycler.setLayoutManager(new LinearLayoutManager(ListadoActivity.this));
        postsRecycler.setAdapter(mAdapter);
    }
}

