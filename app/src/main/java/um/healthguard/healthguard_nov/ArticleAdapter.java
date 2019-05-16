package um.healthguard.healthguard_nov;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{



    private Context mctx;
    private ArrayList<Article> articleList = new ArrayList<Article>();

    public ArticleAdapter(Context mctx, ArrayList<Article> articleList) {
        this.mctx = mctx;
        this.articleList = articleList;
    }



    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mctx);
        View view = inflater.inflate(R.layout.list_layout, null);
        ArticleViewHolder holder = new ArticleViewHolder(view,mctx,articleList);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);




        holder.textViewTitle.setText(article.getTitle());
        holder.textViewDesc.setText(article.getShortdesc());
        holder.textViewRating.setText(Double.toString(article.getRating()));
        holder.imageView.setImageResource(article.getImage());



    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewRating;
        ArrayList<Article> articleList = new ArrayList<Article>();
        Context mctx;

        public ArticleViewHolder(View itemView, Context mctx, ArrayList<Article> articleList) {
            super(itemView);
            this.articleList = articleList;
            this.mctx = mctx;

            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Article article = this.articleList.get(position);
            Intent intent = new Intent(mctx , ArticleDetails.class);
            intent.putExtra("title",article.getTitle());
            intent.putExtra("articledetails",article.getDetails());
            intent.putExtra("image",article.getImage());
            this.mctx.startActivity(intent);

        }
    }
}
