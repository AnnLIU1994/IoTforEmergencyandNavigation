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
                coordsPercent[0] = 625;
                coordsPercent[1] = 688;
                break;
            case R.id.q145rg1:
                coordsPercent[0] = 625;
                coordsPercent[1] = 318;
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

    public static void positioningNodeNav(ImageView vertex) {
        vertex.setImageResource(R.drawable.ic_node_unselected_nav);
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

    public static void selectedNodeNav(ImageView vertexTouched) {
        vertexTouched.setImageResource(R.drawable.ic_node_selected_nav);
        vertexTouched.setTranslationX(getTraslationPosition(vertexTouched.getId())[0]);
        vertexTouched.setTranslationY(getTraslationPosition(vertexTouched.getId())[1]);
        MapFinalActivity.firstPage.setVisible(false);
        MapFinalActivity.forward.setVisible(true);
    }

    public static void unselectedNode(ImageView vertexUntouched) {
        vertexUntouched.setImageResource(R.drawable.ic_node_unselected);
        vertexUntouched.setTranslationX(getPosition(vertexUntouched.getId())[0]);
        vertexUntouched.setTranslationY(getPosition(vertexUntouched.getId())[1]);
    }

    public static void unselectedNodeNav(ImageView vertexUntouched) {
        vertexUntouched.setImageResource(R.drawable.ic_node_unselected_nav);
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
        }
        return id;
    }
}
