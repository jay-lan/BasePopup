package razerdp.demo.popup;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;

import razerdp.basepopup.BasePopupWindow;
import razerdp.basepopup.R;
import razerdp.demo.utils.ToastUtils;

/**
 * Created by 大灯泡 on 2016/1/22.
 * 菜单。
 */
public class DismissControlPopup extends BasePopupWindow implements View.OnClickListener {

    public DismissControlPopup(Activity context) {
        super(context, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        findViewById(R.id.tx_1).setOnClickListener(this);
        findViewById(R.id.tx_2).setOnClickListener(this);
        findViewById(R.id.tx_3).setOnClickListener(this);
        setAlignBackground(false);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        AnimationSet set = new AnimationSet(true);
        set.setInterpolator(new DecelerateInterpolator());
        set.addAnimation(getScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0));
        set.addAnimation(getDefaultAlphaAnimation());
        return set;
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        AnimationSet set = new AnimationSet(true);
        set.setInterpolator(new DecelerateInterpolator());
        set.addAnimation(getScaleAnimation(1, 0, 1, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0));
        set.addAnimation(getDefaultAlphaAnimation(false));
        return set;
    }

    @Override
    public void showPopupWindow(View v) {
        setOffsetX(v.getWidth() / 2);
        setOffsetY(-v.getHeight() / 2);
        super.showPopupWindow(v);
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tx_1:
                ToastUtils.ToastMessage(getContext(), "click tx_1");
                break;
            case R.id.tx_2:
                ToastUtils.ToastMessage(getContext(), "click tx_2");
                break;
            case R.id.tx_3:
                ToastUtils.ToastMessage(getContext(), "click tx_3");
                break;
            default:
                break;
        }
        dismiss();

    }
}
