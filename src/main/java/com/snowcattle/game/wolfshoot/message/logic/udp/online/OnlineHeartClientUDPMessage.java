package com.snowcattle.game.wolfshoot.message.logic.udp.online;

import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.service.net.message.AbstractNetProtoBufUdpMessage;
import com.snowcattle.game.wolfshoot.message.auto.udp.online.GameOnlineUDPProBuf;
import com.snowcattle.game.wolfshoot.service.net.GameMessageCommandIndex;

/**
 * Created by jwp on 2017/2/16.
 */
@MessageCommandAnnotation(command = GameMessageCommandIndex.ONLINE_HEART_CLIENT_UDP_MESSAGE)
public class OnlineHeartClientUDPMessage extends AbstractNetProtoBufUdpMessage {

    private int id;

    @Override
    public void decoderNetProtoBufMessageBody() throws Exception {
        byte[] bytes = getNetMessageBody().getBytes();
        GameOnlineUDPProBuf.OnlineHeartUDPProBuf req = GameOnlineUDPProBuf.OnlineHeartUDPProBuf.parseFrom(bytes);
        setId(req.getId());
    }

    @Override
    public void release() {

    }

    @Override
    public void encodeNetProtoBufMessageBody() throws Exception {
        GameOnlineUDPProBuf.OnlineHeartUDPProBuf.Builder builder = GameOnlineUDPProBuf.OnlineHeartUDPProBuf.newBuilder();
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

