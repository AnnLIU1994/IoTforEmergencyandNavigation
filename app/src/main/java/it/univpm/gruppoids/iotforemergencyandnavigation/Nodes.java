package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.common.detector.MathUtils;

public class Nodes {

    private static String id;
    private float x;
    private float y;
    private float width;

    private static String activityName;

    public Nodes (float x, float y, float width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public Nodes (String id) {
        this.id = id;
    }

    private static int[] getCoordsPercent(int id) {
        int[] coordsPercent = {0, 0};
        switch (id) {
            case R.id.q145dicea: //TODO: da sostituire con db
                coordsPercent[0] = 413;
                coordsPercent[1] = 142;
                break;
            case R.id.q145s1:
                coordsPercent[0] = 413;
                coordsPercent[1] = 288;
                break;
            case R.id.q145r3:
                coordsPercent[0] = 413;
                coordsPercent[1] = 405;
                break;
            case R.id.q145r1:
                coordsPercent[0] = 413;
                coordsPercent[1] = 562;
                break;
            case R.id.q145wc1:
                coordsPercent[0] = 413;
                coordsPercent[1] = 688;
                break;
            case R.id.q145s2:
                coordsPercent[0] = 510;
                coordsPercent[1] = 688;
                break;
            case R.id.q145s3:
                coordsPercent[0] = 510;
                coordsPercent[1] = 790;
                break;
            case R.id.q145rg2:
                coordsPercent[0] = 605;
                coordsPercent[1] = 688;
                break;
            case R.id.q145rg1:
                coordsPercent[0] = 625;
                coordsPercent[1] = 318;
                break;
            case R.id.q145ema7:
                coordsPercent[0] = 413;
                coordsPercent[1] = 76;
                break;
            case R.id.q145em1:
                coordsPercent[0] = 255;
                coordsPercent[1] = 268;
                break;
            case R.id.q145u1:
                coordsPercent[0] = 661;
                coordsPercent[1] = 283;
                break;
            case R.id.q145emg1:
                coordsPercent[0] = 661;
                coordsPercent[1] = 472;
                break;
            case R.id.q145emg2:
                coordsPercent[0] = 661;
                coordsPercent[1] = 518;
                break;
            case R.id.q145u2:
                coordsPercent[0] = 660;
                coordsPercent[1] = 688;
                break;
            case R.id.q145ema3:
                coordsPercent[0] = 565;
                coordsPercent[1] = 797;
                break;
            case R.id.q145u3:
                coordsPercent[0] = 255;
                coordsPercent[1] = 668;
                break;
            case R.id.q145ram:
                coordsPercent[0] = 255;
                coordsPercent[1] = 716;
                break;
            case R.id.q145ea5:
                coordsPercent[0] = 741;
                coordsPercent[1] = 306;
                break;
            case R.id.q145a5:
                coordsPercent[0] = 718;
                coordsPercent[1] = 337;
                break;
            case R.id.q145a3:
                coordsPercent[0] = 554;
                coordsPercent[1] = 752;
                break;


            case R.id.q150dicea1: //TODO: da sostituire con db
                coordsPercent[0] = 346;
                coordsPercent[1] = 106;
                break;
            case R.id.q150g1:
                coordsPercent[0] = 346;
                coordsPercent[1] = 238;
                break;
            case R.id.q150dicea:
                coordsPercent[0] = 435;
                coordsPercent[1] = 256;
                break;
            case R.id.q150strade:
                coordsPercent[0] = 232;
                coordsPercent[1] = 238;
                break;
            case R.id.q150em1:
                coordsPercent[0] = 232;
                coordsPercent[1] = 331;
                break;
            case R.id.q150wc1:
                coordsPercent[0] = 232;
                coordsPercent[1] = 590;
                break;
            case R.id.q150ram:
                coordsPercent[0] = 232;
                coordsPercent[1] = 715;
                break;
            case R.id.q150g1g2:
                coordsPercent[0] = 346;
                coordsPercent[1] = 413;
                break;
            case R.id.q150g2:
                coordsPercent[0] = 346;
                coordsPercent[1] = 548;
                break;
            case R.id.q150r2:
                coordsPercent[0] = 405;
                coordsPercent[1] = 590;
                break;
            case R.id.q150s1:
                coordsPercent[0] = 473;
                coordsPercent[1] = 736;
                break;
            case R.id.q150r1:
                coordsPercent[0] = 595;
                coordsPercent[1] = 755;
                break;
            case R.id.q150rl:
                coordsPercent[0] = 595;
                coordsPercent[1] = 715;
                break;
            case R.id.q150bib:
                coordsPercent[0] = 100;
                coordsPercent[1] = 802;
                break;
            case R.id.q150emrl:
                coordsPercent[0] = 782;
                coordsPercent[1] = 658;
                break;
            case R.id.q150emr1:
                coordsPercent[0] = 782;
                coordsPercent[1] = 707;
                break;
            case R.id.q150a7:
                coordsPercent[0] = 346;
                coordsPercent[1] = 36;
                break;
            case R.id.q150a5:
                coordsPercent[0] = 595;
                coordsPercent[1] = 278;
                break;
            case R.id.q150a3:
                coordsPercent[0] = 470;
                coordsPercent[1] = 635;
                break;

            case R.id.q155dicea: //TODO: da sostituire con db
                coordsPercent[0] = 485;
                coordsPercent[1] = 230;
                break;
            case R.id.q155r567:
                coordsPercent[0] = 510;
                coordsPercent[1] = 271;
                break;
            case R.id.q155r4:
                coordsPercent[0] = 510;
                coordsPercent[1] = 335;
                break;
            case R.id.q155r4d3:
                coordsPercent[0] = 510;
                coordsPercent[1] = 385;
                break;
            case R.id.q155r23d2:
                coordsPercent[0] = 510;
                coordsPercent[1] = 463;
                break;
            case R.id.q155rd1:
                coordsPercent[0] = 510;
                coordsPercent[1] = 521;
                break;
            case R.id.q155wc1:
                coordsPercent[0] = 510;
                coordsPercent[1] = 587;
                break;
            case R.id.q155u1:
                coordsPercent[0] = 369;
                coordsPercent[1] = 610;
                break;
            case R.id.q155ecdl:
                coordsPercent[0] = 565;
                coordsPercent[1] = 645;
                break;
            case R.id.q155s1:
                coordsPercent[0] = 369;
                coordsPercent[1] = 695;
                break;
            case R.id.q155wc2:
                coordsPercent[0] = 584;
                coordsPercent[1] = 708;
                break;
            case R.id.q155em2:
                coordsPercent[0] = 369;
                coordsPercent[1] = 740;
                break;
            case R.id.q155acq:
                coordsPercent[0] = 369;
                coordsPercent[1] = 792;
                break;
            case R.id.q155em3:
                coordsPercent[0] = 296;
                coordsPercent[1] = 795;
                break;
            case R.id.q155up:
                coordsPercent[0] = 223;
                coordsPercent[1] = 798;
                break;
            case R.id.q155cesmi:
                coordsPercent[0] = 584;
                coordsPercent[1] = 789;
                break;
            case R.id.q155bar:
                coordsPercent[0] = 690;
                coordsPercent[1] = 779;
                break;
            case R.id.q155em1:
                coordsPercent[0] = 345;
                coordsPercent[1] = 335;
                break;
            case R.id.q155a7:
                coordsPercent[0] = 483;
                coordsPercent[1] = 25;
                break;
            case R.id.q155a5:
                coordsPercent[0] = 750;
                coordsPercent[1] = 279;
                break;
            case R.id.q155a3:
                coordsPercent[0] = 613;
                coordsPercent[1] = 648;
                break;
        }
        return coordsPercent;
    }

    private static int[] getPosition(int id) {
        int[] position = {0, 0};
        int x;
        int y;
        int widthScreen = Resources.getSystem().getDisplayMetrics().widthPixels;
        int heightScreen = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
            x = getCoordsPercent(id)[0] - 8;
            y = getCoordsPercent(id)[1] - 28;
        } else {
            x = getCoordsPercent(id)[0];
            y = getCoordsPercent(id)[1];
        }
        position[0] = MathUtils.round((widthScreen * x)/1000);
        position[1] = MathUtils.round((heightScreen * y)/1000);
        return position;
    }

    public static void positioningNode(ImageView vertex) {
        switch (vertex.getId()) {
            case R.id.q155wc2:
            case R.id.q155wc1:
            case R.id.q150wc1:
            case R.id.q145wc1:
                vertex.setImageResource(R.drawable.ic_wc_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1] - 3);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 18);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            case R.id.q155a5:
            case R.id.q155a3:
            case R.id.q155a7:
            case R.id.q150a3:
            case R.id.q150a5:
            case R.id.q150a7:
            case R.id.q145a3:
            case R.id.q145a5:
                vertex.setImageResource(R.drawable.ic_lift_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1] - 3);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 29);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            case R.id.q145ema7:
            case R.id.q150bib:
            case R.id.q150emrl:
            case R.id.q150emr1:
            case R.id.q155up:
            case R.id.q155em3:
            case R.id.q155em2:
            case R.id.q155u1:
            case R.id.q155em1:
            case R.id.q145ram:
            case R.id.q145u3:
            case R.id.q145ema3:
            case R.id.q145u2:
            case R.id.q145emg2:
            case R.id.q145emg1:
            case R.id.q145u1:
            case R.id.q145ea5:
            case R.id.q145em1:
            case R.id.q150em1:
                vertex.setImageResource(R.drawable.ic_exit_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1]);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 18);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            default:
                vertex.setImageResource(R.drawable.ic_node_unselected);
                vertex.setX(getPosition(vertex.getId())[0]);
                vertex.setY(getPosition(vertex.getId())[1]);
        }
        vertex.setVisibility(View.VISIBLE);
    }

    public static void positioningNodeNav(ImageView vertex) {
        switch (vertex.getId()) {
            case R.id.q155wc2:
            case R.id.q155wc1:
            case R.id.q150wc1:
            case R.id.q145wc1:
                vertex.setImageResource(R.drawable.ic_wc_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1] - 3);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 18);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            case R.id.q155a5:
            case R.id.q155a3:
            case R.id.q155a7:
            case R.id.q150a3:
            case R.id.q150a5:
            case R.id.q150a7:
            case R.id.q145a3:
            case R.id.q145a5:
                vertex.setImageResource(R.drawable.ic_lift_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1] - 3);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 29);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            case R.id.q145ema7:
            case R.id.q150bib:
            case R.id.q150emrl:
            case R.id.q150emr1:
            case R.id.q155up:
            case R.id.q155em3:
            case R.id.q155em2:
            case R.id.q155u1:
            case R.id.q155em1:
            case R.id.q145ram:
            case R.id.q145u3:
            case R.id.q145ema3:
            case R.id.q145u2:
            case R.id.q145emg2:
            case R.id.q145emg1:
            case R.id.q145u1:
            case R.id.q145ea5:
            case R.id.q145em1:
            case R.id.q150em1:
                vertex.setImageResource(R.drawable.ic_exit_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1]);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 18);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            default:
                vertex.setImageResource(R.drawable.ic_node_unselected_nav);
                vertex.setX(getPosition(vertex.getId())[0]);
                vertex.setY(getPosition(vertex.getId())[1]);
        }
        vertex.setVisibility(View.VISIBLE);
    }

    private static int[] getTraslationPosition(int id) {
        int[] traslationPosition = {0, 0};
        int xTrasl;
        int yTrasl;
        int widthScreen = Resources.getSystem().getDisplayMetrics().widthPixels;
        int heightScreen = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
            xTrasl = getCoordsPercent(id)[0] - 33; // 8 + 25
            yTrasl = getCoordsPercent(id)[1] - 65; // 28 + 37
        } else {
            xTrasl = getCoordsPercent(id)[0] - 25;
            yTrasl = getCoordsPercent(id)[1] - 37;
        }
        traslationPosition[0] = MathUtils.round((widthScreen * xTrasl)/1000);
        traslationPosition[1] = MathUtils.round((heightScreen * yTrasl)/1000);
        return traslationPosition;
    }

    public static void selectedNode(ImageView vertexTouched) {
        vertexTouched.setImageResource(R.drawable.ic_node_selected);
        vertexTouched.setTranslationX(getTraslationPosition(vertexTouched.getId())[0]);
        vertexTouched.setTranslationY(getTraslationPosition(vertexTouched.getId())[1]);
        MapActivity.firstPage.setVisible(false);
        MapActivity.forward.setVisible(true);
    }

    public static void selectedNodeNav(ImageView vertexTouched) {
        vertexTouched.setImageResource(R.drawable.ic_node_selected_nav);
        vertexTouched.setTranslationX(getTraslationPosition(vertexTouched.getId())[0]);
        vertexTouched.setTranslationY(getTraslationPosition(vertexTouched.getId())[1]);
        MapFinalActivity.firstPage.setVisible(false);
        MapFinalActivity.forward.setVisible(true);
    }

    public static void unselectedNode(ImageView vertexUntouched) {
        switch (vertexUntouched.getId()) {
            case R.id.q155wc2:
            case R.id.q155wc1:
            case R.id.q150wc1:
            case R.id.q145wc1:
                vertexUntouched.setImageResource(R.drawable.ic_wc_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 3);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 18);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            case R.id.q155a5:
            case R.id.q155a3:
            case R.id.q155a7:
            case R.id.q150a3:
            case R.id.q150a5:
            case R.id.q150a7:
            case R.id.q145a3:
            case R.id.q145a5:
                vertexUntouched.setImageResource(R.drawable.ic_lift_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 3);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 29);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            case R.id.q145ema7:
            case R.id.q150bib:
            case R.id.q150emrl:
            case R.id.q150emr1:
            case R.id.q155up:
            case R.id.q155em3:
            case R.id.q155em2:
            case R.id.q155u1:
            case R.id.q155em1:
            case R.id.q145ram:
            case R.id.q145u3:
            case R.id.q145ema3:
            case R.id.q145u2:
            case R.id.q145emg2:
            case R.id.q145emg1:
            case R.id.q145u1:
            case R.id.q145ea5:
            case R.id.q145em1:
            case R.id.q150em1:
                vertexUntouched.setImageResource(R.drawable.ic_exit_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1]);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 18);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            default:
                vertexUntouched.setImageResource(R.drawable.ic_node_unselected);
                vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0]);
                vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1]);
        }
    }

    public static void unselectedNodeNav(ImageView vertexUntouched) {
        switch (vertexUntouched.getId()) {
            case R.id.q155wc2:
            case R.id.q155wc1:
            case R.id.q150wc1:
            case R.id.q145wc1:
                vertexUntouched.setImageResource(R.drawable.ic_wc_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 3);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 18);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            case R.id.q155a5:
            case R.id.q155a3:
            case R.id.q155a7:
            case R.id.q150a3:
            case R.id.q150a5:
            case R.id.q150a7:
            case R.id.q145a3:
            case R.id.q145a5:
                vertexUntouched.setImageResource(R.drawable.ic_lift_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 3);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 29);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            case R.id.q145ema7:
            case R.id.q150bib:
            case R.id.q150emrl:
            case R.id.q150emr1:
            case R.id.q155up:
            case R.id.q155em3:
            case R.id.q155em2:
            case R.id.q155u1:
            case R.id.q155em1:
            case R.id.q145ram:
            case R.id.q145u3:
            case R.id.q145ema3:
            case R.id.q145u2:
            case R.id.q145emg2:
            case R.id.q145emg1:
            case R.id.q145u1:
            case R.id.q145ea5:
            case R.id.q145em1:
            case R.id.q150em1:
                vertexUntouched.setImageResource(R.drawable.ic_exit_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1]);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 18);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            default:
                vertexUntouched.setImageResource(R.drawable.ic_node_unselected_nav);
                vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0]);
                vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1]);
        }
    }

    public static String getNameOfNode(ImageView vertexTouched) {
        switch (vertexTouched.getId()) {
            case R.id.q145dicea: //TODO: da sostituire con db
                id = "q145dicea";
                break;
            case R.id.q145s1:
                id = "q145s1";
                break;
            case R.id.q145r3:
                id = "q145r3";
                break;
            case R.id.q145r1:
                id = "q145r1";
                break;
            case R.id.q145wc1:
                id = "q145wc1";
                break;
            case R.id.q145s2:
                id = "q145s2";
                break;
            case R.id.q145s3:
                id = "q145s3";
                break;
            case R.id.q145rg2:
                id = "q145rg2";
                break;
            case R.id.q145rg1:
                id = "q145rg1";
                break;
            case R.id.q145ema7:
                id = "q145ema7";
                break;
            case R.id.q145ea5:
                id = "q145ea5";
                break;
            case R.id.q145u1:
                id = "q145u1";
                break;
            case R.id.q145a5:
                id = "q145a5";
                break;
            case R.id.q145em1:
                id = "q145em1";
                break;
            case R.id.q145emg1:
                id = "q145emg1";
                break;
            case R.id.q145emg2:
                id = "q145emg2";
                break;
            case R.id.q145u2:
                id = "q145u2";
                break;
            case R.id.q145u3:
                id = "q145u3";
                break;
            case R.id.q145ram:
                id = "q145ram";
                break;
            case R.id.q145a3:
                id = "q145a3";
                break;
            case R.id.q145ema3:
                id = "q145ema3";
                break;

            case R.id.q150dicea1: //TODO: da sostituire con db
                id = "q150dicea1";
                break;
            case R.id.q150g1:
                id = "q150g1";
                break;
            case R.id.q150dicea:
                id = "q150dicea";
                break;
            case R.id.q150strade:
                id = "q150strade";
                break;
            case R.id.q150em1:
                id = "q150em1";
                break;
            case R.id.q150wc1:
                id = "q150wc1";
                break;
            case R.id.q150ram:
                id = "q150ram";
                break;
            case R.id.q150g1g2:
                id = "q150g1g2";
                break;
            case R.id.q150g2:
                id = "q150g2";
                break;
            case R.id.q150r2:
                id = "q150r2";
                break;
            case R.id.q150s1:
                id = "q150s1";
                break;
            case R.id.q150r1:
                id = "q150r1";
                break;
            case R.id.q150rl:
                id = "q150rl";
                break;
            case R.id.q150a7:
                id = "q150a7";
                break;
            case R.id.q150a5:
                id = "q150a5";
                break;
            case R.id.q150a3:
                id = "q150a3";
                break;
            case R.id.q150bib:
                id = "q150bib";
                break;
            case R.id.q150emrl:
                id = "q150emrl";
                break;
            case R.id.q150emr1:
                id = "q150emr1";
                break;

            case R.id.q155dicea: //TODO: da sostituire con db
                id = "q155dicea";
                break;
            case R.id.q155r567:
                id = "q155r567";
                break;
            case R.id.q155r4:
                id = "q155r4";
                break;
            case R.id.q155r4d3:
                id = "q155r4d3";
                break;
            case R.id.q155r23d2:
                id = "q155r23d2";
                break;
            case R.id.q155rd1:
                id = "q155rd1";
                break;
            case R.id.q155wc1:
                id = "q155wc1";
                break;
            case R.id.q155u1:
                id = "q155u1";
                break;
            case R.id.q155ecdl:
                id = "q155ecdl";
                break;
            case R.id.q155s1:
                id = "q155s1";
                break;
            case R.id.q155wc2:
                id = "q155wc2";
                break;
            case R.id.q155em2:
                id = "q155em2";
                break;
            case R.id.q155acq:
                id = "q155acq";
                break;
            case R.id.q155em3:
                id = "q155em3";
                break;
            case R.id.q155up:
                id = "q155up";
                break;
            case R.id.q155cesmi:
                id = "q155cesmi";
                break;
            case R.id.q155bar:
                id = "q155bar";
                break;
            case R.id.q155a7:
                id = "q155a7";
                break;
            case R.id.q155a5:
                id = "q155a5";
                break;
            case R.id.q155a3:
                id = "q155a3";
                break;
            case R.id.q155em1:
                id = "q155em1";
                break;
        }
        return id;
    }
}
