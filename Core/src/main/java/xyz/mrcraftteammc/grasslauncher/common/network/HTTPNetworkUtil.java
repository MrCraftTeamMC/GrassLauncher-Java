package xyz.mrcraftteammc.grasslauncher.common.network;

import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

@Deprecated
public class HTTPNetworkUtil {
    public static final int TIMEOUTS = 3000;
    public static final int connectionPoolSize = 1000;
    public static ConnectionPool mConnectionPool = new ConnectionPool(connectionPoolSize, 30, TimeUnit.MINUTES);
    //executor = new ThreadPoolExecutor(0, 2147483647, ...这个是静态的，21亿连接数量
//    private static RealConnectionPool mConnectionPool=new RealConnectionPool(connectionPoolSize, 30, TimeUnit.MINUTES);
    public static final String ContentType = "application/json;charset=utf-8";
    public static final String AcceptType = "application/json;charset=utf-8";
    public static final MediaType MediaType_ContentType = MediaType.parse(ContentType);

    public static OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
//                .addInterceptor(new RetryIntercepter(3))//重试3次
//                .addInterceptor(new GzipRequestInterceptor())//gzip压缩
                .connectTimeout(TIMEOUTS, TimeUnit.MILLISECONDS) //连接超时
                .readTimeout(TIMEOUTS, TimeUnit.MILLISECONDS) //读取超时
                .writeTimeout(TIMEOUTS, TimeUnit.MILLISECONDS) //写超时
                .callTimeout(TIMEOUTS, TimeUnit.MILLISECONDS)
                // okhttp默认使用的RealConnectionPool初始化线程数==2147483647，在服务端会导致大量线程TIMED_WAITING
                //ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
                .connectionPool(mConnectionPool)
                .build();
    }
}
