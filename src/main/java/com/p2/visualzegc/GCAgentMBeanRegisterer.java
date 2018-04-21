package com.p2.visualzegc;

import com.p2.visualzegc.mbean.GCAgent;
import com.p2.visualzegc.mbean.GCAgentMBean;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by I335831 on 4/21/2018.
 */
public class GCAgentMBeanRegisterer {

    private static GCAgentMBean agentMBean = new GCAgent();

    public static void main(String[] args) throws InterruptedException, MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        initMBean();
        for(;;){
            Thread.sleep(2000);
            System.out.println("MBean Collection Size :" + agentMBean.getCollectionSize());
        }
    }

    private static void initMBean() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName objectName = new ObjectName("com.p2.visualzegc:name=GCAgent");

        mbs.registerMBean(agentMBean, objectName);
    }


}
