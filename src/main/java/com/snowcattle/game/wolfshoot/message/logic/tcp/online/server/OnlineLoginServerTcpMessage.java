package com.snowcattle.game.wolfshoot.message.logic.tcp.online.server;

import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.common.exception.CodecException;
import com.snowcattle.game.service.net.message.AbstractNetProtoBufTcpMessage;
import com.snowcattle.game.wolfshoot.message.auto.tcp.online.server.GameOnlineTCPServerProBuf;
import com.snowcattle.game.wolfshoot.service.net.GameMessageCommandIndex;

/**
 * Created by jiangwenping on 17/2/21.
 */

@MessageCommandAnnotation(command = GameMessageCommandIndex.ONLINE_LOGIN_TCP_SERVER_MESSAGE)
public class OnlineLoginServerTcpMessage extends AbstractNetProtoBufTcpMessage {

    private long playerId;
    private int tocken;

    @Override
    public void decoderNetProtoBufMessageBody() throws CodecException, Exception {

    }

    @Override
    public void release() throws CodecException {

    }

    @Override
    public void encodeNetProtoBufMessageBody() throws CodecException, Exception {
        GameOnlineTCPServerProBuf.OnlineHeartTCPServerProBuf.Builder builder = GameOnlineTCPServerProBuf.OnlineHeartTCPServerProBuf.newBuilder();
        builder.setPlayerId(playerId);
        builder.setTocken(tocken);
        byte[] bytes = builder.build().toByteArray();
        getNetMessageBody().setBytes(bytes);
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public int getTocken() {
        return tocken;
    }

    public void setTocken(int tocken) {
        this.tocken = tocken;
    }
}
