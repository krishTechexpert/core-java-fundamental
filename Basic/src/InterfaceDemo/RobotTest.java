package InterfaceDemo;
/*
* What is an Interface?
An interface is like a TV remote.
* It tells you what buttons you can press (like power, volume up, volume down),
* but it does not tell you how the TV works inside.

When you press the "power" button, it works on all TVs,
* no matter if it's a Samsung, Sony, or LG TV. The button is the same,
*  but inside, each TV works in its own way.

* Why Do We Need an Interface?
Imagine you have a toy robot 🤖 that can talk and walk.

Without Interface (Problem)
If we make a robot without an interface,
* we may need to create a separate class for each type of robot.
* That means we cannot easily change or add new types of robots.

* class TalkingRobot {
    void talk() {
        System.out.println("Hello, I can talk!");
    }
}

class WalkingRobot {
    void walk() {
        System.out.println("I am walking!");
    }
}

* ⛔ Problem: What if we want a robot that can both talk and walk?
*  We have to change the whole code! 😢

* With Interface (Solution)


* */

// Interface for talking robots
interface Talkable {
    void talk();
}

// Interface for walking robots
interface Walkable {
    void walk();
}

// A robot that can talk
class TalkingRobot implements Talkable {
    @Override
    public void talk() {
        System.out.println("Hello, I can talk!");
    }
}

// A robot that can walk
class WalkingRobot implements Walkable {
    @Override
    public void walk() {
        System.out.println("I am walking!");
    }
}

// A robot that can talk AND walk!
class SmartRobot implements Talkable, Walkable {
    @Override
    public void talk() {
        System.out.println("Hi! I am a smart robot, and I can talk!");
    }

    @Override
    public void walk() {
        System.out.println("I am also walking!");
    }
}

public class RobotTest {
    public static void main(String[] args) {
        Talkable tRobot = new TalkingRobot();
        tRobot.talk(); // Only talks

        Walkable wRobot = new WalkingRobot();
        wRobot.walk(); // Only walks

        // SmartRobot can do both!
        SmartRobot smartRobot = new SmartRobot();
        smartRobot.talk();
        smartRobot.walk();
    }
}

/*
* Why Is This Better?
✅ Easy to Add New Robots → If we want a flying robot 🛸, we can just create
* a Flyable interface and implement it.
✅ Flexible → We can mix and match abilities (Talking, Walking, Flying, etc.).
✅ No Need to Change Old Code → We don’t have to change RobotTest if we add a new robot.

Final Simple Explanation 🧒
Think of an interface like rules for a game.

A Football Player follows football rules. ⚽
A Basketball Player follows basketball rules. 🏀
A Super Athlete can follow both rules and play both sports!
An interface tells the rules, but each player (or class) plays in its own way.

So, we need an interface to make our code flexible, easy to change, and reusable! 🎉🚀

* If you still not understand then go to Think About a Mobile Phone Charger 📱🔌
see MobileInterfaceRealWorldExample.java file..
* */