public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> li = new LinkedList<>();
        li.append(5);
        li.append(4);
        li.remove(0);
        System.out.println(li);
        System.out.println(li.getSize());
        System.out.println(li.getTail());

    }
}
