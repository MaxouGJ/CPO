public class Exercice6 {
    public static void main(String[]args){
//        System.out.println((int)true); Compilation
        System.out.println((int)'a');
        System.out.println((byte)'a');
        System.out.println((byte)257);
        System.out.println((char)98);
        System.out.println((double)98);
        System.out.println((char)98.12);
        System.out.println((long)98.12);
//        System.out.println((boolean)98.); Compilation on ne peut pas convertir des booléens
//        System.out.println((B)new A()); Exécution
//        System.out.println((C) new B()); Compiltion
        System.out.println((A) new C());
        
    }
}

class A{ }

class B extends A { }

class C extends A { }
