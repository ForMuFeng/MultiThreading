package ShutOff;

/**
 * @program: ThreadLearn
 * @description: 测试类
 * @author: Mr.Yqy
 * @create: 2019-03-23 14:58
 **/
public class Test {
    public static void main(String[] args) {
        Exception_Stop exception_stop=new Exception_Stop();
        exception_stop.run();

        System.out.println("-----------------分界线----------------------");
        Return_Stop return_stop=new Return_Stop();
        return_stop.run();
    }
}
