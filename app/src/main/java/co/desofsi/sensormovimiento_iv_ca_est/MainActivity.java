package co.desofsi.sensormovimiento_iv_ca_est;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    private SensorManager sensorManager;

    private Sensor sensor;

    private Button izquierza;
    private Button derecha;
    private CardView cardViewderecha;
    private CardView cardViewizquierda;

    private ImageView imageView;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.txt_izquierda);
        izquierza = (Button) findViewById(R.id.btn_left);
        derecha = (Button) findViewById(R.id.btn_right);

        cardViewderecha = (CardView) findViewById(R.id.card_derecha);
        cardViewizquierda = (CardView) findViewById(R.id.card_izquiedar);

        imageView = (ImageView) findViewById(R.id.img_derecha);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);


        izquierza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("SOLO SE QUE NADA SE");
            }
        });


        derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.logo);
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float valor = event.values[0];

        if (valor > 0) {

            cardViewizquierda.setVisibility(View.VISIBLE);
            cardViewderecha.setVisibility(View.GONE);
            izquierza.setVisibility(View.VISIBLE);
            derecha.setVisibility(View.GONE);
            imageView.setImageResource(R.drawable.ic_android_black_24dp);
        } else {

            textView.setText("");
            cardViewizquierda.setVisibility(View.GONE);
            cardViewderecha.setVisibility(View.VISIBLE);


            izquierza.setVisibility(View.GONE);
            derecha.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
