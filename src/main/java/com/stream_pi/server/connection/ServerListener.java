package com.stream_pi.server.connection;

import com.stream_pi.action_api.normalaction.NormalAction;
import com.stream_pi.action_api.normalaction.ToggleAction;
import com.stream_pi.util.exception.SevereException;

public interface ServerListener
{
    boolean onNormalActionClicked(NormalAction action);
    boolean onToggleActionClicked(ToggleAction action, boolean toggle);

    void clearTemp();

    void init();

    void othInit();

    void initLogger() throws SevereException;
}
