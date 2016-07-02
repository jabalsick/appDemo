package example.firebase.mongo.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.firebase.mongo.R;


public class PostViewHolder extends RecyclerView.ViewHolder{


    public TextView tituloView, detailView,ratingView,authorView;
    public ImageView postImageView;


    public PostViewHolder(View itemView) {
        super(itemView);

        tituloView = (TextView) itemView.findViewById(R.id.post_title);
        detailView = (TextView) itemView.findViewById(R.id.post_detail);
        ratingView = (TextView) itemView.findViewById(R.id.post_rating);
        authorView = (TextView) itemView.findViewById(R.id.post_author);
        postImageView = (ImageView) itemView.findViewById(R.id.post_image);

    }

}
