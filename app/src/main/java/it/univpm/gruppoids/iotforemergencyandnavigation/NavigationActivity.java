package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.CalculateRouteProgressFragment;
import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.ChangeUpPlanProgressFragment;
import it.univpm.gruppoids.iotforemergencyandnavigation.fragments.TerminateNavigationDialogFragment;

public class NavigationActivity extends AppCompatActivity implements TerminateNavigationDialogFragment.AlertDialogListener {

    private static final String TERMINATE_NAV_DIALOG_TAG = "TERMINATE_NAV_DIALOG";

    private static final String CALCULATE_ROUTE_PROGRESS_TAG = "CALCULATE_ROUTE_PROGRESS";

    private static final String CHANGE_PLAN_PROGRESS_TAG = "CHANGE_PLAN_PROGRESS";

    public static String initPos, finalPos;
    static int initFloor;
    static int finalFloor;
    ImageView navMap;
    MenuItem updatePos;

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

    private ImageView initNode;
    private ImageView finalNode;
    private ImageView stairNode;

    private String nodeSelected;

    private long mStartTime;
    private static final int ROUTE_CALCULATE_WHAT = 0;
    private static final int CHANGE_WHAT = 1;
    private static final long WAIT_INTERVAL_ROUTE = 1500L;
    private static final long WAIT_INTERVAL_CHANGE = 1500L;

    private CalculateRouteProgressFragment progressCalculateRoute;
    private ChangeUpPlanProgressFragment progressChangePlan;

    private Handler mHandler = new Handler() { // Permette la gestione dell'activity

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case ROUTE_CALCULATE_WHAT:
                    long elapsedTime = SystemClock.uptimeMillis() - mStartTime;
                    if (elapsedTime >= WAIT_INTERVAL_ROUTE) {
                        progressCalculateRoute.dismiss();
                    }
                    break;
                case CHANGE_WHAT:
                    long elapsedTimeChange = SystemClock.uptimeMillis() - mStartTime;
                    if (elapsedTimeChange >= WAIT_INTERVAL_CHANGE) {
                        progressChangePlan.dismiss();

                        Intent changeIntent = new Intent(getApplicationContext(), NavigationChangeActivity.class);
                        changeIntent.putExtra("finalFloor", finalFloor);
                        changeIntent.putExtra("finalPos", finalPos);
                        changeIntent.putExtra("stairId", finalNode.getId());
                        startActivity(changeIntent);
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mStartTime = SystemClock.uptimeMillis();
        progressCalculateRoute = new CalculateRouteProgressFragment();
        progressCalculateRoute.show(getSupportFragmentManager(), CALCULATE_ROUTE_PROGRESS_TAG);
        final Message goMainMessage = mHandler.obtainMessage(ROUTE_CALCULATE_WHAT);
        mHandler.sendMessageAtTime(goMainMessage, mStartTime + WAIT_INTERVAL_ROUTE);

        Intent inputIntent = getIntent();
        initPos = inputIntent.getStringExtra("initPos");
        finalPos = inputIntent.getStringExtra("finalPos");
        initFloor = inputIntent.getIntExtra("initFloor", 0);
        finalFloor = inputIntent.getIntExtra("finalFloor", 0);
        String floorString = Integer.toString(initFloor);

        Toast.makeText(getApplicationContext(), "The initial position is " + initPos + " at " + initFloor + ". The final position is " + finalPos + " at " + finalFloor, Toast.LENGTH_LONG).show();

        navMap = (ImageView) findViewById(R.id.navi_map);

        if (initFloor != 0) {
            getSupportActionBar().setTitle(getResources().getString(R.string.floor_pos) + " " + floorString);
        }

        switch (initFloor) {
            case 145:
                navMap.setImageResource(R.drawable.q145);

                /*q145ema7 = (ImageView) findViewById(R.id.q145ema7);

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

                q145a3 = (ImageView) findViewById(R.id.q145a3);*/


                /*Nodes.positioningNodeNavRouting(q145ema7);

                Nodes.positioningNodeNavRouting(q145em1);

                Nodes.positioningNodeNavRouting(q145u1);

                Nodes.positioningNodeNavRouting(q145emg1);

                Nodes.positioningNodeNavRouting(q145emg2);

                Nodes.positioningNodeNavRouting(q145u2);

                Nodes.positioningNodeNavRouting(q145ema3);

                Nodes.positioningNodeNavRouting(q145u3);

                Nodes.positioningNodeNavRouting(q145ram);

                Nodes.positioningNodeNavRouting(q145dicea);

                Nodes.positioningNodeNavRouting(q145s1);

                Nodes.positioningNodeNavRouting(q145r3);

                Nodes.positioningNodeNavRouting(q145r1);

                Nodes.positioningNodeNavRouting(q145wc1);

                Nodes.positioningNodeNavRouting(q145s2);

                Nodes.positioningNodeNavRouting(q145s3);

                Nodes.positioningNodeNavRouting(q145rg2);

                Nodes.positioningNodeNavRouting(q145rg1);

                Nodes.positioningNodeNavRouting(q145ea5);

                Nodes.positioningNodeNavRouting(q145a5);

                Nodes.positioningNodeNavRouting(q145a3);*/

                if (initFloor == 145) {
                    initNode = (ImageView) findViewById(Nodes.getNodeByName(initPos));
                    Nodes.positioningNodeNav(initNode);
                }

                if (finalFloor == 145) {
                    finalNode = (ImageView) findViewById(Nodes.getNodeByName(finalPos));
                    Nodes.positioningNodeNav(finalNode);
                } else {
                    switch (initPos) {
                        case "q145dicea": //TODO: da sostituire con db
                            finalNode = (ImageView) findViewById(R.id.q145ema7);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145s1":
                            finalNode = (ImageView) findViewById(R.id.q145a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145r3":
                            finalNode = (ImageView) findViewById(R.id.q145ema7);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145r1":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145wc1":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145s2":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145s3":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145rg2":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145rg1":
                            finalNode = (ImageView) findViewById(R.id.q145a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145ema7":
                            //TODO:
                            break;
                        case "q145ea5":
                            finalNode = (ImageView) findViewById(R.id.q145a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145u1":
                            finalNode = (ImageView) findViewById(R.id.q145a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145a5":
                            //TODO:
                            break;
                        case "q145em1":
                            finalNode = (ImageView) findViewById(R.id.q145ema7);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145emg1":
                            finalNode = (ImageView) findViewById(R.id.q145a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145emg2":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145u2":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145u3":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145ram":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q145a3":
                            //TODO:
                            break;
                        case "q145ema3":
                            finalNode = (ImageView) findViewById(R.id.q145a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                    }

                    finalNode.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            mStartTime = SystemClock.uptimeMillis();
                            progressChangePlan = new ChangeUpPlanProgressFragment();
                            progressChangePlan.show(getSupportFragmentManager(), CHANGE_PLAN_PROGRESS_TAG);
                            final Message goMainMessage = mHandler.obtainMessage(CHANGE_WHAT);
                            mHandler.sendMessageAtTime(goMainMessage, mStartTime + WAIT_INTERVAL_CHANGE);
                            return false;
                        }
                    });
                }

                Paint paint = new Paint();
                paint.setColor(getResources().getColor(R.color.colorBlue));
                paint.setStrokeWidth(25);
                paint.setStyle(Paint.Style.FILL);

                Bitmap bmp = Bitmap.createBitmap(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels, Bitmap.Config.ARGB_8888);

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.q145);

                Canvas canvas = new Canvas(bmp);//TODO: sistemare posizionamento linea
                canvas.drawLine(initNode.getX(), initNode.getY(), finalNode.getX(), finalNode.getY(), paint);

                ImageView edge = (ImageView) findViewById(R.id.edge);
                edge.setImageBitmap(bmp);

                /*q145ema7.setOnTouchListener(new View.OnTouchListener() {
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
                });*/
                break;
            case 150:
                navMap.setImageResource(R.drawable.q150);

                /*q150dicea1 = (ImageView) findViewById(R.id.q150dicea1);

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

                q150a3 = (ImageView) findViewById(R.id.q150a3);*/

                /*Nodes.positioningNodeNavRouting(q150dicea1);

                Nodes.positioningNodeNavRouting(q150g1);

                Nodes.positioningNodeNavRouting(q150dicea);

                Nodes.positioningNodeNavRouting(q150strade);

                Nodes.positioningNodeNavRouting(q150em1);

                Nodes.positioningNodeNavRouting(q150wc1);

                Nodes.positioningNodeNavRouting(q150ram);

                Nodes.positioningNodeNavRouting(q150g1g2);

                Nodes.positioningNodeNavRouting(q150g2);

                Nodes.positioningNodeNavRouting(q150r2);

                Nodes.positioningNodeNavRouting(q150s1);

                Nodes.positioningNodeNavRouting(q150r1);

                Nodes.positioningNodeNavRouting(q150rl);

                Nodes.positioningNodeNavRouting(q150bib);

                Nodes.positioningNodeNavRouting(q150emrl);

                Nodes.positioningNodeNavRouting(q150emr1);

                Nodes.positioningNodeNavRouting(q150a7);

                Nodes.positioningNodeNavRouting(q150a5);

                Nodes.positioningNodeNavRouting(q150a3);*/

                if (initFloor == 150) {
                    initNode = (ImageView) findViewById(Nodes.getNodeByName(initPos));
                    Nodes.positioningNodeNav(initNode);
                }

                if (finalFloor == 150) {
                    finalNode = (ImageView) findViewById(Nodes.getNodeByName(finalPos));
                    Nodes.positioningNodeNav(finalNode);
                } else {
                    switch (initPos) {
                        case "q150dicea1": //TODO: da sostituire con db
                            finalNode = (ImageView) findViewById(R.id.q150a7);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150g1":
                            finalNode = (ImageView) findViewById(R.id.q150a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150dicea":
                            finalNode = (ImageView) findViewById(R.id.q150a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150strade":
                            finalNode = (ImageView) findViewById(R.id.q150a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150em1":
                            finalNode = (ImageView) findViewById(R.id.q150a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150wc1":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150ram":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150g1g2":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150g2":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150r2":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150s1":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150r1":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150rl":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150a7":
                            //TODO:
                            break;
                        case "q150a5":
                            //TODO:
                            break;
                        case "q150a3":
                            //TODO:
                            break;
                        case "q150bib":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150emrl":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q150emr1":
                            finalNode = (ImageView) findViewById(R.id.q150a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                    }

                    finalNode.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            mStartTime = SystemClock.uptimeMillis();
                            progressChangePlan = new ChangeUpPlanProgressFragment();
                            progressChangePlan.show(getSupportFragmentManager(), CHANGE_PLAN_PROGRESS_TAG);
                            final Message goMainMessage = mHandler.obtainMessage(CHANGE_WHAT);
                            mHandler.sendMessageAtTime(goMainMessage, mStartTime + WAIT_INTERVAL_CHANGE);
                            return false;
                        }
                    });
                }

                /*q150dicea1.setOnTouchListener(new View.OnTouchListener() {
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
                });*/
                break;
            case 155:
                navMap.setImageResource(R.drawable.q155);

                /*q155dicea = (ImageView) findViewById(R.id.q155dicea);

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

                q155a3 = (ImageView) findViewById(R.id.q155a3);*/

                /*Nodes.positioningNodeNavRouting(q155dicea);

                Nodes.positioningNodeNavRouting(q155r567);

                Nodes.positioningNodeNavRouting(q155r4);

                Nodes.positioningNodeNavRouting(q155r4d3);

                Nodes.positioningNodeNavRouting(q155r23d2);

                Nodes.positioningNodeNavRouting(q155rd1);

                Nodes.positioningNodeNavRouting(q155wc1);

                Nodes.positioningNodeNavRouting(q155u1);

                Nodes.positioningNodeNavRouting(q155ecdl);

                Nodes.positioningNodeNavRouting(q155s1);

                Nodes.positioningNodeNavRouting(q155wc2);

                Nodes.positioningNodeNavRouting(q155em2);

                Nodes.positioningNodeNavRouting(q155acq);

                Nodes.positioningNodeNavRouting(q155em3);

                Nodes.positioningNodeNavRouting(q155up);

                Nodes.positioningNodeNavRouting(q155cesmi);

                Nodes.positioningNodeNavRouting(q155bar);

                Nodes.positioningNodeNavRouting(q155em1);

                Nodes.positioningNodeNavRouting(q155a7);

                Nodes.positioningNodeNavRouting(q155a5);

                Nodes.positioningNodeNavRouting(q155a3);*/

                if (initFloor == 155) {
                    initNode = (ImageView) findViewById(Nodes.getNodeByName(initPos));
                    Nodes.positioningNodeNav(initNode);
                }

                if (finalFloor == 155) {
                    finalNode = (ImageView) findViewById(Nodes.getNodeByName(finalPos));
                    Nodes.positioningNodeNav(finalNode);
                } else {
                    switch (initPos) {
                        case "q155dicea": //TODO: da sostituire con db
                            finalNode = (ImageView) findViewById(R.id.q155a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155r567":
                            finalNode = (ImageView) findViewById(R.id.q155a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155r4":
                            finalNode = (ImageView) findViewById(R.id.q155a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155r4d3":
                            finalNode = (ImageView) findViewById(R.id.q155a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155r23d2":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155rd1":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155wc1":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155u1":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155ecdl":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155s1":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155wc2":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155em2":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155acq":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155em3":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155up":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155cesmi":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155bar":
                            finalNode = (ImageView) findViewById(R.id.q155a3);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                        case "q155a7":
                            //TODO:
                            break;
                        case "q155a5":
                            //TODO:
                            break;
                        case "q155a3":
                            //TODO
                            break;
                        case "q155em1":
                            finalNode = (ImageView) findViewById(R.id.q155a5);
                            Nodes.positioningNodeNav(finalNode);
                            break;
                    }

                    finalNode.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            //TODO: al touch il nodo diventa l'indicatore e gli altri no
                            mStartTime = SystemClock.uptimeMillis();
                            progressChangePlan = new ChangeUpPlanProgressFragment();
                            progressChangePlan.show(getSupportFragmentManager(), CHANGE_PLAN_PROGRESS_TAG);
                            final Message goMainMessage = mHandler.obtainMessage(CHANGE_WHAT);
                            mHandler.sendMessageAtTime(goMainMessage, mStartTime + WAIT_INTERVAL_CHANGE);
                            return false;
                        }
                    });
                }

                /*q155dicea.setOnTouchListener(new View.OnTouchListener() {
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
                });*/
                break;
        }
    }

    @Override
    public void onBackPressed() {
        TerminateNavigationDialogFragment alertDialog = new TerminateNavigationDialogFragment();
        alertDialog.show(getSupportFragmentManager(), TERMINATE_NAV_DIALOG_TAG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);

        MenuItem firstPage = menu.findItem(R.id.firstPage);
        firstPage.setVisible(false);

        updatePos = menu.findItem(R.id.updatePos);
        if (nodeSelected != null) {
            updatePos.setVisible(true);
        }

        MenuItem exit = menu.findItem(R.id.exit);
        exit.setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home: // Id relativo alla freccia in alto a sinistra, per tornare alla schermata precedente
                finish();
                return true;
            case R.id.updatePos:
                Toast.makeText(getApplicationContext(), "Position is updated", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                TerminateNavigationDialogFragment alertDialog = new TerminateNavigationDialogFragment();
                alertDialog.show(getSupportFragmentManager(), TERMINATE_NAV_DIALOG_TAG);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public static String differencePlan() {
        int difference;
        if ((initFloor == 145 & finalFloor == 155) | (finalFloor == 145 & initFloor == 155))
            difference = 2;
        else
            difference = 1;
        return Integer.toString(difference);
    }

    public static boolean isGoUp() {
        boolean goUp;
        if ((initFloor == 145 & (finalFloor == 150 | finalFloor == 155)) | (initFloor == 150 & finalFloor == 155))
            return goUp = true;
        else
            return goUp = false;
    }

    private void goInitPos() {
        Intent intent = new Intent(this, InitPositionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void yesPressed() {
        goInitPos();
    }

    @Override
    public void noPressed() {

    }
}
