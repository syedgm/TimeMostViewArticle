package com.mostviewarticle.android.articles.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mostviewarticle.android.R;
import com.mostviewarticle.android.util.Contract;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MostViewArticleAdapter  extends RecyclerView.Adapter<MostViewArticleAdapter.ViewHolder> {


    private Context context;
    private ArrayList<Contract.mostViewArticle> items;
    private final View.OnClickListener listener;


    public MostViewArticleAdapter(Context context, View.OnClickListener listener) {
        this.context = context;
        items = new ArrayList<>();
        this.listener = listener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.mostview_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(List<Contract.mostViewArticle> items) {
        //this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,bylineTxt,listDateTxt,abstractTxt;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            bylineTxt = (TextView) itemView.findViewById(R.id.author);

            listDateTxt = (TextView) itemView.findViewById(R.id.date);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            abstractTxt = (TextView) itemView.findViewById(R.id.article_abstract);
            itemView.setOnClickListener(listener);

        }

        public void bind(Contract.mostViewArticle mostViewArticle) {
            title.setText(mostViewArticle.title);
            bylineTxt.setText(mostViewArticle.byline);
            listDateTxt.setText(mostViewArticle.published_date);
            abstractTxt.setText(mostViewArticle.abstracttxt);

            if(mostViewArticle.media!=null && mostViewArticle.media.get(0).mediametadata!=null){
            String imageUrl = mostViewArticle.media.get(0).mediametadata.get(0).url;
                imageView.setVisibility(View.VISIBLE);
                Picasso.with(context)
                        .load(imageUrl)
                        .fit()
                        .into(imageView);

            }else {
                imageView.setVisibility(View.GONE);
            }



            //ImageLoadingUtils.loadImageURL(promotion.getPromitionLogoPath(), imageView,context);

            itemView.setTag(mostViewArticle);

        }


    }
    }
