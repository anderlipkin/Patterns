package сreational.factorymethod.RegistryFactories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {

    private static List<Factory<? extends Part>> partFactories = new ArrayList<>();

    private static Random random = new Random();

    static {
        partFactories.add(FuelFilter.factory);
        partFactories.add(AirFilter.factory);
        partFactories.add(CabinAirFilter.factory);
        partFactories.add(OilFilter.factory);
        partFactories.add(FanBelt.factory);
        partFactories.add(GeneratorBelt.factory);
    }

    static Part createRandom() {
        int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}

class Filter extends Part {}

class Belt extends Part {};

class FuelFilter extends Filter {
    static Factory<FuelFilter> factory = () -> new FuelFilter();
}

class AirFilter extends Filter {
    static Factory<AirFilter> factory = () -> new AirFilter();
}

class CabinAirFilter extends Filter {
    static Factory<CabinAirFilter> factory = () -> new CabinAirFilter();
}

class OilFilter extends Filter {
    static Factory<OilFilter> factory = () -> new OilFilter();
}

class FanBelt extends Belt {
    static Factory<FanBelt> factory = () -> new FanBelt();
}

class GeneratorBelt extends Belt {
    static Factory<GeneratorBelt> factory = () -> new GeneratorBelt();
}


