package learn.basic.multi_study.multibasic;

/**
 * 面向对象的三大特征：
 *   封装性：
 *   继承性：除了有extends，还有implements ，  extends继承或者implements实现，是多态性的前提
 *          不一定是类与类之间的继承  还有可能是接口与接口之间的继承 还有可能是类与接口的实现
 *          反正你得产生一个上下级的关系，这才有了多态性的前提
 *
 *      其中继承性是多态性的前提
 *
 *   多态性：不是多种状态，而是多种形态
 *
 *
 *   举例：
 *      有一个人类 把它当作  父类
 *            有两个子类(不管是继承还是实现都能作为多态的前提) 分别是 学生 和 员工
 *            假如我现在有一个对象，这个对象就是小明
 *            那我们来看  小明同学  它就是一个学生
 *            小明是一个学生，但同时也是一个人。  从子类往上看  学生是不是人  那肯定是啊  员工是不是人 那肯定也是啊 那子类就是一个父类  学生就是一个人
 *            小明既是一个学生，同时也是一个人  那这就是两种形态  一个叫作学生形态 一个叫作人类形态
 *
 *            那我们来看 小明是一个对象， 这个对象既是学生也是人 ，那就是既有学生形态，也有人类形态。 所以我们说
 *            一个对象拥有多种形态，这就是：对象的多态性。  注意：多态性说的是这个对象  可不是这个类
 *            是小明这个人 有了学生形态和人类形态  一个是我自己 一个是我父类 是这个对象它同时拥有两种形态 这叫做对象的多态性
 *
 *
 *   代码当中体现多态性，其实就是一句话：父类引用指向子类对象。
 *   格式：
 *     父类名称  对象名  =  new  子类名称();  这就是左父右子  这样就能体现我们代码当中的多态性
 *     接口名称  对象名  =  new  实现类名称();
 *
 */
public class MultiSummary {


    public static void main(String[] args) {

        //此时我们发现 Fu类 和 Zi类  这两个方法长得是一样的  此前我们在创建对象都是Zi zi = new  Zi();  跟Fu没什么关系
        //那我们现在就要用多态的写法

        //使用多态的写法
        //左侧父类的引用，指向了右侧子类的对象
        Fu obj = new Zi();

        //如果调用了下面这个方法  它会优先用谁的呢
        //首先method()是一个成员方法， 看右边new的是谁那就运行谁  右边new的是Zi()  Zi当中有没有  有叫method()   运行结果是子类方法
        obj.method();
        //那如果要是子类没有怎么办呢  我们来调用一下看结果
        //没有那就往上找 对吗  对  运行结果是  父类特有方法
        //规则我们此前已经接触过了 只不过现在呢 我把这个概念告诉大家  什么叫做多态  一句话 左父右子 就叫做多态
        //那么在这里呢右侧子类对象 就被当作父类进行使用  一只猫被当作动物来看待是没有什么问题的 因为子类就是一个父类
        //在这里体现了面向对象的多态性
        obj.methodFu();


    }
}
