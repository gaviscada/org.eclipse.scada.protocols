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
package org.eclipse.scada.protocol.modbus.slave;

import org.eclipse.scada.protocol.modbus.message.BaseMessage;

public interface SessionContext
{

    public void sendExceptionReply ( BaseMessage baseMessage, int exceptionCode );

    public void sendReadReply ( BaseMessage baseMessage, int[] data );

    public void sendReadReply ( BaseMessage baseMessage, boolean[] data );

}