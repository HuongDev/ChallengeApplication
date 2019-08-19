package vn.com.huong.challengeapplication.ui.main.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import vn.com.huong.challengeapplication.R;

/**
 * Created by HuongPN on 01/03/2019.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FoodViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_food, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int i) {

        holder.tvName.setText();
        holder.tvRestaurant.setText();
        holder.tvTaste.setText();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imvFood)
        ImageView imvFood;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvRestaurant)
        TextView tvRestaurant;
        @BindView(R.id.tvTaste)
        TextView tvTaste;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
