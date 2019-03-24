package ShutOff;

/**
 * @program: ThreadLearn
 * @description: 通过retrun结束线程
 * @author: Mr.Yqy
 * @create: 2019-03-23 15:28
 **/
public class ReturnEnd extends Thread{
    /**
     * 虽然return也可以实现结束线程的效果但是还是更建议使用
     * 抛出异常的方式结束线程
     * 因为使用异常处理可以更加使程序完善
     * 并且使用return结束会使程序中出现多个return语句
     * 不利于程序的可读性
     */

    @Override
    public void run() {
        try {
        System.out.println(this.getClass().getName()+"的run方法开始运行");
        if(true){
            System.out.println("使用retrun方法结束线程");
            return;
        }
            Thread.sleep(1000);
            System.out.println("线程自己结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
