/*
 * Alioune BA and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.notification.impl;

import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorRemoved;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorUpdated;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRemoved;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeUpdated;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.OpendaylightInventoryListener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoonListener implements OpendaylightInventoryListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(DataChangeListener.class);

	@Override
	public void onNodeConnectorRemoved(NodeConnectorRemoved arg0) {
		// TODO Auto-generated method stub
		//LOG.info("Provider NodeConnector Removed "+ arg0.toString());
		Object object = arg0.getClass();
		LOG.info("Printing Object "+ object.toString());
	}
	@Override
	public void onNodeConnectorUpdated(NodeConnectorUpdated arg0) {
		// TODO Auto-generated method stub
		//LOG.info("Provider NodeConnector Removed "+ arg0.toString());
		Object object = arg0.getClass();
		LOG.info("Printing Object "+ object.toString());
		
	}
	@Override
	public void onNodeRemoved(NodeRemoved arg0) {
		// TODO Auto-generated method stub
		//LOG.info("Provider NodeConnector Removed "+ arg0.toString());
		Object object = arg0.getClass();
		if (object instanceof Node)
			LOG.info("Printing toString "+ arg0.toString());
		
	}
	@Override
	public void onNodeUpdated(NodeUpdated arg0) {
		// TODO Auto-generated method stub
		//LOG.info("Provider Node Updated "+ arg0.getId().getValue());
		Object object = arg0.getClass();
		if (object instanceof Node)
			LOG.info("Printing toString "+ arg0.toString());
		
		
		//LOG.info("Provider Node Updated "+ arg0.getClass());
		
	}

}
