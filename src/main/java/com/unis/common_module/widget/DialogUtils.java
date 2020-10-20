package com.unis.common_module.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.unis.common_module.R;
import com.unis.common_module.adapter.SelectCommonSessionAdapter;
import com.unis.common_module.bean.SelectSessionBean;
import com.unis.common_module.config.Constants;
import com.unis.common_module.config.MoxinConfig;
import com.unis.common_module.router.RouterPath;
import com.unis.common_module.utils.ActivityUtils;

import java.util.List;

public class DialogUtils {
    private volatile static DialogUtils mSingleton = null;
    public final int BOTH = 0;
    public final int SURE = 1;
    public final int CANCEL = 2;
    private CommonBaseDialog baseDialog;

    private DialogUtils() {

    }

    public static DialogUtils getInstance() {
        if (mSingleton == null) {
            synchronized (DialogUtils.class) {
                if (mSingleton == null) {
                    mSingleton = new DialogUtils();
                }
            }
        }
        return mSingleton;
    }

    /**
     * 看大图 拍摄 选择图片
     *
     * @param context
     * @param onSelectPic
     */
    public void showSelectPic(Context context, OnSelectPic onSelectPic) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            dismissDialog();
            baseDialog = CommonBaseDialog.showDialog(context, R.layout.common_dialog_select_pic_layout);
            baseDialog.setOnTouchOutside(true)
                    .setDialogLocation(Gravity.BOTTOM, 0, 0, 0, 0)
                    .setViewListener(new CommonBaseDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, int viewId) {
                            dialog.dismiss();
                            if (viewId == R.id.tv_select_pic_watch_big) {
                                if (onSelectPic != null) {
                                    onSelectPic.onWatchBig();
                                }
                            } else if (viewId == R.id.tv_select_pic_take_pic) {
                                if (onSelectPic != null) {
                                    onSelectPic.onTakePic();
                                }
                            } else if (viewId == R.id.tv_select_pic_from_album) {
                                if (onSelectPic != null) {
                                    onSelectPic.onFromAlbum();
                                }
                            }
                        }
                    }, R.id.tv_select_pic_watch_big, R.id.tv_select_pic_take_pic, R.id.tv_select_pic_from_album, R.id.tv_select_pic_cancel);
        }
    }

    public void showProgressDialog(Context context) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            dismissDialog();
            baseDialog = CommonBaseDialog.showDialog(context, R.layout.common_dialog_show_progress_layout);
            TextView tvTitle = baseDialog.getView(R.id.tv_common_show_progress_name);
            ProgressBar pb = baseDialog.getView(R.id.pb_common_show_progress_show);
            baseDialog.setOnTouchOutside(true)
                    .setDialogLocation(Gravity.CENTER, 50, 0, 50, 0);
        }
    }

    /**
     * 正常对话框
     *
     * @param context
     * @param dialogType 类型
     * @param titleName
     * @param confirmStr 确认
     * @param onBtClick
     */
    public void showHintDialog(Context context, int dialogType, String titleName, String confirmStr, OnBtClick onBtClick) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            dismissDialog();
            baseDialog = CommonBaseDialog.showDialog(context, R.layout.common_dialog_show_hint_layout);
            TextView tvName = baseDialog.getView(R.id.tv_common_hint_name);
            View lineView = baseDialog.getView(R.id.view_common_hint_line);
            TextView tvSure = baseDialog.getView(R.id.tv_common_hint_sure);
            TextView tvCancel = baseDialog.getView(R.id.tv_common_hint_cancel);
            if (dialogType == SURE) {
                lineView.setVisibility(View.GONE);
                tvCancel.setVisibility(View.GONE);
            } else if (dialogType == CANCEL) {
                tvSure.setVisibility(View.GONE);
                lineView.setVisibility(View.GONE);
            }
            if (!TextUtils.isEmpty(titleName)) {
                tvName.setText(titleName);
            }
            if (!TextUtils.isEmpty(confirmStr)) {
                tvSure.setText(confirmStr);
            }
            baseDialog.setOnTouchOutside(false)
                    .setDialogLocation(Gravity.CENTER, 50, 0, 50, 0)
                    .setViewListener(new CommonBaseDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, int viewId) {
                            dialog.dismiss();
                            if (viewId == R.id.tv_common_hint_sure) {
                                if (onBtClick != null) {
                                    onBtClick.onConfirm("");
                                }
                            }
                        }
                    }, R.id.tv_common_hint_sure, R.id.tv_common_hint_cancel);
        }
    }

    /**
     * 客服电话
     *
     * @param context
     * @param onBtClick
     */
    public void showPhoneDialog(Context context, OnBtClick onBtClick) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            dismissDialog();
            baseDialog = CommonBaseDialog.showDialog(context, R.layout.common_dialog_phone_layout);
            TextView tvNum = baseDialog.getView(R.id.tv_dialog_phone_num);
            tvNum.setText(MoxinConfig.SERVICE_PHONE);
            baseDialog.setOnTouchOutside(true)
                    .setDialogLocation(Gravity.CENTER, 50, 0, 50, 0)
                    .setViewListener(new CommonBaseDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, int viewId) {
                            dialog.dismiss();
                            if (viewId == R.id.tv_dialog_phone_sure) {
                                if (onBtClick != null) {
                                    String content = tvNum.getText().toString().trim();
                                    onBtClick.onConfirm(content);
                                }
                            }
                        }
                    }, R.id.tv_dialog_phone_sure, R.id.tv_dialog_phone_cancel);
        }
    }

    /**
     * 取消 确定 按钮在右边
     *
     * @param context
     * @param titleStr
     * @param onBtClick
     */
    public void showRightDialog(Context context, String titleStr, OnBtClick onBtClick) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            dismissDialog();
            baseDialog = CommonBaseDialog.showDialog(context, R.layout.common_dialog_right_hint_layout);
            TextView tvName = baseDialog.getView(R.id.tv_dialog_right_hint_name);
            if (!TextUtils.isEmpty(titleStr)) {
                tvName.setText(titleStr);
            }
            baseDialog.setOnTouchOutside(true)
                    .setDialogLocation(Gravity.CENTER, 50, 0, 50, 0)
                    .setViewListener(new CommonBaseDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, int viewId) {
                            dialog.dismiss();
                            if (viewId == R.id.tv_dialog_right_hint_sure) {
                                if (onBtClick != null) {
                                    onBtClick.onConfirm("");
                                }
                            }
                        }
                    }, R.id.tv_dialog_right_hint_sure, R.id.tv_dialog_right_hint_cancel);
        }
    }

    /**
     * 转发 分享 对话框
     *
     * @param context
     * @param content
     * @param selectList
     * @param onBtClick
     */
    public void showSelectSessionDialog(Context context, String content, List<SelectSessionBean> selectList, OnBtClick onBtClick) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            dismissDialog();
            baseDialog = CommonBaseDialog.showExitDialog(context, R.layout.common_dialog_select_session_layout);
            TextView tvName = baseDialog.getView(R.id.tv_common_select_session_name);
            LinearLayout listLayout = baseDialog.getView(R.id.ly_common_select_session_list_one);
            ImageView ivGroupHead = baseDialog.getView(R.id.iv_common_select_session_list_head);
            TextView tvGroupName = baseDialog.getView(R.id.tv_common_select_session_list_name);
            MaxHeightRecyclerView rvList = baseDialog.getView(R.id.rv_common_select_session_list);
            TextView tvContent = baseDialog.getView(R.id.tv_common_select_session_send_content);
            EditText etMark = baseDialog.getView(R.id.et_common_select_session_mark);
            tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
            tvContent.setOnTouchListener(onTouchListener);
            if (selectList != null && selectList.size() >= 2) {
                tvName.setText("分别发送给：");
                listLayout.setVisibility(View.GONE);
                rvList.setVisibility(View.VISIBLE);
                rvList.setLayoutManager(new GridLayoutManager(context, 5));
                rvList.setAdapter(new SelectCommonSessionAdapter(R.layout.common_dialog_select_session_item, selectList));
            } else {
                tvName.setText("发送给：");
                listLayout.setVisibility(View.VISIBLE);
                rvList.setVisibility(View.GONE);
                if (selectList.size() == 1) {
                    Glide.with(context).load(selectList.get(0).getUserPhoto()).placeholder(R.mipmap.default_head).circleCrop().into(ivGroupHead);
                    tvGroupName.setText(selectList.get(0).getUserName());
                }
            }
            tvContent.setText(content);
            baseDialog.setDialogLocation(Gravity.CENTER, 42, 0, 42, 0)
                    .setViewListener(new CommonBaseDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, int viewId) {
                            dialog.dismiss();
                            if (viewId == R.id.tv_common_select_session_send) {
                                if (onBtClick != null) {
                                    String markStr = etMark.getText().toString().trim();
                                    onBtClick.onConfirm(markStr);
                                }
                            }
                        }
                    }, R.id.tv_common_select_session_send, R.id.tv_common_select_session_cancel);
        }
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //父节点不拦截子节点
                v.getParent().requestDisallowInterceptTouchEvent(true);
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                //父节点不拦截子节点
                v.getParent().requestDisallowInterceptTouchEvent(true);
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                //父节点拦截子节点
                v.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    };

    /**
     * 确认 取消 对话框
     *
     * @param context
     * @param onBtClick
     */
    public void showSureDialog(Context context, String sureStr, OnBtClick onBtClick) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            dismissDialog();
            baseDialog = CommonBaseDialog.showDialog(context, R.layout.common_dialog_sure_layout);
            TextView tvSure = baseDialog.getView(R.id.tv_dialog_sure_sure);
            if (!TextUtils.isEmpty(sureStr)) {
                if (sureStr.contains("黑名单")) {
                    tvSure.setTextColor(context.getResources().getColor(R.color.black_2A));
                }
                tvSure.setText(sureStr);
            }
            baseDialog.setOnTouchOutside(true)
                    .setDialogLocation(Gravity.BOTTOM, 0, 0, 0, 0)
                    .setViewListener(new CommonBaseDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, int viewId) {
                            dialog.dismiss();
                            if (viewId == R.id.tv_dialog_sure_sure) {
                                if (onBtClick != null) {
                                    onBtClick.onConfirm("");
                                }
                            }
                        }
                    }, R.id.tv_dialog_sure_sure, R.id.tv_dialog_sure_cancel);
        }
    }

    /**
     * 底部对话框
     *
     * @param context
     * @param firstStr
     * @param secondStr
     * @param onBtClick
     */
    public void showThreeDialog(Context context, String firstStr, String secondStr, OnBtClick onBtClick) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            dismissDialog();
            baseDialog = CommonBaseDialog.showDialog(context, R.layout.common_dialog_list_layout);
            TextView tvFirst = baseDialog.getView(R.id.tv_dialog_list_first);
            TextView tvSecond = baseDialog.getView(R.id.tv_dialog_list_second);
            if (!TextUtils.isEmpty(firstStr)) {
                tvFirst.setText(firstStr);
            }
            if (!TextUtils.isEmpty(secondStr)) {
                tvSecond.setText(secondStr);
            }
            baseDialog.setOnTouchOutside(true)
                    .setDialogLocation(Gravity.BOTTOM, 0, 0, 0, 0)
                    .setViewListener(new CommonBaseDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, int viewId) {
                            dialog.dismiss();
                            if (viewId == R.id.tv_dialog_list_first) {
                                if (onBtClick != null) {
                                    onBtClick.onConfirm(firstStr);
                                }
                            } else if (viewId == R.id.tv_dialog_list_second) {
                                if (onBtClick != null) {
                                    onBtClick.onConfirm(secondStr);
                                }
                            }
                        }
                    }, R.id.tv_dialog_list_first, R.id.tv_dialog_list_second, R.id.tv_dialog_list_cancel);
        }
    }

    /**
     * 字体选择
     *
     * @param context
     * @param onFontClick
     */
    public void showFontDialog(Context context, OnFontClick onFontClick) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            dismissDialog();
            baseDialog = CommonBaseDialog.showDialog(context, R.layout.common_dialog_font_size_layout);
            baseDialog.setOnTouchOutside(true)
                    .setDialogLocation(Gravity.BOTTOM, 0, 0, 0, 0)
                    .setViewListener(new CommonBaseDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, int viewId) {
                            dialog.dismiss();
                            if (viewId == R.id.tv_dialog_font_size_largest) {
                                if (onFontClick != null) {
                                    onFontClick.onLargest();
                                }
                            } else if (viewId == R.id.tv_dialog_font_size_large) {
                                if (onFontClick != null) {
                                    onFontClick.onLarge();
                                }
                            } else if (viewId == R.id.tv_dialog_font_size_standard) {
                                if (onFontClick != null) {
                                    onFontClick.onStandard();
                                }
                            } else if (viewId == R.id.tv_dialog_font_size_small) {
                                if (onFontClick != null) {
                                    onFontClick.onSmall();
                                }
                            }
                        }
                    }, R.id.tv_dialog_font_size_largest, R.id.tv_dialog_font_size_large, R.id.tv_dialog_font_size_standard, R.id.tv_dialog_font_size_small, R.id.tv_dialog_font_size_cancel);
        }
    }


    private void dismissDialog() {
        if (baseDialog != null && baseDialog.isShowing()) {
            baseDialog.dismiss();
            baseDialog = null;
        }
    }

    /**
     * 退出 对话框
     *
     * @param context
     */
    public void showExitDialog(Context context) {
        if (getActivity(context) != null && !getActivity(context).isFinishing()) {
            CommonBaseDialog.showExitDialog(context, R.layout.common_dialog_exit_layout)
                    .setDialogLocation(Gravity.CENTER, 80, 0, 80, 0)
                    .setViewListener(new CommonBaseDialog.OnCloseListener() {
                        @Override
                        public void onClick(Dialog dialog, int viewId) {
                            ActivityUtils.finishAll();
                            Constants.IS_CLEAR_DATA = false;
                            dialog.dismiss();
                            ARouter.getInstance().build(RouterPath.LOGIN_LOGINACTIVITY).navigation();
                        }
                    }, R.id.tv_common_exit_sure);
        }
    }

    private Activity getActivity(Context context) {
        while (!(context instanceof Activity) && context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        } else
            return null;
    }

    public interface OnSelectPic {
        void onWatchBig();

        void onTakePic();

        void onFromAlbum();
    }

    public interface OnFontClick {
        void onLargest();

        void onLarge();

        void onStandard();

        void onSmall();
    }

    public interface OnBtClick {
        void onConfirm(String content);
    }
}
