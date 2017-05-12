package alfilm.iz.me.alfilm.ui.adapters;

import alfilm.iz.me.alfilm.R;
import alfilm.iz.me.alfilm.data.models.Result;
import alfilm.iz.me.alfilm.utils.StringHelper;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieItemViewHolder> {

  private List<Result> movieList;

  private MovieCallback callback;

  public MovieListAdapter(List<Result> movieList, MovieCallback callback) {
    this.movieList = movieList;
    this.callback = callback;
  }

  @Override public MovieItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    MovieItemViewHolder viewHolder;
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());

    View view = inflater.inflate(R.layout.item_movie, parent, false);
    viewHolder = new MovieItemViewHolder(view);
    return viewHolder;
  }

  @Override public void onBindViewHolder(MovieItemViewHolder holder, int position) {

    final Result item = movieList.get(position);

    holder.container.setOnClickListener(v -> {
      callback.onMovieClick(item, position);
    });

    holder.tvMovieName.setText(item.getOriginalTitle());
    holder.tvMovieDesc.setText(item.getOverview());

    String voteAvg = Double.toString(item.getVoteAverage());
    holder.tvPrice.setText(voteAvg);

    String imagePath = StringHelper.getImagePath(item.getPosterPath());
    if (imagePath.isEmpty()) return;

    final Context context = holder.ivMoviePic.getContext();
    Picasso.with(context).load(imagePath).placeholder(R.mipmap.ic_launcher).into(holder.ivMoviePic);
  }

  @Override public int getItemCount() {
    return movieList.size();
  }

  public interface MovieCallback {
    void onMovieClick(Result result, int position);
  }

  static class MovieItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.container) ViewGroup container;

    @BindView(R.id.ivMoviePic) ImageView ivMoviePic;

    @BindView(R.id.tvMovieName) TextView tvMovieName;

    @BindView(R.id.tvMovieDesc) TextView tvMovieDesc;

    @BindView(R.id.tvPrice) TextView tvPrice;

    MovieItemViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
