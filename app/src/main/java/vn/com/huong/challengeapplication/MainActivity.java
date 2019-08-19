package vn.com.huong.challengeapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.com.huong.challengeapplication.internal.base.BaseActivity;
import vn.com.huong.challengeapplication.ui.main.food.FoodFragment;
import vn.com.huong.challengeapplication.ui.main.home.HomeFragment;
import vn.com.huong.challengeapplication.ui.main.MyFoodFragment;
import vn.com.huong.challengeapplication.ui.main.ProfileFragment;
import vn.com.huong.challengeapplication.ui.main.ShoppingFragment;

/**
 * Created by HuongPN on 12/15/2018.
 */
public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.navigation)
    BottomNavigationView navigationView;

    final Fragment foodFragment = new FoodFragment();
    final Fragment profileFragment = new ProfileFragment();
    final Fragment homeFragment = new HomeFragment();
    final Fragment shoppingFragment = new ShoppingFragment();
    final Fragment myFoodFragment = new MyFoodFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = foodFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initAllFragment();

//        navigationView.setSelectedItemId(R.id.action_home);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_food:
                    showFragment(foodFragment, item);
                    break;
                case R.id.action_profile:
                    showFragment(profileFragment, item);
                    break;
                case R.id.action_home:
                    showFragment(homeFragment, item);
                    break;
                case R.id.action_shopping:
                    showFragment(shoppingFragment, item);
                    break;
                case R.id.action_clock:
                    showFragment(myFoodFragment, item);
                    break;
            }
            return false;
        }
    };

    private void showFragment(Fragment fragment, MenuItem item){
        fm.beginTransaction().hide(active).show(fragment).commit();
        item.setChecked(true);
        active = fragment;
    }

    private void initAllFragment(){
        fm.beginTransaction().add(R.id.frame_container, myFoodFragment, "5").hide(myFoodFragment).commit();
        fm.beginTransaction().add(R.id.frame_container, shoppingFragment, "4").hide(shoppingFragment).commit();
        fm.beginTransaction().add(R.id.frame_container, homeFragment, "3").hide(homeFragment).commit();
        fm.beginTransaction().add(R.id.frame_container, profileFragment, "2").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.frame_container, foodFragment, "1").commit();
    }
}
