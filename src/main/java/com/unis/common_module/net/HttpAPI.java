package com.unis.common_module.net;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.unis.common_module.bean.AccountinfoBean;
import com.unis.common_module.bean.BaseBean;
import com.unis.common_module.bean.ChatHistorySearchBean;
import com.unis.common_module.bean.ConversationBean;
import com.unis.common_module.bean.GroupDetailBean;
import com.unis.common_module.bean.LoginBean;
import com.unis.common_module.bean.MessageDetailBean;
import com.unis.common_module.bean.NoticeDetailBean;
import com.unis.common_module.bean.SwitchCountBody;
import com.unis.common_module.bean.UpLoadBean;
import com.unis.common_module.bean.UserSignBean;
import com.unis.common_module.bean.UserinfoBean;
import com.unis.common_module.body.AddAppBody;
import com.unis.common_module.body.AddManagerBody;
import com.unis.common_module.body.AddMemberBody;
import com.unis.common_module.body.AllAppBody;
import com.unis.common_module.body.BlockListBody;
import com.unis.common_module.body.ChatHistorySearchBody;
import com.unis.common_module.body.ClearChatBody;
import com.unis.common_module.body.CommonAppBody;
import com.unis.common_module.body.ConversationBody;
import com.unis.common_module.body.ConversationListBody;
import com.unis.common_module.body.CreateGroupBody;
import com.unis.common_module.body.DeleteMessageBody;
import com.unis.common_module.body.GroupListBody;
import com.unis.common_module.body.GroupManagerBody;
import com.unis.common_module.body.LastReadReportBody;
import com.unis.common_module.body.MemberListBody;
import com.unis.common_module.body.NoticeBody;
import com.unis.common_module.body.NoticeIdBody;
import com.unis.common_module.body.NoticeTopBody;
import com.unis.common_module.body.PersonManagerBody;
import com.unis.common_module.body.ReadReportBody;
import com.unis.common_module.body.RemoveBody;
import com.unis.common_module.body.TopBody;
import com.unis.common_module.body.UpdateBody;
import com.unis.common_module.body.WithdrawMessageBody;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

public interface HttpAPI {
    //上传文件
    @Multipart
    @POST("/api/ecp.user.backend/user/uploadPhoto")
    Observable<UpLoadBean> uploadPhoto(@Part MultipartBody.Part file);

    //登录
    @FormUrlEncoded
    @POST("/api/ecp.sso.backend/sso/login")
//    @POST("http://172.16.105.181:8281/ecp.sso.backend/sso/login")
    Observable<LoginBean> login(@Field("username") String username,
                                @Field("password") String password,
                                @Field("allowAccountType") String allowAccountType);

    //获取登录用户信息的
    @GET("/api/ecp.user.backend/user/account/findDetailByAccountId")
    Observable<AccountinfoBean> accountInfo(@Query("accountId") String accountId);


    //手机发送验证码
    @GET("/api/ecp.sso.backend/sso/sendMobileValidateCode")
    Observable<Object> sendMobileValidateCode(@Query("codeType") String codeType,
                                              @Query("mobile") String mobile);

    //短信验证码登录
    @GET("/api/ecp.sso.backend/sso/loginByMobileCode")
    Observable<LoginBean> loginByMobileCode(@Query("mobile") String mobile,
                                            @Query("code") String code,
                                            @Query("allowAccountType") String allowAccountType

    );

    //验证码校验
    @GET("/api/ecp.sso.backend/sso/verificationCodeWithType/verify")
    Observable<ResponseBody> verify(@Query("mobile") String mobile,
                                    @Query("code") String code,
                                    @Query("type") String type
    );

    //绑定手机号
    @GET("/api/ecp.user.backend/user/bindMobile")
    Observable<ResponseBody> bindMobile(@Query("mobile") String mobile,
                                        @Query("code") String code
    );

    //重置密码获取用户信息
    @GET("/api/ecp.sso.backend/pwd/userInfo")
    Observable<Object> pwdUserInfo(@Query("resetMethod") String codeType,
                                   @Query("verificationCode") String verificationCode,
                                   @Query("resetText") String resetText,
                                   @Query("allowAccountType") String allowAccountType
    );

    //重置密码验证码验证
    @FormUrlEncoded
    @POST("/api/ecp.sso.backend/pwd/resetByCode")
    Observable<Object> resetByCode(@Field("resetCode") String mobile,
                                   @Field("newPassword") String code,
                                   @Field("userIds") String allowAccountType
    );

    //切换身份
    @POST("/api/ecp.sso.backend/sso/switchAccount")
    Observable<Object> switchAccount(
            @Body SwitchCountBody body);

    //获取组织通讯录
    @FormUrlEncoded
    @POST("/api/ecp.user.backend/selector/school_organizeList")
    Observable<JsonArray> schoolOrganizeList(@Field("id") String id,
                                             @Field("nodeType") String nodeType,
                                             @Field("type") String type,
                                             @Field("schoolId") String schoolId);

    // 创建群组
    @POST("/api/ecampus.im.backend/im/group/create")
    Observable<BaseBean> groupCreate(@Body CreateGroupBody createGroupBody);

    //用户加入的群列表
    @POST("/api/ecampus.im.backend/im/group/search")
    Observable<ResponseBody> groupList(@Body GroupListBody body);

    //群成员列表
    @POST("/api/ecampus.im.backend/im/group/member/search")
    Observable<JsonArray> memberList(@Body MemberListBody body);

    //获取单聊会话id
    @POST("/api/ecampus.im.backend/im/conversation/getConversationId")
    Observable<Object> getConversationId(@Body ConversationBody body);

    //获取用户信息
    @GET("/api/ecampus.im.backend/im/user/info")
    Observable<UserinfoBean> info(@Query("userId") String userId);

    //用户会话列表的分页
    @POST("/api/ecampus.im.backend/im/conversation/search")
    Observable<ConversationBean> conversationSearch(@Body ConversationListBody body);

    //置顶或取消置顶的会话
    @POST("/api/ecampus.im.backend/im/conversation/topped")
    Observable<BaseBean> conversationTopped(@Body TopBody topBody);

    //用户删除会话
    @POST("/api/ecampus.im.backend/im/conversation/remove")
    Observable<BaseBean> conversationRemove(@Body RemoveBody removeBody);

    //获取群详情
    @GET("/api/ecampus.im.backend/im/group/detail")
    Observable<GroupDetailBean> groupDetail(@Query("groupId") String groupId);

    // 添加群成员
    @POST("/api/ecampus.im.backend/im/group/member/add")
    Observable<BaseBean> memberAdd(@Body AddMemberBody addMemberBody);

    // 上传群头像
    @POST("/api/ecampus.im.backend/im/group/portrait/upload")
    Observable<BaseBean> uploadGroupHead(@Body RequestBody body);

    // 删除群成员
    @POST("/api/ecampus.im.backend/im/group/member/remove")
    Observable<BaseBean> memberRemove(@Body AddMemberBody addMemberBody);

    // 修改群名称
    @POST("/api/ecampus.im.backend/im/group/name/update")
    Observable<BaseBean> updateGroupName(@Body UpdateBody updateBody);

    // 发布群公告
    @POST("/api/ecampus.im.backend/im/group/notice/add")
    Observable<BaseBean> addNotice(@Body NoticeBody noticeBody);

    //群公告列表
    @GET("/api/ecampus.im.backend/im/group/notice/search")
    Observable<JsonArray> noticeList(@Query("groupId") String groupId);

    // 修改群公告
    @POST("/api/ecampus.im.backend/im/group/notice/update")
    Observable<BaseBean> updateNotice(@Body NoticeBody noticeBody);

    // 置顶、取消置顶群公告
    @POST("/api/ecampus.im.backend/im/group/notice/topped")
    Observable<BaseBean> toppedNotice(@Body NoticeTopBody noticeBody);

    // 移除群公告
    @POST("/api/ecampus.im.backend/im/group/notice/remove")
    Observable<BaseBean> removeNotice(@Body NoticeBody noticeBody);

    //群公告已读
    @POST("/api/ecampus.im.backend/im/group/notice/read")
    Observable<BaseBean> noticeRead(@Body NoticeIdBody idBody);

    //公告详情
    @GET("/api/ecampus.im.backend/im/group/notice/{id}")
    Observable<NoticeDetailBean> noticeDetail(@Path("id") String noticeId);

    // 修改个人群内昵称
    @POST("/api/ecampus.im.backend/im/user/nickname/update")
    Observable<BaseBean> updateGroupNickName(@Body NoticeBody noticeBody);

    //转让群主
    @POST("/api/ecampus.im.backend/im/group/master/change")
    Observable<BaseBean> changeGroupMaster(@Body UpdateBody updateBody);

    //解散群
    @POST("/api/ecampus.im.backend/im/group/destroy")
    Observable<BaseBean> destroyGroup(@Body UpdateBody updateBody);

    //退出群聊
    @POST("/api/ecampus.im.backend/im/group/logout")
    Observable<BaseBean> logoutGroup(@Body AddMemberBody addMemberBody);

    //设置管理员
    @POST("/api/ecampus.im.backend/im/group/admin/add")
    Observable<BaseBean> addManager(@Body AddManagerBody addManagerBody);

    //用户群设置
    @GET("/api/ecampus.im.backend/im/user/setting")
    Observable<JsonArray> groupSet(@Query("userId") String userId, @Query("schoolId") String userSchoolId);

    //单聊设置过免打扰的
    @GET("/api/ecampus.im.backend/im/user/notDisturb/search")
    Observable<JsonArray> searchUserSet();

    //群消息免打扰设置
    @POST("/api/ecampus.im.backend/im/group/message/acceptMode")
    Observable<BaseBean> acceptMode(@Body GroupManagerBody noNoticeBody);

    //单聊免打扰设置
    @POST("/api/ecampus.im.backend//im/user/message/acceptMode")
    Observable<BaseBean> userAcceptMode(@Body PersonManagerBody noNoticeBody);

    //自动保存群文件到云盘
    @POST("/api/ecampus.im.backend/im/group/sync_file")
    Observable<BaseBean> syncFile(@Body GroupManagerBody syncBody);

    //设置显示群成员昵称
    @POST("/api/ecampus.im.backend/im/group/member/nickname/show")
    Observable<BaseBean> nickNameShow(@Body GroupManagerBody showBody);

    //设置仅群组和群管理员可管理-群名称-成员-公告
    @POST("/api/ecampus.im.backend/im/group/name_member_notice/onlyAdminCanManage")
    Observable<BaseBean> onlyAdminCanManage(@Body GroupManagerBody canBody);

    //设置入群申请验证
    @POST("/api/ecampus.im.backend/im/group/join/check")
    Observable<BaseBean> joinCheck(@Body GroupManagerBody checkBody);

    //取消管理员
    @POST("/api/ecampus.im.backend/im/group/admin/remove")
    Observable<BaseBean> removeManager(@Body AddManagerBody addManagerBody);

    //分页查询历史消息
    @POST("/api/ecampus.im.backend/im/message/history/search")
    Observable<ChatHistorySearchBean> chatHistorySearch(@Body ChatHistorySearchBody historySearchBody);

    //常用联系人
    @GET("/api/ecampus.im.backend/im/user/contacts/top")
    Observable<JsonArray> topContacts();

    //im用户信息
    @GET("/api/ecampus.im.backend/im/user/info")
    Observable<Object> imUserInfo(@Query("userId") String userId, @Query("userSchoolId") String userSchoolId);

    //im用户签名
    @GET("/api/ecampus.im.backend/im/user/sign")
    Observable<UserSignBean> imUserSign(@Query("userId") String userId);

    //加入黑名单
    @POST("/api/ecampus.im.backend/im/user/blocklist/add")
    Observable<BaseBean> joinBlack(@Body BlockListBody blockListBody);

    //删除黑名单
    @POST("/api/ecampus.im.backend/im/user/blocklist/remove")
    Observable<BaseBean> deleteBlack(@Body BlockListBody blockListBody);

    //黑名单列表
    @GET("/api/ecampus.im.backend/im/user/blocklist/search")
    Observable<JsonArray> blockList();

    //修改密码
    @FormUrlEncoded
    @POST("/api/ecp.sso.backend/pwd/resetByOldPwd")
    Observable<ResponseBody> changePwd(@Field("oldPassword") String oldPassword,
                                       @Field("newPassword") String newPassword);

    //清空消息
    @POST("/api/ecampus.im.backend/im/message/clear")
    Observable<BaseBean> clearChatRecords(@Body ClearChatBody clearChatBody);

    //删除消息
    @POST("/api/ecampus.im.backend/im/message/delete")
    Observable<BaseBean> deleteMessage(@Body DeleteMessageBody deleteMessageBody);

    //撤回消息
    @POST("/api/ecampus.im.backend/im/message/withdraw")
    Observable<BaseBean> withdrawMessage(@Body WithdrawMessageBody withdrawMessageBody);

    //消息已读详情
    @GET("/api/ecampus.im.backend/im/message/read/detail")
    Observable<MessageDetailBean> readDetail(@Query("conversationId") String conversationId, @Query("msgId") String msgId);

    //消息已读上报
    @POST("/api/ecampus.im.backend/im/message/read/report")
    Observable<BaseBean> readReport(@Body ReadReportBody readReportBody);

    //上报最后一条消息
    @POST("/api/ecampus.im.backend/im/message/lastRead/report")
    Observable<BaseBean> lastReadReport(@Body LastReadReportBody lastReadReportBody);

    //获取常用应用列表-通用
    @POST("/api/cloud.app.backend/workPlatform/selectCommonUsedApps")
    Observable<JsonArray> selectCommonUsedApps(@Body CommonAppBody commonAppBody);

    //应用库查询-通用
    @POST("/api/cloud.app.backend/workPlatform/query")
    Observable<JsonObject> queryWork(@Body AllAppBody allAppBody);

    //应用分类
    @GET("/api/cloud.app.backend/appClassify/searchAll")
    Observable<JsonArray> queryType();

    //新增常用应用-获取应用库-通用
    @POST("/api/cloud.app.backend/workPlatform/selectCommonUsedSuitableApps")
    Observable<JsonArray> selectCommonUsedSuitableApps(@Body CommonAppBody commonAppBody);

    //新增常用应用-通用
    @POST("/api/cloud.app.backend/workPlatform/insertCommonUsedApps")
    Observable<ResponseBody> insertCommonUsedApps(@Body AddAppBody addAppBody);

    //删除常用应用-通用
    @POST("/api/cloud.app.backend/workPlatform/deleteCommonUsedApps")
    Observable<ResponseBody> deleteCommonUsedApps(@Body AddAppBody addAppBody);

    //班级-首页
    @GET("/api/oa-classspace-backend/message/teacherClasses")
    Observable<JsonArray> queryClassIndex(@QueryMap Map<String, String> map);

    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);

}
