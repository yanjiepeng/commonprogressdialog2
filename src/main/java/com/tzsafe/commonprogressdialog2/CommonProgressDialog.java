package com.tzsafe.commonprogressdialog2;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CommonProgressDialog extends Dialog {
    public CommonProgressDialog(@NonNull Context context) {
        super(context);
    }

    public CommonProgressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CommonProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    private static CommonProgressDialog progressDialog;

    //创建dialog样式
    public static CommonProgressDialog createDialog(Context context) {

        progressDialog = new CommonProgressDialog(context, R.style.ProgressDialogStyle);
        progressDialog.setCanceledOnTouchOutside(false);  //禁止点击外边取消对话框
        progressDialog.setContentView(R.layout.progressdialog);
        progressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        return progressDialog;

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (progressDialog == null) {
            return;
        }
        //添加控件  执行帧动画
        ImageView imageView = (ImageView) progressDialog.findViewById(R.id.loadingImageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();

    }

    /**
     * 设置提示语
     *
     * @param strMessage 提示语内容
     * @return
     */
    public CommonProgressDialog setMessage(String strMessage) {
        TextView tvMessage = (TextView) progressDialog.findViewById(R.id.id_tv_loadingmsg);

        if (tvMessage != null) {
            tvMessage.setText(strMessage);
        }
        return progressDialog;
    }


    public CommonProgressDialog setMessageTextColor(int color) {


        TextView tvMessage = (TextView) progressDialog.findViewById(R.id.id_tv_loadingmsg);
        if (tvMessage != null) {
            tvMessage.setTextColor(color);
        }
        return progressDialog;
    }
}
