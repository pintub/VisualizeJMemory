package com.p2.visualzegc.mbean;

import java.util.ArrayList;
import java.util.List;

/**Naming convention must be =  MBean interface name - "MBean"
 * Created by I335831 on 4/21/2018.
 */
public class GCAgent implements GCAgentMBean {

    private int collectionSize;

    @Override
    public int getCollectionSize() {
        return collectionSize;
    }

    @Override
    public void setCollectionSize(int collectionSize) {
        this.collectionSize = collectionSize;
    }

    @Override
    public void createGcReachableCollection() {
        List<String> fatList = getFatCollection(collectionSize);
    }

    @Override
    public void createGcUnReachableCollection() {
        getFatCollection(collectionSize);
    }

    private List<String> getFatCollection(int size){
        List<String> fatList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            fatList.add("String" + i );
        }

        return fatList;
    }

}
