public class Room {
    String name;
    Cat[] cats = new Cat[0];

    void add(Cat cat) {
        Cat[] temp = new Cat[this.cats.length + 1];
        for (int i = 0; i < this.cats.length; i++) {
            temp[i] = this.cats[i];
        }
        temp[temp.length - 1] = cat;
        cats = temp;
    }

    void print() {
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].name);
        }
    }
}
