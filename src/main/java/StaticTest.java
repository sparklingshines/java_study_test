class Print {
    public Print(String s){
        System.out.print(s + " ");
    }
}

class StaticParent{

    public static Print obj1 = new Print("1");
    public Print obj2 = new Print("2");
    public static Print obj3 = new Print("3");

    // 构造代码块
    {
        new Print("9");
    }

    static{
        new Print("4");
    }

    public static Print obj4 = new Print("5");
    public Print obj5 = new Print("6");

    {
        new Print("8");
    }

    public StaticParent(){
        new Print("7");
    }

}

class StaticChild extends Parent{

    static{
        new Print("a");
    }

    {
        new Print("g");
    }

    public static Print obj1 = new Print("b");
    public Print obj2 = new Print("c");

    private StaticParent parent;

    public StaticChild (){
        new Print("d");
        parent = new StaticParent();
    }

    public static Print obj3 = new Print("e");

    public Print obj4 = new Print("f");

    {
        new Print("h");
    }

    public static void main(String [] args){
        Parent obj1 = new Child ();
        Parent obj2 = new Child ();
    }
}


/**
 1、先执行父类的静态代码块和静态变量初始化，并且静态代码块和静态变量的执行顺序只跟代码中出现的顺序有关。
 2、执行子类的静态代码块和静态变量初始化。
 3、执行父类的实例变量初始化和构造代码块，并且实例变量和构造代码块的执行顺序只跟代码中出现顺序有关。
 4、执行父类的构造函数
 5、执行子类的实例变量初始化和构造代码块，并且实例变量和构造代码块的执行顺序只跟代码中出现顺序有关。
 6、执行子类的构造函数
 7.静态代码块和静态变量再JAVA整个生命周期中只加载一次，实例变量和构造代码块再每次new时都执行一次。
 */
public class StaticTest {

    public static void main(String[] args) {
        new StaticTest();                         //4.第四步，new一个类，但在new之前要处理匿名代码块
        System.out.println("------------------------------");
        StaticParent parent = new StaticParent();
        System.out.println();
        System.out.println("------------------------------");
        StaticParent parent1 = new StaticParent();
        System.out.println();
        System.out.println("------------------------------");
        StaticChild child = new StaticChild();
        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
        StaticChild child1 = new StaticChild();
        System.out.println();
    }

    static int num = 4;                    //2.第二步，静态变量和静态代码块的加载顺序由编写先后决定
    int a = 5;                             //6.第六步，按照顺序加载变量


    {
        num += 3;
        System.out.println("b");           //5.第五步，按照顺序加载匿名代码块，代码块中有打印
    }

    { // 成员变量第三个
        System.out.println("c");           //7.第七步，按照顺序打印c
    }

    static {                              // 3.第三步，静态块，然后执行静态代码块，因为有输出，故打印a
        System.out.println("a");
    }

    StaticTest() { // 类的构造函数，第四个加载
        System.out.println("d");           //8.第八步，最后加载构造函数，完成对象的建立
    }

    static void run()                    // 静态方法，调用的时候才加载// 注意看，e没有加载
    {
        System.out.println("e");
    }
}
