
class A {
    private String name ="This is A";

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public A(){
        show();
        print();
    }

    public void show(){
        System.out.println(name);
    }

    public void print(){
        System.out.println(name);
    }
}

class B extends A {
    private String name ="This is B";

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public B(){
        show();
        print();
    }

    public void show(){
        System.out.println(name);
    }

    public void print(){
        System.out.println(name);
    }
}

class Parent {
    public String normalStr = "Normal member of parent.";
    public static String staticStr = "Static member of parent.";
    private String name = "父亲";

    public void normalMethod(){
        System.out.println("Normal method of parent.");
    }

    public static void staticMethod(){
        System.out.println("Static method of parent.");
    }

    public void sayHello(){
        System.out.println("Hello from " + name);
    }
}

class Child extends Parent {
    public String normalStr = "Normal member of child.";
    public static String staticStr = "Static member of child.";
    private String name = "儿子";

    public void normalMethod(){
        System.out.println("Normal method of child.");
    }

    public static void staticMethod(){
        System.out.println("Static method of child.");
    }

}

/**
 对于非静态的属性和方法
 对于非静态属性，子类可以继承父类的非静态属性。但是当子类和父类有相同的非静态属性时，并没有重写并覆盖父类的非静态属性，只是隐藏了父类的非静态属性。
 对于非静态的方法，子类可以继承父类的非静态方法并可以重写覆盖父类的非静态属性方法。
 对于静态的属性和方法

 对于静态的属性，子类可以继承父类的静态属性。但是和非静态的属性一样，会被隐藏。
 对于静态的方法，子类可以继承父类的静态方法。但是子类不可重写覆盖父类的静态方法，子类的同名静态方法会隐藏父类的静态方法。
 */
public class Test {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getName());
        B b = new B();
        System.out.println(b.getName());
        System.out.println(((A)b).getName());
        A c = new B();
        System.out.println(c.getName());

        System.out.println("-------------------------------------------------");

        Child child = new Child();
        System.out.println(child.normalStr);
        System.out.println(Child.staticStr);
        child.normalMethod();
        Child.staticMethod();
        child.sayHello();

        System.out.println("-------------------------------------------------");

        Parent child1 = new Child();
        System.out.println(child1.normalStr);
        System.out.println(Parent.staticStr);
        child1.normalMethod();
        Parent.staticMethod();
        child1.sayHello();

    }
}
