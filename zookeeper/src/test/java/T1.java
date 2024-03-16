import org.apache.curator.RetryLoop;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class T1 {
    private CuratorFramework client;

    @Before
    public void test1() {
        RetryPolicy policy = new ExponentialBackoffRetry(1000, 3);
//        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", 1000 * 60, 10000, policy);
        client = CuratorFrameworkFactory.builder().namespace("byh")
                .connectString("127.0.0.1:2181")
                .sessionTimeoutMs(1000 * 60)
                .connectionTimeoutMs(1000 * 60)
                .retryPolicy(policy)
                .build();
        client.start();
    }

    @After
    public void test2() {
        if (client != null) {
            client.close();
        }
    }

    @Test
    public void test3() throws Exception {
        System.out.println(client.create().forPath("/app1", "123".getBytes()));
    }

    @Test
    public void test4() throws Exception {
        System.out.println(new String(client.getData().forPath("/app1")));
        System.out.println(client.getChildren().forPath("/"));
//        System.out.println(client.getACL().forPath("/"));
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        System.out.println(stat);
    }

    @Test
    public void test5() throws Exception {
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        int v = stat.getVersion();
        client.setData().withVersion(v).forPath("/app1", "777".getBytes());
    }

    @Test
    public void test6() throws Exception {
        System.out.println(client.delete().forPath("/app1"));
    }





}
