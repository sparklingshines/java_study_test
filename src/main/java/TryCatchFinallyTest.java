
class Number{
    public int num = 10;

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}

public class TryCatchFinallyTest {

    public static Integer test1() {
        int num = 10;
        try {
            System.out.println("try");
            return num += 80;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (num > 20) {
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
        }
        return num;
    }

    public static Integer test2() {
        int num = 10;
        try {
            System.out.println("try");
            return num += 90;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (num > 20) {
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
            num = 110;
        }
        return num;
    }

    public static Integer test3() {
        int num = 10;
        try {
            System.out.println("try");
            return num += 100;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (num > 20) {
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
            num = 120;
            return num;
        }
    }

    public static Number test4(){
        Number number = new Number();
        try{
            System.out.println("try");
            return number;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (number.num > 20){
                System.out.println("number.num>20 : " + number.num);
            }
            System.out.println("finally");
            number.num = 100;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(TryCatchFinallyTest.test1());
        System.out.println("-------------------");
        System.out.println(TryCatchFinallyTest.test2());
        System.out.println("-------------------");
        System.out.println(TryCatchFinallyTest.test3());
        System.out.println("-------------------");
        System.out.println(TryCatchFinallyTest.test4());
        System.out.println("-------------------");
    }

}
