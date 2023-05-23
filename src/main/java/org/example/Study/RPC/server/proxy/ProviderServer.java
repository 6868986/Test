/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPC.server.proxy;

import org.example.Study.RPC.server.request.Request;
import org.example.Study.RPC.server.response.Response;
import org.example.Study.RPC.server.service.HelloService;
import org.example.Study.RPC.server.service.HelloServiceImpl;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/19 15:49
 */
public class ProviderServer {

    @Resource
    HelloService helloService;

    public static void main(String[] args) throws IOException {
        new ProviderServer().run();
    }

    public void run() throws IOException {

        ServerSocket listener = new ServerSocket(9090);
        try{
            //未引入线程池
            while(true){
                Socket socket = listener.accept();
                try{
                    //将请求反序列化
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    Object object = objectInputStream.readObject();

                    //调用HelloServiceImpl服务
                    String res = null;
                    if(object instanceof Request){
                        Request request = (Request) object;
                        if("hello".equals(request.getMethod())){
                            //通过反射调用服务方法（Spring工厂底层通过反射调用 method.invoke)
                            res = helloService.hello(request.getName());
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }

                    //返回结果
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(new Response(res));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }

    }
}
