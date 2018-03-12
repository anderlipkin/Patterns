package сreational.factorymethod.RegistryFactories;

public class FactoryMethodRegistry {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
