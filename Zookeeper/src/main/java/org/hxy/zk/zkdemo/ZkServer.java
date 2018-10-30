package org.hxy.zk.zkdemo;

import org.apache.zookeeper.*;

public class ZkServer {
    private static String connectString = "zookeeper01:2181,zookeeper02:2181,zookeeper02:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zooKeeper = null;
    private String parentNode = "/servers";

    //创建zk的客户端连接
    public void getConnect() throws Exception {
        zooKeeper = new ZooKeeper(connectString,sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType()+"-----"+watchedEvent.getPath());
                try {
                    //再次启动监听
                    zooKeeper.getChildren("/",true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //注册服务器
    public void registerServer(String hostname) throws Exception {
        String create = zooKeeper.create(parentNode + "/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname + " is online " + create);
    }

    //业务功能
    public void business(String hostname) throws Exception {
        System.out.println(hostname + " is working~~~");
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {
        //获取zk链接
        ZkServer zkServer = new ZkServer();
        zkServer.getConnect();
        //利用zk链接注册服务器信息
        zkServer.registerServer(args[0]);

        //启动业务功能
        zkServer.business(args[0]);
    }

}
