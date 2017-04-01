package com.testing.lootwatermelon;

import java.util.Random;
import java.util.concurrent.*;

import static java.lang.System.out;

/**
 * @author ayorfree
 * @create 2017-04-01-上午8:42
 */

public class LootWatermelon {
    public static void main(String[] args) throws Exception{
        Looting looting = new Looting(10, 1000);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(looting);

        try {
            future.get(2000, TimeUnit.MILLISECONDS);
            out.println("事件正常结束。");
        }catch (Exception e){
            out.println("事件被打断： " + future.cancel(true));
        }
        executorService.shutdownNow();
    }
}

class Looting implements Callable<String>{
    private int wmQuantities;
    private int milliseconds;

    public Looting(int wmQuantities, int milliseconds){
        this.wmQuantities = wmQuantities;
        this.milliseconds = milliseconds;
        out.println("共" + wmQuantities + "个西瓜");
    }

    @Override
    public String call() throws Exception{
        int wmCount = 0;
        Random random = new Random();

        while (++wmCount <= wmQuantities){
            out.println("抢到" + wmCount + "个西瓜...");
            Thread.sleep(random.nextInt(milliseconds));
        }
        return ("本次" + wmQuantities + "个西瓜中，抢了" + (wmCount - 1) + "个。");
    }


}
