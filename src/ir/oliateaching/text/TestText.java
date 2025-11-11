package ir.oliateaching.text;

public class TestText {
    static void main() {
        Text text1 = new Text(new char[]{'H', 'e', 'l', 'l', 'o' ,' ', 'W', 'o', 'r', 'l', 'd'});
        Text text2 = new Text(new char[]{' ', 'm', 'y', ' ', 'n', 'a' , 'm', 'e', ' ', 'i', 's', ' ' , 'O' , 'l' , 'i' , 'a'});
        Text text3 = new Text("javad");

        System.out.print("text1: ");
        text1.print();

        System.out.print("text2: ");
        text2.print();

        System.out.print("text3: ");
        text3.print();

        // concat
        text1.concat(text2);
        System.out.print("After concat Text1 and Text2: ");
        text1.print();

        // indexOf
        System.out.println("Index of 'o': " + text1.indexOf('o'));
        System.out.println("Index of 'z': " + text1.indexOf('z'));

        // replace
        Text oldText = new Text(new char[]{'W', 'o', 'r', 'l', 'd'});
        Text newText = new Text(new char[]{'J', 'a', 'v', 'a' , 'd'});
        text1.replace(oldText, newText);
        System.out.print("After replace 'World' with 'Javad': ");
        text1.print();

        // equals
        System.out.println("text1 equals text3: " + text1.equals(text3));

        // contains
        Text searchText = new Text(new char[]{'J', 'a', 'v', 'a' , 'd'});
        System.out.println("Contains 'Javad': " + text1.contains(searchText));
    }
}