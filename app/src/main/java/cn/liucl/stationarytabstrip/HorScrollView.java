package cn.liucl.stationarytabstrip;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * 带滚动监听的ScrollView
 * Created by liucl on 2016/4/25.
 */
public class HorScrollView extends HorizontalScrollView {

    private ScrollViewListener scrollViewListener = null;

    public HorScrollView(Context context) {
        this(context, null);
    }

    public HorScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollViewListener != null) {
            scrollViewListener.onScroll(getScrollX(), getScrollY());
        }
    }

    public interface ScrollViewListener {

        void onScroll(int x, int y);

    }

}
