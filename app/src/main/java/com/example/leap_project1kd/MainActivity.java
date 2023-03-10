package com.example.leap_project1kd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView userButton;
    ImageView AdminBtn;
    TextView Password;
    public static Uri camera1URI;
    public static Uri camera2URI;
    View decorView;
    public static Uri camera3URI;
    public static Uri camera4URI;
    public static Uri SaveFolderURI;
    TextView Credit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userButton = (ImageView) findViewById(R.id.btn_user_home);
        setUserBtn();
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility==0){
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
        Password = findViewById(R.id.Password);
        AdminBtn = (ImageView) findViewById(R.id.btn_admin);
        Credit = findViewById(R.id.textView3);
        Credit.setAlpha((float)0.05);
        setAdminBtn();
    }
    public void setUserBtn(){
        userButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent i = new Intent(getApplicationContext(),UserHome.class);
                startActivity(i);
            }
        });
    }
    public void setAdminBtn(){
        AdminBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                if(Password.getText().toString().equals("C234")){
                    Intent i = new Intent(getApplicationContext(),Select_Cameras.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public static Uri getUris(int reqCode){
        switch(reqCode){
            case 1:
                return camera1URI;
            case 2:
                return camera2URI;
            case 3:
                return camera3URI;
            case 4:
                return camera4URI;
            case 5:
                return SaveFolderURI;
            default:
                return null;
        }
    }
    public static void setUris(Uri uri, int Code){
        switch(Code){
            case 1:
                camera1URI = uri;
                Log.i("Camera 1 uri", String.valueOf(camera1URI));
                break;
            case 2:
                camera2URI = uri;
                Log.i("Camera 2 uri", String.valueOf(camera2URI));
                break;
            case 3:
                camera3URI = uri;
                Log.i("Camera 3 uri", String.valueOf(camera3URI));
                break;
            case 4:
                camera4URI = uri;
                Log.i("Camera 4 uri", String.valueOf(camera4URI));
                break;
            case 5:
                SaveFolderURI = uri;
            default:
                Log.i("Set Uri Log", "Null return");
        }
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }
    private int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
    }
}