package org.hxy.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZkClient {

    //private String connectString = "192.168.1.237:2181,192.168.1.239:2181,192.168.1.240:2181";
    private String connectString = "zookeeper01:2181,zookeeper02:2181,zookeeper03:2181";
    private Integer sessionTimeout = 2000;
    private ZooKeeper zooKeeper = null;

    @Before
    public void initZK() throws IOException {
            zooKeeper = new ZooKeeper(connectString,sessionTimeout,new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType()+"======"+watchedEvent.getPath());
                try {
                    Stat exists = zooKeeper.exists("/hxy", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Test
    public void  initNodes() throws Exception {
        String s = zooKeeper.create("/hxy", "940906".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);
    }

    @Test
    public void getNodes() throws Exception {
        List<String> children = zooKeeper.getChildren("/", false);
        children.forEach(System.out::println);
    }

    @Test
    public void testExist() throws Exception {
        Stat stat = zooKeeper.exists("/hxy", true);
        System.out.println(stat==null?"Not Exist":"Exist");

        Thread.sleep(Long.MAX_VALUE);
    }
}
