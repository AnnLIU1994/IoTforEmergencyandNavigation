package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MapFinalActivity extends AppCompatActivity {

    public static ImageView mapImage;
    public static MenuItem forward;
    public static MenuItem firstPage;

    String initPos;

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

    private String nodeSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_final);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent inputIntent = getIntent();
        initPos = inputIntent.getStringExtra("initPos");
        int floorExtra = inputIntent.getIntExtra("floor", 0);
        String floorString = Integer.toString(floorExtra);

        mapImage = (ImageView) findViewById(R.id.mapFloor);

        if (floorExtra != 0) {
            getSupportActionBar().setTitle(getResources().getString(R.string.floor_pos) + " " + floorString);
        }

        switch (floorString) {
            case "145":
                mapImage.setImageResource(R.drawable.q145);


                q145dicea = (ImageView) findViewById(R.id.q145dicea);

                q145s1 = (ImageView) findViewById(R.id.q145s1);

                q145r3 = (ImageView) findViewById(R.id.q145r3);

                q145r1 = (ImageView) findViewById(R.id.q145r1);

                q145wc1 = (ImageView) findViewById(R.id.q145wc1);

                q145s2 = (ImageView) findViewById(R.id.q145s2);

                q145s3 = (ImageView) findViewById(R.id.q145s3);

                q145rg2 = (ImageView) findViewById(R.id.q145rg2);

                q145rg1 = (ImageView) findViewById(R.id.q145rg1);


                Nodes.positioningNodeNav(q145dicea);

                Nodes.positioningNodeNav(q145s1);

                Nodes.positioningNodeNav(q145r3);

                Nodes.positioningNodeNav(q145r1);

                Nodes.positioningNodeNav(q145wc1);

                Nodes.positioningNodeNav(q145s2);

                Nodes.positioningNodeNav(q145s3);

                Nodes.positioningNodeNav(q145rg2);

                Nodes.positioningNodeNav(q145rg1);


                q145dicea.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q145dicea);
                            nodeSelected = Nodes.getNameOfNode(q145dicea);

                            // unselected
                            Nodes.unselectedNodeNav(q145s1);
                            Nodes.unselectedNodeNav(q145r3);
                            Nodes.unselectedNodeNav(q145r1);
                            Nodes.unselectedNodeNav(q145wc1);
                            Nodes.unselectedNodeNav(q145s2);
                            Nodes.unselectedNodeNav(q145s3);
                            Nodes.unselectedNodeNav(q145rg2);
                            Nodes.unselectedNodeNav(q145rg1);
                        }
                        return false;
                    }
                });

                q145s1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q145s1);
                            nodeSelected = Nodes.getNameOfNode(q145s1);

                            // unselected
                            Nodes.unselectedNodeNav(q145dicea);
                            Nodes.unselectedNodeNav(q145r3);
                            Nodes.unselectedNodeNav(q145r1);
                            Nodes.unselectedNodeNav(q145wc1);
                            Nodes.unselectedNodeNav(q145s2);
                            Nodes.unselectedNodeNav(q145s3);
                            Nodes.unselectedNodeNav(q145rg2);
                            Nodes.unselectedNodeNav(q145rg1);
                        }
                        return false;
                    }
                });

                q145r3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q145r3);
                            nodeSelected = Nodes.getNameOfNode(q145r3);

                            // unselected
                            Nodes.unselectedNodeNav(q145dicea);
                            Nodes.unselectedNodeNav(q145s1);
                            Nodes.unselectedNodeNav(q145r1);
                            Nodes.unselectedNodeNav(q145wc1);
                            Nodes.unselectedNodeNav(q145s2);
                            Nodes.unselectedNodeNav(q145s3);
                            Nodes.unselectedNodeNav(q145rg2);
                            Nodes.unselectedNodeNav(q145rg1);
                        }
                        return false;
                    }
                });

                q145r1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q145r1);
                            nodeSelected = Nodes.getNameOfNode(q145r1);

                            // unselected
                            Nodes.unselectedNodeNav(q145dicea);
                            Nodes.unselectedNodeNav(q145s1);
                            Nodes.unselectedNodeNav(q145r3);
                            Nodes.unselectedNodeNav(q145wc1);
                            Nodes.unselectedNodeNav(q145s2);
                            Nodes.unselectedNodeNav(q145s3);
                            Nodes.unselectedNodeNav(q145rg2);
                            Nodes.unselectedNodeNav(q145rg1);
                        }
                        return false;
                    }
                });

                q145wc1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q145wc1);
                            nodeSelected = Nodes.getNameOfNode(q145wc1);

                            // unselected
                            Nodes.unselectedNodeNav(q145dicea);
                            Nodes.unselectedNodeNav(q145s1);
                            Nodes.unselectedNodeNav(q145r3);
                            Nodes.unselectedNodeNav(q145r1);
                            Nodes.unselectedNodeNav(q145s2);
                            Nodes.unselectedNodeNav(q145s3);
                            Nodes.unselectedNodeNav(q145rg2);
                            Nodes.unselectedNodeNav(q145rg1);
                        }
                        return false;
                    }
                });

                q145s2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q145s2);
                            nodeSelected = Nodes.getNameOfNode(q145s2);

                            // unselected
                            Nodes.unselectedNodeNav(q145dicea);
                            Nodes.unselectedNodeNav(q145s1);
                            Nodes.unselectedNodeNav(q145r3);
                            Nodes.unselectedNodeNav(q145r1);
                            Nodes.unselectedNodeNav(q145wc1);
                            Nodes.unselectedNodeNav(q145s3);
                            Nodes.unselectedNodeNav(q145rg2);
                            Nodes.unselectedNodeNav(q145rg1);
                        }
                        return false;
                    }
                });

                q145s3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q145s3);
                            nodeSelected = Nodes.getNameOfNode(q145s3);

                            // unselected
                            Nodes.unselectedNodeNav(q145dicea);
                            Nodes.unselectedNodeNav(q145s1);
                            Nodes.unselectedNodeNav(q145r3);
                            Nodes.unselectedNodeNav(q145r1);
                            Nodes.unselectedNodeNav(q145wc1);
                            Nodes.unselectedNodeNav(q145s2);
                            Nodes.unselectedNodeNav(q145rg2);
                            Nodes.unselectedNodeNav(q145rg1);
                        }
                        return false;
                    }
                });

                q145rg2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q145rg2);
                            nodeSelected = Nodes.getNameOfNode(q145rg2);

                            // unselected
                            Nodes.unselectedNodeNav(q145dicea);
                            Nodes.unselectedNodeNav(q145s1);
                            Nodes.unselectedNodeNav(q145r3);
                            Nodes.unselectedNodeNav(q145r1);
                            Nodes.unselectedNodeNav(q145wc1);
                            Nodes.unselectedNodeNav(q145s2);
                            Nodes.unselectedNodeNav(q145s3);
                            Nodes.unselectedNodeNav(q145rg1);
                        }
                        return false;
                    }
                });

                q145rg1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q145rg1);
                            nodeSelected = Nodes.getNameOfNode(q145rg1);

                            // unselected
                            Nodes.unselectedNodeNav(q145dicea);
                            Nodes.unselectedNodeNav(q145s1);
                            Nodes.unselectedNodeNav(q145r3);
                            Nodes.unselectedNodeNav(q145r1);
                            Nodes.unselectedNodeNav(q145wc1);
                            Nodes.unselectedNodeNav(q145s2);
                            Nodes.unselectedNodeNav(q145s3);
                            Nodes.unselectedNodeNav(q145rg2);
                        }
                        return false;
                    }
                });
                break;
            case "150":
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

                Nodes.positioningNodeNav(q150dicea1);

                Nodes.positioningNodeNav(q150g1);

                Nodes.positioningNodeNav(q150dicea);

                Nodes.positioningNodeNav(q150strade);

                Nodes.positioningNodeNav(q150em1);

                Nodes.positioningNodeNav(q150wc1);

                Nodes.positioningNodeNav(q150ram);

                Nodes.positioningNodeNav(q150g1g2);

                Nodes.positioningNodeNav(q150g2);

                Nodes.positioningNodeNav(q150r2);

                Nodes.positioningNodeNav(q150s1);

                Nodes.positioningNodeNav(q150r1);

                Nodes.positioningNodeNav(q150rl);

                q150dicea1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150dicea1);
                            nodeSelected = Nodes.getNameOfNode(q150dicea1);

                            // unselected
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150g1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150g1);
                            nodeSelected = Nodes.getNameOfNode(q150g1);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150dicea.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150dicea);
                            nodeSelected = Nodes.getNameOfNode(q150dicea);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150strade.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150strade);
                            nodeSelected = Nodes.getNameOfNode(q150strade);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150em1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150em1);
                            nodeSelected = Nodes.getNameOfNode(q150em1);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150wc1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150wc1);
                            nodeSelected = Nodes.getNameOfNode(q150wc1);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150ram.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150ram);
                            nodeSelected = Nodes.getNameOfNode(q150ram);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150g1g2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150g1g2);
                            nodeSelected = Nodes.getNameOfNode(q150g1g2);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150g2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150g2);
                            nodeSelected = Nodes.getNameOfNode(q150g2);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150r2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150r2);
                            nodeSelected = Nodes.getNameOfNode(q150r2);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150s1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150s1);
                            nodeSelected = Nodes.getNameOfNode(q150s1);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150r1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150r1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150r1);
                            nodeSelected = Nodes.getNameOfNode(q150r1);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150rl);
                        }
                        return false;
                    }
                });

                q150rl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q150rl);
                            nodeSelected = Nodes.getNameOfNode(q150rl);

                            // unselected
                            Nodes.unselectedNodeNav(q150dicea1);
                            Nodes.unselectedNodeNav(q150g1);
                            Nodes.unselectedNodeNav(q150dicea);
                            Nodes.unselectedNodeNav(q150strade);
                            Nodes.unselectedNodeNav(q150em1);
                            Nodes.unselectedNodeNav(q150wc1);
                            Nodes.unselectedNodeNav(q150ram);
                            Nodes.unselectedNodeNav(q150g1g2);
                            Nodes.unselectedNodeNav(q150g2);
                            Nodes.unselectedNodeNav(q150r2);
                            Nodes.unselectedNodeNav(q150s1);
                            Nodes.unselectedNodeNav(q150r1);
                        }
                        return false;
                    }
                });
                break;
            case "155":
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

                Nodes.positioningNodeNav(q155dicea);

                Nodes.positioningNodeNav(q155r567);

                Nodes.positioningNodeNav(q155r4);

                Nodes.positioningNodeNav(q155r4d3);

                Nodes.positioningNodeNav(q155r23d2);

                Nodes.positioningNodeNav(q155rd1);

                Nodes.positioningNodeNav(q155wc1);

                Nodes.positioningNodeNav(q155u1);

                Nodes.positioningNodeNav(q155ecdl);

                Nodes.positioningNodeNav(q155s1);

                Nodes.positioningNodeNav(q155wc2);

                Nodes.positioningNodeNav(q155em2);

                Nodes.positioningNodeNav(q155acq);

                Nodes.positioningNodeNav(q155em3);

                Nodes.positioningNodeNav(q155up);

                Nodes.positioningNodeNav(q155cesmi);

                Nodes.positioningNodeNav(q155bar);

                q155dicea.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155dicea);
                            nodeSelected = Nodes.getNameOfNode(q155dicea);

                            // unselected
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155r567.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155r567);
                            nodeSelected = Nodes.getNameOfNode(q155r567);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155r4.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155r4);
                            nodeSelected = Nodes.getNameOfNode(q155r4);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155r4d3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155r4d3);
                            nodeSelected = Nodes.getNameOfNode(q155r4d3);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155r23d2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155r23d2);
                            nodeSelected = Nodes.getNameOfNode(q155r23d2);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155rd1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155rd1);
                            nodeSelected = Nodes.getNameOfNode(q155rd1);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155wc1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155wc1);
                            nodeSelected = Nodes.getNameOfNode(q155wc1);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155u1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155u1);
                            nodeSelected = Nodes.getNameOfNode(q155u1);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155ecdl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155ecdl);
                            nodeSelected = Nodes.getNameOfNode(q155ecdl);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155s1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155s1);
                            nodeSelected = Nodes.getNameOfNode(q155s1);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155wc2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155wc2);
                            nodeSelected = Nodes.getNameOfNode(q155wc2);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155em2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155em2);
                            nodeSelected = Nodes.getNameOfNode(q155em2);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155acq.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155acq);
                            nodeSelected = Nodes.getNameOfNode(q155acq);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155em3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155em3);
                            nodeSelected = Nodes.getNameOfNode(q155em3);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155up.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155up);
                            nodeSelected = Nodes.getNameOfNode(q155up);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155cesmi);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155cesmi.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155cesmi);
                            nodeSelected = Nodes.getNameOfNode(q155cesmi);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155bar);
                        }
                        return false;
                    }
                });

                q155bar.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            Nodes.selectedNodeNav(q155bar);
                            nodeSelected = Nodes.getNameOfNode(q155bar);

                            // unselected
                            Nodes.unselectedNodeNav(q155dicea);
                            Nodes.unselectedNodeNav(q155r567);
                            Nodes.unselectedNodeNav(q155r4);
                            Nodes.unselectedNodeNav(q155r4d3);
                            Nodes.unselectedNodeNav(q155r23d2);
                            Nodes.unselectedNodeNav(q155rd1);
                            Nodes.unselectedNodeNav(q155wc1);
                            Nodes.unselectedNodeNav(q155u1);
                            Nodes.unselectedNodeNav(q155ecdl);
                            Nodes.unselectedNodeNav(q155s1);
                            Nodes.unselectedNodeNav(q155wc2);
                            Nodes.unselectedNodeNav(q155em2);
                            Nodes.unselectedNodeNav(q155acq);
                            Nodes.unselectedNodeNav(q155em3);
                            Nodes.unselectedNodeNav(q155up);
                            Nodes.unselectedNodeNav(q155cesmi);
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
                MapFinalActivity.this.finish();
                break;
            case R.id.forward:
                Intent nextPage = new Intent(this, NavigationActivity.class);
                nextPage.putExtra("initPos", initPos);
                nextPage.putExtra("finalPos", nodeSelected);
                startActivity(nextPage);
                break;
            case android.R.id.home: // Id relativo alla freccia in alto a sinistra, per tornare alla schermata precedente
                NavUtils.navigateUpFromSameTask(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
