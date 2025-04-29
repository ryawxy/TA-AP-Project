package model;

public abstract class Movable {
   private double currentT = 0;

   public double getCurrentT() {
      return currentT;
   }

   public void setCurrentT(double t) {
      this.currentT = t;
   }

   public abstract void move(int x, int y);
}
