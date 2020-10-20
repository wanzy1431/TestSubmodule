package com.unis.common_module.view;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.TextUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeWebViewClient;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tea.fileselectlibrary.FileSelector;
import com.unis.common_module.R;
import com.unis.common_module.R2;
import com.unis.common_module.base.BaseActivity;
import com.unis.common_module.base.UnisApplication;
import com.unis.common_module.bean.CalendarBean;
import com.unis.common_module.bean.ClassFragmentBean;
import com.unis.common_module.bean.MoxinAccount;
import com.unis.common_module.bean.TeacherDetailBean;
import com.unis.common_module.bean.WebActivitySettingBean;
import com.unis.common_module.bean.WebData;
import com.unis.common_module.clouddisk.CloudDiskRouter;
import com.unis.common_module.clouddisk.PermissonUtils;
import com.unis.common_module.clouddisk.bean.FileBean;
import com.unis.common_module.config.CommonSelectionConfig;
import com.unis.common_module.config.Constants;
import com.unis.common_module.daoentity.OrganizeEntity;
import com.unis.common_module.daoentity.OrganizeEntityDao;
import com.unis.common_module.fileupload.FileUploadBean;
import com.unis.common_module.fileupload.UploadConfig;
import com.unis.common_module.fileupload.UploadListener;
import com.unis.common_module.fileupload.UploadManager;
import com.unis.common_module.net.SpAPI;
import com.unis.common_module.router.RouterPath;
import com.unis.common_module.utils.ARouterUtils;
import com.unis.common_module.utils.AccountUtils;
import com.unis.common_module.utils.FileUtil;
import com.unis.common_module.utils.GlideEngine;
import com.unis.common_module.utils.LogUtil;
import com.unis.common_module.utils.PicStyleUtils;
import com.unis.common_module.utils.RxManager;
import com.unis.common_module.widget.RecordDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.unis.common_module.clouddisk.CloudDiskConfig.CLOUDDISK_H5_TYPE;
import static com.unis.common_module.clouddisk.CloudDiskConfig.CLOUDDISK_SELECT_LOCAL_FILE;
import static com.unis.common_module.clouddisk.CloudDiskConfig.CLOUD_EVENT_TRANSMISSION;
import static com.unis.common_module.clouddisk.CloudDiskConfig.CLOUD_EVENT_TRANSMISSION_QUERY_COUNT;
import static com.unis.common_module.config.CommonSelectionConfig.CODE_REQUESTCODE_CALENDAR;

/**
 * Copyright (C), 2020-2020, by UNIS company
 * FileName: WebViewActivity
 * Author: zhangyibin
 * Date: 2020/8/25 10:48
 * Description:
 */

@Route(path = RouterPath.APP_WEBACTIVITY)
public class WebViewActivity extends BaseActivity implements UploadListener<FileUploadBean> {
    private BridgeWebView mWebView;
    @BindView(R2.id.commont_web_layout)
    LinearLayout mLayout;
    @BindView(R2.id.commont_web_title)
    LinearLayout mHeader;
    @BindView(R2.id.tv_common_title)
    TextView titleText;
    @BindView(R2.id.ll_common_back)
    LinearLayout backView;


    @BindView(R2.id.web_testclick_view)
    View mClickView;
    private UploadManager uploadManager;//文件上传管理者
    @Autowired
    String url;
    private File file;
    private RecordDialog mRecordDialog;
    private String teacherItem;
    private RxManager mRxManager;
    private String type = "";
    private Observer<Integer> observer;
    private static final int REQUESTCODE_FILE_PICKER = 1112;
    private RxPermissions mRxPremission;
    private String duration = "";

    @Override
    protected void setLayout() {
        setView(R.layout.common_activity_web, TYPE_NORMAL);
    }

    @Override
    protected void processData() {
//        Intent intent = getIntent();
//        url = intent.getStringExtra("url");
//        if (null == url || "".equals(url)) {
//            return;
//        }
        Bundle mBundle = getIntent().getExtras();
        mRxPremission = new RxPermissions((FragmentActivity) mContext);
        if (url == null) {
            url = mBundle.getString("url", "www.baidu.com");
        }
        if (teacherItem == null) {
            teacherItem = mBundle.getString("teacher_classItem", "");
        }
        uploadManager = new UploadManager.Builder<FileUploadBean>()
                .uploadUrl(UploadConfig.UPLOAD_BASEURL + "/api/ecp.fileserver.svc/upload/common")
                .listener(this)
                .initClass(FileUploadBean.class)
                .builder();
        initWeb();
        mClickView.setOnClickListener(v -> {

            // goForResult(VideoRecordActivity.class, VideoRecordActivity.VIDEO_RESULT_CODE);
        });
        titleText.setText(null);
        backView.setOnClickListener(v -> {
            finish();
        });
        if (mRxManager == null)
            mRxManager = new RxManager();
        mRxManager.on("audio_filepath", o -> {
            type = "audio_record";
            String[] split = o.toString().split(",");
            //录音上传
            duration = split[1];
            uploadManager.start(split[0]);
        });
        mRxManager.on("video_filepath", o -> {
            type = "video_record";
            //视频上传
            uploadManager.start(o.toString());
        });
        mRxManager.on("dialog_delete", o -> {

            //删除
            //Toast(o.toString());
        });
        observer = aBoolean -> {
            WebData.AppToJs appToJs = new WebData.AppToJs();
            appToJs.setClouddisk_transmission_count(aBoolean);
            WebData functionData = new WebData();
            functionData.setType(CLOUD_EVENT_TRANSMISSION);
            functionData.setAppToJs(appToJs);
            mWebView.callHandler("AppCallJs", new Gson().toJson(functionData), data2 -> {
                // data返回的参数
            });

        };
        LiveEventBus.get().with(CLOUD_EVENT_TRANSMISSION, Integer.class).observeForever(observer);

    }

    @Override
    protected void back() {

    }

    //初始化webview
    private void initWeb() {
        if (mWebView == null)
            mWebView = new BridgeWebView(getApplicationContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mWebView.setLayoutParams(params);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mLayout.addView(mWebView);
        WebSettings settings = mWebView.getSettings();
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);//缓存模式
        settings.setJavaScriptEnabled(true);//允许js交互
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//允许弹窗
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setBlockNetworkImage(false);//把图片放在最后渲染
        settings.setDefaultTextEncodingName("utf-8");//设置编码格式
        /*String ua = settings.getUserAgentString();
        settings.setUserAgentString(ua+"/device=android");*/
        //允许webview对文件的操作
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setDefaultHandler(new DefaultHandler());
        mWebView.setWebViewClient(new MyWebViewClient(mWebView));//使用jsbridge必须

        mWebView.loadUrl(url);
        //js调用客户端方法
        mWebView.registerHandler("JsCallApp", (data, function) -> {
            if ("".equals(data))
                return;
            LogUtils.e(data);
            WebData webData = new Gson().fromJson(data, WebData.class);
            //文件上传类型添加
            String biztype;
            if (webData.getJsToApp() == null)
                biztype = "";
            else
                biztype = webData.getJsToApp().getBizType();
            if (!TextUtils.isEmpty(biztype))//设置文件上传类型
                uploadManager.setBizType(biztype);
            switch (webData.getType()) {
                case "userInfo":
                    //获取用户信息
                    WebData functionData = new WebData();
                    functionData.setType("userInfo");
                    MoxinAccount selectAccount = AccountUtils.getSelectAccount();
                    WebData.AppToJs appToJs = new WebData.AppToJs();
                    appToJs.setUserInfo(selectAccount);
                    functionData.setAppToJs(appToJs);
                    function.onCallBack(new Gson().toJson(functionData));
                    break;
                case "shareCalendar": {
                    //日历分享
                    Bundle bundle = new Bundle();
                    CalendarBean calendarBean = webData.getJsToApp().getCalendarBean();
                    if (calendarBean != null) {
                        calendarBean.setShareType(Constants.CALENDAR);
                        bundle.putSerializable("content", calendarBean);
                        bundle.putString("source", Constants.INTENT_FROM_CALENDAR);
                        ARouter.getInstance().build(RouterPath.MSG_CALENDARSELECTACTIVITY).with(bundle).navigation();
                    }
                }
                break;
                case "teacherDetailBean": {
                    TeacherDetailBean teacherDetailBean = webData.getJsToApp().getTeacherDetailBean();
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.USERID, teacherDetailBean.getUserId());
                    bundle.putString(Constants.USERSCHOOLID, teacherDetailBean.getSchoolId());
                    ARouter.getInstance().build(RouterPath.MSG_USERINFOACTIVITY).with(bundle).navigation();
                }
                break;
                case "selectPerson":
                    //选人空间
                    ARouterUtils.goSelectionWidget(this, CommonSelectionConfig.INTENT_FROM_WEB_CALENDAR, CODE_REQUESTCODE_CALENDAR);
                    break;
                case "openPic":
                    //打开相册
                    mRxPremission.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            .subscribe(aBoolean -> {
                                if (aBoolean) {
                                    openPic();
                                } else {
                                    Toast("未授权，功能可能无法使用");
                                }
                            });
                    break;
                case "finish":
                    //关闭
                    finish();
                    break;
                case "teacher_classItem":
                    //班级tab 中item信息
                    WebData classItemData = new WebData();
                    classItemData.setType("teacher_classItem");
                    WebData.AppToJs classItemappToJs = new WebData.AppToJs();
                    classItemappToJs.setTeacherClassItem(new Gson().fromJson(teacherItem, ClassFragmentBean.class));
                    classItemData.setAppToJs(classItemappToJs);
                    function.onCallBack(new Gson().toJson(classItemData));
                    break;
                case "setHeader":
                    //设置H5标题
                    titleText.setVisibility(View.VISIBLE);
                    titleText.setText("");
                    if (webData.getJsToApp() != null) {
                        WebActivitySettingBean setting = webData.getJsToApp().getSettingBean();
                        if (setting != null) {
                            mHeader.setVisibility(setting.isShowHeader() ? View.VISIBLE : View.GONE);
                            titleText.setVisibility(setting.isShowTitle() ? View.VISIBLE : View.GONE);
                            titleText.setText(setting.getTitle());
                        }
                    }
                    break;
                case "newView":
                    if (webData.getJsToApp() != null) {
                        String newUrl = webData.getJsToApp().getUrl();
                        if (newUrl != null) {
                            ARouterUtils.goWebViewActivity(newUrl);
                        }
                    }
                    break;
                case CLOUD_EVENT_TRANSMISSION_QUERY_COUNT:
                    LiveEventBus.get().with(CLOUD_EVENT_TRANSMISSION_QUERY_COUNT).post(true);
                    break;
                case CLOUDDISK_H5_TYPE:
                    //调用选网盘文件控件
                    CloudDiskRouter.startRootPageForSelectFile(this);
                    break;
                case CLOUDDISK_SELECT_LOCAL_FILE:
                    //选择本地文件
                    openFilePicker();
                    break;
                case "audio_record":
                    //录音
                    mRxPremission.request(Manifest.permission.RECORD_AUDIO)
                            .subscribe(aBoolean -> {
                                if (aBoolean) {
                                    if (mRecordDialog == null)
                                        mRecordDialog = new RecordDialog(mContext);
                                    if (!mRecordDialog.isShowing())
                                        mRecordDialog.show();
                                } else {
                                    Toast("未授权，功能可能无法使用");
                                }
                            });

                    break;
                case "video_record":
                    //录像
                    mRxPremission.request(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
                            .subscribe(aBoolean -> {
                                if (aBoolean) {
                                    goForResult(VideoRecordActivity.class, VideoRecordActivity.VIDEO_RESULT_CODE);
                                } else {
                                    Toast("未授权，功能可能无法使用");
                                }
                            });
                    break;
                case "download_img":
                    List<String> urlList = webData.getJsToApp().getDownloadUrlList();
                    if (urlList == null || urlList.size() == 0) {
                        return;
                    }

                    //多图片下载
                    Observable.just(urlList)
                            .map((Func1<List<String>, List<File>>) s -> {
                                List<File> mFileList = new ArrayList<>();
                                //图片地址转换获取图片文件集合
                                try {
                                    for (String imgurl : s) {
                                        File file = Glide.with(mContext).asFile().load(imgurl).submit().get();
                                        mFileList.add(file);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return mFileList;
                            }).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe((Action1<List<File>>) files -> {
                                for (File file : files) {
                                    if (file != null) {
                                        //图片保存成功
                                        saveImageToGallery(file);
                                    }
                                }
                                Toast("图片保存成功");
                            });
                    break;
                /*case "goback":
                    //返回上一层
                    if (mWebView.canGoBack()) {
                        mWebView.goBack();
                    } else {
                        finish();
                    }
                    break;*/
                default:
                    toast("type:" + webData.getType() + "web:" + data);
                    break;
            }
        });
        //客户端调用js方法
        mWebView.callHandler("AppCallJs", "需要传递的参数", data -> {
            // data返回的参数
        });
    }
    //打开文件选择器
    private void openFilePicker() {
        PermissonUtils.grantStoragePermission(this, new PermissonUtils.GrantedResult() {
            @Override
            public void onSuccess() {
                String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                FileSelector.create(WebViewActivity.this)
                        .isChooseFile(true)//设置是选择文件还是文件夹
                        .setMaxNum(5)//设置选择最大数量
                        .setTitle("手机存储")//设置title
                        .setRootPath(rootPath)//设置需要选择的文件路径，默认为根路径
                        .setMaxFileSize(Integer.MAX_VALUE)//设置可以选择文件大小的最大值
//                            .setFileFilter(new String[]{"pdf", "doc", "docx", "txt", "png", "mp4"})//设置过滤需要保留的扩展名
                        .startForResult(REQUESTCODE_FILE_PICKER);
            }

            @Override
            public void onFail() {

            }
        });
    }

    //打开相册
    private void openPic() {
        //选择相册
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofAll())//相册
                //.isWeChatStyle(true)//开启R.style.picture_WeChat_style样式
                .setPictureStyle(PicStyleUtils.getWeChatStyle(this))//动态自定义相册主题
                // .setPictureCropStyle(PicStyleUtils.getWechatCropStyle(this))//动态自定义裁剪主题
                .isEnableCrop(false)// 是否裁剪
                .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                .showCropGrid(false)//是否显示裁剪矩形网格 圆形裁剪时建议设为false
                .rotateEnabled(false)//裁剪是否可旋转图片
                .isCamera(false)//列表是否显示拍照按钮
                .circleDimmedLayer(false)// 是否开启圆形裁剪
                .imageEngine(GlideEngine.createGlideEngine())// 图片加载引擎 glide
                .maxSelectNum(4)//最大选择数量,默认9张
                .isMaxSelectEnabledMask(true) //选择条件达到阀时列表是否启用蒙层效果
                .forResult(new OnResultCallbackListener<LocalMedia>() {
                    @Override
                    public void onResult(List<LocalMedia> result) {
                        // 结果回调
                        Observable.just(result)
                                .map((Func1<List<LocalMedia>, ArrayList<String>>) localMedia -> {
                                    ArrayList<String> mList = new ArrayList<>();
                                    for (LocalMedia file : localMedia) {
                                        mList.add(file.getRealPath());
                                    }
                                    return mList;
                                })
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .doOnNext((Action1<ArrayList<String>>) strings -> {
                                    WebData webData = new WebData();
                                    webData.setType("openPic");
                                    WebData.AppToJs webApptojs = new WebData.AppToJs();
                                    List<WebData.AppToJs.UploadInfo> mList = new ArrayList<>();
                                    //图片上传开始前，通知H5图片名字 和图片缩略图
                                    for (String path : strings) {
                                        file = new File(path);
                                        WebData.AppToJs.UploadInfo uploadItemInfo = new WebData.AppToJs.UploadInfo();
                                        uploadItemInfo.setFilename(file.getName());//文件名
                                        uploadItemInfo.setFileId(path);//id android本地路径
                                        String[] split = file.getName().split("\\.");
                                        uploadItemInfo.setFileType(split[split.length - 1]);//文件类型
                                        Bitmap thumbnail = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(path), 30, 30);
                                        uploadItemInfo.setThumbBase64(bitmapToBase64(thumbnail));//缩略图base64
                                        uploadItemInfo.setStatus(UploadConfig.STATUS_DEFAULT);//状态默认`
                                        uploadItemInfo.setUrl("");//服务端地址
                                        mList.add(uploadItemInfo);
                                    }
                                    webApptojs.setUploadInfos(mList);
                                    webData.setAppToJs(webApptojs);
                                    String json = new Gson().toJson(webData);
                                    mWebView.callHandler("AppCallJs", json, data -> {

                                    });
                                })
                                .subscribe((Action1<ArrayList<String>>) strings -> {
                                    type = "openPic";//android 调用H5type 图片上传
                                    uploadManager.start(strings);
                                });
                    }

                    @Override
                    public void onCancel() {
                        // 取消
                    }
                });
    }

    //跳转返回
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK)
            return;
//        选择云盘文件返回的数据
        if (requestCode == CloudDiskRouter.REQUEST_CODE_SELECT_FILE) {
            ArrayList<FileBean> fileBeanArrayList = data.getParcelableArrayListExtra(CloudDiskRouter.KEY_CLOUD_FILE);
            WebData.AppToJs appToJs = new WebData.AppToJs();
            appToJs.setFileBeanList(fileBeanArrayList);
            WebData functionData = new WebData();
            functionData.setType(CLOUDDISK_H5_TYPE);
            functionData.setAppToJs(appToJs);
            mWebView.callHandler("AppCallJs", new Gson().toJson(functionData), data2 -> {
                // data返回的参数
            });

        } else if (requestCode == CODE_REQUESTCODE_CALENDAR) {
            ArrayList<String> idS = data.getStringArrayListExtra(CommonSelectionConfig.INTENT_PARAM_IDS);
            List<OrganizeEntity> list = UnisApplication.instance().getDaoSession().getOrganizeEntityDao().queryBuilder().where(OrganizeEntityDao.Properties.KeyId.eq(SpAPI.THIS.getDbKey()), OrganizeEntityDao.Properties.UserId.in(idS)).list();
            WebData.AppToJs appToJs = new WebData.AppToJs();
            appToJs.setOrganizeEntityList(list);
            WebData functionData = new WebData();
            functionData.setType(CommonSelectionConfig.CALENDAR_H5_TYPE);
            functionData.setAppToJs(appToJs);
            mWebView.callHandler("AppCallJs", new Gson().toJson(functionData), data2 -> {
                // data返回的参数
            });

        } else if (requestCode == RecordDialog.CHOSE_FILE) {
            //选择文件返回数据
            String path = FileUtil.getPathFromUri(mContext, data.getData());
            MediaPlayer mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
            } catch (Exception e) {
                e.printStackTrace();
            }
            duration = (mediaPlayer.getDuration() / 1000) + ""; //时长
            mediaPlayer.release();
            uploadManager.start(path);
        } else if (requestCode == REQUESTCODE_FILE_PICKER) {
            handleSelelctFile(data);
        }

    }

    //本地文件选择
    private void handleSelelctFile(@Nullable Intent data) {
        List<String> files = FileSelector.obtainSelectorList(data);
        WebData.AppToJs appToJs = new WebData.AppToJs();
        appToJs.setLocalFilePaths(files);
        WebData functionData = new WebData();
        functionData.setType(CLOUDDISK_SELECT_LOCAL_FILE);
        functionData.setAppToJs(appToJs);
        mWebView.callHandler("AppCallJs", new Gson().toJson(functionData), data2 -> {
            // data返回的参数
        });
    }

    //上传开始
    @Override
    public void start(String url) {
        LogUtils.e("start:上传开始");
        android2h5(UploadConfig.STATUS_START, url, 0, "");
    }

    //上传中
    @Override
    public void progress(long read, long contentLength, String url, long kbs) {

        int progress = (int) (100 * read / contentLength);
        LogUtils.e("progress:上传zhong" + progress);
        android2h5(UploadConfig.STATUS_DOWING, url, progress, "");
    }

    //上传完毕
    @Override
    public void complete(String url, FileUploadBean value) {
        LogUtils.e("complete:上传完毕" + value.toString());
        android2h5(UploadConfig.STATUS_COMPLETE, url, 0, value.getUrl(), value.getUuid(), value.getUpdateTime());
    }

    //上传失败
    @Override
    public void error(String url, String msg) {
        LogUtils.e("error:上传失败");
        android2h5(UploadConfig.STATUS_ERROR, url, 0, "");
    }

    //android 调用H5
    private void android2h5(int status, String fileurl, int progress, String url, String uuid, String updateTime) {
        File file = new File(fileurl);
        WebData webData = new WebData();
        webData.setType(type);
        WebData.AppToJs appToJs = new WebData.AppToJs();
        WebData.AppToJs.UploadInfo itemInfo = new WebData.AppToJs.UploadInfo();
        itemInfo.setStatus(status);//设置状态
        itemInfo.setFilename(file.getName());//设置文件名
        itemInfo.setProgress(progress);//设置进度
        itemInfo.setUrl(url);//设置服务器返回url
        itemInfo.setFileId(fileurl);//id android本地路径
        itemInfo.setUuid(uuid);//文件上传id
        itemInfo.setUpdateTime(updateTime);//文件上传时间
        itemInfo.setDuration(duration);//时长
        String[] split = file.getName().split("\\.");
        itemInfo.setFileType(split[split.length - 1]);//数据type
        appToJs.setUploadInfo(itemInfo);
        webData.setAppToJs(appToJs);
        mWebView.callHandler("AppCallJs", new Gson().toJson(webData), data -> {

        });
    }

    private void android2h5(int status, String fileurl, int progress, String url) {
        android2h5(status, fileurl, progress, url, "", "");
    }


    class MyWebViewClient extends BridgeWebViewClient {

        public MyWebViewClient(BridgeWebView webView) {
            super(webView);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("tel:")) {
                //电话
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(url));
                startActivity(intent);
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Uri uri = request.getUrl();
                if (uri != null && uri.toString().contains("arouter")) {
                    ARouter.getInstance().build(uri).navigation();
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();//返回上个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onDestroy() {
        if (mWebView != null) {
            mWebView.destroy();
            mWebView = null;
        }
        mLayout.removeAllViews();

        LiveEventBus.get().with(CLOUD_EVENT_TRANSMISSION, Integer.class).removeObserver(observer);
        observer = null;

        super.onDestroy();
    }

    /*
     * 图片转base64
     * */
    public String bitmapToBase64(Bitmap bitmap) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //保存图片到相册
    public void saveImageToGallery(File file) {
        String fileName = System.currentTimeMillis() + ".jpg";
        File filemark = new File(Constants.TEACHING_TAKEPICK);
        if (!filemark.exists()) {
            FileUtils.createOrExistsDir(Constants.TEACHING_TAKEPICK);
        }
        File newFile = new File(Constants.TEACHING_TAKEPICK, fileName);
        if (newFile.exists()) {
            newFile.delete();
        }
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer) > 0) {
                fileOutputStream.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 最后通知图库更新
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.fromFile(new File(newFile.getPath()))));
    }
}
