package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.res.Resources;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.common.detector.MathUtils;

/**
 * Created by hew dv67090el on 15/07/2016.
 */
public class Nodes {

    private static String id;
    private float x;
    private float y;
    private float width;

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
                coordsPercent[0] = 625;
                coordsPercent[1] = 688;
                break;
            case R.id.q145rg1:
                coordsPercent[0] = 625;
                coordsPercent[1] = 318;
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
        vertex.setImageResource(R.drawable.ic_node_unselected);
        vertex.setVisibility(View.VISIBLE);
        vertex.setX(getPosition(vertex.getId())[0]);
        vertex.setY(getPosition(vertex.getId())[1]);
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

    public static void unselectedNode(ImageView vertexUntouched) {
        vertexUntouched.setImageResource(R.drawable.ic_node_unselected);
        vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0]);
        vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1]);
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
        }
        return id;
    }
}
