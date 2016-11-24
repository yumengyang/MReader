package com.yuanchuangli.mreader.model.biz;

import com.yuanchuangli.mreader.model.bean.user.BaseUser;

/**
 * @author Blank
 * @description IUserBiz 登录操作的接口
 * @time 2016/11/24 18:24
 */

public interface IUserBiz {
    void login(BaseUser user, OnloginListener onloginListener);
}
