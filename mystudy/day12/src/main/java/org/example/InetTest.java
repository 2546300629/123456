package org.example;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetTest {
    public static void main(String[] args) {
        InetTest in = new InetTest();
        in.getIpAddress();
    }

    public void getIpAddress() {
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println("IP4形式获取:"+localHost);
        System.out.println("byte数组形式获取IP:"+Arrays.toString(localHost.getAddress()));
        System.out.println("字符串形式获取IP:"+localHost.getHostAddress());
        System.out.println("字符串形式获取主机名:"+localHost.getHostName());
        System.out.println("字符串形式获取完全限定域名:"+localHost.getCanonicalHostName());
        System.out.println("IP4获取哈希码:"+localHost.hashCode());
        InetAddress loop4 = Inet4Address.getLoopbackAddress();
        System.out.println(loop4);
        InetAddress local6 = null;
        try {
            local6 = Inet6Address.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println("IP6获取:"+local6);
        System.out.println("byte数组形式获取IP:"+Arrays.toString(local6.getAddress()));
        System.out.println("IP6与IP4相等?"+local6.equals(localHost));
        System.out.println(local6==localHost);
        System.out.println("IP6获取哈希码:"+local6.hashCode());
    }
}
