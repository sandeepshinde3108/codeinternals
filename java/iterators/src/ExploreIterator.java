import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator helps in iterating items in a collection
 */
public final class ExploreIterator {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);

        Iterator<Integer> numIterator = numList.iterator();
        //hasNext() -> checks if there's a next element in the list
        while(numIterator.hasNext()){
            //next() -> gets the next element
            System.out.println(numIterator.next());
        }
    }
}
