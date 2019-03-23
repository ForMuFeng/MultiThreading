package ShutOff;

/**
 * @program: ThreadLearn
 * @description: 测试线程
 * @author: Mr.Yqy
 * @create: 2019-03-23 14:52
 **/
public class Exception_Stop implements Runnable{

    /**
     * 使用抛出异常的方式停止线程的好处
     * 可以进行异常处理，方便进行抛出异常的定位
     *
     */

    //使用异常停止线程
    @Override
    public void run() {
        System.out.println(this.getClass().getName()+"开始工作");
        try {
            System.out.println("运行状态："+Thread.interrupted());
            Thread.sleep(1000);
            if (true){
                throw  new InterruptedException();
            }
            Thread.sleep(1000);
            System.out.println("线程自我运行结束");
            } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("线程被停止了");
        }
    }


}
