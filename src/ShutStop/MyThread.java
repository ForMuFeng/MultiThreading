package ShutStop;

/**
 * @program: ThreadLearn
 * @description: 关于线程的暂停
 * @author: Mr.Yqy
 * @create: 2019-03-23 15:44
 **/
public class MyThread{

    /**
     * 线程的暂停和继续可以使用suspend和resume方法实现
     * 但是这两个方法如果使用不当会造成一个问题：独占
     * 因为虽然使用了suspend方法，但是线程并没有释放变量，别的线程并不能访问这个变量
     *
     * thread类中还有yield方法，这个方法可以使得线程放弃现在的cpu资源，将它让给别的任务占用cpu
     * 但是问题在于可能刚刚释放又重新获得了cpu资源
     * 下面写一个方法来感受这种情况
     */
    public static class Thread1 extends Thread{

        @Override
        public void run() {
            try {
                System.out.println(this.getClass().getName()+"开始运行");
                long time1=System.currentTimeMillis();
                for(int i=1;i<5000000;i++){
//                    Thread.yield();
                }
                long time2=System.currentTimeMillis();
                System.out.println("花费时间"+(time2-time1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static class Test1 {
        public static void main(String[] args) {
            Thread1 a=new Thread1();
            a.start();
        }
    }

    /**
     *
     * 在这个Main中运行时，如果使用注释，则时间为4ms，但是如果取消注释，则时间需要2000ms左右
     *
     */


    /**
     * 接下来介绍一下线程的优先级：
     * 1.线程的优先级具有继承的特性，即如果你使用线程A启动了线程B，那么A和B的优先级是一样的
     * 2.线程可以使用setPriority来更改优先级
     *   注意：高优先级的线程总是大部分先执行完，但是这不代表高优先级的线程全部先执行完。
     *   同时，线程的优先级和代码的执行顺序是无关的。
     *   下面用一个事例来演示这种情况
     * 3.线程的优先级是有随机性的，虽然说大多数情况下优先级高的线程会被先执行完，但是也有少数相反的情况发生
     *
     */

    public static class  Thread3 extends Thread{
        @Override
        public void run() {
            for(int i=1;i<500000000;i++);
            System.out.println("线程3执行");
        }
    }
    public static class  Thread4 extends Thread{
        @Override
        public void run() {
            for(int i=1;i<500000000;i++);
            System.out.println("线程4执行");
        }
    }
    public static class Test2{
        public static void main(String[] args) {
            for(int i=0;i<5;i++){
                Thread a=new Thread3();
                Thread b=new Thread4();
                a.setPriority(10);
                b.setPriority(1);
                b.start();
                a.start();
            }

        }
    }

}
