package ru.alex.project.lesson18;

public interface IPay {
    boolean makePayment(double amount);

    default IPay additionalPay(IPay next){
       return amount -> {
           if(!makePayment(amount)) return next.makePayment(amount);
           return true;
       };
    }
}
