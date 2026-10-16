package ro.ase.lab;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toast.makeText(this, "Am ajuns in starea onCreate()!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPauseTag", "Am ajuns in starea onPause()!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResumeTag", "Am ajuns in starea onResume()!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStartTag", "Am ajuns in starea onStart()!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStopTag", "Am ajuns in starea onStop()!");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroyTag", "Am ajuns in starea onDestroy()!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestartTag", "Am ajuns in starea onRestart()!");
    }

}


