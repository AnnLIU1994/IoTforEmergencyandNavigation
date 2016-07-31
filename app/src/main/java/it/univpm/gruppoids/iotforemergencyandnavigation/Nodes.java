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
}
