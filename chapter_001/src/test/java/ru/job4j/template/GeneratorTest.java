package ru.job4j.template;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void whenInputPatternWithKeysThanGenerateExpected() {
        Map<String, Object> map = new HashMap<>();
        Generator generator = new GeneratorMap();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        try {
            String res = generator
                    .produce("I am a ${name}, Who are ${subject}? ", map);
            assertTrue(res.equals("I am a Petr Arsentev, Who are you? "));
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test()
    public void whenExtraKeysInMapThanException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Map has extra key for input template");
        Map<String, Object> map = new HashMap<>();
        Generator generator = new GeneratorMap();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        map.put("profession", "mentor");
        String res = generator
                .produce("I am a ${name}, Who are ${subject}? ", map);
    }

    @Test
    public void whenInputPatternHasKeyThatAbsentInMapThanException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Map has't key for input template");
        Map<String, Object> map = new HashMap<>();
        Generator generator = new GeneratorMap();
        map.put("name", "Petr Arsentev");
        String res = generator
                .produce("I am a ${name}, Who are ${subject}? ", map);
    }
}
