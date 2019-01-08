package com.softtech.appcentertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.push.Push;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCenter.start(getApplication(), "57b13362-77c6-43a6-a24a-95f3f1478550",
                Analytics.class, Crashes.class,Push.class);

        Button btnCheckName=(Button)findViewById(R.id.button_control_name);

        btnCheckName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(getApplicationContext(),"Uzun Basma,Basmaa!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
//Test for CI
    public void CheckName(View v)  {
        String name = ((EditText)findViewById(R.id.editText_name)).getText().toString();
        TextView welcomeText=(TextView)findViewById(R.id.text_welcome);
        if(name.equals("umut"))
        {
           Toast.makeText(this, "Giriş Başarılı",  Toast.LENGTH_SHORT).show();
           welcomeText.setText("Hoş Geldin Umut");
            welcomeText.setTextSize(35);
        }
        else if(name.equals("bora"))
        {
            Toast.makeText(this, "Yetkilendirmeden dolayı sayfayı göremezsiniz.",  Toast.LENGTH_SHORT).show();
            welcomeText.setText("");
        }
        else if(name.equals("emel"))
        {
            Toast.makeText(this, "Build Hata Verdi",  Toast.LENGTH_SHORT).show();
            welcomeText.setText("Benim Bilgisayarımda Çalışıyordu");
            welcomeText.setTextSize(17);
        }
        else
        {
            Integer test = 5 / 0;
        }




    }






}
