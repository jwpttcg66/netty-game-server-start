package com.snowcattle.game.wolfshoot.message.handler.auto.online;

import com.snowcattle.game.common.annotation.MessageCommandAnnotation;
import com.snowcattle.game.message.handler.AbstractMessageHandler;
import com.snowcattle.game.message.logic.tcp.online.client.OnlineLoginClientTcpMessage;
import com.snowcattle.game.service.net.message.AbstractNetMessage;
import com.snowcattle.game.wolfshoot.service.net.GameMessageCommandIndex;

/**
 * Created by jiangwenping on 17/2/21.
 */

public abstract class OnlineTcpHandler extends AbstractMessageHandler {
    @MessageCommandAnnotation(command = GameMessageCommandIndex.ONLINE_LOGIN_TCP_CLIENT_MESSAGE)
    public AbstractNetMessage handleOnlineLoginClientTcpMessage(OnlineLoginClientTcpMessage message) throws Exception{
        return handleOnlineLoginClientTcpMessageImpl(message);
    }

    public abstract AbstractNetMessage handleOnlineLoginClientTcpMessageImpl(OnlineLoginClientTcpMessage message) throws Exception;
}
