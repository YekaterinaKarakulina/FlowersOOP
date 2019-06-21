package task_flowers.InterfaceWithImplimentations;

import task_flowers.Exceptions.EmptyBasketException;

public interface Soldable {

    public void printCheck()throws EmptyBasketException;

    double getPrice();

}
