package it.univpm.gruppoids.iotforemergencyandnavigation.ui;

import android.content.res.Resources;
import android.widget.ImageView;

/**
 * Created by simon on 22/11/2016.
 */

public class ControllerUI {


    public static void positioningNode(ImageView vertex, int x, int y) {
        switch (vertex.getId()) {
            /*case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc2:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q155wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q150wc1:
            case it.univpm.gruppoids.iotforemergencyandnavigation.R.id.q145wc1:
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_wc_unselected);
                if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                        Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
                    vertex.setX(x - 6);
                    vertex.setY(y - 3);
                } else {
                    vertex.setX(x - 18);
                    vertex.setY(y - 18);
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
                    vertex.setX(x - 6);
                    vertex.setY(y - 3);
                } else {
                    vertex.setX(x - 29);
                    vertex.setY(y - 18);
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
                    vertex.setX(x - 6);
                    vertex.setY(y);
                } else {
                    vertex.setX(x - 18);
                    vertex.setY(y - 18);
                }
                break;*/
            default:
                vertex.setImageResource(it.univpm.gruppoids.iotforemergencyandnavigation.R.drawable.ic_node_unselected);
                vertex.setX(x);
                vertex.setY(y);
        }
    }
}
