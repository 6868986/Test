/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPC;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/11 11:40
 */

import javax.annotation.Resource;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RpcServer {

    @Resource
    static
    HelloService helloService;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                // 接收客户端发送过来的请求数据
                RpcRequest rpcRequest = (RpcRequest) input.readObject();

                // 调用服务方法，并返回处理结果
                String result = invokeMethod(rpcRequest);

                // 将处理结果写入响应数据并发送回客户端
                RpcResponse rpcResponse = new RpcResponse(result);
                output.writeObject(rpcResponse);

                input.close();
                output.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String invokeMethod(RpcRequest rpcRequest) {
        // TODO: 根据请求数据调用相应的服务方法，并返回处理结果
        return helloService.hello(rpcRequest.name);
    }
}

