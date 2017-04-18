package com.venus.android.custom.handler;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.venus.android.data.repository.NetMsgHandler;

/**
 * Created by lev on 5/29/16.
 */
public class MsgHandler extends Handler {
    final NetMsgHandler msgHandler;

    public MsgHandler(NetMsgHandler netMsgHandler) {
        this.msgHandler = netMsgHandler;
    }

    public void handleMessage(Message message) {
        if (this.msgHandler.getContext() != null) {
            Toast.makeText(this.msgHandler.getContext(), "用户异常,请重新登录", Toast.LENGTH_SHORT).show();
//            UserCache.getInstance(this.msgHandler.getContext()).clearUserCache();
            Intent intent = new Intent();
            intent.setData(Uri.parse("nearmcht://view-login"));
            intent.addFlags(335544320);
            this.msgHandler.getContext().startActivity(intent);
        }
    }
}
