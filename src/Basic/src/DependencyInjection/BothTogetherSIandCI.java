package Basic.src.DependencyInjection;

/*
* ✅ Using Both Constructor and Setter Injection Together in Java for different variable
Using both constructor injection and setter injection in the same class is useful in cases where:

Mandatory dependencies are injected via constructor injection.
Optional or changeable dependencies are injected via setter injection.

* 📌 Example: Laptop with a Processor and Optional Graphics Card
A Laptop requires a Processor (mandatory → constructor injection).
A GraphicsCard is optional (can be upgraded later → setter injection).

* */

// Processor Interface (Mandatory Dependency)
interface PRocessor {
    void process();
}

// GraphicsCard Interface (Optional Dependency)
interface GraphicsCard {
    void render();
}

// Intel Processor
class IntelProcessor implements PRocessor {
    @Override
    public void process() {
        System.out.println("Using Intel Processor for fast performance!");
    }
}

// AMD Processor
class AMDProcessor implements PRocessor {
    @Override
    public void process() {
        System.out.println("Using AMD Processor for gaming performance!");
    }
}

// NVIDIA Graphics Card
class NvidiaGraphics implements GraphicsCard {
    @Override
    public void render() {
        System.out.println("Rendering with NVIDIA Graphics Card.");
    }
}

// AMD Graphics Card
class AMDGraphics implements GraphicsCard {
    @Override
    public void render() {
        System.out.println("Rendering with AMD Graphics Card.");
    }
}

// Laptop Class using Constructor and Setter Injection
class Laptop {
    private PRocessor processor;  // Mandatory (Constructor Injection)
    private GraphicsCard graphicsCard; // Optional (Setter Injection)

    // Constructor Injection for Processor (Mandatory)
    public Laptop(PRocessor processor) {
        this.processor = processor;
    }

    // Setter Injection for Graphics Card (Optional)
    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    void start() {
        processor.process();
        if (graphicsCard != null) {
            graphicsCard.render();
        } else {
            System.out.println("No dedicated Graphics Card installed.");
        }
        System.out.println("Laptop is starting...");
    }

}

public class BothTogetherSIandCI {
    public static void main(String[] args) {
        //Injecting mandatory dependency (Processor)
        PRocessor intelProcessor = new IntelProcessor();
        Laptop myLaptop = new Laptop(intelProcessor);

        // Running without Graphics Card (Setter Injection not used)
        myLaptop.start();

        System.out.println("----------------------");

        // Injecting an optional dependency (Graphics Card)
        GraphicsCard nvidiaGraphics = new NvidiaGraphics();
        myLaptop.setGraphicsCard(nvidiaGraphics);

        // Running with Graphics Card
        myLaptop.start();
    }
}
//Output
/*
* Using Intel Processor for fast performance!
No dedicated Graphics Card installed.
Laptop is starting...
----------------------
Using Intel Processor for fast performance!
Rendering with NVIDIA Graphics Card.
Laptop is starting...

* */


/*
* ✅ When to Use Both Together?
If some dependencies are required at object creation (like Processor in a Laptop).
If some dependencies can be changed later (like adding a GraphicsCard after buying a laptop).
* */