/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.client.data;

import io.netty.channel.socket.SocketChannel;

import org.eclipse.scada.protocol.iec60870.apci.MessageChannel;
import org.eclipse.scada.protocol.iec60870.asdu.MessageManager;
import org.eclipse.scada.protocol.iec60870.asdu.message.MessageRegistrator;
import org.eclipse.scada.protocol.iec60870.client.Client;
import org.eclipse.scada.protocol.iec60870.client.ClientModule;

public class DataModule implements ClientModule
{
    private final DataHandler dataHandler;

    private final DataModuleOptions options;

    public DataModule ( final DataHandler dataHandler, final DataModuleOptions options )
    {
        this.dataHandler = dataHandler;
        this.options = options;
    }

    @Override
    public void initializeClient ( final Client client, final MessageManager manager )
    {
        new MessageRegistrator ().register ( manager );
    }

    @Override
    public void initializeChannel ( final SocketChannel channel, final MessageChannel messageChannel )
    {
        channel.pipeline ().addLast ( new DataModuleHandler ( this.dataHandler, this.options ) );
    }

    @Override
    public void dispose ()
    {
    }

}
