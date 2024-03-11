import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator is used to do forward and backward traversals
 */
public final class ExploreListIterator {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);

        ListIterator<Integer> numIterator = numList.listIterator();
        System.out.println("-----------Forward traversal-------------------");
        //This is to do forward traversal
        while(numIterator.hasNext()){
            System.out.println(numIterator.next());
        }

        System.out.println("-----------Reverse traversal-------------------");
        //This is to do reverse traversal
        while(numIterator.hasPrevious()){
            System.out.println(numIterator.previous());
        }
    }
}
