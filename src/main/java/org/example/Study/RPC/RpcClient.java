/**
 * meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package org.example.Study.RPC;

/**
 * @author liushixing@meituan.com
 * @date 2023/5/11 11:41
 */
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RpcClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // 发送请求数据给服务端
            RpcRequest rpcRequest = new RpcRequest("world"); // 构造请求数据
            output.writeObject(rpcRequest);

            // 接收服务端返回的响应数据
            RpcResponse rpcResponse = (RpcResponse) input.readObject();
            String result = rpcResponse.result;

            input.close();
            output.close();
            socket.close();

            // 处理响应数据
            System.out.println("Service result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

