public class CheckClass {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Vaska";
        Room room = new Room();

        room.add(cat);
        room.print();
        System.out.println("---------");
        Cat cat2 = new Cat();
        cat2.name = "Murzik";
        room.add(cat2);
        room.print();
        System.out.println("---------");
        room.add(new Cat("Barsik", 3, "black"));
        room.print();


//        Cat myCat = new Cat();
//        myCat.name = "Vaska";
//        myCat.age = 15;
//
//        myCat.color = "green";
//        Cat myCat2 = new Cat("Murzik", 7, "red");
//
//        System.out.println(myCat.meow("korm"));
//        myCat.meow();
//
//        int[] numbers = {1, 456, 6587, 334, 98, 5464, 456};
//        int[] numbers2 = new int[7];
//        Cat[] cats = {new Cat(), new Cat(), new Cat(), myCat, myCat2};
//
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] > 600 || numbers[i] < 300) {
//                System.out.println(numbers[i]);
//            }
//            if (numbers[i] <= 600 ) {
//                if (numbers[i] > 400) {
//                    continue;
//                } else {
//                    System.out.println("QQQ");
//                }
//            } else if (numbers[i] > 6000) {
//                System.out.println("Hello, Kitty!");
//            } else {
//                System.out.println("Hello, Hillel!");
//            }
//            System.out.println(numbers[i]);
//            break;
//        }
//        System.out.println("AAA");
//        System.out.println(111);
//        System.out.println(true);
    }
}
