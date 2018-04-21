package com.p2.visualzegc.mbean;

/**
 * Naming convention must have "MBean" suffix
 * Created by I335831 on 4/21/2018.
 */
public interface GCAgentMBean {

    int getCollectionSize();

    void setCollectionSize(int collectionSize);

    //Not to be Garbage Collected
    //Memory Leak here, OOM will happen
    void createGcReachableCollection();

    //To be Garbage Collected
    //No memory leak , Garbage Collection will happen
    void createGcUnReachableCollection();
}
