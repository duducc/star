package learn.basic.extend_study.extend3;

/**
 * 在父子类的继承关系当中  成员方法的访问也有一定的规则
 *
 * 在父子类的继承关系当中，创建子类对象，访问成员方法的规则：
 *   创建的对象是谁，就优先用谁，如果没有则向上找。
 *
 *   注意事项：
 *      无论是成员方法还是成员变量，如果没有都是向上找父类，绝对不会向下找子类的。  都是向上找父类 绝对不会向下找子类 例 段正淳 是不知道自己孩子是谁
 *
 *
 *    重写（Override）
 *    概念：在继承关系当中，你得先有继承，方法的名称一样，参数列表也一样，具体实现不一样
 *
 *    重写（Override）；方法的名称一样，参数列表【也一样】  覆盖  覆写
 *    重载（Overload）：方法的名称一样，参数列表【不一样】
 *
 *    方法的覆盖重写特点：创建的是子类对象，则优先用子类方法。  它new的谁 用的就是谁
 *
 */
public class Demo01ExtendsMethod {
    public static void main(String[] args) {
        Zi zi = new Zi();
        //可以发现  既有methodZi   也有methodFu  因为它继承了呀  所以你都能进行调用
        zi.methodFu();//父类方法执行！
        zi.methodZi();//子类方法执行！

        //关键就在重名的时候怎么办

        //Zi zi = new Zi();  创建对象  右边是new的谁  就优先用谁  这时是Zi()
        //创建的是new了子类对象，所以优先用子类方法  没有你在往上找
        zi.method();
    }

}
