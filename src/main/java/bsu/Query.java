package bsu;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

    public class Query {
        private final List<Casino> casinos;

        public Query(List<Casino> casinos) {
            this.casinos = casinos;
        }

        public int rateValueOfTheCity(String city) {
            return casinos
                    .stream()
                    .filter(p -> p.getCity().equalsIgnoreCase(city))
                    .reduce(0, (x, y) -> x + y.getRateValue(),
                            Integer::sum);
        }

        public void searchName(String NAME) {
            casinos
                    .stream().parallel()
                    .filter(p -> p.getName().equals(NAME)).findAny()
                    .ifPresent(System.out::println);
        }

        public void casinoTopRateValue() {
            casinos
                    .stream()
                    .collect(Collectors.toMap(Casino::getName, Casino::getRateValue))
                    .entrySet().forEach(System.out::println);
        }

        public void TopRateValue(int y) {
            casinos
                    .stream()
                    .filter(c -> c.getRateValue() > y)
                    .map(c -> "Name: " + c.getName() + " - " + c.getRateValue() + " wins")
                    .forEach(System.out::println);
        }
    }

