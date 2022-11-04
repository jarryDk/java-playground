package dk.jarry.playground;

import java.util.ArrayList;
import java.util.List;

public class _6_SwitchPatternMatching {

  sealed interface Fruit permits Apple, Orange, Pear {}
  record Apple(Integer weight) implements Fruit{}
  record Orange(Integer weight) implements Fruit{}
  record Pear(Integer weight) implements Fruit{}

  public static void main(String[] args) throws InterruptedException {

    List<Fruit> fruitBasket = new ArrayList<>();
    fruitBasket.add(new Apple(506));
    fruitBasket.add(new Orange(400));
    fruitBasket.add(new Orange(800));
    fruitBasket.add(new Pear(716));

    fruitBasket.forEach(fruit ->{

      switch (fruit){
        case Apple a -> System.out.println("Apple -- " + a.toString());
        case Orange o when o.weight() < 500  -> System.out.println("Orange - small");
        case Orange o -> System.out.println("Orange");
        case Pear  p -> System.out.println("Apple");
      }

    });

  }

}
