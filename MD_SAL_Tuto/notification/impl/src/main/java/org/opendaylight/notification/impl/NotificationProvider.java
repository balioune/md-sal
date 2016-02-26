/*
 * Alioune BA and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.notification.impl;

//The following notification will generate error (see logs)
//import org.opendaylight.controller.md.sal.binding.api.NotificationService;
import org.opendaylight.controller.sal.binding.api.NotificationService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataBroker.DataChangeScope;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NotificationProvider implements BindingAwareProvider, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationProvider.class);
    public static final InstanceIdentifier<Nodes>  iid = InstanceIdentifier.builder(Nodes.class).build();
    
    //public static final InstanceIdentifier<Node>  iid1 = InstanceIdentifier.create(Nodes.class)
    //		.child(Node.class).builder().build();
    
    //public static final InstanceIdentifier<Node>  iid1 = InstanceIdentifier.builder(Nodes.class)
    //		.child(Node.class, new NodeKey(new NodeId("openflow:1"))).build();

    private ListenerRegistration<DataChangeListener> listener;

    @Override
    public void onSessionInitiated(ProviderContext session) {
    	DataBroker dataservice = session.getSALService(DataBroker.class);
    	NotificationService notificationService = session.getSALService(NotificationService.class);
    	/**
    	 * Register to OpendaylightInventoryListener service
    	 */
    	//notificationService.registerNotificationListener(new MoonListener());
    	/**
    	 * Register to DataChangeListener service
    	 */
    	listener = dataservice.registerDataChangeListener(LogicalDatastoreType.OPERATIONAL, 
    			iid, new MoonDataListener(), DataChangeScope.SUBTREE);
        LOG.info("NotificationProvider Session Initiated");
    }

    @Override
    public void close() throws Exception {
        LOG.info("NotificationProvider Closed");
    }

}
