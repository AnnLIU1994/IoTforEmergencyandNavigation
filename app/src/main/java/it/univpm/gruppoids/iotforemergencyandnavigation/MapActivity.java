package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MapActivity extends AppCompatActivity {


    public static ImageView mapImage;
    public static MenuItem forward;
    public static MenuItem firstPage;

    private ImageView q145dicea;
    private ImageView q145s1;
    private ImageView q145r3;
    private ImageView q145r1;
    private ImageView q145wc1;
    private ImageView q145s2;
    private ImageView q145s3;
    private ImageView q145rg2;
    private ImageView q145rg1;
    private ImageView q145ema7;
    private ImageView q145em1;
    private ImageView q145u1;
    private ImageView q145ea5;
    private ImageView q145a5;
    private ImageView q145emg1;
    private ImageView q145emg2;
    private ImageView q145u2;
    private ImageView q145a3;
    private ImageView q145ema3;
    private ImageView q145u3;
    private ImageView q145ram;

    private ImageView q150dicea1;
    private ImageView q150g1;
    private ImageView q150dicea;
    private ImageView q150strade;
    private ImageView q150em1;
    private ImageView q150wc1;
    private ImageView q150ram;
    private ImageView q150g1g2;
    private ImageView q150g2;
    private ImageView q150r2;
    private ImageView q150s1;
    private ImageView q150r1;
    private ImageView q150rl;
    private ImageView q150bib;
    private ImageView q150emrl;
    private ImageView q150emr1;
    private ImageView q150a7;
    private ImageView q150a5;
    private ImageView q150a3;

    private ImageView q155dicea;
    private ImageView q155r567;
    private ImageView q155r4;
    private ImageView q155r4d3;
    private ImageView q155r23d2;
    private ImageView q155rd1;
    private ImageView q155wc1;
    private ImageView q155u1;
    private ImageView q155ecdl;
    private ImageView q155s1;
    private ImageView q155wc2;
    private ImageView q155em2;
    private ImageView q155acq;
    private ImageView q155em3;
    private ImageView q155up;
    private ImageView q155cesmi;
    private ImageView q155bar;
    private ImageView q155em1;
    private ImageView q155a7;
    private ImageView q155a5;
    private ImageView q155a3;

    private String nodeSelected;

    int initFloorExtra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent inputIntent = getIntent();
        initFloorExtra = inputIntent.getIntExtra("initFloor", 0);
        String floorString = Integer.toString(initFloorExtra);

        mapImage = (ImageView) findViewById(R.id.mapFloor);

        if (initFloorExtra != 0) {
            getSupportActionBar().setTitle(getResources().getString(R.string.floor_pos) + " " + floorString);
        }
        switch (initFloorExtra) {
            case 145:
                mapImage.setImageResource(R.drawable.q145);

                q145ema7 = (ImageView) findViewById(R.id.q145ema7);

                q145em1 = (ImageView) findViewById(R.id.q145em1);

                q145u1 = (ImageView) findViewById(R.id.q145u1);

                q145emg1 = (ImageView) findViewById(R.id.q145emg1);

                q145emg2 = (ImageView) findViewById(R.id.q145emg2);

                q145u2 = (ImageView) findViewById(R.id.q145u2);

                q145ema3 = (ImageView) findViewById(R.id.q145ema3);

                q145ram = (ImageView) findViewById(R.id.q145ram);

                q145u3 = (ImageView) findViewById(R.id.q145u3);

                q145dicea = (ImageView) findViewById(R.id.q145dicea);

                q145s1 = (ImageView) findViewById(R.id.q145s1);

                q145r3 = (ImageView) findViewById(R.id.q145r3);

                q145r1 = (ImageView) findViewById(R.id.q145r1);

                q145wc1 = (ImageView) findViewById(R.id.q145wc1);

                q145s2 = (ImageView) findViewById(R.id.q145s2);

                q145s3 = (ImageView) findViewById(R.id.q145s3);

                q145rg2 = (ImageView) findViewById(R.id.q145rg2);

                q145rg1 = (ImageView) findViewById(R.id.q145rg1);

                q145ea5 = (ImageView) findViewById(R.id.q145ea5);

                q145a5 = (ImageView) findViewById(R.id.q145a5);

                q145a3 = (ImageView) findViewById(R.id.q145a3);


                Nodes.positioningNode(q145ema7);

                Nodes.positioningNode(q145em1);

                Nodes.positioningNode(q145u1);

                Nodes.positioningNode(q145emg1);

                Nodes.positioningNode(q145emg2);

                Nodes.positioningNode(q145u2);

                Nodes.positioningNode(q145ema3);

                Nodes.positioningNode(q145u3);

                Nodes.positioningNode(q145ram);

                Nodes.positioningNode(q145dicea);

                Nodes.positioningNode(q145s1);

                Nodes.positioningNode(q145r3);

                Nodes.positioningNode(q145r1);

                Nodes.positioningNode(q145wc1);

                Nodes.positioningNode(q145s2);

                Nodes.positioningNode(q145s3);

                Nodes.positioningNode(q145rg2);

                Nodes.positioningNode(q145rg1);

                Nodes.positioningNode(q145ea5);

                Nodes.positioningNode(q145a5);

                Nodes.positioningNode(q145a3);


                q145ema7.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145ema7);
                            nodeSelected = Nodes.getNameOfNode(q145ema7);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145em1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145em1);
                            nodeSelected = Nodes.getNameOfNode(q145em1);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145u1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145u1);
                            nodeSelected = Nodes.getNameOfNode(q145u1);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145emg1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145emg1);
                            nodeSelected = Nodes.getNameOfNode(q145emg1);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145emg2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145emg2);
                            nodeSelected = Nodes.getNameOfNode(q145emg2);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145u2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145u2);
                            nodeSelected = Nodes.getNameOfNode(q145u2);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145ema3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145ema3);
                            nodeSelected = Nodes.getNameOfNode(q145ema3);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145u3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145u3);
                            nodeSelected = Nodes.getNameOfNode(q145u3);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145ram.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145ram);
                            nodeSelected = Nodes.getNameOfNode(q145ram);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145dicea.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145dicea);
                            nodeSelected = Nodes.getNameOfNode(q145dicea);

                            // unselected
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145s1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145s1);
                            nodeSelected = Nodes.getNameOfNode(q145s1);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145r3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145r3);
                            nodeSelected = Nodes.getNameOfNode(q145r3);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145r1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145r1);
                            nodeSelected = Nodes.getNameOfNode(q145r1);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145wc1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145wc1);
                            nodeSelected = Nodes.getNameOfNode(q145wc1);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145s2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145s2);
                            nodeSelected = Nodes.getNameOfNode(q145s2);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145s3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145s3);
                            nodeSelected = Nodes.getNameOfNode(q145s3);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145rg2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145rg2);
                            nodeSelected = Nodes.getNameOfNode(q145rg2);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145rg1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145rg1);
                            nodeSelected = Nodes.getNameOfNode(q145rg1);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145ea5.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145ea5);
                            nodeSelected = Nodes.getNameOfNode(q145ea5);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145a5.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145a5);
                            nodeSelected = Nodes.getNameOfNode(q145a5);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145rg1);
                            Nodes.unselectedNode(q145a3);
                        }
                        return false;
                    }
                });

                q145a3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q145a3);
                            nodeSelected = Nodes.getNameOfNode(q145a3);

                            // unselected
                            Nodes.unselectedNode(q145dicea);
                            Nodes.unselectedNode(q145s1);
                            Nodes.unselectedNode(q145r3);
                            Nodes.unselectedNode(q145r1);
                            Nodes.unselectedNode(q145wc1);
                            Nodes.unselectedNode(q145s2);
                            Nodes.unselectedNode(q145s3);
                            Nodes.unselectedNode(q145rg2);
                            Nodes.unselectedNode(q145ema7);
                            Nodes.unselectedNode(q145em1);
                            Nodes.unselectedNode(q145u1);
                            Nodes.unselectedNode(q145emg1);
                            Nodes.unselectedNode(q145emg2);
                            Nodes.unselectedNode(q145u2);
                            Nodes.unselectedNode(q145ema3);
                            Nodes.unselectedNode(q145u3);
                            Nodes.unselectedNode(q145ram);
                            Nodes.unselectedNode(q145ea5);
                            Nodes.unselectedNode(q145a5);
                            Nodes.unselectedNode(q145rg1);
                        }
                        return false;
                    }
                });
                break;
            case 150:
                mapImage.setImageResource(R.drawable.q150);

                q150dicea1 = (ImageView) findViewById(R.id.q150dicea1);

                q150g1 = (ImageView) findViewById(R.id.q150g1);

                q150dicea = (ImageView) findViewById(R.id.q150dicea);

                q150strade = (ImageView) findViewById(R.id.q150strade);

                q150em1 = (ImageView) findViewById(R.id.q150em1);

                q150wc1 = (ImageView) findViewById(R.id.q150wc1);

                q150ram = (ImageView) findViewById(R.id.q150ram);

                q150g1g2 = (ImageView) findViewById(R.id.q150g1g2);

                q150g2 = (ImageView) findViewById(R.id.q150g2);

                q150r2 = (ImageView) findViewById(R.id.q150r2);

                q150s1 = (ImageView) findViewById(R.id.q150s1);

                q150r1 = (ImageView) findViewById(R.id.q150r1);

                q150rl = (ImageView) findViewById(R.id.q150rl);

                q150bib = (ImageView) findViewById(R.id.q150bib);

                q150emrl = (ImageView) findViewById(R.id.q150emrl);

                q150emr1 = (ImageView) findViewById(R.id.q150emr1);

                q150a7 = (ImageView) findViewById(R.id.q150a7);

                q150a5 = (ImageView) findViewById(R.id.q150a5);

                q150a3 = (ImageView) findViewById(R.id.q150a3);

                Nodes.positioningNode(q150dicea1);

                Nodes.positioningNode(q150g1);

                Nodes.positioningNode(q150dicea);

                Nodes.positioningNode(q150strade);

                Nodes.positioningNode(q150em1);

                Nodes.positioningNode(q150wc1);

                Nodes.positioningNode(q150ram);

                Nodes.positioningNode(q150g1g2);

                Nodes.positioningNode(q150g2);

                Nodes.positioningNode(q150r2);

                Nodes.positioningNode(q150s1);

                Nodes.positioningNode(q150r1);

                Nodes.positioningNode(q150rl);

                Nodes.positioningNode(q150bib);

                Nodes.positioningNode(q150emrl);

                Nodes.positioningNode(q150emr1);

                Nodes.positioningNode(q150a7);

                Nodes.positioningNode(q150a5);

                Nodes.positioningNode(q150a3);

                q150dicea1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150dicea1);
                            nodeSelected = Nodes.getNameOfNode(q150dicea1);

                            // unselected
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150g1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150g1);
                            nodeSelected = Nodes.getNameOfNode(q150g1);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150dicea.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150dicea);
                            nodeSelected = Nodes.getNameOfNode(q150dicea);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150strade.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150strade);
                            nodeSelected = Nodes.getNameOfNode(q150strade);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150em1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150em1);
                            nodeSelected = Nodes.getNameOfNode(q150em1);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150wc1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150wc1);
                            nodeSelected = Nodes.getNameOfNode(q150wc1);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150ram.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150ram);
                            nodeSelected = Nodes.getNameOfNode(q150ram);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150g1g2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150g1g2);
                            nodeSelected = Nodes.getNameOfNode(q150g1g2);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150g2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150g2);
                            nodeSelected = Nodes.getNameOfNode(q150g2);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150r2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150r2);
                            nodeSelected = Nodes.getNameOfNode(q150r2);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150s1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150s1);
                            nodeSelected = Nodes.getNameOfNode(q150s1);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150r1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150r1);
                            nodeSelected = Nodes.getNameOfNode(q150r1);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150rl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150rl);
                            nodeSelected = Nodes.getNameOfNode(q150rl);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150bib.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150bib);
                            nodeSelected = Nodes.getNameOfNode(q150bib);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150emrl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150emrl);
                            nodeSelected = Nodes.getNameOfNode(q150emrl);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150emr1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150emr1);
                            nodeSelected = Nodes.getNameOfNode(q150emr1);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150a7.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150a7);
                            nodeSelected = Nodes.getNameOfNode(q150a7);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150a5.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150a5);
                            nodeSelected = Nodes.getNameOfNode(q150a5);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150emr1);
                            Nodes.unselectedNode(q150a3);
                        }
                        return false;
                    }
                });

                q150a3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q150a3);
                            nodeSelected = Nodes.getNameOfNode(q150a3);

                            // unselected
                            Nodes.unselectedNode(q150dicea1);
                            Nodes.unselectedNode(q150g1);
                            Nodes.unselectedNode(q150dicea);
                            Nodes.unselectedNode(q150strade);
                            Nodes.unselectedNode(q150em1);
                            Nodes.unselectedNode(q150wc1);
                            Nodes.unselectedNode(q150ram);
                            Nodes.unselectedNode(q150g1g2);
                            Nodes.unselectedNode(q150g2);
                            Nodes.unselectedNode(q150r2);
                            Nodes.unselectedNode(q150s1);
                            Nodes.unselectedNode(q150r1);
                            Nodes.unselectedNode(q150bib);
                            Nodes.unselectedNode(q150emrl);
                            Nodes.unselectedNode(q150rl);
                            Nodes.unselectedNode(q150a7);
                            Nodes.unselectedNode(q150a5);
                            Nodes.unselectedNode(q150emr1);
                        }
                        return false;
                    }
                });
                break;
            case 155:
                mapImage.setImageResource(R.drawable.q155);

                q155dicea = (ImageView) findViewById(R.id.q155dicea);

                q155r567 = (ImageView) findViewById(R.id.q155r567);

                q155r4 = (ImageView) findViewById(R.id.q155r4);

                q155r4d3 = (ImageView) findViewById(R.id.q155r4d3);

                q155r23d2 = (ImageView) findViewById(R.id.q155r23d2);

                q155rd1 = (ImageView) findViewById(R.id.q155rd1);

                q155wc1 = (ImageView) findViewById(R.id.q155wc1);

                q155u1 = (ImageView) findViewById(R.id.q155u1);

                q155ecdl = (ImageView) findViewById(R.id.q155ecdl);

                q155s1 = (ImageView) findViewById(R.id.q155s1);

                q155wc2 = (ImageView) findViewById(R.id.q155wc2);

                q155em2 = (ImageView) findViewById(R.id.q155em2);

                q155acq = (ImageView) findViewById(R.id.q155acq);

                q155em3 = (ImageView) findViewById(R.id.q155em3);

                q155up = (ImageView) findViewById(R.id.q155up);

                q155cesmi = (ImageView) findViewById(R.id.q155cesmi);

                q155bar = (ImageView) findViewById(R.id.q155bar);

                q155em1 = (ImageView) findViewById(R.id.q155em1);

                q155a7 = (ImageView) findViewById(R.id.q155a7);

                q155a5 = (ImageView) findViewById(R.id.q155a5);

                q155a3 = (ImageView) findViewById(R.id.q155a3);

                Nodes.positioningNode(q155dicea);

                Nodes.positioningNode(q155r567);

                Nodes.positioningNode(q155r4);

                Nodes.positioningNode(q155r4d3);

                Nodes.positioningNode(q155r23d2);

                Nodes.positioningNode(q155rd1);

                Nodes.positioningNode(q155wc1);

                Nodes.positioningNode(q155u1);

                Nodes.positioningNode(q155ecdl);

                Nodes.positioningNode(q155s1);

                Nodes.positioningNode(q155wc2);

                Nodes.positioningNode(q155em2);

                Nodes.positioningNode(q155acq);

                Nodes.positioningNode(q155em3);

                Nodes.positioningNode(q155up);

                Nodes.positioningNode(q155cesmi);

                Nodes.positioningNode(q155bar);

                Nodes.positioningNode(q155em1);

                Nodes.positioningNode(q155a7);

                Nodes.positioningNode(q155a5);

                Nodes.positioningNode(q155a3);

                q155dicea.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155dicea);
                            nodeSelected = Nodes.getNameOfNode(q155dicea);

                            // unselected
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155r567.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155r567);
                            nodeSelected = Nodes.getNameOfNode(q155r567);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155r4.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155r4);
                            nodeSelected = Nodes.getNameOfNode(q155r4);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155r4d3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155r4d3);
                            nodeSelected = Nodes.getNameOfNode(q155r4d3);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155r23d2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155r23d2);
                            nodeSelected = Nodes.getNameOfNode(q155r23d2);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155rd1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155rd1);
                            nodeSelected = Nodes.getNameOfNode(q155rd1);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155wc1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155wc1);
                            nodeSelected = Nodes.getNameOfNode(q155wc1);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155u1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155u1);
                            nodeSelected = Nodes.getNameOfNode(q155u1);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155ecdl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155ecdl);
                            nodeSelected = Nodes.getNameOfNode(q155ecdl);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155s1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155s1);
                            nodeSelected = Nodes.getNameOfNode(q155s1);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155wc2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155wc2);
                            nodeSelected = Nodes.getNameOfNode(q155wc2);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155em2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155em2);
                            nodeSelected = Nodes.getNameOfNode(q155em2);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155acq.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155acq);
                            nodeSelected = Nodes.getNameOfNode(q155acq);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155em3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155em3);
                            nodeSelected = Nodes.getNameOfNode(q155em3);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155up.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155up);
                            nodeSelected = Nodes.getNameOfNode(q155up);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155cesmi.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155cesmi);
                            nodeSelected = Nodes.getNameOfNode(q155cesmi);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155bar.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155bar);
                            nodeSelected = Nodes.getNameOfNode(q155bar);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155em1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155em1);
                            nodeSelected = Nodes.getNameOfNode(q155em1);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155a7.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155a7);
                            nodeSelected = Nodes.getNameOfNode(q155a7);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155a5.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155a5);
                            nodeSelected = Nodes.getNameOfNode(q155a5);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155em1);
                            Nodes.unselectedNode(q155a3);
                        }
                        return false;
                    }
                });

                q155a3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNode(q155a3);
                            nodeSelected = Nodes.getNameOfNode(q155a3);

                            // unselected
                            Nodes.unselectedNode(q155dicea);
                            Nodes.unselectedNode(q155r567);
                            Nodes.unselectedNode(q155r4);
                            Nodes.unselectedNode(q155r4d3);
                            Nodes.unselectedNode(q155r23d2);
                            Nodes.unselectedNode(q155rd1);
                            Nodes.unselectedNode(q155wc1);
                            Nodes.unselectedNode(q155u1);
                            Nodes.unselectedNode(q155ecdl);
                            Nodes.unselectedNode(q155s1);
                            Nodes.unselectedNode(q155wc2);
                            Nodes.unselectedNode(q155em2);
                            Nodes.unselectedNode(q155acq);
                            Nodes.unselectedNode(q155em3);
                            Nodes.unselectedNode(q155up);
                            Nodes.unselectedNode(q155cesmi);
                            Nodes.unselectedNode(q155bar);
                            Nodes.unselectedNode(q155a7);
                            Nodes.unselectedNode(q155a5);
                            Nodes.unselectedNode(q155em1);
                        }
                        return false;
                    }
                });
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        firstPage = menu.findItem(R.id.firstPage);
        forward = menu.findItem(R.id.forward);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.firstPage:
                Intent intent = new Intent(this, InitPositionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                MapActivity.this.finish();
                break;
            case R.id.forward:
                Intent nextPage = new Intent(this, ModActivity.class);
                nextPage.putExtra("initPos", nodeSelected); //TODO: invece degli intent scrivere su db
                nextPage.putExtra("initFloor", initFloorExtra);
                startActivity(nextPage);
                break;
            case android.R.id.home: // Id relativo alla freccia in alto a sinistra, per tornare alla schermata precedente
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}