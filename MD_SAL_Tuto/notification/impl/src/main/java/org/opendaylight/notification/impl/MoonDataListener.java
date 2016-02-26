package org.opendaylight.notification.impl;

import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoonDataListener implements DataChangeListener, AutoCloseable{
	
	 private static final Logger LOG = LoggerFactory.getLogger(MoonDataListener.class);
	 public static final InstanceIdentifier<Node>  iid = InstanceIdentifier.builder(Nodes.class)
	    		.child(Node.class, new NodeKey(new NodeId("openflow:1"))).build();


	@Override
	public void onDataChanged(AsyncDataChangeEvent<InstanceIdentifier<?>, DataObject> event) {
		// TODO Auto-generated method stub
	       if(event.getCreatedData().containsKey(iid) ) {
	            if(event.getCreatedData().get(iid) instanceof Node) {
	                LOG.info("onDataChanged - new Node created: "+event.getCreatedData().toString() );
	            }
	            quietClose();
	        } else if (event.getUpdatedData().containsKey(iid)) {
	            if(event.getUpdatedData().get(iid) instanceof Node) {
	                LOG.info("onDataChanged - new Node updated: "+event.getCreatedData().toString() );
	            }
	            quietClose();
	        }
		//LOG.info("onDataChanged class "+ arg0.getClass());
	}
	
    private void quietClose() {
        try {
            this.close();
        } catch (Exception e) {
            throw new IllegalStateException("Unable to close registration",e);
        }
    }

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
