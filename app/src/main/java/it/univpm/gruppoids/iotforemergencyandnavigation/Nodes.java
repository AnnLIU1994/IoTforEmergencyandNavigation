package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.common.detector.MathUtils;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.Node;

public class Nodes {

    private static String id;
    private String idd;
    private short x;
    private short y;
    private short z;
    private float width;
    private boolean stair;
    private boolean emergency;

    private static String activityName;

    //DbAdapter db;

    public Nodes (String id, short x, short y, short z, float width, boolean stair, boolean emergency) {
        this.idd = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.stair = stair;
        this.emergency = emergency;
    }

    /*public Nodes (String id) {
        this.id = id;
    }*/

    public void setX(short x) {
        this.x = x;
    }

    public void setY(short y) {
        this.y = y;
    }

    public void setZ(short z) {
        this.z = z;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setStair(boolean stair) {
        this.stair = stair;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public String getId() {
        return idd;
    }

    public short getX() {
        return x;
    }

    public short getY() {
        return y;
    }

    public short getZ() {
        return z;
    }

    public float getWidth() {
        return width;
    }

    public boolean getStair() {
        return stair;
    }

    public boolean getEmergency() {
        return emergency;
    }


    public static void positioningNode(ImageView vertex) {
        switch (vertex.getId()) {
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145wc1:
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_wc_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1] - 3);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 18);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a5:
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_lift_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1] - 3);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 29);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150bib:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emrl:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emr1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155up:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155u1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ram:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ea5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145em1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150em1:
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_exit_unselected);
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
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_node_unselected);
                vertex.setX(getPosition(vertex.getId())[0]);
                vertex.setY(getPosition(vertex.getId())[1]);
        }
        vertex.setVisibility(View.VISIBLE);
    }

    public static void positioningNodeNav(ImageView vertex) {
        switch (vertex.getId()) {
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145wc1:
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_wc_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1] - 3);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 18);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a5:
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_lift_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(getPosition(vertex.getId())[0] - 6);
                    vertex.setY(getPosition(vertex.getId())[1] - 3);
                } else {
                    vertex.setX(getPosition(vertex.getId())[0] - 29);
                    vertex.setY(getPosition(vertex.getId())[1] - 18);
                }
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150bib:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emrl:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emr1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155up:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155u1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ram:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ea5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145em1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150em1:
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_exit_unselected_nav);
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
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_node_unselected_nav);
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
        vertexTouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_node_selected);
        vertexTouched.setTranslationX(getTraslationPosition(vertexTouched.getId())[0]);
        vertexTouched.setTranslationY(getTraslationPosition(vertexTouched.getId())[1]);
        MapActivity.firstPage.setVisible(false);
        MapActivity.forward.setVisible(true);
    }

    public static void selectedNodeNav(ImageView vertexTouched) {
        vertexTouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_node_selected_nav);
        vertexTouched.setTranslationX(getTraslationPosition(vertexTouched.getId())[0]);
        vertexTouched.setTranslationY(getTraslationPosition(vertexTouched.getId())[1]);
        MapFinalActivity.firstPage.setVisible(false);
        MapFinalActivity.forward.setVisible(true);
    }

    public static void unselectedNode(ImageView vertexUntouched) {
        switch (vertexUntouched.getId()) {
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145wc1:
                vertexUntouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_wc_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 3);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 18);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a5:
                vertexUntouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_lift_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 3);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 29);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150bib:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emrl:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emr1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155up:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155u1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ram:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ea5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145em1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150em1:
                vertexUntouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_exit_unselected);
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
                vertexUntouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_node_unselected);
                vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0]);
                vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1]);
        }
    }

    public static void unselectedNodeNav(ImageView vertexUntouched) {
        switch (vertexUntouched.getId()) {
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145wc1:
                vertexUntouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_wc_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 3);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 18);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a5:
                vertexUntouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_lift_unselected_nav);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 6);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 3);
                } else {
                    vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0] - 29);
                    vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1] - 18);
                }
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema7:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150bib:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emrl:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emr1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155up:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155u1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ram:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema3:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ea5:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145em1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150em1:
                vertexUntouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_exit_unselected_nav);
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
                vertexUntouched.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_node_unselected_nav);
                vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0]);
                vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1]);
        }
    }

    public static String getNameOfNode(ImageView vertexTouched) {
        switch (vertexTouched.getId()) {
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145dicea: //TODO: da sostituire con db

                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145s1:
                id = "q145s1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145r3:
                id = "q145r3";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145r1:
                id = "q145r1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145wc1:
                id = "q145wc1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145s2:
                id = "q145s2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145s3:
                id = "q145s3";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145rg2:
                id = "q145rg2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145rg1:
                id = "q145rg1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema7:
                id = "q145ema7";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ea5:
                id = "q145ea5";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u1:
                id = "q145u1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a5:
                id = "q145a5";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145em1:
                id = "q145em1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg1:
                id = "q145emg1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg2:
                id = "q145emg2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u2:
                id = "q145u2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u3:
                id = "q145u3";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ram:
                id = "q145ram";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a3:
                id = "q145a3";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema3:
                id = "q145ema3";
                break;

            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150dicea1: //TODO: da sostituire con db
                id = "q150dicea1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150g1:
                id = "q150g1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150dicea:
                id = "q150dicea";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150strade:
                id = "q150strade";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150em1:
                id = "q150em1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150wc1:
                id = "q150wc1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150ram:
                id = "q150ram";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150g1g2:
                id = "q150g1g2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150g2:
                id = "q150g2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150r2:
                id = "q150r2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150s1:
                id = "q150s1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150r1:
                id = "q150r1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150rl:
                id = "q150rl";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a7:
                id = "q150a7";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a5:
                id = "q150a5";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a3:
                id = "q150a3";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150bib:
                id = "q150bib";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emrl:
                id = "q150emrl";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emr1:
                id = "q150emr1";
                break;

            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155dicea: //TODO: da sostituire con db
                id = "q155dicea";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155r567:
                id = "q155r567";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155r4:
                id = "q155r4";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155r4d3:
                id = "q155r4d3";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155r23d2:
                id = "q155r23d2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155rd1:
                id = "q155rd1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc1:
                id = "q155wc1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155u1:
                id = "q155u1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155ecdl:
                id = "q155ecdl";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155s1:
                id = "q155s1";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc2:
                id = "q155wc2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em2:
                id = "q155em2";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155acq:
                id = "q155acq";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em3:
                id = "q155em3";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155up:
                id = "q155up";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155cesmi:
                id = "q155cesmi";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155bar:
                id = "q155bar";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a7:
                id = "q155a7";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a5:
                id = "q155a5";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a3:
                id = "q155a3";
                break;
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em1:
                id = "q155em1";
                break;
        }
        return id;
    }

    public static int getNodeByName(String nameOfNode) {
        int idNode = 0;
        switch (nameOfNode) {
            case "q145dicea": //TODO: da sostituire con db
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145dicea;
                break;
            case "q145s1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145s1;
                break;
            case "q145r3":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145r3;
                break;
            case "q145r1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145r1;
                break;
            case "q145wc1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145wc1;
                break;
            case "q145s2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145s2;
                break;
            case "q145s3":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145s3;
                break;
            case "q145rg2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145rg2;
                break;
            case "q145rg1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145rg1;
                break;
            case "q145ema7":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema7;
                break;
            case "q145ea5":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ea5;
                break;
            case "q145u1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u1;
                break;
            case "q145a5":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a5;
                break;
            case "q145em1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145em1;
                break;
            case "q145emg1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg1;
                break;
            case "q145emg2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145emg2;
                break;
            case "q145u2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u2;
                break;
            case "q145u3":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145u3;
                break;
            case "q145ram":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ram;
                break;
            case "q145a3":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145a3;
                break;
            case "q145ema3":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145ema3;
                break;

            case "q150dicea1": //TODO: da sostituire con db
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150dicea1;
                break;
            case "q150g1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150g1;
                break;
            case "q150dicea":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150dicea;
                break;
            case "q150strade":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150strade;
                break;
            case "q150em1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150em1;
                break;
            case "q150wc1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150wc1;
                break;
            case "q150ram":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150ram;
                break;
            case "q150g1g2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150g1g2;
                break;
            case "q150g2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150g2;
                break;
            case "q150r2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150r2;
                break;
            case "q150s1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150s1;
                break;
            case "q150r1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150r1;
                break;
            case "q150rl":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150rl;
                break;
            case "q150a7":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a7;
                break;
            case "q150a5":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a5;
                break;
            case "q150a3":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150a3;
                break;
            case "q150bib":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150bib;
                break;
            case "q150emrl":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emrl;
                break;
            case "q150emr1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150emr1;
                break;

            case "q155dicea": //TODO: da sostituire con db
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155dicea;
                break;
            case "q155r567":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155r567;
                break;
            case "q155r4":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155r4;
                break;
            case "q155r4d3":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155r4d3;
                break;
            case "q155r23d2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155r23d2;
                break;
            case "q155rd1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155rd1;
                break;
            case "q155wc1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc1;
                break;
            case "q155u1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155u1;
                break;
            case "q155ecdl":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155ecdl;
                break;
            case "q155s1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155s1;
                break;
            case "q155wc2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc2;
                break;
            case "q155em2":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em2;
                break;
            case "q155acq":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155acq;
                break;
            case "q155em3":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em3;
                break;
            case "q155up":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155up;
                break;
            case "q155cesmi":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155cesmi;
                break;
            case "q155bar":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155bar;
                break;
            case "q155a7":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a7;
                break;
            case "q155a5":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a5;
                break;
            case "q155a3":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155a3;
                break;
            case "q155em1":
                idNode = it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155em1;
                break;
        }
        return idNode;
    }
}
