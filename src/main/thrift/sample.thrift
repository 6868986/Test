namespace java com.meituan.sample

struct Request {
    1:i32 userId,
    2:string content
}

service HelloService {
    Request sayHello(1:Request request)
}
