
package InterfaceDemo;

/*
* Think About a Mobile Phone Charger 📱🔌
Problem Without an Interface
Imagine you have different phones:

Samsung Phone
iPhone
OnePlus Phone
Each phone needs charging, but what if each phone had its own unique charger
* that only works for that phone?

That would be a big problem! If you switch phones, you need a new charger every time.


* */

/*
* How Does This Relate to Java?
An interface in Java is like this universal charger!
* It defines a rule that different classes (phones) must follow,
* but each class (phone) can implement it in its own way.

Example in Java:
Without Interface (Bad Approach)
// Separate chargers for each phone (problematic!)
class SamsungCharger {
    void chargeSamsung() {
        System.out.println("Charging Samsung Phone...");
    }
}

class iPhoneCharger {
    void chargeiPhone() {
        System.out.println("Charging iPhone...");
    }
}
⛔ Problem: If you buy a new phone, you need a new charger class!
* The code is not flexible. 😢

With Interface (Good Approach - Universal Charger)
* */









// Interface (Universal Charger)
interface Charger {
    void charge(); // All chargers must have this method
}
// Samsung Charger
class SamsungCharger implements Charger {
    @Override
    public void charge() {
        System.out.println("Charging Samsung Phone...");
    }
}

// iPhone Charger
class iPhoneCharger implements Charger {
    @Override
    public void charge() {
        System.out.println("Charging iPhone...");
    }
}

// OnePlus Charger
class OnePlusCharger implements Charger {
    @Override
    public void charge() {
        System.out.println("Charging OnePlus Phone...");
    }
}

// ✅ NEW Charger: Google Pixel Charger
class GooglePixelCharger implements Charger {
    @Override
    public void charge() {
        System.out.println("Charging Google Pixel Phone...");
    }
}

public class MobileInterfaceRealWorldExample {
    public static void main(String[] args) {
        // ✅ Easily swap chargers without modifying ChargingStation class
        Charger myCharger; // One charger variable (like one cable)
        // Now, we swap different chargers easily
        myCharger = new SamsungCharger();
        myCharger.charge(); // Charging Samsung

        myCharger = new iPhoneCharger();
        myCharger.charge(); // Charging iPhone

        myCharger = new OnePlusCharger();
        myCharger.charge(); // Charging OnePlus

        myCharger = new GooglePixelCharger(); // ✅ Added new charger without changing old code
        myCharger.charge(); // Charging Google Pixel

    }
}

/**
 * Think About a Real-Life Example 🔌
 * Imagine you have one charging cable that works with different adapters:
 *
 * Samsung Adapter
 * iPhone Adapter
 * OnePlus Adapter
 * Google Pixel Adapter
 * You don’t need to buy a new cable every time you switch phones.
 * You just change the adapter and plug it into the same cable!
 *
 * */

/*
* Why Is This Useful?
Imagine you had to write separate code for each phone charger instead of just swapping
* myCharger.
You would repeat a lot of code and make it harder to manage.
With an interface (Charger), we only need one variable and just change the
* object it refers to.

* */

/*
* Final Simple Explanation 🚀
A TV remote can control different TVs (Samsung, Sony, LG).
You don’t need a new remote for every TV; you just pair it with a different TV.
Similarly, in Java, we don’t need to change the main code. We just change the
* charger object (myCharger = new XYZCharger();), and it works! 🎉
Now
* */