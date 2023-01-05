package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@Slf4j
public class Main {

        public static void main(String[] args) {
                
                //zmienna z nakładki slf4j
//                private static final Logger log = LoggerFactory.getLogger(Main.class);

                log.info("Hello text {} another text {}",123, "sth");
                log.warn("warn msg");
                log.info("info msg");
                log.debug("debug msg");
                System.out.println("Hello world!");
                log.trace("trace msg");
                
                //mapa z przykładami logów
                final Map<Integer, Consumer<Integer>> ACTIONS =
                        Map.of(
                                0, key -> log.debug("debug {}", key),
                                1, key -> log.info("info {}", key),
                                2, key -> log.warn("warn {}", key),
                                3, key -> log.error("error {}", key)
                        );
                        //funkcja wypisująca przykąłdy z mapy
                log(ACTIONS);
        
        
        
                // metoda rzucająca wyjątek i wypisanie go w postaci stackrace
//                try {
//                        method1();
//                } catch (Exception e){
//                        //wydrukuje cały stacktrace
//                        log.error("Exception was thrown: {}", e);
//                }

        }
        
        private static void log(Map<Integer, Consumer<Integer>> ACTIONS) {
                
                
                IntStream.rangeClosed(0, 1000)
                        .map(i-> i % 4)
                        .forEach(key-> Optional.ofNullable(ACTIONS.get(key))
                                               .orElseThrow(() ->new RuntimeException("case not hadled"))
                                               .accept(key)     );
                
                
        }
        
        private static void method1() {
                method1();
        }
}