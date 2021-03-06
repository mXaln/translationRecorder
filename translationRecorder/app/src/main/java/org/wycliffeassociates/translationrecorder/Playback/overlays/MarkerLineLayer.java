package org.wycliffeassociates.translationrecorder.Playback.overlays;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by sarabiaj on 11/9/2016.
 */

public class MarkerLineLayer extends View {

    Paint mPaintBaseLine;

    public interface MarkerLineDrawDelegator {
        void onDrawMarkers(Canvas canvas);
    }

    public static MarkerLineLayer newInstance(Context context, MarkerLineDrawDelegator drawDelegator){
        MarkerLineLayer mll = new MarkerLineLayer(context);
        mll.setMarkerLineDrawDelegator(drawDelegator);
        mll.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mll.setPaint();
        return mll;
    }

    private void setPaint(){
        mPaintBaseLine = new Paint(Color.BLACK);
        mPaintBaseLine.setStyle(Paint.Style.STROKE);
        mPaintBaseLine.setStrokeWidth(2f);
    }

    MarkerLineDrawDelegator mMarkerLineDrawDelegator;

    private MarkerLineLayer(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mMarkerLineDrawDelegator.onDrawMarkers(canvas);
    }

    private void setMarkerLineDrawDelegator(MarkerLineDrawDelegator drawDelegator){
        mMarkerLineDrawDelegator = drawDelegator;
    }
}
