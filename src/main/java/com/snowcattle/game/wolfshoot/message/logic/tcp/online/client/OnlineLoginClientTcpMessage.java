package com.snowcattle.game.wolfshoot.message.logic.tcp.online.client;

import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.service.net.message.AbstractNetProtoBufTcpMessage;
import com.snowcattle.game.wolfshoot.message.auto.tcp.online.client.GameOnlineTCPClientProBuf;
import com.snowcattle.game.wolfshoot.service.net.GameMessageCommandIndex;

/**
 * Created by jiangwenping on 17/2/21.
 */
@MessageCommandAnnotation(command = GameMessageCommandIndex.ONLINE_LOGIN_TCP_CLIENT_MESSAGE)
public class OnlineLoginClientTcpMessage extends AbstractNetProtoBufTcpMessage {

    private int id;

    public OnlineLoginClientTcpMessage(){
        setCmd(GameMessageCommandIndex.ONLINE_LOGIN_TCP_CLIENT_MESSAGE);
    }

    @Override
    public void decoderNetProtoBufMessageBody() throws Exception {
        byte[] bytes = getNetMessageBody().getBytes();
        GameOnlineTCPClientProBuf.OnlineLoginTCPClientProBuf req = GameOnlineTCPClientProBuf.OnlineLoginTCPClientProBuf.parseFrom(bytes);
        setId(req.getId());
    }

    @Override
    public void release() {

    }

    @Override
    public void encodeNetProtoBufMessageBody() throws Exception {
        GameOnlineTCPClientProBuf.OnlineLoginTCPClientProBuf.Builder builder = GameOnlineTCPClientProBuf.OnlineLoginTCPClientProBuf.newBuilder();
        builder.setId(getId());
        byte[] bytes = builder.build().toByteArray();
        getNetMessageBody().setBytes(bytes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

