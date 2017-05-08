package com.snowcattle.game.wolfshoot.message.logic.tcp.online.client;

import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.service.net.message.AbstractNetProtoBufTcpMessage;
import com.snowcattle.game.wolfshoot.message.auto.tcp.online.client.GameOnlineTCPClientProBuf;
import com.snowcattle.game.wolfshoot.service.net.GameMessageCommandIndex;

/**
 * Created by jiangwenping on 17/2/8.
 */
@MessageCommandAnnotation(command = GameMessageCommandIndex.ONLINE_HEART_CLIENT_TCP_MESSAGE)
public class OnlineHeartClientTcpMessage extends AbstractNetProtoBufTcpMessage {

    private int id;

    public OnlineHeartClientTcpMessage(){
        setCmd(GameMessageCommandIndex.ONLINE_HEART_CLIENT_TCP_MESSAGE);
    }

    @Override
    public void decoderNetProtoBufMessageBody() throws Exception {
        byte[] bytes = getNetMessageBody().getBytes();
        GameOnlineTCPClientProBuf.OnlineHeartTCPClientProBuf req = GameOnlineTCPClientProBuf.OnlineHeartTCPClientProBuf.parseFrom(bytes);
        setId(req.getId());
    }

    @Override
    public void release() {

    }

    @Override
    public void encodeNetProtoBufMessageBody() throws Exception {
        GameOnlineTCPClientProBuf.OnlineHeartTCPClientProBuf.Builder builder = GameOnlineTCPClientProBuf.OnlineHeartTCPClientProBuf.newBuilder();
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
