package com.yuanchuangli.mreader.model.biz;

import com.yuanchuangli.mreader.api.ServerInterface_POST;
import com.yuanchuangli.mreader.model.bean.user.BaseUser;
import com.yuanchuangli.mreader.parse.JSONParse_PHP;

/**
 * @author Blank
 * @description 处理具体的逻辑
 * @time 2016/11/23 11:26
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final BaseUser user, final OnloginListener loginListener) {
        new Thread() {
            @Override
            public void run() {
                String json = ServerInterface_POST.checkPass(user);
                int code = JSONParse_PHP.getStatus(json);
                switch (code) {
                    case JSONParse_PHP.STATUS_SUCCESS:
                        loginListener.loginSuccess(user);
                        break;
                    case JSONParse_PHP.STATUS_FAILE:
                        loginListener.loginFailed();
                    case JSONParse_PHP.STATUS_PARSE_FAIL_INNER:
                        loginListener.loginFailed();
                        break;
                }
            }
        }.start();

    }
}