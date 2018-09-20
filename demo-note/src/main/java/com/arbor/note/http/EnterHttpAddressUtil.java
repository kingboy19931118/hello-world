package com.arbor.note.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

/**
 * @author qiaomu.wang
 * @date 2018-09-18
 */
public class EnterHttpAddressUtil {
    private transient static final Logger log = LoggerFactory.getLogger(EnterHttpAddressUtil.class);
    private static BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(50);
    private static ThreadFactory factory = new ThreadPoolExecutorFactoryBean();

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 30, 5L, TimeUnit.SECONDS, blockingQueue, factory);

    private CloseableHttpClient httpClient = HttpClients.createDefault();
//    private HttpGet get = new HttpGet("http://www.hljhwnc.com/new_er.php?class_id=141&id=3759");
    private HttpGet get = new HttpGet("http://www.hljhwnc.com/new_er.php?class_id=142&id=3758");

    static {
        executor.allowCoreThreadTimeOut(true);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                EnterHttpAddressUtil util = new EnterHttpAddressUtil();
                for (int j = 0; j < 100000; j++) {
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "已经执行次数：" + j);
                    util.sendGet();
                }
                util.closeIO();
            });
        }

//        for (int i = 0; i < 10000; i++) {
//            System.out.println("已经执行次数：" + i);
//            sendGet("http://www.hljhwnc.com/new_er.php?class_id=141&id=3759");
//        }
    }

    private void sendGet() {
        try {
//            get.setHeader("Content-Type", "application/x-www-form-urlencoded");
//            StringEntity stringEntity = new StringEntity(convertToUrlFormEncodedString(elemeCommonVO), "UTF-8");
//            stringEntity.setContentType("application/x-www-form-urlencoded");
//            get.setEntity(stringEntity);

//            System.out.println(JSON.toJSONString(get));

            CloseableHttpResponse response = httpClient.execute(get);
            response.close();
//            HttpEntity entity = response.getEntity();
//            String entityString = EntityUtils.toString(entity);

//            System.out.println(entityString);

//            ElemeCommonVO vo = JSON.parseObject(entityString, ElemeCommonVO.class);

//            System.out.println(vo);
//            return entityString;

        } catch (UnsupportedEncodingException e) {
            log.error("httpclient request error", e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (httpClient != null) {
//                try {
//                    httpClient.close();
//                } catch (IOException e) {
//                    log.error("close httpclient error", e);
//                }
//            }
        }
    }

    private void closeIO() {
        try {
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (UnsupportedEncodingException e) {
            log.error("httpclient request error", e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    log.error("close httpclient error", e);
                }
            }
        }
    }
}
