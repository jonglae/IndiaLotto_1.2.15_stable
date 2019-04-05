package gotopark.com.IndiaLotto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hotchemi.android.rate.AppRate;
import hotchemi.android.rate.OnClickButtonListener;
import hotchemi.android.rate.StoreType;

/**
 * Created by User on 4/15/2017.
 */

public class ActivityFour extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        TextView text1 = (TextView) findViewById(R.id.textView1);
        TextView text2 = (TextView) findViewById(R.id.textView2);
        TextView text4 = (TextView) findViewById(R.id.textView4);
        ImageView App_image = (ImageView) findViewById (R.id.imageView);
        ImageView App_image2 = (ImageView) findViewById (R.id.imageView2);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_arrow:
                        Intent intent0 = new Intent(ActivityFour.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_android:
                        Intent intent1 = new Intent(ActivityFour.this, ActivityOne.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(ActivityFour.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(ActivityFour.this, ActivityThree.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_backup:
                        break;
                }


                return false;
            }
        });

        App_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String html_link1 = getString (R.string.app_info3);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(html_link1));
                startActivity(intent);
            }
        });

        AnRate ();

        App_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String html_link1 = getString (R.string.app_info3);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(html_link1));
                startActivity(intent);
            }
        });

        /** 앱버전 과 앱이름 표시 */
        String versionCode = BuildConfig.VERSION_NAME;
        String app_name = getString(R.string.app_name);
        text1.setText(app_name+"  V"+versionCode+"\n");
        text1.append(getString(R.string.app_info1));
        text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        text2.setText(getString(R.string.app_info2));

        text4.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        text4.setText(getString(R.string.app_info4)+"\n");

        text4.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        text4.setClickable (true);
        text4.setMovementMethod(LinkMovementMethod.getInstance());
        text4.append(Html.fromHtml ("<a href=https://twitter.com/data114>Twitter Follow @data114</a>"));

    }

    public void AnRate() {
        AppRate.with (this)
                .setStoreType (StoreType.GOOGLEPLAY) //default is Google, other option is Amazon
                .setInstallDays (2) // default 10, 0 means install day.
                .setLaunchTimes (10) // default 10 times.
                .setRemindInterval (1) // default 1 day.
                .setShowLaterButton (true) // default true.
                .setDebug (false) // default false.
                .setCancelable (false) // default false.
                .setOnClickButtonListener (new OnClickButtonListener () { // callback listener.
                    @Override
                    public void onClickButton(int which) {
                    }
                }).monitor ();
        AppRate.showRateDialogIfMeetsConditions (this);
    }

}