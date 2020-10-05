import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyListImplementationTest {

    @BeforeEach
    void init(){
    }

    @Test
    void testIsEmpty() {
        MyListImplementation list =  new MyListImplementation<Integer>();
        assertThat(list.isEmpty()).isEqualTo(true);
    }

    @Test
    void testAdd() {
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add(1);
        list.add(2);
        assertThat(list.isEmpty()).isEqualTo(false);
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void testContains() {
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add(1);
        list.add(2);
        assertThat(list.contains(1)).isEqualTo(true);
        assertThat(list.contains(3)).isEqualTo(false);
    }

    @Test
    void testRemove() {
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add("A");
        list.add("B");
        assertThat(list.remove("C")).isEqualTo(false);
        list.remove("B");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void testContainsAll(){
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertThat(list.containsAll(List.of("A", "B"))).isEqualTo(true);
        assertThat(list.containsAll(List.of("A", "D"))).isEqualTo(false);
    }

    @Test
    void testAddAll(){
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.addAll(List.of("A", "B"));
        assertThat(list.containsAll(List.of("A", "B"))).isEqualTo(true);
        assertThat(list.containsAll(List.of("A", "D"))).isEqualTo(false);
    }

    @Test
    void testRemoveAll(){
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.addAll(List.of("A", "B"));
        assertThat(list.removeAll(List.of("A"))).isEqualTo(true);
        assertThat(list.removeAll(List.of("D"))).isEqualTo(false);
    }

    @Test
    void testGet(){
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add("A");
        list.add("B");
        list.add("C");

        assertThat(list.get(0)).isEqualTo("A");
        assertThat(list.get(2)).isEqualTo("C");
    }

    @Test
    void testSet(){
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.set(0, "C");
        assertThat(list.get(0)).isEqualTo("C");
    }

    @Test
    void testIndexOf(){
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add("A");
        list.add("B");
        list.add("C");

        assertThat(list.indexOf("C")).isEqualTo(2);
        assertThat(list.indexOf("D")).isEqualTo(-1);
    }

    @Test
    void testAddByIndex(){
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add("A");
        list.add("B");
        list.add(1, "C");

        assertThat(list.get(1)).isEqualTo("C");
        assertThat(list.get(2)).isEqualTo("B");
    }

    @Test
    void testRemoveByIndex(){
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add("A");
        list.add("B");
        list.remove(1);

        assertThat(list.get(0)).isEqualTo("A");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void testAddAllByIndex(){
        MyListImplementation list =  new MyListImplementation<Integer>();
        list.add("A");
        list.add("B");
        list.addAll(1, List.of("C", "D"));

        assertThat(list.get(1)).isEqualTo("C");
        assertThat(list.get(2)).isEqualTo("D");
        assertThat(list.get(3)).isEqualTo("B");
    }


}
