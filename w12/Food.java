package delicacy;

import util.Chain;

public abstract class Food implements Dish {
   private final double price;
   private final String name;
   @Override
   public double getPrice() { return price; }
   @Override
   public Chain<String>getIngredients() { return Chain.getInstance(name); }
   public Food(double price, String name) {
      if (price < 0 || name == null) throw new IllegalArgumentException();
      this.price = price;
      this.name = name;
   }
}
