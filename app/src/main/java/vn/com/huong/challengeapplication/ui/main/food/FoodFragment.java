package vn.com.huong.challengeapplication.ui.main.food;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import vn.com.huong.challengeapplication.R;
import vn.com.huong.challengeapplication.ui.main.home.FoodAdapter;

public class FoodFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.tvChefs)
    TextView tvChefs;
    @BindView(R.id.underChefs)
    View underChefs;
    @BindView(R.id.tvPopularFood)
    TextView tvPopularFood;
    @BindView(R.id.underFood)
    View underFood;
    @BindView(R.id.imageFilter)
    ImageView imageFilter;
    @BindView(R.id.rcvFood)
    RecyclerView rcvFood;

    private FoodAdapter adapter;
    private LinearLayoutManager layoutManager;

    @BindColor(R.color.gray)
    int gray;
    @BindColor(R.color.text_opacity_pink)
    int pink;

    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        ButterKnife.bind(this, view);
        initView();

        adapter = new FoodAdapter();
        layoutManager = new LinearLayoutManager(getContext());
        rcvFood.setLayoutManager(layoutManager);
        rcvFood.setAdapter(adapter);

        return view;
    }

    private void initView(){
        popularFoodClickedListen();
        tvPopularFood.setOnClickListener(this);
        tvChefs.setOnClickListener(this);
    }

    private void popularFoodClickedListen(){
        tvPopularFood.setTextColor(pink);
        underFood.setVisibility(View.VISIBLE);
        tvChefs.setTextColor(gray);
        underChefs.setVisibility(View.INVISIBLE);
    }

    private void chefsClickedListen(){
        tvPopularFood.setTextColor(gray);
        underFood.setVisibility(View.INVISIBLE);
        tvChefs.setTextColor(pink);
        underChefs.setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvChefs:
                configChefs();
                break;
            case R.id.tvPopularFood:
                configPopularFood();
                break;
        }
    }

    private void configChefs() {
        chefsClickedListen();

        // Change data of recycler view
    }

    private void configPopularFood() {
        popularFoodClickedListen();
    }
}
