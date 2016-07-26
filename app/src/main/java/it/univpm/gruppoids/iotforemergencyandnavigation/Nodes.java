package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.res.Resources;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.common.detector.MathUtils;

/**
 * Created by hew dv67090el on 15/07/2016.
 */
public class Nodes {

    private String id;
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
            case R.id.q145dicea:
                coordsPercent[0] = 413;
                coordsPercent[1] = 142;
                break;
            case R.id.q145s1:
                coordsPercent[0] = 413;
                coordsPercent[1] = 288;
                break;
        }
        return coordsPercent;
    }

    private static int[] getPosition(int id) {
        int[] position = {0, 0};
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        position[0] = MathUtils.round((width * getCoordsPercent(id)[0])/1000);
        position[1] = MathUtils.round((height * getCoordsPercent(id)[1])/1000);
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
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        int xTrasl = getCoordsPercent(id)[0] - 25;
        int yTrasl = getCoordsPercent(id)[1] - 37;
        traslationPosition[0] = MathUtils.round((width * xTrasl)/1000);
        traslationPosition[1] = MathUtils.round((height * yTrasl)/1000);
        return traslationPosition;
    }

    public static void onTouchNode(ImageView vertexTouched) {
        vertexTouched.setImageResource(R.drawable.ic_node_selected);
        vertexTouched.setTranslationX(getTraslationPosition(vertexTouched.getId())[0]);
        vertexTouched.setTranslationY(getTraslationPosition(vertexTouched.getId())[1]);
        MapActivity.insertPos.setVisibility(View.VISIBLE);
    }

    public static int getXTranslatePosition(String id) {
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int x = 0;
        switch (id) {
            case "q145dicea":
                x = 395;
                break;
        }
        float xPerc = (width * x)/1000;
        return MathUtils.round(xPerc);
    }

    public static int getYTranslatePosition(String id) {
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        int y = 0;
        switch (id) {
            case "q145dicea":
                y = 113;
                break;
        }
        float yPerc = (height * y)/1000;
        return MathUtils.round(yPerc);
    }

}
