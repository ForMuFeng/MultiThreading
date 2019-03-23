package ShutOff;

/**
 * @program: ThreadLearn
 * @description: 测试类
 * @author: Mr.Yqy
 * @create: 2019-03-23 14:58
 **/
public class Test {
    public static void main(String[] args) {
        ExceptionEnd exception_stop=new ExceptionEnd();
        exception_stop.run();

        System.out.println("-----------------分界线----------------------");
        ReturnEnd return_stop=new ReturnEnd();
        return_stop.run();
    }
}
