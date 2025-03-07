package org.example;

//2️⃣ Implement a Concrete Car Class (CarImpl.java)

public class CarImpl extends Car {
    @Override
    protected Engine getEngine() {
        return null; // Spring will override this method dynamically
    }

}

// This class extends Car, but Spring will replace the getEngine() implementation
//with a method that fetches a new prototype bean each time.

