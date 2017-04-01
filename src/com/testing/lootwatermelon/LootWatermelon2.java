package com.testing.lootwatermelon;

/**
 * @author ayorfree
 * @create 2017-04-01-上午8:55
 */

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import static java.lang.System.out;

public class LootWatermelon2 {
    private static AtomicInteger wmCount = new AtomicInteger(0);  //抢到的西瓜计数，这时候改用原子变量
    private static int wmQuantities;  //西瓜总数
    private static int milliseconds;  //sleep时长的上限

    public LootWatermelon2(int wmQuantities, int milliseconds) {
        this.wmQuantities = wmQuantities;
        this.milliseconds = milliseconds;
        out.println("共" + wmQuantities + "个西瓜。");
    }

    public static class Looting implements Callable<String> {
        private String someone;  //哄抢者
        private int someoneWMQuantities = 0;  //每个抢到的西瓜总数

        public Looting(String someone) {
            this.someone = someone;
            out.println(someone + "加入。");
        }

        @Override
        public String call() throws Exception {
            Random random =new Random();  //时长随机数

            while(wmCount.incrementAndGet() <= wmQuantities) {
                someoneWMQuantities++;
                out.println(someone + "抢到本次的第" + wmCount.get() + "个西瓜...其共抢到" + someoneWMQuantities + "个西瓜。");
                Thread.sleep(random.nextInt(milliseconds));  //每次搬抢西瓜所花时间是不同的
            }

            return(someone + "共抢到" + someoneWMQuantities + "个西瓜。");
        }
    }

    public static void main(String[] args) throws Exception, ExecutionException {
        LootWatermelon2 lootWatermelon2 = new LootWatermelon2(10,1000);

        Looting looting1 = new Looting("张三");
        Looting looting2 = new Looting("李四");
        Looting looting3 = new Looting("王二");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String>  future1 = executorService.submit(looting1);
        Future<String>  future2 = executorService.submit(looting2);
        Future<String>  future3 = executorService.submit(looting3);

        try {
            future1.get(1000, TimeUnit.MILLISECONDS);  //假设维护次序人员1000ms后赶到，中断哄抢线程
            future2.get(1000, TimeUnit.MILLISECONDS);
            future3.get(1000, TimeUnit.MILLISECONDS);
            out.println("事件正常结束。");
        } catch(Exception e) {
            out.println("事件被中断："  + future1.cancel(true));
            out.println("事件被中断："  + future2.cancel(true));
            out.println("事件被中断："  + future3.cancel(true));
        }
        executorService.shutdownNow(); //关闭ExecutorService
        out.println(looting1.someone + "共抢到" + looting1.someoneWMQuantities + "个西瓜。");
        out.println(looting2.someone + "共抢到" + looting2.someoneWMQuantities + "个西瓜。");
        out.println(looting3.someone + "共抢到" + looting3.someoneWMQuantities + "个西瓜。");
        out.println("还有" + (wmQuantities - looting1.someoneWMQuantities
                - looting2.someoneWMQuantities
                - looting3.someoneWMQuantities)
                + "个西瓜未被抢走。");
    }
}
