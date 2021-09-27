package learn.basic.abstract_interface_study;

/**
 * 深入理解Java的接口和抽象类
 *
 *   对于面向对象编程来说，抽象是它的一大特征。
 *   在Java中，可以通过两种形式来体现OOP的抽象：接口和抽象类。
 *   这两者有太多相似的地方，又有太多不同的地方。
 *   很多人在初学的时候会以为它们可以随意互换使用，但是实际则不然。
 *   今天我们就一起来学习一下Java中的接口和抽象类。下面是本文的目录大纲：
 *   一.抽象类
 *        在了解抽象类之前，先来了解一下抽象方法。抽象方法是一种特殊的方法：它只有声明，而没有具体的实现。抽象方法的声明格式为：
 *        abstract void fun();
 *        抽象方法必须用abstract关键字进行修饰。如果一个类含有抽象方法，则称这个类为抽象类，抽象类必须在类前用abstract关键字修饰。
 *        因为抽象类中含有无具体实现的方法，所以不能用抽象类创建对象。
 *       下面要注意一个问题：在《JAVA编程思想》一书中，将抽象类定义为“包含抽象方法的类”，
 *       但是后面发现如果一个类不包含抽象方法，只是用abstract修饰的话也是抽象类。
 *       也就是说抽象类不一定必须含有抽象方法。
 *       个人觉得这个属于钻牛角尖的问题吧，因为如果一个抽象类不包含任何抽象方法，为何还要设计为抽象类？所以暂且记住这个概念吧，不必去深究为什么。
 *      [public] abstract class ClassName {
 *           abstract void fun();
 *      }
 *      从这里可以看出，抽象类就是为了继承而存在的，如果你定义了一个抽象类，却不去继承它，那么等于白白创建了这个抽象类，因为你不能用它来做任何事情。
 *      对于一个父类，如果它的某个方法在父类中实现出来没有任何意义，必须根据子类的实际需求来进行不同的实现，那么就可以将这个方法声明为abstract方法，此时这个类也就成为abstract类了。
 *      包含抽象方法的类称为抽象类，但并不意味着抽象类中只能有抽象方法，它和普通类一样，同样可以拥有成员变量和普通的成员方法。注意，抽象类和普通类的主要有三点区别：
 *       1）抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），缺省情况下默认为public。
 *       2）抽象类不能用来创建对象；
 *       3）如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法。如果子类没有实现父类的抽象方法，则必须将子类也定义为为abstract类。
 *     在其他方面，抽象类和普通的类并没有区别。
 *
 *   二.接口
 *      接口，英文称作interface，在软件工程中，接口泛指供别人调用的方法或者函数。
 *      从这里，我们可以体会到Java语言设计者的初衷，它是对行为的抽象。
 *      在Java中，定一个接口的形式如下：
 *      [public] interface InterfaceName {
 *
 *      }
 *      接口中可以含有变量和方法。
 *      但是要注意，接口中的变量会被隐式地指定为public static final变量（并且只能是public static final变量，用private修饰会报编译错误），
 *      而方法会被隐式地指定为public abstract方法且只能是public abstract方法（用其他关键字，比如private、protected、static、 final等修饰会报编译错误），
 *      并且接口中所有的方法不能有具体的实现，也就是说，接口中的方法必须都是抽象方法。
 *      从这里可以隐约看出接口和抽象类的区别，接口是一种极度抽象的类型，它比抽象类更加“抽象”，并且一般情况下不在接口中定义变量。
 *      要让一个类遵循某组特地的接口需要使用implements关键字，具体格式如下：
 *      class ClassName implements Interface1,Interface2,[....]{
 *
 *      }
 *     可以看出，允许一个类遵循多个特定的接口。如果一个非抽象类遵循了某个接口，就必须实现该接口中的所有方法。对于遵循某个接口的抽象类，可以不实现该接口中的抽象方法。
 *
 *   三.抽象类和接口的区别
 *         1.语法层面上的区别
 *             1）抽象类可以提供成员方法的实现细节，而接口中只能存在public abstract 方法；
 *             2）抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是public static final类型的；
 *             3）接口中不能含有静态代码块以及静态方法，而抽象类可以有静态代码块和静态方法；
 *             4）一个类只能继承一个抽象类，而一个类却可以实现多个接口。
 *         2.设计层面上的区别
 *             1）抽象类是对一种事物的抽象，即对类抽象，
 *                 而接口是对行为的抽象。      抽象类是对整个类整体进行抽象，包括属性、行为，但是接口却是对类局部（行为）进行抽象。
 *                 举个简单的例子:
 *                 飞机和鸟是不同类的事物，但是它们都有一个共性，就是都会飞。
 *                 那么在设计的时候，可以将飞机设计为一个类Airplane，将鸟设计为一个类Bird，但是不能将 飞行 这个特性也设计为类，因此它只是一个行为特性，并不是对一类事物的抽象描述。
 *                 此时可以将 飞行 设计为一个接口Fly，包含方法fly( )，然后Airplane和Bird分别根据自己的需要实现Fly这个接口。
 *                 然后至于有不同种类的飞机，比如战斗机、民用飞机等直接继承Airplane即可，
 *                 对于鸟也是类似的，不同种类的鸟直接继承Bird类即可。
 *                 从这里可以看出，继承是一个 "是不是"的关系，而 接口 实现则是 "有没有"的关系。
 *                 如果一个类继承了某个抽象类，则子类必定是抽象类的种类，而接口实现则是有没有、具备不具备的关系，
 *                 比如鸟是否能飞（或者是否具备飞行这个特点），能飞行则可以实现这个接口，不能飞行就不实现这个接口。
 *             2）设计层面不同，抽象类作为很多子类的父类，它是一种模板式设计。
 *                             而接口是一种行为规范，它是一种辐射式设计。
 *                 什么是模板式设计？最简单例子，大家都用过ppt里面的模板,如果用模板A设计了ppt B和ppt C,
 *                                              ppt B和ppt C公共的部分就是模板A了.
 *                                   如果它们的公共部分需要改动，则只需要改动模板A就可以了，不需要重新对ppt B和ppt C进行改动。
 *                 而辐射式设计，比如某个电梯都装了某种报警器，一旦要更新报警器，就必须全部更新。
 *                              也就是说对于抽象类，如果需要添加新的方法，可以直接在抽象类中添加具体的实现，子类可以不进行变更；
 *                              而对于接口则不行，如果接口进行了变更，则所有实现这个接口的类都必须进行相应的改动。
 *           下面看一个网上流传最广泛的例子：门和警报的例子：门都有open( )和close( )两个动作，此时我们可以定义通过抽象类和接口来定义这个抽象概念：
 *             abstract class Door {
 *                public abstract void open();
 *                public abstract void close();
 *             }
 *            或者：
 *            interface Door {
 *                public abstract void open();
 *                public abstract void close();
 *            }
 *          但是现在如果我们需要门具有报警alarm( )的功能，那么该如何实现？下面提供两种思路：
 *             1）将这三个功能都放在抽象类里面，但是这样一来所有继承于这个抽象类的子类都具备了报警功能，但是有的门并不一定具备报警功能；
 *             2）将这三个功能都放在接口里面，需要用到报警功能的类就需要实现这个接口中的open( )和close( )，也许这个类根本就不具备open( )和close( )这两个功能，比如火灾报警器。
 *                 从这里可以看出， Door的open() 、close()和alarm()根本就属于两个不同范畴内的行为，open()和close()属于门本身固有的行为特性，而alarm()属于延伸的附加行为。
 *             因此最好的解决办法是单独将报警设计为一个接口，包含alarm()行为,Door设计为单独的一个抽象类，包含open和close两种行为。再设计一个报警门继承Door类和实现Alarm接口。
 *            interface Alram {
 *              void alarm();
 *            }
 *
 *           abstract class Door {
 *             void open();
 *             void close();
 *           }
 *
 *           class AlarmDoor extends Door implements Alarm {
 *               void oepn() {
 *                  //....
 *               }
 *               void close() {
 *                 //....
 *               }
 *              void alarm() {
 *                //....
 *              }
 *           }
 */
public class ConceptDif {
}
