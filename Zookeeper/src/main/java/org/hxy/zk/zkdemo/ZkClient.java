package org.hxy.zk.zkdemo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ZkClient {
    private static String connectString = "zookeeper01:2181,zookeeper02:2181,zookeeper02:2181";
    private static int sessionTimeout = 2000;
    private ZooKeeper zooKeeper = null;
    private String parentNode = "/servers";
    //获取连接
    public void getConnect() throws Exception {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType()+"-----"+watchedEvent.getPath());
                try {
                    getServers();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //监听节点变化
    public void getServers() throws Exception {
        //监听parentNode路径子节点
        List<String> children = zooKeeper.getChildren(parentNode, true);
        List<String> servers = new ArrayList<>();
        //获取子节点信息
        for (String child:children) {
            byte[] data = zooKeeper.getData(parentNode + "/" + child, false, null);
            servers.add(new String(data));
        }

        //打印数据
        System.out.println(servers);
    }

    //实现自己的业务逻辑
    public void business() throws InterruptedException {
        System.out.println("Client is working~");
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {
        //获取连接
        ZkClient zkClient = new ZkClient();
        zkClient.getConnect();
        //监听节点变化
        zkClient.getServers();
        //实现自己的业务逻辑
        zkClient.business();
    }
}
