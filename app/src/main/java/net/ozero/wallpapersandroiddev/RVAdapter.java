package net.ozero.wallpapersandroiddev;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import net.ozero.wallpapersandroiddev.rest.model.Hit;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<Hit> mData;

    public RVAdapter(Context context) {
        mContext = context;
        mData = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()
        ).inflate(R.layout.rv_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        ImageView imageView = holder.imageView;
        Glide
                .with(mContext)
                .load(mData.get(position).getPreviewURL())
                .into(imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Hit hit = mData.get(holder.getAdapterPosition());
                Intent intent = new Intent(mContext, ImageActivity.class);
                intent.putExtra(App.EXTRA_IMAGE, hit.getWebformatURL());
                intent.putExtra(App.EXTRA_URL, hit.getPageUrl());
                intent.putExtra(App.EXTRA_WALLPAPER, hit.getLargeImageURL());

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(ArrayList<Hit> hits) {
        mData.addAll(hits);
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.rvImageView);
        }
    }
}
